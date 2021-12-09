(function() {
	let inputValidate = window.common.validate.input;

	let joinRow = ".join_row",
		notice = ".notice";

	let content = document.querySelector(".content"),
		form = content.querySelector("form"),
		inputList = form.querySelectorAll(joinRow)
		timerSpan = form.querySelector("div.timer.join_row").querySelector(".timer");

	let code = "",
		timer;

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
					updateValidState(inputId);
					
					if(inputId == "register_number") {
						checkValidateRegisterNumber(inputId, joinRows[inputId]["input"].value);
					} else if(inputId == "user_id") {
						checkId(inputId, joinRows[inputId]["input"].value);
					}
				}
			}

			if(func.length == 0) {
				if(inputId == "user_check_pwd") {
					hideNotice(joinRows[inputId]["joinRow"]);

					if(isEqualPwdInputs()) {
						updateValidState(inputId, "비밀번호가 일치하지 않습니다.");
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
					updateValidState(selectId);
				}
			}
		}

		return flag;
	}

	function checkValidateRegisterNumber(inputId, registerNumber) {
		let isRun = false;

		if(isRun) return;
		isRun = true;
		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4) {
				if((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
					if(xhr.response.data) {
						isRun = false,
						data = xhr.response.data[0];

						if(data["tax_type"] == "국세청에 등록되지 않은 사업자등록번호입니다.") {
							deleteValidState(inputId, "국세청에 등록되지 않은 사업자등록번호입니다.");
						} else if(data["b_stt"].indexOf("폐업자") > 0 || data["b_stt"].indexOf("휴업자") > 0) {
							deleteValidState(inputId, "휴/폐업 기업으로 등록된 사업자등록번호로 가입하실 수 없습니다.");
						} else {
							let xhr2 = new XMLHttpRequest();
							xhr2.onreadystatechange = function() {
								if(xhr2.readyState == 4) {
									if((xhr2.status >= 200 && xhr2.status < 300) || xhr2.status == 304) {
										if(xhr2.response.message) {
											if(xhr2.response.message.length > 0) {
												deleteValidState(inputId, xhr2.response.message);
											} else {
												updateValidState(inputId);
											}
										}
									} else {
										console.log("ajax 통신 실패");
									}
								}
							}

							xhr2.open("GET", "/account/join/company/" + registerNumber);
							xhr2.setRequestHeader("Content-type", "application/json;");
							xhr2.responseType = "json";
							xhr2.send();
						}
					}
				} else {
					console.log("ajax 통신 실패");
				}
			}
		}

		xhr.open("POST", "https://api.odcloud.kr/api/nts-businessman/v1/status?serviceKey=c9hyIZt9CgnuVKtsIKuJUjSvh05L0r5rH%2F7JKVTwAyI9eTtTqB3IXe59mdop%2FQmSV%2Btm8TUv9Pw%2BY4tyjvJ5ig%3D%3D");
		xhr.setRequestHeader("Content-type", "application/json;");
		xhr.responseType = "json";
		xhr.send(JSON.stringify({"b_no":["" + registerNumber.replaceAll(/-/g, "")]}));
	}

	function checkId(inputId, id) {
		let isRun = false;

		if(isRun) return;
		isRun = true;

		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4) {
				if((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
					if(xhr.response.message) {
						if(xhr.response.message.length > 0) {
							deleteValidState(inputId, xhr.response.message);
						} else {
							updateValidState(inputId);
						}
					}
				} else {
					console.log("ajax 통신 실패");
				}
			}
		}

		xhr.open("GET", "/account/join/member/" + id);
		xhr.responseType = "json";
		xhr.send();
	}

	function clickEventHandler(e) {
		if(e.target.tagName == "BUTTON") {
			let button = e.target;

			if(button.classList.contains("check_button")) {
				let inputId = button.closest(joinRow).querySelector("input").id;

				if(button.classList.contains("send_email_button")) {
					sendMailButtonHandler(inputId, button);
				} else if(button.classList.contains("email_check_button")) {
					emailCheckButtonHandler(inputId);
				} else if(button.classList.contains("address_search_button")) {
					addressSearchButtonHandler();
				}
			} else if(button.classList.contains("confirm_button")){
				confirmButtonHandler();
			}
		}
	}

	function sendMailButtonHandler(inputId, button) {
		let text = inputValidate["emailCheck"](joinRows[inputId]["input"].value);

		if(text.length > 0) {
			deleteValidState(inputId, text);
		} else {
			if(confirm("인증 메일을 전송하시겠습니까?")) {
				updateValidState(inputId);
				setDisabled(button);
				joinRows[inputId]["input"].setAttribute("readonly", true);
				sendMail(inputId, joinRows[inputId]["input"].value, button);
				hideNotice(joinRows["email_check"]["joinRow"]);
			} else {
				deleteValidState(inputId, "인증이 완료되지 않았습니다.");
				deleteValidState("email_check", "인증이 완료되지 않았습니다.");
				joinRows[inputId]["input"].removeAttribute("readonly");
				clearCertStringTimer();
			}
		}
	}

	function sendMail(inputId, email, button) {
		let isRun = false;

		if(isRun) return;
		isRun = true;

		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4) {
				button.removeAttribute("disabled");

				if((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
					if(xhr.response.message) {
						if(xhr.response.message == "메일을 보내는 데에 실패했습니다.") {
							deleteValidState(inputId, xhr.response.message);
							joinRows[inputId]["input"].removeAttribute("disabed");
						} else {
							updateValidState(inputId);
							alert(xhr.response.message);
							code = xhr.response.certString;
							joinRows["email_check"]["input"].removeAttribute("disabled");
							joinRows["email_check"]["input"].value = "";
							joinRows["email_check"]["joinRow"].querySelector("button").removeAttribute("disabled");
							startCertStringTimer(180);
						}
					}
				} else {
					console.log("ajax 통신 실패");
				}
			}
		}

		xhr.open("GET", "/account/join/mail/" + email);
		xhr.responseType = "json";
		xhr.send();
	}

	function startCertStringTimer(count) {
		let minutes, seconds;

		timerSpan.classList.add("show");

		clearInterval(timer);
		timer = setInterval(function() {
			minutes = parseInt(count/60, 10);
			seconds = parseInt(count% 60, 10);

			minutes = "0" + minutes;
			seconds = seconds < 10 ? "0" + seconds : seconds;
			timerSpan.innerHTML = minutes + ":" + seconds;

			if(--count < 0) {
				clearCertStringTimer("인증 시간이 초과하였습니다.");
			}

		}, 1000);
	}

	function clearCertStringTimer(message) {
		clearInterval(timer);
		timerSpan.classList.remove("show");
		timerSpan.innerHTML = "03:00";
		setDisabled(joinRows["email_check"]["input"]);
		setDisabled(joinRows["email_check"]["joinRow"].querySelector("button"));

		if(message) {
			deleteValidState("email_check", message);
		}
	}

	function emailCheckButtonHandler(inputId) {
		if(code == joinRows[inputId]["input"].value) {
			updateValidState(inputId);
			clearCertStringTimer();
			alert("인증되었습니다.");
		} else {
			deleteValidState(inputId, "인증번호가 일치하지 않습니다.");
		}
	}

	function addressSearchButtonHandler() {
		new daum.Postcode({
			oncomplete: function(data) {
				joinRows["postcode"]["input"].value = data.zonecode;
				joinRows["road_address"]["input"].value = data.roadAddress;
				updateValidState("postcode");
				updateValidState("road_address");
			}
		}).open();
	}

	function confirmButtonHandler() {
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

	function setDisabled(tag) {
		tag.setAttribute("disabled", true);
	}

	function removeDisabled(tag) {
		tag.removeAttribute("disabled");
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

	window.addEventListener("DOMContentLoaded", init);	
})();