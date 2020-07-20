
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

	<%-- <hr>
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
	<button onclick="location.href='write.do'">신규등록</button> --%>
	<c:choose>
		<c:when test="${empty list || fn:length(list) ==0}">
			<div id="no_hire">"구매하신 물품이 없습니다"</div>
		</c:when>

		<c:otherwise>	
			<c:forEach var="dto" items='${list }'>
				<%-- <div class="date" id="date">구매일: ${dto.upDate }</div> --%>
				<!-- 구매 시간  -->
				<div class="h_list">
					<div class="h_content">
						<div id="h_info">
							공고 제목:${dto.h_title}<br>
						</div>
						<div id="h_info">
							경력: ${dto.h_career}<br>
						</div>


						<!-- 배송메모 -->
<%-- 						<div class="o_modify" id="u_modify_input_${dto.pid}">
							<label><b>배송 메모 수정</b></label>


							<form class="modify " action="updateOk.woo" method="post">
								<input type="hidden" name="pid" value="${dto.pid}"> <input
									id="memo_${dto.pid}" type="text"
									placeholder="${dto.pccontent }" name="pccontent">

								<div class="u_modify_1">
									<button id="u_modify_1_${dto.pid}" type="submit">수정</button>
									<button id="u_modify_3_${dto.pid}" type="button">취소</button>
								</div>
							</form>


						</div> --%>
					</div>




<%-- 					<div class="row o_button col-md-2 ">

						<div class="u_cancel col-md-12 ">

							<div class="u_modify_2">
								<button id="u_modify_2_${dto.pid}">수정하기</button>
							</div>

							<form action="cancelOk.woo" method="post">
								<button id="u_cancel_1_${dto.pid}" type="submit">취소 요청</button>
								<input type="hidden" name="pid" value="${dto.pid}"> <input
									id="u_pcstatus_${dto.pid}" type="hidden" name="pcstatus"
									value="${dto.pcstatus}">
							</form>
						</div>

					</div> --%>


				</div>
			</c:forEach>

		</c:otherwise>
	</c:choose>
	</div>


</body>
</html>