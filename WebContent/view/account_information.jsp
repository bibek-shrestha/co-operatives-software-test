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
		<h1 class="page-def">My Account</h1>
	</div>
	<ul class="nav-show">
		<li class="main-page">Home<span class="divider">></span></li>
		<li class="active">My Account</li>
	</ul>
	<div class="main-contain-content clearfix">
		<!-- <div class="alert-info">
			</div> -->
		<ul class="list-my-account">
			<li class="summary-active"><a href="/KJJCSoft/com/kjjcsoft/controllers/AccountInformation">Summary</a></li>
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/ChangePassword">Change Password</a></li>
		</ul>
		<div class="all-content">
			<div class="account-information clearfix">
				<p>My Information</p>
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
				<div class="myLogs">
					<c:set var="counter" scope="page" value="${0}" />
					<p>My Logs</p>
					<div class="log-table-container">
						<table class="log-table">
							<tr>
								<th>S.N</th>
								<th>Login Time</th>
								<th>Logout Time</th>
							</tr>
							<c:forEach items="${mylogs}" var="members">
								<tr>
									<c:set var="counter" scope="page" value="${counter+1}" />
									<td>
										<c:out value="${counter}" />
									</td>
									<td>${members.loginTime}</td>
									<td>${members.logoutTime}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<c:remove var="counter" scope="page" />
					<c:remove var="mylogs" scope="request" />
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</div>
</body>
</html>