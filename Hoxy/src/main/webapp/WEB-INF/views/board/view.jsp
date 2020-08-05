<%@ page import="com.lec.spring.user.domain.UserDTO" %>
<%@ page import="com.lec.spring.user.domain.AdmDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script src="${pageContext.request.contextPath }/JS/board.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>

<c:choose>
	<c:when test="${empty list || fn:length(list) == 0 }">
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
			<title>읽기${list[0].subject}</title> <!-- title에 글제목 넣기 -->
		</head>
		<script>
			function chkDelete(uid){
				// 삭제 여부, 다시 확인 하고 진행하기
				Swal.fire({
					title: '게시글을 삭제하시겠습니까?',
					text: "삭제시 복구되지 않습니다.",
					icon: 'warning',
					showCancelButton: true,
					confirmButtonColor: '#3085d6',
					cancelButtonColor: '#d33',
					confirmButtonText: 'YES'
				}).then((result) => {
					if (result.value) {
							location.href = 'deleteOk.do?uid=' + uid;

					}
				})



			}
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

		<%

			int adminID = 0;
			AdmDTO dto2;
			if(session.getAttribute("admSession") != null) {
				dto2 = (AdmDTO) session.getAttribute("admSession");
				adminID = dto2.getA_uid();
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
									if(session.getAttribute("comSession") != null|| session.getAttribute("comSession") != null) {
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

		<div class="container" >


			<br><br><br>

			<h1>BLIND BOARD

			</h1>

			<br>
			<div class="wrtie_bar"></div>
			<br><br>
			<div class="row" style="height: 30px">
				<div class="col-md-4">
					<i class="fas fa-caret-right"></i>
						${list[0].category}
		<c:if test="${list[0].category ne '공지사항'}">
					<i class="fas fa-caret-right"></i>
						${list[0].companyName}
		</c:if>
				</div>

				<div class="col-md-5"></div>
				NO:
				<div id="a" class="col-md-1">${list[0].uid}</div><br>

			</div>

			<br>
			<div class="row" style="height: 50px">
				<div class="col-md-1">

				</div>

				<div class="col-md-11">
					<h1>${list[0].subject}</h1>
				</div>



			</div>

			<div class="row" style="height: 50px">
				<div class="col-md-1" style="text-align: center">
					<i class="fas fa-user-tie"></i>
				</div>

				<div class="col-md-3">
					<c:if test="${list[0].category ne '공지사항'}">
						${list[0].writeName}<br>
					</c:if>
					<c:if test="${list[0].category eq '공지사항'}">
						ADMIN<br>
					</c:if>
						${list[0].regDate}
				</div>

				<div class="col-md-2">
					조회수 : ${list[0].viewCnt}
				</div>

				<div class="col-md-2">
					<i class="far fa-comment-dots"></i>
					<span id="replycnt"></span>
				</div>

				<div class="col-md-2">
					<button type="button" id="copy_btn" class="border_btn" style="float: right">URL 복사</button>

				</div>

				<div class="col-md-2">

					<input type="text" id="copy_text_input" value="" style="color: white; width: 10px;">
				</div>




			</div>
			<hr>

			<div class="row border" style="height: 450px; background-color: rgba(240,240,240,0.6); padding: 50px;">
				<div class="col-md-12">
						${list[0].content}
				</div>




			</div>
			<br>
			<button onclick="location.href='list.do'" class="gray_Btn">목록</button>
			<button onclick="location.href='write.do'" class="org_Btn regist_Btn">등록</button>


			<c:set var="userID" value="<%=userID%>"></c:set>
			<c:set var="adminID" value="<%=adminID%>"></c:set>

			<div id="us" style="display: none">${userID}</div>



				<c:if test="${userID == list[0].u_uid}">
				<button onclick="location.href='update.do?uid=${list[0].uid}'" class="org_Btn regist_Btn">수정</button>
				<button onclick="chkDelete(${list[0].uid})" class="org_Btn regist_Btn">삭제</button>
			</c:if>

			<c:if test="${adminID != 0}">
				<button onclick="location.href='update.do?uid=${list[0].uid}'" class="org_Btn regist_Btn">수정</button>
				<button onclick="chkDelete(${list[0].uid})" class="org_Btn regist_Btn">삭제</button>
			</c:if>
				<%--    <button onclick="location.href='update.do?uid=${list[0].uid}'">수정하기</button>--%>
				<%--	<button onclick="location.href = 'list.do'">목록보기</button>--%>
				<%--	<button onclick="chkDelete(${list[0].uid})">삭제하기</button>--%>
				<%--	<button onclick="location.href = 'write.do'">신규등록</button>--%>


		</div>

		<hr>

		<div class="container">

			<div class="row">

				<div class="col-md-12">
					<form id="frmWrite" name="frmWrite" method="post" >
						<input type="hidden" name="buid" value="${list[0].uid }">
						<input type="hidden" name="cuid" value="${userID}">
		<c:choose>
			<c:when test="${userID == 0 }">
				<textarea name="content" placeholder="로그인 후 이용해주세요" readonly = readonly style="width: 80%; height: 100px" ></textarea>
			</c:when>

			<c:otherwise>
						<textarea name="content" placeholder="댓글을 입력해주세요" style="width: 80%; height: 100px" ></textarea>

			</c:otherwise>
		</c:choose>
						<button type="submit" style="width: 15%; height: 100px; float: right" class="gray_Btn">제출</button>
					</form>
				</div>

			</div>
		</div>
		<br><br>


		<div class="container" id="ajaxin" style="margin-bottom: 30px">

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


		</body>
		</html>

	</c:otherwise>
</c:choose>

















