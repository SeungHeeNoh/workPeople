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


