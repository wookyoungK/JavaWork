package com.lec.spring.app;

import com.lec.spring.app.persistence.ColorDAO;
import org.springframework.ui.Model;

import java.util.Map;

public class GUpdatedCommand implements ACommand{
    @Override
    public void execute(Model model) {
        Map<String, Object> map = model.asMap();

        String colo1 = (String)map.get("color1");
        String colo2 = (String)map.get("color2");
        String colo3 = (String)map.get("color3");
        ColorDAO dao = C.sqlSession.getMapper(ColorDAO.class);
        model.addAttribute("result", dao.update(colo1,colo2,colo3));
    }
}
