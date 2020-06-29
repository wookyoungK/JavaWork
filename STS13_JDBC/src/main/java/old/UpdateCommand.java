package old;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		WriteDAO dao = new WriteDAO(); //DAO 객체 생성
		int cnt = 0;
		
  // 한글 인코딩 꼭!
		int uid = Integer.parseInt(request.getParameter("uid"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		// 매개변수 받아오기

		try {
			//트랜직션수행
			cnt= dao.update(uid,subject,content);
			request.setAttribute("update", cnt);
			
		} catch(SQLException e) {

			e.printStackTrace();
		}

	}


}
