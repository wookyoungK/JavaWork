<%--
  Created by IntelliJ IDEA.
  User: yjiwo
  Date: 2020-07-27
  Time: 오후 6:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
</head>
<body>
<div id="background_modal" class="background_modal">
    <div class="modal_contents">
        <h4>
            <b>손님 아이디는?</b><span class="close">&times;</span>
        </h4><br>
        <h2 id="id_value"></h2>
        <br>
        <button type="button" id="pwSearch_btn" class="btn peach-gradient btn-rounded waves-effect">
            <i class="fa fa-envelope"></i>비밀번호 찾기</button>
    </div>
</div>

</body>
</html>