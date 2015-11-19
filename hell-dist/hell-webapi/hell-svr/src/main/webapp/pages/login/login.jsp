<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  request.setAttribute("rt",path);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <% %>
  <base href="<%=basePath%>">
  <title>用户登陆</title>

  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!--
  <link rel="stylesheet" type="text/css" href="styles.css">
  -->
  <link rel="stylesheet" href="${rt}/resources/css/login/reset.css">
  <link rel="stylesheet" href="${rt}/resources/css/login/supersized.css">
  <link rel="stylesheet" href="${rt}/resources/css/login/style.css">
  <script src="${rt}/resources/js/common/jquery-1.11.3.js" ></script>
  <script src="${rt}/resources/js/common/jquery-cookie-1.4.0.zip" ></script>
  <script src="${rt}/resources/js/common/supersized.3.2.7.min.js" ></script>
  <script src="${rt}/resources/js/common/supersized-init.js" ></script>
  <script src="${rt}/resources/js/common/scripts.js" ></script>

  <script type="text/javascript">
    <%--$.cookie("alive","on",{expires:1,path:"${rt}/pages"});--%>
    function login(){
      $(".userLogin").submit();
    }
    function check(){
      if($("#loginname").val()==""){
        alert("用户名不能为空！");
        $("#loginname").focus();
        return false;
      }
      if($("#password").val()==""){
        alert("密码不能为空");
        $("#password").focus();
        return false;
      }
      return true;
    }
  </script>
</head>

<body>
<div class="page-container">
  <h1>用户登陆</h1>
  <form class="userLogin" action="${rt}/login" method="post" onsubmit="return check();">
    <input type="text" name="username" id="username" class="username"  value="${username}" placeholder="请输入您的用户名！"/>
    <input type="password" name="password" id="password" class="password" value="${password}" placeholder="请输入您的用户密码！"/>
    <button type="submit" class="submit_button" onClick="login();">登录</button>
  </form>
</div>
</body>
</html>
