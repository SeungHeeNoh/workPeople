$(function() {

    /* 숫자랑 하이픈만 받기(phone) */
    $("#phone").keyup(function() {
      $(this).val( $(this).val().replace(/[^0-9\-]/gi,"") );
    });
  
    /* 비밀번호 변경 창 */
    $("#devBtnChangePwd").click(function(){
		if($(".devPwdChangeArea").css('display') == 'none') {
		    $(".devPwdChangeArea").css('display','table');
		} else  {
		    $(".devPwdChangeArea").css('display','none');
		}
    });

	/* 비밀번호 밀치여부 및 형식 확인 */
    $('.pw').focusout(function(){
        var pwd1 = $("#devNewPwd_1").val();
        var pwd2 = $("#devNewPwd_2").val();

        if(!/(?=.*[a-zA-Z](?=.*[0-9])(?=.*[^a-zA-Z0-9])).{8,16}/.test(pwd1)){
            $(".check_notice").css('display','inline-block');
            $("#devNewPwd_2").attr("readonly", true);
        } else {
            $(".check_notice").css('display','none');
            $("#devNewPwd_2").attr("readonly", false);
        }

        if(pwd1 !='' && pwd2 ==''){
            null;
        } else if(pwd1 !="" || pwd2 !=""){
            if(pwd1 == pwd2){
                $(".check_success").css('display','inline-block');
                $(".check_danger").css('display','none');
            } else {
                $(".check_danger").css('display','inline-block');
                $(".check_success").css('display','none');
            }

        } 

    });
   
   
    /* submit */
    $("#devBtnSubmit").click(function(){
    	var pwd1 = $("#devNewPwd_1").val();
        var pwd2 = $("#devNewPwd_2").val();
      
       if(pwd1 !='' && pwd2 !=''){
	   		if(pwd1 == pwd2){
	   			if(confirm("회원 정보를 수정하시겠습니까?")){
	   				$("#update_form").submit();
	   			}
	   		} else {
	   		     alert("새로 작성한 비밀번호가 일치하지 않습니다.");
   			}
        } else if (pwd1 =='' && pwd2 ==''){
         	if(confirm("회원 정보를 수정하시겠습니까?")){
	   				$("#update_form").submit();
	   			}
        }
        
       
		
    });
   
   
   
   
   
});

    
    
    
