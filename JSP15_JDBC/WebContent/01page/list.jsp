<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import = 'java.sql.*' %><%-- JDB 관련 import --%>
   <%@ page import = "java.text.SimpleDateFormat" %>
   
<%
	int curPage =1; //현재 페이지 (디폴트 1page)
	
	//현재 몇 페이지 인지 paramerter 받아오기
	
	String pageParam = request.getParameter("page");
	if(pageParam != null && !pageParam.toString().trim().equals("")){
		try{
			
			int p = Integer.parseInt(pageParam);
			if(p>0)
				curPage = p;
			
		}catch(NumberFormatException e){
		
			
		}
	}
%>   
   
   <%!
   //JDBC 관련 기본 객체 변수
   Connection conn = null;
   Statement stmt = null;
   PreparedStatement pstmt = null;
   ResultSet rs = null; //SELECT 결과, excuteQuery()
   int cnt = 0; // DML 결과 executeUpdate()
   
   //Connection 에 필요한 값 세팅
   String driver = "oracle.jdbc.driver.OracleDriver";
   String url ="jdbc:oracle:thin:@localhost:1521:XE";
   String uid = "scott0316";
   String upw = "tiger0316";
   %>
   
   <%!
   
   //쿼리문 준비
   //final String SQL_WRITE_SELECT =
   //	"SELECT * FROM test_write ORDER BY wr_uid DESC";   
   
   
   //페이징
   //글 목록 전체 개수 가져오기
   String SQL_WRITE_COUNT_ALL = "SELECT count(*) FROM test_write";
   
   //fromRow 부터 pageRows 만큼 SELECT
   //(몇번쨰) 부터 (몇개)만큼
   
   final String SQL_WRITE_SELECT_FROM_ROW = "";
   
   %>
   
   
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>글목록 </title>
</head>
<body>

<style>
table {width: 100%;}
table, th, td{
	border: 1px solid black;
	border-collapse: collapse;
}

</style>



   <%
   try{
     Class.forName(driver);
     out.println("드라이버 로딩 성공"+"<br>");
     conn = DriverManager.getConnection(url,uid,upw);
     out.println("conn성공<br>");
     
     //트랜잭션 실행
     pstmt = conn.prepareStatement(SQL_WRITE_SELECT);
     
     rs =pstmt.executeQuery();
     out.println("쿼리 성공<br>");
%>
	<hr>
	<h2>리스트</h2>
	<table>
		<tr>
			<th>UID</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
<%

	while(rs.next()){
		out.println("<tr>");
		
		int uid =rs.getInt("wr_uid");
		String subject = rs.getString("wr_subject");
		String name = rs.getString("wr_name");
		int viewcnt =rs.getInt("wr_viewcnt");
		Date d =rs.getDate("wr_regdate");
		Time t =rs.getTime("wr_regdate");
		/* import = 'java.sql. 해주어서 ㄱㅊ */
				
		String regdate ="";
		if(d != null){
			regdate =new SimpleDateFormat("yyyy-MM-dd").format(d)+ " "
					+ new SimpleDateFormat("hh:mm:ss").format(t);
		}
		
		out.println("<td>"+uid +"</td>");
		out.println("<td><a href='view.jsp?uid=" + uid + "'>"+subject+"</a></td>");
		//view.jsp로넘어가면 어느글에대한 view.jsp로 넘어가야하는것인지 알아야한다 -->uid값으로 구분
		out.println("<td>"+name+"</td>");
		out.println("<td>"+viewcnt+"</td>");
		out.println("<td>"+regdate+"</td>");
	
		
		out.println("</tr>");
		
	}// end while
%>		
		
	</table>
	<br>
	<button onclick ="location.href ='write.jsp'">신규등록</button>
<% 
     
   }catch(Exception e){
      e.printStackTrace();
      //예외처리
   }finally{
      //리소스 해제
      try{
         if(rs!=null)rs.close();
         if(stmt!=null)stmt.close();
         if(pstmt!=null)pstmt.close();
         if(conn!=null)conn.close();
      }catch(Exception e){
         e.printStackTrace();
      }
   }
   %>
   <%-- 위 트랜잭션이 마무리 되면 페이지 보여주기 --%>




    
    
    


</body>
</html>