package com.lec.spring.user.service;

import com.lec.spring.user.domain.UserDTO;
import com.lec.spring.user.persistence.UserDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private SqlSessionTemplate sessionTemplate;

    private UserDAO userDAO;

    public int regist(UserDTO userDTO){
        int res = 0;
        userDAO = sessionTemplate.getMapper(UserDAO.class);

        try {
            res = userDAO.register(userDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public int userIdCheck(String u_id){
        userDAO = sessionTemplate.getMapper(UserDAO.class);
        return userDAO.checkOverId(u_id);
    }
}
