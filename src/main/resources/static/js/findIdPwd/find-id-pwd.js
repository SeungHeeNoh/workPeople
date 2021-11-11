(function() {
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

				console.log(label.textContent.indexOf("이름") > 0);
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
			// form.submit();
		}

		function idCheck(value) {
			let flag = true;

			if(value.length == 0) {
				alert("아이디를 입력해주세요.");
				flag = false;
			} else if(!/^[a-z0-9\_]{4,20}$/gi.test(value)) {
				alert("4~20자의 영문, 숫자와 특수문자(_)만 입력 가능합니다.");
				flag = false;
			}

			return flag;
		}

		function nameCheck(value) {
			let flag = true;

			if(value.length == 0) {
				alert("이름을 입력해주세요.");
				flag = false;
			} else if(!/^[ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z]{2,}$/.test(value)) {
				alert("이름에 특수문자, 숫자는 사용하실 수 없습니다.");
				flag = false;
			}

			return flag;
		}

		function emailCheck(value) {
			let flag = true;

			if(value.length == 0) {
				alert("이메일을 입력해주세요.");
				flag=false;
			} else if(!/^[a-z0-9.+_-]+@([0-9a-z_-]+\.)+[a-z]{2,10}$/i.test(value)) {
				alert("유효하지 않은 이메일 형식입니다.");
				flag = false;
			}

			return flag;
		}
	}

	window.addEventListener("DOMContentLoaded", init);	
})();
