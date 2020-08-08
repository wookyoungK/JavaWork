package com.lec.spring.user.domain;

public class AdmDTO {
    private int a_uid;
    private String a_id;
    private String a_pw;
    private String a_auth;
    private String enabled;

    public AdmDTO() {
    }

    public AdmDTO(int a_uid, String a_id, String a_pw, String a_auth, String enabled) {
        this.a_uid = a_uid;
        this.a_id = a_id;
        this.a_pw = a_pw;
        this.a_auth = a_auth;
        this.enabled = enabled;
    }

    public int getA_uid() {
        return a_uid;
    }

    public void setA_uid(int a_uid) {
        this.a_uid = a_uid;
    }

    public String getA_id() {
        return a_id;
    }

    public void setA_id(String a_id) {
        this.a_id = a_id;
    }

    public String getA_pw() {
        return a_pw;
    }

    public void setA_pw(String a_pw) {
        this.a_pw = a_pw;
    }

    public String getA_auth() {
        return a_auth;
    }

    public void setA_auth(String a_auth) {
        this.a_auth = a_auth;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }
}
