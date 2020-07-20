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
		var position = frm["position"].value.trim();
		var phone = frm["phone"].value.trim();
		var email = frm["email"].value.trim();
		
		if(uid == ""){
			alert("직원번호 반드시 입력해야 합니다");
			frm["uid"].focus();
			return false;
		}
		if(name == ""){
			alert("이름 반드시 작성해야 합니다");
			frm["name"].focus();
			return false;
		}
		if(position == ""){
			alert("직책 반드시 작성해야 합니다");
			frm["position"].focus();
			return false;
		}
		var phone_check="^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
		
		if(!frm.phone.value.match(phone_check)){
			alert("휴대폰 번호 다시 작성해야 합니다");
			frm["phone"].focus();
			return false;
		}
		
		var email_check="^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
		if(!frm.email.value.match(email_check)){
			alert("이메일 다시 작성해야 합니다");
			frm["email"].focus();
			return false;
		}
		return true;
	}
</script>
<body>
	<h2>수정</h2>
	<form name="frm" action="updateOk.do" method="post"
		onsubmit="return chkSubmit()">
		
직원번호:
<input type="text" name="uid" value="${select[0].uid }" /><br>
이름:
<input type="text" name="name" value="${select[0].name }"/><br>
직책:
<input type="text" name="position" value="${select[0].position }"/><br>
휴대폰:
<input type="text" name="phone" value="${select[0].phone }"/><br>
이메일:
<input type="text" name="email" value="${select[0].email }"/><br>
	<br> <input type="submit" value="수정" />
	</form>
	<button onclick="history.back()">이전으로</button>
	<button onclick="location.href='list.do'">목록보기</button>

</body>
</html>


	</c:otherwise>
</c:choose>













