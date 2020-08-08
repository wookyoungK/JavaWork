package com.lec.spring.resume.service;

import com.lec.spring.resume.persistence.resumeDAO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class resumeUpdateOkService {

    @Autowired
    private SqlSession sqlsession;

    public resumeDAO dao;

    public void resumeUpdateOk( int uid,  String subject,  String name,  int gender,  String birth,  String email,  String phonenum,  String address1,  String address2,  String status,     String servicetype,  String hopeincome,  String workarea,  String joptype){

        dao =  sqlsession.getMapper(resumeDAO.class);

        dao.resumeUpdate(  subject,   name,   gender,   birth,   email,   phonenum,   address1,   address2,   status,  servicetype,   hopeincome,   workarea,   joptype,  uid);
    }
}
