package com.lec.spring.app.domain;

import com.lec.spring.hire.beans.HWriteDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class AppDTO {

    //회사명, 공고 이름, 지원일, 열람여부, 마감여부, 이력서 번호 ,이력서타이틀
    private int a_uid;
    private Timestamp a_date;
    private Timestamp r_date;
    private int a_view;
    private int u_uid;
    private int h_uid;
    private int r_uid;
    private String r_title;
    private String u_name;

    public String getU_name() {
        return u_name;
    }

    private int age;

    public String getToeic() {
        return toeic;
    }

    private String toeic;

    private int career;

    public int getCareer() {
        return career;
    }

    public void setR_date(Timestamp r_date) {
        this.r_date = r_date;
    }

    public int getA_uid() {
        return a_uid;
    }

    public void setA_uid(int a_uid) {
        this.a_uid = a_uid;
    }

    public Timestamp getA_date() {
        return a_date;
    }

    public void setA_date(Timestamp a_date) {
        this.a_date = a_date;
    }

    public int getA_view() {
        return a_view;
    }

    public void setA_view(int a_view) {
        this.a_view = a_view;
    }

    public int getU_uid() {
        return u_uid;
    }

    public void setU_uid(int u_uid) {
        this.u_uid = u_uid;
    }

    public int getH_uid() {
        return h_uid;
    }

    public void setH_uid(int h_uid) {
        this.h_uid = h_uid;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setToeic(String toeic) {
        this.toeic = toeic;
    }

    public void setCareer(int career) {
        this.career = career;
    }

    public String getH_title() {
        return h_title;
    }

    public void setH_title(String h_title) {
        this.h_title = h_title;
    }

    public String getH_name() {
        return h_name;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }

    public int getDday() {
        return dday;
    }

    public void setDday(int dday) {
        this.dday = dday;
    }

    public String getH_part() {
        return h_part;
    }

    public void setH_part(String h_part) {
        this.h_part = h_part;
    }

    public void setR_uid(int r_uid) {
        this.r_uid = r_uid;
    }

    public void setR_title(String r_title) {
        this.r_title = r_title;
    }

    public Timestamp getR_date() {
        return r_date;
    }

    public int getR_uid() {
        return r_uid;
    }

    public String getR_title() {
        return r_title;
    }

    private String h_title;//공고 타이틀

    private String h_name;
    private int dday;
    private String h_part;




    public AppDTO(int u_uid, int h_uid, int r_uid) {
        this.u_uid = u_uid;
        this.h_uid = h_uid;
        this.r_uid = r_uid;
    }

    public int getAge() {
        return age;
    }
}
