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
		<li class="">Customers<span class="divider">></span></li>
		<li class="">Manage<span class="divider">></span></li>
		<li class="active">Add</li>
	</ul>
	<div class="main-contain-content clearfix">
		<ul class="manage-customer-navigation">
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/overview">Overview</a></li>
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/registration">Add</a></li>
			<li><a href="/KJJCSoft/com/kjjcsoft/controllers/edit">Edit</a></li>
		</ul>
		<div class="all-content">
			<form action="/KJJCSoft/com/kjjcsoft/controllers/registration" method="post">
				<div class="registration-one clearfix">
					<div class="info-personal f-left">
						<label for="fullname">Full Name</label>
						<input type="text" name="fullname" value="${param.fullname}" />
						<c:if test="${!empty requestScope.errorfn}">
							<c:out value="${requestScope.errorfn}" />
							<c:remove var="errorfn" scope="request" />
						</c:if>
						<br> <label for="age">Age</label>
						<input type="text" name="age" value="${param.age}">
						<c:if test="${!empty requestScope.errora}">
							<c:out value="${requestScope.errora}" />
							<c:remove var="errora" scope="request" />
						</c:if>
						<br> <label for="dob">Date of birth</label>
						<input type="text" name="dob" value="${param.dob}" />
						<c:if test="${!empty requestScope.errordob}">
							<c:out value="${requestScope.errordob }" />
							<c:remove var="errordob" scope="request" />
						</c:if>
						<div class="form-radio">
							<label for="gender">Gender</label>
							<input type="radio" name="gender" value="Male" checked />
							<span>Male</span>
							<input type="radio" name="gender" value="Female" />
							<span>Female</span>
							<c:if test="${!empty requestScope.errorg}">
								<c:out value="${requestScope.errorg }" />
								<c:remove var="errorg" scope="request" />
							</c:if>
						</div>
						<label for="nationality">Nationality</label>
						<input type="text" name="nationality" value="${param.nationality}" />
						<c:if test="${!empty requestScope.errorn}">
							<c:out value="${requestScope.errorn }" />
							<c:remove var="errorn" scope="request" />
						</c:if>
						<br> <label for="citizenship_no">Citizenship no.</label>
						<input type="text" name="citizenship_no" value="${param.citizenship_no}" />
						<c:if test="${!empty requestScope.errorcs}">
							<c:out value="${requestScope.errorcs }" />
							<c:remove var="errorcs" scope="request" />
						</c:if>
					</div>
					<div class="info-status f-right">
						<div class="form-radio">
							<label for="marital_status">Marital Status</label>
							<input type="radio" name="marital_status" value="Single" checked />
							<span>Single</span>
							<input type="radio" name="marital_status" value="Married" />
							<span>Married</span>
							<c:if test="${!empty requestScope.errorms}">
								<c:out value="${requestScope.errorms }" />
								<c:remove var="errorms" scope="request" />
							</c:if>
						</div>
						<label for="spouse_name">Spouse Name</label>
						<input type="text" name="spouse_name" value="${param.spouse_name}" />
						<c:if test="${!empty requestScope.errorsn}">
							<c:out value="${requestScope.errorsn }" />
							<c:remove var="errorsn" scope="request" />
						</c:if>
						<br> <label for="occupation">Occupation</label>
						<input type="text" name="occupation" value="${param.occupation}" />
						<c:if test="${!empty requestScope.erroro}">
							<c:out value="${requestScope.erroro }" />
							<c:remove var="erroro" scope="request" />
						</c:if>
						<br> <label for="cellnumber_first">Mobile</label>
						<input type="text" name="cellnumber_first" value="${param.cellnumber_first}" />
						<c:if test="${!empty requestScope.errorcn}">
							<c:out value="${requestScope.errorcn}" />
							<c:remove var="errorcn" scope="request" />
						</c:if>
						<br> <label for="cellnumber_second">Mobile</label>
						<input type="text" name="cellnumber_second" value="${param.cellnumber_second}" />
						<c:if test="${!empty requestScope.errorcs}">
							<c:out value="${requestScope.errorcs}" />
							<c:remove var="errorcs" scope="request" />
						</c:if>
						<br> <label for="landline">Phone</label>
						<input type="text" name="landline" value="${param.landline}" />
						<c:if test="${!empty requestScope.errorll}">
							<c:out value="${requestScope.errorll}" />
							<c:remove var="errorll" scope="request" />
						</c:if>
						<br> <label for="customer_email">Email</label>
						<input type="text" name="customer_email" value="${param.customer_email}" />
						<c:if test="${!empty requestScope.erroreid}">
							<c:out value="${requestScope.erroreid}" />
							<c:remove var="erroreid" scope="request" />
						</c:if>
					</div>
				</div>
				<div class="contact-address">
					<legend>Permanent Address</legend>
					<div class="address">
					<label for="perm_dist">District</label>
					<input type="text" name="perm_dist" value="${param.perm_dist}" />
					<c:if test="${!empty requestScope.errorpd}">
						<c:out value="${requestScope.errorpd }" />
						<c:remove var="errorpd" scope="request" />
					</c:if>
					</div>
					<div class="address">
					<label for="perm_vdc_mp">VDC/MP</label>
					<input type="text" name="perm_vdc_mp" value="${param.perm_vdc_mp}" />
					<c:if test="${!empty requestScope.errorpvm}">
						<c:out value="${requestScope.errorpvm }" />
						<c:remove var="errorpvm" scope="request" />
					</c:if>
					</div>
					<div class="address">
					<label for="perm_other">Other Info</label>
					<input type="text" name="perm_other" value="${param.perm_other }" />
					<c:if test="${!empty requestScope.errorpe}">
						<c:out value="${requestScope.errorpe}" />
						<c:remove var="errorpe" scope="request" />
					</c:if>
					</div>
				</div>
				<div class="contact-address">
					<legend>Temporary Address</legend>
					<div class="address">
					<label for="temp_dist">District</label>
					<input type="text" name="temp_dist" value="${param.temp_dist}" />
					<c:if test="${!empty requestScope.errortd}">
						<c:out value="${requestScope.errortd}" />
						<c:remove var="errortd" scope="request" />
					</c:if>
					</div>
					<div class="address">
					<label for="temp_vdc_mp">VDC/MP</label>
					<input type="text" name="temp_vdc_mp" value="${param.temp_vdc_mp}" />
					<c:if test="${!empty requestScope.errortvm}">
						<c:out value="${requestScope.errortvm}" />
						<c:remove var="errortvm" scope="request" />
					</c:if>
					</div>
					<div class="address">
					<label for="temp_other">Other Info</label>
					<input type="text" name="temp_other" value="${param.temp_other}" />
					<c:if test="${!empty requestScope.errorte}">
						<c:out value="${requestScope.errorte}" />
						<c:remove var="errorte" scope="request" />
					</c:if>
					</div>
				</div>
				<div class="registration-one clearfix">
					<div class="info-personal f-left">
						<label for="fathers_name">Father's Name:</label>
						<input type="text" name="fathers_name" value="${param.fathers_name}" />
						<c:if test="${!empty requestScope.errorf}">
							<c:out value="${requestScope.errorf }" />
							<c:remove var="errorf" scope="request" />
						</c:if>
						<br> <label for="grandfathers_name">Grandfather's Name</label>
						<input type="text" name="grandfathers_name" value="${param.grandfathers_name}" />
						<c:if test="${!empty requestScope.errorgfn}">
							<c:out value="${requestScope.errorgfn }" />
							<c:remove var="errorgfn" scope="request" />
						</c:if>
					</div>
					<div class="info-status f-right">
						<label for="father_in_law_name">Father-in-Law's</label>
						<input type="text" name="father_in_law_name" value="${param.father_in_law_name}" />
						<c:if test="${!empty requestScope.errorfln}">
							<c:out value="${requestScope.errorfln }" />
							<c:remove var="errorfln" scope="request" />
						</c:if>
					</div>
				</div>
				<div class="info-personal">
					<legend>Nominee</legend>
					<label for="nominee_name">Nominee's Name</label>
					<input type="text" name="nominee_name" value="${param.nominee_name}" />
					<c:if test="${!empty requestScope.errornn}">
						<c:out value="${requestScope.errornn}" />
						<c:remove var="errornn" scope="request" />
					</c:if>
					<br> <label for="nominee_relation">Relation</label>
					<input type="text" name="nominee_relation" value="${param.nominee_relation}" />
					<c:if test="${!empty requestScope.errornr}">
						<c:out value="${requestScope.errornr }" />
						<c:remove var="errornr" scope="request" />
					</c:if>
					<br> <label for="nominee_cell_first">Mobile 1:</label>
					<input type="text" name="nominee_cell_first" value="${param.nominee_cell_first}" />
					<c:if test="${!empty requestScope.errorncf}">
						<c:out value="${requestScope.errorncf }" />
						<c:remove var="errorncn" scope="request" />
					</c:if>
					<br> <label for="nominee_cell_second">Mobile 2:</label>
					<input type="text" name="nominee_cell_second" value="${param.nominee_cell_seconnd}" />
					<c:if test="${!empty requestScope.errorncs}">
						<c:out value="${requestScope.errorncs }" />
						<c:remove var="errorncs" scope="request" />
					</c:if>
					<br> <label for="nominee_landline">Landline</label>
					<input type="text" name="nominee_landline" value="${param.nominee_landline}" />
					<c:if test="${!empty requestScope.errornll}">
						<c:out value="${requestScope.errornll }" />
						<c:remove var="errornll" scope="request" />
					</c:if>
					<br> <label for="nominee_email">Email:</label>
					<input type="text" name="nominee_email" value="${param.nominee_email}" />
					<c:if test="${!empty requestScope.errorneid}">
						<c:out value="${requestScope.errorneid }" />
						<c:remove var="errorneid" scope="request" />
					</c:if>
					<fieldset>
						<legend>Permanent Address</legend>
						<label for="n_perm_dist">District</label>
						<input type="text" name="n_perm_dist" value="${param.n_perm_dist}" />
						<c:if test="${!empty requestScope.errornpd}">
							<c:out value="${requestScope.errornpd }" />
							<c:remove var="errornpd" scope="request" />
						</c:if>
						<label for="n_perm_vdc_mp">VDC/Municipality</label>
						<input type="text" name="n_perm_vdc_mp" value="${param.n_perm_vdc_mp}" />
						<c:if test="${!empty requestScope.errornpvm}">
							<c:out value="${requestScope.errornpvm }" />
							<c:remove var="errornpvm" scope="request" />
						</c:if>
						<label for="n_perm_other">Other Information</label>
						<input type="text" name="n_perm_other" value="${param.n_perm_other}" />
						<c:if test="${!empty requestScope.errornpe}">
							<c:out value="${requestScope.errornpe }" />
							<c:remove var="errornpe" scope="request" />
						</c:if>
					</fieldset>
					<fieldset>
						<legend>Temporary Address</legend>
						<label for="n_temp_dist">District</label>
						<input type="text" name="n_temp_dist" value="${param.n_temp_dist}" />
						<c:if test="${!empty requestScope.errorntd}">
							<c:out value="${requestScope.errorntd }" />
							<c:remove var="errorntd" scope="request" />
						</c:if>
						<label for="n_temp_vdc_mp">VDC/Municipality</label>
						<input type="text" name="n_temp_vdc_mp" value="${param.n_temp_vdc_mp}" />
						<c:if test="${!empty requestScope.errorntvm}">
							<c:out value="${requestScope.errorntvm }" />
							<c:remove var="errorntvm" scope="request" />
						</c:if>
						<label for="n_temp_other">Other Information</label>
						<input type="text" name="n_temp_other" value="${param.n_temp_other}" />
						<c:if test="${!empty requestScope.errornte}">
							<c:out value="${requestScope.errornte}" />
							<c:remove var="errornte" scope="request" />
						</c:if>
					</fieldset>
				</div>
				<div class="info-personal">
					<legend>For Under Age</legend>
					<label for="guardian_name">Guardian Name</label>
					<input type="text" name="guardian_name" value="${param.guardian_name}" />
					<c:if test="${!empty requestScope.errorgn}">
						<c:out value="${requestScope.errorgn }" />
						<c:remove var="errorgn" scope="request" />
					</c:if>
					<br> <label for="guardian_relation">Relation</label>
					<input type="text" name="guardian_relation" value="${param.guardian_relation}" />
					<c:if test="${!empty requestScope.errorgr}">
						<c:out value="${requestScope.errorgr }" />
						<c:remove var="errorgr" scope="request" />
					</c:if>
					<br> <label for="guardian_cell_first">Mobile 1:</label>
					<input type="text" name="guardian_cell_first" value="${param.guardian_cell_first}" />
					<c:if test="${!empty requestScope.errorgcf}">
						<c:out value="${requestScope.errorgcf }" />
						<c:remove var="errorgcf" scope="request" />
					</c:if>
					<br> <label for="guardian_cell_second">Mobile 2:</label>
					<input type="text" name="guardian_cell_second" value="${param.guardian_cell_second}" />
					<c:if test="${!empty requestScope.errorgcs}">
						<c:out value="${requestScope.errorgcs }" />
						<c:remove var="errorgcs" scope="request" />
					</c:if>
					<br> <label for="guardian_landline">Landline</label>
					<input type="text" name="guardian_landline" value="${param.guardian_landline}" />
					<c:if test="${!empty requestScope.errorgll}">
						<c:out value="${requestScope.errorgll }" />
						<c:remove var="errorgll" scope="request" />
					</c:if>
					<br> <label for="guardian_email">Email</label>
					<input type="text" name="guardian_email" value="${param.guardian_email}" />
					<c:if test="${!empty requestScope.errorgeid}">
						<c:out value="${requestScope.errorgeid }" />
						<c:remove var="errorgeid" scope="request" />
					</c:if>
					<fieldset>
						<legend>Permanent Address</legend>
						<label for="g_perm_dist">District</label>
						<input type="text" name="g_perm_dist" value="${param.g_perm_dist}" />
						<c:if test="${!empty requestScope.errorgpd}">
							<c:out value="${requestScope.errorgpd }" />
							<c:remove var="errorgpd" scope="request" />
						</c:if>
						<label for="g_perm_vdc_mp">VDC/Municipality</label>
						<input type="text" name="g_perm_vdc_mp" value="${param.g_perm_vdc_mp}" />
						<c:if test="${!empty requestScope.errorgpvm}">
							<c:out value="${requestScope.errorgpvm }" />
							<c:remove var="errorgpvm" scope="request" />
						</c:if>
						<label for="g_perm_other">Other Information</label>
						<input type="text" name="g_perm_other" value="${param.g_perm_other}" />
						<c:if test="${!empty requestScope.errorgpe}">
							<c:out value="${requestScope.errorgpe }" />
							<c:remove var="errorgpe" scope="request" />
						</c:if>
					</fieldset>
					<fieldset>
						<legend>Temporary Address</legend>
						<label for="g_temp_dist">District</label>
						<input type="text" name="g_temp_dist" value="${param.g_temp_dist}" />
						<c:if test="${!empty requestScope.errorgtd}">
							<c:out value="${requestScope.errorgtd}" />
							<c:remove var="errorgtd" scope="request" />
						</c:if>
						<label for="g_temp_vdc_mp">VDC/Municipality</label>
						<input type="text" name="g_temp_vdc_mp" value="${param.g_temp_vdc_mp}" />
						<c:if test="${!empty requestScope.errorgtvm}">
							<c:out value="${requestScope.errorgtvm }" />
							<c:remove var="errorgtvm" scope="request" />
						</c:if>
						<label for="g_temp_other">Other Information</label>
						<input type="text" name="g_temp_other" value="${param.g_temp_other }" />
						<c:if test="${!empty requestScope.errorgte}">
							<c:out value="${requestScope.errorgte }" />
							<c:remove var="errorgte" scope="request" />
						</c:if>
					</fieldset>
				</div>
				<div class="info-personal">
				<label for="creation_date">Account Creation Date</label>
				<input type="text" name="creation_date" value="${param.creation_date}" />
				<c:if test="${!empty requestScope.errorcd}">
					<c:out value="${requestScope.errorcd }" />
					<c:remove var="errorcd" scope="request" />
				</c:if>
				<br> <label for="reffered_by">Reffered By:</label>
				<input type="text" name="reffered_by" value="${param.reffered_by}" />
				<c:if test="${!empty requestScope.errorrb}">
					<c:out value="${requestScope.errorrb }" />
					<c:remove var="errorrb" scope="request" />
				</c:if>
				<label for="approved_by">Approved By:</label>
				<input type="text" name="approved_by" value="${param.approved_by}" />
				<c:if test="${!empty requestScope.errorapb}">
					<c:out value="${requestScope.errorapb }" />
					<c:remove var="errorapb" scope="request" />
				</c:if>
				<br>
				<div class="btn">
				<input type="submit" value="Save" name="normField" />
				</div>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</div>
</body>
</html>