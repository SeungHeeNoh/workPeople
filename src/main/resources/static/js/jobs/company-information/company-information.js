(function() {
	let token = document.querySelector("meta[name='_csrf']").getAttribute("content"),
		tokenHeader = document.querySelector("meta[name='_csrf_header']").getAttribute("content");

	let content = document.body.querySelector(".content"),
		infoHeader = content.querySelector(".info_header"),
		interestedCompanyCount = infoHeader.querySelector(".like_button").querySelector(".count"),
		floatingNaviWrapper = content.querySelector(".floating-navi"),
		floatingNavi = floatingNaviWrapper.querySelector(".floating-navi-inner"),
		naviTabs = floatingNavi.querySelectorAll("li"),
		information = content.querySelector(".information"),
		info = new Array();

	let windowPageYOffset = window.pageYOffset,
		position = {
			floatingNaviWrapper : windowPageYOffset + floatingNaviWrapper.getBoundingClientRect().top,
			info : {}
		},
		positionNameArray = "";

	function debounce(func) {
		let timer;

		return function(e) {
			if(timer) clearTimeout(timer);
			timer = setTimeout(func, 100, e);
		}
	}

	function init() {
		floatingNaviInit();
		window.addEventListener("scroll", scrollEventHandler);
		window.addEventListener("resize", debounce(resizeEventHandler));
		infoHeader.addEventListener("click", infoHeaderClickEventHandler);
		floatingNavi.addEventListener("click", naviClickEventHanlder);
	}

	function floatingNaviInit() {
		positionNameArray = getPositionNameArray();

		positionNameArray.forEach(function(positionName) {
			info.push(information.querySelector("." + positionName));
		});

		setTimeout(function() {
			setInfoPosition();
			scrollEventHandler();
		}, 100);
	}

	function getPositionNameArray() {
		let nameArray = new Array();

		naviTabs.forEach(function(naviTab) {
			nameArray.push(naviTab.getAttribute("data-target"));
		});

		return nameArray;
	}

	function setInfoPosition() {
		info.forEach(function(info) {
			position.info[info.classList[0]] = windowPageYOffset + info.getBoundingClientRect().top;
		});
	}

	function scrollEventHandler() {
		let scrollTop = document.documentElement.scrollTop;

		if(position.floatingNaviWrapper < scrollTop) {
			floatingNavi.classList.add("fixed");

			floatingNaviClear();
			let flag = true;

			for(let i=1; i<naviTabs.length; i++) {
				if(scrollTop < position.info[positionNameArray[i]]-100) {
					naviTabs[i-1].classList.add("active");
					flag = false;
					break;
				}
			}

			if(flag) {
				naviTabs[naviTabs.length-1].classList.add("active");
			}
		} else {
			floatingNavi.classList.remove("fixed");
		}
	}

	function floatingNaviClear() {
		naviTabs.forEach(function(naviTab) {
			naviTab.classList.remove("active");
		});
	}

	function resizeEventHandler() {
		windowPageYOffset = window.pageYOffset;
		position.floatingNaviWrapper = windowPageYOffset + floatingNaviWrapper.getBoundingClientRect().top;
		setInfoPosition();
	}

	function infoHeaderClickEventHandler(e) {
		if(e.target.tagName == "BUTTON") {
			let button = e.target;

			if(button.classList.contains("login_button")) {
				openModal();
			} else {
				if(button.classList.contains("like_button")) {
					companyLikeButtonToggleEventHandler(button);
				}
			} 
		}
	}

	function companyLikeButtonToggleEventHandler(button) {
		button.setAttribute("disabled", true);
		let xhr = new XMLHttpRequest();

		if(button.classList.contains("active")) {
			xhr.onreadystatechange = function() {
				if(xhr.readyState == 4) {
					if((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
						deactiveLikeButton(button);
						if(xhr.response.interestedCompanyCount != null) {
							interestedCompanyCount.innerHTML = xhr.response.interestedCompanyCount;
						}
					} else {
						console.log("ajax 통신 실패");
					}
				}
			}

			xhr.open("DELETE", "/personal/mypage/interestedCompany/company/" + button.getAttribute("data-company-no"));
			xhr.setRequestHeader(tokenHeader, token);
			xhr.responseType = "json";
			xhr.send();
		} else {
			xhr.onreadystatechange = function() {
				if(xhr.readyState == 4) {
					if((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
						activeLikeButton(button);
						if(xhr.response.interestedCompanyCount != null) {
							interestedCompanyCount.innerHTML = xhr.response.interestedCompanyCount;
						}
					} else {
						console.log("ajax 통신 실패");
					}
				}
			}

			xhr.open("POST", "/personal/mypage/interestedCompany/company/" + button.getAttribute("data-company-no"));
			xhr.setRequestHeader(tokenHeader, token);
			xhr.responseType = "json";
			xhr.send();
		}
		button.removeAttribute("disabled");
	}

	function activeLikeButton(button) {
		button.classList.add("active");
		button.querySelector("span").innerHTML = "해제";
	}

	function deactiveLikeButton(button) {
		button.classList.remove("active");
		button.querySelector("span").innerHTML = "설정";
	}

	function naviClickEventHanlder(e) {
		if(e.target.tagName == "LI") {
			window.scrollTo({top : position.info[e.target.getAttribute("data-target")] - floatingNavi.clientHeight, behavior:'smooth'});
		} 
	}

	window.addEventListener("DOMContentLoaded", init);
})();
