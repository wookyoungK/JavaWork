package com.lec.sts12_validation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")

//이페이지를 컨트롤러로 사용할떄에는 선언후 반드시 서버 재시작
public class BoardController {
	
	@RequestMapping("write.do")
	public String write() {
		return "board/write";
		
	}

}
