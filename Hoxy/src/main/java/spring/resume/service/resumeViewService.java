package com.lec.spring.resume.service;

import com.lec.spring.resume.domain.resumeViewDTO;
import com.lec.spring.resume.persistence.resumeDAO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class resumeViewService {

    @Autowired
    private SqlSession sqlsession;

    public resumeDAO dao;

    public resumeViewDTO resumeView(int uid){
        dao =  sqlsession.getMapper(resumeDAO.class);

        return dao.select(uid);

    }
}
