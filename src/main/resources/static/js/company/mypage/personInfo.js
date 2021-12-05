$(function() {
	    // 게시글 목록에 mouseover/mouseout 시 onmouseover 클래스 추가/제거 처리
		const mtcSchListTb = document.querySelector('.table-list');
		
		mtcSchListTb.addEventListener('mouseover', function(){
			
			if(event.target.classList.contains('person-info_tr'))
				event.target.classList.add('onmouseover');
			else if(event.target.parentNode.classList.contains('person-info_tr'))
				event.target.parentNode.classList.add('onmouseover');
		});
		
		mtcSchListTb.addEventListener('mouseout', function(){
			
			if(event.target.classList.contains('person-info_tr'))
				event.target.classList.remove('onmouseover');
			else if(event.target.parentNode.classList.contains('person-info_tr'))
				event.target.parentNode.classList.remove('onmouseover');
			
		});
		
		/* 스크랩 인재  */
		const heartSvg = document.querySelectorAll('.button__favorite');
		const heartPath = document.querySelectorAll('.button__favorite img');
		const rno = document.querySelectorAll('.rno');
		
		const hs = document.querySelectorAll('.button__favorite , .btnimg');
		
		
			
		heartSvg.forEach( (hs) =>   {
			hs.addEventListener('click', (e) => changeClass(e));
		});
		
		function changeClass(e){
			let heartSvg = e.currentTarget,
				heartPath = heartSvg.querySelector(".button__favorite img"),
				rno = heartSvg.querySelector(".rno").value;
		
			if(heartSvg.classList.contains("like-default")){
				if(confirm("해당 이력서를 스크랩 인재에서 삭제하시겠습니까?")){
					heartSvg.classList.remove("like-default");
					heartSvg.classList.add("like-fill");
					console.log(heartPath);
					heartPath.setAttribute('src','/images/companyMyPage/nonescrap.png');
					nonescrap(rno);
				}
				
			}
			else{
				if(confirm("해당 이력서를 스크랩 하시겠습니까?")){
				console.log(heartPath);
				 	heartSvg.classList.remove("like-fill");
				 	heartSvg.classList.add("like-default");
				 	heartPath.setAttribute('src','/images/companyMyPage/scrap.png');
				     scrap(rno);
				}
			  }
		
			}
		
		 
		
		function scrap(rno) {
		  	 
			
			var result = {"rno" : rno}
                    
				$.ajax({
                            url : '/company/mypage/scrap', 
                            type :'POST',
                            data : JSON.stringify(result),
                            contentType:'application/json;charset=utf-8',
                            dataType: 'json', 
                            beforeSend: function (jqXHR, settings) {
				           			var header = $("meta[name='_csrf_header']").attr("content");
						            var token = $("meta[name='_csrf']").attr("content");
						            jqXHR.setRequestHeader(header, token);
							}
							}).done(function (rData, textStatus, jqXHR) {
								if(rData > 0){
									alert("해당 이력서가 스크랩 되었습니다.");
									if(confirm("스크랩한 이력서 목록을 확인하시겠습니까?")){
										document.location.href="/company/mypage/scrapPersonInfoList";    
									}   
								} else {
									alert("해당 이력서의 스크랩을 실패했습니다.");
								}
							}).fail(function (rData, textStatus, errorThrown) {
								alert("통신 실패!! 상담원에게 문의주세요!");
							})
                          
          	}   
		
		
	    
	 
	function nonescrap(rno) {
		 
		   
			var result = {"rno" : rno}
                    
				$.ajax({
                            url : '/company/mypage/nonescrap', 
                            type :'POST',
                            data : JSON.stringify(result),
                            contentType:'application/json;charset=utf-8',
                            dataType: 'json', 
                            beforeSend: function (jqXHR, settings) {
				           			var header = $("meta[name='_csrf_header']").attr("content");
						            var token = $("meta[name='_csrf']").attr("content");
						            jqXHR.setRequestHeader(header, token);
							}
							}).done(function (rData, textStatus, jqXHR) {
								if(rData > 0){
									alert("해당 이력서를 스크랩에서 삭제하였습니다.");
									document.location.href=location.href;    
								} else {
									alert("해당 이력서의 스크랩 삭제를 실패했습니다.");
								}
							}).fail(function (rData, textStatus, errorThrown) {
								alert("통신 실패!! 상담원에게 문의주세요!");
							})
        			  
        			  
	 }

   
    
});