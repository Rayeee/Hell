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
	
		<script type="text/javascript">
			$('body').flipLightBox()
		</script>
		<script type="text/javascript">
			$(function() {
				var filterList = {
					init : function() {
						// MixItUp plugin
						// http://mixitup.io
						$('#portfoliolist').mixitup({
							targetSelector : '.portfolio',
							filterSelector : '.filter',
							effects : ['fade'],
							easing : 'snap',
							// call the hover effect
							onMixEnd : filterList.hoverEffect()
						});
					},
					hoverEffect : function() {
						// Simple parallax effect
						$('#portfoliolist .portfolio').hover(function() {
							$(this).find('.label').stop().animate({
								bottom : 0
							}, 200, 'easeOutQuad');
							$(this).find('img').stop().animate({
								top : -30
							}, 500, 'easeOutQuad');
						}, function() {
							$(this).find('.label').stop().animate({
								bottom : -40
							}, 200, 'easeInQuad');
							$(this).find('img').stop().animate({
								top : 0
							}, 300, 'easeOutQuad');
						});

					}
				};
				filterList.init();
			});
			$(document).ready(function() {
				$("div.fancyDemo a").fancybox();
			});
		</script>
  </head>
  <div class="bg">
		<!----- start-header---->
		<div class="container">
			<div id="home" class="header wow bounceInDown" data-wow-delay="0.4s">
					<div class="top-header">
						<div class="col-xs-2 logo">
							<h1><a href="index.html">Rayee.</a></h1>
						</div>
						<!----start-top-nav---->
						  <div class="col-xs-10 top-nav">
						  <span class="menu"> </span>
							<ul>
								<li><a href="${rt}/index" class="btn1 btn4 btn-1 btn1-1b">Home</a></li>
								<li><a href="about.html" class="btn1 btn4 btn-1 btn1-1b">About</a></li>
								<li><a href="404.html" class="btn1 btn4 btn-1 btn1-1b">Services</a></li>
								<li class="active"><a href="${rt}/pictures" class="btn1 btn4 btn-1 btn1-1b">Pictures</a></li>
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
			</div>
			<!----- //End-header---->
			<div class="clearfix"> </div>
	</div>
		<!---- top-grids ---->
	   <div class="portfolio_main">
	   	  <div class="container">
						<ul id="filters" class="clearfix">
							<li>
								<span class="filter active" data-filter="film tv">All</span>
							</li>
							<li>
								<span class="filter" data-filter="film">FILM</span>
							</li>
							<li>
								<span class="filter" data-filter="tv">TV</span>
							</li>
						<!-- 	<li>
								<span class="filter" data-filter="icon app card ">Icon</span>
							</li>
							<li>
								<span class="filter" data-filter="web card icon">Web</span>
							</li> -->
						</ul>
						<div id="portfoliolist">
							<div class="portfolio film" data-cat="web">
								<div class="portfolio-wrapper">
									<div class="fancyDemo">
										<a rel="group" title="" href="${rt}/resources/images/pictures/haidao/haidao_01b.jpg"><img src="${rt}/resources/images/pictures/haidao/haidao_01.jpg" alt=""class="img-responsive"/></a>
									</div>
									<div class="label">
										<div class="label-text">
											<span class="text-category">海盗</span>
										</div>
										<div class="label-bg"></div>
									</div>
								</div>
							</div>
							<div class="portfolio film" data-cat="app">
								<div class="portfolio-wrapper">
									<div class="fancyDemo">
										<a rel="group" title="" href="${rt}/resources/images/pictures/gongfan/gongfan_01b.jpg"><img src="${rt}/resources/images/pictures/gongfan/gongfan_01.jpg" alt=""class="img-responsive"/></a>
									</div>
									<div class="label">
										<div class="label-text">
											<span class="text-category">共犯</span>
										</div>
										<div class="label-bg"></div>
									</div>
								</div>
							</div>
							<div class="portfolio film" data-cat="web">
								<div class="portfolio-wrapper">
									<div class="fancyDemo">
										<a rel="group" title="" href="${rt}/resources/images/pictures/tower/tower_01b.jpg"><img src="${rt}/resources/images/pictures/tower/tower_01.jpg" alt=""class="img-responsive"/></a>
									</div>
									<div class="label">
										<div class="label-text">
											<span class="text-category">摩天楼</span>
										</div>
										<div class="label-bg"></div>
									</div>
								</div>
							</div>
							<div class="portfolio tv" data-cat="card">
								<div class="portfolio-wrapper">
									<div class="fancyDemo">
										<a rel="group" title="" href="${rt}/resources/images/pictures/shark/shark_01b.jpg"><img src="${rt}/resources/images/pictures/shark/shark_01.jpg" alt=""class="img-responsive"/></a>
									</div>
									<div class="label">
										<div class="label-text">
											<span class="text-category">鲨鱼</span>
										</div>
										<div class="label-bg"></div>
									</div>
								</div>
							</div>
							<div class="portfolio tv" data-cat="app">
								<div class="portfolio-wrapper">
									<div class="fancyDemo">
										<a rel="group" title="" href="${rt}/resources/images/pictures/gequ/gequ_01b.jpg"><img src="${rt}/resources/images/pictures/gequ/gequ_01.jpg" alt=""class="img-responsive"/></a>
									</div>
									<div class="label">
										<div class="label-text">
											<span class="text-category">个人取向</span>
										</div>
										<div class="label-bg"></div>
									</div>
								</div>
							</div>
							<div class="portfolio tv" data-cat="card">
								<div class="portfolio-wrapper">
									<div class="fancyDemo">
										<a rel="group" title="" href="${rt}/resources/images/pictures/xiaxiang/xiaxiang_01b.jpg"><img src="${rt}/resources/images/pictures/xiaxiang/xiaxiang_01.jpg" alt=""class="img-responsive"/></a>
									</div>
									<div class="label">
										<div class="label-text">
											<span class="text-category">夏日香气</span>
										</div>
										<div class="label-bg"></div>
									</div>
								</div>
							</div>
							<div class="portfolio film" data-cat="card">
								<div class="portfolio-wrapper">
									<div class="fancyDemo">
										<a rel="group" title="" href="${rt}/resources/images/pictures/gf/gf_01b.jpg"><img src="${rt}/resources/images/pictures/gf/gf_01.jpg" alt=""class="img-responsive"/></a>
									</div>
									<div class="label">
										<div class="label-text">
											<span class="text-category">我的见鬼女友</span>
										</div>
										<div class="label-bg"></div>
									</div>
								</div>
							</div>
							<div class="portfolio film" data-cat="web">
								<div class="portfolio-wrapper">
									<div class="fancyDemo">
										<a rel="group" title="" href="${rt}/resources/images/pictures/baiyexing/baiyexing_01b.jpg"><img src="${rt}/resources/images/pictures/baiyexing/baiyexing_01.jpg" alt=""class="img-responsive"/></a>
									</div>
									<div class="label">
										<div class="label-text">
											<span class="text-category">白夜行</span>
										</div>
										<div class="label-bg"></div>
									</div>
								</div>
							</div>
							<div class="portfolio tv" data-cat="app">
								<div class="portfolio-wrapper">
									<div class="fancyDemo">
										<a rel="group" title="" href="${rt}/resources/images/pictures/juguangdeng/juguangdeng_01b.jpg"><img src="${rt}/resources/images/pictures/juguangdeng/juguangdeng_01.jpg" alt=""class="img-responsive"/></a>
									</div>
									<div class="label">
										<div class="label-text">
											<span class="text-category">聚光灯</span>
										</div>
										<div class="label-bg"></div>
									</div>
								</div>
							</div>
							<div class="portfolio tv" data-cat="card">
								<div class="portfolio-wrapper">
									<div class="fancyDemo">
										<a rel="group" title="" href="${rt}/resources/images/pictures/lianaishidai/lianaishidai_01b.jpg"><img src="${rt}/resources/images/pictures/lianaishidai/lianaishidai_01.jpg" alt=""class="img-responsive"/></a>
									</div>
									<div class="label">
										<div class="label-text">
											<span class="text-category">恋爱时代</span>
										</div>
										<div class="label-bg"></div>
									</div>
								</div>
							</div>
							<div class="portfolio film" data-cat="icon">
								<div class="portfolio-wrapper">
									<div class="fancyDemo">
										<a rel="group" title="" href="${rt}/resources/images/pictures/jiehun/jiehun_01b.jpg"><img src="${rt}/resources/images/pictures/jiehun/jiehun_01.jpg" alt=""class="img-responsive"/></a>
									</div>
									<div class="label">
										<div class="label-text">
											<span class="text-category">妻子结婚了</span>
										</div>
										<div class="label-bg"></div>
									</div>
								</div>
							</div>
							<div class="portfolio film" data-cat="web">
								<div class="portfolio-wrapper">
									<div class="fancyDemo">
										<a rel="group" title="" href="${rt}/resources/images/pictures/city/city_01b.jpg"><img src="${rt}/resources/images/pictures/city/city_01.jpg" alt=""class="img-responsive"/></a>
									</div>
									<div class="label">
										<div class="label-text">
											<span class="text-category">无防备都市</span>
										</div>
										<div class="label-bg"></div>
									</div>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
			<ul class="pagination">
			  <li><a href="#">Prev</a></li>
			  <li><a href="#">1</a></li>
			  <li><a href="#">2</a></li>
			  <li><a href="#">3</a></li>
			  <li class="cau_hide"><a href="#">4</a></li>
			  <li class="cau_hide"><a href="#">5</a></li>
			  <li class="cau_hide"><a href="#">6</a></li>
			  <li class="cau_hide"><a href="#">7</a></li>
			  <li><a href="#">Next</a></li>
			</ul>
		</div>
	  </div>
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
  <body>
  
  </body>
  