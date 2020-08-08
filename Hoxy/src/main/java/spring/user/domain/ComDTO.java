package com.lec.spring.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ComDTO {
    private int c_uid;
    private String c_id;
    private String c_pw;
    private String c_name;
    private String c_ceoName;
    private String c_address1;
    private String c_address2;
    private String c_postNum;
    private String c_cnum;
    private String c_form;
    private int c_employees;
    private String c_category;
    private String c_auth;
    private String enabled;

    public ComDTO() {
    }

    public ComDTO(int c_uid, String c_id, String c_pw, String c_name, String c_ceoName, String c_address1, String c_address2, String c_postNum, String c_cnum, String c_form, int c_employees, String c_category, String c_auth, String enabled) {
        this.c_uid = c_uid;
        this.c_id = c_id;
        this.c_pw = c_pw;
        this.c_name = c_name;
        this.c_ceoName = c_ceoName;
        this.c_address1 = c_address1;
        this.c_address2 = c_address2;
        this.c_postNum = c_postNum;
        this.c_cnum = c_cnum;
        this.c_form = c_form;
        this.c_employees = c_employees;
        this.c_category = c_category;
        this.c_auth = c_auth;
        this.enabled = enabled;
    }

    public int getC_uid() {
        return c_uid;
    }

    public void setC_uid(int c_uid) {
        this.c_uid = c_uid;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getC_pw() {
        return c_pw;
    }

    public void setC_pw(String c_pw) {
        this.c_pw = c_pw;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_ceoName() {
        return c_ceoName;
    }

    public void setC_ceoName(String c_ceoName) {
        this.c_ceoName = c_ceoName;
    }

    public String getC_address1() {
        return c_address1;
    }

    public void setC_address1(String c_address1) {
        this.c_address1 = c_address1;
    }

    public String getC_address2() {
        return c_address2;
    }

    public void setC_address2(String c_address2) {
        this.c_address2 = c_address2;
    }

    public String getC_postNum() {
        return c_postNum;
    }

    public void setC_postNum(String c_postNum) {
        this.c_postNum = c_postNum;
    }

    public String getC_cnum() {
        return c_cnum;
    }

    public void setC_cnum(String c_cnum) {
        this.c_cnum = c_cnum;
    }

    public String getC_form() {
        return c_form;
    }

    public void setC_form(String c_form) {
        this.c_form = c_form;
    }

    public int getC_employees() {
        return c_employees;
    }

    public void setC_employees(int c_employees) {
        this.c_employees = c_employees;
    }

    public String getC_category() {
        return c_category;
    }

    public void setC_category(String c_category) {
        this.c_category = c_category;
    }

    public String getC_auth() {
        return c_auth;
    }

    public void setC_auth(String c_auth) {
        this.c_auth = c_auth;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }
}
