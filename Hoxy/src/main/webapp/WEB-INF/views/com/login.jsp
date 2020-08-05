<%--
  Created by IntelliJ IDEA.
  User: yjiwo
  Date: 2020-07-27
  Time: 오후 5:29
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
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<style>
    body {
        background: #ffd203;
    }
    .user-modal {
        position: fixed;
        top: 150px;
        left: 0;
        width: 100%;
        height: 100%;
        z-index: 3;
        overflow-y: auto;
        cursor: pointer;
    }
    .user-modal.is-visible {
        visibility: visible;
        opacity: 1;
    }
    .user-modal.is-visible .user-modal-container {
        -webkit-transform: translateY(0);
        -moz-transform: translateY(0);
        -ms-transform: translateY(0);
        -o-transform: translateY(0);
        transform: translateY(0);
    }

    .user-modal-container {
        position: relative;
        width: 90%;
        max-width: 600px;
        background: #FFF;
        margin: 3em auto 4em;
        cursor: auto;
        border-radius: 0.25em;
        -webkit-transform: translateY(-30px);
        -moz-transform: translateY(-30px);
        -ms-transform: translateY(-30px);
        -o-transform: translateY(-30px);
        transform: translateY(-30px);
        -webkit-transition-property: -webkit-transform;
        -moz-transition-property: -moz-transform;
        transition-property: transform;
        -webkit-transition-duration: 0.3s;
        -moz-transition-duration: 0.3s;
        transition-duration: 0.3s;
    }
    .form {
        padding: 1.4em;
    }
    .form .fieldset {
        position: relative;
        margin: 1.4em 0;
    }
    .form .fieldset:first-child {
        margin-top: 0;
    }
    .form .fieldset:last-child {
        margin-bottom: 0;
    }
    .form label {
        font-size: 14px;
        font-size: 0.875rem;
    }
    .form input {
        margin: 0;
        padding: 0;
        border-radius: 0.25em;
    }
    .form input.full-width {
        width: 100%;
    }
    .form input.has-padding {
        padding: 12px 20px 12px 50px;
    }
    .form input.has-border {
        border: 1px solid #d2d8d8;
        -webkit-appearance: none;
        -moz-appearance: none;
        -ms-appearance: none;
        -o-appearance: none;
        appearance: none;
    }
    .form input.has-border:focus {
        border-color: #343642;
        box-shadow: 0 0 5px rgba(52, 54, 66, 0.1);
        outline: none;
    }
    .form input.has-error {
        border: 1px solid #d76666;
    }
    .form input[type=password] {
        /* space left for the HIDE button */
        padding-right: 65px;
    }
    .form input[type=submit] {
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
    }
    .form input[type=submit]:hover {
        background: #40db40;
    }
    .form .hide-password {
        display: inline-block;
        position: absolute;
        text-decoration: none;
        right: 0;
        top: 0;
        padding: 6px 15px;
        border-left: 1px solid #d2d8d8;
        top: 50%;
        bottom: auto;
        -webkit-transform: translateY(-50%);
        -moz-transform: translateY(-50%);
        -ms-transform: translateY(-50%);
        -o-transform: translateY(-50%);
        transform: translateY(-50%);
        font-size: 14px;
        font-size: 0.875rem;
        color: #343642;
    }
    @media only screen and (min-width: 600px) {
        .form {
            padding: 2em;
        }
        .form .fieldset {
            margin: 2em 0;
        }
        .form .fieldset:first-child {
            margin-top: 0;
        }
        .form .fieldset:last-child {
            margin-bottom: 0;
        }
        .form input.has-padding {
            padding: 16px 20px 16px 50px;
        }
        .form input[type=submit] {
            padding: 16px 0;
        }
    }
    .arrow{
        margin: 35px;
        color: #fff;
        font-size: 40px;
    }
</style>
<link rel="shortcut icon" type="image/x-icon"
      href="https://i.imgur.com/8AyMFrx.png">
<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<body>
<!-- Cookie가 비어있지 않을 때 checked 속성을 줌 -->
<c:if test="${not empty cookie.user_check}">
    <c:set value="checked" var="checked"/>
</c:if>
<div class="arrow">
    <i class="fas fa-arrow-left" onclick="history.back()"></i>
</div>
<div class="user-modal">
    <div class="user-modal-container">

        <div id="login">
            <div class="form">

                <p class="fieldset">
                    <input class="full-width has-padding has-border" id="c_id" type="id" name="c_id" value="${cookie.user_check.value}" placeholder="ID">
                </p>

                <p class="fieldset">
                    <input class="full-width has-padding has-border" id="c_pw" type="password"  placeholder="Password">
                </p>

                <p class="fieldset">
                    <input type="checkbox" id="remember-me" checked>
                    <label for="remember-me">Remember me</label>
                </p>

                <p class="fieldset">
                    <input id="loginBtn" class="full-width" type="submit" value="Login">
                </p>
                <p class="fieldset">
                    <a class="full-width" href="${pageContext.request.contextPath}/user/c_register">회원가입</a>
                </p>
            </div>

            <!--<p class="form-bottom-message"><a href="#0">Forgot your password?</a></p>-->
            <!-- <a href="#0" class="close-form">Close</a> -->
        </div>
    </div>
</div>
<!-- Cookie가 비어있지 않을 때 checked 속성을 줌 -->
<!--<div class="container">
    <div class="area_inputs wow fadeIn">
        <div class="form-group">
            <label class="font-weight-bold text-white" for="c_id">아이디</label>
            <div>
                <input type="text" class="form-control" id="c_id" name="c_id" value="" placeholder="아이디">
            </div>
        </div>
        <div class="form-group">
            <label class="font-weight-bold text-white" for="c_pw">비밀번호</label>
            <div>
                <input type="password" class="form-control" id="c_pw" name="c_pw" placeholder="비밀번호">
            </div>
        </div>
        <div class="form-group">
					<span class="font-weight-bold text-white bg-dark"
                          id="spanLoginCheck"></span>
        </div>
        <div class="form-group">
            <div>
                <button id="loginBtn" type="button"	class="btn btn-primary btn-block">로그인</button>
            </div>
        </div>
        <div class="form-group">
            <a class="btn btn-deep-orange btn-block" href="/user/c_register">회원가입</a>
        </div>
    </div>
</div>
</div>-->
<script>
    // 로그인 id / pw 확인
    $('#loginBtn').click(function() {
        var id = $('#c_id').val();
        var pw = $('#c_pw').val();
        $.ajax({
            type : 'post',
            url : '/com/login',
            data : {
                c_id : id,
                c_pw : pw,
            },
            success : function(data) {
                if (data == 0) { //로그인 실패시
                    console.log(data);
                    $('#spanLoginCheck').text('로그인 정보를 정확히 입력해주세요.');
                } else { //로그인 성공시
                    console.log(data);
                    location.href = '${pageContext.request.contextPath}/companyMain';
                }
            }
        });
    });
</script>
</body>
</html>