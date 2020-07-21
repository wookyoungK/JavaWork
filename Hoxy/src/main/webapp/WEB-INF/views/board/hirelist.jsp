<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- JSTL 버전으로 바뀌니, import 번잡함도 사라진다. JAVA변수 선언도 사라진다!  -->

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공고 관리</title>
</head>
<body>

<style>
table {
	width: 100%;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>

	<hr>
	<h2>공고 관리</h2>
	<table>
		<tr>
			<th>공고 번호</th>
			<th>제목</th>
			<th>경력</th>
		</tr>
		<c:choose>
			<c:when test="${empty list || fn:length(list) ==0}">
			</c:when>
			<c:otherwise>
				<c:forEach var="dto" items='${list }'>
					<tr>
						<td>${dto.uid }</td>
						<td>${dto.title }</td>
						<td>${dto.career }</td>
					</tr>
				</c:forEach>

			</c:otherwise>
		</c:choose>
	</table>
	<br>
	<button onclick="location.href='write.do'">공고등록</button>


</body>
</html>