(function() {
	let inputValidate = window.common.validate.input;

	let content = document.querySelector(".content"),
		form = content.querySelector("form"),
		infoTable = form.querySelector("table"),
		rows = infoTable.querySelectorAll("tr"),
		confirmButton = form.querySelector("button");

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
			} else if(label.textContent.indexOf("이름") >= 0) {
				flag = nameCheck(input.value);
				if(!flag) break;
			} else if(label.textContent == "이메일") {
				flag = emailCheck(input.value);
				if(!flag) break;
			}
		}

		if(flag) {
			form.submit();
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
	}

	window.addEventListener("DOMContentLoaded", init);	
})();
