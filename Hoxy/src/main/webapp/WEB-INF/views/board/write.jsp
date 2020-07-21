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
	
	var title = frm["title"].value.trim();
	var salary = frm["salary"].value.trim();
	var position2 = frm["position2"].value.trim();
	var part = frm["part"].value.trim();

	
	if(title == ""){
		alert("이름 반드시 작성해야 합니다");
		frm["title"].focus();
		return false;
	}
	if(salary == ""){
		alert("직책 반드시 작성해야 합니다");
		frm["salary"].focus();
		return false;
	}
	if(position2 == ""){
		alert("직책 반드시 작성해야 합니다");
		frm["position2"].focus();
		return false;
	}
	if(part == ""){
		alert("직책 반드시 작성해야 합니다");
		frm["part"].focus();
		return false;
	}
/* 	var phone_check="^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
	
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
	return true; */
}

</script>
<body>
<h2>신규등록</h2>
<form name="frm" action="writeOk.do" method="post" onsubmit="return chkSubmit()">
공고 제목:
<input type="text" name="title"/><br>
급여:
<input type="text" name="salary"/><br>
근무지역:
<input type="text" name="position2"/><br>
직무:
<input type="text" name="part"/><br>

<br><br>
<input type="submit" value="공고 등록"/>
</form>
<br>
<button type="button" onclick="location.href='hirelist.do'">목록으로</button>


</body>
</html>















