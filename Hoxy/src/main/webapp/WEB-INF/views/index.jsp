<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <!--COLOR PICKER-->
    <link rel="icon" type="image/png" href="http://example.com/myicon.png">
    <script src="${pageContext.request.contextPath }/JS/jscolor.js"></script>


    <!--부트스트랩 차트-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- 차트 링크 -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>


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
    <script src="${pageContext.request.contextPath }/JS/yj.js"></script>


    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">


    <link rel="shortcut icon" type="image/x-icon"
          href="https://i.imgur.com/8AyMFrx.png">

    <title>입사지원관리</title>
</head>

<body class="bk_gray">
<div id="header" class="row">

    <div class="col-md-2"></div>
    <div id="small_logo" class="col-md-2" onclick="location.href='/managerMain'"></div>

    <ul class="col-md-4" class="inline">
    </ul>
    <ul class="col-md-4" class="inline">
        <li>
            <a href="#"><i class="fas"></i></a>
            <%
                if(session.getAttribute("admSession") != null) {
            %>
            <a href="/logout" class="white_board_btn">로그아웃</a>
            <% }else{%>
            <a href="/user/loginchoice" class="white_board_btn">로그인</a>
            <%}%>
            <a href="/app/color">
                지원통계관리
            </a>

            <a href="/board/gWrite.do">
                공지등록
            </a>

        </li>


    </ul>


</div>
<div class="main_box div_950">
    <div class="main_box_content">
        <h1>지원 통계 목록</h1><br><br>
        <form action="listUpdate" method="post" class="row">
            <div class="col-md-12 padding20"></div>

            <c:forEach var="List" items="${List }">

                <div class="col-md-1"></div>
                <div class="col-md-5 listupdate">
                    <c:if test="${List.graphView1 == 1}">
                        <input type="checkbox" name="graphView1" value="1" checked="checked"> 지원자 수<br>
                    </c:if>
                    <c:if test="${List.graphView1 != 1}">
                        <input type="checkbox" name="graphView1" value="1"> 지원자 수<br>
                    </c:if>


                    <c:if test="${List.graphView2 == 1}">
                        <input type="checkbox" name="graphView2" value="1" checked="checked"> 경력별 현황<br>
                    </c:if>
                    <c:if test="${List.graphView2 != 1}">
                        <input type="checkbox" name="graphView2" value="1"> 경력별 현황<br>
                    </c:if>


                    <c:if test="${List.graphView3 == 1}">
                        <input type="checkbox" name="graphView3" value="1" checked="checked"> 연봉별 현황<br>
                    </c:if>
                    <c:if test="${List.graphView3 != 1}">
                        <input type="checkbox" name="graphView3" value="1"> 연봉별 현황<br>
                    </c:if>


                    <c:if test="${List.graphView4 == 1}">
                        <input type="checkbox" name="graphView4" value="1" checked="checked"> 성별별 현황<br>
                    </c:if>
                    <c:if test="${List.graphView4 != 1}">
                        <input type="checkbox" name="graphView4" value="1"> 성별별 현황<br>
                    </c:if>

                </div>
                <div class="col-md-6 listupdate">
                    <c:if test="${List.graphView5 == 1}">
                        <input type="checkbox" name="graphView5" value="1" checked="checked"> 연령별 현황<br>
                    </c:if>
                    <c:if test="${List.graphView5 != 1}">
                        <input type="checkbox" name="graphView5" value="1"> 연령별 현황<br>
                    </c:if>


                    <c:if test="${List.graphView6 == 1}">
                        <input type="checkbox" name="graphView6" value="1" checked="checked"> 학력별 현황<br>
                    </c:if>
                    <c:if test="${List.graphView6 != 1}">
                        <input type="checkbox" name="graphView6" value="1"> 학력별 현황<br>
                    </c:if>


                    <c:if test="${List.graphView7 == 1}">
                        <input type="checkbox" name="graphView7" value="1" checked="checked"> TOEIC<br>
                    </c:if>
                    <c:if test="${List.graphView7 != 1}">
                        <input type="checkbox" name="graphView7" value="1"> TOEIC<br>
                    </c:if>
                </div>

            </c:forEach>
            <div class="col-md-12 padding20"></div>
            <div class="col-md-1"></div>
            <button type="submit" class="org_Btn">즉시적용</button>
        </form>
    </div>
    <div class="padding20"></div>
    <div class="main_box_content">
        <h1>지원 통계 디자인</h1><br><br>
        <form action="colorUpdate" method="post" class = "row">
            <c:forEach var="Color" items="${Color }">
                <div class="col-md-6">
                    <br><br>
                    Color1: <input id="color1" name="color1" value="${Color.color1 }" data-jscolor=""><br><br>
                    Color2: <input id="color2" name="color2" value="${Color.color2 }" data-jscolor=""><br><br>
                    Color3: <input id="color3" name="color3" value="${Color.color3 }" data-jscolor=""><br><br>
                </div> <!-- 부트스트랩 -->
                <div class="container col-md-5">

                    <canvas id="myChart"></canvas>
                </div> <!-- 부트스트랩 -->
                <div class="col-md-1"></div>
                <div class="padding20 col-md-12"></div>
                <div class="col-md-1"></div>
                <button type="submit" class="org_Btn">즉시적용</button>
            </c:forEach>
        </form>



        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
                crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
                crossorigin="anonymous"></script> <!-- 차트 -->
        <script>
            var color1 = $('input#color1').val();
            var color2 = $('input#color2').val();
            var color3 = $('input#color3').val();
            var ctx = document.getElementById('myChart');
            var myChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: ['Red', 'Blue', 'Yellow'],
                    datasets: [{
                        label: '# of Votes',
                        data: [200, 552, 302],
                        backgroundColor: [color1, color2, color3],
                        borderColor: [color1, color2, color3],
                        borderWidth: 0.5

                    }]
                },
                options: {scales: {yAxes: [{ticks: {beginAtZero: true}}]}}
            });

            $("#color1, #color2, #color3").change(function () {
                var color1 = $('input#color1').val();
                var color2 = $('input#color2').val();
                var color3 = $('input#color3').val();
                var ctx = document.getElementById('myChart');
                var myChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: ['Red', 'Blue', 'Yellow'],
                        datasets: [{
                            label: '# of Votes',
                            data: [12, 19, 3, 5, 2, 3],
                            backgroundColor: [color1, color2, color3],
                            borderColor: [color1, color2, color3],
                            borderWidth: 0.5

                        }]
                    },
                    options: {scales: {yAxes: [{ticks: {beginAtZero: true}}]}}
                });
            });
        </script>
    </div>

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
            <a>사업자등록 : 113-86-00917, 직업정보제공사업 : 서울 관악 제 2005-6호, 통신판매업 : 제 2339호, Copyright (c) (주)사람인HR. All rights
                reserved.</a><br>
        </div>
    </div>
</div>
</body>
</html>
