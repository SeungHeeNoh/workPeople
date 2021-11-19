
$(function() {
    // 탭이동
    $('label').click(function(){
        $('label').removeClass('on');
        $(this).addClass('on');
        var idx=$(this).index()+1;

        $('.tab_content').css('display','none');
        $('.tab_content'+idx).css('display','block');
        
        });  

    // 상세버튼(플레티넘 영역)
    $(".btn1").click(function(){
        if($(".item1").css('display') == 'none') {
            $(".item1").css('display','block');
            $('.btn1_1').removeClass('colorInvert');
            $('.wrap1').addClass('expand');
        } else  {
            $(".item1").css('display','none');
            $('.btn1_1').addClass('colorInvert');
            $('.wrap1').removeClass('expand');
        }
    });
    // 상세버튼(베이직 영역)
    $(".btn2").click(function(){
        if($(".item2").css('display') == 'none') {
            $(".item2").css('display','block');
            $('.btn2_1').removeClass('colorInvert');
            $('.wrap2').addClass('expand');
        } else  {
            $(".item2").css('display','none');
            $('.btn2_1').addClass('colorInvert');
            $('.wrap2').removeClass('expand');
        }
    });
     // 상세버튼(랭킹업 영역)
     $(".btn3").click(function(){
        if($(".item3").css('display') == 'none') {
            $(".item3").css('display','block');
            $('.btn3_1').removeClass('colorInvert');
            $('.wrap3').addClass('expand');
        } else  {
            $(".item3").css('display','none');
            $('.btn3_1').addClass('colorInvert');
            $('.wrap3').removeClass('expand');
        }
    });


    // 플레티넘 모달창
    const open = () => { 
        const date = document.querySelector(".date_start").value;
        const s = document.getElementById("top_term_popular1");
        const popular1 = s.options[s.selectedIndex].value;
        if(date == ''){
            alert('노출 기간을 설정해주세요. (상세 버튼 클릭)');
        } else {
            $( '.option_start' ).text( date );
            $( '.option_day' ).text( popular1 );
            document.querySelector(".modalDrawer").classList.add("show");
            document.querySelector(".dimmed").style.display = 'block';
        }
    }
    
    const close = () => {
        document.querySelector(".modalDrawer").classList.remove("show");
        document.querySelector(".dimmed").style.display = 'none';
    }
    
    document.querySelector(".btn1_1").addEventListener("click", open);
    document.querySelector(".btnClose").addEventListener("click", close);
    document.querySelector(".dimmed").addEventListener("click", close);

    
     // 베이직 모달창
     const open2 = () => { 
        const date = document.querySelector(".date_start2").value;
        const s = document.getElementById("top_term_popular2");
        const popular2 = s.options[s.selectedIndex].value;
        if(date == ''){
            alert('노출 기간을 설정해주세요. (상세 버튼 클릭)');
        } else {
            $( '.option_start2' ).text( date );
            $( '.option_day2' ).text( popular2 );
            document.querySelector(".modal2").classList.add("show");
            document.querySelector(".dim2").style.display = 'block';
        }
    }
    
    const close2 = () => {
        document.querySelector(".modal2").classList.remove("show");
        document.querySelector(".dim2").style.display = 'none';
    }
    
    document.querySelector(".btn2_1").addEventListener("click", open2);
    document.querySelector(".btnC2").addEventListener("click", close2);
    document.querySelector(".dim2").addEventListener("click", close2);

    // 랭킹업 모달창
    const open3 = () => { 
        const date = document.querySelector(".date_start3").value; 
        const s = document.getElementById("top_term_popular3");
        const popular3 = s.options[s.selectedIndex].value;
        if(date == ''){
            alert('노출 기간을 설정해주세요. (상세 버튼 클릭)');
        } else {
            $( '.option_start3' ).text( date );
            $( '.option_day3' ).text( popular3 );
            document.querySelector(".modal3").classList.add("show");
            document.querySelector(".dim3").style.display = 'block';
        }
    }
    
    const close3 = () => {
        document.querySelector(".modal3").classList.remove("show");
        document.querySelector(".dim3").style.display = 'none';
    }
    
    document.querySelector(".btn3_1").addEventListener("click", open3);
    document.querySelector(".btnC3").addEventListener("click", close3);
    document.querySelector(".dim3").addEventListener("click", close3);


    // 결제 api 
    $(".total_btn").click(function () { 
        var che = $('input[name="radio"]:checked').val();
        if(che == ''){
            alert("공고를 선택해주세요.");
        } else {
            const { IMP } = window;
            IMP.init('imp36894634'); 
            IMP.request_pay({
                pg : 'html5_inicis',
                pay_method : 'card',
                merchant_uid : 'merchant_' + new Date().getTime(),
                name : '주문명:결제테스트',
                amount : 1,
                buyer_email : 'iamport@siot.do',
                buyer_name : '구매자이름',
                buyer_tel : '010-1234-5678',
                buyer_addr : '서울특별시 강남구 삼성동',
                buyer_postcode : '123-456'
            }, function(rsp) {
                if ( rsp.success ) {
                    var msg = '결제가 완료되었습니다.';
                    var result = {
                        "imp_uid" : rsp.imp_uid,
                        "merchant_uid" : rsp.merchant_uid,
                        "biz_email" : '&lt;%=email%&gt;',
                        "pay_date" : new Date().getTime(),
                        "amount" : rsp.paid_amount,
                        "card_no" : rsp.apply_num,
                        "refund" : 'payed'
                        }
                        console.log("결제성공 " + msg);
                        $.ajax({
                            url : '/samsam/insertPayCoupon.do', 
                            type :'POST',
                            data : JSON.stringify(result,
                                    ['imp_uid', 'merchant_uid', 'biz_email', 
                                        'pay_date', 'amount', 'card_no', 'refund']),
                            contentType:'application/json;charset=utf-8',
                            dataType: 'json', //서버에서 보내줄 데이터 타입
                            success: function(res){
                                                    
                              if(res == 1){
                                 console.log("추가성공");	
                            		           
                              }else{
                                 console.log("Insert Fail!!!");
                              }
                            },
                            error:function(){
                              console.log("Insert ajax 통신 실패!!!");
                            }
                        }) //ajax
                } else {
                    var msg = '결제에 실패하였습니다.';
                    msg += '에러내용 : ' + rsp.error_msg;
                }
            
                alert(msg);
                document.location.href="/user/mypage/home"; //alert창 확인 후 이동할 url 설정
            });
        }
       
    });

    




    

});


