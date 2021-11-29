package com.kh.workPeople.common.vo;

import java.util.Date;

public class ResumeDetails {

    private int rNo;                    // 이력서번호
    private String biTitle;             // 이력서 제목
    private String biName;              // 이름
    private String biGender;            // 성별
    private Date biBirthDate;           // 생년월일

    private String biBirthDateYearFormat;       // 생년월일 년도만 문자열 포멧팅(ex : 1994)

    private int biAge;                  // 나이(한국식나이) int로 포멧팅 (ex : 28)
    private int biAgeInFull;            // 나이(만나이ㅏ) int로 포멧팅(ex : 27)
    
    private String biEmail;             // 이메일
    private String biPhone;             // 전화번호(000-0000-000)
    private String biAddress;           // 주소
    private String biAddressDetail;     // 상세주소
    private int sNo;                    // 업종 번호
    private int aNo;                    // 첨부파일번호
    private String eType;               // 학력구분(고졸미만,검정고시, 고졸, 대졸이상)
    private String eHighName;           // 고등학교이름
    private String eHighMajor;          // 고등학교 전공계열
    private Date eHighAdmission;        // 고등학교 입학 년월
    private Date eHighGraduation;       // 고등학교 졸업 년월

    private String eHighAdmissionFormat;    // 고등학교 입학년월 문자열 포멧팅(ex : 2000.02)
    private String eHighGraduationFormat;   // 고등학교 졸업년월 문자열 포멧팅(ex : 2000.02)
    
    private String eColleageType;       // 대학교 학력 구분(전문학사,학사)
    private String eColleageName;       // 대학교 이름
    private Date eColleageAdmission;    // 대학교 입학년월
    
    private String eColleageAdmissionFormat;  // 대학교 입학년월 문자열 포멧팅 (ex : 2000.02)
    
    private String eColleageAdmissionType;  // 대학교 입학 구분(입학,편입)
    private Date eColleageGraduate;     // 대학 졸업년월
    
    private String eColleageGraduateFormat;     // 대학교 졸업년월 문자열 포멧팅 (ex : 2000.02)
    
    private String eColleageGraduateType;   // 대학 졸업구분(졸업,재학중,휴학중,자퇴,졸업예정,재학중)
    private String eColleageMajor;      // 대학 전공
    private String eColleageCredit;     // 대학 학점
    private String eColleageStandardCredit;     // 대학 기준 학점
    private String eMasterName;         // 대학원(석사) 이름
    private Date eMasterAdmission;          // 대학원(석사) 입학년월
    
    private String eMasterAdmissionFormat;  // 대학원(석사) 입학년월 문자열 포멧팅
    
    private String eMasterAdmissionType;    // 대학원(석사) 입학 구분
    private Date eMasterGraduate;           // 대학원(석사) 졸업년월
    
    private String eMasterGraduateFormat;   // 대학원(석사) 졸업년월 문자열 포멧팅
    
    private String eMasterGraduateType;     // 대학원(석사) 졸업구분
    private String eMasterMajor;            // 대학원(석사)전공
    private String eMasterCredit;           // 대학원(석사)학점
    private String eMasterStandardCredit;      // 대학원(석사) 기준학점
    private String eDoctorName;             // 대학원(박사) 이름
    private Date eDoctorAdmission;          // 대학원(박사) 입학년월
    
    private String eDoctorAdmissionFormat;  // 대학원(박사) 입학년월 문자열 포멧팅
    
    private String eDoctorAdmissionType;    // 대학원(박사) 입학구분
    private Date eDoctorGraduate;           // 대학원(박사) 졸업년월
    
    private String eDoctorGraduateFormat;   // 대학원(박사) 졸업년월 포멧팅
    
    private String eDoctorGraduateType;      // 대학원(박사)졸업구분
    private String eDoctorMajor;            // 대학원(박사) 전공
    private String eDoctorCredit;           // 대학원(박사)학점
    private String eDoctorStandardCredit;       // 대학원(박사) 기준학점

    public ResumeDetails() {
    }

    public ResumeDetails(int rNo, String biTitle, String biName, String biGender, Date biBirthDate, int biAge, String biEmail, String biPhone, String biAddress, String biAddressDetail, int sNo, int aNo, String eType, String eHighName, String eHighMajor, Date eHighAdmission, Date eHighGraduation, String eColleageType, String eColleageName, Date eColleageAdmission, String eColleageAdmissionType, Date eColleageGraduate, String eColleageGraduateType, String eColleageMajor, String eColleageCredit, String eColleageStandardCredit, String eMasterName, Date eMasterAdmission, String eMasterAdmissionType, Date eMasterGraduate, String eMasterGraduateType, String eMasterMajor, String eMasterCredit, String eMasterStandardCredit, String eDoctorName, Date eDoctorAdmission, String eDoctorAdmissionType, Date eDoctorGraduate, String eDoctorGraduateType, String eDoctorMajor, String eDoctorCredit, String eDoctorStandardCredit) {
        this.rNo = rNo;
        this.biTitle = biTitle;
        this.biName = biName;
        this.biGender = biGender;
        this.biBirthDate = biBirthDate;
        this.biAge = biAge;
        this.biEmail = biEmail;
        this.biPhone = biPhone;
        this.biAddress = biAddress;
        this.biAddressDetail = biAddressDetail;
        this.sNo = sNo;
        this.aNo = aNo;
        this.eType = eType;
        this.eHighName = eHighName;
        this.eHighMajor = eHighMajor;
        this.eHighAdmission = eHighAdmission;
        this.eHighGraduation = eHighGraduation;
        this.eColleageType = eColleageType;
        this.eColleageName = eColleageName;
        this.eColleageAdmission = eColleageAdmission;
        this.eColleageAdmissionType = eColleageAdmissionType;
        this.eColleageGraduate = eColleageGraduate;
        this.eColleageGraduateType = eColleageGraduateType;
        this.eColleageMajor = eColleageMajor;
        this.eColleageCredit = eColleageCredit;
        this.eColleageStandardCredit = eColleageStandardCredit;
        this.eMasterName = eMasterName;
        this.eMasterAdmission = eMasterAdmission;
        this.eMasterAdmissionType = eMasterAdmissionType;
        this.eMasterGraduate = eMasterGraduate;
        this.eMasterGraduateType = eMasterGraduateType;
        this.eMasterMajor = eMasterMajor;
        this.eMasterCredit = eMasterCredit;
        this.eMasterStandardCredit = eMasterStandardCredit;
        this.eDoctorName = eDoctorName;
        this.eDoctorAdmission = eDoctorAdmission;
        this.eDoctorAdmissionType = eDoctorAdmissionType;
        this.eDoctorGraduate = eDoctorGraduate;
        this.eDoctorGraduateType = eDoctorGraduateType;
        this.eDoctorMajor = eDoctorMajor;
        this.eDoctorCredit = eDoctorCredit;
        this.eDoctorStandardCredit = eDoctorStandardCredit;
    }

    public ResumeDetails(int rNo, String biTitle, String biName, String biGender, Date biBirthDate, String biBirthDateYearFormat, int biAge, int biAgeInFull, String biEmail, String biPhone, String biAddress, String biAddressDetail, int sNo, int aNo, String eType, String eHighName, String eHighMajor, Date eHighAdmission, Date eHighGraduation, String eHighAdmissionFormat, String eHighGraduationFormat, String eColleageType, String eColleageName, Date eColleageAdmission, String eColleageAdmissionFormat, String eColleageAdmissionType, Date eColleageGraduate, String eColleageGraduateFormat, String eColleageGraduateType, String eColleageMajor, String eColleageCredit, String eColleageStandardCredit, String eMasterName, Date eMasterAdmission, String eMasterAdmissionFormat, String eMasterAdmissionType, Date eMasterGraduate, String eMasterGraduateFormat, String eMasterGraduateType, String eMasterMajor, String eMasterCredit, String eMasterStandardCredit, String eDoctorName, Date eDoctorAdmission, String eDoctorAdmissionFormat, String eDoctorAdmissionType, Date eDoctorGraduate, String eDoctorGraduateFormat, String eDoctorGraduateType, String eDoctorMajor, String eDoctorCredit, String eDoctorStandardCredit) {
        this.rNo = rNo;
        this.biTitle = biTitle;
        this.biName = biName;
        this.biGender = biGender;
        this.biBirthDate = biBirthDate;
        this.biBirthDateYearFormat = biBirthDateYearFormat;
        this.biAge = biAge;
        this.biAgeInFull = biAgeInFull;
        this.biEmail = biEmail;
        this.biPhone = biPhone;
        this.biAddress = biAddress;
        this.biAddressDetail = biAddressDetail;
        this.sNo = sNo;
        this.aNo = aNo;
        this.eType = eType;
        this.eHighName = eHighName;
        this.eHighMajor = eHighMajor;
        this.eHighAdmission = eHighAdmission;
        this.eHighGraduation = eHighGraduation;
        this.eHighAdmissionFormat = eHighAdmissionFormat;
        this.eHighGraduationFormat = eHighGraduationFormat;
        this.eColleageType = eColleageType;
        this.eColleageName = eColleageName;
        this.eColleageAdmission = eColleageAdmission;
        this.eColleageAdmissionFormat = eColleageAdmissionFormat;
        this.eColleageAdmissionType = eColleageAdmissionType;
        this.eColleageGraduate = eColleageGraduate;
        this.eColleageGraduateFormat = eColleageGraduateFormat;
        this.eColleageGraduateType = eColleageGraduateType;
        this.eColleageMajor = eColleageMajor;
        this.eColleageCredit = eColleageCredit;
        this.eColleageStandardCredit = eColleageStandardCredit;
        this.eMasterName = eMasterName;
        this.eMasterAdmission = eMasterAdmission;
        this.eMasterAdmissionFormat = eMasterAdmissionFormat;
        this.eMasterAdmissionType = eMasterAdmissionType;
        this.eMasterGraduate = eMasterGraduate;
        this.eMasterGraduateFormat = eMasterGraduateFormat;
        this.eMasterGraduateType = eMasterGraduateType;
        this.eMasterMajor = eMasterMajor;
        this.eMasterCredit = eMasterCredit;
        this.eMasterStandardCredit = eMasterStandardCredit;
        this.eDoctorName = eDoctorName;
        this.eDoctorAdmission = eDoctorAdmission;
        this.eDoctorAdmissionFormat = eDoctorAdmissionFormat;
        this.eDoctorAdmissionType = eDoctorAdmissionType;
        this.eDoctorGraduate = eDoctorGraduate;
        this.eDoctorGraduateFormat = eDoctorGraduateFormat;
        this.eDoctorGraduateType = eDoctorGraduateType;
        this.eDoctorMajor = eDoctorMajor;
        this.eDoctorCredit = eDoctorCredit;
        this.eDoctorStandardCredit = eDoctorStandardCredit;
    }

    public String getBiBirthDateYearFormat() {
        return biBirthDateYearFormat;
    }

    public void setBiBirthDateYearFormat(String biBirthDateYearFormat) {
        this.biBirthDateYearFormat = biBirthDateYearFormat;
    }

    public int getBiAgeInFull() {
        return biAgeInFull;
    }

    public void setBiAgeInFull(int biAgeInFull) {
        this.biAgeInFull = biAgeInFull;
    }

    public String geteHighAdmissionFormat() {
        return eHighAdmissionFormat;
    }

    public void seteHighAdmissionFormat(String eHighAdmissionFormat) {
        this.eHighAdmissionFormat = eHighAdmissionFormat;
    }

    public String geteHighGraduationFormat() {
        return eHighGraduationFormat;
    }

    public void seteHighGraduationFormat(String eHighGraduationFormat) {
        this.eHighGraduationFormat = eHighGraduationFormat;
    }

    public String geteColleageAdmissionFormat() {
        return eColleageAdmissionFormat;
    }

    public void seteColleageAdmissionFormat(String eColleageAdmissionFormat) {
        this.eColleageAdmissionFormat = eColleageAdmissionFormat;
    }

    public String geteColleageGraduateFormat() {
        return eColleageGraduateFormat;
    }

    public void seteColleageGraduateFormat(String eColleageGraduateFormat) {
        this.eColleageGraduateFormat = eColleageGraduateFormat;
    }

    public String geteMasterAdmissionFormat() {
        return eMasterAdmissionFormat;
    }

    public void seteMasterAdmissionFormat(String eMasterAdmissionFormat) {
        this.eMasterAdmissionFormat = eMasterAdmissionFormat;
    }

    public String geteMasterGraduateFormat() {
        return eMasterGraduateFormat;
    }

    public void seteMasterGraduateFormat(String eMasterGraduateFormat) {
        this.eMasterGraduateFormat = eMasterGraduateFormat;
    }

    public String geteDoctorAdmissionFormat() {
        return eDoctorAdmissionFormat;
    }

    public void seteDoctorAdmissionFormat(String eDoctorAdmissionFormat) {
        this.eDoctorAdmissionFormat = eDoctorAdmissionFormat;
    }

    public String geteDoctorGraduateFormat() {
        return eDoctorGraduateFormat;
    }

    public void seteDoctorGraduateFormat(String eDoctorGraduateFormat) {
        this.eDoctorGraduateFormat = eDoctorGraduateFormat;
    }

    public int getrNo() {
        return rNo;
    }

    public void setrNo(int rNo) {
        this.rNo = rNo;
    }

    public String getBiTitle() {
        return biTitle;
    }

    public void setBiTitle(String biTitle) {
        this.biTitle = biTitle;
    }

    public String getBiName() {
        return biName;
    }

    public void setBiName(String biName) {
        this.biName = biName;
    }

    public String getBiGender() {
        return biGender;
    }

    public void setBiGender(String biGender) {
        this.biGender = biGender;
    }

    public Date getBiBirthDate() {
        return biBirthDate;
    }

    public void setBiBirthDate(Date biBirthDate) {
        this.biBirthDate = biBirthDate;
    }

    public int getBiAge() {
        return biAge;
    }

    public void setBiAge(int biAge) {
        this.biAge = biAge;
    }

    public String getBiEmail() {
        return biEmail;
    }

    public void setBiEmail(String biEmail) {
        this.biEmail = biEmail;
    }

    public String getBiPhone() {
        return biPhone;
    }

    public void setBiPhone(String biPhone) {
        this.biPhone = biPhone;
    }

    public String getBiAddress() {
        return biAddress;
    }

    public void setBiAddress(String biAddress) {
        this.biAddress = biAddress;
    }

    public String getBiAddressDetail() {
        return biAddressDetail;
    }

    public void setBiAddressDetail(String biAddressDetail) {
        this.biAddressDetail = biAddressDetail;
    }

    public int getsNo() {
        return sNo;
    }

    public void setsNo(int sNo) {
        this.sNo = sNo;
    }

    public int getaNo() {
        return aNo;
    }

    public void setaNo(int aNo) {
        this.aNo = aNo;
    }

    public String geteType() {
        return eType;
    }

    public void seteType(String eType) {
        this.eType = eType;
    }

    public String geteHighName() {
        return eHighName;
    }

    public void seteHighName(String eHighName) {
        this.eHighName = eHighName;
    }

    public String geteHighMajor() {
        return eHighMajor;
    }

    public void seteHighMajor(String eHighMajor) {
        this.eHighMajor = eHighMajor;
    }

    public Date geteHighAdmission() {
        return eHighAdmission;
    }

    public void seteHighAdmission(Date eHighAdmission) {
        this.eHighAdmission = eHighAdmission;
    }

    public Date geteHighGraduation() {
        return eHighGraduation;
    }

    public void seteHighGraduation(Date eHighGraduation) {
        this.eHighGraduation = eHighGraduation;
    }

    public String geteColleageType() {
        return eColleageType;
    }

    public void seteColleageType(String eColleageType) {
        this.eColleageType = eColleageType;
    }

    public String geteColleageName() {
        return eColleageName;
    }

    public void seteColleageName(String eColleageName) {
        this.eColleageName = eColleageName;
    }

    public Date geteColleageAdmission() {
        return eColleageAdmission;
    }

    public void seteColleageAdmission(Date eColleageAdmission) {
        this.eColleageAdmission = eColleageAdmission;
    }

    public String geteColleageAdmissionType() {
        return eColleageAdmissionType;
    }

    public void seteColleageAdmissionType(String eColleageAdmissionType) {
        this.eColleageAdmissionType = eColleageAdmissionType;
    }

    public Date geteColleageGraduate() {
        return eColleageGraduate;
    }

    public void seteColleageGraduate(Date eColleageGraduate) {
        this.eColleageGraduate = eColleageGraduate;
    }

    public String geteColleageGraduateType() {
        return eColleageGraduateType;
    }

    public void seteColleageGraduateType(String eColleageGraduateType) {
        this.eColleageGraduateType = eColleageGraduateType;
    }

    public String geteColleageMajor() {
        return eColleageMajor;
    }

    public void seteColleageMajor(String eColleageMajor) {
        this.eColleageMajor = eColleageMajor;
    }

    public String geteColleageCredit() {
        return eColleageCredit;
    }

    public void seteColleageCredit(String eColleageCredit) {
        this.eColleageCredit = eColleageCredit;
    }

    public String geteColleageStandardCredit() {
        return eColleageStandardCredit;
    }

    public void seteColleageStandardCredit(String eColleageStandardCredit) {
        this.eColleageStandardCredit = eColleageStandardCredit;
    }

    public String geteMasterName() {
        return eMasterName;
    }

    public void seteMasterName(String eMasterName) {
        this.eMasterName = eMasterName;
    }

    public Date geteMasterAdmission() {
        return eMasterAdmission;
    }

    public void seteMasterAdmission(Date eMasterAdmission) {
        this.eMasterAdmission = eMasterAdmission;
    }

    public String geteMasterAdmissionType() {
        return eMasterAdmissionType;
    }

    public void seteMasterAdmissionType(String eMasterAdmissionType) {
        this.eMasterAdmissionType = eMasterAdmissionType;
    }

    public Date geteMasterGraduate() {
        return eMasterGraduate;
    }

    public void seteMasterGraduate(Date eMasterGraduate) {
        this.eMasterGraduate = eMasterGraduate;
    }

    public String geteMasterGraduateType() {
        return eMasterGraduateType;
    }

    public void seteMasterGraduateType(String eMasterGraduateType) {
        this.eMasterGraduateType = eMasterGraduateType;
    }

    public String geteMasterMajor() {
        return eMasterMajor;
    }

    public void seteMasterMajor(String eMasterMajor) {
        this.eMasterMajor = eMasterMajor;
    }

    public String geteMasterCredit() {
        return eMasterCredit;
    }

    public void seteMasterCredit(String eMasterCredit) {
        this.eMasterCredit = eMasterCredit;
    }

    public String geteMasterStandardCredit() {
        return eMasterStandardCredit;
    }

    public void seteMasterStandardCredit(String eMasterStandardCredit) {
        this.eMasterStandardCredit = eMasterStandardCredit;
    }

    public String geteDoctorName() {
        return eDoctorName;
    }

    public void seteDoctorName(String eDoctorName) {
        this.eDoctorName = eDoctorName;
    }

    public Date geteDoctorAdmission() {
        return eDoctorAdmission;
    }

    public void seteDoctorAdmission(Date eDoctorAdmission) {
        this.eDoctorAdmission = eDoctorAdmission;
    }

    public String geteDoctorAdmissionType() {
        return eDoctorAdmissionType;
    }

    public void seteDoctorAdmissionType(String eDoctorAdmissionType) {
        this.eDoctorAdmissionType = eDoctorAdmissionType;
    }

    public Date geteDoctorGraduate() {
        return eDoctorGraduate;
    }

    public void seteDoctorGraduate(Date eDoctorGraduate) {
        this.eDoctorGraduate = eDoctorGraduate;
    }

    public String geteDoctorGraduateType() {
        return eDoctorGraduateType;
    }

    public void seteDoctorGraduateType(String eDoctorGraduateType) {
        this.eDoctorGraduateType = eDoctorGraduateType;
    }

    public String geteDoctorMajor() {
        return eDoctorMajor;
    }

    public void seteDoctorMajor(String eDoctorMajor) {
        this.eDoctorMajor = eDoctorMajor;
    }

    public String geteDoctorCredit() {
        return eDoctorCredit;
    }

    public void seteDoctorCredit(String eDoctorCredit) {
        this.eDoctorCredit = eDoctorCredit;
    }

    public String geteDoctorStandardCredit() {
        return eDoctorStandardCredit;
    }

    public void seteDoctorStandardCredit(String eDoctorStandardCredit) {
        this.eDoctorStandardCredit = eDoctorStandardCredit;
    }

    @Override
    public String toString() {
        return "ResumeDetails{" +
                "rNo=" + rNo +
                ", biTitle='" + biTitle + '\'' +
                ", biName='" + biName + '\'' +
                ", biGender='" + biGender + '\'' +
                ", biBirthDate=" + biBirthDate +
                ", biAge=" + biAge +
                ", biEmail='" + biEmail + '\'' +
                ", biPhone='" + biPhone + '\'' +
                ", biAddress='" + biAddress + '\'' +
                ", biAddressDetail='" + biAddressDetail + '\'' +
                ", sNo=" + sNo +
                ", aNo=" + aNo +
                ", eType='" + eType + '\'' +
                ", eHighName='" + eHighName + '\'' +
                ", eHighMajor='" + eHighMajor + '\'' +
                ", eHighAdmission=" + eHighAdmission +
                ", eHighGraduation=" + eHighGraduation +
                ", eColleageType='" + eColleageType + '\'' +
                ", eColleageName='" + eColleageName + '\'' +
                ", eColleageAdmission=" + eColleageAdmission +
                ", eColleageAdmissionType='" + eColleageAdmissionType + '\'' +
                ", eColleageGraduate=" + eColleageGraduate +
                ", eColleageGraduateType='" + eColleageGraduateType + '\'' +
                ", eColleageMajor='" + eColleageMajor + '\'' +
                ", eColleageCredit='" + eColleageCredit + '\'' +
                ", eColleageStandardCredit='" + eColleageStandardCredit + '\'' +
                ", eMasterName='" + eMasterName + '\'' +
                ", eMasterAdmission=" + eMasterAdmission +
                ", eMasterAdmissionType='" + eMasterAdmissionType + '\'' +
                ", eMasterGraduate=" + eMasterGraduate +
                ", eMasterGraduateType='" + eMasterGraduateType + '\'' +
                ", eMasterMajor='" + eMasterMajor + '\'' +
                ", eMasterCredit='" + eMasterCredit + '\'' +
                ", eMasterStandardCredit='" + eMasterStandardCredit + '\'' +
                ", eDoctorName='" + eDoctorName + '\'' +
                ", eDoctorAdmission=" + eDoctorAdmission +
                ", eDoctorAdmissionType='" + eDoctorAdmissionType + '\'' +
                ", eDoctorGraduate=" + eDoctorGraduate +
                ", eDoctorGraduateType='" + eDoctorGraduateType + '\'' +
                ", eDoctorMajor='" + eDoctorMajor + '\'' +
                ", eDoctorCredit='" + eDoctorCredit + '\'' +
                ", eDoctorStandardCredit='" + eDoctorStandardCredit + '\'' +
                '}';
    }
}
