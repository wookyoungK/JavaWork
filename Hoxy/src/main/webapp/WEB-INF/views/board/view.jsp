<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<c:choose>
	<c:when test="${empty view || fn:length(view) == 0 }">
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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title> ${view[0].name }</title>
</head>
<script>
function chkDelete(uid){
	var r = confirm("삭제하시겠습니까?");
	if(r){
		location.href = 'deleteOk.do?uid=' + uid;
	}
}
</script>
<body>
<h2>${view[0].name }</h2>
<br>
직원번호 : ${view[0].uid }<br>
이름 : ${view[0].name }<br>
직책 : ${view[0].position }<br>
휴대폰 : ${view[0].phone }<br>
이메일 : ${view[0].email }<br>
<hr>
<br>
<button onclick="location.href='update.do?uid=${view[0].uid }'">수정하기</button>
<button onclick="location.href = 'list.do'">목록보기</button>
<button onclick="chkDelete(${view[0].uid })">삭제하기</button>
<button onclick="location.href = 'write.do'">신규등록</button>

</body>
</html>

	</c:otherwise>
</c:choose>













