package com.lec.spring.user.controller;

import com.lec.spring.user.service.UserSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SearchController {

    @Autowired
    private UserSearchService searchService;

    @RequestMapping(value = "/user/userSearch", method = RequestMethod.GET)
    public String userSearch(Model model) {

       return "user/userSearch";
    }

    // 아이디 찾기
    @RequestMapping(value = "/user/userSearch", method = RequestMethod.POST)
    @ResponseBody
    public String userIdSearch(@RequestParam("inputName_1") String u_name,
                               @RequestParam("inputPhone_1") String u_phoneNum) {

        String result = searchService.get_searchId(u_name, u_phoneNum);
        System.out.println(u_name);
        System.out.println(u_phoneNum);

        System.out.println("컨트롤러 확인" + result);

        return result;
    }

}
