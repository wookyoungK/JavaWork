package com.lec.spring.resume.domain;

import java.util.Date;

public class resumeListDTO {
    private String r_title;
    private Date r_date;
    private int r_uid;

    public resumeListDTO(String r_title, Date r_date, int r_uid) {
        this.r_title = r_title;
        this.r_date = r_date;
        this.r_uid = r_uid;
    }

    public resumeListDTO() {
    }


    public String getR_title() {
        return r_title;
    }

    public void setR_title(String r_title) {
        this.r_title = r_title;
    }

    public Date getR_date() {
        return r_date;
    }

    public void setR_date(Date r_date) {
        this.r_date = r_date;
    }

    public int getR_uid() {
        return r_uid;
    }

    public void setR_uid(int r_uid) {
        this.r_uid = r_uid;
    }
}
