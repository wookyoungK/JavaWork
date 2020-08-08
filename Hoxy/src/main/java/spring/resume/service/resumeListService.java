package com.lec.spring.resume.service;


import com.lec.spring.resume.domain.resumeListDTO;
import com.lec.spring.resume.persistence.resumeDAO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class resumeListService {

    @Autowired
    private SqlSession sqlsession;

    public resumeDAO dao;

    public List<resumeListDTO> selectList(int uid){

        dao = sqlsession.getMapper(resumeDAO.class);

        return dao.selectAll(uid);

    }

}
