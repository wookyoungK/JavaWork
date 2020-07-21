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


<h1>파일 업로드</h1>
<form action="fileupload", method="post" enctype="multipart/form-data">
    <input type="file", name="uploadfile" placeholder="파일 선택" /><br/>
    <input type="submit" value="업로드">
</form>

</body>
</html>