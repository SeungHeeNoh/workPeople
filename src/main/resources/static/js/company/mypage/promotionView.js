
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
            if(popular1 < 10){
            	$( '.option_day' ).text( popular1 );
            } else if(popular1 == 10){
            	$( '.option_day' ).text( Number(popular1) + 2 );
            } else {
           	 	$( '.option_day' ).text( Number(popular1) + 4 );
            }
            
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


    // 플레티넘 기간 (지난 날짜 선택 시 alert)
	document.getElementById("startDate1").addEventListener("change", function(){
	
		let date = document.getElementById("startDate1").value;
			       let today = new Date();
			       today.setHours(0);
			       today.setSeconds(0);
			       today.setMilliseconds(0);
			       let visitDay = new Date(date);
			       
			       if (visitDay < today) {
			          alert("지난 날짜는 등록할 수 없습니다.");
			          document.getElementById("startDate1").value = "";
			       } 
			       }
    );
     // 베이직 기간 (지난 날짜 선택 시 alert)
	document.getElementById("startDate2").addEventListener("change", function(){
	
		let date = document.getElementById("startDate2").value;
			       let today = new Date();
			       today.setHours(0);
			       today.setSeconds(0);
			       today.setMilliseconds(0);
			       let visitDay = new Date(date);
			       
			       if (visitDay < today) {
			          alert("지난 날짜는 등록할 수 없습니다.");
			          document.getElementById("startDate2").value = "";
			       } 
			       }
    );
     // 랭킹업 기간 (지난 날짜 선택 시 alert)
	document.getElementById("startDate3").addEventListener("change", function(){
	
		let date = document.getElementById("startDate3").value;
			       let today = new Date();
			       today.setHours(0);
			       today.setSeconds(0);
			       today.setMilliseconds(0);
			       let visitDay = new Date(date);
			       
			       if (visitDay < today) {
			          alert("지난 날짜는 등록할 수 없습니다.");
			          document.getElementById("startDate3").value = "";
			       } 
			       }
    );
	
	
	
	
	// 플레티넘 기간 선택시 금액 변경
	$("#top_term_popular1").on("change", function(){
    	let selOne = $("#top_term_popular1 option:selected").val();
    	selOne2 = $.numberWithCommas(selOne * 2000);
    	$( '#total1' ).text( selOne2  );
    	$( '#modal_total1' ).text( selOne2  );
    	$( '#modal_total2' ).text( selOne2  );
    	$( '#modal_total3' ).text( selOne2  );
    });
    
    // 베이직 기간 선택시 금액 변경
	$("#top_term_popular2").on("change", function(){
    	let selOne = $("#top_term_popular2 option:selected").val();
    	selOne2 = $.numberWithCommas(selOne * 1000);
    	$( '#total2' ).text( selOne2  );
    	$( '#modal_total4' ).text( selOne2  );
    	$( '#modal_total5' ).text( selOne2  );
    	$( '#modal_total6' ).text( selOne2  );
    });
    
    // 랭킹업 기간 선택시 금액 변경
	$("#top_term_popular3").on("change", function(){
    	let selOne = $("#top_term_popular3 option:selected").val();
    	selOne2 = $.numberWithCommas(selOne * 500);
    	$( '#total3' ).text( selOne2  );
    	$( '#modal_total7' ).text( selOne2  );
    	$( '#modal_total8' ).text( selOne2  );
    	$( '#modal_total9' ).text( selOne2  );
    });
	
	$.numberWithCommas = function (x) {
	  return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
	} 

	
	

    // 플레티넘  결제 api 
    $("#total_btn1").click(function () { 
    
        var che = $('input[name="radio"]:checked').val();
        var startDate = $('#startDate1').val();
        var s = document.getElementById("top_term_popular1");
        var date = s.options[s.selectedIndex].value;
        var userName = $('input[name="userName"]').val();
        var userNo = $('input[name="userNo"]').val();
        var userEmail = $('input[name="userEmail"]').val();
        var orderNo = 1;
        
        var newDate = 0;
        
        if(date == 14){
        	newDate = Number(date) + 4
        } else if (date == 10){
        	newDate = Number(date) + 2
        } else {
            newDate = date
        }
        
        var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		$(function() {
		    $(document).ajaxSend(function(e, xhr, options) {
		        xhr.setRequestHeader(header, token);
		    });
		});
        
        if(che == undefined){
            alert("공고를 선택해주세요.");
        } else {
            const { IMP } = window;
            IMP.init('imp36894634'); 
            
            
            IMP.request_pay({
                pg : 'html5_inicis',
                pay_method : 'card',
                merchant_uid : 'merchant_' + new Date().getTime(),
                name : '플레티넘 상품',
                amount : $( '#modal_total3' ).text().replace(/[^0-9]/g, ""),
                buyer_email: userEmail,
                buyer_name: userName,
            }, function(rsp) {
                if ( rsp.success ) {
                    var result = {
                        "imp" : rsp.imp_uid,
                        "merchant" : rsp.merchant_uid,
                        "amount" : rsp.paid_amount,
                        "cardno" : rsp.apply_num,
                        "userNo" : userNo,
                        "jvNo" : che,
                        "date" : newDate,
                        "orderNo" : orderNo,
                        "startDate" : startDate
                        }
                        console.log("결제성공 " + msg);
                        $.ajax({
                            url : '/company/mypage/payment', 
                            type :'POST',
                            data : JSON.stringify(result),
                            contentType:'application/json;charset=utf-8',
                            dataType: 'json', 
                            success: function(res){
                            console.log(res);	
                                                    
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
                  document.location.href="/company/mypage/paymentFinish";    
                    
                } else {
                    var msg = '결제에 실패하였습니다.';
                    msg += '에러내용 : ' + rsp.error_msg;
                    alert(msg);
                    document.location.href="/main";
                }
           
               
            });
        }
       
    });
    
    
       // 베이직  결제 api 
    $("#total_btn2").click(function () { 
    
        var che = $('input[name="radio"]:checked').val();
        var startDate = $('#startDate2').val();
        var s = document.getElementById("top_term_popular2");
        var date = s.options[s.selectedIndex].value;
        var userName = $('input[name="userName"]').val();
        var userNo = $('input[name="userNo"]').val();
        var userEmail = $('input[name="userEmail"]').val();
        var orderNo = 2;
        
     
        
        var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		$(function() {
		    $(document).ajaxSend(function(e, xhr, options) {
		        xhr.setRequestHeader(header, token);
		    });
		});
        
        if(che == undefined){
            alert("공고를 선택해주세요.");
        } else {
            const { IMP } = window;
            IMP.init('imp36894634'); 
            
            
            IMP.request_pay({
                pg : 'html5_inicis',
                pay_method : 'card',
                merchant_uid : 'merchant_' + new Date().getTime(),
                name : '베이직 상품',
                amount : $( '#modal_total6' ).text().replace(/[^0-9]/g, ""),
                buyer_email: userEmail,
                buyer_name: userName,
            }, function(rsp) {
                if ( rsp.success ) {
                    var result = {
                        "imp" : rsp.imp_uid,
                        "merchant" : rsp.merchant_uid,
                        "amount" : rsp.paid_amount,
                        "cardno" : rsp.apply_num,
                        "userNo" : userNo,
                        "jvNo" : che,
                        "date" : date,
                        "orderNo" : orderNo,
                        "startDate" : startDate
                        }
                        console.log("결제성공 " + msg);
                        $.ajax({
                            url : '/company/mypage/payment', 
                            type :'POST',
                            data : JSON.stringify(result),
                            contentType:'application/json;charset=utf-8',
                            dataType: 'json', 
                            success: function(res){
                            console.log(res);	
                                                    
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
                  document.location.href="/company/mypage/paymentFinish";    
                    
                } else {
                    var msg = '결제에 실패하였습니다.';
                    msg += '에러내용 : ' + rsp.error_msg;
                     alert(msg);
                    document.location.href="/main";
                }
            
              
               
            });
        }
       
    });
    
    
       // 랭크업 결제 api 
    $("#total_btn3").click(function () { 
    
        var che = $('input[name="radio"]:checked').val();
        var startDate = $('#startDate3').val();
        var s = document.getElementById("top_term_popular3");
        var date = s.options[s.selectedIndex].value;
        var userName = $('input[name="userName"]').val();
        var userNo = $('input[name="userNo"]').val();
        var userEmail = $('input[name="userEmail"]').val();
        var orderNo = 3;
        
       
        
        var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		$(function() {
		    $(document).ajaxSend(function(e, xhr, options) {
		        xhr.setRequestHeader(header, token);
		    });
		});
        
        if(che == undefined){
            alert("공고를 선택해주세요.");
        } else {
            const { IMP } = window;
            IMP.init('imp36894634'); 
            
            
            IMP.request_pay({
                pg : 'html5_inicis',
                pay_method : 'card',
                merchant_uid : 'merchant_' + new Date().getTime(),
                name : '랭크업 상품',
                amount : $( '#modal_total9' ).text().replace(/[^0-9]/g, ""),
                buyer_email: userEmail,
                buyer_name: userName,
            }, function(rsp) {
                if ( rsp.success ) {
                    var result = {
                        "imp" : rsp.imp_uid,
                        "merchant" : rsp.merchant_uid,
                        "amount" : rsp.paid_amount,
                        "cardno" : rsp.apply_num,
                        "userNo" : userNo,
                        "jvNo" : che,
                        "date" : date,
                        "orderNo" : orderNo,
                        "startDate" : startDate
                        }
                        console.log("결제성공 " + msg);
                        $.ajax({
                            url : '/company/mypage/payment', 
                            type :'POST',
                            data : JSON.stringify(result),
                            contentType:'application/json;charset=utf-8',
                            dataType: 'json', 
                            success: function(res){
                            console.log(res);	
                                                    
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
                  document.location.href="/company/mypage/paymentFinish";    
                    
                } else {
                    var msg = '결제에 실패하였습니다.';
                    msg += '에러내용 : ' + rsp.error_msg;
                    alert(msg);
                    document.location.href="/main";
                }
            
            
            });
        }
       
    });

    
	

	


});


