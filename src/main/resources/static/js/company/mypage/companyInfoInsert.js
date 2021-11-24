// input 숫자, 날짜 작성
$(function() {

    // 두 칸 모두 숫자만 입력되도록
    $("#number").keypress(function(event) {
      if (event.which < 48 || event.which > 57) {
        event.preventDefault();
      }
    })
    $("#date").keypress(function(event) {
      if (event.which < 48 || event.which > 57) {
        event.preventDefault();
      }
    })
  
    var RegNotNum = /[^0-9]/g;
  
    /* 1. 숫자 */
    $("#number").keyup(function() {
      this.value = this.value.replace(RegNotNum, '');
    });
  
    /* 2. 날짜 */
    $("#date").attr("maxlength", 10); // 최대길이 설정
    $("#date").keyup(function() {
  
      var date = this.value;
  
      date = date.replace(RegNotNum, ''); // 숫자만 남기기
  
      if (date == "" || date == null || date.length < 5) {
        this.value = date;
        return;
      }
  
      var DataFormat;
      var RegPhonNum;
  
      // 날짜 포맷(yyyy-mm-dd) 만들기 
      if (date.length <= 6) {
        DataFormat = "$1-$2"; // 포맷을 바꾸려면 이곳을 변경
        RegPhonNum = /([0-9]{4})([0-9]+)/;
      } else if (date.length <= 8) {
        DataFormat = "$1-$2-$3"; // 포맷을 바꾸려면 이곳을 변경
        RegPhonNum = /([0-9]{4})([0-9]{2})([0-9]+)/;
      }
  
      date = date.replace(RegPhonNum, DataFormat);
  
      this.value = date;
  
      // 모두 입력됐을 경우 날짜 유효성 확인
      if (date.length == 10) {
  
        var isVaild = true;
  
        if (isNaN(Date.parse(date))) {
          // 유효 날짜 확인 여부
          isVaild = false;
        } else {
  
          // 년, 월, 일 0 이상 여부 확인
          var date_sp = date.split("-");
          date_sp.forEach(function(sp) {
            if (parseInt(sp) == 0) {
              isVaild = false;
            }
          });
  
          // 마지막 일 확인
          var last = new Date(new Date(date).getFullYear(), new Date(date).getMonth()+1, 0);
          // 일이 달의 마지막날을 초과했을 경우 다음달로 자동 전환되는 현상이 있음 (예-2월 30일 -> 3월 1일)
          if (parseInt(date_sp[1]) != last.getMonth()+1) {
                      var date_sp2 = date_sp.slice(0);
                      date_sp2[2] = '01';
                      var date2 = date_sp2.join("-");
                      last = new Date(new Date(date2).getFullYear(), new Date(date2).getMonth()+1, 0);
                  }
          if (last.getDate() < parseInt(date_sp[2])) {
            isVaild = false;
          }
        }
  
        if (!isVaild) {
          alert("잘못된 날짜입니다. \n다시 입력하세요.");
          this.value = "";
          this.focus();
          return;
        }
      }
    });
  });
// input 숫자, 날짜 작성 

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
      var $me = $(this);
      var selectedFileName = $me.val();
      alert(selectedFileName);
      selectedFileName = CorpInfo.Util.Path.getFileName(selectedFileName);
      
      var logoFileName = $('#devSelectLogoName');

      var fileExt = CorpInfo.Util.Path.getExtension(selectedFileName).toLowerCase();
      if (fileExt !== 'jpeg' && fileExt !== 'jpg' && fileExt !== 'png') {
          $('#devSelectLogo').val('');
          logoFileName.html('');
          alert('파일 형식이 올바르지 않습니다.');
          return false;
      }
      else {
          logoFileName.html(selectedFileName);
      }
  })

  /* 로고 삭제시 */
  $('#devDeleteLogo').on('click', function () {
      if (parent && parent.corpView && parent.corpView.onDeleteLogo) {
          parent.corpView.onDeleteLogo('C');
      }
  })

  /* 로고 업로드 레이어 닫기 */
  $('#devCloseLayer').on('click', function () {
      if (parent && parent.corpView && parent.corpView.closeLogoLy) {
          parent.corpView.closeLogoLy();
      }
  })

  /* 로고 업로드 */
  $('#devSubmit').on('click', function () {
      if (isValidForm()) {
          var ua = navigator.userAgent.toLowerCase();
          if (ua.indexOf('msie') > -1 || ua.indexOf('trident') > -1 || ua.indexOf('edge') > -1) {     
              document.charset = "euc-kr";
	      }
          $('#frmLogo').submit();
         
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
    
    
    
    
});