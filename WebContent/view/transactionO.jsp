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
		<h1 class="page-def">Transactions (Office)</h1>
	</div>
	<ul class="nav-show">
		<li class="main-page">Home<span class="divider">></span></li>
		<li class="">Transactions<span class="divider">></span></li>
		<li class="active">Office</li>
	</ul>
	<div class="main-contain-content clearfix">
		<div class="all-content">
		<c:if test="${sessionScope.successMsg == true }">
			<div>
				Inserted Successfully!
				<c:remove var="successMsg" scope="session"/>
			</div>
		</c:if>
			<div class="form-container">
			<c:if test="${!empty errorGen}">
						<c:out value="${errorGen}"/>
						<c:remove var="errorGen" scope="request"/>
					</c:if>
				<form action="/KJJCSoft/com/kjjcsoft/controllers/otransaction" method="post">
					Customer ID:
					<input type="text" name="customerId" value="${param.customerId}" size="20">
					<c:if test="${!empty errorcid}">
						<c:out value="${empty errorcid}" />
						<c:remove var="errorcid" scope="request" />
					</c:if>
					<input type="submit" name="check" value="Check">
					<label for="customerName">Customer Name</label>
					<c:choose>
						<c:when test="${!empty requestScope.cName}">
							<input type="text" name="customerName" value="<c:out value="${requestScope.cName}"/>" />
						</c:when>
						<c:otherwise>
							<input type="text" name="customerName" value="${param.customerName}" />
						</c:otherwise>
					</c:choose>
					<c:if test="${!empty requestScope.customerError}">
						<c:out value="${requestScope.customerError }" />
						<c:remove var="customerError" scope="request" />
					</c:if>
					<br> Customer Account: <select name="accountType">
						<c:choose>
							<c:when test="${param.accountType == 'ds'}">
								<option value="ds" selected>DS</option>
								<option value="ms">MS</option>
								<option value="cfd">CFD</option>
							</c:when>
							<c:when test="${param.accountType == 'ms'}">
								<option value="ds">DS</option>
								<option value="ms" selected>MS</option>
								<option value="cfd">CFD</option>
							</c:when>
							<c:when test="${param.accountType == 'cfd'}">
								<option value="ds">DS</option>
								<option value="ms">MS</option>
								<option value="cfd" selected>CFD</option>
							</c:when>
							<c:otherwise>
								<option value="ds" selected>DS</option>
								<option value="ms">MS</option>
								<option value="cfd">CFD</option>
							</c:otherwise>
						</c:choose>
					</select> <br> Account ID:
					<input type="text" name="accountId" value="${param.accountId}" size="20">
					<c:if test="${!empty errorAcId}">
						<c:out value="${errorAcId}" />
						<c:remove var="errorAcId" scope="request" />
					</c:if>
					<input type="submit" name="checkagain" value="Check">
					<c:choose>
						<c:when test="${exists == true }">
							Ok.
						</c:when>
						<c:when test="${exists == false }">
							No Account found.
						</c:when>
					</c:choose>
					<br> Deposit Amount:
					<input type="text" name="depositAmount" value="${param.depositAmount}" size="20">
					<c:if test="${!empty errorDA}">
						<c:out value="${errorDA}"/>
						<c:remove var="errorDA" scope="request"/>
					</c:if>
					<br> Withdrawal Amount:
					<input type="text" name="withdrawalAmount" value="${param.withdrawalAmount}" size="20">
					<c:if test="${!empty errorWA}">
						<c:out value="${errorWA}"/>
						<c:remove var="errorWA" scope="request"/>
					</c:if>
					<br> References:
					<input type="text" name="references" value="${param.references}" size="20">
					<c:if test="${!empty errorR}">
						<c:out value="${errorR}"/>
						<c:remove var="errorR" scope="request"/>
					</c:if>
					<br>
					<input type="submit" name="save" value="Next">
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</div>
</body>
</html>