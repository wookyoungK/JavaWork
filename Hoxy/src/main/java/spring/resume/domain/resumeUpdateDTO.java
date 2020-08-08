package com.lec.spring.resume.domain;

import java.util.Date;

public class resumeUpdateDTO {

    private int r_uid;
    private int u_uid;
    private String r_title;
    private String r_name;
    private String r_dateofbirth;
    private String r_email;
    private String r_phonenum;
    private String r_address1;
    private String r_address2;
    private String r_servicetype;
    private String r_hopeincome;
    private String r_workarea;
    private String r_jobtype;

    public resumeUpdateDTO() {
    }

    public resumeUpdateDTO(int r_uid, int u_uid, String r_title, String r_name, String r_dateofbirth, String r_email, String r_phonenum, String r_address1, String r_address2, String r_servicetype, String r_hopeincome, String r_workarea, String r_jobtype) {
        this.r_uid = r_uid;
        this.u_uid = u_uid;
        this.r_title = r_title;
        this.r_name = r_name;
        this.r_dateofbirth = r_dateofbirth;
        this.r_email = r_email;
        this.r_phonenum = r_phonenum;
        this.r_address1 = r_address1;
        this.r_address2 = r_address2;
        this.r_servicetype = r_servicetype;
        this.r_hopeincome = r_hopeincome;
        this.r_workarea = r_workarea;
        this.r_jobtype = r_jobtype;
    }


    public int getR_uid() {
        return r_uid;
    }

    public void setR_uid(int r_uid) {
        this.r_uid = r_uid;
    }

    public int getU_uid() {
        return u_uid;
    }

    public void setU_uid(int u_uid) {
        this.u_uid = u_uid;
    }

    public String getR_title() {
        return r_title;
    }

    public void setR_title(String r_title) {
        this.r_title = r_title;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public String getR_dateofbirth() {
        return r_dateofbirth;
    }

    public void setR_dateofbirth(String r_dateofbirth) {
        this.r_dateofbirth = r_dateofbirth;
    }

    public String getR_email() {
        return r_email;
    }

    public void setR_email(String r_email) {
        this.r_email = r_email;
    }

    public String getR_phonenum() {
        return r_phonenum;
    }

    public void setR_phonenum(String r_phonenum) {
        this.r_phonenum = r_phonenum;
    }

    public String getR_address1() {
        return r_address1;
    }

    public void setR_address1(String r_address1) {
        this.r_address1 = r_address1;
    }

    public String getR_address2() {
        return r_address2;
    }

    public void setR_address2(String r_address2) {
        this.r_address2 = r_address2;
    }

    public String getR_servicetype() {
        return r_servicetype;
    }

    public void setR_servicetype(String r_servicetype) {
        this.r_servicetype = r_servicetype;
    }

    public String getR_hopeincome() {
        return r_hopeincome;
    }

    public void setR_hopeincome(String r_hopeincome) {
        this.r_hopeincome = r_hopeincome;
    }

    public String getR_workarea() {
        return r_workarea;
    }

    public void setR_workarea(String r_workarea) {
        this.r_workarea = r_workarea;
    }

    public String getR_jobtype() {
        return r_jobtype;
    }

    public void setR_jobtype(String r_jobtype) {
        this.r_jobtype = r_jobtype;
    }
}
