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
		<h1 class="page-def">Edit</h1>
	</div>
	<ul class="nav-show">
		<li class="main-page">Home<span class="divider">></span></li>
		<li class="">Customer<span class="divider">></span></li>
		<li class="">Manage<span class="divider">></span></li>
		<li class="active">Edit</li>
	</ul>
	<div class="main-contain-content clearfix">
	<c:if test="${sessionScope.successMsg == true }">
		Customer Information updated successfully.
		<c:remove var="successMsg" scope="session"/>
	</c:if>
		<ul class="manage-customer-navigation">
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/overview">Overview</a></li>
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/registration">Add</a></li>
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/edit">Edit</a></li>
		</ul>
		<div class="main-content-container-search">
			<div class="search-bar">
				<form action="/KJJCSoft/com/kjjcsoft/controllers/edit" method="post">
					<input type="text" name="query_string" />
					<input type="submit" value="Search" name="search">
				</form>
			</div>
		</div>
		<div class="all-content">
			<table>
				<tr>
					<th>Customer ID</th>
					<th>Customer Name</th>
					<th>Age</th>
					<th>Gender</th>
					<th>Citizenship No</th>
					<th>Address</th>
					<th>Joined Date</th>
					<th>Entry By</th>
					<th>Status</th>
					<th>Change Status</th>
					<th>Edit</th>
				</tr>
				<c:choose>
					<c:when test="${!empty requestScope.editList}">
						<c:forEach items="${editList}" var="member">
							<tr>
								<td>${member.customerId}</td>
								<td>${member.customerName}</td>
								<td>${member.customerAge}</td>
								<td>${member.gender}</td>
								<td>${member.citizenShipNo}</td>
								<td>${member.permVdcMunicipality}</td>
								<td>${member.jDate}</td>
								<td>${member.enteredBy}</td>
								<td>
									<c:choose>
										<c:when test="${member.status == true }">
									Active
								</c:when>
										<c:otherwise>
									Inactive
								</c:otherwise>
									</c:choose>
								</td>
								<td>
								<form method="post" action="/KJJCSoft/com/kjjcsoft/controllers/edit">
									<input type="hidden" name="customerid" value="${member.customerId}"/>
									<c:choose>
										<c:when test="${member.status == true }">
											<input type="submit" value="Disable" name="disable"/>
										</c:when>
										<c:otherwise>
												<input type="submit" value="Enable" name="enable"/>
										</c:otherwise>
									</c:choose>
								</form>
								</td>
								<td>
									<a href="/KJJCSoft/com/kjjcsoft/controllers/edit?customerid=${member.customerId}&edit=true"> Edit</a>
								</td>
							</tr>
						</c:forEach>
						<c:remove var="editList" scope="request"/>
					</c:when>
					<c:when test="${empty requestScope.editList and empty requestScope.errormsg}">
						<tr>
							<td colspan="10">No related customers available.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="10">
								<c:out value="${requestScope.errormsg}" />
								<c:remove var="errormsg" scope="request" />
							</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</div>
</body>
</html>