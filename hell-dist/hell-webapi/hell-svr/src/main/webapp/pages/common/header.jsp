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
<script src="${rt}/resources/js/common/jquery-cookie-1.4.0.zip"></script>


<script src="${rt}/resources/js/common/owl.carousel.js"></script>
<script src="${rt}/resources/js/common/fliplightbox.min.js"></script>
<script src="${rt}/resources/js/common/jquery.easing.min.js"></script>
<script src="${rt}/resources/js/common/jquery.fancybox-1.2.1.js"></script>
<script src="${rt}/resources/js/common/md5.js"></script>


<script src="${rt}/resources/js/common/supersized.3.2.7.min.js"></script>
<script src="${rt}/resources/js/common/supersized-init.js"></script>
<script src="${rt}/resources/js/common/scripts.js"></script>

<link href="${rt}/resources/css/index/animate.css" rel="stylesheet"  type="text/css" media="all"/>
<script src="${rt}/resources/js/common/jquery.corner.js"></script>
<script src="${rt}/resources/js/common/wow.min.js"></script>

<!-- service functions -->
<!-- user login check -->
<script src="${rt}/resources/js/login/loginCheck.js"></script>

<script>
	new WOW().init();
</script>

<link href="${rt}/resources/css/index/font-awesome.min.css" rel='stylesheet' type='text/css' />
<link href="${rt}/resources/css/index/jquery.fancybox.css" rel='stylesheet' type='text/css' />
<link href="${rt}/resources/css/index/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="${rt}/resources/css/index/style.css" rel='stylesheet' type='text/css' />
<link href="${rt}/resources/css/index/owl.carousel.css" rel='stylesheet' type='text/css' />

<!-- login jsp css -->
<link rel="stylesheet" href="${rt}/resources/css/login/reset.css">
<link rel="stylesheet" href="${rt}/resources/css/login/supersized.css">
<link rel="stylesheet" href="${rt}/resources/css/login/style.css">

<!---- animated-css ---->
<!----webfonts--->
<link href='http://fonts.useso.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Dancing+Script:400,700' rel='stylesheet' type='text/css'>
<!---//webfonts--->
