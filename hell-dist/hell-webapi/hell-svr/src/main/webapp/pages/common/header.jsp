<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("rt",path);
%>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />

<script type="text/javascript">var rt = "${root}";</script>
<script src="${rt}/resources/js/common/jquery-1.11.3.js" ></script>
<script src="${rt}/resources/js/common/jquery.mixitup.min.js" ></script>
<script src="${rt}/resources/js/common/jquery.swipebox.min.js" ></script>


<script src="${rt}/resources/js/common/owl.carousel.js"></script>
<script src="${rt}/resources/js/common/fliplightbox.min.js"></script>
<script src="${rt}/resources/js/common/jquery.easing.min.js"></script>
<script src="${rt}/resources/js/common/jquery.fancybox-1.2.1.js"></script>

<link href="${rt}/resources/css/index/animate.css" rel="stylesheet"  type="text/css" media="all"/>
<script src="${rt}/resources/js/common/jquery.corner.js"></script>
<script src="${rt}/resources/js/common/wow.min.js"></script>
<script>
	new WOW().init();
</script>
<link href="${rt}/resources/css/index/font-awesome.min.css" rel='stylesheet' type='text/css' />

<link href="${rt}/resources/css/index/jquery.fancybox.css" rel='stylesheet' type='text/css' />
<link href="${rt}/resources/css/index/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="${rt}/resources/css/index/style.css" rel='stylesheet' type='text/css' />
<link href="${rt}/resources/css/index/owl.carousel.css" rel='stylesheet' type='text/css' />

<!---- animated-css ---->
<!----webfonts--->
<link href='http://fonts.useso.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Dancing+Script:400,700' rel='stylesheet' type='text/css'>
<!---//webfonts--->
