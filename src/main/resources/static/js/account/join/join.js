(function() {
	let inputValidate = window.common.validate.input;

	let joinRow = ".join_row",
		notice = ".notice";

	let content = document.querySelector(".content"),
		form = content.querySelector("form"),
		inputList = form.querySelectorAll(".join_row");

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
					updateVlidState("user_check_pwd");
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
		let flag = true;

		if(validateTarget.tagName == "INPUT") {
			let input = validateTarget,
				inputId = input.id,
				func = "";

			switch(inputId) {
				case "register_number" : 
					func = "companyRegisterNumber";
					break;
				case "user_id" : 
					func = "idCheck";
					break;
				case "user_pwd" : 
					func = "passwordCheck";
					break;
				case "user_name" :
					func = "nameCheck";
					break;
				case "phone" :
					func = "phoneCheck";
					break;
				case "email" :
					func = "emailCheck";
					break;
				case "detail_address" :
					func = "detailAddressCheck";
					break;
			}

			if(func.length > 0) {
				let result = inputValidate[func](joinRows[inputId]["input"].value);
				hideNotice(joinRows[inputId]["joinRow"]);

				if(result.length > 0) {
					deleteValidState(inputId, result);
					flag = false;
				} else {
					updateVlidState(inputId);
				}
			}

			if(func.length == 0) {
				if(inputId == "user_check_pwd") {
					hideNotice(joinRows[inputId]["joinRow"]);

					if(isEqualPwdInputs()) {
						updateVlidState(inputId, "비밀번호가 일치하지 않습니다.");
					} else {
						deleteValidState(inputId);
						flag = false;
					}
				}
			}
		} else if(validateTarget.tagName == "SELECT") {
			let select = validateTarget
				selectId = select.id;

			if(selectId == "company_type" || selectId == "sector") {
				hideNotice(joinRows[selectId]["joinRow"]);

				if(select.value == "default") {
					deleteValidState(selectId);
					flag = false;
				} else {
					updateVlidState(selectId);
				}
			}
		}

		return flag;
	}

	function clickEventHandler(e) {
		if(e.target.tagName == "BUTTON") {
			let button = e.target;

			if(button.classList.contains("check_button")) {
				let inputId = button.closest(joinRow).querySelector("input").id;

				if(button.classList.contains("register_number_check_button")) {
					hideNotice(joinRows[inputId]["joinRow"]);

					if(joinRows[inputId]["input"].value.length != 10) {
						joinRows[inputId]["checkNotice"].classList.add("show");
					} else {
						joinRows[inputId]["checkNotice"].classList.remove("show");
						// 1. 사업자 등록번호가 존재하는 번호인지 API를 통해 확인
						// - 존재하지 않는 번호인 경우 : "유효하지 않은 사업자 등록번호입니다." alert 노출
						// - 존재하는 번호인 경우
						//	  2. DB에 가입된 회원인지 확인
						//		- 이미 가입한 회원인 경우 "이미 가입한 기업회원입니다." alert 노출
						//		- 가입 가능한 회원인 경우 "가입 가능한 기업회원입니다. 등록하시겠습니까?" confirm 노출 => 확인 클릭 시 readonly로 변경, 취소 시 readonly 제거
					}
				} else if(button.classList.contains("id_check_button")) {
					hideNotice(joinRows[inputId]["joinRow"]);

					if(inputValidate.idCheck(joinRows[inputId]["input"].value).length > 0) {
						joinRows[inputId]["notice"].classList.add("show");
					} else {
						joinRows[inputId]["notice"].classList.remove("show");
						// DB를 통한 아이디 중복 체크
						// - 중복 아이디라면 : "사용할 수 없는 아이디입니다." alert 노출
						// - 중복 아이디가 아니라면 : "사용 가능한 아이디입니다. 사용하시겠습니까?" confirm 노출 => 확인 클릭 시 readonly로 변경, 취소 시 readonly 제거
					}
				} else if(button.classList.contains("send_email_button")) {
					hideNotice(joinRows[inputId]["joinRow"]);

					if(inputValidate.emailCheck(joinRows[inputId]["input"].value).length > 0) {
						joinRows[inputId]["notice"].classList.add("show");
					} else {
						joinRows[inputId]["notice"].classList.remove("show");
						// 이메일 발송
					}
				} else if(button.classList.contains("email_check_button")) {
					
				} else if(button.classList.contains("address_search_button")) {
					new daum.Postcode({
						oncomplete: function(data) {
							joinRows["postcode"]["input"].value = data.zonecode;
							joinRows["road_address"]["input"].value = data.roadAddress;
							updateVlidState("postcode");
							updateVlidState("road_address");
						}
					}).open();
				}
			} else if(button.classList.contains("confirm_button")){
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

	function updateVlidState(id) {
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

	window.addEventListener("DOMContentLoaded", init);	
})();