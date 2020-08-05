<%@ page import="com.lec.spring.resume.domain.resumeListDTO" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lec.spring.user.domain.UserDTO" %>
<!--
Created by IntelliJ IDEA.
User: suu
Date: 2020/07/20
Time: 1:06 PM
To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
-->
<html lang="ko">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>NEXT 이력서 현황 </title>
    <!-- Latest compiled and minified CSS -->
    <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
    />
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/CSS/resumeList.css"/>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/CSS/yoondoo.css"/>
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>

<% List<resumeListDTO> list = (List<resumeListDTO>) request.getAttribute("list");

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");




%>
<body>
<div>
    <header>
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
                        if(session.getAttribute("userSession") != null) {
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
    </header>

    <section class="my-5 py-5">


        <div class="container border bg-light p-3 border-dark border-4 ">
            <div class="container p-3"><h2>이력서 현황</h2></div>
            <label class="ml-3 my-2 text-muted">이력서는 <span class="req my-2">최대 10개</span>까지 작성하여 등록 가능합니다. </label>
            <div class="container p-3"><h5>총 <span class="req my-2"><%= list.size()%></span>건</h5></div>

            <div id="rows">


            <% for(int i =0 ; i < list.size(); i++){
                String date = sdf.format(list.get(i).getR_date());

            %>



                <div class="container border border-3 border-dark bg-white p-3 my-3"><label class="ml-3 my-2 text-muted">수정 <span class="req my-2"><%= date%></span>  </label><button id="btn-delete_<%= list.get(i).getR_uid()%>" class="border bg-white btn-lg" > <i class="fas fa-times d-flex justify-content-end" id="rightup"></i></button>
                 <div class="container ml-5"><h2><strong><a class="text-dark" href="resumeView/<%= list.get(i).getR_uid()%>"><ins> <%=list.get(i).getR_title() %> </ins> </a></strong> </h2>
                 </div>
                <button type="button" class="btn btn-success btn-light text-dark border border-3 border-dark mt-5 " id="resumeUpdate_<%= list.get(i).getR_uid()%>">수정하기</button>
                </div>

            <% } %>


            </div>

        </div>

        <div class="container mt-5 d-flex justify-content-center">
        <a type="button" class="btn btn-success btn-light text-dark border border-3 border-dark" id="resumeWrite" href="resumeWrite">이력서 등록하기</a>
        </div>

    </section>

    <footer><div id="main_footer">

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
                <a>이메일 : help@saramin.co.kr, Fax : 02-6937-0039(대표), 02-6937-0035(세금계산서) 이메일문의 사람인 네이버 블로그 사람인 페이스북
                    페이지</a><br>
                <br>
                <a>(주)사람인HR, 우 : 08378, 서울특별시 구로구 디지털로34길 43, 201호(구로동), 대표 : 김용환</a><br>
                <br>
                <a>사업자등록 : 113-86-00917, 직업정보제공사업 : 서울 관악 제 2005-6호, 통신판매업 : 제 2339호, Copyright (c) (주)사람인HR. All rights
                    reserved.</a><br>
            </div>
        </div>
    </div></footer>
</div>
</body>
<script src="../../../JS/resumeList.js" type="text/javascript"></script>

</html>
