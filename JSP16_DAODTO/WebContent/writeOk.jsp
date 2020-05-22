<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id= "dao" class="com.lec.beans.WriteDAO"/> <!-- DAO bean 생성  -->

   
<%
	//이거무조건해주야한다
	request.setCharacterEncoding("utf-8"); //한글 인코딩 꼭!
	//입력한 값 받아오기
	String name =request.getParameter("name");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
	//유효성 체크(백엔드에서도 검사해줘야한다, 이부분이 백엔드!)
	//name ,subject 는 비어있으면 안된다. NN
	// null 이거나 빈 문자열이면 이전화면으로 돌아가기	
	if(name == null || subject == null || 
		name.trim().equals("") || subject.trim().equals("")){
		
%>		

	<script>
		alert("작성자 이름, 글 제목은 필수 입니다!");
		history.back(); //history.go(-1);		
	</script>
		
<% 
		return ; // ★★★★★ 더 이상 JSP 프로세싱 하지 않도록 종료!!
				//jsp코드에서 return을넣은것은 더이상 프로세싱 하지않는다는것이다!! 
	}
%>	
   
<%	
	//DAO 사용한 트랜잭션
	int cnt = dao.insert(subject, content, name);
%>   
   
<%-- 위 트랜잭션이 마무리 되면 페이지 보여주기 --%>


<% if(cnt == 0){ %>
			<script>
				alert("등록 실패!!!!!");
				history.back(); //브라우저가 기억하는 직전 페이지 (입력중 페이지)
			</script>
<%}else { %>
	<script>
		alert("등록 성공, 리스트를 출력합니다");
		location.href = "list.jsp";
	</script>
	
	
<% } %>

