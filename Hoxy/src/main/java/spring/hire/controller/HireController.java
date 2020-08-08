package com.lec.spring.hire.controller;


import com.lec.spring.hire.beans.HWriteDTO;
import com.lec.spring.hire.command.*;
import com.lec.spring.hire.domain.C;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hire")
public class HireController {

    private HCommand command;

    private SqlSession sqlSession;

    public HireController() {
        super();
        System.out.println("hireController() 생성");
    }

    @Autowired
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
        C.sqlSession = sqlSession;
    }

//    @RequestMapping("/hirelist.do")
//    public String list(Model model) {
//        command = new HListCommand();
//        command.excute(model);
//        return "hire/hirelist";
//    }


    @RequestMapping(value = "/hireSearch.do")
    public String hireSearch() {

        return "hire/hireSearch";

    }

    @RequestMapping(value = "/hirelist.do")
    public String hirelist() {

        return "hire/hirelist";

    }
    @RequestMapping(value = "/deleteOk.do")
    public String deleteOk() {

        return "hire/deleteOk";

    }


    @RequestMapping("/write.do")
    public String write(Model model) {
        return "hire/write";
    }


    @RequestMapping(value = "/writeOk.do", method = RequestMethod.POST)
    public String writeOk(HWriteDTO dto, Model model) {
        model.addAttribute("dto", dto);
        new HWriteCommand().excute(model);
        return "hire/writeOk";
    }


    @RequestMapping("/view.do")
    public String view(Model model, int h_uid) {
        model.addAttribute("h_uid", h_uid);
        command = new HViewCommand();
        command.excute(model);
        return "hire/view";
    }

    @RequestMapping("/update.do")
    public String update(int h_uid, Model model) {
        model.addAttribute("h_uid", h_uid);
        new HSelectCommand().excute(model);
        return "hire/update";
    }

    @RequestMapping(value = "/updateOk.do", method = RequestMethod.POST)
    public String updateOk(HWriteDTO dto, Model model) {
        model.addAttribute("dto", dto);
        new UpdateCommand().excute(model);
        return "hire/updateOk";
    }
//    @RequestMapping("/hireSearch.do")
//    public String list(Model model) {
//        command = new AHListCommand();
//        command.excute(model);
//        return "hire/hireSearch";
//    }
//
//    @RequestMapping("/deleteOk.do")
//    public String delete(Model model, int h_uid) {
//        model.addAttribute("h_uid", h_uid);
//        command = new HDeleteCommand();
//        command.excute(model);
//        return "hire/deleteOk";
//    }














    /*
     * @RequestMapping(value = "/fileupload.do", method = RequestMethod.POST) public
     * void upload(MultipartFile uploadfile) { logger.info("upload() POST 호출");
     * logger.info("파일 이름: {}", uploadfile.getOriginalFilename());
     * logger.info("파일 크기: {}", uploadfile.getSize());
     *
     * saveFile(uploadfile);
     *
     * }
     *
     * private String saveFile(MultipartFile file) { // 파일 이름 변경 UUID uuid =
     * UUID.randomUUID(); String saveName = uuid + "_" + file.getOriginalFilename();
     *
     * logger.info("saveName: {}", saveName);
     *
     * // 저장할 File 객체를 생성(껍데기 파일)ㄴ File saveFile = new File(UPLOAD_PATH, saveName);
     * // 저장할 폴더 이름, 저장할 파일 이름
     *
     * try { file.transferTo(saveFile); // 업로드 파일에 saveFile이라는 껍데기 입힘 } catch
     * (IOException e) { e.printStackTrace(); return null; }
     *
     * return saveName; } // end saveFile(
     */

}