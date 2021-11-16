(function() {
	let content = document.body.querySelector(".content"),
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

	function naviClickEventHanlder(e) {
		if(e.target.tagName == "LI") {
			window.scrollTo({top : position.info[e.target.getAttribute("data-target")] - floatingNavi.clientHeight, behavior:'smooth'});
		}
	}

	window.addEventListener("DOMContentLoaded", init);
})();
