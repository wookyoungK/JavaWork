package com.lec.spring.app;

import com.lec.spring.app.persistence.AppDAO;
import com.lec.spring.app.persistence.ColorDAO;
import org.springframework.ui.Model;

import java.util.Map;

public class GCommand implements ACommand{
    @Override
    public void execute(Model model) {
        Map<String, Object> map = model.asMap();

        ColorDAO dao = C.sqlSession.getMapper(ColorDAO.class);
        model.addAttribute("Color", dao.select());
    }
}
