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
		<h1 class="page-def">Users</h1>
	</div>
	<ul class="nav-show">
		<li class="main-page">Home<span class="divider">></span></li>
		<li class="active">Users</li>
	</ul>
	<div class="main-contain-content clearfix">
		<div class="main-content-container-search">
			<div class="search-bar">
				<form action="/KJJCSoft/com/kjjcsoft/controllers/usersearch" method="post">
					<input type="text" name="query_word" />
					<input type="submit" value="Search" name="search" />
				</form>
			</div>
			<a href="/KJJCSoft/com/kjjcsoft/controllers/adduser">Add</a>
		</div>
		<div class="all-content">
			<div class="user-container">
				<p>Users</p>
				<div class="user-table-container">
					<table class="user-table">
						<tr>
							<th>S.N</th>
							<th>Username</th>
							<th>Employee Name</th>
							<th>Role</th>
							<th>Status</th>
							<th>Action</th>
						</tr>
						<tr>
							<c:set var="counter" value="${0}" scope="page" />
							<c:forEach items="${userlist}" var="members">
								<c:set var="counter" value="${counter+1}" />
								<tr>
									<td>
										<c:out value="${counter}" />
									</td>
									<td>
										<c:out value="${members.user_name}" />
									</td>
									<td>
										<c:out value="${members.name}" />
									</td>
									<td>
										<c:out value="${members.role}" />
									</td>
									<td>
										<c:choose>
											<c:when test="${members.user_enabled == true}">
										Active
									</c:when>
											<c:otherwise>
										Inactive
									</c:otherwise>
										</c:choose>
									</td>
									<td>
										<form action="/KJJCSoft/com/kjjcsoft/controllers/users" method="post">
											<input type="hidden" name="userId" value="${members.user_id}" />
											<c:choose>
												<c:when test="${members.user_enabled == true}">
													<input type="submit" value="Deactivate" name="deactivate">
												</c:when>
												<c:otherwise>
													<input type="submit" value="Activate" name="activate">
												</c:otherwise>
											</c:choose>
										</form>
									</td>
								</tr>
							</c:forEach>
						</tr>
						<c:remove var="userlist" scope="request" />
						<c:remove var="counter" scope="page" />
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