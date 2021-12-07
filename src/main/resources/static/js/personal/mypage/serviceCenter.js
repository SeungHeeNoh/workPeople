/* SockJS 객체 생성 - 요청 url 경로를 매개변수로 등록*/
var sock = new SockJS("/single-chat");

/* 소켓 연결 시 동작하는 이벤트 핸들러 정의 */
sock.onopen = function(data){
    console.log(sock);
    console.log(data);
}

/* 소켓 종료 시 동작하는 이벤트 핸들러 정의 */
sock.onclose = function(){
    // location.href="/";
    history.go(-1);
}

/* 웹소켓 처리 객체에서 전달 받은 TextMessage를 처리하는 이벤트 핸들러 정의*/
sock.onmessage = onMessage;

$(function(){
    /* 메세지 전송 버튼 클릭 시 */
    $(".green1").click(function(){
        /* 메세지를 웹 소켓처리 객체로 전송하는 함수
           매핑 된 핸들러 객체의 handelrTextMessage 메소드가 실행 */
        sock.send($("#message").val());
        $("#message").val("");
    })

    /* 채팅에서 나가기 버튼 클릭 시 */
    // $("#exitBtn").click(function(){
    //     /* 소켓 연결을 닫음 */
    //     sock.onclose();
    // })
})


function onMessage(evt){
    var data = evt.data;
    var strArray = data.split("|");

    /* 전송 된 데이터 출력 */
    for(var i=0; i<strArray.length; i++){
        console.log('strArray['+i+'] : '+strArray[i]);
    }

    var now = new Date();
    var printDate = now.getFullYear() + "/"+(now.getMonth()+1) + "/"+now.getDate()
        +" "+now.getHours() + " : "+now.getMinutes()+":"+now.getSeconds();

    var printHTML = '';

    /* 채팅창에 누군가 입장한 경우 */
    if(strArray.length >1){
        var host = strArray[0].substr(1, strArray[0].indexOf(":")-1);


        console.log("host : "+host);
        console.log("ck_host : "+ck_host);

        /* 내가 작성한 메세지일 때*/
        if(host === ck_host){
            printHTML += "<div style='margin-left:60%'>"
                + "<sub>"+printDate+"</sub><br>"
                + "<strong>["+strArray[1]+"] : " + strArray[2] + "</strong>"
                + "</div>";
        } else{
            /* 다른 사람이 작성한 메세지일 때*/
            printHTML += "<div style='margin-left:2%'>"
                + "<sub>"+printDate+"</sub><br>"
                + "<strong>["+strArray[1]+"] : " + strArray[2] + "</strong>"
                + "</div>";

        }


    } else{
        /* 누군가 퇴장한 경우 */
        printHTML += "<div style='margin-left:60%;'>"
            + "<sub>"+printDate + "</sub>"
            + "<strong>[서버관리자]"+strArray[0] + "</strong>"
            +"</div>"
    }

    $(".content2_container").append(printHTML);

}
