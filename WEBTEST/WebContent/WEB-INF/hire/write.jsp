<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath }/JS/woo.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/CSS/woo.css"/>

<style>
/*datepicer 버튼 롤오버 시 손가락 모양 표시*/
.ui-datepicker-trigger{cursor: pointer;}
/*datepicer input 롤오버 시 손가락 모양 표시*/
.hasDatepicker{cursor: pointer;}
</style>

<title>기업 공고 등록</title>
</head>



<body>
<h2>기업 공고 등록</h2>
<br><hr>
<form name="frm" action="writeOk.do" method="post" onsubmit="return chkSubmit()">
<input type="text" name="C_UID"/><br>
기업명:
<input type="text" name="name"/><br> 
공고 제목:
<input type="text" name="title"/><br>
급여:
<input type="text" name="salary"/><br>
<br><hr>
로고:
<br><hr>
근무지역:
	<select id="position1" name="position1">
							<option value="1">강남</option>
							<option value="2">역삼</option>
							<option value="3">수원</option>
							<option value="4">서울</option>
							<option value="5">서초</option>
							<option value="6">방배</option>
							<option value="7">교대</option>
							<option value="" selected>지역 선택</option>
			</select>
<input type="text" name="position2"  placeholder="상세 주소입력" id="position2"/><br>
<br><hr>

<h2>모집 내용</h2>
직무:
<input type="text" name="part"/><br>
<br><hr>

경력:
<input type="checkbox" name="career" value="무관"/>무관(신입/경력에 상관없이 모집)
<input type="checkbox" name="career" value="신입"/>신입
<input type="checkbox" name="career" value="경력"/>경력

<!-- <input type="checkbox" name="career" value="mango"/>3년이상
<input type="checkbox" name="career" value="melon"/

1,2,번호로 중복값가져오기
>메론 -->

<br><hr>
학력:
<input type="checkbox" name="degree" value="학력무관"/>학력무관
<input type="checkbox" name="degree" value="고졸"/>고졸
<input type="checkbox" name="degree" value="대졸"/>대졸
<input type="checkbox" name="degree" value="초대졸"/>초대졸
<br><hr>
근무형태:
<input type="checkbox" name="workform" value="정규직"/>정규직
<input type="checkbox" name="workform" value="파견직"/>파견직
<input type="checkbox" name="workform" value="계약직"/>계약직
<input type="checkbox" name="workform" value="인턴직"/>인턴직
<br><hr>
모집마감일:
<input type="checkbox" name="Date" value="마감일 선택" id="endDate"/>마감일 선택
<input type="checkbox" name="Date" value="상시모집" id="always"/>상시모집<br><br>

<div id="h_date">
 From: <input type="text" id="upDate" name="upDate">&nbsp;&nbsp;&nbsp; To: <input type="text" id="regDate" name="regDate">
</div>

<br><br>


<input type="submit" value="공고 등록"/>


</form>




<br>
<button type="button" onclick="location.href='hirelist.do'">목록으로</button>


</body>
</html>















