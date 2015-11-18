<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/pages/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
    <h1>HTTP Status 403 - Access is denied</h1>

    <c:choose>
        <c:when test="${empty username}">
            <h2>You do not have permission to access this page!</h2>
        </c:when>
        <c:otherwise>
            <h2>
                Username : ${username} <br /> You do not have permission to access
                this page!
            </h2>
        </c:otherwise>
    </c:choose>

</body>
</html>