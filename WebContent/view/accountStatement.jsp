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
		<h1 class="page-def">Account Statement</h1>
	</div>
	<ul class="nav-show">
		<li class="main-page">Home<span class="divider">></span></li>
		<li class="">Reports<span class="divider">></span></li>
		<li class="active">Account Statement</li>
	</ul>
	<div class="main-contain-content clearfix">
		<div class="all-content">
			<form action="/KJJCSoft/com/kjjcsoft/controllers/AccountStatement">
			<label for="acType">Account Type</label>
				<select name="acType">
					<option value="ds">DS</option>
					<option value="ms">MS</option>
					<option value="fds">FDS</option>
					<option value="cfd">CFD</option>
				</select>
				<label for="accountNumber">Account Number</label>
				<input type="text" name="accountNumber"/>
				<input type="submit" value="Generate" name="generate"/>
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</div>