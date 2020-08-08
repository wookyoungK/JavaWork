package com.lec.spring.user.controller;

import com.lec.spring.user.domain.UserDTO;
import com.lec.spring.user.service.UserMyPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserMypageController {

    @Autowired
    UserMyPageService service;

    //@RequestMapping(value = "/user/userMypage", method = RequestMethod.GET)
    //public String getusermy() throws Exception{
     //  return "/user/userMypage";
    //}

    @RequestMapping(value = "/user/userMypage")
    public String userMypage(HttpSession session, Model model) {

        UserDTO userData = (UserDTO) session.getAttribute("userSession");

        System.out.println(userData);

        String u_id = userData.getU_id();

        System.out.println(u_id);

        model.addAttribute("user",service.getMyPage(u_id));

        return "user/userMypage";
    }

    //사용자 삭제
    @RequestMapping("/user/userDelete")
    public String delete(UserDTO userDTO) {

        String u_id = userDTO.getU_id();
        service.deleteUser(u_id);

        return "user/userMypage";
    }

    //이름 수정
    @RequestMapping(value = "/user/userEditname", method = RequestMethod.POST)
    @ResponseBody
    public int editName(UserDTO userDTO) {
        String u_name = userDTO.getU_name();
        String u_id = userDTO.getU_id();
        return service.editName(u_name, u_id);
    }

    //비밀번호 수정
    @RequestMapping(value = "/user/userEditpw")
    @ResponseBody
    public int editPw(UserDTO userDTO) {
        String u_pw = userDTO.getU_pw();
        String u_id = userDTO.getU_id();
        return service.editPw(u_pw, u_id);
    }

    //폰번호 수정
    @RequestMapping(value = "/user/userEditphone")
    @ResponseBody
    public int editPhone(UserDTO userDTO) {
        String u_phoneNum = userDTO.getU_phoneNum();
        String u_id = userDTO.getU_id();
        return service.editPhone(u_phoneNum, u_id);
    }

    //이메일 수정
    @RequestMapping(value = "/user/userEditemail")
    @ResponseBody
    public int editEmail(UserDTO userDTO) {
        String u_id = userDTO.getU_id();
        String u_email = userDTO.getU_email();
        return service.editEmail(u_email, u_id);
    }

}