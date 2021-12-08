// input 숫자 작성
$(function() {

    // 숫자만 입력되도록
    $("#number").keypress(function(event) {
      if (event.which < 48 || event.which > 57) {
        event.preventDefault();
      }
    })
  
    var RegNotNum = /[^0-9]/g;
  
    /* 숫자 */
    $("#number").keyup(function() {
      this.value = this.value.replace(RegNotNum, '');
    });
  
   
  });
// input 숫자 작성 

// 글자 수 카운팅
  $(document).ready(function() {
    $('#business_detail').on('keyup', function() {
        $('#counter').html($(this).val().length+"/ 50");
        $('#counter').css("color","red");

        if($(this).val().length == 0) {
            $('#counter').css("color","#545454");
        } else {
            $('#counter').css("color","#F3C995");
        }

        if($(this).val().length > 50) {
            alert("최대 50자까지 입력 가능합니다.");
            $(this).val($(this).val().substring(0, 50));
            $('#counter').html("50 / 50");
        }
    
     });
  });
$(document).ready(function() {
  $('#lb_History').on('keyup', function() {
      $('#tecounter1').html($(this).val().length+"/ 1000");
      $('#tecounter1').css("color","red");

      if($(this).val().length == 0) {
          $('#tecounter1').css("color","#545454");
      } else {
          $('#tecounter1').css("color","#F3C995");
      }

      if($(this).val().length > 1000) {
          alert("최대 1000자까지 입력 가능합니다.");
          $(this).val($(this).val().substring(0, 1000));
          $('#tecounter1').html("1000 / 1000");
      }
  
  });
});
$(document).ready(function() {
  $('#lb_overview').on('keyup', function() {
      $('#tecounter2').html($(this).val().length+"/ 1000");
      $('#tecounter2').css("color","red");

      if($(this).val().length == 0) {
          $('#tecounter2').css("color","#545454");
      } else {
          $('#tecounter2').css("color","#F3C995");
      }

      if($(this).val().length > 1000) {
          alert("최대 1000자까지 입력 가능합니다.");
          $(this).val($(this).val().substring(0, 1000));
          $('#tecounter2').html("1000 / 1000");
      }
  
  });
});
// 글자 수 카운팅



// 로고 팝업창 숨기기
function dis(){
  if($('#dis').css('display') == 'none'){
  $('#dis').show();
  }else{
  $('#dis').hide();
  }
}  
// 로고 팝업창 숨기기

// 로고 팝업창 

$(function() {


  /* 파일선택 완료시 */
  $('#devSelectLogo').on('change', function () {
  
  	var $fileLogo = $('#devSelectLogo');
	var selectedFileName = $fileLogo.val();
  	var FileName = selectedFileName.substr(12);
  	
  	$('#devSelectLogoName').text(FileName);
  
  })

  /* 로고 삭제시 */
  $('#devLogoDel').on('click', function () {
  
  	if(confirm("로고를 삭제하시겠습니까?")){
     	$.ajax({
		    url: "/company/mypage/deleteFile",
		    type: "POST",
		    data: new FormData($("#devInfoForm")[0]),
		    enctype: 'multipart/form-data',
		    processData: false,
		    contentType: false,
		    cache: false,
		    success: function (date) {
		    	if(date > 0){
		    	   alert("로고가 삭제됐습니다.");
		    	  	 $('.logoBefore').css("display","block");
   					 $('.logoAfter').css("display","none");
		    	} else {
		    	 alert("로고 삭제에 실패했습니다.");
		    	}
		     
		    },
		    error: function () {
		      alert("통신 실패!! 상담원에게 문의주세요!");
		    }
		  });
     	
	      }
   
   	 
   	 
  })

  /* 로고 업로드 레이어 닫기 */
  $('#devLogoModify').on('click', function () {
     $('#dis').show();
  })

  /* 로고 업로드 */
  $('#devSubmit').on('click', function () {
    
      if (isValidForm()) {
       if(confirm("로고를 등록하시겠습니까?")){
	     	$.ajax({
			    url: "/company/mypage/uploadFile",
			    type: "POST",
			    data: new FormData($("#devInfoForm")[0]),
			    enctype: 'multipart/form-data',
			    processData: false,
			    contentType: false,
			    cache: false,
			    success: function (date) {
			    	if(date > 0){
			    	   alert("로고가 등록됐습니다.");
			    	   $('.logoBefore').css("display","none");
				   	   $('.logoAfter').css("display","block");
				       $('#dis').hide();
				     	preview();
			    	} else {
			    	 alert("로고 등록에 실패했습니다.");
			    	}
			     
			    },
			    error: function () {
			      alert("통신 실패!! 상담원에게 문의주세요!");
			    }
			  });
	     	
	     	
	      }
	     } 
	  })
	
	
	var isValidForm = function () {
	var $fileLogo = $('#devSelectLogo');
	var selectedFileName = $fileLogo.val();
	
	
	  if (!selectedFileName) {
	      alert('로고를 선택해 주십시오.');
	      return false;
	  }
	
	  return true;
     
    }
    
    /* input type file 요소들 */
	let fileElements = document.querySelector("#devSelectLogo");
	/* div image_area 요소들 */
	let imageArea = document.querySelector(".logo");
	
	
	function preview(){
		if(fileElements.files && fileElements.files[0]){
			let reader = new FileReader();
			reader.readAsDataURL(fileElements.files[0]);
			reader.onload = function(){
				imageArea.innerHTML = '<img id="logoimg" src="' + reader.result + '">';
				let image = document.querySelector("#logoimg");
				image.width = "188";
				image.height = "79";
			}
		}
		
	}
    
    

    
    
});