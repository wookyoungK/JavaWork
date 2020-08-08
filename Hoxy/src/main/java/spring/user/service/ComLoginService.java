package com.lec.spring.user.service;

import com.lec.spring.user.domain.ComDTO;
import com.lec.spring.user.persistence.ComDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class ComLoginService {
    @Autowired
    private SqlSessionTemplate sessionTemplate;

    @Autowired
    private UserRedundantLoginService service;

    private ComDAO comDAO;

    public int comLogin_service(ComDTO comDTO, HttpSession httpSession, String com_check, HttpServletResponse response) {
        System.out.println("ComLoginService 객체 확인 : " + comDTO);

        String c_id = comDTO.getC_id();
        String c_pw = comDTO.getC_pw();

        comDAO = sessionTemplate.getMapper(ComDAO.class);
        ComDTO dto = comDAO.loginCom(c_id);

        System.out.println("로그인 객체 확인 : " + dto);

        int result = 0;

        if (dto == null) {
            result = 0;
            return result;
        }

        /*if (dto != null) {
            // 아이디,비번,스토어id가 모두 같은경우
            System.out.println("1단계");
            if (dto.getC_id().equals(c_id) && dto.getC_pw().equals(c_pw)) {
                System.out.println("2단계");
                // 쿠키 체크 검사
                Cookie cookie = new Cookie("com_check", c_id);
                System.out.println(cookie);
                System.out.println(com_check);
                if (com_check.equals("true")) {
                    response.addCookie(cookie);
                    System.out.println("3단계-쿠키 아이디저장 O");
                    // 쿠키 확인
                    // System.out.println("Service check" + cookie);
                } else {
                    System.out.println("3단계-쿠키 아이디저장 X");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }*/

                httpSession.setAttribute("comSession", dto);
                System.out.println("회사 세션 : " + httpSession.getAttribute("comSession"));

                result = 1;

                //
                httpSession.setAttribute("loginId", comDTO.getC_id());

                service.printloginUsers();
                if (service.isUsing(comDTO.getC_id())) {
                    result = -3;
                    System.out.println("중복로그인");
                } else {
                    service.setSession(httpSession, comDTO.getC_id());
                }
                //

        return result;
    }
}