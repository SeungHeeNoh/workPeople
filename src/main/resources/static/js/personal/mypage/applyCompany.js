// let jvNoCheckBox = document.querySelectorAll(".checkBtn1"),
//     jvNo = [],
//     applyCancelBtn = document.querySelector(".orange1"),
//     deleteBtn = document.querySelector(".green1");
//
// applyCancelBtn.addEventListener('click',applyCancel);
// deleteBtn.addEventListener('click',deleteApply);


let jvNo = [];

function test(item) {
    jvNo.push(item);
}

function applyCancel(){
    $.ajax({
        type: "post", //요청 메소드 방식
        url:"/personal/mypage/applyCompany/applyCancel",
        dataType:"json", //서버가 요청 URL을 통해서 응답하는 내용의 타입
        data:{
            ids
        },
        success : function(result){
            //서버의 응답데이터가 클라이언트에게 도착하면 자동으로 실행되는함수(콜백)
            //result - 응답데이터
            //$('#result').text(result);
            alert(result);
        },
        error : function(a, b, c){
            //통신 실패시 발생하는 함수(콜백)
            alert(a + b + c);
        }
    });

    for(let i=0; i<jvNoCheckBox.length; i++){
        if(jvNoCheckBox[i].checked){
            jvNo.push(jvNoCheckBox[i].value);
        }
    }

    location.href="/personal/mypage/applyCompany"
}






// for(let i=0; i<jvNoCheckBox.length; i++){
//
//     if(jvNoCheckBox[i].getAttribute("checked")){
//         jvNo.push(jvNoCheckBox[i].value);
//     }
//
// }























