(function() {

	if(typeof window.common === "undefined") {
		window.common = {};
	}

	if(typeof window.common.validate == "undefined") {
		window.common.validate = {};
	}

	if(typeof window.common.validate.input == "undefined") {
		window.common.validate.input = {};
	}

	let inputValidate = window.common.validate.input;

	inputValidate.companyRegisterNumber = function companyRegisterNumber(value) {
		let result = "";

		if(value.length == 0) {
			result = "사업자 등록번호를 입력해주세요.";
		} else if(!/^[0-9]{3}-[0-9]{2}-[0-9]{5}$/.test(value)) {
			result = "사업자 등록번호 형식에 맞춰 입력해주세요.";
		}

		return result;
	}

	inputValidate.idCheck = function idCheck(value) {
		let result = "";

		if(value.length == 0) {
			result = "아이디를 입력해주세요.";
		} else if(!/^[a-z0-9\_]{4,20}$/gi.test(value)) {
			result = "4~20자의 영문, 숫자와 특수문자(_)만 입력 가능합니다.";
		}

		return result;
	}

	inputValidate.nameCheck = function nameCheck(value) {
		let result = "";

		if(value.length == 0) {
			result = "이름을 입력해주세요.";
		} else if(!/^[ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z\s()]{2,}$/.test(value)) {
			result = "이름에 특수문자, 숫자를 제외한 글자가 두 글자 이상 입력되어야 합니다.";
		}

		return result;
	}

	inputValidate.emailCheck = function emailCheck(value) {
		let result = "";

		if(value.length == 0) {
			result = "이메일을 입력해주세요.";
		} else if(!/^[a-z0-9.+_-]+@([0-9a-z_-]+\.)+[a-z]{2,10}$/i.test(value)) {
			result = "유효하지 않은 이메일 형식입니다.";
		}

		return result;
	}

	inputValidate.passwordCheck = function passwordCheck(value) {
		let result = "";

		if(value.length == 0) {
			result = "비밀번호를 입력해주세요.";
		} else if(!/(?=.*[a-zA-Z](?=.*[0-9])(?=.*[^a-zA-Z0-9])).{8,16}/.test(value)) {
			result = "비밀번호는 8~16자리 영문 대소문자, 숫자, 특수문자 중 3가지 이상 조합으로 구성되어야 합니다."
		}

		return result;
	}

	inputValidate.phoneCheck = function phoneCheck(value) {
		let result = "";

		if(value.length == 0) {
			result = "전화번호를 입력해주세요.";
		} else if(!/^[0-9]{3}\-[0-9]{3,4}\-[0-9]{4}$/.test(value)) {
			result = "유효하지 않은 전화번호 형식입니다.";
		}

		return result;
	}

	inputValidate.detailAddressCheck = function passwordCheck(value) {
		let result = "";

		if(value.length == 0) {
			result = "상세주소를 입력해주세요.";
		}

		return result;
	}

})();
