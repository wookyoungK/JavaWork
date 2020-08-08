package com.lec.spring.user.controller;

import com.lec.spring.user.domain.UserDTO;
import com.lec.spring.user.service.UserMailSendService;
import com.lec.spring.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class userRegisterController {

    @Autowired
    private UserService userService;

    //@Autowired
    //private UserMailSendService mailSender;

    @RequestMapping(value = "/user/idCheck", method = RequestMethod.GET)
    @ResponseBody
    public int idCheck(@RequestParam("u_id") String u_id){
        return userService.userIdCheck(u_id);
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public String regGet() throws Exception{
        return "user/register";
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public String register(UserDTO userDTO, Model model, HttpServletRequest request) throws Exception {
        userService.regist(userDTO);
        return "redirect:/";

    }

    //@RequestMapping(value = "/user/key_alter", method = RequestMethod.GET)
    //public String key_alterConfirm(@RequestParam("u_id") String u_id, @RequestParam("u_key") String u_key){
    //    return "user/regSuccess";
    //}

}
