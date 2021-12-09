$(function() {

    // 전화번호 입력칸
    function autoHypenPhone(str){
        str = str.replace(/[^0-9]/g, '');
        var tmp = '';
        if( str.length < 4){
            return str;
        }else if(str.length < 7){
            tmp += str.substr(0, 3);
            tmp += '-';
            tmp += str.substr(3);
            return tmp;
        }else if(str.length < 11){
            tmp += str.substr(0, 3);
            tmp += '-';
            tmp += str.substr(3, 3);
            tmp += '-';
            tmp += str.substr(6);
            return tmp;
        }else{
            tmp += str.substr(0, 3);
            tmp += '-';
            tmp += str.substr(3, 4);
            tmp += '-';
            tmp += str.substr(7);
            return tmp;
        }
        return str;
    }

    var cellPhone = document.getElementById('cellPhone');
    cellPhone.onkeyup = function(event){
        event = event || window.event;
        var _val = this.value.trim();
        this.value = autoHypenPhone(_val) ;
    }

    // $(document).ready(function (){
    //     $("#educationType1").on('click',function (){
    //         $("#educationType1").css("background-color","")
    //
    //     });
    //
    // });







});

let educationType1 = document.getElementById('educationType1'),
    educationType2 = document.getElementById('educationType2'),
    educationType3 = document.getElementById('educationType3'),
    educationType4 = document.getElementById('educationType4'),
    EducationeType= document.getElementById('EducationeType'),
    highSchoolFormAll= document.getElementById('highSchoolFormAll'),
    highSchoolForm= document.getElementById('highSchoolForm'),
    ColleageForm= document.getElementById('ColleageForm');

educationType1.addEventListener('click',educationType1Func);
educationType2.addEventListener('click',educationType2Func);
educationType3.addEventListener('click',educationType3Func);
educationType4.addEventListener('change',educationType4Func);

function educationType1Func(){
    educationTypeStyleNone();
    educationType1.style.backgroundColor = "#F9E2AE";
    EducationeType.value = '고등학교 졸업 미만';

    highSchoolFormAll.style.display = "none";
    ColleageForm.style.display = "none";

}
function educationType2Func(){
    educationTypeStyleNone();
    educationType2.style.backgroundColor = "#F9E2AE";
    EducationeType.value = '고등학교 졸업';

    highSchoolFormAll.style.display = "block";
    ColleageForm.style.display = "none";

}
function educationType3Func(){
    educationTypeStyleNone();
    educationType3.style.backgroundColor = "#F9E2AE";
    EducationeType.value = '대학교 졸업 이상';

    highSchoolFormAll.style.display = "block";
    ColleageForm.style.display = "block";


}
function educationType4Func(){
    if(this.checked){
        EducationeType.value = '검정고시';

        highSchoolForm.style.display = "none";
        ColleageForm.style.display = "none";

    } else{
        highSchoolForm.style.display = "block";
    }
}

function educationTypeStyleNone(){
    educationType1.style.backgroundColor = "white";
    educationType2.style.backgroundColor = "white";
    educationType3.style.backgroundColor = "white";
}

// input type = 'file' 태그 (imgfile)에 변화가 있을 때
document.getElementById('singleFile').addEventListener('change',function(){
    // 만약 파일이 존재한다면
    if(this.files && this.files[0]){
        // FileReader 객체 생성
        let reader = new FileReader();
        // 파일 내용을   읽어들여 dataURL 형식의 문자열로 설정
        reader.readAsDataURL(this.files[0]);
        // 읽어들이기 성공했을 때 호출되는 이벤트 핸들러 작성
        reader.onload = function(){
            console.log(reader.result);
            // div에 이미지 넣기 (src 속성에 result 넣기)
            document.getElementById('content-basicInfo-img-container').innerHTML = "<img src = '"+reader.result+"' style='width: 120px;height: 160px;'>";
        }

    }
});


let careerType1 = document.getElementById("careerType1"),
    careerType2 = document.getElementById("careerType2"),
    careerAllContainer = document.querySelector(".careerAllContainer"),
    careerYN = document.getElementById("careerYN");

careerType1.addEventListener('click',careerType1Func);
careerType2.addEventListener('click',careerType2Func);

function careerType1Func(){
    careerType1.style.backgroundColor = "#F9E2AE";
    careerType2.style.backgroundColor = "white";
    careerAllContainer.style.display = "none";
    careerYN.value = 'N';
}

function careerType2Func(){
    careerType1.style.backgroundColor = "white";
    careerType2.style.backgroundColor = "#F9E2AE";
    careerAllContainer.style.display = "block";
    careerYN.value = 'Y';
}


let addCareer = document.getElementById("addCareer"),
    careerWrap = document.querySelector(".careerWrap"),
    careerWrap2 = document.getElementById("careerWrap"),
    deleteCareer = document.getElementById("deleteCareer");


addCareer.addEventListener('click',addCareerFunc);
// deleteCareer.addEventListener('click',deleteCareerFunc);

let careerClassNum = 2;
function addCareerFunc(){

    let copy = careerWrap.cloneNode(true);
    copy.className = 'careerContentNum'+careerClassNum;
    careerWrap2.append(copy);

    careerClassNum+=1;
}














let content4 = document.querySelector(".content4"),
    content5 = document.querySelector(".content5"),
    content6 = document.querySelector(".content6"),
    content7 = document.querySelector(".content7"),
    content8 = document.querySelector(".content8"),
    internForms = document.getElementById("internForms"),
    licenseForm = document.getElementById("licenseForm"),
    languageForm = document.getElementById("languageForm"),
    awardsForm = document.getElementById("awardsForm"),
    selfIntroduceForm = document.getElementById("selfIntroduceForm");


content4.addEventListener('click',content4Func);
content5.addEventListener('click',content5Func);
content6.addEventListener('click',content6Func);
content7.addEventListener('click',content7Func);
content8.addEventListener('click',content8Func);

let clickNum = 0;
function content4Func(){

    if(clickNum%2===0){
        internForms.style.display = 'block';
        content4.style.color='#85CBCC';
    } else{
        internForms.style.display = 'none';
        content4.style.color='#979797';
    }
    clickNum+=1;
}

let clickNum2 = 0;
function content5Func(){

    if(clickNum2%2===0){
        licenseForm.style.display = 'block';
        content5.style.color='#85CBCC';
    } else{
        licenseForm.style.display = 'none';
        content5.style.color='#979797';
    }
    clickNum2+=1;
}

let clickNum3 = 0;
function content6Func(){

    if(clickNum3%2===0){
        languageForm.style.display = 'block';
        content6.style.color='#85CBCC';
    } else{
        languageForm.style.display = 'none';
        content6.style.color='#979797';
    }
    clickNum3+=1;
}

let clickNum4 = 0;
function content7Func(){

    if(clickNum4%2===0){
        awardsForm.style.display = 'block';
        content7.style.color='#85CBCC';
    } else{
        awardsForm.style.display = 'none';
        content7.style.color='#979797';
    }
    clickNum4+=1;
}

let clickNum5 = 0;
function content8Func(){

    if(clickNum5%2===0){
        selfIntroduceForm.style.display = 'block';
        content8.style.color='#85CBCC';
    } else{
        selfIntroduceForm.style.display = 'none';
        content8.style.color='#979797';
    }
    clickNum5+=1;
}







