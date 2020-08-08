package com.lec.spring.app;

import com.lec.spring.app.ACommand;
import com.lec.spring.app.domain.AppDTO;
import com.lec.spring.app.persistence.AppDAO;
import org.springframework.ui.Model;

import java.util.Map;

public class AWriteCommand  implements ACommand {
    @Override
    public void execute(Model model) {
        Map<String, Object> map = model.asMap();
        AppDTO dto = (AppDTO)map.get("dto");



        AppDAO dao = C.sqlSession.getMapper(AppDAO.class);
        if(dao.selectAppList(dto)>0) {
            model.addAttribute("result", -1);

        }else{
        model.addAttribute("result",dao.insert(dto));}

    }


}
