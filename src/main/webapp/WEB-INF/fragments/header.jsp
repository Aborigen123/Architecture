<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<!-- Facebook APP ID -->
	<meta property="fb:app_id" content="12345"/>

	<meta name="keywords" content="Car-Dealer, auto-salon, automobile, business, car, car-gallery, car-selling-template, cars, dealer, marketplace, mobile, real estate, responsive, sell, vehicle" />
	<meta name="description" content="Auto Dealer HTML - Responsive HTML Auto Dealer Template" />

	<!-- Open Graph -->
	<meta property="og:site_name" content="Auto Dealer HTML"/>
	<meta property="og:title" content="Home" />
	<meta property="og:url" content="http://localhost/01_index.html" />
	<meta property="og:image" content="http://cdn.winterjuice.com/example/autodealer/image.jpg" />
	<meta property="og:description" content="Auto Dealer HTML - Responsive HTML Auto Dealer Template" />

	<!-- Page Title -->
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="/resources/css/style.css" />
	<link rel="stylesheet" type="text/css" href="/resources/css/style980.css" />
	<link rel="stylesheet" type="text/css" href="/resources/css/style800.css" />
	<link rel="stylesheet" type="text/css" href="/resources/css/style700.css" />
	<link rel="stylesheet" type="text/css" href="/resources/css/style600.css" />
	<link rel="stylesheet" type="text/css" href="/resources/css/style500.css" />
	<link rel="stylesheet" type="text/css" href="/resources/css/style400.css" />
	<link rel="stylesheet" type="text/css" href="/resources/css/jquery.fancybox-1.3.4.css" media="screen" />
	<!--[if IE]>
	<link href="css/style_ie.css" rel="stylesheet" type="text/css">
	<![endif]-->
	<script type="text/javascript" src="/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="/resources/js/jquery.easing.1.3.js"></script>
	<script type="text/javascript" src="/resources/js/jquery.bxslider.js"></script>
	<script type="text/javascript" src="/resources/js/jquery.mousewheel.js"></script>
	<script type="text/javascript" src="/resources/js/jquery.selectik.js"></script>
	<script type="text/javascript" src="/resources/js/jquery.fancybox-1.3.4.pack.js"></script>
	<script type="text/javascript" src="/resources/js/jquery.countdown.js"></script>
	<script type="text/javascript" src="/resources/js/jquery.checkbox.js"></script>
	<script type="text/javascript" src="/resources/js/js.js"></script>
</head>
<body class="page">
	<!--BEGIN HEADER-->
		<div id="header">
			<div class="top_info">
				<div class="logo">
					<a href="#">Auto<span>Dealer</span></a>
				</div>
				<div class="header_contacts">
					<div class="phone">+1 (800) 455-55-95</div>
					<div>WinterJuice, LLC, 1875 South Grant Street, Suite 680, San Mateo, CA 94402</div>
				</div>
				<div class="socials">
			 
     

			<sec:authorize access="!isAuthenticated()">
			
			
			<%--class="glyphicon glyphicon-log-in" --%>
		           <a href="${pageContext.request.contextPath}/login"  style="margin-right:40px;"  ><span   style="color:#ffffff "  >Login</span></a><br>
		         <%--class="glyphicon glyphicon-user" --%>
		          <a href="${pageContext.request.contextPath}/registration" style="margin-right:40px;"  ><span style="color:#ffffff " style='margin-right:30px'>Register</span></a><br>
		            
		     </sec:authorize>
		     
  
<a href="${pageContext.request.contextPath}/admin" style="margin-right:40px;" ><span style="color:#ffffff ">Admin</span></a>

		     
		     <sec:authorize access="isAuthenticated()">
		     		<sec:authentication property="principal.username" var="username"/>
	     		<br>	<a href="${username}" style="margin-right:40px;"><span style="color:#ffffff ">${username}</span></a>

					<c:url var="logoutUrl" value="/logout" />
					<form:form action="${logoutUrl}" method="post" cssStyle="padding-top: 7px;">
					<input class="btn btn-danger" type="submit" value="logout" />
					</form:form>
			</sec:authorize>
     
				</div>
			</div>
			<div class="bg_navigation">
				<div class="navigation_wrapper">
					<div id="navigation">
						<span>Home</span>
						<ul>
							<li class="current"><a href="#">Home</a></li>
							<li><a href="#">About Us</a></li>
							<li><a href="#">Blog</a></li>
							<li><a href="#">News</a></li>
							<li><a href="#">For Salers</a></li>
							<li><a href="#">Contacts</a></li>
						</ul>
					</div>

					<div id="search_form">
						<form  action="/search">
							<input type="text"class="txb_search" name="search"/>
							<input type="submit" class="btn_search" value="Search"/>
						</form>
					</div>
				</div>
			</div>
		</div>