package com.lec.sts16_interceptor.board.command;

import org.springframework.ui.Model;

public interface BCommand {
	void excute(Model model);
	
	//달라진것
}
