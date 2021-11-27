(function() {

    if(document.querySelector(".orange1").value != null){
        let deleteBtn =document.querySelector(".orange1"),
            rNo = deleteBtn.value

        deleteBtn.addEventListener('click',deleteResume);

        function deleteResume(){

            let deleteYN = confirm("이력서를 삭제하시겠습니까?");

            if(deleteYN){
                location.href = "/personal/mypage/home/resumeDelete/"+rNo;
            }
        }
    }

    if(document.querySelector(".content_title_text4_btn").value != null) {
        let applyBtn = document.querySelector(".content_title_text4_btn"),
            applyBtnNo = applyBtn.value;

        applyBtn.addEventListener('click', applyResume);

        function applyResume() {

            if (applyBtnNo == null) {
                alert("대표 이력서를 등록해주세요.");
                location.href = "/personal/mypage/resumeManagement";
            } else {
                let applyYN = confirm("현재 대표이력서로 해당 공고에 즉시지원 하시겠습니까?");

                if (applyYN) {
                    location.href = "/personal/mypage/home/applyResume/" + rNo + "," + applyBtnNo;
                }
            }


        }
    }












})();
