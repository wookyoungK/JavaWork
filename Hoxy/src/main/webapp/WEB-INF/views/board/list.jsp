<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="com.lec.spring.user.domain.UserDTO"%>
<%-- JSTL 버전으로 바뀌니, import 번잡함도 사라진다. JAVA 변수 선언도 사라진다. --%>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/CSS/jinyoung.css"/>

	<script src="${pageContext.request.contextPath }/JS/yj.js"></script>


	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

	<link rel="stylesheet"
		  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />

	<link rel="shortcut icon" type="image/x-icon"
		  href="https://i.imgur.com/8AyMFrx.png">
	<title>글 목록</title>
<style>

.gong {
	color:red;
	font-weight: bold;
}
</style>
</head>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$(".btnCategory").click(function(){
		location.href = "?category="+$(this).val();
	}) // p 가 클릭되면 매개변수의 함수 수행
});
</script>
<body>

<%

	int userID = 0;
	UserDTO dto;
	if(session.getAttribute("userSession") != null) {
		 dto = (UserDTO) session.getAttribute("userSession");
		 userID = dto.getU_uid();
	}


%>
<div id="main_header">
	<div class = "div_1260 row">
		<div id = "main_header_log" class="col-md-2" onclick="location.href='/'"></div>
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
						<a href="/hire/hireSearch.do">
							지역별 채용공고
						</a>
						<a href="/board/list.do">
							BLIND_BOARD
						</a>
					</li>


				</ul>
				<ul class = "col-md-5" class = "inline">
					<li>
						<a href="#"><i class="fas"></i></a>
						<%
							if(session.getAttribute("userSession") != null|| session.getAttribute("comSession") != null) {
						%>
						<a href="/logout">로그아웃</a>
						<% }else{%>
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


<c:set var="userID" value="<%=userID%>"></c:set>


      <div class="container" style="font-size: small">

		  <br><br><br>

		  <h1>BLIND BOARD

		  </h1>

		  <br>
		  <div class="wrtie_bar"></div>
		  <br><br>
		<ul class="nav nav-pills nav-fill">
					<li class="nav-item btnCategory" value="1"><a
						class="nav-link list-group-item list-group-item-action list-group-item-light"
						href="#">전체목록</a></li>
					<li class="nav-item btnCategory" value="2"><a
						class="nav-link list-group-item list-group-item-action list-group-item-light"
						href="#">기업후기</a></li>
					<li class="nav-item btnCategory" value="3"><a
						class="nav-link list-group-item list-group-item-action list-group-item-light"
						href="#">면접후기</a></li>
					<li class="nav-item btnCategory" value="4"><a
						class="nav-link list-group-item list-group-item-action list-group-item-light"
						href="#">정보공유</a></li>
					
				</ul>
		

		<table class="table border p-3">
			<tr>
				<th class="th1">N</th>
				<th class="th2">기업명</th>
				<th class="th3">제목</th>
				<th class="th4">작성자</th>
				<th class="th5">조회수</th>
				<th class="th6">등록일</th>
				<th class="th7">분류</th>
			</tr>
			
			<c:choose>
			<c:when test="${page == '1' }">	
			<c:forEach var="noti" items="${notice}" varStatus="status">
				<tr class="gong">
				<td>${noti.uid }</td>
				<td>-</td>
				<td><a class="gong" href="view.do?uid=${noti.uid }">${noti.subject }</a>
				<c:if test="${noticeRepCnt[status.index] != 0}">
				<b>[${noticeRepCnt[status.index]}]</b>
				</c:if>
				
				</td>
				
				<td>ADMIN</td>			
				<td>${noti.viewCnt }</td>
				<td>${noti.regDate }</td>
				<td>${noti.category}</td>
			</tr>
			
			</c:forEach>
			</c:when>
			<c:otherwise>
			

			
			
			</c:otherwise>
		</c:choose>
			
 
		<c:choose>
			<c:when test="${empty list || fn:length(list) == 0 }">			
			</c:when>
			<c:otherwise>
			
			<c:forEach var="dto" items="${list}" varStatus="status">
				<tr>
				<td>${dto.uid }</td>
				<td>${dto.companyName }</td>
				<td><a href="view.do?uid=${dto.uid }">${dto.subject }</a>
				<c:if test="${recnt[status.index] != 0}">
				<b>[${recnt[status.index]}]</b>
				</c:if>
				
				</td>
				
				<td>${dto.writeName }</td>			
				<td>${dto.viewCnt }</td>
				<td>${dto.regDate }</td>
				<td>${dto.category}</td>
			</tr>
			
			</c:forEach>
			
			
			</c:otherwise>
		</c:choose>
		
			

		</table>
		
		
				<div style="padding: 10px;">
				<c:if test="${cnt > 1 }">
					<jsp:include page="pagination.jsp">
						<jsp:param value="${5 }" name="writePages" />
						<jsp:param value="${cnt }" name="totalPage" />
						<jsp:param value="${page }" name="curPage" />
					</jsp:include>
				</c:if>
					<div>
						<c:if test="<%=userID != 0%>">
							<button onclick="location.href='write.do'" class="org_Btn regist_Btn">등록</button>
						</c:if>

					</div>
					<hr>

					<div style="width: 50%; margin: 0 auto; text-align: center">
						
						<form name='frm' method='get' action='list.do'
							style="display: block; margin-top: 5px;">
							<div class="input-group">
							<select name='col'
								style="width: auto; float: left; margin-bottom:5px">
								<!-- 검색 컬럼 -->
								<option value='none' selected>제목&기업명</option>
								<option value='company'>기업명</option>
								<option value='subject'>제목</option>
							</select>
							
								<input type="text" class="form-control" name='word' value=''
									placeholder="검색어를 입력하세요" aria-label="검색어를 입력하세요"
									aria-describedby="button-addon2">
								<div class="input-group-append">
									<button class="btn btn-outline-secondary" type="submit"
										id="button-addon2">검색</button>
								</div>

							</div>
						</form>
					</div>
				</div>
	  </div>
		<br>
<div class="pad20"></div>

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






</body>
</html>















