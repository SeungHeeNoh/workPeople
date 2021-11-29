(function() {

    let resumeDeleteBtn = document.querySelectorAll(".orange2"),
        resumeDeleteBtnValue = new Array(resumeDeleteBtn.length);

    for(let i=0; i<resumeDeleteBtn.length; i++){
        resumeDeleteBtnValue[i] = resumeDeleteBtn[i].value;

        resumeDeleteBtn[i].addEventListener('click',resumeDelete);

        function resumeDelete(){
            let checkyn = confirm("해당 이력서를 삭제하시겠습니까?");
            if(checkyn){
                location.href = "/personal/mypage/resumeManagement/resumeDelete/"+resumeDeleteBtnValue[i];
            }
        }
    }






















})();