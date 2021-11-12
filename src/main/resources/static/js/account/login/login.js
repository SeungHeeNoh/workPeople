
(function() {
	let cookie = window.common.cookie;

	let login = document.querySelector(".login_area"),
		typeChangeTabs = login.querySelectorAll(".type_change_tab > li"),
		loginForm = login.querySelector("form"),
		rememberIdCheckbox = loginForm.querySelector("#remember_id"),
		idInput = loginForm.querySelector("input[name='id']"),
		passwordIntput = loginForm.querySelector("input[name='password']"),
		memberTypeInput = loginForm.querySelector("input[name='member_type']");

	function init() {
		viewInit();
		login.addEventListener("click", loginClickEventHandler);
	}

	function viewInit() {
		let cookieId = cookie.getCookie("rememberId");

		if(cookieId.length > 0) {
			idInput.value = cookieId;
			rememberIdCheckbox.setAttribute("checked", true);
		}
	}

	function loginClickEventHandler(e) {
		if(e.target.tagName == "BUTTON") {
			loginButtonClickEventHandler();
		} else if(e.target.tagName == "LI") {
			changeTab(e.target)
		}
	}

	function loginButtonClickEventHandler() {
		let flag = true;

		if(idInput.value.length == 0) {
			alert("아이디를 입력하세요.");
			flag = false;
		} else if(idInput.value.length < 4) {
			alert("아이디는 4자 이상이어야 합니다.");
			flag = false;
		} else if(passwordIntput.value.length == 0) {
			alert("비밀번호를 입력하세요.");
			flag = false;
		} else if(passwordIntput.value.length < 8) {
			alert("비밀번호는 8자 이상이어야 합니다.");
			flag=false;
		}

		if(flag) {
			if(rememberIdCheckbox.checked) {
				cookie.setCookie("rememberId", idInput.value, 7);
			} else {
				cookie.deleteCookie("rememberId");
			}
			loginForm.submit();
		}
	}

	function changeTab(activeTab) {
		typeChangeTabs.forEach(function(item, index) {
			item.classList.remove("active");
		});

		activeTab.classList.add("active");
		memberTypeInput.value = activeTab.getAttribute("data-member-type");
	}

	window.addEventListener("DOMContentLoaded", init);	
})();
