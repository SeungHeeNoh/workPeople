(function() {
	let token = document.querySelector("meta[name='_csrf']").getAttribute("content"),
		tokenHeader = document.querySelector("meta[name='_csrf_header']").getAttribute("content");

	let body = document.body,
		content = body.querySelector(".content"),
		dimmed = body.querySelector(".dimmed"),
		modal = dimmed.querySelector("#modal"),
		headerWrap = content.querySelector(".job_vacancy_header_wrap");

	let fixedPoint = window.pageYOffset + headerWrap.getBoundingClientRect().bottom;

	function debounce(func) {
		let timer;

		return function(e) {
			if(timer) clearTimeout(timer);
			timer = setTimeout(func, 100, e);
		}
	}

	function init() {
		window.addEventListener("scroll", scrollEventHandler);
		window.addEventListener("resize", debounce(resizeEventHandler));
		content.addEventListener("click", contentClickEventHandler);
		modal.addEventListener("click", modalClickEventHandler);
	}

	function scrollEventHandler() {
		let scrollTop = document.documentElement.scrollTop;

		if(scrollTop >= fixedPoint) {
			headerWrap.classList.add("fixed");
		} else {
			headerWrap.classList.remove("fixed");
		}
	}

	function resizeEventHandler() {
		fixedPoint = window.pageYOffset + headerWrap.getBoundingClientRect().bottom;
	}

	function contentClickEventHandler(e) {
		if(e.target.tagName == "BUTTON") {
			if(e.target.classList.contains("login_button")) {
				openMoadl();
			} else {
				let button = e.target;

				if(button.classList.contains("like_button")) {
					companyLikeButtonToggleEventHandler(button);
				}else if(button.classList.contains("scrap_button")) {
					scrapButtonToggleEventHanlder(button);
				} else if(button.classList.contains("apply_button")) {
					applyButtonClickEventHandler();
				} else if(button.classList.contains("report_button")) {
					reportButtonClickEventHandler(button);
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
					} else {
						console.log("ajax 통신 실패");
					}
					button.removeAttribute("disabled");
				}
			}

			xhr.open("DELETE", "/personal/mypage/interestedCompany/company/" + button.getAttribute("data-company-no"));
			xhr.setRequestHeader(tokenHeader, token);
			xhr.send();
		} else {
			xhr.onreadystatechange = function() {
				if(xhr.readyState == 4) {
					if((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
						activeLikeButton(button);
					} else {
						console.log("ajax 통신 실패");
					}
					button.removeAttribute("disabled");
				}
			}

			xhr.open("POST", "/personal/mypage/interestedCompany/company/" + button.getAttribute("data-company-no"));
			xhr.setRequestHeader(tokenHeader, token);
			xhr.send();
		}
	}

	function activeLikeButton(button) {
		button.classList.add("active");
		button.querySelector("span").innerHTML = "해제";
	}

	function deactiveLikeButton(button) {
		button.classList.remove("active");
		button.querySelector("span").innerHTML = "설정";
	}

	function scrapButtonToggleEventHanlder(button) {
		button.setAttribute("disabled", true);
		let xhr = new XMLHttpRequest();

		if(button.classList.contains("active")) {
			xhr.onreadystatechange = function() {
				if(xhr.readyState == 4) {
					if((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
						deactiveScrapButton(button);
					} else {
						console.log("ajax 통신 실패");
					}
					button.removeAttribute("disabled");
				}
			}

			xhr.open("DELETE", "/personal/mypage/scrap/job-vacancy/" + button.getAttribute("data-job-vacancy-no"));
			xhr.setRequestHeader(tokenHeader, token);
			xhr.send();
		} else {
			xhr.onreadystatechange = function() {
				if(xhr.readyState == 4) {
					if((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
						activeScrapButton(button);
					} else {
						console.log("ajax 통신 실패");
					}
					button.removeAttribute("disabled");
				}
			}

			xhr.open("POST", "/personal/mypage/scrap/job-vacancy/" + button.getAttribute("data-job-vacancy-no"));
			xhr.setRequestHeader(tokenHeader, token);
			xhr.send();
		}
	}

	function activeScrapButton(button) {
		button.classList.add("active");
		button.querySelector("span").innerHTML = "해제";
	}

	function deactiveScrapButton(button) {
		button.classList.remove("active");
		button.querySelector("span").innerHTML = "설정";
	}

	function applyButtonClickEventHandler() {
		openMoadl();
	}

	function modalClickEventHandler(e) {
		if(e.target.tagName == "BUTTON" && e.target.classList.contains("close_button")) {
			closeModal();
		}
	}

	function openMoadl() {
		body.classList.add("modal_open");
		dimmed.classList.add("show");
	}

	function closeModal() {
		body.classList.remove("modal_open");
		dimmed.classList.remove("show");
	}

	function reportButtonClickEventHandler(button) {
		if(button.classList.contains("done")) {
			alert("이미 신고된 공고입니다.");
		} else {
			button.setAttribute("disabled", true);

			let xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function() {
				if(xhr.readyState == 4) {
					if((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
						if(xhr.response.message == "success") {
							alert("신고가 완료되었습니다.");
						} else {
							alert("에러로 인해 실패했습니다.")
						}
						button.classList.add("done");
					} else {
						console.log("ajax 통신 실패");
					}
					button.removeAttribute("disabled");
				}
			}

			xhr.open("POST", "/personal/mypage/report/job-vacancy/" + button.getAttribute("data-job-vacancy-no"));
			xhr.setRequestHeader(tokenHeader, token);
			xhr.responseType = "json";
			xhr.send();
		}
	}

	window.addEventListener("DOMContentLoaded", init);	
})();
