<%--
  Created by IntelliJ IDEA.
  User: bhd44
  Date: 2020-07-14
  Time: 오후 4:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link href="https://fonts.googleapis.com/css2?family=Jua&family=Nanum+Brush+Script&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/CSS/testtest.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/CSS/testtest2.css"/>

</head>
<link rel="shortcut icon" type="image/x-icon"
      href="https://i.imgur.com/8AyMFrx.png">
<body>
<img class = "main_img" src="https://i.imgur.com/DguGnWE.png">
<h1 id = "main_img_message">HI! I'm Nam Publisher ♥</h1>
<c:choose>
    <c:when test="${u_name!=null}">
        <div id="main_login" onclick="location.href='/logout'">LOGOUT</div>
        <div id="main_mypage" onclick="location.href='/user/userMypage'">MY PAGE</div>
        <div id="main_username">${u_name} 님 안녕하세요</div>
    </c:when>
    <c:otherwise>
        <div id="main_login" onclick="location.href ='/user/loginchoice' ">LOGIN</div>
    </c:otherwise>
</c:choose>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/2.0.2/TweenMax.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/JS/jquery.lettering-0.6.1.min.js"></script>


<script src="${pageContext.request.contextPath }/JS/testtest.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>


<nav role="navigation">

    <div id="menuToggle">
        <!--
        A fake / hidden checkbox is used as click reciever,
        so you can use the :checked selector on it.
        -->
        <input type="checkbox"/>

        <!--
        Some spans to act as a hamburger.

        They are acting like a real hamburger,
        not that McDonalds stuff.
        -->
        <span></span>
        <span></span>
        <span></span>

        <!--
        Too bad the menu has to be inside of the button
        but hey, it's pure CSS magic.
        -->

        <ul id="menu">
            <a href="/hire/hireSearch.do">
                <li>지역별 채용공고</li>
            </a>
            <a href="/board/list.do">
                <li>BLIND-BOARD</li>
            </a>
            <a href="/resume/resumeList">
                <li>이력서 관리</li>
            </a>
            <a href="/app/appmyList">
                <li>지원 관리</li>
            </a>
            <a href="/companyMain">
                <li>기업서비스</li>
            </a>

        </ul>
    </div>
</nav>


<section class="container">
    <div id="main_header_log"></div>
    <h1>
        <%--  <span class="title">This is</span>
          <span class="title">a long</span>--%>
        <span class="title">일할래 Hoxy?</span>
    </h1>

    <%--<div class="button">restart</div>--%>
</section>


<div class="wrap">

    <form class="" name='frm' method='get' action='hire/hireSearch.do'>
        <div class="search">
            <select class="searchTerm" name="localSearch" class="col-md-5">
                <option value="서울시">서울시</option>
                <option value="경기도">경기도</option>
                <option value="부산광역시">부산광역시</option>
                <option value="인천광역시">인천광역시</option>
                <option value="대전광역시">대전광역시</option>
                <option value="대구광역시">대구광역시</option>
                <option value="울산광역시">울산광역시</option>
                <option value="" selected> 지역 선택</option>
            </select>
            <input type="text" class="searchTerm searchTerm1" type="text" name='searchWord'
                   placeholder="특수문자 입력불가" aria-label="특수문자 입력 불가"
                   aria-describedby="button-addon2">
            <button type="submit" class="searchButton">
                <i class="fas fa-search"></i>
            </button>

        </div>
    </form>

</div>
</body>

</html>
