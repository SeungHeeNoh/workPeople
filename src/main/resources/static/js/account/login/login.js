
(function() {
	let cookie = window.common.cookie;

	let login = document.querySelector(".login_area"),
		loginForm = login.querySelector("form"),
		rememberIdCheckbox = loginForm.querySelector("#remember_id"),
		idInput = loginForm.querySelector("input[name='id']"),
		passwordIntput = loginForm.querySelector("input[name='password']");

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

	window.addEventListener("DOMContentLoaded", init);	
})();
