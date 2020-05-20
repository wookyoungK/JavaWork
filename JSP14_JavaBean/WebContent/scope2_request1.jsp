<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cnt" class="com.lec.beans.CountBean" scope="request"/>
<jsp:setProperty name="cnt" property="count"/>

<!-- cnt.setCount(Integer.parseInt(request.getParameter("count"))) -->

<h3>request1<br>cnt와 getCount호출</h3>

<jsp:getProperty name="cnt" property="count"/><br>

<!-- cnt.getCount() -->

<!-- <a href="scope2_request2.jsp">request2로... </a> -->
<!-- 이부분 이해하는것이중요 앞에 page에서는 CountBean생성이 console 에 찍히면서 계속 새로 생성되는 것이지만   -->
<!--forward 는 한 cycle로 쭉갓다가 그값을 받는다 , 다시 request 누르면 새로생성됨 ,공유하는것임!! -->
<jsp:forward page="scope2_request2.jsp"/>
