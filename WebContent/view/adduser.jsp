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
		<h1 class="page-def">Add User</h1>
	</div>
	<ul class="nav-show">
		<li class="main-page">Home<span class="divider">></span></li>
		<li class="">Users<span class="divider">></span></li>
		<li class="active">Add</li>
	</ul>
	<div class="main-contain-content clearfix">
		<c:if test="${!empty requestScope.successAdd}">
			<div class="alert-info">
				<c:out value="${requestScope.successAdd}" />
				<c:remove var="successAdd" scope="request" />
			</div>
		</c:if>
		<div class="all-content">
			<div class="add-user-form">
				<form action="/KJJCSoft/com/kjjcsoft/controllers/adduser" method="post">
				<div class="info-personal">
					<label for="username">Username</label>
					<input type="text" name="username" value="${param.username}" />
					<c:out value="${errorUname}" />
					<c:remove var="errorUname" scope="request" />
					<label for="password">Password</label>
					<input type="password" name="password" value="${param.password}" />
					<c:out value="${errorPwd}" />
					<c:remove var="errorPwd" scope="request" />
					<label for="employee_id">Employee_id</label> <select name="employee_id">
						<c:forEach items="${Empid}" var="members">
							<c:choose>
								<c:when test="${param.employee_id == members}">
									<option value="${members}" selected><c:out value="${members}" /></option>
								</c:when>
								<c:otherwise>
									<option value="${members}"><c:out value="${members}" /></option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:remove var="Empid" scope="request" />
						<c:remove var="members" scope="page" />
					</select>
					<input type="submit" value="Get info" name="check" />
					<label for="employee_name">Employee Name</label>
					<c:choose>
						<c:when test="${empty requestScope.empInfo.getEmployeeName()}">
							<input type="text" name="employee_name" value="" />
						</c:when>
						<c:otherwise>
							<input type="text" name="employee_name" value="${requestScope.empInfo.getEmployeeName()}" />
						</c:otherwise>
					</c:choose>
					<c:if test="${!empty requestScope.empInfo.getEmployeePhoto()}">
						<img src="/KJJCSoft/upload/${requestScope.empInfo.getEmployeePhoto()}" width="200px" height="200px" />
					</c:if>
					<c:remove var="empInfo" scope="request" />
					<c:out value="${errorOpps}" />
					<c:remove var="errorOpps" scope="request" />
					<label for="user_role">Role</label> <select name="user_role">
						<option value="Administrator">Admin</option>
						<option value="User">User</option>
					</select>
					<input type="submit" value="Add" name="addUser" />
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