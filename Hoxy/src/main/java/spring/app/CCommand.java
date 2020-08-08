package com.lec.spring.app;

import com.lec.spring.app.persistence.AppDAO;
import com.lec.spring.app.persistence.ColorDAO;
import org.springframework.ui.Model;

import java.util.Map;

public class CCommand implements ACommand{
    @Override
    public void execute(Model model) {
        Map<String, Object> map = model.asMap();
        int h_uid = (Integer) map.get("h_uid");
        AppDAO dao = C.sqlSession.getMapper(AppDAO.class);
        model.addAttribute("ComInfo", dao.companyInfo(h_uid));
    }
}
