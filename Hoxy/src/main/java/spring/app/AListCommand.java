package com.lec.spring.app;

import com.lec.spring.app.persistence.AppDAO;
import org.springframework.ui.Model;

import java.util.Map;

public class AListCommand implements ACommand {
    @Override
    public void execute(Model model) {
        Map<String, Object> map = model.asMap();
        int u_uid = (Integer) map.get("u_uid");
        //period, view, search

        int period = 365;
        if(map.get("period")!=null){
            period= Integer.parseInt((String)map.get("period"));
        }


        int view1 = 0;
        int view2 = 1;
        if(map.get("view")!=null&& Integer.parseInt((String)map.get("view")) !=2){
            view1= Integer.parseInt((String)map.get("view"));
            view2= Integer.parseInt((String)map.get("view"));

        }
        String search = "%%";
        if(map.get("view")!=null){
            search = "%"+ map.get("search") +"%";
        }
        AppDAO dao = C.sqlSession.getMapper(AppDAO.class);
        model.addAttribute("Alist", dao.selectAByUid(u_uid,period,view1,view2,search));
    }
}
