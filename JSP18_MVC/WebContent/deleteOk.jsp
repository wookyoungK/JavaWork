<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="dao" class="com.lec.beans.WriteDAO"/> <%-- DAO bean 생성 --%>
<!-- request할때마다  connection 이 매번 이때 발생한다   -->



<% // DAO 사용한 트랜잭션
int cnt = (Integer) request.getAttribute("delete");
%>   

<% if(cnt == 0){ %>
	<script>
		alert('삭제 실패');
		history.back();
	</script>
<% } else { %>
	<script>
		alert('삭제 성공');
		location.href = "list.do";  <%-- 삭제후에는 list 로 가자 --%>
	</script>
<% } %>
















