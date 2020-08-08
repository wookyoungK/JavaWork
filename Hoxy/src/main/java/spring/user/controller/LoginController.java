package com.lec.spring.user.controller;

import com.lec.spring.user.domain.AdmDTO;
import com.lec.spring.user.domain.ComDTO;
import com.lec.spring.user.domain.UserDTO;
import com.lec.spring.user.service.AdmService;
import com.lec.spring.user.service.ComLoginService;
import com.lec.spring.user.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    private UserLoginService login_service;

    @Autowired
    private ComLoginService comLoginService;

    @Autowired
    private AdmService admService;

    @RequestMapping(value = "/user/loginchoice", method = RequestMethod.GET)
    public String userLoginCh(HttpSession session, Model model) {

        // 세션만료
        session.invalidate();

        return "user/loginchoice";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public String userLogin(HttpSession session, Model model) {

        // 세션만료
        session.invalidate();

        return "user/login";
    }

    @RequestMapping(value = "/com/login", method = RequestMethod.GET)
    public String comLogin(HttpSession session, Model model){
        session.invalidate();
        return "com/login";
    }

    @RequestMapping(value = "/admin/login", method = RequestMethod.GET)
    public String admLogin(HttpSession session, Model model){
        session.invalidate();
        return "admin/login";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @ResponseBody
    public int userLoingPass(UserDTO userDTO, HttpSession httpSession, HttpServletRequest request,
                             HttpServletResponse response, Model model) {

        // userLogin.jsp에서 아이디기억하기 name값(remember) 가져오기
        String user_check = request.getParameter("remember_userId");

        // 로그인 메서드
        int result = login_service.userLogin_service(userDTO, httpSession, user_check, response);
        System.out.println(result);

        return result;
    }

    @RequestMapping(value = "/com/login", method = RequestMethod.POST)
    @ResponseBody
    public int comLoginPass(ComDTO comDTO, HttpSession httpSession, HttpServletRequest request, HttpServletResponse response, Model model){
        String com_check = request.getParameter("remember_comId");

        int result = comLoginService.comLogin_service(comDTO, httpSession, com_check, response);
        System.out.println(result);

        return result;
    }

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    @ResponseBody
    public int admLoginPass(AdmDTO admDTO, HttpSession httpSession, HttpServletRequest request, HttpServletResponse response, Model model){
        String adm_check = request.getParameter("remember_admId");

        int result = admService.admLogin_service(admDTO, httpSession, adm_check, response);

        System.out.println(result);

        return result;
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpSession session){
        session.invalidate();
        ModelAndView mav = new ModelAndView("redirect:/");
        return mav;
    }

    @RequestMapping(value = "user/regSuccess", method = RequestMethod.GET)
    public String user() {
        return "user/regSuccess";
    }

}
