<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:choose>
	<c:when test="${sessionScope.loggedIn !=true }">
		<c:redirect url="../index.jsp" />
	</c:when>
</c:choose>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/KJJCSoft/view/css/style.css" type="text/css" />
<title>KJJCSoft</title>
</head>
<body>
	<div class="container">
		<div class="main-header clearfix">KJJC Soft</div>
		<div class="details-container clearfix">
		<div class="details">
			<img src="<c:out value="/KJJCSoft/upload/${sessionScope.CustomerDetails.getPhotoPath()}"/>" height="50px" width="50px" />
			Customer ID:
			<c:out value="${sessionScope.CustomerDetails.getCustomerId()}" />
			Name :
			<c:out value="${sessionScope.CustomerDetails.getCustomerName()}" />
			Age :
			<c:out value="${sessionScope.CustomerDetails.getCustomerAge()}" />
			Sex :
			<c:out value="${sessionScope.CustomerDetails.getGender()}" />
			Date of birth :
			<c:out value="${sessionScope.CustomerDetails.getDob()}" />
			Nationality :
			<c:out value="${sessionScope.CustomerDetails.getNationality()}" />
			Citizenship Number :
			<c:choose>
				<c:when test="${empty sessionScope.CustomerDetails.getCitizenShipNo()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${sessionScope.CustomerDetails.getCitizenShipNo()}" />
				</c:otherwise>
			</c:choose>
			<fieldset>
				<legend>Permanent Address</legend>
				District :
				<c:out value="${sessionScope.CustomerDetails.getPermDistrict()}" />
				Vdc/Municipality :
				<c:out value="${sessionScope.CustomerDetails.getPermVdcMunicipality()}" />
				Other Information :
				<c:choose>
					<c:when test="${empty sessionScope.CustomerDetails.getPermExtrainfo()}">
						<span>-</span>
					</c:when>
					<c:otherwise>
						<c:out value="${sessionScope.CustomerDetails.getPermExtrainfo()}" />
					</c:otherwise>
				</c:choose>
			</fieldset>
			<fieldset>
				<legend>Temporary Address</legend>
				District :
				<c:choose>
					<c:when test="${empty sessionScope.CustomerDetails.getTempDistrict()}">
						<span>-</span>
					</c:when>
					<c:otherwise>
						<c:out value="${sessionScope.CustomerDetails.getTempDistrict()}" />
					</c:otherwise>
				</c:choose>
				Vdc/Municipality :
				<c:choose>
					<c:when test="${empty sessionScope.CustomerDetails.getTempVdcMunicipality()}">
						<span>-</span>
					</c:when>
					<c:otherwise>
						<c:out value="${sessionScope.CustomerDetails.getTempVdcMunicipality()}" />
					</c:otherwise>
				</c:choose>
				Other Information :
				<c:choose>
					<c:when test="${empty sessionScope.CustomerDetails.getTempExtrainfo()}">
						<span>-</span>
					</c:when>
					<c:otherwise>
						<c:out value="${sessionScope.CustomerDetails.getTempExtrainfo()}" />
					</c:otherwise>
				</c:choose>
			</fieldset>
			Mobile number :
			<c:choose>
				<c:when test="${empty sessionScope.CustomerDetails.getCellNumberFirst()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${sessionScope.CustomerDetails.getCellNumberFirst()}" />
				</c:otherwise>
			</c:choose>
			Mobile number :
			<c:choose>
				<c:when test="${empty sessionScope.CustomerDetails.getCellNumberSecond()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${sessionScope.CustomerDetails.getCellNumberSecond()}" />
				</c:otherwise>
			</c:choose>
			Landline :
			<c:choose>
				<c:when test="${empty sessionScope.CustomerDetails.getLandLine()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${sessionScope.CustomerDetails.getLandLine()}" />
				</c:otherwise>
			</c:choose>
			Email :
			<c:choose>
				<c:when test="${empty sessionScope.CustomerDetails.getEmailId()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${sessionScope.CustomerDetails.getEmailId()}" />
				</c:otherwise>
			</c:choose>
			Marital Status :
			<c:out value="${sessionScope.CustomerDetails.getMaritalStatus()}" />
			Spouse Name :
			<c:choose>
				<c:when test="${empty sessionScope.CustomerDetails.getSpouseName()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${sessionScope.CustomerDetails.getSpouseName()}" />
				</c:otherwise>
			</c:choose>
			Occupation :
			<c:out value="${sessionScope.CustomerDetails.getOccupation()}" />
			Father's Name :
			<c:out value="${sessionScope.CustomerDetails.getFathersName()}" />
			Grandfather's Name :
			<c:choose>
				<c:when test="${empty sessionScope.CustomerDetails.getGrandFathersName()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${sessionScope.CustomerDetails.getGrandFathersName()}" />
				</c:otherwise>
			</c:choose>
			Father-in-law's Name :
			<c:choose>
				<c:when test="${empty sessionScope.CustomerDetails.getFatherInLawsName()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${sessionScope.CustomerDetails.getFatherInLawsName()}" />
				</c:otherwise>
			</c:choose>
			<b>Nominee Information</b> Nominee's Name :
			<c:out value="${sessionScope.CustomerDetails.getNomineesName()}" />
			Relation :
			<c:out value="${sessionScope.CustomerDetails.getNomineeRelation()}" />
			<fieldset>
				<legend>Permanent Address</legend>
				District :
				<c:out value="${sessionScope.CustomerDetails.getnPermDistrict()}" />
				Vdc/Municipality :
				<c:out value="${sessionScope.CustomerDetails.getnPermVdcMunicipality()}" />
				Other Information :
				<c:choose>
					<c:when test="${empty sessionScope.CustomerDetails.getnPermExtraInfo()}">
						<span>-</span>
					</c:when>
					<c:otherwise>
						<c:out value="${sessionScope.CustomerDetails.getnPermExtraInfo()}" />
					</c:otherwise>
				</c:choose>
			</fieldset>
			<fieldset>
				<legend>Temporary Address</legend>
				District :
				<c:choose>
					<c:when test="${empty sessionScope.CustomerDetails.getnTempDistrict()}">
						<span>-</span>
					</c:when>
					<c:otherwise>
						<c:out value="${sessionScope.CustomerDetails.getnTempDistrict()}" />
					</c:otherwise>
				</c:choose>
				Vdc/Municipality :
				<c:choose>
					<c:when test="${empty sessionScope.CustomerDetails.getnTempVdcMunicipality()}">
						<span>-</span>
					</c:when>
					<c:otherwise>
						<c:out value="${sessionScope.CustomerDetails.getnTempVdcMunicipality()}" />
					</c:otherwise>
				</c:choose>
				Other Information :
				<c:choose>
					<c:when test="${empty sessionScope.CustomerDetails.getnTempExtraInfo()}">
						<span>-</span>
					</c:when>
					<c:otherwise>
						<c:out value="${sessionScope.CustomerDetails.getnTempExtraInfo()}" />
					</c:otherwise>
				</c:choose>
			</fieldset>
			Mobile number :
			<c:choose>
				<c:when test="${empty sessionScope.CustomerDetails.getnCellNumberFirst()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${sessionScope.CustomerDetails.getnCellNumberFirst()}" />
				</c:otherwise>
			</c:choose>
			Mobile number :
			<c:choose>
				<c:when test="${empty sessionScope.CustomerDetails.getnCellNumberSecond()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${sessionScope.CustomerDetails.getnCellNumberSecond()}" />
				</c:otherwise>
			</c:choose>
			Landline :
			<c:choose>
				<c:when test="${empty sessionScope.CustomerDetails.getnLandLine()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${sessionScope.CustomerDetails.getnLandLine()}" />
				</c:otherwise>
			</c:choose>
			Email :
			<c:choose>
				<c:when test="${empty sessionScope.CustomerDetails.getnEmailId()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${sessionScope.CustomerDetails.getnEmailId()}" />
				</c:otherwise>
			</c:choose>
			<b>Guardian Information for Underage</b> Name :
			<c:choose>
				<c:when test="${empty sessionScope.CustomerDetails.getGuardianName()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${sessionScope.CustomerDetails.getGuardianName()}" />
				</c:otherwise>
			</c:choose>
			Relation :
			<c:choose>
				<c:when test="${empty sessionScope.CustomerDetails.getgRelation()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${sessionScope.CustomerDetails.getgRelation()}" />
				</c:otherwise>
			</c:choose>
			<fieldset>
				<legend>Permanent Address</legend>
				District :
				<c:choose>
					<c:when test="${empty sessionScope.CustomerDetails.getgPermDistrict()}">
						<span>-</span>
					</c:when>
					<c:otherwise>
						<c:out value="${sessionScope.CustomerDetails.getgPermDistrict()}" />
					</c:otherwise>
				</c:choose>
				Vdc/Municipality :
				<c:choose>
					<c:when test="${empty sessionScope.CustomerDetails.getgPermVdcMunicipality()}">
						<span>-</span>
					</c:when>
					<c:otherwise>
						<c:out value="${sessionScope.CustomerDetails.getgPermVdcMunicipality()}" />
					</c:otherwise>
				</c:choose>
				Other Information :
				<c:choose>
					<c:when test="${empty sessionScope.CustomerDetails.getgPermExtraInfo()}">
						<span>-</span>
					</c:when>
					<c:otherwise>
						<c:out value="${sessionScope.CustomerDetails.getgPermExtraInfo()}" />
					</c:otherwise>
				</c:choose>
			</fieldset>
			<fieldset>
				<legend>Temporary Address</legend>
				District :
				<c:choose>
					<c:when test="${empty sessionScope.CustomerDetails.getgTempDistrict()}">
						<span>-</span>
					</c:when>
					<c:otherwise>
						<c:out value="${sessionScope.CustomerDetails.getgTempDistrict()}" />
					</c:otherwise>
				</c:choose>
				Vdc/Municipality :
				<c:choose>
					<c:when test="${empty sessionScope.CustomerDetails.getgTempVdcMunicipality()}">
						<span>-</span>
					</c:when>
					<c:otherwise>
						<c:out value="${sessionScope.CustomerDetails.getgTempVdcMunicipality()}" />
					</c:otherwise>
				</c:choose>
				Other Information :
				<c:choose>
					<c:when test="${empty sessionScope.CustomerDetails.getgTempExtraInfo()}">
						<span>-</span>
					</c:when>
					<c:otherwise>
						<c:out value="${sessionScope.CustomerDetails.getgTempExtraInfo()}" />
					</c:otherwise>
				</c:choose>
			</fieldset>
			Mobile number :
			<c:choose>
				<c:when test="${empty sessionScope.CustomerDetails.getgCellNumberFirst()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${sessionScope.CustomerDetails.getgCellNumberFirst()}" />
				</c:otherwise>
			</c:choose>
			Mobile number :
			<c:choose>
				<c:when test="${empty sessionScope.CustomerDetails.getgCellNumberSecond()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${sessionScope.CustomerDetails.getgCellNumberSecond()}" />
				</c:otherwise>
			</c:choose>
			Landline :
			<c:choose>
				<c:when test="${empty sessionScope.CustomerDetails.getgLandLine()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${sessionScope.CustomerDetails.getgLandLine()}" />
				</c:otherwise>
			</c:choose>
			Email :
			<c:choose>
				<c:when test="${empty sessionScope.CustomerDetails.getgEmailId()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${sessionScope.CustomerDetails.getgEmailId()}" />
				</c:otherwise>
			</c:choose>
			Joined Date :
			<c:out value="${sessionScope.CustomerDetails.getjDate()}" />
			Reffered By :
			<c:choose>
				<c:when test="${empty sessionScope.CustomerDetails.getRefferedBy()}">
					<span>-</span>
				</c:when>
				<c:otherwise>
					<c:out value="${sessionScope.CustomerDetails.getRefferedBy()}" />
				</c:otherwise>
			</c:choose>
			Approved By :
			<c:out value="${sessionScope.CustomerDetails.getApprovedBy()}" />
			Entry By :
			<c:out value="${sessionScope.CustomerDetails.getEnteredBy() }" />
			Finger Prints :
			<img src="/KJJCSoft/upload/<c:out value="${sessionScope.CustomerDetails.getFingerPrintPath()}"/>" height="100px" width="100px" />
			<c:remove var="CustomerDetails" scope="session" />
		</div>
		<jsp:include page="footer.jsp"/>
		</div>
	</div>
</body>
</html>