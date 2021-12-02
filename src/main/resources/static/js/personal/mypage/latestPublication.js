let applyBtn = document.querySelectorAll(".content_title_text4_btn"),
    applyBtnNo = new Array(applyBtn.length);



for(let i=0; i<applyBtn.length; i++) {
    applyBtnNo[i] = applyBtn[i].value;

    applyBtn[i].addEventListener('click', applyResume);

    function applyResume() {

        if (statusYResume === null) {
            alert("대표 이력서를 등록해주세요.");
            location.href = "/personal/mypage/resumeManagement";
        } else {
            let applyYN = confirm("현재 대표이력서로 해당 공고에 즉시지원 하시겠습니까?");

            if (applyYN) {
                location.href = "/personal/mypage/latestPublication/applyResume/" + statusYResumeRNo + "," + applyBtnNo[i];
            }
        }


    }
}


