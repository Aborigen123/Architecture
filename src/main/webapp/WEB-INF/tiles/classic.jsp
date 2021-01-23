<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1">

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
<body>
<tiles:insertAttribute name="header"/>

	<div id="content">
			<tiles:insertAttribute name="body"/>
			</div>
			
			</body>
			<tiles:insertAttribute name="footer"/>
</html>