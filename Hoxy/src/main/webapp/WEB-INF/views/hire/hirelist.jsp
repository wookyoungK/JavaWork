<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/CSS/common.css" />
<script src="${pageContext.request.contextPath }/JS/board.js"></script>

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

	<div id="list">
		<div class="d01">
			<div class="right" id="pageRows"></div>
		</div>
	</div>

	<c:choose>
		<c:when test="${empty list || fn:length(list) ==0}">
		</c:when>
		<c:otherwise>
			<c:forEach var="dto" items='${list }'>
				<hr>
            공고 번호:
            <td>${dto.uid }</td>
				<br>
            제목:
            <td>${dto.title }</td>
				<br>
            경력:
            <td>${dto.career }</td>
				<br>
				<c:choose>
					<c:when test="${dto.remainDate < 0 }">
						<h2>모집기간: 모집 종료</h2>
					</c:when>
					<c:when test="${dto.remainDate == 0 }">
						<h2>모집기간: 오늘 종료</h2>
					</c:when>

					<c:otherwise>
						<h2>모집기간: ${dto.remainDate}일</h2>


						<form id="frmList" name="frmList">
							<table>
								<thead>
									<th>#</th>
									<th>UID</th>
									<th>제목</th>
								</thead>

								<tbody>

								</tbody>
							</table>
						</form>

					</c:otherwise>
				</c:choose>


				<%--버튼 --%>
				<button onclick="location.href='view.do?uid=${dto.uid }'">상세
					보기</button>
				<button id="delete" onclick="chkDelete(${dto.uid })">공고 삭제</button>

				<br>
				<br>
			</c:forEach>

		</c:otherwise>
	</c:choose>



	<br>
	<button onclick="location.href='write.do'">공고등록</button>
	<%-- 페이징 --%>
	<div class="center">
		<ul class="pagination" id="pagination">

		</ul>
	</div>


</body>
</html>