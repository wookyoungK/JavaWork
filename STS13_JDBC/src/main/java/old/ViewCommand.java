package old;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ViewCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		WriteDAO dao = new WriteDAO(); //DAO 객체 생성
		WriteDTO [] arr=null;
		int uid = Integer.parseInt(request.getParameter("uid"));
		// 매개변수 받아오기



		try {
			//트랜직션수행
			arr= dao.readByUid(uid);
			request.setAttribute("view", arr);
			
		} catch(SQLException e) {

			e.printStackTrace();
		}

	}


}
