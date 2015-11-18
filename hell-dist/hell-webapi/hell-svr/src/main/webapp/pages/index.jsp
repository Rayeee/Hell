<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="/pages/common/header.jsp"%>
    <title>HOME</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">     <!-- ViewPort <meta>标记用于指定用户是否可以缩放Web页面 -->
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar()
	{ window.scrollTo(0,1); } </script>
  </head>
  
  <body>
 <div class="bg">
		<!----- start-header---->
		<div class="container">
			<div id="home" class="header">
					<div class="top-header">
						<div class="col-xs-2 logo">
							<h1><a href="index.html">Rayee.</a></h1>
						</div>
						<!----start-top-nav---->
						 <div class="col-xs-10 top-nav">
						  <span class="menu"> </span>
							<ul>
								<li class="active"><a href="${rt}/index" class="btn1 btn4 btn-1 btn1-1b">Home</a></li>
								<li><a href="about.html" class="btn1 btn4 btn-1 btn1-1b">About</a></li>
								<li><a href="404.html" class="btn1 btn4 btn-1 btn1-1b">Services</a></li>
								<li><a href="${rt}/pictures" class="btn1 btn4 btn-1 btn1-1b">Pictures</a></li>
								<li><a href="contact.html" class="btn1 btn4 btn-1 btn1-1b">contact</a></li>
							</ul>
				<!-- script-nav -->
			<script>
			$("span.menu").click(function(){
				$(".top-nav ul").slideToggle(500, function(){
				});
			});
			</script>
			<!-- //script-nav -->
              </div>		
			 <div class="clearfix"> </div>
			</div>
			</div>
			<!----- //End-header---->
			<!---- banner-info ---->
			<div class="banner-info">
				
					<h2 class="wow fadeIn" data-wow-delay="0.5s"><span>we are</span><br /><label>Welcome to ...</label></h2>
				<div class="top-banner-grids wow bounceInUp" data-wow-delay="0.4s">
					<div class="banner-grid text-center">
						<span class="top-icon1"> </span>
						<h3>Lorem ipsum </h3>
					</div>
					<div class="banner-grid banner-grid-active text-center">
						<span class="top-icon2"> </span>
						<h3>deleniti atque</h3>
					</div>
					<div class="banner-grid text-center">
						<span class="top-icon3"> </span>
						<h3>dislike men</h3>
					</div>
					
					<div class="clearfix"> </div>
				</div>
			   </div>
			</div>
			<div class="clearfix"> </div>
		</div>
	 </div>
			<!---- banner-info ---->
			<!---- top-grids ---->
			<div class="top-grids text-center">
				<div class="container">
					<div class="col-md-3 wow bounceIn" data-wow-delay="0.4s">
						<div class="top-grid">
							<h3><a href="#"></a></h3>
							<label> </label>
							<p></p>
							<div class="btn-align"><a href="#" title="+" class="btn btn-inverse btn-normal btn-primary " target="_self"> </a></div>
						</div>
					</div>
					<div class="col-md-3 wow bounceIn" data-wow-delay="0.4s">
						<div class="top-grid">
							<h3><a href="#">adaptive style</a></h3>
							<label> </label>
							<p>This is Photoshop's version  of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin,</p>
							<div class="btn-align"><a href="#" title="+" class="btn btn-inverse btn-normal btn-primary " target="_self"> </a></div>
						</div>
					</div>
					<div class="col-md-3 wow bounceIn" data-wow-delay="0.4s">
						<div class="top-grid">
						    <h3><a href="#">money making</a></h3>
							<label> </label>
							<p>This is Photoshop's version  of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin,</p>
							<div class="btn-align"><a href="#" title="+" class="btn btn-inverse btn-normal btn-primary " target="_self"> </a></div>
						</div>
					</div>
					<div class="col-md-3 wow bounceIn" data-wow-delay="0.4s">
						<div class="top-grid">
						    <h3><a href="#">brand keaping</a></h3>
							<label> </label>
							<p>This is Photoshop's version  of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin,</p>
							<div class="btn-align"><a href="#" title="+" class="btn btn-inverse btn-normal btn-primary " target="_self"> </a></div>
						</div>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
			<!---- top-grids ---->
			<!---- about ---->
			<div id="about">
				<div class="head-section">
					<div class="container">
						<h3><span>about</span><label>us .</label></h3>
					</div>
				</div>
					<!--- about-grids ---->
					<div class="about-grids">
						<div class="col-md-4 about-grid about-grid1 wow fadeInLeft" data-wow-delay="0.4s">
							<div class="about-grid-info">
								<h4><a href="#">this is a point about the company</a></h4>
								<p>This is Photoshop's version  of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. Morbi accumsan ipsum velit. Nam nec tellus a odio tincidunt auctor a ornare odio. Sed </p>
							</div>
							<div class="about-grid-pic">
							<img src="${rt}/resources/images/space/space_01.jpg" title="name" />
							</div>
						</div>
						<div class="col-md-4 about-grid about-grid2 wow fadeInUp" data-wow-delay="0.4s">
							<div class="about-grid-pic">
							<img src="${rt}/resources/images/space/space_02.jpg" title="name" />
							</div>
							<div class="about-grid-info">
								<h4><a href="#">this is a point about the company</a></h4>
								<p>This is Photoshop's version  of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. Morbi accumsan ipsum velit. Nam nec tellus a odio tincidunt auctor a ornare odio. Sed </p>
							</div>
						</div>
						<div class="col-md-4 about-grid about-grid1 wow fadeInRight" data-wow-delay="0.4s">
							<div class="about-grid-info">
								<h4><a href="#">this is a point about the company</a></h4>
								<p>This is Photoshop's version  of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. Morbi accumsan ipsum velit. Nam nec tellus a odio tincidunt auctor a ornare odio. Sed </p>
							</div>
							<div class="about-grid-pic">
							<img src="${rt}/resources/images/space/space_03.jpg" title="name" />
							</div>
						</div>
						<div class="clearfix"> </div>
					</div>
					<!--- /about-grids ---->
				</div>
			</div>
			<!---- about ----> 
			<!--- process --->
			<!---- Team ----->
			<div id="team">
				<div class="head-section">
					<div class="container">
						<h3><span>우리</span><label>손예진.</label></h3>
					</div>
				</div>
				<!----sreen-gallery-cursual---->
						<div class="sreen-gallery-cursual">
							 <!-- requried-jsfiles-for owl -->
							        <script>
							    $(document).ready(function() {
							      $("#owl-demo").owlCarousel({
							        items : 3,
							        lazyLoad : true,
							        autoPlay : true,
							        navigation : true,
							        navigationText :  false,
							        pagination : false,
							      });
							    });
							    </script>
							 <!-- //requried-jsfiles-for owl -->
							 <!-- start content_slider -->
						       <div id="owl-demo" class="owl-carousel text-center">
					                <div class="item wow zoomIn" data-wow-delay="0.3s">
					                	<img class="lazyOwl" data-src="${rt}/resources/images/pictures/sunyizhen/yizhen_01.jpg" alt="name">
					                	<h5><span>Ipsum</span> Lorem</h5>
					                	<label>Injected</label>
					                </div>
					                <div class="item wow zoomIn" data-wow-delay="0.3s">
					                	<img class="lazyOwl" data-src="${rt}/resources/images/pictures/sunyizhen/yizhen_02.jpg" alt="name">
					                	<h5><span>Internet</span> Sydney</h5>
					                	<label> standard</label>
					                </div>
					                <div class="item wow zoomIn" data-wow-delay="0.3s">
					                	<img class="lazyOwl" data-src="${rt}/resources/images/pictures/sunyizhen/yizhen_03.jpg" alt="name">
					                	<h5><span>repetition </span> small</h5>
					                	<label>Ut enim</label>
					                </div>
					                <div class="item wow zoomIn" data-wow-delay="0.3s">
					                	<img class="lazyOwl" data-src="${rt}/resources/images/pictures/sunyizhen/yizhen_04.jpg" alt="name">
					                	<h5><span>Peter</span> Holmes</h5>
					                	<label>suffered</label>
					                </div>
					                <div class="item wow zoomIn" data-wow-delay="0.3s">
					                	<img class="lazyOwl" data-src="${rt}/resources/images/pictures/sunyizhen/yizhen_05.jpg" alt="name">
					                	<h5><span>Kenny</span> Johns</h5>
					                	<label>generator</label>
					                </div>
					                <div class="item wow zoomIn" data-wow-delay="0.3s">
					                	<img class="lazyOwl" data-src="${rt}/resources/images/pictures/sunyizhen/yizhen_06.jpg" alt="name">
					                	<h5><span>Trisha </span> Steplton</h5>
					                	<label>humour</label>
					                </div>
				              </div>
						<!--//sreen-gallery-cursual---->
				</div>
			</div>
			<!---- Team ----->
			<!---- map ---->
			<div id="contact" class="map">
				<div class="contact-info text-center wow fadeInLeft" data-wow-delay="0.3s">
					<h4><span>Rayee</span>ZGY</h4>
					<p><span class="map-icon1"> </span>2015/6/5</p>
					<p><span class="map-icon2"> </span><a href="">××××××@163.com</a></p>
					<p><span class="map-icon3"> </span>139××××××××</p>
				</div>
			</div>
			<!---- map ---->
			<div class="clearfix"> </div>
			<!---- footer --->
			<div class="footer text-center">
				<div class="container">
					<div class="copy">
		              <p>Copyright &copy; 2015.Rayee All rights reserved.<a target="_blank" href="#">Rayee</a></p>
		            </div>
				</div>
			</div>
			<!---- footer --->
  </body>
</html>
