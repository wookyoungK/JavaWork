<%@ page import="com.lec.spring.user.domain.ComDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<c:choose>
    <c:when test="${empty select || fn:length(select) == 0 }">
        <script>
            alert("해당 정보가 삭제되거나 없습니다");
            history.back();
        </script>
    </c:when>
    <c:otherwise>

        <!DOCTYPE html>
        <html lang="ko">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
            <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
            <script src="${pageContext.request.contextPath }/JS/yj.js"></script>

            <script src="${pageContext.request.contextPath }/JS/woo.js"></script>
            <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
            <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/CSS/woo.css"/>
            <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/CSS/reset.css"/>
            <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/CSS/yoondoo.css"/>
            <!-- banner관련 -->
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
                  integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
                  crossorigin="anonymous">

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
            String CeoName = "";
            String CName = "";
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

        <div id="HessionHide">
            <div id="CID"><%=CID%>
            </div>
            <div id="CeoName"><%=CeoName%>
            </div>
            <div id="CName"><%=CName%>
            </div>
        </div>


        <div id="main_header">
            <div class="div_1260 row">
                <div id="main_header_log" class="col-md-2" onclick="location.href='/'"></div>
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
                                <a href="/hire/hireSearch.do">
                                    지역별 채용공고
                                </a>
                                <a href="/board/list.do">
                                    BLIND_BOARD
                                </a>
                            </li>


                        </ul>
                        <ul class="col-md-5" class="inline">
                            <li>
                                <a href="#"><i class="fas"></i></a>
                                <%
                                    if (session.getAttribute("comSession") != null) {
                                %>
                                <a href="/logout">로그아웃</a>
                                <% } else {%>
                                <a href="/user/loginchoice">로그인</a>
                                <%}%>
                                <a href="/resume/resumeList" id="header_sub_a1">
                                    이력서 관리
                                </a>

                                <a href="/app/appmyList">
                                    지원 관리
                                </a>
                                <a href="companyMain.jsp" class="white_board_btn">
                                    기업 서비스
                                </a>
                            </li>


                        </ul>

                    </div>
                </nav>
            </div>


        </div>
        <div class="row">

            <div class="writeExtra col-md-2">

            </div>
            <div id="hirewrite" class="col-md-8 row">
                <form name="frm" action="updateOk.do" method="post" onsubmit="return chkUpdate()">
                    <div class="col-md-12 row">
                        기업명:<input class="col-md-5" type="text" name="h_name" value="${select[0].h_name }"/>
                        <input type="hidden" name="h_uid" value="${select[0].h_uid }"/>

                    </div>
                    <br>
                    공고 제목:
                    <input class="col-md-8" type="text" name="h_title" value="${select[0].h_title} "/><br><br>
                    급여:
                    <input class="col-md-5" type="text" name="h_salary" value="${select[0].h_salary}"/><br><br>
                    내용:
                    <input class="col-md-8" type="text" name="h_content" value="${select[0].h_content}"/><br>
                    <br>
                    근무지역:
                    <select class="col-md-4" id="h_position1" name="h_position1">
                        <option value="서울시">서울시</option>
                        <option value="경기도">경기도</option>
                        <option value="부산광역시">부산광역시</option>
                        <option value="인천광역시">인천광역시</option>
                        <option value="대전광역시">대전광역시</option>
                        <option value="대구광역시">대구광역시</option>
                        <option value="을산광역시">을산광역시</option>
                        <option value="" selected>지역 선택</option>
                    </select>
                    <input class="col-md-6" type="text" name="h_position2" placeholder="상세 주소입력"
                           id="h_position2" value="${select[0].h_position2}"/><br>
                    <br>
                    <hr>


                    <h2 id="subTitle">모집 내용</h2>
                    <br>
                    직무:
                    <input class="col-md-4" type="text" name="h_part" value="${select[0].h_part}"/><br>
                    <br>
                    <hr>

                    경력:
                    <input type="radio" name="h_career" value="무관" required/>무관(신입/경력에 상관없이 모집)
                    <input type="radio" name="h_career" value="신입"/>신입
                    <input type="radio" name="h_career" value="경력"/>경력

                    <!-- <input type="radio" name="career" value="mango"/>3년이상
                    <input type="radio" name="career" value="melon"/

                    1,2,번호로 중복값가져오기
                    >메론 -->

                    <br>
                    <hr>
                    학력:
                    <input type="radio" name="h_degree" value="학력무관" required/>학력무관
                    <input type="radio" name="h_degree" value="고졸"/>고졸
                    <input type="radio" name="h_degree" value="대졸"/>대졸
                    <input type="radio" name="h_degree" value="초대졸"/>초대졸
                    <br>
                    <hr>
                    근무형태:
                    <input type="radio" name="h_workform" value="정규직" required/>정규직
                    <input type="radio" name="h_workform" value="파견직"/>파견직
                    <input type="radio" name="h_workform" value="계약직"/>계약직
                    <input type="radio" name="h_workform" value="인턴직"/>인턴직
                    <br>
                    <hr>
                    모집마감일:
                    <input type="radio" name="Date" value="마감일 선택" id="h_endDate"/>마감일 선택
                    <input type="radio" name="Date" value="상시모집" id="h_always"/>상시모집<br><br>

                    <div id="h_date">
                        From: <input type="text" id="h_upDate" name="h_upDate" value="h_upDate" required>&nbsp;&nbsp;&nbsp;
                        To: <input
                            type="text"
                            id="h_regDate"
                            name="h_regDate"
                            value="h_regDate" required>
                    </div>

                    <br><br>


                    <input id="register" class="org_Btn" type="submit" value="공고 등록"/>
                    <button class="org_Btn" type="button" onclick="location.href='hirelist.do'">목록으로</button>

                </form>
            </div>

            <div class="writeExtra col-md-2"></div>
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
                    <a>이메일 : help@saramin.co.kr, Fax : 02-6937-0039(대표), 02-6937-0035(세금계산서) 이메일문의 사람인 네이버 블로그 사람인
                        페이스북
                        페이지</a><br>
                    <br>
                    <a>(주)사람인HR, 우 : 08378, 서울특별시 구로구 디지털로34길 43, 201호(구로동), 대표 : 김용환</a><br>
                    <br>
                    <a>사업자등록 : 113-86-00917, 직업정보제공사업 : 서울 관악 제 2005-6호, 통신판매업 : 제 2339호, Copyright (c) (주)사람인HR.
                        All rights
                        reserved.</a><br>
                </div>
            </div>
        </div>
        </div>

        </body>
        </html>


    </c:otherwise>
</c:choose>