package com.lec.spring.app;

import com.lec.spring.app.persistence.ColorDAO;
import com.lec.spring.app.persistence.ListDAO;
import org.springframework.ui.Model;

import java.util.Map;

public class LCommand implements ACommand{
    @Override
    public void execute(Model model) {
        Map<String, Object> map = model.asMap();

        ListDAO dao = C.sqlSession.getMapper(ListDAO.class);
        model.addAttribute("List", dao.select());
    }
}
