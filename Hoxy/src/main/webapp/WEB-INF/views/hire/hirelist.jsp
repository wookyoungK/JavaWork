<%@ page import="com.lec.spring.user.domain.ComDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="${pageContext.request.contextPath }/JS/yj.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
    <script src="${pageContext.request.contextPath }/JS/woo.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/CSS/woo.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/CSS/reset.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/CSS/yoondoo.css"/>
    <!-- banner관련 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <%--    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"--%>
    <%--            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"--%>
    <%--            crossorigin="anonymous"></script>--%>


    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <script>
        $('.carousel').carousel({
            interval: 100
        })
    </script>


    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <%--폰트--%>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">

    <%--icon--%>
    <link rel="shortcut icon" type="image/x-icon"
          href="https://i.imgur.com/8AyMFrx.png">
</head>

<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<style>
    /*datepicer 버튼 롤오버 시 손가락 모양 표시*/
    .ui-datepicker-trigger {
        cursor: pointer;
    }

    /*datepicer input 롤오버 시 손가락 모양 표시*/
    .hasDatepicker {
        cursor: pointer;
    }
</style>

<title>기업 공고 등록</title>
<body>
<%
    int CID = 0;
    String CeoName="";
    String CName="";
    if (session.getAttribute("comSession") == null) {
%>
<script>
    alert('로그인이 필요한 페이지 입니다');
    location.href = "/com/login"
</script>
<%
    } else {

        ComDTO dto = (ComDTO) session.getAttribute("comSession");
        CID = dto.getC_uid();
        CeoName = dto.getC_ceoName();
        CName = dto.getC_name();
    }
%>

<div>


    <div id="main_header">
        <div class="div_1260 row">
            <div id="main_header_log" class="col-md-2"></div>
            <div class="col-md-7"><h2 id="main_header_sub">일할래 Hoxy?</h2></div>
            <div id="demo" class="carousel slide col-md-3" data-ride="carousel">
                <div class="carousel-inner demo">
                    <!-- 슬라이드 쇼 -->
                    <div class="carousel-item active">
                        <!--가로-->
                        <img class="d-block w-100"
                             src="https://www.saraminbanner.co.kr/new/main/2019/09/pxarcp_3lrf-2rxicx_GNB02.png"
                             alt="First slide">
                        <div class="carousel-caption d-none d-md-block"></div>
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100"
                             src="https://www.saraminbanner.co.kr/new/main/2019/02/pn95lv_90sh-2rxibq_GNBbanner01recommend.png"
                             alt="Second slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100"
                             src="https://www.saraminbanner.co.kr/new/main/2020/06/qcpw4j_k0rw-2rxibp_bannertopside.png"
                             alt="Third slide">
                    </div>
                </div>
            </div>
        </div>

        <div>
            <nav id="header_nav">

                <div class="div_1260 row">
                    <ul class="col-md-7" class="inline">
                        <li>
                            <a href="#"><i class="fas fa-bars"></i></a>
                            <a href="#">
                                Welcome <%=CName%> Company
                            </a>
                        </li>


                    </ul>
                    <ul class="col-md-5" class="inline">
                        <li>
                            <a href="#"><i class="fas"></i></a>
                            <%
                                if(session.getAttribute("comSession") != null) {
                            %>
                            <a href="/logout" class="white_board_btn">로그아웃</a>
                            <% }else{%>
                            <a href="/user/loginchoice" class="white_board_btn">로그인</a>
                            <%}%>

                            <a href="/app/appcomList">
                                지원 관리
                            </a>
                            <a href="/hire/hirelist.do" >
                                채용 공고
                            </a>

                        </li>


                    </ul>

                </div>
            </nav>
        </div>
        <%-- 글목록 --%>
        <div id="list" class="col-md-12 row">
            <div class="d01 col-md-1">
                <%--                <div class="left" id="pageinfo"></div>--%>


            </div>


            <form class=col-md-9" id="frmList" name="frmList">
                <table>
                    <tbody>

                    </tbody>
                </table>
            </form>

            <%--버튼 --%>

            <div class="right col-md-2" id="pageRows">

                <button id="register" class="org_Btn" onclick="location.href='write.do'">공고등록</button>
            </div>

            <div id="HessionHide">
                <%--                <input type="hidden" value="<%=CID%>" id="CID"/>--%>
                <div id="CID"><%=CID%></div>
                <div id="CeoName"><%=CeoName%></div>
                <div id="CName"><%=CName%></div>

            </div>
        </div>


        <br>
        <%-- 페이징 --%>
        <div class="center">
            <ul class="pagination" id="pagination">

            </ul>
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
                    <a>이메일 : help@saramin.co.kr, Fax : 02-6937-0039(대표), 02-6937-0035(세금계산서) 이메일문의 사람인 네이버 블로그 사람인 페이스북
                        페이지</a><br>
                    <br>
                    <a>(주)사람인HR, 우 : 08378, 서울특별시 구로구 디지털로34길 43, 201호(구로동), 대표 : 김용환</a><br>
                    <br>
                    <a>사업자등록 : 113-86-00917, 직업정보제공사업 : 서울 관악 제 2005-6호, 통신판매업 : 제 2339호, Copyright (c) (주)사람인HR. All
                        rights
                        reserved.</a><br>
                </div>
            </div>
        </div>


</body>
</html>




