(function() {
	let applyCompanyBtn = document.querySelectorAll(".content_title_text4_btn"),
    	applyCompany = new Array(applyCompanyBtn.length);
    	
    let applyContentWrap = document.querySelector("#content_wrap"),
		checkButtonSize = applyContentWrap.querySelectorAll(".checkBtn1").length,
		form = applyContentWrap.querySelector(".delete_form"),
		scrapCancelButton = form.querySelector("button");

	let checkCount = 0;
    	
	function init() {
		applyCompanyButtonBindClickEvent();
		applyContentWrap.addEventListener("change", changeEventHandler);
	}
	
	function applyCompanyButtonBindClickEvent() {
		for(let i=0; i<applyCompanyBtn.length; i++){
			applyCompany[i] = applyCompanyBtn[i].value;
	    	applyCompanyBtn[i].addEventListener('click',applyResume);

			function applyResume(){
		        if (statusYResume === null) {
		            alert("대표 이력서를 등록해주세요.");
		            location.href = "/personal/mypage/resumeManagement";
		        } else {
		            let applyYN = confirm("현재 대표이력서로 해당 공고에 즉시지원 하시겠습니까?");
		
		            if (applyYN) {
		                location.href = "/personal/mypage/scrap/applyResume/" + statusYResumeRNo + "," + applyCompany[i];
		            }
		        }
		    }
		}
	}
	
	function changeEventHandler(e) {
		if(e.target.tagName = "INPUT") {
			let input = e.target;

			if(input.classList.contains("checkBtn1")) {
				scrapCheckButtonChangeEventHandler(input);
			}
		}
	}

	function scrapCheckButtonChangeEventHandler(input) {
		if(input.classList.contains("active")) {
			deleteForm(input);
		} else {
			insertForm(input);
		}
	}

	function deleteForm(input) {
		form.querySelector("input[value='" + input.getAttribute("data-job-vacancy-no")+ "']").remove();
		input.classList.remove("active");
		checkCount--;

		if(checkCount == 0) {
			scrapCancelButton.setAttribute("disabled", true);
		}
	}

	function insertForm(input) {
		form.insertAdjacentHTML("beforeend", "<input type='hidden' name='jvNo' value='" + input.getAttribute("data-job-vacancy-no") + "'>");
		input.classList.add("active");
		checkCount++;

		if(checkCount > 0) {
			scrapCancelButton.removeAttribute("disabled");
		}
	}


	window.addEventListener("DOMContentLoaded", init);	
})();