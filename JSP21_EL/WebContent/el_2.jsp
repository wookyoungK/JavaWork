<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dto" class="com.lec.beans.WriteDTO" scope="page" />
<jsp:setProperty name="dto" property="uid" value="123"/>
<jsp:setProperty name="dto" property="subject" value="제목"/>
<jsp:setProperty name="dto" property="name" value="작성자입니다"/>
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL - ActionTag</title>
</head>

<body>
	작성자 : <%= dto.getName() %><br>
	제목 : <%= dto.getSubject() %><br>
	uid : <%= dto.getUid() %><br>
	<hr>

	uid : <jsp:getProperty name="dto" property="uid"/><br>
	제목 : <jsp:getProperty name="dto" property="subject"/><br>
	이름 : <jsp:getProperty name="dto" property="name"/><br>
	<hr>
	
	uid : ${ dto.uid }<br>
	제목 : ${ dto.subject }<br>
	이름 : ${ dto.name }<br>
</body>
</html>

