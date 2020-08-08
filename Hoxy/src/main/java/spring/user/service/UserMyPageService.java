package com.lec.spring.user.service;

import com.lec.spring.user.domain.UserDTO;
import com.lec.spring.user.persistence.UserDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserMyPageService {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    private UserDAO userDao;

    public UserDTO getMyPage(String u_id) {
        userDao = sqlSessionTemplate.getMapper(UserDAO.class);
        return userDao.getMyPage(u_id);
    }
    // 사용자 삭제 메서드
    public int deleteUser(String u_id) {
        userDao = sqlSessionTemplate.getMapper(UserDAO.class);
        return userDao.deleteUser(u_id);
    }

    // 이름 수정 메서드
    public int editName(String u_name, String u_id) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("u_name", u_name);
        map.put("u_id", u_id);
        userDao = sqlSessionTemplate.getMapper(UserDAO.class);
        return userDao.editUserName(map);
    }
    // 비밀번호 수정 메서드
    public int editPw(String u_pw, String u_id) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("u_pw", u_pw);
        map.put("u_id", u_id);
        userDao = sqlSessionTemplate.getMapper(UserDAO.class);
        return userDao.editUserPw(map);
    }
    // 폰번호 수정 메서드
    public int editPhone(String u_phoneNum, String u_id) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("u_phoneNum", u_phoneNum);
        map.put("u_id", u_id);
        userDao = sqlSessionTemplate.getMapper(UserDAO.class);
        return userDao.editUserPhone(map);
    }
    // 이메일 수정 메서드
    public int editEmail(String u_email, String u_id) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("u_email", u_email);
        map.put("u_id", u_id);
        userDao = sqlSessionTemplate.getMapper(UserDAO.class);
        return userDao.editUserEmail(map);
    }
}
