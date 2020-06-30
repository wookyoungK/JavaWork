package com.lec.sts12_validation;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.beans.WriteDTO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@RequestMapping("write.do")
	public String write() {
		return "board/write";
	}
	
	@RequestMapping("writeOk.do")				//폼검증부분
	public String writeOk(@ModelAttribute("w") @Valid WriteDTO dto, 
			BindingResult result) {  // ← validator 가 유효성 검사를 한 결과가 담긴 객체.
		System.out.println("writeOk():" + dto.getUid() + ":" + dto.getName());
//		System.out.println("에러개수: " + result.getErrorCount());  // 바인딩과정에서 발생한 에러 개수 
//		System.out.println("validate전 ");showErrors(result);
		
		String page = "board/writeOk";
		
		
		//validator 객체 생성
//		BoardValidator validator =new BoardValidator();
//		validator.validate(dto, result);
		System.out.println("validate후 ");showErrors(result);
		
		if(result.hasErrors()) {// 에러 있으면
			page="board/write"; //원래 폼으로 돌아가기!
		}
		
		return page;
	}
	
	//error 에 담겨있는 에러 들을 다 출력해보기 ,도우미 메소드
	public void showErrors(Errors errors) {
		if(errors.hasErrors()) {
			System.out.println("에러 개수 : "+errors.getErrorCount());
			System.out.println("\t[field]\t|[code]");
			List<FieldError> errList = errors.getFieldErrors();
			for(FieldError err : errList) {
				System.out.println("\t" + err.getField() + "\t|" + err.getCode());
			}
		} else {
			System.out.println("에러 없슴");
		}
	}
		
		// 이 컨트롤러 클래스의 handler 에서 폼 데이터를 바인딩 할때 검증하는 개체 지정
		//에러 동작하는것을 멈춘후 여기서 동작하게해준다
		//으로 검증이 필요한 객체를 가져오기 전에 수행할 method를 지정해주는 annotation이다.
		@InitBinder
		public void initBinder(WebDataBinder binder) {
			binder.setValidator(new BoardValidator());
		}
	
}






















