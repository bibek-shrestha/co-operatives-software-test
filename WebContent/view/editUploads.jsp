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
		<h1 class="page-def">Edit</h1>
	</div>
	<ul class="nav-show">
		<li class="main-page">Home<span class="divider">></span></li>
		<li class="">Customers<span class="divider">></span></li>
		<li class="">Manage<span class="divider">></span></li>
		<li class="active">Edit</li>
	</ul>
	<div class="main-contain-content clearfix">
		<c:if test="${!empty requestScope.alertMsg}">
			<div>
				<c:out value="${alertMsg}" />
				<c:remove var="alertMsg" scope="request" />
			</div>
		</c:if>
		<ul class="manage-customer-navigation">
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/overview">Overview</a></li>
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/registration">Add</a></li>
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/edit">Edit</a></li>
		</ul>
		<div class="all-content">
			<div class="form-container">
				<form method="post" action="/KJJCSoft/com/kjjcsoft/controllers/change" enctype="multipart/form-data">
				<input type="hidden" name="customerId" value="${sessionScope.storedInfo.customerId}"/>
				<input type="hidden" name="update" value=""/>
					Current picture :
					<img src="/KJJCSoft/upload/${sessionScope.storedInfo.photoPath}" width="250px" height="300px"/>
					<input type="file" name="upload_photo"/>
					<c:if test="${!empty requestScope.errorp}">
						<c:out value="${requestScope.errorp}" />
						<c:remove var="errorp" scope="request" />
					</c:if>
					FingerPrint :
					<img src="/KJJCSoft/upload/${sessionScope.storedInfo.fingerPrintPath}" width ="300px" height="300px"/>
					<input type="file" name="upload_fingerprints"/>
					<c:if test="${!empty requestScope.errorfp}">
						<c:out value="${requestScope.errorfp }" />
						<c:remove var="errorfp" scope="request" />
					</c:if>
					<input type="submit" value="Done" name="done"/>
				</form>
			</div>
		</div>
		<jsp:include page="footer.jsp"/>
	</div>
</div>
</div>
</body>
</html>