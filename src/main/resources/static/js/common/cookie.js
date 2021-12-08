(function() {

	if(typeof window.common === "undefined") {
		window.common = {};
	}

	if(typeof window.common.cookie == "undefined") {
		window.common.cookie = {};
	}

	let cookie = window.common.cookie;

	cookie.getCookie = function getCookie(cookieName) {
		let value = "",
			cookieIndex = document.cookie.indexOf(cookieName);

		if(cookieIndex >= 0) {
			let end = document.cookie.indexOf(";", cookieIndex + cookieName.length);
			if(end < 0) end = document.cookie.length;

			value = document.cookie.substring(cookieIndex+cookieName.length+1, end);
		}

		return value;
	}

	cookie.setCookie = function setCookie(cookieName, value, expireDays) {
		let expireDate = new Date();
		expireDate.setDate(expireDate.getDate() + expireDays);

		document.cookie= cookieName + "=" + escape(value) + ";" + (expireDays == null ? "" : " expires=" + expireDate.toGMTString());
	}

	cookie.deleteCookie = function deleteCookie(cookieName) {
		document.cookie= cookieName + "= ; expires=" + new Date().toGMTString() + ";";
	}

})();
