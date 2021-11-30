let applyCompanyBtn = document.querySelectorAll(".content_title_text4_btn"),
    applyCompany = new Array(applyCompanyBtn.length);

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

