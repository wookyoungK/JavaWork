package com.lec.spring.user.service;

import com.lec.spring.user.persistence.UserDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSearchService {

    @Autowired
    private SqlSessionTemplate sessionTemplate;

    private UserDAO userDAO;

    // 아이디 찾기
    public String get_searchId(String u_name, String u_phoneNum) {

        userDAO = sessionTemplate.getMapper(UserDAO.class);

        String result = "";

        try {
            result = userDAO.searchId(u_name, u_phoneNum);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


}
