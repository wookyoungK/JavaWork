package com.lec.spring.user.service;

import com.lec.spring.user.domain.ComDTO;
import com.lec.spring.user.persistence.ComDAO;
import com.lec.spring.user.persistence.UserDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComService {
    @Autowired
    private SqlSessionTemplate template;

    private ComDAO dao;

    public int regist(ComDTO dto){
        int res = 0;
        dao = template.getMapper(ComDAO.class);

        try {
            res = dao.c_register(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public int usercIdCheck(String c_id){
        dao = template.getMapper(ComDAO.class);
        return dao.checkOverId(c_id);
    }
}
