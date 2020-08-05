<%--
  Created by IntelliJ IDEA.
  User: yjiwo
  Date: 2020-08-01
  Time: 오전 10:20
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
    <title>Title</title>
</head>
<style>
    ul, li {
        margin: 0;
        padding: 0;
    }

    body {
        overflow: hidden;
        background: #ffd203;
    }

    .main-nav {
        width: 90%;
        max-width: 385px;
        margin: 0 auto;
        height: 100%;
        cursor: pointer;
    }
    .main-nav ul {
        position: absolute;
        width: 100%;
        top: 40%;
        margin: 0;
        padding: 0;
    }
    .main-nav li {
        list-style: none;
        float: left;
    }
    .main-nav a {
        display: block;
        height: 50px;
        margin: 10px;
        padding: 2px 25px;
        text-decoration: none;
        border-radius: 30px;
        line-height: 45px;
        color: #FFF;
        -webkit-transition: all 0.30s ease-in-out;
        -moz-transition: all 0.30s ease-in-out;
        -ms-transition: all 0.30s ease-in-out;
        -o-transition: all 0.30s ease-in-out;
    }

    .main-nav li:nth-child(1) a {

        border: 2px solid #fff;
    }
    .main-nav li:nth-child(1) a:hover {
        background: #fff;
        color: #d83d3d;
    }

    .main-nav li:nth-child(2) a {

        border: 2px solid #fff;
    }
    .main-nav li:nth-child(2) a:hover {
        background: #fff;
        color: #d83d3d;
    }

    .main-nav li:nth-child(3) a {

        border: 2px solid #fff;
    }
    .main-nav li:nth-child(3) a:hover {
        background: #fff;
        color: #d83d3d;
    }
    .container {
        transform: translate(-50%, -50%);
        top: 8%;
        left: 942px;
        display: block;
        position: absolute;
        max-width: 500px;
    }
    div#main_header_log {
        background-image: url(https://i.imgur.com/rt9op1w.png);
        height: 108px;
        width: 250px;
        background-size: cover;
        background-repeat: no-repeat;
        margin-top: 280px;
        margin-bottom: 20px;
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

<div class="arrow">
    <i class="fas fa-arrow-left" onclick="history.back()"></i>
</div>

<section class="container">
    <div id="main_header_log" onclick="history.back()"></div>
    <h1>
        <%--  <span class="title">This is</span>
          <span class="title">a long</span>--%>
        <%--<span class="title">일할래 Hoxy?</span>--%>
    </h1>

    <%--<div class="button">restart</div>--%>
</section>
<nav class="main-nav">
    <ul>
        <li><a class="User" href="${pageContext.request.contextPath}/user/login">User</a></li>
        <li><a class="Company" href="${pageContext.request.contextPath}/com/login">Company</a></li>
        <li><a class="Admin" href="${pageContext.request.contextPath}/admin/login">Admin</a></li>
    </ul>
</nav>
</body>
</html>