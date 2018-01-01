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
		<h1 class="page-def">Success</h1>
	</div>
	<ul class="nav-show">
		<li class="main-page">Home<span class="divider">></span></li>
		<li class="">Accounts<span class="divider">></span></li>
		<li class="">Savings<span class="divider">></span></li>
		<li class="">Continuous Fixed Deposit<span class="divider">></span></li>
		<li class="active">Success</li>
	</ul>
	<div class="main-contain-content clearfix">
		<ul class="saving-accounts-navigation">
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/savingdetails">Summary</a></li>
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/dailysaving">Daily Savings</a></li>
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/monthlysaving">Monthly Savings</a></li>
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/fixeddeposit">Fixed Deposits</a></li>
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/cfixeddeposit">Continuous Fixed Deposit</a></li>
		</ul>
		<a href="/KJJCSoft/com/kjjcsoft/controllers/opendaily">Add</a>
		<div class="all-content">
			<c:choose>
				<c:when test="${sessionScope.cfdAcInfo.getAccountId()!=0 and sessionScope.cfdAcInfo.getAccountId() != null}">
	Continuous Fixed Deposit Account created successfully!
	Account number : <c:out value="${sessionScope.cfdAcInfo.getAccountId()}" />
	Account holders ID : <c:out value="${sessionScope.cfdAcInfo.getCustomerId()}" />
	Account Holder's Name: <c:out value="${sessionScope.cName}" />
					<c:remove var="cName" scope="session" />
	Interest Rate : <c:out value="${sessionScope.cfdAcInfo.getInterestRate()}" />
	Maturity Time : <c:out value="${sessionScope.cfdAcInfo.getMaturityPeriod()}" />
					<c:remove var="cfdAcInfo" scope="session" />
					<c:choose>
						<c:when test="${sessionScope.accessedFromCustomer==true}">
							<a href="/KJJCSoft/com/kjjcsoft/controllers/customers">
								<input type="button" name="" value="Ok">
							</a>
							<c:remove var="accessedFromCustomer" scope="session" />
						</c:when>
						<c:otherwise>
							<a href="/KJJCSoft/com/kjjcsoft/controllers/cfixeddeposit">
								<input type="button" name="" value="Ok">
							</a>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:when test="${sessionScope.cfdAcInfo.getAccountId()==0 or sessionScope.cfdAcInfo.getAccountId() == null }">
					<c:remove var="cfdAcInfo" scope="session" />
		Something went wrong. The account for the customer was not created. Please try again from Accounts
		<c:choose>
						<c:when test="${sessionScope.accessedFromCustomer==true}">
							<a href="/KJJCSoft/com/kjjcsoft/controllers/customers">
								<input type="button" name="" value="Ok">
							</a>
							<c:remove var="accessedFromCustomer" scope="session" />
						</c:when>
						<c:otherwise>
							<a href="/KJJCSoft/com/kjjcsoft/controllers/cfixeddeposit">
								<input type="button" name="" value="Ok">
							</a>
						</c:otherwise>
					</c:choose>
				</c:when>
			</c:choose>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</div>
</body>
</html>