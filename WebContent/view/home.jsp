<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="now" class="java.util.Date" />
<jsp:include page="header.jsp" />
<jsp:include page="sidebar.jsp" />
<div class="main-contain clearfix">
	<div class="main-contain-header clearfix">
		<div class="to-right">
			<ul class="stats">
				<li class="green"><i class="icon-briefcase"></i>
					<div class="details">
						<span class="big">Account Status</span>
						<span>
							<c:choose>
								<c:when test="${sessionScope.AdminLogin==true}">
							Admin
						</c:when>
								<c:otherwise>User</c:otherwise>
							</c:choose>
						</span>
					</div></li>
				<li class="orange"><i class="icon-calendar"></i>
					<div class="details">
						<span class="big">
							<fmt:formatDate type="date" value="${now}" dateStyle="long" />
						</span>
						<span>
							<fmt:formatDate type="date" value="${now}" dateStyle="long" pattern="EEEE" />
						</span>
					</div></li>
			</ul>
		</div>
		<h1 class="page-def">Dashboard</h1>
	</div>
	<ul class="nav-show">
		<li class="main-page">Home<span class="divider">></span></li>
		<li class="active">Dashboard</li>
	</ul>
	<div class="main-contain-content clearfix">
		<c:choose>
			<c:when test="${sessionScope.initLogin==true}">
				<div class="alert-info">Welcome to dashboard. You have logged in successfully</div>
				<c:remove var="initLogin" scope="session" />
			</c:when>
			<c:otherwise>
				<div class="alert-info">Welcome to dashboard.</div>
			</c:otherwise>
		</c:choose>
		<div class="all-content">
			<div class="account-information">
				<p>User Information</p>
				<div class="profile-pic">
					<img alt="User profile picture" src="/KJJCSoft/upload/${sessionScope.Userinfo.getEmployeePhotoPath()}" class="success-profile-img">
				</div>
				<div class="user-info-container">
					<table class="user-info">
						<tr>
							<th>Name</th>
							<td>
								<c:out value="${sessionScope.Userinfo.getName()}" />
							</td>
						</tr>
						<tr>
							<th>User Type</th>
							<td>
								<c:out value="${sessionScope.Userinfo.getRole()}" />
							</td>
						</tr>
						<tr>
							<th>User Status</th>
							<td>
								<c:if test="${sessionScope.Userinfo.isUser_enabled() == true }">
						Active
					</c:if>
							</td>
						</tr>
						<tr>
							<th>Last Login</th>
							<td>
								<c:choose>
									<c:when test="${empty sessionScope.Userinfo.getLastLogin()}">
										<c:out value="${sessionScope.Userinfo.getCurrentLogin()}" />
									</c:when>
									<c:otherwise>
										<c:out value="${sessionScope.Userinfo.getLastLogin()}" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<th>Current Login</th>
							<td>
								<c:out value="${sessionScope.Userinfo.getCurrentLogin()}" />
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</div>
</body>
</html>