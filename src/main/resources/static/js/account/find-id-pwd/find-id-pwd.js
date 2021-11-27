(function() {
	let inputValidate = window.common.validate.input;

	let token = document.querySelector("meta[name='_csrf']").getAttribute("content"),
		header = document.querySelector("meta[name='_csrf_header']").getAttribute("content");

	let content = document.querySelector(".content"),
		form = content.querySelector("form"),
		infoTable = form.querySelector("table"),
		rows = infoTable.querySelectorAll("tr"),
		confirmButton = form.querySelector("button.green");

	let isFindId = content.querySelector("h2").textContent.indexOf("비밀번호") < 0;

	function init() {
		confirmButton.addEventListener("click", confirmButtonClickEventHandler);
	}

	function confirmButtonClickEventHandler() {
		let flag = true;

		for(let i=0; i<rows.length; i++) {
			let row = rows[i],
				label = row.querySelector("label"),
				input = row.querySelector("input");

			if(label.textContent == "아이디") {
				flag = idCheck(input.value);
				if(!flag) break;
			} else if(label.textContent == "이름") {
				flag = nameCheck(input.value, label.textContent);
				if(!flag) break;
			} else if(label.textContent == "이메일") {
				flag = emailCheck(input.value);
				if(!flag) break;
			} else if(label.textContent.indexOf("사업자 등록번호") >= 0) {
				flag = companyRegisterNumberCheck(input.value);
				if(!flag) break;
			}
		}

		if(flag) {
			if(isFindId) {
				findId();
			} else {
				findPwd();
			}
		}
	}

	function idCheck(value) {
		let flag = true,
			result = inputValidate.idCheck(value);

		if(result.length > 0) {
			alert(result);
			flag = false;
		}

		return flag;
	}

	function nameCheck(value) {
		let flag = true,
			result = inputValidate.nameCheck(value);

		if(result.length > 0) {
			alert(result);
			flag = false;
		}

		return flag;
	}

	function emailCheck(value) {
		let flag = true,
			result = inputValidate.emailCheck(value);

		if(result.length > 0) {
			alert(result);
			flag = false;
		}

		return flag;
	}

	function companyRegisterNumberCheck(value) {
		let flag = true,
			result = inputValidate.companyRegisterNumber(value);

		if(result.length > 0) {
			alert(result);
			flag = false;
		}

		return flag;
	}

	function findId() {
		let isRun = false;

		if(isRun) return;
		isRun = true;

		let xhr = new XMLHttpRequest(),
			url = "";
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4) {
				if((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
					if(xhr.response.message) {
						alert(xhr.response.message);
					}
				} else {
					console.log("ajax 통신 실패");
				}
			}
		}

		xhr.open("POST", "/account/find-id-pwd/member/id");
		xhr.setRequestHeader("Content-type", "application/json;")
		xhr.setRequestHeader(header, token);
		xhr.responseType = "json";
		xhr.send(JSON.stringify(serialize(new FormData(form))));
	}

	function serialize(formData) {
		let data = {};

		for(let [key, value] of formData) {
			data[key] = value;
		}

		return data;
	}

	window.addEventListener("DOMContentLoaded", init);	
})();
