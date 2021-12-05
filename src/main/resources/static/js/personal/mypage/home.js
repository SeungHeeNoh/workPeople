

        if(document.querySelector(".orange1") != null) {
            let deleteBtn = document.querySelector(".orange1"),
                rNo = deleteBtn.value;

            deleteBtn.addEventListener('click', deleteResume);


            function deleteResume() {

                let deleteYN = confirm("이력서를 삭제하시겠습니까?");

                if (deleteYN) {
                    location.href = "/personal/mypage/home/resumeDelete/" + rNo;
                }
            }
        }



        let applyBtn = document.querySelectorAll(".content_title_text4_btn"),
            applyBtnNo = new Array(applyBtn.length);



        for(let i=0; i<applyBtn.length; i++) {
            applyBtnNo[i] = applyBtn[i].value;

            applyBtn[i].addEventListener('click', applyResume);

            function applyResume() {

                if (statusYResume === null) {
                    alert("대표 이력서를 등록해주세요.");
                    location.href = "/personal/mypage/resumeManagement";
                } else {
                    let applyYN = confirm("현재 대표이력서로 해당 공고에 즉시지원 하시겠습니까?");

                    let rNo = document.querySelector(".orange1").value;

                    if (applyYN) {
                        location.href = "/personal/mypage/home/applyResume/" + rNo + "," + applyBtnNo[i];
                    }
                }


            }
        }

        <!-- Initialize Swiper -->

            var swiper = new Swiper(".mySwiper", {
            slidesPerView: 1,
            spaceBetween: 30,
            loop: true,
            pagination: {
            el: ".swiper-pagination",
            clickable: true,
        },
            navigation: {
            nextEl: ".swiper-button-next",
            prevEl: ".swiper-button-prev",
        },
        });

        let applyCompanyStatus = document.getElementById("applyCompanyStatus"),
            resumeBrowseStatus = document.getElementById("resumeBrowseStatus"),
            scrapStatus = document.getElementById("scrapStatus"),
            interestedCompanyStatus = document.getElementById("interestedCompanyStatus"),

            applyCompanyText = document.getElementById("applyCompanyText"),
            resumeBrowseText = document.getElementById("resumeBrowseText"),
            scrapStatusText = document.getElementById("scrapStatusText"),
            interestedCompanyText = document.getElementById("interestedCompanyText");

        applyCompanyText.addEventListener('click',applyCompanyEvent);
        resumeBrowseText.addEventListener('click',resumeBrowseEvent);
        scrapStatusText.addEventListener('click',scrapEvent);
        interestedCompanyText.addEventListener('click',interestedCompanyEvent);




        function applyCompanyEvent(){
            displayNone();
            applyCompanyStatus.style.display="block";
        }
        function resumeBrowseEvent(){
            displayNone();
            resumeBrowseStatus.style.display="block";
        }
        function scrapEvent(){
            displayNone();
            scrapStatus.style.display="block";
        }
        function interestedCompanyEvent(){
            displayNone();
            interestedCompanyStatus.style.display="block";
        }

        function displayNone(){
            applyCompanyStatus.style.display="none";
            resumeBrowseStatus.style.display="none";
            scrapStatus.style.display="none";
            interestedCompanyStatus.style.display="none";
        }



        let applyCompanyEventPageMove = document.querySelectorAll(".applyCompanyEvent"),
            resumeBrowseEventPageMove = document.querySelectorAll(".resumeBrowseEvent"),
            scrapEventPageMove = document.querySelectorAll(".scrapEvent"),
            interestedCompanyEventPageMove = document.querySelectorAll(".interestedCompanyEvent");


        for(let i=0; i<applyCompanyEventPageMove.length; i++) {
            applyCompanyEventPageMove[i].addEventListener('click', pageMove1);
        }
        for(let i=0; i<resumeBrowseEventPageMove.length; i++) {
            resumeBrowseEventPageMove[i].addEventListener('click', pageMove2);
        }
        for(let i=0; i<scrapEventPageMove.length; i++) {
            scrapEventPageMove[i].addEventListener('click', pageMove3);
        }
        for(let i=0; i<interestedCompanyEventPageMove.length; i++) {
            interestedCompanyEventPageMove[i].addEventListener('click', pageMove4);
        }

        function pageMove1() {
            location.href = "/personal/mypage/applyCompany";
        }
        function pageMove2() {
            location.href = "/personal/mypage/resumeBrowseCompany";
        }
        function pageMove3() {
            location.href = "/personal/mypage/scrap";
        }
        function pageMove4() {
            location.href = "/personal/mypage/interestedCompany";
        }




