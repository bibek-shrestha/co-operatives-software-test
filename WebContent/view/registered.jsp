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
		<h1 class="page-def">Successful</h1>
	</div>
	<ul class="nav-show">
		<li class="main-page">Home<span class="divider">></span></li>
		<li class="active">Customers<span class="divider">></span></li>
		<li class="">Manage<span class="divider">></span></li>
		<li class="">Register<span class="divider">></span></li>
		<li class="">Success</li>
	</ul>
	<div class="main-contain-content clearfix">
		<br>
		<img src="<c:out value="/KJJCSoft/upload/${requestScope.newCustomer.getPhotoPath()}"/>" height="50px" width="50px" />
		Customer ID :
		<c:out value="${requestScope.newCustomer.getCustomerId()}" />
		Name :
		<c:out value="${requestScope.newCustomer.getCustomerName()}" />
		Age :
		<c:out value="${requestScope.newCustomer.getCustomerAge()}" />
		Sex :
		<c:out value="${requestScope.newCustomer.getGender()}" />
		Date of birth :
		<c:out value="${requestScope.newCustomer.getDob()}" />
		Nationality :
		<c:out value="${requestScope.newCustomer.getNationality()}" />
		Citizenship Number :
		<c:choose>
			<c:when test="${empty requestScope.newCustomer.getCitizenShipNo()}">
				<span>-</span>
			</c:when>
			<c:otherwise>
				<c:out value="${requestScope.newCustomer.getCitizenShipNo()}" />
			</c:otherwise>
		</c:choose>
		<fieldset>
			<legend>Permanent Address</legend>
			District :
			<c:out value="${requestScope.newCustomer.getPermDistrict()}" />
			Vdc/Municipality :
			<c:out value="${requestScope.newCustomer.getPermVdcMunicipality()}" />
			Other Information :
			<c:choose>
				<c:when test="${empty requestScope.newCustomer.getPermExtrainfo()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${requestScope.newCustomer.getPermExtrainfo()}" />
				</c:otherwise>
			</c:choose>
		</fieldset>
		<fieldset>
			<legend>Temporary Address</legend>
			District :
			<c:choose>
				<c:when test="${empty requestScope.newCustomer.getTempDistrict()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${requestScope.newCustomer.getTempDistrict()}" />
				</c:otherwise>
			</c:choose>
			Vdc/Municipality :
			<c:choose>
				<c:when test="${empty requestScope.newCustomer.getTempVdcMunicipality()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${requestScope.newCustomer.getTempVdcMunicipality()}" />
				</c:otherwise>
			</c:choose>
			Other Information :
			<c:choose>
				<c:when test="${empty requestScope.newCustomer.getTempExtrainfo()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${requestScope.newCustomer.getTempExtrainfo()}" />
				</c:otherwise>
			</c:choose>
		</fieldset>
		Mobile number :
		<c:choose>
			<c:when test="${empty requestScope.newCustomer.getCellNumberFirst()}">
				<span>-</span>
			</c:when>
			<c:otherwise>
				<c:out value="${requestScope.newCustomer.getCellNumberFirst()}" />
			</c:otherwise>
		</c:choose>
		Mobile number :
		<c:choose>
			<c:when test="${empty requestScope.newCustomer.getCellNumberSecond()}">
				<span>-</span>
			</c:when>
			<c:otherwise>
				<c:out value="${requestScope.newCustomer.getCellNumberSecond()}" />
			</c:otherwise>
		</c:choose>
		Landline :
		<c:choose>
			<c:when test="${empty requestScope.newCustomer.getLandLine()}">
				<span>-</span>
			</c:when>
			<c:otherwise>
				<c:out value="${requestScope.newCustomer.getLandLine()}" />
			</c:otherwise>
		</c:choose>
		Email :
		<c:choose>
			<c:when test="${empty requestScope.newCustomer.getEmailId()}">
				<span>-</span>
			</c:when>
			<c:otherwise>
				<c:out value="${requestScope.newCustomer.getEmailId()}" />
			</c:otherwise>
		</c:choose>
		Marital Status :
		<c:out value="${requestScope.newCustomer.getMaritalStatus()}" />
		Spouse Name :
		<c:choose>
			<c:when test="${empty requestScope.newCustomer.getSpouseName()}">
				<span>-</span>
			</c:when>
			<c:otherwise>
				<c:out value="${requestScope.newCustomer.getSpouseName()}" />
			</c:otherwise>
		</c:choose>
		Occupation :
		<c:out value="${requestScope.newCustomer.getOccupation()}" />
		Father's Name :
		<c:out value="${requestScope.newCustomer.getFathersName()}" />
		Grandfather's Name :
		<c:choose>
			<c:when test="${empty requestScope.newCustomer.getGrandFathersName()}">
				<span>-</span>
			</c:when>
			<c:otherwise>
				<c:out value="${requestScope.newCustomer.getGrandFathersName()}" />
			</c:otherwise>
		</c:choose>
		Father-in-law's Name :
		<c:choose>
			<c:when test="${empty requestScope.newCustomer.getFatherInLawsName()}">
				<span>-</span>
			</c:when>
			<c:otherwise>
				<c:out value="${requestScope.newCustomer.getFatherInLawsName()}" />
			</c:otherwise>
		</c:choose>
		<b>Nominee Information</b> Nominee's Name :
		<c:out value="${requestScope.newCustomer.getNomineesName()}" />
		Relation :
		<c:out value="${requestScope.newCustomer.getNomineeRelation()}" />
		<fieldset>
			<legend>Permanent Address</legend>
			District :
			<c:out value="${requestScope.newCustomer.getnPermDistrict()}" />
			Vdc/Municipality :
			<c:out value="${requestScope.newCustomer.getnPermVdcMunicipality()}" />
			Other Information :
			<c:choose>
				<c:when test="${empty requestScope.newCustomer.getnPermExtraInfo()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${requestScope.newCustomer.getnPermExtraInfo()}" />
				</c:otherwise>
			</c:choose>
		</fieldset>
		<fieldset>
			<legend>Temporary Address</legend>
			District :
			<c:choose>
				<c:when test="${empty requestScope.newCustomer.getnTempDistrict()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${requestScope.newCustomer.getnTempDistrict()}" />
				</c:otherwise>
			</c:choose>
			Vdc/Municipality :
			<c:choose>
				<c:when test="${empty requestScope.newCustomer.getnTempVdcMunicipality()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${requestScope.newCustomer.getnTempVdcMunicipality()}" />
				</c:otherwise>
			</c:choose>
			Other Information :
			<c:choose>
				<c:when test="${empty requestScope.newCustomer.getnTempExtraInfo()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${requestScope.newCustomer.getnTempExtraInfo()}" />
				</c:otherwise>
			</c:choose>
		</fieldset>
		Mobile number :
		<c:choose>
			<c:when test="${empty requestScope.newCustomer.getnCellNumberFirst()}">
				<span>-</span>
			</c:when>
			<c:otherwise>
				<c:out value="${requestScope.newCustomer.getnCellNumberFirst()}" />
			</c:otherwise>
		</c:choose>
		Mobile number :
		<c:choose>
			<c:when test="${empty requestScope.newCustomer.getnCellNumberSecond()}">
				<span>-</span>
			</c:when>
			<c:otherwise>
				<c:out value="${requestScope.newCustomer.getnCellNumberSecond()}" />
			</c:otherwise>
		</c:choose>
		Landline :
		<c:choose>
			<c:when test="${empty requestScope.newCustomer.getnLandLine()}">
				<span>-</span>
			</c:when>
			<c:otherwise>
				<c:out value="${requestScope.newCustomer.getnLandLine()}" />
			</c:otherwise>
		</c:choose>
		Email :
		<c:choose>
			<c:when test="${empty requestScope.newCustomer.getnEmailId()}">
				<span>-</span>
			</c:when>
			<c:otherwise>
				<c:out value="${requestScope.newCustomer.getnEmailId()}" />
			</c:otherwise>
		</c:choose>
		<b>Guardian Information for Underage</b> Name :
		<c:choose>
			<c:when test="${empty requestScope.newCustomer.getGuardianName()}">
				<span>-</span>
			</c:when>
			<c:otherwise>
				<c:out value="${requestScope.newCustomer.getGuardianName()}" />
			</c:otherwise>
		</c:choose>
		Relation :
		<c:choose>
			<c:when test="${empty requestScope.newCustomer.getgRelation()}">
				<span>-</span>
			</c:when>
			<c:otherwise>
				<c:out value="${requestScope.newCustomer.getgRelation()}" />
			</c:otherwise>
		</c:choose>
		<fieldset>
			<legend>Permanent Address</legend>
			District :
			<c:choose>
				<c:when test="${empty requestScope.newCustomer.getgPermDistrict()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${requestScope.newCustomer.getgPermDistrict()}" />
				</c:otherwise>
			</c:choose>
			Vdc/Municipality :
			<c:choose>
				<c:when test="${empty requestScope.newCustomer.getgPermVdcMunicipality()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${requestScope.newCustomer.getgPermVdcMunicipality()}" />
				</c:otherwise>
			</c:choose>
			Other Information :
			<c:choose>
				<c:when test="${empty requestScope.newCustomer.getgPermExtraInfo()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${requestScope.newCustomer.getgPermExtraInfo()}" />
				</c:otherwise>
			</c:choose>
		</fieldset>
		<fieldset>
			<legend>Temporary Address</legend>
			District :
			<c:choose>
				<c:when test="${empty requestScope.newCustomer.getgTempDistrict()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${requestScope.newCustomer.getgTempDistrict()}" />
				</c:otherwise>
			</c:choose>
			Vdc/Municipality :
			<c:choose>
				<c:when test="${empty requestScope.newCustomer.getgTempVdcMunicipality()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${requestScope.newCustomer.getgTempVdcMunicipality()}" />
				</c:otherwise>
			</c:choose>
			Other Information :
			<c:choose>
				<c:when test="${empty requestScope.newCustomer.getgTempExtraInfo()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${requestScope.newCustomer.getgTempExtraInfo()}" />
				</c:otherwise>
			</c:choose>
		</fieldset>
		Mobile number :
		<c:choose>
			<c:when test="${empty requestScope.newCustomer.getgCellNumberFirst()}">
				<span>-</span>
			</c:when>
			<c:otherwise>
				<c:out value="${requestScope.newCustomer.getgCellNumberFirst()}" />
			</c:otherwise>
		</c:choose>
		Mobile number :
		<c:choose>
			<c:when test="${empty requestScope.newCustomer.getgCellNumberSecond()}">
				<span>-</span>
			</c:when>
			<c:otherwise>
				<c:out value="${requestScope.newCustomer.getgCellNumberSecond()}" />
			</c:otherwise>
		</c:choose>
		Landline :
		<c:choose>
			<c:when test="${empty requestScope.newCustomer.getgLandLine()}">
				<span>-</span>
			</c:when>
			<c:otherwise>
				<c:out value="${requestScope.newCustomer.getgLandLine()}" />
			</c:otherwise>
		</c:choose>
		Email :
		<c:choose>
			<c:when test="${empty requestScope.newCustomer.getgEmailId()}">
				<span>-</span>
			</c:when>
			<c:otherwise>
				<c:out value="${requestScope.newCustomer.getgEmailId()}" />
			</c:otherwise>
		</c:choose>
		Joined Date :
		<c:out value="${requestScope.newCustomer.getjDate()}" />
		Reffered By :
		<c:choose>
			<c:when test="${empty requestScope.newCustomer.getRefferedBy()}">
				<span>-</span>
			</c:when>
			<c:otherwise>
				<c:out value="${requestScope.newCustomer.getRefferedBy()}" />
			</c:otherwise>
		</c:choose>
		Approved By :
		<c:out value="${requestScope.newCustomer.getApprovedBy()}" />
		Entry By :
		<c:out value="${requestScope.newCustomer.getEnteredBy() }" />
		Finger Prints :
		<img src="/KJJCSoft/upload/<c:out value="${requestScope.newCustomer.getFingerPrintPath()}"/>" height="100px" width="100px" />
		<c:remove var="newCustomer" scope="request" />
		<br>
		<b>Open Saving Account</b>
		<br>
		<a href="/KJJCSoft/com/kjjcsoft/controllers/opendaily">
			<input type="button" value="Daily Savings" />
		</a>
		<a href="/KJJCSoft/com/kjjcsoft/controllers/openmonthly">
			<input type="button" value="Monthly Savings" />
		</a>
		<a href="/KJJCSoft/com/kjjcsoft/controllers/openfixed">
			<input type="button" value="Fixed Deposit" />
		</a>
		<a href="/KJJCSoft/com/kjjcsoft/controllers/opencfixed">
			<input type="button" value="Continious Fixed Deposit" />
		</a>
	<!-- 	<b>Loan Account</b>
		<a href="">
			<input type="button" value="Bussiness Loan" />
		</a>
		<a href="">
			<input type="button" value="Agricultural Loan">
		</a> -->
	</div>
	<jsp:include page="footer.jsp" />
</div>
</div>
</body>
</html>