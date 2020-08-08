package com.lec.spring.user.persistence;

import com.lec.spring.user.domain.UserDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public interface UserDAO {

    int register(UserDTO userDTO) throws Exception;
    int checkOverId(String u_id);
    int GetKey(String u_id, String u_key);
    //int alter_userKey(String u_id, String key);
    String searchId(@Param("u_name")String u_name, @Param("u_phoneNum")String u_phoneNum);
    //int searchPassword(String u_id, String u_email, String key);
    UserDTO loginUser(@Param("u_id")String u_id);
    UserDTO getMyPage(String u_id);// 마이페이지 메서드
    int editUserName(HashMap<String,String> map);// 유저 이름 수정
    int editUserPhone(HashMap<String,String> map);// 유저 폰번호 수정
    int editUserPw(HashMap<String,String> map);// 유저 비밀번호 수정
    int editUserEmail(HashMap<String,String> map);// 유저 이메일 수정
    int deleteUser(String user_id);// 유저 삭제
    int checkOverEmail(String user_email);// 이메일 중복 체크
    String checkOverPhoneNum(String userPhone);// 유저 전화번호 중복 체크

}
