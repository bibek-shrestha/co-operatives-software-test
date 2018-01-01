<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="sidebar f-left clearfix">
	<div class="company-logo">
		<img src="/KJJCSoft/view/images/camera-lens-logo.jpg" id="logo" />
	</div>
	<div class="sidebar-nav">
		<c:choose>
			<c:when test="${sessionScope.AdminLogin==true}">
				<ul>
					<li class="non-col-li"><a href="#" data-target=".dashboard-menu" class="nav-header collapsed" data-toggle="collapse">Dashboard</a></li>
					<li class="col-li">
						<ul class="dashboard-menu nav nav-list collapse">
							<li><a href="/KJJCSoft/view/home.jsp">Main</a></li>
							<li><a href="/KJJCSoft/com/kjjcsoft/controllers/AccountInformation">My Account</a></li>
							<li><a href="/KJJCSoft/com/kjjcsoft/controllers/users">Users</a></li>
						</ul>
					</li>
					<li class="non-col-li"><a href="#" data-target=".customer-menu" class="nav-header collapsed" data-toggle="collapse">Customer</a></li>
					<li class="col-li">
						<ul class="customer-menu nav nav-list collapse">
							<li><a href="/KJJCSoft/com/kjjcsoft/controllers/overview">Manage</a></li>
							<li><a href="/KJJCSoft/com/kjjcsoft/controllers/customers">All</a></li>
						</ul>
					</li>
					<li class="non-col-li"><a href="#" data-target=".account-menu" class="nav-header collapsed" data-toggle="collapse">Accounts</a></li>
					<li class="col-li">
						<ul class="account-menu nav nav-list collapse">
							<li><a href="/KJJCSoft/com/kjjcsoft/controllers/savingdetails">Saving</a></li>
							<li><a href="/KJJCSoft/com/kjjcsoft/controllers/manageaccount">Manage</a></li>
						</ul>
					</li>
					<li class="non-col-li"><a href="#" data-target=".transaction-menu" class="nav-header collapsed" data-toggle="collapse">Transactions</a></li>
					<li class="col-li">
						<ul class="transaction-menu nav nav-list collapse">
							<li><a href="/KJJCSoft/com/kjjcsoft/controllers/ctransaction">Collector</a></li>
							<li><a href="/KJJCSoft/com/kjjcsoft/controllers/otransaction">Office</a></li>
						</ul>
					</li>
					<li class="non-col-li"><a href="#" data-target=".report-menu" class="nav-header collapsed" data-toggle="collapse">Reports</a></li>
					<li class="col-li">
						<ul class="report-menu nav nav-list collapse">
							<li><a href="/KJJCSoft/com/kjjcsoft/controllers/EMIGenerator">EMI</a></li>
							<li><a href="/KJJCSoft/com/kjjcsoft/controllers/AccountStatement">Account Statement</a></li>
						</ul>
					</li>
				</ul>
			</c:when>
			<c:otherwise>
								<ul>
					<li class="non-col-li"><a href="#" data-target=".dashboard-menu" class="nav-header collapsed" data-toggle="collapse">Dashboard</a></li>
					<li class="col-li">
						<ul class="dashboard-menu nav nav-list collapse">
							<li><a href="/KJJCSoft/view/home.jsp">Main</a></li>
						</ul>
					</li>
					<li class="non-col-li"><a href="#" data-target=".customer-menu" class="nav-header collapsed" data-toggle="collapse">Customer</a></li>
					<li class="col-li">
						<ul class="customer-menu nav nav-list collapse">
							<li><a href="/KJJCSoft/com/kjjcsoft/controllers/overview">Manage</a></li>
							<li><a href="/KJJCSoft/com/kjjcsoft/controllers/customers">All</a></li>
						</ul>
					</li>
					<li class="non-col-li"><a href="#" data-target=".account-menu" class="nav-header collapsed" data-toggle="collapse">Accounts</a></li>
					<li class="col-li">
						<ul class="account-menu nav nav-list collapse">
							<li><a href="/KJJCSoft/com/kjjcsoft/controllers/savingdetails">Saving</a></li>
							<li><a href="/KJJCSoft/com/kjjcsoft/controllers/manageaccount">Manage</a></li>
						</ul>
					</li>
					<li class="non-col-li"><a href="#" data-target=".transaction-menu" class="nav-header collapsed" data-toggle="collapse">Transactions</a></li>
					<li class="col-li">
						<ul class="transaction-menu nav nav-list collapse">
							<li><a href="/KJJCSoft/com/kjjcsoft/controllers/ctransaction">Collector</a></li>
							<li><a href="">Office</a></li>
						</ul>
					</li>
					<li class="non-col-li"><a href="#" data-target=".report-menu" class="nav-header collapsed" data-toggle="collapse">Reports</a></li>
					<li class="col-li">
						<ul class="report-menu nav nav-list collapse">
							<li><a href="/KJJCSoft/com/kjjcsoft/controllers/EMIGenerator">EMI</a></li>
							<li><a href="/KJJCSoft/com/kjjcsoft/controllers/AccountStatement">Account Statement</a></li>
						</ul>
					</li>
				</ul>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="logout-button">
		<form action="/KJJCSoft/com/kjjcsoft/controllers/Logout" method="post">
			<div class="logout">
				<input type="Submit" value="Logout" id="logout-button" />
			</div>
		</form>
	</div>
</div>