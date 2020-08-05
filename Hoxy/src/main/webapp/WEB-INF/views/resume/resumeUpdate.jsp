<%@ page import="com.lec.spring.resume.domain.resumeWriteVO" %>
<%@ page import="com.lec.spring.resume.domain.resumeUpdateDTO" %>
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
    <title>NEXT 이력서 수정하기</title>
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

<%   resumeUpdateDTO vo = (resumeUpdateDTO) request.getAttribute("list");

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

    <section class="mb-5">

        <form id="uploadForm" enctype="multipart/form-data" method="post">
            <div class="container p-3"><h4>프로필 사진 업로드</h4></div>

            <div class="container border bg-white p-3 w-50">
                <div class="custom-file">
                    <label class="my-3">프로필 업로드</label>
                    <label class="custom-file-label w-25 m-auto" for="file-name">Choose file</label>
                    <input class="custom-file-input w-25 m-auto" type="file" name="file" id="file-name"/>
                </div>
                <button type="button" class="input-group-text m-auto" id="btn-upload">사진 업로드</button>
            </div>
        </form>


        <form method="post" id="form1">
            <div class="d-flex justify-content-center my-5">
                <input type="text" id="subject" name="subject" class="p-4 my-3 border-5 w-50 border-dark" placeholder="이력서 제목을 입력하세요." value="<%= vo.getR_title()%>">
                    <%--            <input type="text" placeholder="이력서 제목을 입력하세요."/>--%>
                </input>
            </div>



            <div class="container p-3"><h4>기본정보</h4></div>

            <div id="basic" class="container p-5 border bg-white">

                <div class="form-group row">

                    <label class="ml-3 my-2">이름</label><span class="req my-2">필수</span>

                    <input type="text" class="form-control w-25 ml-5" id="basicName" name="basicName" value="<%= vo.getR_name()%>" required>

                    <select class="browser-default custom-select w-25 ml-5" id="selectStatus" required>
                        <option selected>구직상태 선택</option>
                        <option value="1">구직준비중(재학생)</option>
                        <option value="2">구직중</option>
                        <option value="3">재직중</option>
                    </select>

                                    <input class="container row" type="hidden" id="resumeStatus" name="resumeStatus" value="1">

                    <%--                        <form id="uploadForm" enctype="multipart/form-data" method="post">--%>
                    <%--                            <div class="custom-file row ml-3">--%>
                    <%--                            <label class="custom-file-label w-25" for="file-name">Choose file</label>--%>
                    <%--                                <input class="custom-file-input" type="file" name="file" id="file-name"/>--%>
                    <%--                            </div>--%>
                    <%--                        </form>--%>
                </div>

                <div class="form-group row">
                    <label class="ml-3 my-3 mr-1">생년월일<span class="req my-3">필수</span></label>
                    <input type="text" class="form-control w-25 ml-3 my-2 mr-5" id="basicBirth" name="basicBirth" placeholder="YYYYMMDD" value="<%= vo.getR_dateofbirth()%>">
                    <div class="btn-group btn-group-toggle ml-5 h-50 my-2 px-3 mr-5" data-toggle="buttons">
                        <label class="btn btn-secondary active">
                            <input type="radio" name="optionSelected" id="option1" autocomplete="off" value="남" checked> 남
                        </label>
                        <label class="btn btn-secondary">
                            <input type="radio" name="options2" id="option2" autocomplete="off" value="여"> 여
                        </label>
                    </div>
                    <div class="row d-flex justify-content-end align-items-start px-5 ml-5">

                    </div>
                </div>
                <div class="form-group row">
                    <label class="ml-3 my-3 mr-2">이메일<span class="req my-3">필수</span></label>
                    <input type="text" class="form-control w-25 ml-4 my-2" id="basicEmail" name="basicEmail" value="<%= vo.getR_email()%>">
                </div>
                <div class="form-group row">
                    <label class="ml-3 my-3 mr-2">휴대폰<span class="req my-3">필수</span></label>
                    <input type="text" class="form-control w-25 ml-4 my-2" id="basicPhone" name="basicPhone" value="<%= vo.getR_phonenum()%>">
                </div>
                <script	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
                <div class="form-group row">
                    <label class="ml-3 my-3">주소<span class="req my-3">필수</span></label>
                    <input type="text" class="form-control w-50 ml-5 pl-1 my-2" id="basicAddrs" name="basicAddrs" value="<%= vo.getR_address1()%>" readonly>
                    <input type="button" onclick="juso()" value="주소 찾기" id="sample4_btn" class="ml-5 h-50 my-2 btn btn-secondary">
                </div>
                <input type="text" class="form-control w-75" id="basicAddrs2" name="basicAddrs2" value="<%= vo.getR_address2()%>"/>

            </div>






            <div class="container p-3 mt-5"><h4>TOEIC 점수</h4></div>
            <div class="container p-5 border bg-white">
                <div class="form-group row">
                    <label class="ml-3 my-2 ">점수(0-990)</label>
                    <input type="text" class="form-control w-25 ml-5" id="toeicScore" name="toeicScore" value="">
                    <span class="ml-3 my-2">점</span>
                </div>
            </div>

            <div class="container p-3 mt-5"><h4>자기소개서</h4></div>

            <div class="container p-5 border bg-light">
                <input type="text" id="intro" name="introTitle" class="form-control border-bottom-2" value=""  placeholder="자소서 제목 (100자까지 입력 가능합니다.)" maxlength="100">
                <textarea class="form-control h-25 DOC_TEXT" name="introduction" form="form1"></textarea>
                <div class="container"><span class="mr-2">글자수</span><span class="text-muted" id="counter">(<span class="text-warning">0</span> / 최대 1000자)</span></div>
            </div>

            <div class="container p-3 mt-5"><h4>희망 근무조건 선택</h4></div>
            <div class="container p-5 border bg-white">
                <div class="form-group row my-4">
                    <label class="ml-3 my-3 mr-4 pr-2">근무형태<span class="req my-2">필수</span></label>
                    <select class="browser-default custom-select w-25  my-2" id="selectJopType">
                        <option selected>선택</option>
                        <option value="1">IT</option>
                        <option value="2">게임</option>
                        <option value="3">사무직</option>
                    </select>
                    <input type="hidden" id="HopeJobType" name="HopeJobType" value="1">

                </div>
                <div class="form-group row w-50 my-4">
                    <label class="ml-3 my-2">연봉</label><span class="req my-2 mr-3">필수</span>
                    <input type="text" class="form-control w-25 ml-5" id="hopeIncome" name="hopeIncome" value="<%= vo.getR_hopeincome()%>"><span class="ml-3 my-2">만원</span>
                </div>
                <div class="form-group row my-4">
                    <label class="ml-3 my-2">근무지역</label><span class="req my-2 mr-1">필수</span>
                    <input type="text" class="form-control w-25 ml-4" id="hopeArea" name="hopeArea" value="<%= vo.getR_workarea()%>">

                </div>

                <div class="form-group row my-4">
                    <label class="ml-3 my-2">직종</label><span class="req my-2 mr-2">필수</span>
                    <input type="text" class="form-control w-25 ml-5" id="hopeService" name="hopeService" value="<%= vo.getR_servicetype()%>">
                </div>
            </div>

            <div class="container p-3 mt-5"><h4>포트폴리오 및 기타문서</h4></div>
            <div class="container p-5 border bg-white">
                <div class="form-group row">
                    <label class="ml-3 my-2 ">포트폴리오 URL</label>
                    <input type="text" class="form-control w-75 ml-5" id="portUrl" name="portUrl" value="">
                    <span class="ml-3 my-2"></span>
                </div>
            </div>

            <div class="container p-5  d-flex justify-content-center">
                <button type="button" class="btn btn-success btn-lg" id="resumeUpdate">이력서 수정하기</button>
            </div>


        </form>
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
<script src="../../../JS/resumeUpdate.js" type="text/javascript"></script>

</html>
