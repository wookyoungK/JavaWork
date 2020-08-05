<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>MS</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.13/js/mdb.min.js"></script>
    <style>
        @import url('https://fonts.googleapis.com/css?family=Roboto:100,300,400,700');

        /************ Start Main Rules **************/
        *{
            margin: 0;
            padding: 0;
            outline: none;
            box-sizing: border-box;
            /*   font-family: 'Roboto', sans-serif; */font-family: 'Raleway', sans-serif;
        }

        body{background: #ffd203  }

        .main-box{
            position: relative;
            display: block;
            width: 58%;
            height: auto;
            margin: 50px auto;
            border-radius: 8px;
            overflow: hidden;
            background:#FFF;
        }



        /************ Start Form Container **************/

        .top-buttons {
            position: relative;
            display: block;
            width: 100%;
            height: 15%;
            padding: 25px;
            text-align: left;
        }

        .form{
            width: 100%;
            height: auto;
            padding: 10px 40px;
        }

        .form form {
            width: 100%;
            height: 100%;
        }

        .form form
        lable,
        input[type="text"],
        input[type="email"],
        input[type="password"] {
            display: block;
        }

        .form form lable {
            font-size: 16px;
            font-weight: 300;
            margin: 6px 0;
        }

        p.terms {
            color: #9E9E9E;
            margin-bottom: 60px;
        }

        .form form
        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            border: none;
            font-size: 16px;
            font-weight: 200;
            margin-bottom: 10px;
            padding: 5px 0 10px 0;
            background: transparent;
            border-bottom: 1px solid #4c5c72;
        }

        .form form input::placeholder{
            color: #cecece;
        }

        .form form a {
            color: #fff;
        }

        input.form-btn {
            color: #fff;
            font-size: 18px;
            font-weight: 300;
            padding: 12px 55px;
            margin-right: 20px;
            border: none;
            cursor: pointer;
            border-radius: 35px;
            transition: all 0.3s linear;
            background: #ffd203;
        }

        input.form-btn:hover{
            box-shadow: none
        }

        .form-signin{
            display: none;
            padding-top: 120px;
        }

        .form input[type=button] {
            padding: 16px 0;
            cursor: pointer;
            background: #ffd203;
            color: #FFF;
            font-weight: bold;
            border: none;
            -webkit-appearance: none;
            -moz-appearance: none;
            -ms-appearance: none;
            -o-appearance: none;
            appearance: none;
            -webkit-transition: all 0.30s ease-in-out;
            -moz-transition: all 0.30s ease-in-out;
            -ms-transition: all 0.30s ease-in-out;
            -o-transition: all 0.30s ease-in-out;
            width: 25%;
        }
        .arrow{
            margin: 35px;
            color: #fff;
            font-size: 40px;
        }
    </style>
</head>
<link rel="shortcut icon" type="image/x-icon"
      href="https://i.imgur.com/8AyMFrx.png">
<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<body>

<div class="arrow">
    <i class="fas fa-arrow-left" onclick="history.back()"></i>
</div>

<div class="main-box">


    <div class="">

        <div class="top-buttons">
            <h2 class = "userMyPage_title">마이페이지</h2>
        </div>

        <div class="form form-signup">
            <form id = "userMyPage_myForm" name="form1">
                <h4>아이디</h4>
                <input type = "text" name = "u_id" id = "u_id" value = "${user.u_id }" readonly>

                <h4>비밀번호</h4>
                <input type = "text" name = "u_pw" id = "userMyPage_pw" value = "**********" readonly>
                <p id = "edit_pw" class = "edit" style = "font-size : 18px;" onclick ="edit('pw')">수정하기</p>
                <p id = "errorPw" style = "display : none; margin-left : 70px; color : red; font-size : 15px; margin-bottom : 0px;"></p></td>
                <div class="check_font" id="pw_check"></div>

                <h4>이름</h4>
                <input type = "text" name = "u_name" id = "userMyPage_name" value = "${user.u_name }" readonly>
                <p id = "edit_name" class = "edit" style = "font-size : 18px;" onclick = "edit('name')">수정하기</p>
                <p id = "errorName" style = "display : none; margin-left : 70px; color : red; font-size : 15px; margin-bottom : 0px;"></p>
                <div class="check_font" id="name_check"></div>

                <h4>주민번호</h4>
                <input type = "text" name = "u_jumin" id = "u_jumin" value = "${user.u_jumin }" readonly>

                <h4>핸드폰번호</h4>
                <input type = "text" name = "u_phoneNum" id = "userMyPage_phone" value = "${user.u_phoneNum }" readonly>
                <p id = "edit_phone" class = "edit" style = "font-size : 18px;" onclick ="edit('phone')">수정하기</p>
                <p id = "errorPhone" style = "display : none; margin-left : 70px; color : red; font-size : 15px; margin-bottom : 0px;"></p>
                <div class="check_font" id="phone_check"></div>

                <h4>이메일</h4>
                <input type = "text" name = "u_email" id = "userMyPage_email" value = "${user.u_email }" readonly>
                <p id = "edit_email" class = "edit" style = "font-size : 18px;" onclick ="edit('email')">수정하기</p>
                <p id = "errorEmail" style = "display : none; margin-left : 70px; color : red; font-size : 15px; margin-bottom : 0px;"></p>
                <div class="check_font" id="email_check"></div>

                <h4>회원정보관리</h4>
                <input type="button" id="userMyPage_deleteBtn" value="탈퇴" class = "userMyPage_deleteBtn">

                <!-- 삭제 모달창 -->
                <div id = "userMyPage_deleteModal" class = "userMyPage_deleteModal">
                    <div class = "userMyPage_deleteDiv"><p>정말 탈퇴하시겠습니까?</p>
                        <input type = "button" id = "userMyPage_deleteOkBtn" class = "userMyPage_deleteOkBtn" value = "탈퇴하기">
                        <input type = "button" id = "userMyPage_deleteCancelBtn" class = "userMyPage_deleteCancelBtn" value = "취소하기">
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="clear-fix"></div>
</div>


<!--<div class="container">
    <h1 class = "userMyPage_title">마이 페이지</h1>
    <hr>
    <div class ="userMyPage_userInfo">
        <form id = "userMyPage_myForm" name="form1">
            <table class ="userMyPage_userTable">
                <tr id = "userMyPage_userIdTr">
                    <th>회원아이디</th>
                    <td><input type = "text" name = "u_id" id = "u_id" value = "" readonly></td>
                </tr>
                <tr>
                    <th>이름</th>
                    <td><input type = "text" name = "u_name" id = "userMyPage_name" value = "" readonly>
                        <p id = "edit_name" class = "edit" style = "float : right; font-size : 18px; margin-top : 10px; margin-right : 30px;" onclick = "edit('name')">수정하기</p>
                        <p id = "errorName" style = "display : none; margin-left : 70px; color : red; font-size : 15px; margin-bottom : 0px;"></p></td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td><input type = "text" name = "u_pw" id = "userMyPage_pw" value = "**********" readonly>
                        <p id = "edit_pw" class = "edit" style = "float : right; font-size : 18px; margin-top : 10px; margin-right : 30px;" onclick ="edit('pw')">수정하기</p>
                        <p id = "errorPw" style = "display : none; margin-left : 70px; color : red; font-size : 15px; margin-bottom : 0px;"></p></td>
                </tr>
                <tr>
                    <th>핸드폰번호</th>
                    <td><input type = "text" name = "u_phoneNum" id = "userMyPage_phone" value = "" readonly>
                        <p id = "edit_phone" class = "edit" style = "float : right; font-size : 18px; margin-top : 10px; margin-right : 30px;" onclick ="edit('phone')">수정하기</p>
                        <p id = "errorPhone" style = "display : none; margin-left : 70px; color : red; font-size : 15px; margin-bottom : 0px;"></p></td>
                </tr>
                <tr>
                    <th>주민번호</th>
                    <td><input type = "text" name = "u_jumin" id = "u_jumin" value = "" readonly>
                </tr>
                <tr>
                    <th>회원이메일</th>
                    <td><input type = "text" name = "u_email" id = "userMyPage_email" value = "" readonly>
                        <p id = "edit_email" class = "edit" style = "float : right; font-size : 18px; margin-top : 10px; margin-right : 30px;" onclick ="edit('email')">수정하기</p>
                        <p id = "errorEmail" style = "display : none; margin-left : 70px; color : red; font-size : 15px; margin-bottom : 0px;"></p></td>
                </tr>
                <tr>
                    <th>회원정보관리</th>
                    <td class = "userMyPage_btnTd"><input type="button" id="userMyPage_deleteBtn" value="탈퇴" class = "userMyPage_deleteBtn"></td>
                </tr>
            </table>
        </form>
    </div>-->


    <!-- 삭제 모달창 -->
    <!--<div id = "userMyPage_deleteModal" class = "userMyPage_deleteModal">
        <div class = "userMyPage_deleteDiv"><p>정말 탈퇴하시겠습니까?</p>
            <input type = "button" id = "userMyPage_deleteOkBtn" class = "userMyPage_deleteOkBtn" value = "탈퇴하기">
            <input type = "button" id = "userMyPage_deleteCancelBtn" class = "userMyPage_deleteCancelBtn" value = "취소하기">
        </div>
    </div>

</div>-->
</body>
<script>
    $(document).ready(function(){
        $('#userMyPage_mainModal').hide(); // 시작시 수정모달창을 가림
        $('#userMyPage_deleteModal').hide(); // 시작시 삭제모달창 가림
    });

    var u_id = "${userSession.u_id}";

    ///////////// 수정버튼을 눌렀을 경우 //////////////
    function edit(e){ //수정하기 버튼을 눌렀을 경우
        console.log(e);
        if(e == "name"){
            $('#userMyPage_' + e).val("");
        }else{
            $('#userMyPage_' + e).focus();
            $('#userMyPage_' + e).css("border","1px solid #ffc107")
            $('#userMyPage_' + e).attr("readonly", false);
            $('#edit_' + e).text("수정완료").attr("id", "edit_" + e + "Ok").attr("onclick", "editOk(" + "'" + e + "'" + ")");
        }
        if(e == "pw"){
            $('#userMyPage_' + e).val("");
        }else{
            $('#userMyPage_' + e).focus();
            $('#userMyPage_' + e).css("border","1px solid #ffc107").attr("readonly", false);
            $('#edit_' + e).text("수정완료").attr("id", "edit_" + e + "Ok").attr("onclick", "editOk(" + "'" + e + "'" + ")");
        }
        if(e == "phone"){
            $('#userMyPage_' + e).val("");
        }else{
            $('#userMyPage_' + e).focus();
            $('#userMyPage_' + e).css("border","1px solid #ffc107").attr("readonly", false);
            $('#edit_' + e).text("수정완료").attr("id", "edit_" + e + "Ok").attr("onclick", "editOk(" + "'" + e + "'" + ")");
        }
        if(e == "email"){
            $('#userMyPage_' + e).val("");
        }else{
            $('#userMyPage_' + e).focus();
            $('#userMyPage_' + e).css("border","1px solid #ffc107").attr("readonly", false);
            $('#edit_' + e).text("수정완료").attr("id", "edit_" + e + "Ok").attr("onclick", "editOk(" + "'" + e + "'" + ")");
        }
    }
    // 유효성검사 정규식
    var nameP =  /^[0-9a-zA-Z가-힣]{2,20}$/;
    var phoneP = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;
    var emailP = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    var birthP = /^[0-9]{8}$/;
    var pwJ = /^[A-Za-z0-9]{4,12}$/;

    ///////////수정확인 버튼을 눌렀을 경우/////////////
    function editOk(e){
        if(e == "name"){
            if(nameP.test($('#userMyPage_name').val())){
                $('#errorName').css("display","none");
                editFinish(e);
            } else{
                console.log(($('#userMyPage_name').val()));
                $('#errorName').show().html("한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)");
                $('#errorName').show().html("한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)");
            }
        } else if (e == "phone"){
            if(phoneP.test($('#userMyPage_phone').val())){
                $('#errorPhone').css("display","none");
                editFinish(e);
            } else {
                $('#errorPhone').show().html("형식에맞지 않는 번호입니다.");
            }
        } else if (e == "email"){
            if(emailP.test($('#userMyPage_email').val())){
                $('#errorEmail').css("display","none");
                editFinish(e);
            } else {
                $('#errorEmail').show().html("이메일 주소를 다시 확인해주세요.");
            }
        } else if(e == "pw"){
            if(pwJ.test($('#userMyPage_pw').val())){
                $('#errorPw').css("display","none");
               editFinish(e);
            }else{
                $('#errorPw').show().html("비밀번호를 확인해주세여");
            }
        }
    }
    ////////// 수정에서 유효성검사를 통과했을경우 메서드 ///////////
    function editFinish(e){
        $.ajax({
            url : '${pageContext.request.contextPath}' + '/user/userEdit' + e + '',
            type : 'post',
            data : $('#userMyPage_myForm').serialize(),
            success : function(data){
                alert("수정을 완료했습니다.");
                $('#userMyPage_' + e).css("border","none");
                $('#userMyPage_' + e).css("border-bottom","1px solid #4c5c72").attr("readonly", true);
                $('#edit_' + e + 'Ok').text("수정하기").attr("id", "edit_" + e ).attr("onclick", "edit(" + "'" + e + "'" + ")");
            }
        });
    }

    //////////삭제버튼 클릭시 삭제확인 모달창이 뜸///////////
    $('#userMyPage_deleteBtn').click(function(){
        $('#userMyPage_deleteModal').show();
    });

    /////////모달창에서 삭제확인버튼클릭시 로그인페이지로 이동////////
    $('#userMyPage_deleteOkBtn').click(function(){
        $.ajax({
            url : '${pageContext.request.contextPath}' + '/user/userDelete',
            type : 'post',
            data : $('#userMyPage_myForm').serialize(),
            success : function(data){
                alert("탈퇴처리 되었습니다.");
                location.href = '${pageContext.request.contextPath}/user/login'
            }
        });
        $('#userMyPage_mainModal').hide();
    });

    /////////모달창에서 취소버튼 클릭시 다시 마이페이지이동//////////
    $('#userMyPage_deleteCancelBtn').click(function(){

        $('#userMyPage_deleteModal').hide();

    });

    //////////모달창 밖의 영역을 누르면 띄워져 있는 모달창을 닫음//////////
    $(window).on('click', function() {
        //jquery는 dom 객체를 jquery 객체로 한 번 감싸 리턴하므로 dom 객체를 얻어와야 비교 가능
        if (event.target == $('#userMyPage_mainModal').get(0)) {
            $('#userMyPage_mainModal').hide();
        }
    });
    $(window).on('click', function() {
        //jquery는 dom 객체를 jquery 객체로 한 번 감싸 리턴하므로 dom 객체를 얻어와야 비교 가능
        if (event.target == $('#userMyPage_deleteModal').get(0)) {
            $('#userMyPage_deleteModal').hide();
        }
    });

    //////////닫기버튼을 누르면 수정모달창 닫음//////////
    $('#userMyPage_close').click(function(){
        $('#userMyPage_mainModal').hide();

    });
</script>
</html>