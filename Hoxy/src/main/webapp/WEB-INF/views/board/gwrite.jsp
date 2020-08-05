<%@ page import="com.lec.spring.user.domain.AdmDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/CSS/reset.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/CSS/yoondoo.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/CSS/jinyoung.css"/>

    <script src="${pageContext.request.contextPath }/JS/yj.js"></script>


    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <%--폰트--%>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">


    <!-- banner관련 -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
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
            interval : 100
        })
    </script>


    <%--icon--%>
    <link rel="shortcut icon" type="image/x-icon"
          href="https://i.imgur.com/8AyMFrx.png">
</head>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<title>글작성</title>

<script>
    function chkSubmit(){  // 폼 검증

        return true;
    }

</script>
<body>

<%

    int adminID = 0;
    AdmDTO dto;
    if(session.getAttribute("admSession") != null) {
        dto = (AdmDTO) session.getAttribute("admSession");
        adminID = dto.getA_uid();
    }


%>


<c:set var="adminID" value="<%=adminID%>"></c:set>
<c:if test="<%=adminID == 0%>">
    <script>

        Swal.fire({
            icon: 'success',
            title: '접속 실패!',
            text: '로그인 페이지로 이동합니다.!',
            buttons : {
                confirm : {
                    text : 'OK',
                    value : true
                }
            }

        }).then((result) => {
            if(result){
                location.href = "../../user/login";
            }
        })

    </script>
</c:if>


<div id="main_header">
    <div class = "div_1260 row" style="background-color: white">
        <div id = "main_header_log" class="col-md-2"></div>
        <div class="col-md-7"><h2 id = "main_header_sub">일할래 Hoxy?</h2></div>
        <div id="demo" class="carousel slide col-md-3" data-ride="carousel">
            <div class="carousel-inner demo">
                <!-- 슬라이드 쇼 -->
                <div class="carousel-item active">
                    <!--가로-->
                    <img class="d-block w-100" src="https://www.saraminbanner.co.kr/new/main/2019/09/pxarcp_3lrf-2rxicx_GNB02.png"
                         alt="First slide">
                    <div class="carousel-caption d-none d-md-block"></div>
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="https://www.saraminbanner.co.kr/new/main/2019/02/pn95lv_90sh-2rxibq_GNBbanner01recommend.png"
                         alt="Second slide">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="https://www.saraminbanner.co.kr/new/main/2020/06/qcpw4j_k0rw-2rxibp_bannertopside.png"
                         alt="Third slide">
                </div>
            </div>
        </div>

    </div>
    <div>
        <nav id = "header_nav">

            <div class = "div_1260 row">
                <ul class = "col-md-7" class = "inline">
                    <li >
                        <a href="#"><i class="fas fa-bars"></i></a>
                        <a href="#">
                            지역별
                        </a>
                        <a href="#">
                            BLIND_BOARD
                        </a>
                    </li>


                </ul>
                <ul class = "col-md-5" class = "inline">
                    <li>
                        <a href="#"><i class="fas"></i></a>
                        <a href="#">
                            로그인
                        </a>
                        <a href="#" id="header_sub_a1">
                            이력서 관리
                            <div id = "header_sub_nav1" class="inline">
                                <ul class = "inline">
                                    <li >이력서 등록</li>
                                    <li >이력서 현황</li>
                                    <li >이력서 수정</li>
                                </ul>
                            </div>
                        </a>

                        <a href="#">
                            지원 관리
                        </a>
                        <a href="#">
                            기업 서비스
                        </a>
                    </li>


                </ul>

            </div>
        </nav>
    </div>
</div>


<div class="container">
    <br><br><br>

    <h1>BLIND BOARD</h1>
    <br>
    <div class="wrtie_bar"></div>
    <form name="frm" action="writeOk.do" method="post" onsubmit="return chkSubmit()">

        <div class="form-group">
            <br>
            <br>
            <br>
            <label>Subject *</label>
            <br>
            <br>
            <br>
            <input type="text" name="subject" class="form-control" placeholder="Please Write Subject" required="required"/><br>
        </div>

        <div class="row">
            <div class="form-group col-md-6">
                <label>Category *</label>
                <br>
                <br>
                <br>
                <select name="category" class="form-control">
                    <option>공지사항</option>

                </select>
            </div>

            <div class="form-group col-md-6">

                <input type="hidden" name="c_uid" class="form-control" value="2">

            </div>
        </div>

        <br>
        <br>
        <br>
        <div class="form-group">
            <label>Content *</label>
            <br>
            <br>
            <br>
            <textarea name="content" class="form-control" rows="5" placeholder="Please Write Content" required="required"></textarea>
        </div>
        <input type="hidden" name="u_uid" value="1"/><br>
        <button type="submit" class="org_Btn regist_Btn" value="등록">등록</button>
        <button type="button" class="gray_Btn" onclick="location.href='list.do'">목록</button>
    </form>

    <div class="pad20">


    </div>







</div>


<div id="main_footer">

    <div id="main_footer_nav" >
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
        <div id = "main_footer_img" class="col-md-1 ">
        </div>
        <div id="main_footer_content" class="div_1260 col-md-8">
            <a>사람인 고객센터 02-2025-4733 (평일 09:00~19:00, 주말·공휴일 휴무)</a><br>
            <br>
            <a>이메일 : help@saramin.co.kr, Fax : 02-6937-0039(대표), 02-6937-0035(세금계산서) 이메일문의 사람인 네이버 블로그 사람인 페이스북 페이지</a><br>
            <br>
            <a>(주)사람인HR, 우 : 08378, 서울특별시 구로구 디지털로34길 43, 201호(구로동), 대표 : 김용환</a><br>
            <br>
            <a>사업자등록 : 113-86-00917, 직업정보제공사업 : 서울 관악 제 2005-6호, 통신판매업 : 제 2339호, Copyright (c) (주)사람인HR. All rights reserved.</a><br>
        </div>
    </div>
</div>



<%-- 글 내용이 많을수 있기 때문에 POST 방식 사용 --%>



</body>
</html>















