(function() {
	let contentWrap = document.querySelector("#content_wrap"),
		form = contentWrap.querySelector(".delete_form"),
		deleteButton = form.querySelector("button");
		
	let checkCount = 0;

	function init() {
		contentWrap.addEventListener("change", changeEventHandler);
	}

	function changeEventHandler(e) {
		if(e.target.tagName = "INPUT") {
			let input = e.target;

			if(input.classList.contains("checkBtn1")) {
				interestedCompanyCheckButtonChangeEventHandler(input);
			}
		}
	}

	function interestedCompanyCheckButtonChangeEventHandler(input) {
		if(input.classList.contains("active")) {
			deleteForm(input);
		} else {
			insertForm(input);
		}
	}

	function deleteForm(input) {
		form.querySelector("input[value='" + input.getAttribute("data-company-no")+ "']").remove();
		input.classList.remove("active");
		checkCount--;

		if(checkCount == 0) {
			deleteButton.setAttribute("disabled", true);
		}
	}

	function insertForm(input) {
		form.insertAdjacentHTML("beforeend", "<input type='hidden' name='companyNo' value='" + input.getAttribute("data-company-no") + "'>");
		input.classList.add("active");
		checkCount++;

		if(checkCount > 0) {
			deleteButton.removeAttribute("disabled");
		}
	}

	window.addEventListener("DOMContentLoaded", init);	
})();