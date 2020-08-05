<%@ page import="com.lec.spring.resume.domain.resumeViewDTO" %>
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
    <title>NEXT 이력서 등록하기</title>
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/CSS/resumeWrite.css"/>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/CSS/yoondoo.css"/>
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>
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

    <%  resumeViewDTO dto = (resumeViewDTO) request.getAttribute("list");

    %>

    <section class="mb-5">



        <div class="container mt-5 d-flex justify-content-center"><h4>이력서 제목</h4></div>

            <div class="d-flex justify-content-center my-2 ">
                <input type="text" id="subject" name="subject" class="p-4 my-3 border-5 w-50 border-dark" value="<%= dto.getR_title() %>" readonly>
                    <%--            <input type="text" placeholder="이력서 제목을 입력하세요."/>--%>
                </input>
            </div>



            <div class="container p-3"><h4>기본정보</h4></div>

            <div id="basic" class="container p-5 border bg-white">

                <div class="form-group row">

                    <label class="ml-3 my-2  text-info">이름</label><span class="req my-2"></span>

                    <input type="text" class="form-control w-25 ml-5 bg-white border-0" id="basicName" name="basicName" readonly value="<%= dto.getR_name()%>">

                    <span class="req my-2">구직상태 : </span>
                    <input type="text" class="form-control w-25 ml-5 bg-white border-0" id="status" name="basicName" readonly value="<%= dto.getR_status()%>">



                    <%--                        <form id="uploadForm" enctype="multipart/form-data" method="post">--%>
                    <%--                            <div class="custom-file row ml-3">--%>
                    <%--                            <label class="custom-file-label w-25" for="file-name">Choose file</label>--%>
                    <%--                                <input class="custom-file-input" type="file" name="file" id="file-name"/>--%>
                    <%--                            </div>--%>
                    <%--                        </form>--%>
                </div>

                <div class="form-group row">
                    <label class="ml-3 my-3 mr-1 text-info">생년월일<span class="req my-3"></span></label>
                    <input type="text" class="form-control w-25 ml-3 my-2  bg-white border-0" id="basicBirth" name="basicBirth" value="<%= dto.getR_dateofbirth()%>" readonly>
                        <% if(dto.getR_gender() == 0){%>
                    <span class="req my-2 mr-4">성별 : </span>
                    <input type="text" class="form-control w-25 ml-5 bg-white border-0" value="남"  readonly>

                        <% }else{ %>
                    <span class="req my-2 mr-4">성별 : </span>
                    <input type="text" class="form-control w-25 ml-5 bg-white border-0" value="여"  readonly>
                        <%}%>
                    <div class="row d-flex justify-content-end align-items-start px-5 ml-5">

                    </div>
                </div>
                <div class="form-group row">
                    <label class="ml-3 my-3 mr-2 text-info">이메일<span class="req my-3"></span></label>
                    <input type="text" class="form-control w-25 ml-4 my-2 bg-white border-0" value="<%= dto.getR_email()%>" readonly>
                </div>
                <div class="form-group row">
                    <label class="ml-3 my-3 mr-2 text-info">휴대폰<span class="req my-3"></span></label>
                    <input type="text" class="form-control w-25 ml-4 my-2 bg-white border-0" value="<%= dto.getR_phonenum()%>" readonly>
                </div>
                <script	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
                <div class="form-group row">
                    <label class="ml-3 my-3 text-info">주소<span class="req my-3"></span></label>
                    <input type="text" class="form-control w-50 ml-5 pl-1 my-2 bg-white border-0" value="<%= dto.getR_address1()%>" readonly>

                </div>
                <input type="text" class="form-control w-75 bg-white border-0 m-auto" value="<%= dto.getR_address2()%>" readonly/>

            </div>


            <div class="container p-3 mt-5"><h4>학력사항</h4></div>

            <div id="edu" class="container p-5 mt-0 border bg-white">
                <div class="form-group row">
                    <label class="ml-3 my-3 mr-2 text-info">최종학력</label>
                    <input type="text" class="form-control w-25 ml-4 my-2 bg-white border-0" value="<%= dto.getR_finaledu()%>" readonly>
                </div>

            </div>

            <div class="container p-3 mt-5"><h4>경력사항</h4></div>

            <div id="career" class="container p-5 mt-0 border bg-white">

                <div class="form-group row">
                    <label class="ml-3 my-3 mr-2 text-info"><%= dto.getR_career()%><span class="req my-3 ml-5">총 경력</span></label>
                    <input type="text" class="form-control w-25  my-2 bg-white border-0" value="<%= dto.getR_totalcareer()%>개월" readonly>
                </div>


            </div>





            <div class="container p-3 mt-5"><h4>희망 근무조건 선택</h4></div>
            <div class="container p-5 border bg-white">
                <div class="form-group row my-4">
                    <label class="ml-3 my-3 mr-4 pr-2 text-info">근무형태<span class="req my-2"></span></label>

                    <input type="text" class="form-control w-25 ml-2 bg-white border-0 my-2" value="<%=dto.getR_jobtype()%>" readonly>

                </div>
                <div class="form-group row w-50 my-4">
                    <label class="ml-3 my-2 text-info">연봉</label><span class="req my-2 mr-3"></span>
                    <input type="text" class="form-control w-25 ml-5 bg-white border-0" value="<%=dto.getR_hopeincome()%> 만원" readonly><span class="my-2"></span>
                </div>
                <div class="form-group row my-4">
                    <label class="ml-3 my-2 text-info">근무지역</label><span class="req my-2 mr-1"></span>
                    <input type="text" class="form-control w-25 ml-4 bg-white border-0" value="<%=dto.getR_workarea()%>" readonly>

                </div>

                <div class="form-group row my-4">
                    <label class="ml-3 my-2 text-info">직종</label><span class="req my-2 mr-2"></span>
                    <input type="text" class="form-control w-25 ml-5 bg-white border-0" value="<%=dto.getR_servicetype()%>" readonly>
                </div>
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
<%--<script src="../../../JS/resumeWrite.js" type="text/javascript"></script>--%>

</html>
