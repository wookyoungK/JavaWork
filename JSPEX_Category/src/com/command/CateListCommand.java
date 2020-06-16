package com.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.CategoryDAO;
import com.lec.beans.CategoryDTO;

public class CateListCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {

		CategoryDAO dao = new CategoryDAO(); // DAO 객체 생성
		CategoryDTO[] arr = null;
		int depth = Integer.parseInt(request.getParameter("depth"));
		int parent = Integer.parseInt(request.getParameter("parent"));


			try {
				arr = dao.selectByUid(depth, parent);
				request.setAttribute("list", arr);

			} catch (SQLException e) {

				try {
					arr = dao.select(depth);
					request.setAttribute("list", arr);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
