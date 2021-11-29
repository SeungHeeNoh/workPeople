var $layerPopup = document.querySelector('.popup_wrap');
var $btnLayerPopupClose = document.querySelector('.popup_wrap .btnClose');
var $btnLayerPopupTodayHide = document.querySelector('.popup_wrap .btnTodayHide');

// 최초 레이어팝업 노출 (testCookie라는 이름의 쿠키가 존재하지 않으면 레이어 노출)
if(!$.cookie('testCookie')){
	layerPopupShow();
}

// 팝업 닫기 클릭
$btnLayerPopupClose.addEventListener('click', function(){
    layerPopupHide(0);
});

// 팝업 오늘 하루 보지 않기 클릭
$btnLayerPopupTodayHide.addEventListener('click', function(){
    layerPopupHide(1);
});

// 팝업 노출
function layerPopupShow(){
    $layerPopup.style.display = 'block'
}

// 팝업 비노출
 function layerPopupHide(state){
     $layerPopup.style.display = 'none'

     if(state === 1){
        if($.cookie('testCookie') == undefined){
            $.cookie('testCookie', 'Y', { expires: 1, path: '/'});
        }
    }
 }
