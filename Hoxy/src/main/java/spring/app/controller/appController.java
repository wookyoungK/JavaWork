package com.lec.spring.app.controller;

import com.lec.spring.app.*;
import com.lec.spring.app.domain.AppDTO;
import com.lec.spring.hire.command.HCommand;
import com.lec.spring.hire.command.HViewCommand;
import com.lec.spring.user.domain.ComDTO;
import com.lec.spring.user.domain.UserDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/app")
public class appController {

    private ACommand command;
    private HCommand command2;

    // MyBabatis
    private SqlSession sqlSession;


    public appController() {
    }

    @Autowired
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
        C.sqlSession = sqlSession;
    }

    @RequestMapping("/hireDetail")
    public String hireDetail(int h_uid, Model model, HttpSession session) {

        if (session.getAttribute("userSession") != null) {
            UserDTO dto = (UserDTO) session.getAttribute("userSession");
            model.addAttribute("user", dto);
            model.addAttribute("u_uid", dto.getU_uid());
            model.addAttribute("u_name", dto.getU_name());
        }


        model.addAttribute("h_uid", h_uid);
        //model.addAttribute("uid", h_uid);
        new HViewCommand().excute(model);
        new GCommand().execute(model);
        new RListCommand().execute(model);
        new CCommand().execute(model);
        return "/hire/hireDetail";
    }

    @RequestMapping(value = "/appWriteOk", method = RequestMethod.POST)
    public String appWriteOk(AppDTO dto, Model model) {
        model.addAttribute("dto", dto);
        new AWriteCommand().execute(model);
        return "/application/appWriteOk";
    }

    @RequestMapping("/appmyList")
    public String appmyList(HttpSession session,Model model
    ,String period,String view, String search) {
        if (session.getAttribute("userSession") != null) {
            UserDTO dto = (UserDTO) session.getAttribute("userSession");
            model.addAttribute("u_uid", dto.getU_uid());

            //조회기간
            //열람, 미열람
            //검색
            if(period!=null) model.addAttribute("period", period);
            if(view!=null) model.addAttribute("view", view);
            if(search!=null) model.addAttribute("search", search);

            new AListCommand().execute(model);
            new RListCommand2().execute(model);
            return "/application/appmyList";
        }else {

            return "/user/login";
        }


    }

    @RequestMapping("/appcomList")
    public String appcomList(HttpSession session,Model model
            ,String hid,String view, String search) {
        if (session.getAttribute("comSession") != null) {
            ComDTO dto = (ComDTO) session.getAttribute("comSession");
            model.addAttribute("c_uid", dto.getC_uid());

            //공고 선택
            //열람, 미열람
            //검색
            if(hid!=null) model.addAttribute("hid", hid);
            if(view!=null) model.addAttribute("view", view);
            if(search!=null) model.addAttribute("search", search);

            new AListCommand2().execute(model);
            return "/application/appcomList";
        }else {

            return "/com/login";
        }


    }

    @RequestMapping("/appDelete")
    public String appDelete(int a_uid, Model model) {

        model.addAttribute("a_uid", a_uid);
        new ADeleteCommand().execute(model);
        return "/application/appDeleteOk";
    }

    @RequestMapping("/appUpdate")
    public String appUpdate(int a_uid, int r_uid, Model model) {

        model.addAttribute("a_uid", a_uid);
        model.addAttribute("r_uid", r_uid);
        new AUpdateCommand().execute(model);
        return "/application/appUpdateOk";
    }

    @RequestMapping("/colorUpdate")
    public String colorUpdate(String color1, String color2, String color3, Model model) {



        model.addAttribute("color1", color1);
        model.addAttribute("color2", color2);
        model.addAttribute("color3", color3);
        new GUpdatedCommand().execute(model);
        return "/application/colorUpdateOk";
    }

    @RequestMapping("/listUpdate")
    public String listUpdate(String graphView1, String graphView2, String graphView3, String graphView4, String graphView5, String graphView6, String graphView7, Model model) {

        model.addAttribute("graphView1", graphView1);
        model.addAttribute("graphView2", graphView2);
        model.addAttribute("graphView3", graphView3);
        model.addAttribute("graphView4", graphView4);
        model.addAttribute("graphView5", graphView5);
        model.addAttribute("graphView6", graphView6);
        model.addAttribute("graphView7", graphView7);

        new LUpdatedCommand().execute(model);
        return "/application/listUpdateOk";
    }

    @RequestMapping("/color")
    public String color(Model model) {
        new LCommand().execute(model);
        new GCommand().execute(model);
        return "index";
    }

    @RequestMapping("/appviewUpdate")
    public String appviewUpdate(int a_uid ,Model model) {

        model.addAttribute("a_uid", a_uid);
        new AUpdateCommand2().execute(model);
        return "/application/appUpdateOk2";
    }
}
