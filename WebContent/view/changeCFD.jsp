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
		<h1 class="page-def">Manage</h1>
	</div>
	<ul class="nav-show">
		<li class="main-page">Home<span class="divider">></span></li>
		<li class="">Account<span class="divider">></span></li>
		<li class="active">Manage<span class="divider">></span></li>
		<li class="active">Edit</li>
	</ul>
	<div class="main-contain-content clearfix">
		<div class="all-content">
			<div class="form-container">
				<c:if test="${!empty errormain}">
					<c:out value="${errormain}" />
					<c:remove var="errormain" scope="request" />
				</c:if>
				<form action="/KJJCSoft/com/kjjcsoft/controllers/changeacinfo" method="post">
					<c:choose>
						<c:when test="${!empty changeValue}">
							<label for="account_id">Account Id</label>
							<c:out value="${changeValue.accountId}" />
							<label for="customer_id">Customer Id</label>
							<input type="text" name="customer_id" value="<c:out value="${changeValue.customerId}"/>" />
							<c:if test="${!empty errorcid}">
								<c:out value="${errorcid}" />
								<c:remove var="errorcid" scope="request" />
							</c:if>
							<input type="hidden" name="account_type" value="cfd" />
							<input type="submit" value="check" name="check" />
							<label for="customer_name">Customer Name</label>
							<input type="text" name="customer_name" value="<c:out value="${changeValue.customerName}"/>" />
							<c:out value="${requestScope.customerError}" />
							<label for="interest_rate">Interest Rate</label>
							<input type="text" name="interest_rate" value="<c:out value="${changeValue.interestRate}"/>" />
							<c:if test="${!empty errorir}">
								<c:out value="${errorir}" />
								<c:remove var="errorir" scope="request" />
							</c:if>
							<label for="maturity_date">Maturity Date</label>
							<c:out value="${changeValue.maturityPeriod}"/>
							<label for="maturity_period">Maturity Period</label>
							<input type="text" name="maturity_period" value="<c:out value="${changeValue.years}"/>" />
							<c:if test="${!empty errory}">
								<c:out value="${errory}" />
								<c:remove var="errory" scope="request" />
							</c:if>
							<label for="approved_by">Approved By</label>
							<input type="text" name="approved_by" value="<c:out value="${changeValue.approvedBy}"/>" />
							<c:if test="${!empty errorapb}">
								<c:out value="${errorapb}" />
								<c:remove var="errorapb" scope="request" />
							</c:if>
						</c:when>
						<c:otherwise>
							<label for="account_id">Account Id</label>
							<c:out value="${changeValue.accountId}" />
							<label for="customer_id">Customer Id</label>
							<input type="text" name="customer_id" value="<c:out value="${param.customer_id}"/>" />
							<c:if test="${!empty errorcid}">
								<c:out value="${errorcid}" />
								<c:remove var="errorcid" scope="request" />
							</c:if>
							<input type="hidden" name="account_type" value="cfd" />
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
							<label for="maturity_date">Maturity Date</label>
							<c:out value="${changeValue.maturityPeriod}"/>
							<label for="maturity_period">Maturity Period</label>
							<input type="text" name="maturity_period" value="${param.maturity_period}" />
							<c:if test="${!empty errory}">
								<c:out value="${errory}" />
								<c:remove var="errory" scope="request" />
							</c:if>
							<label for="approved_by">Approved By</label>
							<input type="text" name="approved_by" value="<c:out value="${param.approved_by}"/>" />
							<c:if test="${!empty errorapb}">
								<c:out value="${errorapb}" />
								<c:remove var="errorapb" scope="request" />
							</c:if>
						</c:otherwise>
					</c:choose>
					<c:remove var="changeValue" scope="request" />
					<input type="submit" value="Update" name="update" />
					<input type="submit" value="Cancel" name="cancel" />
				</form>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</div>
</body>
</html>