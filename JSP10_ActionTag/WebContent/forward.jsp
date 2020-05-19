<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>forward</title>
</head>
<body>

<!-- Action Tag  -->
<!-- sendRedirect 는 url이 완전 바뀌지만 , jsp:forward는 url이 그대로이다 .! -->
<h3>지금의 페이지는 forward 페이지 입니다. </h3>
<jsp:forward page="sub.jsp"/>

<p>위 라인의 내용은 sub 페이지의 내용입니다</p>


<%

%>

</body>
</html>