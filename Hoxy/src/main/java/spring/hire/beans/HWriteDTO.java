package com.lec.spring.hire.beans;

public class HWriteDTO {


    private int c_uid;
    private int h_uid;
    private String h_name;
    private String h_title;
    private String h_content;
    // private String c_uid;
    private String h_salary;
    private String h_position1;
    private String h_position2;
    private String h_part;
    private String h_career;
    private String h_degree;
    private String h_workform;
    private int h_cnt;
    private String h_upDate;
    private String h_regDate;
    private String h_remainDate;
    private int dday;

    public HWriteDTO() {
        super();
    }

    public HWriteDTO(int c_uid, int h_uid, String h_name, String h_title, String h_content, String h_salary, String h_position1, String h_position2, String h_part, String h_career, String h_degree, String h_workform, int h_cnt, String h_upDate, String h_regDate, String h_remainDate, int dday) {
        this.c_uid= c_uid;
        this.h_uid = h_uid;
        this.h_name = h_name;
        this.h_title = h_title;
        this.h_content = h_content;
        this.h_salary = h_salary;
        this.h_position1 = h_position1;
        this.h_position2 = h_position2;
        this.h_part = h_part;
        this.h_career = h_career;
        this.h_degree = h_degree;
        this.h_workform = h_workform;
        this.h_cnt = h_cnt;
        this.h_upDate = h_upDate;
        this.h_regDate = h_regDate;
        this.h_remainDate = h_remainDate;
        this.dday=dday;
    }

    public int getDday() {
        return dday;
    }

    public void setDday(int dday) {
        this.dday = dday;
    }

    public int getC_uid() {
        return c_uid;
    }

    public void setC_uid(int c_uid) {
        this.c_uid = c_uid;
    }

    public int getH_uid() {
        return h_uid;
    }

    public void setH_uid(int h_uid) {
        this.h_uid = h_uid;
    }

    public String getH_name() {
        return h_name;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }

    public String getH_title() {
        return h_title;
    }

    public void setH_title(String h_title) {
        this.h_title = h_title;
    }

    public String getH_content() {
        return h_content;
    }

    public void setH_content(String h_content) {
        this.h_content = h_content;
    }

    public String getH_salary() {
        return h_salary;
    }

    public void setH_salary(String h_salary) {
        this.h_salary = h_salary;
    }

    public String getH_position1() {
        return h_position1;
    }

    public void setH_position1(String h_position1) {
        this.h_position1 = h_position1;
    }

    public String getH_position2() {
        return h_position2;
    }

    public void setH_position2(String h_position2) {
        this.h_position2 = h_position2;
    }

    public String getH_part() {
        return h_part;
    }

    public void setH_part(String h_part) {
        this.h_part = h_part;
    }

    public String getH_career() {
        return h_career;
    }

    public void setH_career(String h_career) {
        this.h_career = h_career;
    }

    public String getH_degree() {
        return h_degree;
    }

    public void setH_degree(String h_degree) {
        this.h_degree = h_degree;
    }

    public String getH_workform() {
        return h_workform;
    }

    public void setH_workform(String h_workform) {
        this.h_workform = h_workform;
    }

    public int getH_cnt() {
        return h_cnt;
    }

    public void setH_cnt(int h_cnt) {
        this.h_cnt = h_cnt;
    }

    public String getH_upDate() {
        return h_upDate;
    }

    public void setH_upDate(String h_upDate) {
        this.h_upDate = h_upDate;
    }

    public String getH_regDate() {
        return h_regDate;
    }

    public void setH_regDate(String h_regDate) {
        this.h_regDate = h_regDate;
    }

    public String getH_remainDate() {
        return h_remainDate;
    }

    public void setH_remainDate(String h_remainDate) {
        this.h_remainDate = h_remainDate;
    }
}
