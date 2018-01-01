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
		<h1 class="page-def">Change Password</h1>
	</div>
	<ul class="nav-show">
		<li class="main-page">Home<span class="divider">></span></li>
		<li class="">My Account<span class="divider">></span></li>
		<li class="active">Change Password</li>
	</ul>
	<div class="main-contain-content clearfix">
		<c:if test="${successMsg != null}">
			<div class="alert-info">
				<c:out value="${successMsg}" />
			</div>
		</c:if>
		<c:remove var="successMsg" scope="request" />
		<ul class="list-my-account">
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/AccountInformation">Summary</a></li>
			<li class="summary-active change"><a href="/KJJCSoft/com/kjjcsoft/controllers/ChangePassword">Change Password</a></li>
		</ul>
		<div class="all-content">
			<div class="form-wrapper form-password-change">
				<form method="post" action="/KJJCSoft/com/kjjcsoft/controllers/ChangePassword">
					<div>
						<label for="old_password">Old Password</label>
						<input type="password" name="old_password" value="" />
						<c:if test="${!empty requestScope.errorOld}">
							<div class="login-error">
								<c:out value="${requestScope.errorOld}" />
								<c:remove var="errorOld" scope="request" />
							</div>
						</c:if>
					</div>
					<div>
						<label for="new_password">New Password</label>
						<input type="password" name="new_password" />
						<c:if test="${!empty requestScope.errorNewPwd}">
							<div class="login-error">
								<c:out value="${requestScope.errorNewPwd}" />
								<c:remove var="errorNewPwd" scope="request" />
							</div>
						</c:if>
					</div>
					<div>
						<label for="repeat_password">Repeat New Password</label>
						<input type="password" name="repeat_password" />
						<c:if test="${!empty requestScope.errorRepPwd}">
							<div class="login-error">
								<c:out value="${requestScope.errorRepPwd}" />
								<c:remove var="errorRepPwd" scope="request" />
							</div>
						</c:if>
					</div>
					<div>
						<input type="submit" value="Change" />
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</div>
</body>
</html>