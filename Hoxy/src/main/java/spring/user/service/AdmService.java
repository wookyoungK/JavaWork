package com.lec.spring.user.service;

import com.lec.spring.user.domain.AdmDTO;
import com.lec.spring.user.persistence.AdmDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class AdmService {

    @Autowired
    private SqlSessionTemplate template;

    @Autowired
    private UserRedundantLoginService service;

    private AdmDAO admDAO;

    public int admLogin_service(AdmDTO admDTO, HttpSession httpSession, String adm_check, HttpServletResponse response) {
        System.out.println("AdmLoginService 객체 확인 : " + admDTO);

        String a_id = admDTO.getA_id();
        String a_pw = admDTO.getA_pw();
        System.out.println(a_id + " " + a_pw);

        admDAO = template.getMapper(AdmDAO.class);
        System.out.println(admDAO);

        AdmDTO dto = admDAO.loginAdm(a_id);
        System.out.println("로그인 객체 확인 : " + dto);

        int result = 0;

        if (dto == null) {
            result = 0;
            return result;
        }

        if (dto != null) {
            // 아이디,비번,스토어id가 모두 같은경우
            System.out.println("1단계");
            if (dto.getA_id().equals(a_id) && dto.getA_pw().equals(a_pw)) {
                System.out.println("2단계");
                // 쿠키 체크 검사
                Cookie cookie = new Cookie("com_check", a_id);
                System.out.println(cookie);
                System.out.println(adm_check);
                //if (adm_check.equals("true")) {
                //    response.addCookie(cookie);
                //   System.out.println("3단계-쿠키 아이디저장 O");
                // 쿠키 확인
                // System.out.println("Service check" + cookie);
                //} else {
                //    System.out.println("3단계-쿠키 아이디저장 X");
                //   cookie.setMaxAge(0);
                //   response.addCookie(cookie);
                //}

                httpSession.setAttribute("admSession", dto);
                System.out.println("어드민 세션 : " + httpSession.getAttribute("admSession"));

                result = 1;

                //
                httpSession.setAttribute("loginId", admDTO.getA_id());

                service.printloginUsers();
                if (service.isUsing(admDTO.getA_id())) {
                    result = -3;
                    System.out.println("중복로그인");
                } else {
                    service.setSession(httpSession, admDTO.getA_id());
                }
                //


            }
        }
        return result;
    }
}
