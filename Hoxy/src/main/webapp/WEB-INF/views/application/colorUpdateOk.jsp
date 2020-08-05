<%--
  Created by IntelliJ IDEA.
  User: bhd44
  Date: 2020-07-27
  Time: 오후 4:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
    <c:when test="${result == 0 }">
        <script>
            alert('수정 실패');
            history.back();
        </script>
    </c:when>
    <c:otherwise>
        <script>
            alert('수정 성공');
            location.href = "color";  <%-- 삭제후에는 list 로 가자 --%>
        </script>
    </c:otherwise>
</c:choose>


