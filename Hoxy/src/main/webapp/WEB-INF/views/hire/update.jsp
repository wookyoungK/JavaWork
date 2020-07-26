<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<c:choose>
	<c:when test="${empty select || fn:length(select) == 0 }">
		<script>
			alert("해당 정보가 삭제되거나 없습니다");
			history.back();
		</script>
	</c:when>
	<c:otherwise>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="selectport" content="width=device-width, initial-scale=1.0">
<title>수정  ${select[0].name }</title>
</head>
<script>
	function chkSubmit() {
		frm = document.forms['frm'];

		var uid = frm["uid"].value.trim();
		var name = frm["name"].value.trim();
		var part = frm["part"].value.trim();


		if (uid == "") {
			alert("직원번호 반드시 입력해야 합니다");
			frm["uid"].focus();
			return false;
		}
		if (name == "") {
			alert("이름 반드시 작성해야 합니다");
			frm["name"].focus();
			return false;
		}
		if (part == "") {
			alert("직책 반드시 작성해야 합니다");
			frm["position"].focus();
			return false;
		}
	}

</script>
<body>
	<h2>수정</h2>
	<form name="frm" action="updateOk.do" method="post"
		onsubmit="return chkSubmit()">
		
공고 번호:
<input type="text" name="uid" value="${select[0].uid }" /><br>
기업 이름:
<input type="text" name="name" value="${select[0].name }"/><br>
직책:
<input type="text" name="position" value="${select[0].part }"/><br>

	<br> <input type="submit" value="수정" />
	</form>
	<button onclick="history.back()">이전으로</button>
	<button onclick="location.href='hirelist.do'">목록보기</button>

</body>
</html>


	</c:otherwise>
</c:choose>













