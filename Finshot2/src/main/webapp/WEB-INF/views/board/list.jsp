
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>글목록</title>
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
	<h2>리스트</h2>
	<table>
		<tr>
			<th>직원번호</th>
			<th>이름</th>
			<th>직급</th>
			<th>전화번호</th>
			<th>이메일</th>
		</tr>

		<c:choose>
			<c:when test="${empty list || fn:length(list) ==0}">
			</c:when>
			<c:otherwise>
			<c:forEach var ="dto" items='${list }'>
				<tr>
					<td>${dto.uid }</td>
					<td><a href="view.do?uid=${dto.uid }">${dto.name }</a></td>
					<td>${dto.position}</td>
					<td>${dto.phone }</td>
					<td>${dto.email }</td>
				</tr>
			</c:forEach>

			</c:otherwise>
		</c:choose>

	</table>
	<br>
	<button onclick="location.href='write.do'">신규등록</button>


</body>
</html>