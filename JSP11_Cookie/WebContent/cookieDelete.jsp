<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
	Cookie[] cookies =request.getCookies();
	String cookieName = "num1";
	
/* 서버가 삭제하는것이아니라 클라이언트가  삭제하라고 하는것이다!  */	
/* 서버는 쿠키를 발급하는곳이지 저장하는곳이 아니다!! */
	if(cookies != null){
		for(int i =0; i < cookies.length; i++){
			if(cookieName.equals(cookies[i].getName())){
				cookies[i].setMaxAge(0); //expiry 를 0으로하면
				response.addCookie(cookies[i]); //response 직후 곧바로 삭제됨.
				
			}
			
			
			
		}
	}

%>

<script>
alert("<%= cookieName%>쿠키 삭제");
location.href ="cookieList.jsp";
</script>