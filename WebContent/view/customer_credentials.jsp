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
		<h1 class="page-def">Credentials Uploads</h1>
	</div>
	<ul class="nav-show">
		<li class="main-page">Home<span class="divider">></span></li>
		<li class="">Customers<span class="divider">></span></li>
		<li class="">Register<span class="divider">></span></li>
		<li class="active">Credentials</li>
	</ul>
	<div class="main-contain-content clearfix">
		<div class="all-content">
			<div class="form-container">
				<form method="post" action="/KJJCSoft/com/kjjcsoft/controllers/registration" enctype="multipart/form-data">
					<label for="upload_photo">Upload Photo:</label>
					<input type="file" name="upload_photo" />
					<c:if test="${!empty requestScope.errorp}">
						<c:out value="${requestScope.errorp}" />
						<c:remove var="errorp" scope="request" />
					</c:if>
					<label for="upload_fingerprints">Upload Finger Prints:</label>
					<input type="file" name="upload_fingerprints" />
					<c:if test="${!empty requestScope.errorfp}">
						<c:out value="${requestScope.errorfp }" />
						<c:remove var="errorfp" scope="request" />
					</c:if>
					<input type="submit" value="Upload" name="uploadFiles" />
				</form>
			</div>
		</div>
	</div>
</div>
</div>
</body>
</html>