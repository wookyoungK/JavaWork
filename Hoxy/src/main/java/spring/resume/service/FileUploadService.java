package com.lec.spring.resume.service;

import com.lec.spring.resume.persistence.resumeDAO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class FileUploadService {

    @Autowired
    private SqlSession sqlsession;

    public resumeDAO dao;

    public void fileUpload(int uid, String File){

       dao =  sqlsession.getMapper(resumeDAO.class);
        System.out.println("uid = " + uid);

        try {
            dao.deleteFile(uid);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("파일이 이미 존재합니다.");
        }
        dao.filesave(uid,File);


    }




}
