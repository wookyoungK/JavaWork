package com.lec.spring.resume.domain;

public class FileDTO {

    private int rf_uid;
    private int u_uid;
    private String rf_source;


    public FileDTO() {
    }

    public FileDTO(int rf_uid, int u_uid, String rf_source) {
        this.rf_uid = rf_uid;
        this.u_uid = u_uid;
        this.rf_source = rf_source;
    }

    public int getRf_uid() {
        return rf_uid;
    }

    public void setRf_uid(int rf_uid) {
        this.rf_uid = rf_uid;
    }

    public int getU_uid() {
        return u_uid;
    }

    public void setU_uid(int u_uid) {
        this.u_uid = u_uid;
    }

    public String getRf_source() {
        return rf_source;
    }

    public void setRf_source(String rf_source) {
        this.rf_source = rf_source;
    }


}
