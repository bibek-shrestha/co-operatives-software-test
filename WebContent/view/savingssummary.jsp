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
		<h1 class="page-def">Summary</h1>
	</div>
	<ul class="nav-show">
		<li class="main-page">Home<span class="divider">></span></li>
		<li class="">Accounts<span class="divider">></span></li>
		<li class="">Savings<span class="divider">></span></li>
		<li class="active">Summary</li>
	</ul>
	<div class="main-contain-content clearfix">
		<ul class="saving-accounts-navigation manage-customer-navigation">
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/savingdetails">Summary</a></li>
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/dailysaving">Daily Savings</a></li>
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/monthlysaving">Monthly Savings</a></li>
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/fixeddeposit">Fixed Deposits</a></li>
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/cfixeddeposit">Continuous Fixed Deposit</a></li>
		</ul>
		<div class="all-content">
			<div class="account-stats account-information">
				<p>Overview Data</p>
				<div class="account-stats-display">
					<div class="overview-circle">
						<div class="circle-num"><c:out value="${requestScope.summaryData[0]}" />
</div>						Total daily saving accounts opened.
					</div>
					<div class="overview-circle">
						<div class="circle-num"><c:out value="${requestScope.summaryData[1]}" />
</div>						Active daily saving accounts.
					</div>
					<div class="overview-circle">
						<div class="circle-num"><c:out value="${requestScope.summaryData[2]}" />
</div>						Inactive daily saving accounts.
					</div>
					<div class="overview-circle">
						<div class="circle-num"><c:out value="${requestScope.summaryData[3]}" /></div>						Total monthly saving accounts opened.
					</div>
					<div class="overview-circle">
						<div class="circle-num"><c:out value="${requestScope.summaryData[4]}" /></div>						Active monthly saving accounts.
					</div>
					<div class="overview-circle">
						<div class="circle-num"><c:out value="${requestScope.summaryData[5]}" /></div>						Inactive monthly saving accounts.
					</div>
					<div class="overview-circle">
						<div class="circle-num"><c:out value="${requestScope.summaryData[6]}" /></div>						Total fixed deposit accounts opened.
					</div>
					<div class="overview-circle">
						<div class="circle-num"><c:out value="${requestScope.summaryData[7]}" /></div>						Active fixed deposit accounts.
					</div>
					<div class="overview-circle">
						<div class="circle-num"><c:out value="${requestScope.summaryData[8]}" /></div>						Inactive fixed deposit accounts.
					</div>
					<div class="overview-circle">
						<div class="circle-num"><c:out value="${requestScope.summaryData[9]}" /></div>						Total continuous fixed deposit accounts opened.
					</div>
					<div class="overview-circle">
						<div class="circle-num"><c:out value="${requestScope.summaryData[10]}" /></div>
						Active continuous fixed deposit.
					</div>
					<div class="overview-circle">
						<div class="circle-num"><c:out value="${requestScope.summaryData[11]}" /></div>
						Inactive continuous fixed deposit.
					</div>
					<div class="overview-circle">
						<div class="circle-num"><c:out value="${requestScope.summaryData[12]}" /></div>
						Total accounts opened.
					</div>
					<div class="overview-circle">
						<div class="circle-num"><c:out value="${requestScope.summaryData[13]}" /></div>
						Active accounts.
					</div>
					<div class="overview-circle">
						<div class="circle-num"><c:out value="${requestScope.summaryData[14]}" /></div>
						Inactive accounts.
					</div>
				</div>
				<c:remove var="overview" scope="request" />
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</div>
</body>
</html>