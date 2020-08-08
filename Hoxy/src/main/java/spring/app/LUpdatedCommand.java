package com.lec.spring.app;

import com.lec.spring.app.persistence.ColorDAO;
import com.lec.spring.app.persistence.ListDAO;
import org.springframework.ui.Model;

import java.util.Map;

public class LUpdatedCommand implements ACommand{
    @Override
    public void execute(Model model) {
        Map<String, Object> map = model.asMap();
        int graphView1;
        int graphView2;
        int graphView3;
        int graphView4;
        int graphView5;
        int graphView6;
        int graphView7;
       if(map.get("graphView1") ==null){
           graphView1 = 0;
       }else{
           graphView1 = 1;
        }
        if(map.get("graphView2") ==null){
            graphView2 = 0;
        }else{
            graphView2 = 1;
        }
        if(map.get("graphView3") ==null){
            graphView3 = 0;
        }else{
            graphView3 = 1;
        }
        if(map.get("graphView4") ==null){
            graphView4 = 0;
        }else{
            graphView4 = 1;
        }
        if(map.get("graphView5") ==null){
            graphView5 = 0;
        }else{
            graphView5 = 1;
        }
        if(map.get("graphView6") ==null){
            graphView6 = 0;
        }else{
            graphView6 = 1;
        }
        if(map.get("graphView7") ==null){
            graphView7 = 0;
        }else{
            graphView7 = 1;
        }
        System.out.println(graphView1+graphView2+graphView3+graphView4);

        ListDAO dao = C.sqlSession.getMapper(ListDAO.class);
        model.addAttribute("result", dao.update(graphView1,graphView2,graphView3,graphView4,graphView5,graphView6,graphView7));
    }
}
