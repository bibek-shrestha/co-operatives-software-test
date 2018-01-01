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
		<h1 class="page-def">All Customers</h1>
	</div>
	<ul class="nav-show">
		<li class="main-page">Home<span class="divider">></span></li>
		<li class="">Customer<span class="divider">></span></li>
		<li class="active">All Customers</li>
	</ul>
	<div class="main-contain-content clearfix">
		<div class="main-content-container-search">
			<div class="search-bar">
				<form action="/KJJCSoft/com/kjjcsoft/controllers/customersearch" method="post">
					<input type="text" name="query_string" />
					<input type="submit" value="Search" name="search">
				</form>
			</div>
		</div>
		<div class="all-content">
			<div class="customer-list-container">
				<table class="customer-list">
					<tr>
						<th>Customer ID</th>
						<th>Name</th>
						<th>Age</th>
						<th>Gender</th>
						<th>CitizenShip No</th>
						<th>Address</th>
						<th>Cell Number</th>
						<th>Marital Status</th>
						<th>Occupation</th>
						<th>Father's Name</th>
						<th>Joined On</th>
						<th>Reffered By</th>
						<th>Entry By</th>
						<th>Details</th>
					</tr>
					<c:forEach items="${customerAll}" var="member">
						<tr>
							<td>${member.customerId}</td>
							<td>${member.customerName}</td>
							<td>${member.customerAge}</td>
							<td>${member.gender}</td>
							<td>${member.citizenShipNo}</td>
							<td>${member.permVdcMunicipality}</td>
							<td>${member.cellNumberFirst}</td>
							<td>${member.maritalStatus}</td>
							<td>${member.occupation}</td>
							<td>${member.fathersName}</td>
							<td>${member.jDate}</td>
							<td>${member.refferedBy}</td>
							<td>${member.enteredBy}</td>
							<td>
								<form action="/KJJCSoft/com/kjjcsoft/controllers/details" method="post" target="_blank">
									<input type="hidden" name="customerId" value="${member.customerId}" />
									<input type="submit" name="view" value="View">
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<c:remove var="customerAll" scope="request" />
	</div>
	<jsp:include page="footer.jsp" />
</div>
</div>
</body>
</html>