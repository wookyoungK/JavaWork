package com.lec.spring.resume.domain;

public class resumeWriteVO {

    private String subject;
    private String basicName;
    private String resumeStatus;
    private String basicBirth;
    private String optionSelected;
    private String basicEmail;
    private String basicPhone;
    private String basicAddrs;
    private String basicAddrs2;

    // 초등학교
    private String eleEduName;
    private String eduElePeriod;
    private String eduElePeriod2;
    private String eduEleArea;

    //중학교

    private String eduMedName;
    private String eduMedPeriod;
    private String eduMedPeriod2;
    private String eduMedArea;

    //고등학교

    private String EduHighName;
    private String eduHighPeriod;
    private String eduHighPeriod2;
    private String eduHighDep;
    private String eduHighArea;

    //대학교 이상

    private String eduUniYear;
    private String EduUniName;
    private String eduUniPeriod;
    private String eduUniPeriod2;
    private String EduUniMajor;
    private String EduUniDep;
    private String eduUniArea;

    // 경력 사항

    private String comName;
    private String comPeriod;
    private String comPeriod2;
    private String comPosition;
    private String comJobType;
    private String comIncome;
    private String totalCareer;

    //토익

    private String toeicScore;



    private String introduction;
    private String introTitle;


    // 희망 근무조건

    private String HopeJobType;
    private String hopeIncome;
    private String hopeArea;
    private String hopeService;

    // 포트폴리오

    private String portUrl;


    public resumeWriteVO(String subject, String basicName, String resumeStatus, String basicBirth, String optionSelected, String basicEmail, String basicPhone, String basicAddrs, String basicAddrs2, String eleEduName, String eduElePeriod, String eduElePeriod2, String eduEleArea, String eduMedName, String eduMedPeriod, String eduMedPeriod2, String eduMedArea, String eduHighName, String eduHighPeriod, String eduHighPeriod2, String eduHighDep, String eduHighArea, String eduUniYear, String eduUniName, String eduUniPeriod, String eduUniPeriod2, String eduUniMajor, String eduUniDep, String eduUniArea, String comName, String comPeriod, String comPeriod2, String comPosition, String comJobType, String comIncome, String totalCareer, String toeicScore, String introduction, String introTitle, String hopeJobType, String hopeIncome, String hopeArea, String hopeService, String portUrl) {
        this.subject = subject;
        this.basicName = basicName;
        this.resumeStatus = resumeStatus;
        this.basicBirth = basicBirth;
        this.optionSelected = optionSelected;
        this.basicEmail = basicEmail;
        this.basicPhone = basicPhone;
        this.basicAddrs = basicAddrs;
        this.basicAddrs2 = basicAddrs2;
        this.eleEduName = eleEduName;
        this.eduElePeriod = eduElePeriod;
        this.eduElePeriod2 = eduElePeriod2;
        this.eduEleArea = eduEleArea;
        this.eduMedName = eduMedName;
        this.eduMedPeriod = eduMedPeriod;
        this.eduMedPeriod2 = eduMedPeriod2;
        this.eduMedArea = eduMedArea;
        EduHighName = eduHighName;
        this.eduHighPeriod = eduHighPeriod;
        this.eduHighPeriod2 = eduHighPeriod2;
        this.eduHighDep = eduHighDep;
        this.eduHighArea = eduHighArea;
        this.eduUniYear = eduUniYear;
        EduUniName = eduUniName;
        this.eduUniPeriod = eduUniPeriod;
        this.eduUniPeriod2 = eduUniPeriod2;
        EduUniMajor = eduUniMajor;
        EduUniDep = eduUniDep;
        this.eduUniArea = eduUniArea;
        this.comName = comName;
        this.comPeriod = comPeriod;
        this.comPeriod2 = comPeriod2;
        this.comPosition = comPosition;
        this.comJobType = comJobType;
        this.comIncome = comIncome;
        this.totalCareer = totalCareer;
        this.toeicScore = toeicScore;
        this.introduction = introduction;
        this.introTitle = introTitle;
        HopeJobType = hopeJobType;
        this.hopeIncome = hopeIncome;
        this.hopeArea = hopeArea;
        this.hopeService = hopeService;
        this.portUrl = portUrl;
    }

    public resumeWriteVO() {
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBasicName() {
        return basicName;
    }

    public void setBasicName(String basicName) {
        this.basicName = basicName;
    }

    public String getResumeStatus() {
        return resumeStatus;
    }

    public void setResumeStatus(String resumeStatus) {
        this.resumeStatus = resumeStatus;
    }

    public String getBasicBirth() {
        return basicBirth;
    }

    public void setBasicBirth(String basicBirth) {
        this.basicBirth = basicBirth;
    }

    public String getOptionSelected() {
        return optionSelected;
    }

    public void setOptionSelected(String optionSelected) {
        this.optionSelected = optionSelected;
    }

    public String getBasicEmail() {
        return basicEmail;
    }

    public void setBasicEmail(String basicEmail) {
        this.basicEmail = basicEmail;
    }

    public String getBasicPhone() {
        return basicPhone;
    }

    public void setBasicPhone(String basicPhone) {
        this.basicPhone = basicPhone;
    }

    public String getBasicAddrs() {
        return basicAddrs;
    }

    public void setBasicAddrs(String basicAddrs) {
        this.basicAddrs = basicAddrs;
    }

    public String getBasicAddrs2() {
        return basicAddrs2;
    }

    public void setBasicAddrs2(String basicAddrs2) {
        this.basicAddrs2 = basicAddrs2;
    }

    public String getEleEduName() {
        return eleEduName;
    }

    public void setEleEduName(String eleEduName) {
        this.eleEduName = eleEduName;
    }

    public String getEduElePeriod() {
        return eduElePeriod;
    }

    public void setEduElePeriod(String eduElePeriod) {
        this.eduElePeriod = eduElePeriod;
    }

    public String getEduElePeriod2() {
        return eduElePeriod2;
    }

    public void setEduElePeriod2(String eduElePeriod2) {
        this.eduElePeriod2 = eduElePeriod2;
    }

    public String getEduEleArea() {
        return eduEleArea;
    }

    public void setEduEleArea(String eduEleArea) {
        this.eduEleArea = eduEleArea;
    }

    public String getEduMedName() {
        return eduMedName;
    }

    public void setEduMedName(String eduMedName) {
        this.eduMedName = eduMedName;
    }

    public String getEduMedPeriod() {
        return eduMedPeriod;
    }

    public void setEduMedPeriod(String eduMedPeriod) {
        this.eduMedPeriod = eduMedPeriod;
    }

    public String getEduMedPeriod2() {
        return eduMedPeriod2;
    }

    public void setEduMedPeriod2(String eduMedPeriod2) {
        this.eduMedPeriod2 = eduMedPeriod2;
    }

    public String getEduMedArea() {
        return eduMedArea;
    }

    public void setEduMedArea(String eduMedArea) {
        this.eduMedArea = eduMedArea;
    }

    public String getEduHighName() {
        return EduHighName;
    }

    public void setEduHighName(String eduHighName) {
        EduHighName = eduHighName;
    }

    public String getEduHighPeriod() {
        return eduHighPeriod;
    }

    public void setEduHighPeriod(String eduHighPeriod) {
        this.eduHighPeriod = eduHighPeriod;
    }

    public String getEduHighPeriod2() {
        return eduHighPeriod2;
    }

    public void setEduHighPeriod2(String eduHighPeriod2) {
        this.eduHighPeriod2 = eduHighPeriod2;
    }

    public String getEduHighDep() {
        return eduHighDep;
    }

    public void setEduHighDep(String eduHighDep) {
        this.eduHighDep = eduHighDep;
    }

    public String getEduHighArea() {
        return eduHighArea;
    }

    public void setEduHighArea(String eduHighArea) {
        this.eduHighArea = eduHighArea;
    }

    public String getEduUniYear() {
        return eduUniYear;
    }

    public void setEduUniYear(String eduUniYear) {
        this.eduUniYear = eduUniYear;
    }

    public String getEduUniName() {
        return EduUniName;
    }

    public void setEduUniName(String eduUniName) {
        EduUniName = eduUniName;
    }

    public String getEduUniPeriod() {
        return eduUniPeriod;
    }

    public void setEduUniPeriod(String eduUniPeriod) {
        this.eduUniPeriod = eduUniPeriod;
    }

    public String getEduUniPeriod2() {
        return eduUniPeriod2;
    }

    public void setEduUniPeriod2(String eduUniPeriod2) {
        this.eduUniPeriod2 = eduUniPeriod2;
    }

    public String getEduUniMajor() {
        return EduUniMajor;
    }

    public void setEduUniMajor(String eduUniMajor) {
        EduUniMajor = eduUniMajor;
    }

    public String getEduUniDep() {
        return EduUniDep;
    }

    public void setEduUniDep(String eduUniDep) {
        EduUniDep = eduUniDep;
    }

    public String getEduUniArea() {
        return eduUniArea;
    }

    public void setEduUniArea(String eduUniArea) {
        this.eduUniArea = eduUniArea;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComPeriod() {
        return comPeriod;
    }

    public void setComPeriod(String comPeriod) {
        this.comPeriod = comPeriod;
    }

    public String getComPeriod2() {
        return comPeriod2;
    }

    public void setComPeriod2(String comPeriod2) {
        this.comPeriod2 = comPeriod2;
    }

    public String getComPosition() {
        return comPosition;
    }

    public void setComPosition(String comPosition) {
        this.comPosition = comPosition;
    }

    public String getComJobType() {
        return comJobType;
    }

    public void setComJobType(String comJobType) {
        this.comJobType = comJobType;
    }

    public String getComIncome() {
        return comIncome;
    }

    public void setComIncome(String comIncome) {
        this.comIncome = comIncome;
    }

    public String getTotalCareer() {
        return totalCareer;
    }

    public void setTotalCareer(String totalCareer) {
        this.totalCareer = totalCareer;
    }

    public String getToeicScore() {
        return toeicScore;
    }

    public void setToeicScore(String toeicScore) {
        this.toeicScore = toeicScore;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getIntroTitle() {
        return introTitle;
    }

    public void setIntroTitle(String introTitle) {
        this.introTitle = introTitle;
    }

    public String getHopeJobType() {
        return HopeJobType;
    }

    public void setHopeJobType(String hopeJobType) {
        HopeJobType = hopeJobType;
    }

    public String getHopeIncome() {
        return hopeIncome;
    }

    public void setHopeIncome(String hopeIncome) {
        this.hopeIncome = hopeIncome;
    }

    public String getHopeArea() {
        return hopeArea;
    }

    public void setHopeArea(String hopeArea) {
        this.hopeArea = hopeArea;
    }

    public String getHopeService() {
        return hopeService;
    }

    public void setHopeService(String hopeService) {
        this.hopeService = hopeService;
    }

    public String getPortUrl() {
        return portUrl;
    }

    public void setPortUrl(String portUrl) {
        this.portUrl = portUrl;
    }
}
