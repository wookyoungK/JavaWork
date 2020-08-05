<%--
  Created by IntelliJ IDEA.
  User: bhd44
  Date: 2020-07-23
  Time: 오후 1:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
    <c:when test="${result == 0 }">
        <script>
            alert('지원 실패');
            history.back();
        </script>
    </c:when>
    <c:when test="${result < 0 }">
        <script>
            alert('이미 지원한 공고입니다.');
            history.back();
        </script>
    </c:when>
    <c:otherwise>
        <script>
            alert('지원 성공');
            history.back();
        </script>
    </c:otherwise>
</c:choose>