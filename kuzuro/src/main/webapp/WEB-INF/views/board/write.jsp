<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시물 작성 하기</title>
</head>
<body>
	<form method="post">

		<label>제목</label> <input type="text" name="title" /><br /> <label>작성자</label>
		<input type="text" name="writer" /><br /> <label>내용</label>
		<textarea cols="50" rows="5" name="content"></textarea>
		<br />

		<button type="submit">작성</button>
     
	</form>
</body>
</html>