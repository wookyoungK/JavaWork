package com.lec.sts13_jdbc.board.command;

import org.springframework.ui.Model;

public interface BCommand {
	void excute(Model model);
	
	//달라진것
}
