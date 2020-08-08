package com.lec.spring.user.domain;

public class UserDTO {
    private int u_uid;
    private String u_id;
    private String u_pw;
    private String u_name;
    private String u_jumin;
    private String u_email;
    private String u_phoneNum;
    private String u_key;
    private String u_auth;
    private String enabled;

    public UserDTO() {
    }

    public UserDTO(int u_uid, String u_id, String u_pw, String u_name, String u_jumin, String u_email, String u_phoneNum, String u_key, String u_auth, String enabled) {
        this.u_uid = u_uid;
        this.u_id = u_id;
        this.u_pw = u_pw;
        this.u_name = u_name;
        this.u_jumin = u_jumin;
        this.u_email = u_email;
        this.u_phoneNum = u_phoneNum;
        this.u_key = u_key;
        this.u_auth = u_auth;
        this.enabled = enabled;
    }

    public int getU_uid() {
        return u_uid;
    }

    public void setU_uid(int u_uid) {
        this.u_uid = u_uid;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getU_pw() {
        return u_pw;
    }

    public void setU_pw(String u_pw) {
        this.u_pw = u_pw;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_jumin() {
        return u_jumin;
    }

    public void setU_jumin(String u_jumin) {
        this.u_jumin = u_jumin;
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public String getU_phoneNum() {
        return u_phoneNum;
    }

    public void setU_phoneNum(String u_phoneNum) {
        this.u_phoneNum = u_phoneNum;
    }

    public String getU_key() {
        return u_key;
    }

    public void setU_key(String u_key) {
        this.u_key = u_key;
    }

    public String getU_auth() {
        return u_auth;
    }

    public void setU_auth(String u_auth) {
        this.u_auth = u_auth;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }
}
