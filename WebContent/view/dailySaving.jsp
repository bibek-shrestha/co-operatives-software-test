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
		<h1 class="page-def">Daily Saving</h1>
	</div>
	<ul class="nav-show">
		<li class="main-page">Home<span class="divider">></span></li>
		<li class="">Accounts<span class="divider">></span></li>
		<li class="">Savings<span class="divider">></span></li>
		<li class="active">Daily Saving</li>
	</ul>
	<div class="main-contain-content clearfix">
		<ul class="saving-accounts-navigation manage-customer-navigation">
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/savingdetails">Summary</a></li>
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/dailysaving">Daily Savings</a></li>
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/monthlysaving">Monthly Savings</a></li>
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/fixeddeposit">Fixed Deposits</a></li>
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/cfixeddeposit">Continuous Fixed Deposit</a></li>
		</ul>
		<a href="/KJJCSoft/com/kjjcsoft/controllers/opendaily">Add</a>
		<div class="all-content">
			<div class="table-list">
				<table>
					<tr>
						<th>Account ID</th>
						<th>Customer ID</th>
						<th>Customer Name</th>
						<th>Interest Rate</th>
						<th>Created On</th>
						<th>Approved by</th>
						<th>Entry By</th>
						<th>Status</th>
					</tr>
					<c:choose>
						<c:when test="${empty list}">
							<tr>
								<td colspan="7">No accounts created yet.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach items="${list}" var="members">
								<tr>
									<td>${members.accountId}</td>
									<td>${members.customerId}</td>
									<td>${members.customerName}</td>
									<td>${members.interestRate}</td>
									<td>${members.creationDate}</td>
									<td>${members.approvedBy}</td>
									<td>${members.enteredby}</td>
									<td>
										<c:choose>
											<c:when test="${members.status == true }">
										Active
									</c:when>
											<c:otherwise>
										Inactive
									</c:otherwise>
										</c:choose>
									</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
					<c:remove var="list" scope="request"/>
					<c:remove var="members" scope="page"/>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</div>
</body>
</html>