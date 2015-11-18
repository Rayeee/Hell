<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("rt",path);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆成功</title>
    <meta  http-equiv="refresh" content="3;${rt}/index">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		/* $(function(){
			$(".usernameform").submit();
		});
		function sub(){
			$(".usernameform").submit();
		} */
	</script>
  </head>
  <body>
	登陆成功！3秒后跳转至<a href="${rt}/index">首页</a>！
	<%-- 
	<form class ="usernameform" action="${rt}/index">
    	<input type="hidden" name = "userbean.username" id="userbean.username"/>
	</form> --%>
  </body>
</html>
