<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>글작성</title>
</head>
<script>
function chkSubmit(){ 
	frm = document.forms["frm"];
	
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
<h2>신규등록</h2>
<form name="frm" action="writeOk.do" method="post" onsubmit="return chkSubmit()">
직원번호:
<input type="text" name="uid"/><br>
이름:
<input type="text" name="name"/><br>
직책:
<input type="text" name="position"/><br>
휴대폰:
<input type="text" name="phone"/><br>
이메일:
<input type="text" name="email"/><br>

<br><br>
<input type="submit" value="등록"/>
</form>
<br>
<button type="button" onclick="location.href='list.do'">목록으로</button>


</body>
</html>















