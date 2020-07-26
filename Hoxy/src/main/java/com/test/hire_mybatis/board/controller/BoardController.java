package com.test.hire_mybatis.board.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.hire_mybatis.board.C;
import com.test.hire_mybatis.board.beans.BWriteDTO;
import com.test.hire_mybatis.board.command.BCommand;
import com.test.hire_mybatis.board.command.BDeleteCommand;
import com.test.hire_mybatis.board.command.BListCommand;
import com.test.hire_mybatis.board.command.BSelectCommand;
import com.test.hire_mybatis.board.command.BViewCommand;
import com.test.hire_mybatis.board.command.BWriteCommand;
import com.test.hire_mybatis.board.command.UpdateCommand;

@Controller
@RequestMapping("/hire")
public class BoardController {


    private BCommand command;

    private SqlSession sqlSession;

    public BoardController() {
        super();
        System.out.println("hireController() 생성");
    }

    @Autowired
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
        C.sqlSession = sqlSession;
    }

    @RequestMapping("/hirelist.do")
    public String list(Model model) {
        command = new BListCommand();
        command.excute(model);
        return "hire/hirelist";
    }


    @RequestMapping("/write.do")
    public String write(Model model) {
        return "hire/write";
    }

    @RequestMapping(value = "/writeOk.do", method = RequestMethod.POST)
    public String writeOk(BWriteDTO dto, Model model) {
        model.addAttribute("dto", dto);
        new BWriteCommand().excute(model);
        return "hire/writeOk";
    }

	
	  @RequestMapping("/view.do") public String view(Model model, int uid) {
	  model.addAttribute("uid", uid); command = new BViewCommand();
	  command.excute(model); return "hire/view"; }
	 
    @RequestMapping("/update.do")
    public String update(int uid, Model model) {
        model.addAttribute("uid", uid);
        new BSelectCommand().excute(model);
        return "hire/update";
    }

    @RequestMapping(value = "/updateOk.do", method = RequestMethod.POST)
    public String updateOk(BWriteDTO dto, Model model) {
        model.addAttribute("dto", dto);
        new UpdateCommand().excute(model);
        return "hire/updateOk";
    }

    @RequestMapping("/deleteOk.do")
    public String delete(Model model, int uid) {
        model.addAttribute("uid", uid);
        command = new BDeleteCommand();
        command.excute(model);
        return "hire/deleteOk";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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
