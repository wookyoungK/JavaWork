package com.lec.sts10_request.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


	
	
	@Controller
	@RequestMapping(value = "/board") //-> /member로 시작하는 request 만 처리 
	public class BoardController {
		
		@RequestMapping(value = "/list") //-> /member+ /save =/member/save
		public String listBoard() {
			return "board/list";
		}
		
		@RequestMapping(value = "/write") //-> /member+ /save =/member/save
		public String writeBoard() {
			return "board/write";
		}
		
		@RequestMapping(value = "/view") //-> /member+ /save =/member/save
		public String viewBoard() {
			return "board/view";
		}
		
		@RequestMapping(value = "/update") //-> /member+ /save =/member/save
		public String updateBoard() {
			return "board/update";
		}
		
		@RequestMapping(value = "/delete") //-> /member+ /save =/member/save
		public String deleteBoard() {
			return "board/delete";
		}
		
		


	}


