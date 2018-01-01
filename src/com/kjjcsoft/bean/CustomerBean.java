/**
 * 
 */
package com.kjjcsoft.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.text.WordUtils;

/**
 * @author Niroj Stha
 *
 */
public class CustomerBean {
	private int customerId;
	private String customerName;
	private String customerAge;
	private String gender;
	private String dob;
	private String permDistrict;
	private String permVdcMunicipality;
	private String permExtrainfo;
	private String tempDistrict;
	private String tempVdcMunicipality;
	private String tempExtrainfo;
	private String cellNumberFirst;
	private String cellNumberSecond;
	private String landLine;
	private String emailId;
	private String citizenShipNo;
	private String nationality;
	private String maritalStatus;
	private String spouseName;
	private String occupation;
	private String fathersName;
	private String grandFathersName;
	private String fatherInLawsName;
	private String nomineesName;
	private String nomineeRelation;
	private String nPermDistrict;
	private String nPermVdcMunicipality;
	private String nPermExtraInfo;
	private String nTempDistrict;
	private String nTempVdcMunicipality;
	private String nTempExtraInfo;
	private String nCellNumberFirst;
	private String nCellNumberSecond;
	private String nLandLine;
	private String nEmailId;
	private String guardianName;
	private String gRelation;
	private String gPermDistrict;
	private String gPermVdcMunicipality;
	private String gPermExtraInfo;
	private String gTempDistrict;
	private String gTempVdcMunicipality;
	private String gTempExtraInfo;
	private String gCellNumberFirst;
	private String gCellNumberSecond;
	private String gLandLine;
	private String gEmailId;
	private String photoPath;
	private String fingerPrintPath;
	private String jDate;
	private String refferedBy;
	private int entryBy;
	private String approvedBy;
	private String enteredBy;
	private boolean status;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(String customerAge) {
		this.customerAge = customerAge;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPermDistrict() {
		return permDistrict;
	}

	public void setPermDistrict(String permDistrict) {
		this.permDistrict = permDistrict;
	}

	public String getPermVdcMunicipality() {
		return permVdcMunicipality;
	}

	public void setPermVdcMunicipality(String permVdcMunicipality) {
		this.permVdcMunicipality = permVdcMunicipality;
	}

	public String getPermExtrainfo() {
		return permExtrainfo;
	}

	public void setPermExtrainfo(String permExtrainfo) {
		this.permExtrainfo = permExtrainfo;
	}

	public String getTempDistrict() {
		return tempDistrict;
	}

	public void setTempDistrict(String tempDistrict) {
		this.tempDistrict = tempDistrict;
	}

	public String getTempVdcMunicipality() {
		return tempVdcMunicipality;
	}

	public void setTempVdcMunicipality(String tempVdcMunicipality) {
		this.tempVdcMunicipality = tempVdcMunicipality;
	}

	public String getTempExtrainfo() {
		return tempExtrainfo;
	}

	public void setTempExtrainfo(String tempExtrainfo) {
		this.tempExtrainfo = tempExtrainfo;
	}

	public String getCellNumberFirst() {
		return cellNumberFirst;
	}

	public void setCellNumberFirst(String cellNumberFirst) {
		this.cellNumberFirst = cellNumberFirst;
	}

	public String getCellNumberSecond() {
		return cellNumberSecond;
	}

	public void setCellNumberSecond(String cellNumberSecond) {
		this.cellNumberSecond = cellNumberSecond;
	}

	public String getLandLine() {
		return landLine;
	}

	public void setLandLine(String landLine) {
		this.landLine = landLine;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getFathersName() {
		return fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public String getGrandFathersName() {
		return grandFathersName;
	}

	public void setGrandFathersName(String grandFathersName) {
		this.grandFathersName = grandFathersName;
	}

	public String getFatherInLawsName() {
		return fatherInLawsName;
	}

	public void setFatherInLawsName(String fatherInLawsName) {
		this.fatherInLawsName = fatherInLawsName;
	}

	public String getNomineesName() {
		return nomineesName;
	}

	public void setNomineesName(String nomineesName) {
		this.nomineesName = nomineesName;
	}

	public String getnPermDistrict() {
		return nPermDistrict;
	}

	public void setnPermDistrict(String nPermDistrict) {
		this.nPermDistrict = nPermDistrict;
	}

	public String getnPermVdcMunicipality() {
		return nPermVdcMunicipality;
	}

	public void setnPermVdcMunicipality(String nPermVdcMunicipality) {
		this.nPermVdcMunicipality = nPermVdcMunicipality;
	}

	public String getnPermExtraInfo() {
		return nPermExtraInfo;
	}

	public void setnPermExtraInfo(String nPermExtraInfo) {
		this.nPermExtraInfo = nPermExtraInfo;
	}

	public String getnTempDistrict() {
		return nTempDistrict;
	}

	public void setnTempDistrict(String nTempDistrict) {
		this.nTempDistrict = nTempDistrict;
	}

	public String getnTempVdcMunicipality() {
		return nTempVdcMunicipality;
	}

	public void setnTempVdcMunicipality(String nTempVdcMunicipality) {
		this.nTempVdcMunicipality = nTempVdcMunicipality;
	}

	public String getnTempExtraInfo() {
		return nTempExtraInfo;
	}

	public void setnTempExtraInfo(String nTempExtraInfo) {
		this.nTempExtraInfo = nTempExtraInfo;
	}

	public String getnCellNumberFirst() {
		return nCellNumberFirst;
	}

	public void setnCellNumberFirst(String nCellNumberFirst) {
		this.nCellNumberFirst = nCellNumberFirst;
	}

	public String getnCellNumberSecond() {
		return nCellNumberSecond;
	}

	public void setnCellNumberSecond(String nCellNumberSecond) {
		this.nCellNumberSecond = nCellNumberSecond;
	}

	public String getnLandLine() {
		return nLandLine;
	}

	public void setnLandLine(String nLandLine) {
		this.nLandLine = nLandLine;
	}

	public String getnEmailId() {
		return nEmailId;
	}

	public void setnEmailId(String nEmailId) {
		this.nEmailId = nEmailId;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public String getgRelation() {
		return gRelation;
	}

	public void setgRelation(String gRelation) {
		this.gRelation = gRelation;
	}

	public String getgPermDistrict() {
		return gPermDistrict;
	}

	public void setgPermDistrict(String gPermDistrict) {
		this.gPermDistrict = gPermDistrict;
	}

	public String getgPermVdcMunicipality() {
		return gPermVdcMunicipality;
	}

	public void setgPermVdcMunicipality(String gPermVdcMunicipality) {
		this.gPermVdcMunicipality = gPermVdcMunicipality;
	}

	public String getgPermExtraInfo() {
		return gPermExtraInfo;
	}

	public void setgPermExtraInfo(String gPermExtraInfo) {
		this.gPermExtraInfo = gPermExtraInfo;
	}

	public String getgTempDistrict() {
		return gTempDistrict;
	}

	public void setgTempDistrict(String gTempDistrict) {
		this.gTempDistrict = gTempDistrict;
	}

	public String getgTempVdcMunicipality() {
		return gTempVdcMunicipality;
	}

	public void setgTempVdcMunicipality(String gTempVdcMunicipality) {
		this.gTempVdcMunicipality = gTempVdcMunicipality;
	}

	public String getgTempExtraInfo() {
		return gTempExtraInfo;
	}

	public void setgTempExtraInfo(String gTempExtraInfo) {
		this.gTempExtraInfo = gTempExtraInfo;
	}

	public String getgCellNumberFirst() {
		return gCellNumberFirst;
	}

	public void setgCellNumberFirst(String gCellNumberFirst) {
		this.gCellNumberFirst = gCellNumberFirst;
	}

	public String getgCellNumberSecond() {
		return gCellNumberSecond;
	}

	public void setgCellNumberSecond(String gCellNumberSecond) {
		this.gCellNumberSecond = gCellNumberSecond;
	}

	public String getgLandLine() {
		return gLandLine;
	}

	public void setgLandLine(String gLandLine) {
		this.gLandLine = gLandLine;
	}

	public String getgEmailId() {
		return gEmailId;
	}

	public void setgEmailId(String gEmailId) {
		this.gEmailId = gEmailId;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getFingerPrintPath() {
		return fingerPrintPath;
	}

	public void setFingerPrintPath(String fingerPrintPath) {
		this.fingerPrintPath = fingerPrintPath;
	}

	public String getjDate() {
		return jDate;
	}

	public void setjDate(String jDate) {
		this.jDate = jDate;
	}

	public String getRefferedBy() {
		return refferedBy;
	}

	public void setRefferedBy(String refferedBy) {
		this.refferedBy = refferedBy;
	}

	public int getEntryBy() {
		return entryBy;
	}

	public void setEntryBy(int entryBy) {
		this.entryBy = entryBy;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getCitizenShipNo() {
		return citizenShipNo;
	}

	public void setCitizenShipNo(String citizenShipNo) {
		this.citizenShipNo = citizenShipNo;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getNomineeRelation() {
		return nomineeRelation;
	}

	public void setNomineeRelation(String nomineeRelation) {
		this.nomineeRelation = nomineeRelation;
	}

	public String getEnteredBy() {
		return enteredBy;
	}

	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int validateCustomerName() {
		customerName = customerName.replaceAll("\\s+", " ").trim();
		customerName = WordUtils.capitalizeFully(customerName);
		if (customerName.length() < 1) {
			return 11;
		} else if (customerName.matches(".*[!@#$%^&*()_+=-><,.;~`:\"\'].*") || customerName.matches(".*\\d+.*")) {
			return 12;
		} else {
			return 0;
		}
	}

	public int validateCustomerAge() {
		customerAge = customerAge.replaceAll("\\s+", " ").trim();
		if (customerAge.length() < 1) {
			return 21;
		} else if (customerAge.matches("\\d{1,3}")) {
			return 0;
		} else {
			return 22;
		}
	}

	public int validatedob() {
		dob = dob.replaceAll("\\s+", " ").trim();
		if (dob.matches("((19|20)\\d\\d)/(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])") || dob.matches("((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])")) {
			return 0;
		} else if (dob.length() < 1) {
			return 31;
		} else {
			return 32;
		}
	}

	public int validateGender() {
		gender = gender.replaceAll("\\s+", " ").trim();
		if (gender.length() < 1 || gender == null) {
			return 41;
		} else {
			return 0;
		}
	}

	public int validateNationality() {
		nationality = nationality.replaceAll("\\s+", " ").trim();
		nationality = WordUtils.capitalizeFully(nationality);
		if (nationality.matches(".*\\d+.*") || nationality.matches(".*[!@#$%^&*()_+=-><,.;~`:\"\'].*")) {
			return 52;
		} else if (nationality.length() < 1) {
			return 51;
		} else {
			return 0;
		}
	}

	public int validateCitizenshipNo() {
		citizenShipNo = citizenShipNo.replaceAll("\\s+", " ").trim();
		if (nationality.equals("Nepali") && (citizenShipNo.matches("^\\d+") || citizenShipNo.matches("^\\d+/\\d+"))) {
			return 0;
		} else if ((!nationality.equals("Nepali") && citizenShipNo.length() < 1)
				|| (nationality.equals("Nepali") && !customerAge.equals("") && !customerAge.matches("[^\\d]+")
						&& Integer.parseInt(customerAge) < 16 && citizenShipNo.length() < 1)) {
			citizenShipNo = "";
			return 0;
		} else if(!nationality.equals("Nepali") && (citizenShipNo.matches("^\\d+") || citizenShipNo.matches("^\\d+/\\d+"))){
			return 0;
		}else if (nationality.equals("Nepali") && !customerAge.equals("") && !customerAge.matches("[^\\d]+")
				&& Integer.parseInt(customerAge) > 16 && citizenShipNo.length() < 1) {
			return 61;
		} else {
			return 62;
		}
	}

	public int validateMaritalStatus() {
		if (maritalStatus.length() < 1 || maritalStatus == null) {
			return 71;
		} else {
			return 0;
		}
	}

	public int validateSpouseName() {
		spouseName = spouseName.replaceAll("\\s+", " ").trim();
		spouseName = WordUtils.capitalizeFully(spouseName);
		if (maritalStatus.equals("Married") && spouseName.length() < 1) {
			return 81;
		} else if (maritalStatus.equals("Married")
				&& (spouseName.matches(".*\\d+.*") || spouseName.matches(".*[!@#$%^&*()_+=-><,.;~`:\"\'].*"))) {
			return 82;
		} else if (maritalStatus.equals("Married") && spouseName.matches("^\\w+.*")) {
			return 0;
		} else {
			spouseName = "";
			return 0;
		}
	}

	public int validateOccupation() {
		occupation = occupation.replaceAll("\\s+", " ").trim();
		occupation = WordUtils.capitalizeFully(occupation);
		if (occupation.length() < 1) {
			return 91;
		} else if (occupation.matches(".*\\d+.*") || occupation.matches(".*[!@#$%^&*()_+=-><,.;~`:\"\'].*")) {
			return 92;
		} else {
			return 0;
		}
	}

	public int validateCellOne() {
		cellNumberFirst = cellNumberFirst.replaceAll("\\s+", " ").trim();
		if (cellNumberFirst.matches("\\d*") && cellNumberFirst.length() < 11) {
			return 0;
		} else if (cellNumberFirst.length() < 2) {
			cellNumberFirst = "";
			return 0;
		} else {
			return 101;
		}
	}

	public int validateCellTwo() {
		cellNumberSecond = cellNumberSecond.replaceAll("\\s+", " ").trim();
		if (cellNumberSecond.matches("\\d*") && cellNumberSecond.length() < 11) {
			return 0;
		} else if (cellNumberSecond.length() < 2) {
			cellNumberSecond = "";
			return 0;
		} else {
			return 111;
		}
	}

	public int validateLandLine() {
		landLine = landLine.replaceAll("\\s+", " ").trim();
		if (landLine.matches("\\d*") && landLine.length() < 11) {
			return 0;
		} else if (landLine.length() < 2) {
			landLine = "";
			return 0;
		} else {
			return 121;
		}
	}

	public int anyNumber() {
		if (cellNumberFirst.equals("") && cellNumberSecond.equals("") && landLine.equals("")) {
			return 131;
		} else {
			return 0;
		}
	}

	public int validateEmail() {
		emailId = emailId.replaceAll("\\s+", " ").trim();
		if (emailId.matches("\\w+@\\w+\\.com")) {
			return 0;
		} else if (emailId.length() < 1) {
			emailId = "";
			return 0;
		} else {
			return 141;
		}
	}

	public int validateDistrictPerm() {
		permDistrict = permDistrict.replaceAll("\\s+", " ").trim();
		permDistrict = WordUtils.capitalizeFully(permDistrict);
		if (permDistrict.length() < 1) {
			return 151;
		} else if (permDistrict.matches("\\w+")) {
			return 0;
		} else {
			return 152;
		}
	}

	public int validateVMpPerm() {
		permVdcMunicipality = permVdcMunicipality.replaceAll("\\s+", " ").trim();
		permVdcMunicipality = WordUtils.capitalizeFully(permVdcMunicipality);
		if (permVdcMunicipality.matches("([^\\W]+\\s?-{1}\\s?[^\\W]*|[^\\W]+)")) {
			return 0;
		} else if (permVdcMunicipality.length() < 1) {
			return 161;
		} else {
			return 162;
		}
	}

	public int validatePermExtra() {
		permExtrainfo = permExtrainfo.replaceAll("\\s+", " ").trim();
		permExtrainfo = WordUtils.capitalizeFully(permExtrainfo);
		if (permExtrainfo.length() < 1) {
			permExtrainfo = "";
			return 0;
		} else if (permExtrainfo.matches("[^\\W]+")) {
			return 0;
		} else {
			return 171;
		}
	}

	public int validateTempDistrict() {
		tempDistrict = tempDistrict.replaceAll("\\s+", " ").trim();
		tempDistrict = WordUtils.capitalizeFully(tempDistrict);
		if (tempDistrict.length() < 1) {
			tempDistrict = "";
			return 0;
		} else if (tempDistrict.matches("\\w+")) {
			return 0;
		} else {
			return 181;
		}
	}

	public int validateTempVMp() {
		tempVdcMunicipality = tempVdcMunicipality.replaceAll("\\s+", " ").trim();
		tempVdcMunicipality = WordUtils.capitalizeFully(tempVdcMunicipality);
		if (tempDistrict.length() > 1 && tempVdcMunicipality.matches("([^\\W]+\\s?-{1}\\s?[^\\W]*|[^\\W]+)")
				&& tempVdcMunicipality.length() > 1) {
			return 0;
		} else if (tempVdcMunicipality.length() < 1 && tempDistrict.length() < 1) {
			tempVdcMunicipality = "";
			return 0;
		} else if (tempDistrict.length() > 1 && tempVdcMunicipality.length() < 1) {
			return 191;
		} else if (tempDistrict.length() < 1 && tempVdcMunicipality.length() > 1) {
			return 192;
		} else {
			return 193;
		}
	}

	public int validateTempExtra() {
		tempExtrainfo = tempExtrainfo.replaceAll("\\s+", " ").trim();
		tempExtrainfo = WordUtils.capitalizeFully(tempExtrainfo);
		if (tempExtrainfo.length() > 1 && tempVdcMunicipality.length() > 1 && tempDistrict.length() < 1) {
			tempExtrainfo = "";
			return 0;
		} else if (tempDistrict.length() > 1 && tempVdcMunicipality.length() > 1
				&& tempExtrainfo.matches(".*[!@#$%^&*()_+=-><,.;~`:\"\'].*")) {
			return 202;
		} else if (tempDistrict.length() > 1 && tempVdcMunicipality.length() > 1 && tempExtrainfo.length() < 1) {
			tempExtrainfo = "";
			return 0;
		} else if (tempDistrict.length() < 1 && tempVdcMunicipality.length() < 1 && tempExtrainfo.length() > 1) {
			return 201;
		} else if (tempDistrict.length() < 1 && tempVdcMunicipality.length() > 1 && tempExtrainfo.length() < 1) {
			tempExtrainfo = "";
			return 0;
		} else if ((tempDistrict.length() > 1 && tempVdcMunicipality.length() < 1 && tempExtrainfo.length() > 1)) {
			return 201;
		} else {
			return 0;
		}
	}

	public int validateFName() {
		fathersName = fathersName.replaceAll("\\s+", " ").trim();
		fathersName = WordUtils.capitalizeFully(fathersName);
		if (fathersName.length() < 1) {
			return 211;
		} else if (fathersName.matches(".*[!@#$%^&*()_+=-><,.;~`:\"\'].*") || (fathersName.matches(".*\\d+.*"))) {
			return 212;
		} else {
			return 0;
		}
	}

	public int validateGFName() {
		grandFathersName = grandFathersName.replaceAll("\\s+", " ").trim();
		grandFathersName = WordUtils.capitalizeFully(grandFathersName);
		if ((grandFathersName.length() < 1 && gender.equals("Male"))
				|| (grandFathersName.length() < 1 && gender.equals("Female") && maritalStatus.equals("Single"))) {
			return 221;
		} else if (grandFathersName.length() < 1 && gender.equals("Female") && maritalStatus.equals("Married")) {
			grandFathersName = "";
			return 0;
		} else if (grandFathersName.matches(".*[!@#$%^&*()_+=-><,.;~`:\"\'].*")
				|| (grandFathersName.matches(".*\\d+.*"))) {
			return 222;
		} else {
			return 0;
		}
	}

	public int validateFLName() {
		fatherInLawsName = fatherInLawsName.replaceAll("\\s+", " ").trim();
		fatherInLawsName = WordUtils.capitalizeFully(fatherInLawsName);
		if (fatherInLawsName.length() < 1 && gender.equals("Female") && maritalStatus.equals("Married")) {
			return 231;
		} else if (fatherInLawsName.length() < 1 && gender.equals("Male")) {
			fatherInLawsName = "";
			return 0;
		} else if (fatherInLawsName.matches(".*[!@#$%^&*()_+=-><,.;~`:\"\'].*")
				|| (fatherInLawsName.matches(".*\\d+.*"))) {
			return 232;
		} else {
			return 0;
		}
	}

	public int validateNomineeName() {
		nomineesName = nomineesName.replaceAll("\\s+", " ").trim();
		nomineesName = WordUtils.capitalizeFully(nomineesName);
		if (nomineesName.length() < 1) {
			return 241;
		} else if (nomineesName.matches(".*[!@#$%^&*()_+=-><,.;~`:\"\'].*") || (nomineesName.matches(".*\\d+.*"))) {
			return 242;
		} else {
			return 0;
		}
	}

	public int validateNomineeRelation() {
		nomineeRelation = nomineeRelation.replaceAll("\\s+", " ").trim();
		nomineeRelation = WordUtils.capitalizeFully(nomineeRelation);
		if (nomineeRelation.length() < 1) {
			return 251;
		} else
			if (nomineeRelation.matches(".*[!@#$%^&*()_+=-><,.;~`:\"\'].*") || (nomineeRelation.matches(".*\\d+.*"))) {
			return 252;
		} else {
			return 0;
		}
	}

	public int validateNCellOne() {
		nCellNumberFirst = nCellNumberFirst.replaceAll("\\s+", " ").trim();
		if (nCellNumberFirst.matches("\\d*") && nCellNumberFirst.length() < 11) {
			return 0;
		} else if (nCellNumberFirst.length() < 1) {
			nCellNumberFirst = "";
			return 0;
		} else {
			return 261;
		}
	}

	public int validateNCellTwo() {
		nCellNumberSecond = nCellNumberSecond.replaceAll("\\s+", " ").trim();
		if (nCellNumberSecond.matches("\\d*") && nCellNumberSecond.length() < 11) {
			return 0;
		} else if (nCellNumberSecond.length() < 2) {
			nCellNumberSecond = "";
			return 0;
		} else {
			return 271;
		}
	}

	public int validateNLandLine() {
		nLandLine = nLandLine.replaceAll("\\s+", " ").trim();
		if (nLandLine.matches("\\d*") && nLandLine.length() < 11) {
			return 0;
		} else if (nLandLine.length() < 2) {
			nLandLine = "";
			return 0;
		} else {
			return 281;
		}
	}

	public int anyNNumber() {
		if (nCellNumberFirst.equals("") && nCellNumberSecond.equals("") && nLandLine.equals("")) {
			return 291;
		} else {
			return 0;
		}
	}

	public int validateNEmail() {
		nEmailId = nEmailId.replaceAll("\\s+", " ").trim();
		if (nEmailId.matches("\\w+@\\w+\\.com")) {
			return 0;
		} else if (nEmailId.length() < 1) {
			nEmailId = "";
			return 0;
		} else {
			return 301;
		}
	}

	public int validateNDistrictPerm() {
		nPermDistrict = nPermDistrict.replaceAll("\\s+", " ").trim();
		nPermDistrict = WordUtils.capitalizeFully(nPermDistrict);
		if (nPermDistrict.length() < 1) {
			return 311;
		} else if (nPermDistrict.matches("\\w+")) {
			return 0;
		} else {
			return 312;
		}
	}

	public int validateNVMpPerm() {
		nPermVdcMunicipality = nPermVdcMunicipality.replaceAll("\\s+", " ").trim();
		nPermVdcMunicipality = WordUtils.capitalizeFully(nPermVdcMunicipality);
		if (nPermVdcMunicipality.matches("([^\\W]+\\s?-{1}\\s?[^\\W]*|[^\\W]+)")) {
			return 0;
		} else if (nPermVdcMunicipality.length() < 1) {
			return 321;
		} else {
			return 322;
		}
	}

	public int validateNPermExtra() {
		nPermExtraInfo = nPermExtraInfo.replaceAll("\\s+", " ").trim();
		nPermExtraInfo = WordUtils.capitalizeFully(nPermExtraInfo);
		if (nPermExtraInfo.length() < 1) {
			nPermExtraInfo = "";
			return 0;
		} else if (nPermExtraInfo.matches("[^\\W]+")) {
			return 0;
		} else {
			return 331;
		}
	}

	public int validateNTempDistrict() {
		nTempDistrict = nTempDistrict.replaceAll("\\s+", " ").trim();
		nTempDistrict = WordUtils.capitalizeFully(nTempDistrict);
		if (nTempDistrict.length() < 1) {
			nTempDistrict = "";
			return 0;
		} else if (nTempDistrict.matches("\\w+")) {
			return 0;
		} else {
			return 341;
		}
	}

	public int validateNTempVMp() {
		nTempVdcMunicipality = nTempVdcMunicipality.replaceAll("\\s+", " ").trim();
		nTempVdcMunicipality = WordUtils.capitalizeFully(nTempVdcMunicipality);
		if (nTempDistrict.length() > 1 && nTempVdcMunicipality.matches("([^\\W]+\\s?-{1}\\s?[^\\W]*|[^\\W]+)")) {
			return 0;
		} else if (nTempVdcMunicipality.length() < 1 && nTempDistrict.length() < 1) {
			nTempVdcMunicipality = "";
			return 0;
		} else if (nTempDistrict.length() > 1 && nTempVdcMunicipality.length() < 1) {
			return 351;
		} else if (nTempDistrict.length() < 1 && nTempVdcMunicipality.length() > 1) {
			return 352;
		} else {
			return 353;
		}
	}

	public int validateNTempExtra() {
		nTempExtraInfo = nTempExtraInfo.replaceAll("\\s+", " ").trim();
		nTempExtraInfo = WordUtils.capitalizeFully(nTempExtraInfo);
		if (nTempExtraInfo.length() < 1 && nTempVdcMunicipality.length() < 1 && nTempDistrict.length() < 1) {
			nTempExtraInfo = "";
			return 0;
		} else if (nTempDistrict.length() > 1 && nTempVdcMunicipality.length() > 1
				&& nTempExtraInfo.matches(".*[!@#$%^&*()_+=-><,.;~`:\"\'].*")) {
			return 362;
		} else if (nTempDistrict.length() > 1 && nTempVdcMunicipality.length() > 1 && nTempExtraInfo.length() < 1) {
			tempExtrainfo = "";
			return 0;
		} else if (nTempDistrict.length() < 1 && nTempVdcMunicipality.length() < 1 && nTempExtraInfo.length() > 1) {
			return 361;
		} else if (nTempDistrict.length() < 1 && nTempVdcMunicipality.length() > 1 && nTempExtraInfo.length() < 1) {
			tempExtrainfo = "";
			return 0;
		} else if ((nTempDistrict.length() > 1 && nTempVdcMunicipality.length() < 1 && nTempExtraInfo.length() > 1)) {
			return 361;
		} else {
			return 0;
		}
	}

	public int validateGuardianName() {
		if ((!customerAge.equals("") && !customerAge.matches("[^\\d]+")) && Integer.parseInt(customerAge) < 16) {
			guardianName = guardianName.replaceAll("\\s+", " ").trim();
			guardianName = WordUtils.capitalizeFully(guardianName);
			if (guardianName.length() < 1) {
				return 371;
			} else if (guardianName.matches(".*[!@#$%^&*()_+=-><,.;~`:\"\'].*") || (guardianName.matches(".*\\d+.*"))) {
				return 372;
			} else {
				return 0;
			}
		} else {
			guardianName = "";
			return 0;
		}
	}

	public int validateGuardianRelation() {
		if ((!customerAge.equals("") && !customerAge.matches("[^\\d]+")) && Integer.parseInt(customerAge) < 16) {
			gRelation = gRelation.replaceAll("\\s+", " ").trim();
			gRelation = WordUtils.capitalizeFully(gRelation);
			if (gRelation.length() < 1) {
				return 381;
			} else if (gRelation.matches(".*[!@#$%^&*()_+=-><,.;~`:\"\'].*") || (gRelation.matches(".*\\d+.*"))) {
				return 382;
			} else {
				return 0;
			}
		} else {
			gRelation = "";
			return 0;
		}
	}

	public int validateGCellOne() {
		if ((!customerAge.equals("") && !customerAge.matches("[^\\d]+")) && Integer.parseInt(customerAge) < 16) {
			gCellNumberFirst = gCellNumberFirst.replaceAll("\\s+", " ").trim();
			if (gCellNumberFirst.matches("\\d*") && gCellNumberFirst.length() < 11) {
				return 0;
			} else if (gCellNumberFirst.length() < 1) {
				gCellNumberFirst = "";
				return 0;
			} else {
				return 391;
			}
		} else {
			gCellNumberFirst = "";
			return 0;
		}
	}

	public int validateGCellTwo() {
		if ((!customerAge.equals("") && !customerAge.matches("[^\\d]+")) && Integer.parseInt(customerAge) < 16) {
			gCellNumberSecond = gCellNumberSecond.replaceAll("\\s+", " ").trim();
			if (gCellNumberSecond.matches("\\d*") && gCellNumberSecond.length() < 11) {
				return 0;
			} else if (gCellNumberSecond.length() < 2) {
				gCellNumberSecond = "";
				return 0;
			} else {
				return 401;
			}
		} else {
			gCellNumberSecond = "";
			return 0;
		}
	}

	public int validateGLandLine() {
		if ((!customerAge.equals("") && !customerAge.matches("[^\\d]+")) && Integer.parseInt(customerAge) < 16) {
			gLandLine = gLandLine.replaceAll("\\s+", " ").trim();
			if (gLandLine.matches("\\d*") && gLandLine.length() < 11) {
				return 0;
			} else if (gLandLine.length() < 2) {
				gLandLine = "";
				return 0;
			} else {
				return 411;
			}
		} else {
			gLandLine = "";
			return 0;
		}
	}

	public int anyGNumber() {
		if ((!customerAge.equals("") && !customerAge.matches("[^\\d]+")) && Integer.parseInt(customerAge) < 16) {
			if (gCellNumberFirst.equals("") && gCellNumberSecond.equals("") && gLandLine.equals("")) {
				return 421;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

	public int validateGEmail() {
		if ((!customerAge.equals("") && !customerAge.matches("[^\\d]+")) && Integer.parseInt(customerAge) < 16) {
			gEmailId = gEmailId.replaceAll("\\s+", " ").trim();
			if (gEmailId.matches("\\w+@\\w+\\.com")) {
				return 0;
			} else if (gEmailId.length() < 1) {
				gEmailId = "";
				return 0;
			} else {
				return 431;
			}
		} else {
			gEmailId = "";
			return 0;
		}
	}

	public int validateGDistrictPerm() {
		if ((!customerAge.equals("") && !customerAge.matches("[^\\d]+")) && Integer.parseInt(customerAge) < 16) {
			gPermDistrict = gPermDistrict.replaceAll("\\s+", " ").trim();
			gPermDistrict = WordUtils.capitalizeFully(gPermDistrict);
			if (gPermDistrict.length() < 1) {
				return 441;
			} else if (gPermDistrict.matches("\\w+")) {
				return 0;
			} else {
				return 442;
			}
		} else {
			gPermDistrict = "";
			return 0;
		}
	}

	public int validateGVMpPerm() {
		if ((!customerAge.equals("") && !customerAge.matches("[^\\d]+")) && Integer.parseInt(customerAge) < 16) {
			gPermVdcMunicipality = gPermVdcMunicipality.replaceAll("\\s+", " ").trim();
			gPermVdcMunicipality = WordUtils.capitalizeFully(gPermVdcMunicipality);
			if (gPermVdcMunicipality.matches("([^\\W]+\\s?-{1}\\s?[^\\W]*|[^\\W]+)")) {
				return 0;
			} else if (gPermVdcMunicipality.length() < 1) {
				return 451;
			} else {
				return 452;
			}
		} else {
			gPermVdcMunicipality = "";
			return 0;
		}
	}

	public int validateGPermExtra() {
		if ((!customerAge.equals("") && !customerAge.matches("[^\\d]+")) && Integer.parseInt(customerAge) < 16) {
			gPermExtraInfo = gPermExtraInfo.replaceAll("\\s+", " ").trim();
			gPermExtraInfo = WordUtils.capitalizeFully(gPermExtraInfo);
			if (gPermExtraInfo.length() < 1) {
				gPermExtraInfo = "";
				return 0;
			} else if (gPermExtraInfo.matches("[^\\W]+")) {
				return 0;
			} else {
				return 461;
			}
		} else {
			gPermExtraInfo = "";
			return 0;
		}
	}

	public int validateGTempDistrict() {
		if ((!customerAge.equals("") && !customerAge.matches("[^\\d]+")) && Integer.parseInt(customerAge) < 16) {
			gTempDistrict = gTempDistrict.replaceAll("\\s+", " ").trim();
			gTempDistrict = WordUtils.capitalizeFully(gTempDistrict);
			if (gTempDistrict.length() < 1) {
				gTempDistrict = "";
				return 0;
			} else if (gTempDistrict.matches("\\w+")) {
				return 0;
			} else {
				return 471;
			}
		} else {
			gTempDistrict = "";
			return 0;
		}
	}

	public int validateGTempVMp() {
		if ((!customerAge.equals("") && !customerAge.matches("[^\\d]+")) && Integer.parseInt(customerAge) < 16) {
			gTempVdcMunicipality = gTempVdcMunicipality.replaceAll("\\s+", " ").trim();
			gTempVdcMunicipality = WordUtils.capitalizeFully(gTempVdcMunicipality);
			if (gTempDistrict.length() > 1 && gTempVdcMunicipality.matches("([^\\W]+\\s?-{1}\\s?[^\\W]*|[^\\W]+)")) {
				return 0;
			} else if (gTempVdcMunicipality.length() < 1 && gTempDistrict.length() < 1) {
				gTempVdcMunicipality = "";
				return 0;
			} else if (gTempDistrict.length() > 1 && gTempVdcMunicipality.length() < 1) {
				return 481;
			} else if (gTempDistrict.length() < 1 && gTempVdcMunicipality.length() > 1) {
				return 482;
			} else {
				return 483;
			}
		} else {
			gTempVdcMunicipality = "";
			return 0;
		}
	}

	public int validateGTempExtra() {
		if ((!customerAge.equals("") && !customerAge.matches("[^\\d]+")) && Integer.parseInt(customerAge) < 16) {
			gTempExtraInfo = gTempExtraInfo.replaceAll("\\s+", " ").trim();
			gTempExtraInfo = WordUtils.capitalizeFully(gTempExtraInfo);
			if (gTempExtraInfo.length() > 1 && gTempVdcMunicipality.length() > 1 && gTempDistrict.length() < 1) {
				gTempExtraInfo = "";
				return 0;
			} else if (gTempDistrict.length() > 1 && gTempVdcMunicipality.length() > 1
					&& gTempExtraInfo.matches(".*[!@#$%^&*()_+=-><,.;~`:\"\'].*")) {
				return 492;
			} else if (gTempDistrict.length() > 1 && gTempVdcMunicipality.length() > 1 && gTempExtraInfo.length() < 1) {
				tempExtrainfo = "";
				return 0;
			} else if (gTempDistrict.length() < 1 && gTempVdcMunicipality.length() < 1 && gTempExtraInfo.length() > 1) {
				return 491;
			} else if (gTempDistrict.length() < 1 && gTempVdcMunicipality.length() > 1 && gTempExtraInfo.length() < 1) {
				tempExtrainfo = "";
				return 0;
			} else
				if ((gTempDistrict.length() > 1 && gTempVdcMunicipality.length() < 1 && gTempExtraInfo.length() > 1)) {
				return 491;
			} else {
				return 0;
			}
		} else {
			gTempExtraInfo = "";
			return 0;
		}
	}

	public int validateAcCreation() {
		jDate = jDate.replaceAll("\\s+", " ").trim();
		if (jDate.length() < 1) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			Date dt = new Date();
			jDate = sdf.format(dt);
			return 0;
		} else if (jDate.matches("((19|20)\\d\\d)/(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])") || jDate.matches("((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])") ) {
			return 0;
		} else {
			return 501;
		}
	}

	public int validateReferredBy() {
		refferedBy = refferedBy.replaceAll("\\s+", " ").trim();
		refferedBy = WordUtils.capitalizeFully(refferedBy);
		if (refferedBy.length() < 1) {
			refferedBy = "";
			return 0;
		} else if (refferedBy.matches(".*[!@#$%^&*()_+=-><,.;~`:\"\'].*") || refferedBy.matches("^\\d+.*")) {
			return 511;
		} else {
			return 0;
		}
	}

	public int validateApprovedBy() {
		approvedBy = approvedBy.replaceAll("\\s+", " ").trim();
		approvedBy = WordUtils.capitalizeFully(approvedBy);
		if (approvedBy.length() < 1) {
			return 521;
		} else if (approvedBy.matches(".*[!@#$%^&*()_+=-><,.;~`:\"\'].*") || approvedBy.matches("^\\d+.*")|| approvedBy.matches(".*\\d+.*")) {
			return 522;
		} else {
			return 0;
		}
	}

}
