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
		<h1 class="page-def">Add</h1>
	</div>
	<ul class="nav-show">
		<li class="main-page">Home<span class="divider">></span></li>
		<li class="">Accounts<span class="divider">></span></li>
		<li class="">Savings<span class="divider">></span></li>
		<li class="">Daily Saving<span class="divider">></span></li>
		<li class="active">Add</li>
	</ul>
	<div class="main-contain-content clearfix">
		<ul class="saving-accounts-navigation ">
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/savingdetails">Summary</a></li>
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/dailysaving">Daily Savings</a></li>
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/monthlysaving">Monthly Savings</a></li>
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/fixeddeposit">Fixed Deposits</a></li>
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/cfixeddeposit">Continuous Fixed Deposit</a></li>
		</ul>
		<div class="all-content">
			<div class="form-container">
				<c:if test="${!empty errormain}">
					<c:out value="${errormain}" />
					<c:remove var="errormain" scope="request" />
				</c:if>
				<form action="/KJJCSoft/com/kjjcsoft/controllers/opendaily" method="post">
					<label for="customer_id">Customer Id</label>
					<c:choose>
						<c:when test="${sessionScope.Id!=null }">
							<input type="text" name="customer_id" value="<c:out value="${sessionScope.Id }"/>" />
						</c:when>
						<c:otherwise>
							<input type="text" name="customer_id" value="<c:out value="${param.customer_id}"/>" />
							<c:if test="${!empty errorcid}">
								<c:out value="${errorcid}" />
								<c:remove var="errorcid" scope="request" />
							</c:if>
						</c:otherwise>
					</c:choose>
					<input type="hidden" name="account_type" value="ds" />
					<input type="submit" value="check" name="check" />
					<label for="customer_name">Customer Name</label>
					<input type="text" name="customer_name" value="<c:out value="${requestScope.cName}"/>" />
					<c:out value="${requestScope.customerError}" />
					<label for="interest_rate">Interest Rate</label>
					<input type="text" name="interest_rate" value="<c:out value="${param.interest_rate}"/>" />
					<c:if test="${!empty errorir}">
						<c:out value="${errorir}" />
						<c:remove var="errorir" scope="request" />
					</c:if>
					<label for="approved_by">Approved By</label>
					<input type="text" name="approved_by" value="<c:out value="${param.approved_by}"/>" />
					<c:if test="${!empty errorapb}">
						<c:out value="${errorapb}" />
						<c:remove var="errorapb" scope="request" />
					</c:if>
					<!-- <label for="starting_amount">Starting Amount</label>
					<input type="text" name="starting_amount" /> -->
					<input type="submit" value="Create" name="create" />
					<input type="submit" value="Cancel" name="cancel" />
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</div>
</body>
</html>