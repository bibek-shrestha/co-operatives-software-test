<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
						<span class="big">Account Status</span> <span> <c:choose>
								<c:when test="${sessionScope.AdminLogin==true}">
							Admin
						</c:when>
								<c:otherwise>User</c:otherwise>
							</c:choose>
						</span>
					</div></li>
				<li class="orange"><i class="icon-calendar"></i>
					<div class="details">
						<span class="big"> <fmt:formatDate type="date"
								value="${now}" dateStyle="long" />
						</span> <span> <fmt:formatDate type="date" value="${now}"
								dateStyle="long" pattern="EEEE" />
						</span>
					</div></li>
			</ul>
		</div>
		<h1 class="page-def">EMI</h1>
	</div>
	<ul class="nav-show">
		<li class="main-page">Home<span class="divider">></span></li>
		<li class="">Reports<span class="divider">></span></li>
		<li class="active">EMI</li>
	</ul>
	<div class="main-contain-content clearfix">
		<div class="all-content">
			<form action="/KJJCSoft/com/kjjcsoft/controllers/EMIGenerator" method="post">
				<label for="amount">Amount</label>
				<input type="text" name="amount" value="${param.amount}"/>
				<c:if test="${requestScope.errorAmount == true}">
					Invalid Principal Amount.
				</c:if>
				<label for="rate">Rate</label>
				<input type="text" name="rate" value="${param.rate }"/>
				<c:if test="${requestScope.errorRate == true}">
					Invalid Rate.
				</c:if>
				<label for="duration">Duration</label>
				<input type="text" name="duration" value="${param.duration}"/>
				<c:if test="${requestScope.errorDuration == true}">
					Invalid Duration.
				</c:if>
				<input type="submit" value="Generate" name="generate"/>
			</form>
			<c:if test="${!empty requestScope.list}">
				<table>
					<tr>
						<th>S.N.</th>
						<th>Date</th>
						<th>Principal</th>
						<th>Pay Amount</th>
						<th>Interest</th>
						<th>Total Payable</th>
						<th>Remaining</th>
					</tr>
					<c:set var="counter" value="0"/>
					<c:set var="totalPaidPrinciple" value="0"/>
					<c:set var="totalPaidInterest" value="0"/>
					<c:set var="totalPaidAmount" value="0"/>					
					<c:forEach items="${requestScope.list}" var="members">
						<tr>
							<td><c:out value="${counter = counter+1 }"/>
							<td>${members.date}</td>
							<td>${members.principal}</td>
							<td>${members.payablePrincipal}</td>
							<td>${members.payableInterest}</td>
							<td>${members.payableAmount}</td>
							<td>${members.remainingPrincipal}</td>
							<c:set var="totalPaidPrinciple" value="${totalPaidPrinciple+members.payablePrincipal}"/>
							<c:set var="totalPaidInterest" value="${totalPaidInterest+members.payableInterest}"/>
							<c:set var="totalPaidAmount" value="${totalPaidAmount+members.payableAmount}"/>
						</tr>
					</c:forEach>
						<tr>
							<td></td>
							<td colspan="2">Total</td>
							<td><c:out value="${totalPaidPrinciple}"/></td>
							<td><c:out value="${totalPaidInterest}"/></td>
							<td><c:out value="${totalPaidAmount}"/></td>
							<td>
						</tr>
					<c:remove var="counter"/>
					<c:remove var="totalPaidPrinciple"/>
					<c:remove var="totalPaidInterest"/>
					<c:remove var="totalPaidAmount"/>
					<c:remove var="list" scope="request"/>
					<c:remove var="members"/>
				</table>
			</c:if>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</div>
</div>
</body>
</html>