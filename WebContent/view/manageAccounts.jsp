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
		<li class="active">Manage</li>
	</ul>
	<div class="main-contain-content clearfix">
		<div class="main-content-container-search">
			<div class="search-bar">
				<form action="/KJJCSoft/com/kjjcsoft/controllers/manageaccount" method="post">
					<select name="accountType">
						<optgroup label="Saving">
							<option value="ds">Daily Saving</option>
							<option value="ms">Monthly Saving</option>
							<option value="fds">Fixed Deposit</option>
							<option value="cfd">Continuous Fixed Deposit</option>
						</optgroup>
					</select>
					<input type="text" name="query_string" />
					<input type="submit" value="Search" name="search">
				</form>
			</div>
		</div>
		<div class="all-content">
		<c:if test="${successMsg == true }">
			Account information edited successfully.
		</c:if>
			<c:choose>
				<c:when test="${!empty list}">
					<table>
						<c:choose>
							<c:when test="${acType == 'ds'}">
								<tr>
									<th>Account ID</th>
									<th>Customer Name</th>
									<th>Interest Rate</th>
									<th>Created On</th>
									<th>Approved by</th>
									<th>Entry By</th>
									<th>Status</th>
									<th>Change Status</th>
									<th>Edit</th>
								</tr>
								<c:forEach items="${list}" var="members">
									<tr>
										<td>${members.accountId}</td>
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
										<td>
											<form method="post" action="/KJJCSoft/com/kjjcsoft/controllers/manageaccount">
												<input type="hidden" name="accountid" value="${members.accountId}" />
												<input type="hidden" name="accounttype" value="${acType}"/>
												<c:choose>
													<c:when test="${members.status == true }">
														<input type="submit" value="Disable" name="disable" />
													</c:when>
													<c:otherwise>
														<input type="submit" value="Enable" name="enable" />
													</c:otherwise>
												</c:choose>
											</form>
										</td>
										<td>
											<a href="/KJJCSoft/com/kjjcsoft/controllers/manageaccount?accountid=${members.accountId}&edit=true&ac=ds"> Edit</a>
										</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:when test="${acType == 'ms'}">
								<tr>
									<th>Account ID</th>
									<th>Customer Name</th>
									<th>Interest Rate</th>
									<th>Created On</th>
									<th>Approved by</th>
									<th>Entry By</th>
									<th>Status</th>
									<th>Change Status</th>
									<th>Edit</th>
								</tr>
								<c:forEach items="${list}" var="members">
									<tr>
										<td>${members.accountId}</td>
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
										<td>
											<form method="post" action="/KJJCSoft/com/kjjcsoft/controllers/manageaccount">
												<input type="hidden" name="accountid" value="${members.accountId}" />
												<input type="hidden" name="accounttype" value="${acType}"/>
												<c:choose>
													<c:when test="${members.status == true }">
														<input type="submit" value="Disable" name="disable" />
													</c:when>
													<c:otherwise>
														<input type="submit" value="Enable" name="enable" />
													</c:otherwise>
												</c:choose>
											</form>
										</td>
										<td>
											<a href="/KJJCSoft/com/kjjcsoft/controllers/manageaccount?accountid=${members.accountId}&edit=true&ac=ms"> Edit</a>
										</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:when test="${acType == 'fds'}">
								<tr>
									<th>Account ID</th>
									<th>Customer Name</th>
									<th>Interest Rate</th>
									<th>Deposit Amount</th>
									<th>Maturity Date</th>
									<th>Created On</th>
									<th>Approved by</th>
									<th>Entry By</th>
									<th>Status</th>
									<th>Change Status</th>
									<th>Edit</th>
								</tr>
								<c:forEach items="${list}" var="members">
									<tr>
										<td>${members.accountId}</td>
										<td>${members.customerName}</td>
										<td>${members.interestRate}</td>
										<td>${members.fixedDepositAmount}</td>
										<td>${members.maturityPeriod}</td>
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
										<td>
											<form method="post" action="/KJJCSoft/com/kjjcsoft/controllers/manageaccount">
												<input type="hidden" name="accountid" value="${members.accountId}" />
												<input type="hidden" name="accounttype" value="${acType}"/>
												<c:choose>
													<c:when test="${members.status == true }">
														<input type="submit" value="Disable" name="disable" />
													</c:when>
													<c:otherwise>
														<input type="submit" value="Enable" name="enable" />
													</c:otherwise>
												</c:choose>
											</form>
										</td>
										<td>
											<a href="/KJJCSoft/com/kjjcsoft/controllers/manageaccount?accountid=${members.accountId}&edit=true&ac=fds"> Edit</a>
										</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:when test="${acType == 'cfd'}">
								<tr>
									<th>Account ID</th>
									<th>Customer Name</th>
									<th>Interest Rate</th>
									<th>Maturity Date</th>
									<th>Created On</th>
									<th>Approved by</th>
									<th>Entry By</th>
									<th>Status</th>
									<th>Change Status</th>
									<th>Edit</th>
								</tr>
								<c:forEach items="${list}" var="members">
									<tr>
										<td>${members.accountId}</td>
										<td>${members.customerName}</td>
										<td>${members.interestRate}</td>
										<td>${members.maturityPeriod}</td>
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
										<td>
											<form method="post" action="/KJJCSoft/com/kjjcsoft/controllers/manageaccount">
												<input type="hidden" name="accountid" value="${members.accountId}" />
												<input type="hidden" name="accounttype" value="${acType}"/>
												<c:choose>
													<c:when test="${members.status == true }">
														<input type="submit" value="Disable" name="disable" />
													</c:when>
													<c:otherwise>
														<input type="submit" value="Enable" name="enable" />
													</c:otherwise>
												</c:choose>
											</form>
										</td>
										<td>
											<a href="/KJJCSoft/com/kjjcsoft/controllers/manageaccount?accountid=${members.accountId}&edit=true&ac=cfd"> Edit</a>
										</td>
									</tr>
								</c:forEach>
							</c:when>
						</c:choose>
					</table>
				</c:when>
				<c:otherwise>
					<c:if test="${!empty errormsgcs}">
						<c:out value="${errormsgcs}" />
					</c:if>
				</c:otherwise>
			</c:choose>
			<c:remove var="list" scope="request"/>
			<c:remove var="members" scope="page"/>
			<c:remove var="acType" scope="request"/>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</div>
</div>
</body>
</html>