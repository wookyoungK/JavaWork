package com.lec.spring.app;

import com.lec.spring.app.domain.AppDTO;
import com.lec.spring.app.persistence.AppDAO;
import com.lec.spring.app.persistence.ListDAO;
import com.lec.spring.user.domain.UserDTO;
import com.lec.spring.user.persistence.ComDAO;
import org.springframework.ui.Model;

import javax.swing.event.ListDataEvent;
import java.util.List;
import java.util.Map;

public class RListCommand implements ACommand{

    @Override
    public void execute(Model model) {
        Map<String, Object> map = model.asMap();
        AppDAO dao = C.sqlSession.getMapper(AppDAO.class);
        ListDAO listDAO = C.sqlSession.getMapper(ListDAO.class);
        if(map.get("u_name")!=null) {
            int u_uid = (Integer) map.get("u_uid");
            model.addAttribute("Rlist", dao.selectRByUid(u_uid));
        }else{
            model.addAttribute("loginChk","false");
        }
        int h_uid = (Integer) map.get("h_uid");

        model.addAttribute("graphList", listDAO.select());

        model.addAttribute("totalApp", dao.selectByhid(h_uid).size());//지원자수
        model.addAttribute("gender1", dao.genderCount1(h_uid).size());//성별 (남)
        model.addAttribute("gender2", dao.genderCount2(h_uid).size());//성별 (여)




        List<AppDTO> age =  dao.age(h_uid);//나이

        int age20=0;
        int age30=0;
        int age40=0;
        int age50=0;
        int age60=0;


        for(int i = 0; i<age.size();i++){
            AppDTO dto = age.get(i);
            int ageNum=0 ;

            try{
                ageNum = dto.getAge();
            }catch (Exception e)
            {}

                if (ageNum >= 20 && ageNum < 30) {
                    age20++;
                }else if(ageNum>= 30 && ageNum < 40){
                    age30++;
                }else if(ageNum >= 40 && ageNum< 50){
                    age40++;
                }else if(ageNum >= 50 && ageNum < 60){
                    age50++;
                }else
                    {
                    age60++;
                }


        }


        model.addAttribute("age20", age20);//나이
        model.addAttribute("age30", age30);//나이
        model.addAttribute("age40", age40);//나이
        model.addAttribute("age50", age50);//나이
        model.addAttribute("age60", age60);//나이




/*
        model.addAttribute("age20", dao.age20(h_uid));//나이
        model.addAttribute("age30", dao.age30(h_uid));//나이
        model.addAttribute("age40", dao.age40(h_uid));//나이
        model.addAttribute("age50", dao.age50(h_uid));//나이
        model.addAttribute("age60", dao.age60(h_uid));//나이
        */


        List<AppDTO> toeic = age;//토익
        //List<AppDTO> toeic =  dao.toeic(h_uid);//토익

        int toeic500=0;
        int toeic600=0;
        int toeic700=0;
        int toeic800=0;
        int toeic900=0;


        for(int i = 0; i<toeic.size();i++){
            AppDTO dto = toeic.get(i);
            int toeicGrade=0 ;

            try{
                toeicGrade = Integer.parseInt(dto.getToeic());
            }catch (Exception e)
            {}

            if (toeicGrade < 600) {
                toeic500++;
            }else if(toeicGrade>= 600 && toeicGrade < 700){
                toeic600++;
            }else if(toeicGrade >= 700 && toeicGrade< 800){
                toeic700++;
            }else if(toeicGrade >= 800 && toeicGrade < 900){
                toeic800++;
            }else
            {
                toeic900++;
            }


        }



        model.addAttribute("toeic500", toeic500);//토익
        model.addAttribute("toeic600", toeic600);//토익
        model.addAttribute("toeic700", toeic700);//토익
        model.addAttribute("toeic800", toeic800);//토익
        model.addAttribute("toeic900", toeic900);//토익


/*
        model.addAttribute("toeic500", dao.toeic500(h_uid));//토익
        model.addAttribute("toeic600", dao.toeic600(h_uid));//토익
        model.addAttribute("toeic700", dao.toeic700(h_uid));//토익
        model.addAttribute("toeic800", dao.toeic800(h_uid));//토익
        model.addAttribute("toeic900", dao.toeic900(h_uid));//토익

*/


        List<AppDTO> career =  age;
        //List<AppDTO> career =  dao.career(h_uid);//토익

        int career0=0;
        int career1=0;
        int career3=0;
        int career5=0;
        int career10=0;


        for(int i = 0; i<career.size();i++){
            AppDTO dto = career.get(i);
            int careerYear=0 ;

            try{
                careerYear = dto.getCareer();
            }catch (Exception e)
            {}

            if (careerYear ==0) {
                career0++;
            }else if(careerYear>= 0 && careerYear < 1){
                career1++;
            }else if(careerYear >= 1 && careerYear< 3){
                career3++;
            }else if(careerYear >= 3 && careerYear < 5){
                career5++;
            }else
            {
                career10++;
            }


        }


        model.addAttribute("career0", career0);//경력
        model.addAttribute("career1", career1);//경력
        model.addAttribute("career3", career3);//경력
        model.addAttribute("career5", career5);//경력
        model.addAttribute("career10", career10);//경력

        /*
        model.addAttribute("career0", dao.career0(h_uid));//경력
        model.addAttribute("career1", dao.career1(h_uid));//경력
        model.addAttribute("career3", dao.career3(h_uid));//경력
        model.addAttribute("career5", dao.career5(h_uid));//경력
        model.addAttribute("career10", dao.career10(h_uid));//경력

         */

    }
}
