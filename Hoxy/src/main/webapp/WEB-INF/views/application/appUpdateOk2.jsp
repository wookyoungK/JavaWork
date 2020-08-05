<%--
  Created by IntelliJ IDEA.
  User: bhd44
  Date: 2020-07-24
  Time: 오후 3:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
    <c:when test="${result == 0 }">
        <script>
            history.back();
        </script>
    </c:when>
    <c:otherwise>
        <script>
            location.href = "appcomList";
        </script>
    </c:otherwise>
</c:choose>

