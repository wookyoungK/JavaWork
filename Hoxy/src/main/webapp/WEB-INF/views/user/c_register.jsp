<%--
  Created by IntelliJ IDEA.
  User: yjiwo
  Date: 2020-07-23
  Time: 오후 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>Title</title>
</head>
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
        overflow: auto;
        background:#FFF;
    }



    /************ Start Form Container **************/

    .top-buttons {
        position: relative;
        display: block;
        width: 100%;
        height: 9%;
        padding: 25px;
        text-align: right;
    }

    .form{
        width: 100%;
        height: 85%;
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
        margin-bottom: 20px;
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
    .arrow{
        margin: 35px;
        color: #fff;
        font-size: 40px;
    }
</style>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
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

        </div>

        <div class="form form-signup">
            <form method="post">
                <lable>아이디</lable>
                <input type="text" id="c_id" name="c_id" placeholder="ID">
                <div class="check_font" id="id_check"></div>

                <lable>비밀번호</lable>
                <input type="password" id="c_pw" name="c_pw" placeholder="password">
                <div class="check_font" id="pw_check"></div>

                <lable>비밀번호 확인</lable>
                <input type="password" id="u_pw2" name="u_pw2" placeholder="Confirm Password">
                <div class="check_font" id="pw2_check"></div>

                <lable>회사 이름</lable>
                <input type="text"  id="c_name" name="c_name" placeholder="name">

                <lable>CEO 이름</lable>
                <input type="text" id="c_ceoName" name="c_ceoName" placeholder="name">
                <div class="check_font" id="name_check"></div>

                <lable>우편번호</lable>
                <input type="text" id="c_postNum" name="c_postNum" placeholder="postNum">

                <lable>기본주소</lable>
                <input type="text" id="c_address1" name="c_address1" placeholder="address1">

                <label>상세주소</label>
                <input type="text" id="c_address2" name="c_address2" placeholder="address2">

                <lable>사업자 번호</lable>
                <input type="text" id="c_cnum" name="c_cnum" placeholder="cnum">

                <lable>기업형태</lable>
                <input type="text" id="c_form" name="c_form" placeholder="form">

                <lable>사원수</lable>
                <input type="text" id="c_employees" name="c_employees" placeholder="employees">

                <lable>기업분류</lable>
                <input type="text" id="c_category" name="c_category" placeholder="category">

                <input type="submit" id="reg_submit" class="form-btn" value="Sign Up"/>

                <br><br>
            </form>
        </div>
    </div>
    <div class="clear-fix"></div>
</div>
</body>
<script>
        //모든 공백 체크 정규식
        var empJ = /\s/g;
        //아이디 정규식
        var idJ = /^[a-z0-9]{4,12}$/;
        // 비밀번호 정규식
        var pwJ = /^[A-Za-z0-9]{4,12}$/;
        // 이름 정규식
        var nameJ = /^[가-힣]{2,6}$/;
        // 이메일 검사 정규식
        var mailJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
        // 휴대폰 번호 정규식
        var phoneJ = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;

        //비밀번호 유효성 체크
        $('#c_pw').blur(function () {
        if(pwJ.test($('#c_pw').val())){
        console.log('true');
        $('#pw_check').text('');
    }else{
        console.log('false');
        $('#pw_check').text('숫자 or 문자로만 4~12자리');
        $('#pw_check').css('color', 'red');
    }
    });

        $('#c_pw2').blur(function () {
        if($('#c_pw').val() != $(this).val()){
        $('#pw2_check').text('비밀번호 불일치');
        $('#pw2_check').css('color', 'red');
    }else{
        $('#pw2_check').text('');
    }
    });

        // 이름에 특수문자 들어가지 않도록 설정
        $("#c_ceoName").blur(function() {
        if (nameJ.test($(this).val())) {
        console.log(nameJ.test($(this).val()));
        $("#name_check").text('');
    } else {
        $('#name_check').text('이름을 확인해주세요');
        $('#name_check').css('color', 'red');
    }
    });

        // 아이디 유효성 검사(1 = 중복 / 0 != 중복)
        $("#c_id").blur(function() {
        // id = "id_reg" / name = "userId"
        var u_id = $('#c_id').val();
        $.ajax({
        url : '${pageContext.request.contextPath}/user/cidCheck?c_id='+ c_id,
        type : 'get',
        success : function(data) {
        console.log("1 = 중복o / 0 = 중복x : "+ data);

        if (data == 1) {
        // 1 : 아이디가 중복되는 문구
        $("#id_check").text("사용중인 아이디입니다 :p");
        $("#id_check").css("color", "red");
        $("#reg_submit").attr("disabled", true);
    } else {

        if(idJ.test(c_id)){
        // 0 : 아이디 길이 / 문자열 검사
        $("#id_check").text("");
        $("#reg_submit").attr("disabled", false);

    } else if(c_id == ""){

        $('#id_check').text('아이디를 입력해주세요 :)');
        $('#id_check').css('color', 'red');
        $("#reg_submit").attr("disabled", true);

    } else {
        $('#id_check').text("아이디는 소문자와 숫자 4~12자리만 가능합니다 :) :)");
        $('#id_check').css('color', 'red');
        $("#reg_submit").attr("disabled", true);
    }

    }
    }, error : function() {
        console.log("실패");
    }
    });
    });

        // 가입하기 실행 버튼 유효성 검사!
        var inval_Arr = new Array(5).fill(false);
        $('#reg_submit').click(function(){
        // 비밀번호가 같은 경우 && 비밀번호 정규식
        if (($('#c_pw').val() == ($('#c_pw2').val()))
        && pwJ.test($('#c_pw').val())) {
        inval_Arr[0] = true;
    } else {
        inval_Arr[0] = false;
    }
        // 이름 정규식
        if (nameJ.test($('#c_ceoName').val())) {
        inval_Arr[1] = true;
    } else {
        inval_Arr[1] = false;
    }

    });
</script>
</html>