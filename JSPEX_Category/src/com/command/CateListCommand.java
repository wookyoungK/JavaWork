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
      String depth = request.getParameter("depth");
      String parent = request.getParameter("parent");

      if (parent == "" || parent=="" || depth=="" || depth==null ||parent==null) {
         try {
            arr = dao.select();
            request.setAttribute("list", arr);
         } catch (SQLException e) {
            e.printStackTrace();
         }
      } else {

         try {
            arr = dao.selectByUid(depth, parent);
            request.setAttribute("list", arr);

         } catch (SQLException e) {
            e.printStackTrace();
         }
      }

   }
}