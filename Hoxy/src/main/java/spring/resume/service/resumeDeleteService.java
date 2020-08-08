package com.lec.spring.resume.service;

import com.lec.spring.resume.persistence.resumeDAO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class resumeDeleteService {

    @Autowired
    private SqlSession sqlsession;

    public resumeDAO dao;

    public void Delete(int uid){
        dao = sqlsession.getMapper(resumeDAO.class);

        dao.resumeDelete(uid);
    }
}
