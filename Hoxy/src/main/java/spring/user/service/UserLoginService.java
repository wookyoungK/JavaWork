package com.lec.spring.user.service;

import com.lec.spring.user.domain.UserDTO;
import com.lec.spring.user.persistence.UserDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class UserLoginService {

    @Autowired
    private SqlSessionTemplate userSqlSession;

    @Autowired
    private UserRedundantLoginService loginManager;

    private UserDAO userDao;


    public int userLogin_service(UserDTO userDTO, HttpSession httpSession, String user_check,
                                 HttpServletResponse response) {

        System.out.println("UserLoginService // 로그인 객체 확인 userVO : " + userDTO);
        String u_id = userDTO.getU_id();
        String u_pw = userDTO.getU_pw();
        System.out.println(u_id + " " + u_pw);

        userDao = userSqlSession.getMapper(UserDAO.class);
        UserDTO dto = userDao.loginUser(u_id);

        System.out.println("UserLoginService // 로그인 객체 확인 vo : " + dto);

        // 로그인 결과값
        int result = 0;

        // 회원 정보가 없을 시
        if (dto == null) {
            result = 0;
            return result;
        }

        // 인증 안 했을 경우 인증하란 메세지 발생
        //String y = "Y";
        //if (!(dto.getU_key().equals(y))) {
        //    result = -2;
        //    return result;
        //}

        // 입력한 아이디 통해 정보가 존재 할 경우
        if (dto != null) {
            // 아이디,비번 모두 같은경우
            System.out.println("1단계");
            if (dto.getU_id().equals(u_id) && dto.getU_pw().equals(u_pw)) {
                System.out.println("2단계");
                // 쿠키 체크 검사
                Cookie cookie = new Cookie("user_check", u_id);
                System.out.println(cookie);
                //if (user_check.equals("true")) {
                 //   response.addCookie(cookie);
                 //   System.out.println("3단계-쿠키 아이디저장 O");
                    // 쿠키 확인
                //     System.out.println("Service check" + cookie);
                //} else {
                //    System.out.println("3단계-쿠키 아이디저장 X");
                //    cookie.setMaxAge(0);
                //    response.addCookie(cookie);
                //}

                //System.out.println("3단계-로그인단계");
                // 세션 저장하기 전에 비밀번호 가리기
                //dto.setU_pw("");

                // 세션에 dto 객체 저장
                httpSession.setAttribute("userSession", dto);
                System.out.println("회원아이디 세션 userSession : " + httpSession.getAttribute("userSession"));

                result = 1;

                // 중복로그인 start

                // 접속자 아이디를 세션에 담는다.
                httpSession.setAttribute("loginId", userDTO.getU_id());

                // 이미 접속한 아이디인지 체크한다.
                loginManager.printloginUsers(); // 접속자 리스트
                if (loginManager.isUsing(userDTO.getU_id())) {
                    result = -3;
                    System.out.println("@@@@@@@@@@@@@@@@@@@[중복로그인 발생]@@@@@@@@@@@@@@@@@@");
                } else {
                    loginManager.setSession(httpSession, userDTO.getU_id());
                }

                // 중복로그인 end
            }
        }

        return result;
    }


}
