<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>구매 완료</title>
</head>
<body>
<p>결제 완료</p>
고객 아이디 : ${ticketInfo.userId } <br />
티켓 구매수 : ${ticketInfo.ticketCount } <br />
<button onclick="history.back()">돌아가기</button>
</body>
</html>

