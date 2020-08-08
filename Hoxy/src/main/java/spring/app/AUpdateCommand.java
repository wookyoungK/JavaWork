package com.lec.spring.app;

import com.lec.spring.app.persistence.AppDAO;
import org.springframework.ui.Model;

import java.util.Map;

public class AUpdateCommand implements ACommand {
    @Override
    public void execute(Model model) {
        Map<String, Object> map = model.asMap();
        int a_uid = (Integer) map.get("a_uid");
        int r_uid = (Integer) map.get("r_uid");

        AppDAO dao = C.sqlSession.getMapper(AppDAO.class);
        model.addAttribute("result",dao.updateByAid(a_uid,r_uid));

    }


}
