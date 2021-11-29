(function() {
	let inputValidate = window.common.validate.input;

	let joinRow = ".join_row",
		notice = ".notice";

	let content = document.querySelector(".content"),
		form = content.querySelector("form"),
		inputList = form.querySelectorAll(joinRow);

	let joinRows = {};

	inputList.forEach(function(joinRow) {
		let name = joinRow.querySelector("input") != null ? joinRow.querySelector("input").id : joinRow.querySelector("select").id;

		joinRows[name] = {
			joinRow : joinRow,
			input : joinRow.querySelector("input") != null ? joinRow.querySelector("input") : joinRow.querySelector("select"),
			notice :joinRow.querySelector(notice),
			isCertify : joinRow.querySelector("button") != null ? true : false
		}
	});

	function init() {
		form.addEventListener("keyup", keyupEventHandler);
		form.addEventListener("focusout", focusoutEventHandler);
		form.addEventListener("click", clickEventHandler);
	}

	function keyupEventHandler(e) {
		if(e.target.tagName == "INPUT") {
			let input = e.target;

			if(input.id == "user_check_pwd") {
				if(isEqualPwdInputs()) {
					updateValidState("user_check_pwd");
				} else {
					deleteValidState("user_check_pwd", "비밀번호가 일치하지 않습니다.");
				}
			}
		}
	}

	function isEqualPwdInputs() {
		return joinRows["user_check_pwd"]["input"].value.length > 0 && joinRows["user_pwd"]["input"].value == joinRows["user_check_pwd"]["input"].value;
	}

	function focusoutEventHandler(e) {
		if(e.target.tagName == "INPUT" || e.target.tagName == "SELECT") {
			validate(e.target)
		}
	}

	function validate(validateTarget) {
		let input = validateTarget,
			inputId = input.id;

		if(inputId == "user_check_pwd") {
			hideNotice(joinRows[inputId]["joinRow"]);

			if(isEqualPwdInputs()) {
				updateValidState(inputId, "비밀번호가 일치하지 않습니다.");
			} else {
				deleteValidState(inputId);
			}
		} else {
			let result = inputValidate["passwordCheck"](joinRows[inputId]["input"].value);
			hideNotice(joinRows[inputId]["joinRow"]);

			if(result.length > 0) {
				deleteValidState(inputId, result);
			} else {
				updateValidState(inputId);
			}
		}
	}

	

	function updateValidState(id) {
		joinRows[id]["joinRow"].classList.add("valid_state");
		joinRows[id]["notice"].classList.remove("show");
	}

	function deleteValidState(id, text) {
		joinRows[id]["joinRow"].classList.remove("valid_state");
		if(text != undefined) joinRows[id]["notice"].innerHTML = text;
		joinRows[id]["notice"].classList.add("show");
	}

	function hideNotice(inputDiv) {
		inputDiv.querySelectorAll(".notice").forEach(function(notice) {
			notice.classList.remove("show");
		});
	}

	function clickEventHandler(e) {
		if(e.target.tagName == "BUTTON") {
			let button = e.target;

			if(button.classList.contains("confirm_button")){
				let flag = true;

				for(let joinRow in joinRows) {
					if(!joinRows[joinRow]["joinRow"].classList.contains("valid_state")) {
						deleteValidState(joinRow, "필수 정보입니다.")
						flag = false;
					}
				}

				if(flag) {
					form.submit();
				}
			}
		}
	}

	window.addEventListener("DOMContentLoaded", init);	
})();