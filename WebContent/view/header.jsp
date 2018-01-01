<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:choose>
	<c:when test="${sessionScope.loggedIn !=true }">
		<c:redirect url="../index.jsp" />
	</c:when>
</c:choose>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/KJJCSoft/view/css/style.css" type="text/css" />
<link href="/KJJCSoft/view/fonts/font-awesome/css/font-awesome.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/KJJCSoft/view/css/bootstrap.css">
<script src="/KJJCSoft/view/js/jquery-1.11.1.min.js" type="text/javascript"></script>
<title>KJJCSoft</title>
</head>
<body>
	<script type="text/javascript">
		$(function() {
			var uls = $('.sidebar-nav > ul > *').clone();
		});
	</script>
	<div class="container">
		<div class="main-header clearfix">
			<div class="soft-name f-left">KJJCSoft</div>
			<div class="soft-logo f-right">
				<a href="/KJJCSoft/view/home.jsp">
					<img alt="User profile picture" src="/KJJCSoft/upload/${sessionScope.Userinfo.getEmployeePhotoPath()}" class="home-img">
				</a>
			</div>
		</div>