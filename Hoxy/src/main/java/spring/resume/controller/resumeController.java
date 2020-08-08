package com.lec.spring.resume.controller;


import com.lec.spring.resume.domain.resumeListDTO;
import com.lec.spring.resume.domain.resumeUpdateDTO;
import com.lec.spring.resume.domain.resumeViewDTO;
import com.lec.spring.resume.domain.resumeWriteVO;
import com.lec.spring.resume.service.*;
import com.lec.spring.user.domain.ComDTO;
import com.lec.spring.user.domain.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

@Controller
@RequestMapping("/resume")
public class resumeController {

    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private com.lec.spring.resume.service.resumeWriteService resumeWriteService;

    @Autowired
    private resumeListService resumeListService;

    @Autowired
    private com.lec.spring.resume.service.resumeDeleteService resumeDeleteService;

    @Autowired
    private resumeUpdateService resumeUpdateService;

    @Autowired
    private resumeUpdateOkService resumeUpdateOkService;

    @Autowired
    private resumeViewService resumeViewService;


    int r_uid = 0;

    @RequestMapping("/resumeWrite")
    public String Write(Model model, HttpSession session) {

        UserDTO dto = (UserDTO) session.getAttribute("userSession");
        if (dto != null) {

            return "resume/resumeWrite";
        }else{
            return "user/login";
        }


    }


    @RequestMapping("/upload")
    public String myUpload() {

        return "resume/upload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(MultipartHttpServletRequest mtf, HttpSession session) throws Exception {
        // 파일 태그
        String fileTag = "file";
        // 업로드 파일이 저장될 경로
        String filePath = mtf.getSession().getServletContext().getRealPath("/");
        // 파일 이름
        MultipartFile file = mtf.getFile(fileTag);

        String fileName = file.getOriginalFilename();

        UserDTO dto = (UserDTO) session.getAttribute("userSession");

        System.out.println(dto.getU_uid());

        fileUploadService.fileUpload(dto.getU_uid(), fileName);
        // 파일 전송
        try {
            file.transferTo(new File(filePath + fileName));
            System.out.println("파일생성 성공");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("업로드 오류");

        }
        return "resume/upload";
    }

    @RequestMapping("/resumeWriteOk")
    public String resumeWriteOkA(){

        return "resume/resumeWriteOk";
    }

    @RequestMapping(value = "/resumeWriteOk", method = RequestMethod.POST)
    public String resumeWriteOk(resumeWriteVO resumeWriteVO, Model model, HttpSession session) {

        UserDTO dto = (UserDTO) session.getAttribute("userSession");



        int gender = 1;
        String total = "0";
        String score = "0";
        String career = "신입";
        if(!resumeWriteVO.getToeicScore().equals("")){
            score = resumeWriteVO.getToeicScore();
        }

        System.out.println(dto.getU_uid()+ resumeWriteVO.getSubject() + resumeWriteVO.getBasicName() + gender+ resumeWriteVO.getBasicBirth() + resumeWriteVO.getBasicEmail() + resumeWriteVO.getBasicPhone() + resumeWriteVO.getBasicAddrs() + resumeWriteVO.getBasicAddrs2() + resumeWriteVO.getResumeStatus() + "초등학교 졸업" + resumeWriteVO.getEleEduName() + resumeWriteVO.getEduEleArea() + resumeWriteVO.getEduElePeriod() + " ~ " + resumeWriteVO.getEduElePeriod2() + resumeWriteVO.getEduHighDep() + resumeWriteVO.getEduUniYear() + resumeWriteVO.getEduUniName() + resumeWriteVO.getEduUniPeriod() + " ~ " + resumeWriteVO.getEduElePeriod2() + resumeWriteVO.getEduUniMajor()+ resumeWriteVO.getEduUniDep()+ resumeWriteVO.getEduUniArea()+ "초등학교 졸업," + resumeWriteVO.getEleEduName()+ career+ resumeWriteVO.getComName()+ resumeWriteVO.getComPeriod() + " ~ " + resumeWriteVO.getComPeriod2()+ resumeWriteVO.getComPosition()+ resumeWriteVO.getComJobType()+ resumeWriteVO.getComIncome()+ total+ resumeWriteVO.getHopeService()+ resumeWriteVO.getHopeIncome() + resumeWriteVO.getHopeArea() + resumeWriteVO.getHopeJobType()+ resumeWriteVO.getIntroduction()+ resumeWriteVO.getIntroTitle()+ score + resumeWriteVO.getPortUrl());


        if(resumeWriteVO.getOptionSelected().equals("남")){
            gender = 0;
        }
        if(!resumeWriteVO.getComName().equals("")){
            career = "경력";
        }
        if(!resumeWriteVO.getTotalCareer().equals("")){
            total= resumeWriteVO.getTotalCareer();
            System.out.println(total);
        }


        if(!resumeWriteVO.getEleEduName().equals("")){
        resumeWriteService.resumeWrite(dto.getU_uid(), resumeWriteVO.getSubject(), resumeWriteVO.getBasicName(), gender, resumeWriteVO.getBasicBirth(), resumeWriteVO.getBasicEmail(), resumeWriteVO.getBasicPhone(), resumeWriteVO.getBasicAddrs(), resumeWriteVO.getBasicAddrs2(), resumeWriteVO.getResumeStatus(), "초등학교 졸업", resumeWriteVO.getEleEduName(), resumeWriteVO.getEduEleArea(), resumeWriteVO.getEduElePeriod() + " ~ " + resumeWriteVO.getEduElePeriod2(), resumeWriteVO.getEduHighDep(), resumeWriteVO.getEduUniYear(), resumeWriteVO.getEduUniName(), resumeWriteVO.getEduUniPeriod() + " ~ " + resumeWriteVO.getEduElePeriod2(), resumeWriteVO.getEduUniMajor(), resumeWriteVO.getEduUniDep(), resumeWriteVO.getEduUniArea(), "초등학교 졸업," + resumeWriteVO.getEleEduName(), career, resumeWriteVO.getComName(), resumeWriteVO.getComPeriod() + " ~ " + resumeWriteVO.getComPeriod2(), resumeWriteVO.getComPosition(), resumeWriteVO.getComJobType(), resumeWriteVO.getComIncome(), total, resumeWriteVO.getHopeService(), resumeWriteVO.getHopeIncome(), resumeWriteVO.getHopeArea(), resumeWriteVO.getHopeJobType(), resumeWriteVO.getIntroduction(), resumeWriteVO.getIntroTitle(), score, resumeWriteVO.getPortUrl());
        }
        else if(!resumeWriteVO.getEduMedName().equals("")){
            resumeWriteService.resumeWrite(dto.getU_uid(), resumeWriteVO.getSubject(), resumeWriteVO.getBasicName(), gender, resumeWriteVO.getBasicBirth(), resumeWriteVO.getBasicEmail(), resumeWriteVO.getBasicPhone(), resumeWriteVO.getBasicAddrs(), resumeWriteVO.getBasicAddrs2(), resumeWriteVO.getResumeStatus(), "중학교 졸업", resumeWriteVO.getEduMedName(), resumeWriteVO.getEduMedArea(), resumeWriteVO.getEduMedPeriod() + " ~ " + resumeWriteVO.getEduMedPeriod2(), resumeWriteVO.getEduHighDep(), resumeWriteVO.getEduUniYear(), resumeWriteVO.getEduUniName(), resumeWriteVO.getEduUniPeriod() + " ~ " + resumeWriteVO.getEduElePeriod2(), resumeWriteVO.getEduUniMajor(), resumeWriteVO.getEduUniDep(), resumeWriteVO.getEduUniArea(), "중학교 졸업," + resumeWriteVO.getEduMedName(), career, resumeWriteVO.getComName(), resumeWriteVO.getComPeriod() + " ~ " + resumeWriteVO.getComPeriod2(), resumeWriteVO.getComPosition(), resumeWriteVO.getComJobType(), resumeWriteVO.getComIncome(), total, resumeWriteVO.getHopeService(), resumeWriteVO.getHopeIncome(), resumeWriteVO.getHopeArea(), resumeWriteVO.getHopeJobType(), resumeWriteVO.getIntroduction(), resumeWriteVO.getIntroTitle(), score, resumeWriteVO.getPortUrl());
        }
        else if(!resumeWriteVO.getEduHighName().equals("")){
            resumeWriteService.resumeWrite(dto.getU_uid(), resumeWriteVO.getSubject(), resumeWriteVO.getBasicName(), gender, resumeWriteVO.getBasicBirth(), resumeWriteVO.getBasicEmail(), resumeWriteVO.getBasicPhone(), resumeWriteVO.getBasicAddrs(), resumeWriteVO.getBasicAddrs2(), resumeWriteVO.getResumeStatus(), "고등학교 졸업", resumeWriteVO.getEduHighName(), resumeWriteVO.getEduHighArea(), resumeWriteVO.getEduHighPeriod() + " ~ " + resumeWriteVO.getEduHighPeriod2(), resumeWriteVO.getEduHighDep(), resumeWriteVO.getEduUniYear(), resumeWriteVO.getEduUniName(), resumeWriteVO.getEduUniPeriod() + " ~ " + resumeWriteVO.getEduElePeriod2(), resumeWriteVO.getEduUniMajor(), resumeWriteVO.getEduUniDep(), resumeWriteVO.getEduUniArea(), "고등학교 졸업," + resumeWriteVO.getEduHighName(), career, resumeWriteVO.getComName(), resumeWriteVO.getComPeriod() + " ~ " + resumeWriteVO.getComPeriod2(), resumeWriteVO.getComPosition(), resumeWriteVO.getComJobType(), resumeWriteVO.getComIncome(), total, resumeWriteVO.getHopeService(), resumeWriteVO.getHopeIncome(), resumeWriteVO.getHopeArea(), resumeWriteVO.getHopeJobType(), resumeWriteVO.getIntroduction(), resumeWriteVO.getIntroTitle(), score, resumeWriteVO.getPortUrl());
        } else if(!resumeWriteVO.getEduUniName().equals("")){
            resumeWriteService.resumeWrite(dto.getU_uid(), resumeWriteVO.getSubject(), resumeWriteVO.getBasicName(), gender, resumeWriteVO.getBasicBirth(), resumeWriteVO.getBasicEmail(), resumeWriteVO.getBasicPhone(), resumeWriteVO.getBasicAddrs(), resumeWriteVO.getBasicAddrs2(), resumeWriteVO.getResumeStatus(), resumeWriteVO.getEduUniYear() + " 졸업", resumeWriteVO.getEleEduName(), resumeWriteVO.getEduEleArea(), resumeWriteVO.getEduUniPeriod() + " ~ " + resumeWriteVO.getEduUniPeriod2(), resumeWriteVO.getEduHighDep(), resumeWriteVO.getEduUniYear(), resumeWriteVO.getEduUniName(), resumeWriteVO.getEduUniPeriod() + " ~ " + resumeWriteVO.getEduUniPeriod2(), resumeWriteVO.getEduUniMajor(), resumeWriteVO.getEduUniDep(), resumeWriteVO.getEduUniArea(),  resumeWriteVO.getEduUniYear()+" 졸업," + resumeWriteVO.getEduUniName(), career, resumeWriteVO.getComName(), resumeWriteVO.getComPeriod() + " ~ " + resumeWriteVO.getComPeriod2(), resumeWriteVO.getComPosition(), resumeWriteVO.getComJobType(), resumeWriteVO.getComIncome(), total, resumeWriteVO.getHopeService(), resumeWriteVO.getHopeIncome(), resumeWriteVO.getHopeArea(), resumeWriteVO.getHopeJobType(), resumeWriteVO.getIntroduction(), resumeWriteVO.getIntroTitle(), score, resumeWriteVO.getPortUrl());
        }
        return "resume/resumeWriteOk";
    }


    @RequestMapping(value = "/resumeList", method = RequestMethod.GET)
    public String resumeList(HttpSession session, Model model){

        UserDTO dto = (UserDTO) session.getAttribute("userSession");

        if (dto != null) {
        List<resumeListDTO> mylist = resumeListService.selectList(dto.getU_uid());

        model.addAttribute("list", mylist);

            return "resume/resumeList";
        }else{
            return "user/login";
        }

    }

    @RequestMapping("/resumeDeleteOk/{uid}")
    public String resumeDelete(@PathVariable("uid") int uid){


        resumeDeleteService.Delete(uid);


        return "resume/resumeDeleteOk";
    }

    @RequestMapping( value = "/resumeUpdateOk" ,method =RequestMethod.POST)
    public String resumeUpdate(HttpSession session, resumeWriteVO resumeWriteVO){
        UserDTO dto = (UserDTO) session.getAttribute("userSession");



        int gender = 1;


        if(resumeWriteVO.getOptionSelected().equals("남")){
            gender = 0;
        }

        System.out.println(resumeWriteVO.getSubject());
        System.out.println(resumeWriteVO.getBasicAddrs());
        System.out.println(resumeWriteVO.getHopeIncome());
            resumeUpdateOkService.resumeUpdateOk( r_uid, resumeWriteVO.getSubject(), resumeWriteVO.getBasicName(), gender, resumeWriteVO.getBasicBirth(), resumeWriteVO.getBasicEmail(), resumeWriteVO.getBasicPhone(), resumeWriteVO.getBasicAddrs(), resumeWriteVO.getBasicAddrs2(), resumeWriteVO.getResumeStatus(), resumeWriteVO.getHopeJobType(), resumeWriteVO.getHopeIncome(), resumeWriteVO.getHopeArea(), resumeWriteVO.getHopeService());

        return "resume/resumeUpdateOk";


    }


    @RequestMapping("/resumeUpdate/{uid}")
    public String resumeUpdateForm(Model model,@PathVariable("uid") int uid){
            r_uid = uid;
            resumeUpdateDTO vo = resumeUpdateService.resumeUpdate(uid);


            model.addAttribute("list",vo);

        return "resume/resumeUpdate";
    }


    @RequestMapping("/resumeView/{r_uid}")
    public String resumeView(HttpSession session, Model model,@PathVariable("r_uid") int r_uid){
        UserDTO dto = (UserDTO) session.getAttribute("userSession");

        resumeViewDTO obj = resumeViewService.resumeView(r_uid);

        model.addAttribute("list", obj);



        return "resume/resumeView";
    }




}
