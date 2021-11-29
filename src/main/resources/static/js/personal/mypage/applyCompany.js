(function() {

    let jvNoCheckBox = document.querySelectorAll(".checkBtn1"),
        jvNo = [],
        applyCancelBtn = document.querySelector(".orange1"),
        deleteBtn = document.querySelector(".green1");

    applyCancelBtn.addEventListener('click',applyCancel);
    // deleteBtn.addEventListener('click',deleteApply);

    function applyCancel(){

        // for(let i=0; i<jvNoCheckBox.length; i++){
        //     if(jvNoCheckBox[i].checked){
        //         jvNo.push(jvNoCheckBox[i].value);
        //     }
        // }

        location.href="/personal/mypage/"


    }







    for(let i=0; i<jvNoCheckBox.length; i++){

        if(jvNoCheckBox[i].getAttribute("checked")){
            jvNo.push(jvNoCheckBox[i].value);
        }

    }
























})();