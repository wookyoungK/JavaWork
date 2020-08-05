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
        <input type="text" id="subject" name="subject" class="p-4 my-3 border-5 w-50 border-dark" placeholder="이력서 제목을 입력하세요.">
<%--            <input type="text" placeholder="이력서 제목을 입력하세요."/>--%>
        </input>
        </div>



        <div class="container p-3"><h4>기본정보</h4></div>

        <div id="basic" class="container p-5 border bg-white">

            <div class="form-group row">

                <label class="ml-3 my-2">이름</label><span class="req my-2">필수</span>

                <input type="text" class="form-control w-25 ml-5" id="basicName" name="basicName" required>

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
                <input type="text" class="form-control w-25 ml-3 my-2 mr-5" id="basicBirth" name="basicBirth" placeholder="YYYYMMDD">
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
                <input type="text" class="form-control w-25 ml-4 my-2" id="basicEmail" name="basicEmail">
            </div>
            <div class="form-group row">
                <label class="ml-3 my-3 mr-2">휴대폰<span class="req my-3">필수</span></label>
                <input type="text" class="form-control w-25 ml-4 my-2" id="basicPhone" name="basicPhone">
            </div>
            <script	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
            <div class="form-group row">
                <label class="ml-3 my-3">주소<span class="req my-3">필수</span></label>
                <input type="text" class="form-control w-50 ml-5 pl-1 my-2" id="basicAddrs" name="basicAddrs" readonly>
                <input type="button" onclick="juso()" value="주소 찾기" id="sample4_btn" class="ml-5 h-50 my-2 btn btn-secondary">
            </div>
                <input type="text" class="form-control w-75" id="basicAddrs2" name="basicAddrs2"/>

        </div>


        <div class="container p-3 mt-5"><h4>학력사항</h4></div>

        <div id="edu" class="container pr-5 pl-5 pb-5 pt-0 mt-0 border bg-white">
            <div class="container btn-group border-bottom p-4  d-flex justify-content-start" role="group" aria-label="First group">
                <button type="button" class="btn btn-secondary border" id="eduElebtn">초등학교 졸업</button>
                <button type="button" class="btn btn-secondary border" id="eduMedbtn">중학교 졸업</button>
                <button type="button" class="btn btn-secondary border" id="eduHighbtn">고등학교 졸업</button>
                <button type="button" class="btn btn-secondary border" id="eduUnibtn">대학, 대학원 이상 졸업</button>
            </div>

            <div id="eduEle">
                <h5 class="mt-5">초등학교 정보 입력</h5>
            <div class="form-group row mt-5">
                <label class="ml-3 my-2">학교명</label><span class="req my-2">필수</span>
                <input type="text" class="form-control w-25 ml-5" id="eleEduName" name="eleEduName">

            </div>
            <div class="form-group row">
                <label class="ml-3 my-3 mr-2">재학기간<span class="req my-3">필수</span></label>
                <input type="text" class="form-control w-25 my-2" id="eduElePeriod" name="eduElePeriod" placeholder="YYYY/MM">
                 <span class="d-flex justify-content-center my-2 ml-3"> <h2> ~ </h2> </span>
                <input type="text" class="form-control w-25 ml-4 my-2" id="eduElePeriod2" name="eduElePeriod2" placeholder="YYYY/MM">
            </div>
            <div class="form-group row my-2">
                <label class="ml-3 my-3 mr-4 pr-2">지역</label>
                <select class="browser-default custom-select w-25 ml-5 my-2" id="selectEleArea">
                    <option selected>지역 선택</option>
                    <option value="1">서울</option>
                    <option value="2">경기</option>
                    <option value="3">인천</option>
                </select>
                <input type="hidden" id="eduEleArea" name="eduEleArea" value="1">

            </div>

            </div>

            <div id="eduMed">
                <h5 class="mt-5">중학교 정보 입력</h5>
                <div class="form-group row mt-5">
                    <label class="ml-3 my-2">학교명</label><span class="req my-2">필수</span>
                    <input type="text" class="form-control w-25 ml-5" id="eduMedName" name="eduMedName">

                </div>
                <div class="form-group row">
                    <label class="ml-3 my-3 mr-2">재학기간<span class="req my-3">필수</span></label>
                    <input type="text" class="form-control w-25 my-2" id="eduMedPeriod" name="eduMedPeriod" placeholder="YYYY/MM">
                    <span class="d-flex justify-content-center my-2 ml-3"> <h2> ~ </h2> </span>
                    <input type="text" class="form-control w-25 ml-4 my-2" id="eduMedPeriod2" name="eduMedPeriod2" placeholder="YYYY/MM">
                </div>
                <div class="form-group row my-2">
                    <label class="ml-3 my-3 mr-4 pr-2">지역</label>
                    <select class="browser-default custom-select w-25 ml-5 my-2" id="selectMedArea">
                        <option selected>지역 선택</option>
                        <option value="1">서울</option>
                        <option value="2">경기</option>
                        <option value="3">인천</option>
                    </select>
                    <input type="hidden" id="eduMedArea" name="eduMedArea" value="1">
                </div>
            </div>

                <div id="eduHigh">
                    <h5 class="mt-5">고등학교 정보 입력</h5>
                    <div class="form-group row mt-5">
                        <label class="ml-3 my-2">학교명</label><span class="req my-2">필수</span>
                        <input type="text" class="form-control w-25 ml-5" id="EduHighName" name="EduHighName">

                    </div>
                    <div class="form-group row">
                        <label class="ml-3 my-3 mr-2">재학기간<span class="req my-3">필수</span></label>
                        <input type="text" class="form-control w-25 my-2" id="eduHighPeriod" name="eduHighPeriod" placeholder="YYYY/MM">
                        <span class="d-flex justify-content-center my-2 ml-3"> <h2> ~ </h2> </span>
                        <input type="text" class="form-control w-25 ml-4 my-2" id="eduHighPeriod2" name="eduHighPeriod2" placeholder="YYYY/MM">
                    </div>
                    <div class="form-group row">
                        <label class="ml-3 my-3 pr-2 mr-3">전공 계열</label>
                        <select class="browser-default custom-select w-25 ml-4 my-2" id="selectHighDep">
                            <option selected>전공계열 선택</option>
                            <option value="1">문과계열</option>
                            <option value="2">이과계열</option>
                            <option value="3">전문(실업)계</option>
                            <option value="4">예체능계</option>
                            <option value="5">특수목적고</option>
                        </select>
                        <input type="hidden" id="eduHighDep" name="eduHighDep" value="1">
                    </div>
                    <div class="form-group row">
                        <label class="ml-3 my-3 mr-4 pr-2">지역</label>
                        <select class="browser-default custom-select w-25 ml-5 my-2" id="selectHighArea">
                            <option selected>지역 선택</option>
                            <option value="1">서울</option>
                            <option value="2">경기</option>
                            <option value="3">인천</option>
                        </select>
                        <input type="hidden" id="eduHighArea" name="eduHighArea" value="1">
                    </div>
                </div>

            <div id="eduUni">
                <h5 class="mt-5">대학,대학원 정보 입력</h5>
                <div class="form-group row">
                    <label class="ml-3 my-3 mr-4 pr-2">대학<span class="req my-2">필수</span></label>
                    <select class="browser-default custom-select w-25 ml-5 my-2" id="selectUniYear">
                        <option selected>선택</option>
                        <option value="1">대학(2,3년)</option>
                        <option value="2">대학교(4년)</option>
                        <option value="3">대학원(석사)</option>
                        <option value="4">대학원(박사)</option>
                    </select>
                    <input type="hidden" id="eduUniYear" name="eduUniYear" value="1">
                </div>
                <div class="form-group row">
                    <label class="ml-3 my-2 ">학교명</label><span class="req my-2 mr-3">필수</span>
                    <input type="text" class="form-control w-25 ml-5" id="EduUniName" name="EduUniName">

                </div>
                <div class="form-group row">
                    <label class="ml-3 my-3 mr-4">재학기간<span class="req my-3">필수</span></label>
                    <input type="text" class="form-control w-25 my-2" id="eduUniPeriod" name="eduUniPeriod" placeholder="YYYY/MM">
                    <span class="d-flex justify-content-center my-2 ml-3"> <h2> ~ </h2> </span>
                    <input type="text" class="form-control w-25 ml-4 my-2" id="eduUniPeriod2" name="eduUniPeriod2" placeholder="YYYY/MM">
                </div>
                <div class="form-group row">
                    <label class="ml-3 my-2 ">전공 계열</label><span class="req my-2">필수</span>
                    <input type="text" class="form-control w-25 ml-5" id="EduUniMajor" name="EduUniMajor">

                </div>
                <div class="form-group row">
                    <label class="ml-3 my-2 ">전공 학과</label><span class="req my-2">필수</span>
                    <input type="text" class="form-control w-25 ml-5" id="EduUniDep" name="EduUniDep">

                </div>
                <div class="form-group row">
                    <label class="ml-3 my-3 mr-4 pr-2">지역<span class="req my-2">필수</span></label>
                    <select class="browser-default custom-select w-25 ml-5 my-2" id="selectUniArea">
                        <option selected>지역 선택</option>
                        <option value="1">서울</option>
                        <option value="2">경기</option>
                        <option value="3">인천</option>
                    </select>
                    <input type="hidden" id="eduUniArea" name="eduUniArea" value="1">
                </div>
            </div>

            </div>

        <div class="container p-3 mt-5"><h4>경력사항</h4></div>

        <div id="career" class="container pr-5 pl-5 pb-5 pt-0 mt-0 border bg-white">
            <div class="container btn-group border-bottom p-4  d-flex justify-content-start align-items-center w-50 border-bottom" role="group" aria-label="First group">
                <button type="button" class="btn btn-secondary border" id="recruitsbtn">신입</button>
                <button type="button" class="btn btn-secondary border" id="careerbtn">경력</button>

            </div>


            <div id="careerform">
                <div class="form-group row mt-5">
                    <label class="ml-3 my-2">회사명</label><span class="req my-2">필수</span>
                    <input type="text" class="form-control w-25 ml-5" id="comName" name="comName">
                </div>
                <div class="form-group row">
                    <label class="ml-3 my-3 mr-2">재직기간<span class="req my-3 mr-4">필수</span></label>
                    <input type="text" class="form-control w-25 my-2" id="comPeriod" name="comPeriod" placeholder="YYYY/MM">
                    <span class="d-flex justify-content-center my-2 ml-3"> <h2> ~ </h2> </span>
                    <input type="text" class="form-control w-25 ml-4 my-2" id="comPeriod2" name="comPeriod2" placeholder="YYYY/MM">
                </div>
                <div class="form-group row">
                    <label class="ml-3 my-2 ">직급/직책</label><span class="req mt-2 mr-1">필수</span>
                    <input type="text" class="form-control w-25 ml-4" id="comPosition" name="comPosition">

                </div>
                <div class="form-group row">
                    <label class="ml-3 my-2 ">직종</label><span class="req my-2 mr-3">필수</span>
                    <input type="text" class="form-control w-25 ml-5" id="comJobType" name="comJobType">

                </div>
                <div class="form-group row">
                    <label class="ml-3 my-2 ">연봉</label><span class="req my-2 mr-3">필수</span>
                    <input type="text" class="form-control w-25 ml-5" id="comIncome" name="comIncome">

                </div>
                <div class="form-group row w-25">
                    <label class="ml-3 my-2 ">총 경력</label><span class="req my-2">필수</span>
                    <input type="text" class="form-control w-25 ml-5" id="totalCareer" name="totalCareer">
                    <span class="my-2 ml-2">개월</span>
                </div>

            </div>
        </div>

        <div class="container p-3 mt-5"><h4>TOEIC 점수</h4></div>
        <div class="container p-5 border bg-white">
            <div class="form-group row">
                <label class="ml-3 my-2 ">점수(0-990)</label>
                <input type="text" class="form-control w-25 ml-5" id="toeicScore" name="toeicScore">
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
                    <option value="1">서울</option>
                    <option value="2">경기</option>
                    <option value="3">인천</option>
                </select>
                <input type="hidden" id="HopeJobType" name="HopeJobType" value="1">

            </div>
            <div class="form-group row w-50 my-4">
                <label class="ml-3 my-2">연봉</label><span class="req my-2 mr-3">필수</span>
                <input type="text" class="form-control w-25 ml-5" id="hopeIncome" name="hopeIncome"><span class="ml-3 my-2">만원</span>
            </div>
            <div class="form-group row my-4">
                <label class="ml-3 my-2">근무지역</label><span class="req my-2 mr-1">필수</span>
                <input type="text" class="form-control w-25 ml-4" id="hopeArea" name="hopeArea">

            </div>

            <div class="form-group row my-4">
                <label class="ml-3 my-2">직종</label><span class="req my-2 mr-2">필수</span>
                <input type="text" class="form-control w-25 ml-5" id="hopeService" name="hopeService">
            </div>
        </div>

        <div class="container p-3 mt-5"><h4>포트폴리오 및 기타문서</h4></div>
        <div class="container p-5 border bg-white">
            <div class="form-group row">
                <label class="ml-3 my-2 ">포트폴리오 URL</label>
                <input type="text" class="form-control w-75 ml-5" id="portUrl" name="portUrl">
                <span class="ml-3 my-2"></span>
            </div>
        </div>

        <div class="container p-5  d-flex justify-content-center">
        <button type="button" class="btn btn-success btn-lg" id="resumeSave">이력서 저장하기</button>
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
<script src="../../../JS/resumeWrite.js" type="text/javascript"></script>

</html>
