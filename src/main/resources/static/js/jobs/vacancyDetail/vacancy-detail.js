(function() {
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

		if(button.classList.contains("active")) {
			deactiveLikeButton(button);
		} else {
			activeLikeButton(button);
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

	function scrapButtonToggleEventHanlder(button) {
		button.setAttribute("disabled", true);

		if(button.classList.contains("active")) {
			deactiveScrapButton(button);
		} else {
			activeScrapButton(button);
		}
		button.removeAttribute("disabled");
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
			alert("신고가 완료되었습니다.");
			button.removeAttribute("disabled");
		}
	}

	window.addEventListener("DOMContentLoaded", init);	
})();
