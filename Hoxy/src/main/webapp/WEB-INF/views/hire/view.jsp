<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt2" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="today" class="java.util.Date"/>
<fmt2:formatDate value="${today}" pattern="YYYY-MM-dd" var="today"/>
<html>
<head>


    <!--폰트어썸-->
    <script src="https://kit.fontawesome.com/bb29575d31.js"></script>


    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/CSS/reset.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/CSS/yoondoo.css"/>
    <%--    <script src="${pageContext.request.contextPath }/JS/yj.js"></script>--%>


    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">


    <link rel="shortcut icon" type="image/x-icon"
          href="https://i.imgur.com/8AyMFrx.png">

    <title>채용공고</title>
</head>

<body class="bk_gray">

<div id="header" class="row">

    <div class="col-md-2"></div>
    <div id="small_logo" class="col-md-2" onclick="location.href='/'"></div>

    <ul class="col-md-4" class="inline">
        <li>
            <a href="#"><i class="fas fa-bars"></i></a>
            <a href="/hire/hireSearch.do">
                지역별 채용공고
            </a>
            <a href="/board/list.do">
                BLIND_BOARD
            </a>
        </li>


    </ul>
    <ul class="col-md-4" class="inline">
        <li>
            <a href="#"><i class="fas"></i></a>
            <%
                if(session.getAttribute("comSession") != null) {
            %>
            <a href="/logout">로그아웃</a>
            <% }else{%>
            <a href="/user/loginchoice">로그인</a>
            <%}%>
            <a href="/resume/resumeList">
                이력서 관리

            </a>

            <a href="/app/appmyList">
                지원 관리
            </a>
            <a href="/companyMain" class = "white_board_btn">
                기업 서비스
            </a>
        </li>


    </ul>


</div>

<div class="main_box div_950">
    <div id="nav_position_1" class="main_box_content row">

        <%--공고 타이틀 자리임--%>

        <h2 class="main_box_title inline col-md-12">(${view[0].h_name })</h2>
        <h1 class="main_box_title inline col-md-8">${view[0].h_title }</h1>
        <button class="gray_Btn inline col-md-1" onclick="history.back()">◀</button>
        <c:choose>

            <c:when test="${view[0].h_remainDate<0}">
                <button class="gray_Btn inline col-md-3">지원마감</button>
            </c:when>


            <c:otherwise>
                <button id="btnModify" class="org_Btn inline col-md-3" onclick="location.href='update.do?h_uid=${view[0].h_uid }'">공고수정
                </button>

            </c:otherwise>

        </c:choose>


        <div class="col-md-6 row updown padding20 margin_auto">
            <div class="nav_box nav_box1" id="nav_box1"><i class="fas fa-tv"></i>채용공고</div>
            <div class="nav_box nav_box2" id="nav_box2"><i class="fas fa-mouse"></i>접수방법</div>
            <div class="nav_box nav_box3" id="nav_box3"><i class="fas fa-chart-bar"></i>지원자통계</div>
            <div class="nav_box nav_box4" id="nav_box4"><i class="far fa-building"></i>기업정보</div>
            <h2 class="col-md-4 bold">경력</h2>
            <h2 class="col-md-8 ">${view[0].h_career }</h2>
            <h2 class="col-md-4 bold">학력</h2>
            <h2 class="col-md-8">${view[0].h_degree }</h2>
            <h2 class="col-md-4 bold">근무형태</h2>
            <h2 class="col-md-8">${view[0].h_workform }</h2>
        </div>
        <div class="col-md-6 row updown padding20 margin_auto">
            <h2 class="col-md-4 bold">급여</h2>
            <h2 class="col-md-8">${view[0].h_salary }</h2>
            <h2 class="col-md-4 bold">직무</h2>
            <h2 class="col-md-8">${view[0].h_part }</h2>
            <h2 class="col-md-4 bold">근무지역</h2>
            <h2 class="col-md-8">${view[0].h_position1 } ${view[0].h_position2 }</h2>
        </div>
    </div>


    <div class="main_box_content">
        <img id="hContent" class="col-md-10"
             src="${view[0].h_content}">
    </div>


    <div id="main_footer">

        <div id="main_footer_nav">
            <nav>
                <ul>

                    <li>회사소개</li>
                    <li>보도기사</li>
                    <li>찾아오시는길</li>
                    <li>회원약간</li>
                    <li>개인정보처리방침</li>
                    <li>이메일무단수집거부</li>
                    <li>채용정보API</li>
                    <li>제휴문의</li>
                    <li>고객센터</li>

                </ul>

            </nav>
        </div>
        <div class="row">
            <div class="col-md-3 ">
            </div>
            <div id="main_footer_img" class="col-md-1 ">
            </div>
            <div id="main_footer_content" class="div_1260 col-md-8">
                <a>사람인 고객센터 02-2025-4733 (평일 09:00~19:00, 주말·공휴일 휴무)</a><br>
                <br>
                <a>이메일 : help@saramin.co.kr, Fax : 02-6937-0039(대표), 02-6937-0035(세금계산서) 이메일문의 사람인 네이버
                    블로그 사람인 페이스북
                    페이지</a><br>
                <br>
                <a>(주)사람인HR, 우 : 08378, 서울특별시 구로구 디지털로34길 43, 201호(구로동), 대표 : 김용환</a><br>
                <br>
                <a>사업자등록 : 113-86-00917, 직업정보제공사업 : 서울 관악 제 2005-6호, 통신판매업 : 제 2339호, Copyright (c)
                    (주)사람인HR. All
                    rights
                    reserved.</a><br>
            </div>
        </div>
    </div>
</div>


</body>
</html>
