<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>用户登陆</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <jsp:include page="../common/header.jsp"/>
    <script type="text/javascript">
//        localStorage.setItem("token","123");
//        document.cookie = "username=John Doe";
    </script>
</head>

<body>
<div class="page-container">
    <h1>用户登陆</h1>
    <input type="text" name="username" id="username" class="username" placeholder="请输入您的用户名！"/>
    <input type="password" name="password" id="password" class="password" placeholder="请输入您的用户密码！"/>
    <button type="submit" class="submit_button" id="login_butt">登录</button>
</div>
</body>
</html>
