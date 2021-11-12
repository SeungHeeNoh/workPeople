(function() {
	let login = document.querySelector(".login_area"),
		loginForm = login.querySelector("form"),
		idInput = loginForm.querySelector("input[name='id']"),
		passwordIntput = loginForm.querySelector("input[name='password']"),
		loginButton = loginForm.querySelector("button");

	function init() {
		loginButton.addEventListener("click", loginButtonClickEventHandler);
	}

	function loginButtonClickEventHandler() {
		if(idInput.value.length == 0) {
			alert("아이디를 입력하세요.");
		} else if(idInput.value.length < 4) {
			alert("아이디는 4자 이상이어야 합니다.");
		} else if(passwordIntput.value.length == 0) {
			alert("비밀번호를 입력하세요.");
		} else if(passwordIntput.value.length < 8) {
			alert("비밀번호는 8자 이상이어야 합니다.");
		}
	}

	window.addEventListener("DOMContentLoaded", init);	
})();
