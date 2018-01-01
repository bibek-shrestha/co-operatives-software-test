package com.kjjcsoft.controllers;
import static com.kjjcsoft.controllers.DirectoryProvider.FINGER_PRINT_UPLOAD_DIRECTORY;
import static com.kjjcsoft.controllers.DirectoryProvider.MAX_FILE_SIZE;
import static com.kjjcsoft.controllers.DirectoryProvider.MAX_REQUEST_SIZE;
import static com.kjjcsoft.controllers.DirectoryProvider.MEMORY_THRESHOLD;
import static com.kjjcsoft.controllers.DirectoryProvider.PHOTO_UPLOAD_DIRECTORY;
import static com.kjjcsoft.controllers.DirectoryProvider.TMP;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.kjjcsoft.bean.CustomerBean;
import com.kjjcsoft.bean.RetrivedUserBean;
import com.kjjcsoft.model.Customer;
/**
 * Servlet implementation class ChangeCustomerInfo
 */
@WebServlet(description = "for changing the customeInfo", urlPatterns = {"/change"})
public class ChangeCustomerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeCustomerInfo() {
		super();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/changeInfo.jsp");
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("cancel") != null) {
			request.getSession().removeAttribute("storedInfo");
			response.sendRedirect("/KJJCSoft/com/kjjcsoft/controllers/edit");
			return;
		}
		if (request.getParameter("finish") != null) {
			CustomerBean applicantInfo = new CustomerBean();
			RetrivedUserBean ses_user = new RetrivedUserBean();
			ses_user = (RetrivedUserBean) request.getSession().getAttribute("Userinfo");
			Customer customerdbo = new Customer();
			boolean isError = false;
			applicantInfo.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
			applicantInfo.setCustomerName(request.getParameter("fullname"));
			applicantInfo.setCustomerAge(request.getParameter("age"));
			applicantInfo.setDob(request.getParameter("dob"));
			applicantInfo.setGender(request.getParameter("gender"));
			applicantInfo.setNationality(request.getParameter("nationality"));
			applicantInfo.setCitizenShipNo(request.getParameter("citizenship_no"));
			applicantInfo.setMaritalStatus(request.getParameter("marital_status"));
			applicantInfo.setSpouseName(request.getParameter("spouse_name"));
			applicantInfo.setOccupation(request.getParameter("occupation"));
			applicantInfo.setCellNumberFirst(request.getParameter("cellnumber_first"));
			applicantInfo.setCellNumberSecond(request.getParameter("cellnumber_second"));
			applicantInfo.setLandLine(request.getParameter("landline"));
			applicantInfo.setEmailId(request.getParameter("customer_email"));
			applicantInfo.setPermDistrict(request.getParameter("perm_dist"));
			applicantInfo.setPermVdcMunicipality(request.getParameter("perm_vdc_mp"));
			applicantInfo.setPermExtrainfo(request.getParameter("perm_other"));
			applicantInfo.setTempDistrict(request.getParameter("temp_dist"));
			applicantInfo.setTempVdcMunicipality(request.getParameter("temp_vdc_mp"));
			applicantInfo.setTempExtrainfo(request.getParameter("temp_other"));
			applicantInfo.setFathersName(request.getParameter("fathers_name"));
			applicantInfo.setGrandFathersName(request.getParameter("grandfathers_name"));
			applicantInfo.setFatherInLawsName(request.getParameter("father_in_law_name"));
			applicantInfo.setNomineesName(request.getParameter("nominee_name"));
			applicantInfo.setNomineeRelation(request.getParameter("nominee_relation"));
			applicantInfo.setnCellNumberFirst(request.getParameter("nominee_cell_first"));
			applicantInfo.setnCellNumberSecond(request.getParameter("nominee_cell_second"));
			applicantInfo.setnLandLine(request.getParameter("nominee_landline"));
			applicantInfo.setnEmailId(request.getParameter("nominee_email"));
			applicantInfo.setnPermDistrict(request.getParameter("n_perm_dist"));
			applicantInfo.setnPermVdcMunicipality(request.getParameter("n_perm_vdc_mp"));
			applicantInfo.setnPermExtraInfo(request.getParameter("n_perm_other"));
			applicantInfo.setnTempDistrict(request.getParameter("n_temp_dist"));
			applicantInfo.setnTempVdcMunicipality(request.getParameter("n_temp_vdc_mp"));
			applicantInfo.setnTempExtraInfo(request.getParameter("n_temp_other"));
			applicantInfo.setGuardianName(request.getParameter("guardian_name"));
			applicantInfo.setgRelation(request.getParameter("guardian_relation"));
			applicantInfo.setgCellNumberFirst(request.getParameter("guardian_cell_first"));
			applicantInfo.setgCellNumberSecond(request.getParameter("guardian_cell_second"));
			applicantInfo.setgLandLine(request.getParameter("guardian_landline"));
			applicantInfo.setgEmailId(request.getParameter("guardian_email"));
			applicantInfo.setgPermDistrict(request.getParameter("g_perm_dist"));
			applicantInfo.setgPermVdcMunicipality(request.getParameter("g_perm_vdc_mp"));
			applicantInfo.setgPermExtraInfo(request.getParameter("g_perm_other"));
			applicantInfo.setgTempDistrict(request.getParameter("g_temp_dist"));
			applicantInfo.setgTempVdcMunicipality(request.getParameter("g_temp_vdc_mp"));
			applicantInfo.setgTempExtraInfo(request.getParameter("g_temp_other"));
			applicantInfo.setjDate(request.getParameter("creation_date"));
			applicantInfo.setRefferedBy(request.getParameter("reffered_by"));
			applicantInfo.setApprovedBy(request.getParameter("approved_by"));
			applicantInfo.setEntryBy(ses_user.getUser_id());
			if (applicantInfo.validateCustomerName() > 0) {
				if (applicantInfo.validateCustomerName() == 11) {
					isError = true;
					request.setAttribute("errorfn", "*Please fill in the name.");
				} else if (applicantInfo.validateCustomerName() == 12) {
					isError = true;
					request.setAttribute("errorfn", "*Name should not contain any numbers or special characters.");
				}
			}
			if (applicantInfo.validateCustomerAge() > 0) {
				if (applicantInfo.validateCustomerAge() == 21) {
					isError = true;
					request.setAttribute("errora", "*Please fill in the age.");
				} else if (applicantInfo.validateCustomerAge() == 22) {
					isError = true;
					request.setAttribute("errora", "*Invalid Age entered.");
				}
			}
			if (applicantInfo.validatedob() > 0) {
				if (applicantInfo.validatedob() == 31) {
					isError = true;
					request.setAttribute("errordob", "*Please fill in the date of birth.");
				} else if (applicantInfo.validatedob() == 32) {
					isError = true;
					request.setAttribute("errordob", "*Invalid date format! Please enter the date in the format YYYY/MM/dd.");
				}
			}
			if (applicantInfo.validateGender() > 0) {
				if (applicantInfo.validateGender() == 41) {
					isError = true;
					request.setAttribute("errorg", "*Please select your gender.");
				}
			}
			if (applicantInfo.validateNationality() > 0) {
				if (applicantInfo.validateNationality() == 51) {
					isError = true;
					request.setAttribute("errorn", "*Please fill in the nationality.");
				} else if (applicantInfo.validateNationality() == 52) {
					isError = true;
					request.setAttribute("errorn", "*Nationality should not contain special characters and numbers.");
				}
			}
			if (applicantInfo.validateCitizenshipNo() > 0) {
				if (applicantInfo.validateCitizenshipNo() == 61) {
					isError = true;
					request.setAttribute("errorcs", "*Please fill in the citizenship number of the applicant.");
				} else if (applicantInfo.validateCitizenshipNo() == 62) {
					isError = true;
					request.setAttribute("errorcs", "*Citizenship number should only  contain digits.");
				}
			}
			if (applicantInfo.validateMaritalStatus() > 0) {
				if (applicantInfo.validateMaritalStatus() == 71) {
					isError = true;
					request.setAttribute("errorms", "*Please select one of the options.");
				}
			}
			if (applicantInfo.validateSpouseName() > 0) {
				if (applicantInfo.validateSpouseName() == 81) {
					isError = true;
					request.setAttribute("errorsn", "*Please fill in the spouse name.");
				} else if (applicantInfo.validateSpouseName() == 82) {
					isError = true;
					request.setAttribute("errorsn", "*Name should not contain any special characters or numbers.");
				}
			}
			if (applicantInfo.validateOccupation() > 0) {
				if (applicantInfo.validateOccupation() == 91) {
					isError = true;
					request.setAttribute("erroro", "*Please fill in the occupation.");
				} else if (applicantInfo.validateOccupation() == 92) {
					isError = true;
					request.setAttribute("erroro", "*Occupation name should not contain any special characters or digits.");
				}
			}
			if (applicantInfo.validateCellOne() > 0) {
				if (applicantInfo.validateCellOne() == 101) {
					isError = true;
					request.setAttribute("errorcn", "*Invaid phone number.");
				}
			}
			if (applicantInfo.validateCellTwo() > 0) {
				if (applicantInfo.validateCellTwo() == 111) {
					isError = true;
					request.setAttribute("errorcs", "*Invalid phone number.");
				}
			}
			if (applicantInfo.validateLandLine() > 0) {
				if (applicantInfo.validateLandLine() == 121) {
					isError = true;
					request.setAttribute("errorll", "*Invalid number.");
				}
			}
			if (applicantInfo.anyNumber() > 0) {
				if (applicantInfo.anyNumber() == 131) {
					isError = true;
					request.setAttribute("errorcn", "*At least one contact information is needed.");
				}
			}
			if (applicantInfo.validateEmail() > 0) {
				if (applicantInfo.validateEmail() == 141) {
					isError = true;
					request.setAttribute("erroreid", "*Invalid email address.");
				}
			}
			if (applicantInfo.validateDistrictPerm() > 0) {
				if (applicantInfo.validateDistrictPerm() == 151) {
					isError = true;
					request.setAttribute("errorpd", "*Please fill in the address.");
				} else if (applicantInfo.validateDistrictPerm() == 152) {
					isError = true;
					request.setAttribute("errorpd", "*District name should not contain special characters and digits.");
				}
			}
			if (applicantInfo.validateVMpPerm() > 0) {
				if (applicantInfo.validateVMpPerm() == 161) {
					isError = true;
					request.setAttribute("errorpvm", "*Please fill in the address.");
				} else if (applicantInfo.validateVMpPerm() == 162) {
					isError = true;
					request.setAttribute("errorpvm", "*This field shouldnot contain special characters.");
				}
			}
			if (applicantInfo.validatePermExtra() > 0) {
				if (applicantInfo.validatePermExtra() == 171) {
					isError = true;
					request.setAttribute("errorpe", "*This field should not contain special characters.");
				}
			}
			if (applicantInfo.validateTempDistrict() > 0) {
				if (applicantInfo.validateTempDistrict() == 181) {
					isError = true;
					request.setAttribute("errortd", "*District name should not contain special characters and digits.");
				}
			}
			if (applicantInfo.validateTempVMp() > 0) {
				if (applicantInfo.validateTempVMp() == 191) {
					isError = true;
					request.setAttribute("errortvm", "*Vdc or municipality needed.");
				} else if (applicantInfo.validateTempVMp() == 192) {
					isError = true;
					request.setAttribute("errortvm", "*Incomplete temporary address. Please fill in complete address.");
				} else if (applicantInfo.validateTempVMp() == 193) {
					isError = true;
					request.setAttribute("errortvm", "*Address should not contain special characters.");
				}
			}
			if (applicantInfo.validateTempExtra() > 0) {
				if (applicantInfo.validateTempExtra() == 201) {
					isError = true;
					request.setAttribute("errorte", "*Incomplete address. Please enter complete address.");
				} else if (applicantInfo.validateTempExtra() == 202) {
					isError = true;
					request.setAttribute("errorte", "*Address should not conatain special characters.");
				}
			}
			if (applicantInfo.validateFName() > 0) {
				if (applicantInfo.validateFName() == 211) {
					isError = true;
					request.setAttribute("errorf", "*Please fill in father's name.");
				} else if (applicantInfo.validateFName() == 212) {
					isError = true;
					request.setAttribute("errorf", "*Name should not contain special characters or digits.");
				}
			}
			if (applicantInfo.validateGFName() > 0) {
				if (applicantInfo.validateGFName() == 221) {
					isError = true;
					request.setAttribute("errorgfn", "*Please fill in grandfather's name.");
				} else if (applicantInfo.validateGFName() == 222) {
					isError = true;
					request.setAttribute("errorgfn", "*Name should not contain special characters or digits.");
				}
			}
			if (applicantInfo.validateFLName() > 0) {
				if (applicantInfo.validateFLName() == 231) {
					isError = true;
					request.setAttribute("errorfln", "*Please fill in father-in-law's name.");
				} else if (applicantInfo.validateFLName() == 232) {
					isError = true;
					request.setAttribute("errorfln", "*Name should not contain special characters and digits.");
				}
			}
			if (applicantInfo.validateNomineeName() > 0) {
				if (applicantInfo.validateNomineeName() == 241) {
					isError = true;
					request.setAttribute("errornn", "*Please fill in nominees name.");
				} else if (applicantInfo.validateNomineeName() == 242) {
					isError = true;
					request.setAttribute("errornn", "*Name shouldnot contain special characters or digits.");
				}
			}
			if (applicantInfo.validateNomineeRelation() > 0) {
				if (applicantInfo.validateNomineeRelation() == 251) {
					isError = true;
					request.setAttribute("errornr", "*Please fill in the relation of nominee.");
				} else if (applicantInfo.validateNomineeRelation() == 252) {
					isError = true;
					request.setAttribute("errornr", "*Should not contain special characters or digits.");
				}
			}
			if (applicantInfo.validateNCellOne() > 0) {
				if (applicantInfo.validateNCellOne() == 261) {
					isError = true;
					request.setAttribute("errorncf", "*Invalid phone number.");
				}
			}
			if (applicantInfo.validateNCellTwo() > 0) {
				if (applicantInfo.validateNCellTwo() == 271) {
					isError = true;
					request.setAttribute("errorncs", "*Invalid phone number.");
				}
			}
			if (applicantInfo.validateNLandLine() > 0) {
				if (applicantInfo.validateNLandLine() == 281) {
					isError = true;
					request.setAttribute("errornll", "*Invalid number.");
				}
			}
			if (applicantInfo.anyNNumber() > 0) {
				if (applicantInfo.anyNNumber() == 291) {
					isError = true;
					request.setAttribute("errorncf", "*At least one contact number is required.");
				}
			}
			if (applicantInfo.validateNEmail() > 0) {
				if (applicantInfo.validateNEmail() == 301) {
					isError = true;
					request.setAttribute("errorneid", "*Invalid email address.");
				}
			}
			if (applicantInfo.validateNDistrictPerm() > 0) {
				if (applicantInfo.validateNDistrictPerm() == 311) {
					isError = true;
					request.setAttribute("errornpd", "*Please fill in the district.");
				} else if (applicantInfo.validateNDistrictPerm() == 312) {
					isError = true;
					request.setAttribute("errornpd", "*District name should not contain special characters or numbers.");
				}
			}
			if (applicantInfo.validateNVMpPerm() > 0) {
				if (applicantInfo.validateNVMpPerm() == 321) {
					isError = true;
					request.setAttribute("errornpvm", "*Please fill in vdc or municipality.");
				} else if (applicantInfo.validateNVMpPerm() == 322) {
					isError = true;
					request.setAttribute("errornpvm", "*Vdc or Municipality name should not have special characters.");
				}
			}
			if (applicantInfo.validateNPermExtra() > 0) {
				if (applicantInfo.validateNPermExtra() == 331) {
					isError = true;
					request.setAttribute("errornpe", "*Address should not contain special characters.");
				}
			}
			if (applicantInfo.validateNTempDistrict() > 0) {
				if (applicantInfo.validateNTempDistrict() == 341) {
					isError = true;
					request.setAttribute("errorntd", "*Address should not contain special characters.");
				}
			}
			if (applicantInfo.validateNTempVMp() > 0) {
				if (applicantInfo.validateNTempVMp() == 351) {
					isError = true;
					request.setAttribute("errorntvm", "*Please enter VDC or municipality name.");
				} else if (applicantInfo.validateNTempVMp() == 352) {
					isError = true;
					request.setAttribute("errorntvm", "*Incomplete address. Please enter complete address.");
				} else if (applicantInfo.validateNTempVMp() == 353) {
					isError = true;
					request.setAttribute("errorntvm", "*Address should not conatain special characters.");
				}
			}
			if (applicantInfo.validateNTempExtra() > 0) {
				if (applicantInfo.validateNTempExtra() == 361) {
					isError = true;
					request.setAttribute("errornte", "*Incomplete address. Please enter complete address.");
				} else if (applicantInfo.validateNTempExtra() == 362) {
					isError = true;
					request.setAttribute("errornte", "*Address should not contain special characters.");
				}
			}
			if (applicantInfo.validateGuardianName() > 0) {
				if (applicantInfo.validateGuardianName() == 371) {
					isError = true;
					request.setAttribute("errorgn", "*Please fill in the guardian's name.");
				} else if (applicantInfo.validateGuardianName() == 372) {
					isError = true;
					request.setAttribute("errorgn", "*Name should not contain special characters or digits.");
				}
			}
			if (applicantInfo.validateGuardianRelation() > 0) {
				if (applicantInfo.validateGuardianRelation() == 381) {
					isError = true;
					request.setAttribute("errorgr", "*Please fill in the relation of the guardian.");
				} else if (applicantInfo.validateGuardianRelation() == 382) {
					isError = true;
					request.setAttribute("errorgr", "*Relation should not contain special characters or digits.");
				}
			}
			if (applicantInfo.validateGCellOne() > 0) {
				if (applicantInfo.validateGCellOne() == 391) {
					isError = true;
					request.setAttribute("errorgcf", "*Invalid phone number.");
				}
			}
			if (applicantInfo.validateGCellTwo() > 0) {
				if (applicantInfo.validateGCellTwo() == 401) {
					isError = true;
					request.setAttribute("errorgcs", "*Invalid phone number.");
				}
			}
			if (applicantInfo.validateGLandLine() > 0) {
				if (applicantInfo.validateGLandLine() == 411) {
					isError = true;
					request.setAttribute("errorgll", "*Invalid number.");
				}
			}
			if (applicantInfo.anyGNumber() > 0) {
				if (applicantInfo.anyGNumber() == 421) {
					isError = true;
					request.setAttribute("errorgcf", "*At least one contact number is required.");
				}
			}
			if (applicantInfo.validateGEmail() > 0) {
				if (applicantInfo.validateGEmail() == 431) {
					isError = true;
					request.setAttribute("errorgeid", "*Invalid email address.");
				}
			}
			if (applicantInfo.validateGDistrictPerm() > 0) {
				if (applicantInfo.validateGDistrictPerm() == 441) {
					isError = true;
					request.setAttribute("errorgpd", "*Please fill in the district.");
				} else if (applicantInfo.validateGDistrictPerm() == 442) {
					isError = true;
					request.setAttribute("errorgpd", "*District should not contain special characters and digits.");
				}
			}
			if (applicantInfo.validateGVMpPerm() > 0) {
				if (applicantInfo.validateGVMpPerm() == 451) {
					isError = true;
					request.setAttribute("errorgpvm", "*Please fill in the Vdc or Municipality.");
				} else if (applicantInfo.validateGVMpPerm() == 452) {
					isError = true;
					request.setAttribute("errorgpvm", "*Address should not contain special characters.");
				}
			}
			if (applicantInfo.validateGPermExtra() > 0) {
				if (applicantInfo.validateGPermExtra() == 461) {
					isError = true;
					request.setAttribute("errorgpe", "*Address should not contain special characters.");
				}
			}
			if (applicantInfo.validateGTempDistrict() > 0) {
				if (applicantInfo.validateGTempDistrict() == 471) {
					isError = true;
					request.setAttribute("errorgtd", "*Address should not contain special characters.");
				}
			}
			if (applicantInfo.validateGTempVMp() > 0) {
				if (applicantInfo.validateGTempVMp() == 481) {
					isError = true;
					request.setAttribute("errorgtvm", "*Please fill in the vdc or municipality.");
				} else if (applicantInfo.validateGTempVMp() == 482) {
					isError = true;
					request.setAttribute("errorgtvm", "*Incomplete address. Please enter complete address.");
				} else if (applicantInfo.validateGTempVMp() == 483) {
					isError = true;
					request.setAttribute("errorgtvm", "*Address should not contain special characters.");
				}
			}
			if (applicantInfo.validateGTempExtra() > 0) {
				if (applicantInfo.validateGTempExtra() == 491) {
					isError = true;
					request.setAttribute("errorgte", "*Incomplete address. Please enter complete address.");
				} else if (applicantInfo.validateGTempExtra() == 492) {
					isError = true;
					request.setAttribute("errorgte", "*Address should not contain special characters.");
				}
			}
			if (applicantInfo.validateAcCreation() > 0) {
				if (applicantInfo.validateAcCreation() == 501) {
					isError = true;
					request.setAttribute("errorcd", "*Invalid date format. Please fill date in the format YYYY/MM/dd.");
				}
			}
			if (applicantInfo.validateReferredBy() > 0) {
				if (applicantInfo.validateReferredBy() == 511) {
					isError = true;
					request.setAttribute("errorrb", "*Name should not contain special characters or digits.");
				}
			}
			if (applicantInfo.validateApprovedBy() > 0) {
				if (applicantInfo.validateApprovedBy() == 521) {
					isError = true;
					request.setAttribute("errorapb", "*Please fill in the name of the approver.");
				} else if (applicantInfo.validateApprovedBy() == 522) {
					isError = true;
					request.setAttribute("errorapb", "*Name should not contain special characters or digits.");
				}
			}
			if (!isError) {
				customerdbo.updateCustomerInfo(applicantInfo);
				request.getSession().removeAttribute("storedInfo");
				request.getSession().setAttribute("successMsg", "true");
				response.sendRedirect("/KJJCSoft/com/kjjcsoft/controllers/edit");
				return;
			}
		}
		if (request.getParameter("next") != null) {
			CustomerBean applicantInfo = new CustomerBean();
			RetrivedUserBean ses_user = new RetrivedUserBean();
			ses_user = (RetrivedUserBean) request.getSession().getAttribute("Userinfo");
			Customer customerdbo = new Customer();
			boolean isError = false;
			applicantInfo.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
			applicantInfo.setCustomerName(request.getParameter("fullname"));
			applicantInfo.setCustomerAge(request.getParameter("age"));
			applicantInfo.setDob(request.getParameter("dob"));
			applicantInfo.setGender(request.getParameter("gender"));
			applicantInfo.setNationality(request.getParameter("nationality"));
			applicantInfo.setCitizenShipNo(request.getParameter("citizenship_no"));
			applicantInfo.setMaritalStatus(request.getParameter("marital_status"));
			applicantInfo.setSpouseName(request.getParameter("spouse_name"));
			applicantInfo.setOccupation(request.getParameter("occupation"));
			applicantInfo.setCellNumberFirst(request.getParameter("cellnumber_first"));
			applicantInfo.setCellNumberSecond(request.getParameter("cellnumber_second"));
			applicantInfo.setLandLine(request.getParameter("landline"));
			applicantInfo.setEmailId(request.getParameter("customer_email"));
			applicantInfo.setPermDistrict(request.getParameter("perm_dist"));
			applicantInfo.setPermVdcMunicipality(request.getParameter("perm_vdc_mp"));
			applicantInfo.setPermExtrainfo(request.getParameter("perm_other"));
			applicantInfo.setTempDistrict(request.getParameter("temp_dist"));
			applicantInfo.setTempVdcMunicipality(request.getParameter("temp_vdc_mp"));
			applicantInfo.setTempExtrainfo(request.getParameter("temp_other"));
			applicantInfo.setFathersName(request.getParameter("fathers_name"));
			applicantInfo.setGrandFathersName(request.getParameter("grandfathers_name"));
			applicantInfo.setFatherInLawsName(request.getParameter("father_in_law_name"));
			applicantInfo.setNomineesName(request.getParameter("nominee_name"));
			applicantInfo.setNomineeRelation(request.getParameter("nominee_relation"));
			applicantInfo.setnCellNumberFirst(request.getParameter("nominee_cell_first"));
			applicantInfo.setnCellNumberSecond(request.getParameter("nominee_cell_second"));
			applicantInfo.setnLandLine(request.getParameter("nominee_landline"));
			applicantInfo.setnEmailId(request.getParameter("nominee_email"));
			applicantInfo.setnPermDistrict(request.getParameter("n_perm_dist"));
			applicantInfo.setnPermVdcMunicipality(request.getParameter("n_perm_vdc_mp"));
			applicantInfo.setnPermExtraInfo(request.getParameter("n_perm_other"));
			applicantInfo.setnTempDistrict(request.getParameter("n_temp_dist"));
			applicantInfo.setnTempVdcMunicipality(request.getParameter("n_temp_vdc_mp"));
			applicantInfo.setnTempExtraInfo(request.getParameter("n_temp_other"));
			applicantInfo.setGuardianName(request.getParameter("guardian_name"));
			applicantInfo.setgRelation(request.getParameter("guardian_relation"));
			applicantInfo.setgCellNumberFirst(request.getParameter("guardian_cell_first"));
			applicantInfo.setgCellNumberSecond(request.getParameter("guardian_cell_second"));
			applicantInfo.setgLandLine(request.getParameter("guardian_landline"));
			applicantInfo.setgEmailId(request.getParameter("guardian_email"));
			applicantInfo.setgPermDistrict(request.getParameter("g_perm_dist"));
			applicantInfo.setgPermVdcMunicipality(request.getParameter("g_perm_vdc_mp"));
			applicantInfo.setgPermExtraInfo(request.getParameter("g_perm_other"));
			applicantInfo.setgTempDistrict(request.getParameter("g_temp_dist"));
			applicantInfo.setgTempVdcMunicipality(request.getParameter("g_temp_vdc_mp"));
			applicantInfo.setgTempExtraInfo(request.getParameter("g_temp_other"));
			applicantInfo.setjDate(request.getParameter("creation_date"));
			applicantInfo.setRefferedBy(request.getParameter("reffered_by"));
			applicantInfo.setApprovedBy(request.getParameter("approved_by"));
			applicantInfo.setEntryBy(ses_user.getUser_id());
			if (applicantInfo.validateCustomerName() > 0) {
				if (applicantInfo.validateCustomerName() == 11) {
					isError = true;
					request.setAttribute("errorfn", "*Please fill in the name.");
				} else if (applicantInfo.validateCustomerName() == 12) {
					isError = true;
					request.setAttribute("errorfn", "*Name should not contain any numbers or special characters.");
				}
			}
			if (applicantInfo.validateCustomerAge() > 0) {
				if (applicantInfo.validateCustomerAge() == 21) {
					isError = true;
					request.setAttribute("errora", "*Please fill in the age.");
				} else if (applicantInfo.validateCustomerAge() == 22) {
					isError = true;
					request.setAttribute("errora", "*Invalid Age entered.");
				}
			}
			if (applicantInfo.validatedob() > 0) {
				if (applicantInfo.validatedob() == 31) {
					isError = true;
					request.setAttribute("errordob", "*Please fill in the date of birth.");
				} else if (applicantInfo.validatedob() == 32) {
					isError = true;
					request.setAttribute("errordob", "*Invalid date format! Please enter the date in the format YYYY/MM/dd.");
				}
			}
			if (applicantInfo.validateGender() > 0) {
				if (applicantInfo.validateGender() == 41) {
					isError = true;
					request.setAttribute("errorg", "*Please select your gender.");
				}
			}
			if (applicantInfo.validateNationality() > 0) {
				if (applicantInfo.validateNationality() == 51) {
					isError = true;
					request.setAttribute("errorn", "*Please fill in the nationality.");
				} else if (applicantInfo.validateNationality() == 52) {
					isError = true;
					request.setAttribute("errorn", "*Nationality should not contain special characters and numbers.");
				}
			}
			if (applicantInfo.validateCitizenshipNo() > 0) {
				if (applicantInfo.validateCitizenshipNo() == 61) {
					isError = true;
					request.setAttribute("errorcs", "*Please fill in the citizenship number of the applicant.");
				} else if (applicantInfo.validateCitizenshipNo() == 62) {
					isError = true;
					request.setAttribute("errorcs", "*Citizenship number should only  contain digits.");
				}
			}
			if (applicantInfo.validateMaritalStatus() > 0) {
				if (applicantInfo.validateMaritalStatus() == 71) {
					isError = true;
					request.setAttribute("errorms", "*Please select one of the options.");
				}
			}
			if (applicantInfo.validateSpouseName() > 0) {
				if (applicantInfo.validateSpouseName() == 81) {
					isError = true;
					request.setAttribute("errorsn", "*Please fill in the spouse name.");
				} else if (applicantInfo.validateSpouseName() == 82) {
					isError = true;
					request.setAttribute("errorsn", "*Name should not contain any special characters or numbers.");
				}
			}
			if (applicantInfo.validateOccupation() > 0) {
				if (applicantInfo.validateOccupation() == 91) {
					isError = true;
					request.setAttribute("erroro", "*Please fill in the occupation.");
				} else if (applicantInfo.validateOccupation() == 92) {
					isError = true;
					request.setAttribute("erroro", "*Occupation name should not contain any special characters or digits.");
				}
			}
			if (applicantInfo.validateCellOne() > 0) {
				if (applicantInfo.validateCellOne() == 101) {
					isError = true;
					request.setAttribute("errorcn", "*Invaid phone number.");
				}
			}
			if (applicantInfo.validateCellTwo() > 0) {
				if (applicantInfo.validateCellTwo() == 111) {
					isError = true;
					request.setAttribute("errorcs", "*Invalid phone number.");
				}
			}
			if (applicantInfo.validateLandLine() > 0) {
				if (applicantInfo.validateLandLine() == 121) {
					isError = true;
					request.setAttribute("errorll", "*Invalid number.");
				}
			}
			if (applicantInfo.anyNumber() > 0) {
				if (applicantInfo.anyNumber() == 131) {
					isError = true;
					request.setAttribute("errorcn", "*At least one contact information is needed.");
				}
			}
			if (applicantInfo.validateEmail() > 0) {
				if (applicantInfo.validateEmail() == 141) {
					isError = true;
					request.setAttribute("erroreid", "*Invalid email address.");
				}
			}
			if (applicantInfo.validateDistrictPerm() > 0) {
				if (applicantInfo.validateDistrictPerm() == 151) {
					isError = true;
					request.setAttribute("errorpd", "*Please fill in the address.");
				} else if (applicantInfo.validateDistrictPerm() == 152) {
					isError = true;
					request.setAttribute("errorpd", "*District name should not contain special characters and digits.");
				}
			}
			if (applicantInfo.validateVMpPerm() > 0) {
				if (applicantInfo.validateVMpPerm() == 161) {
					isError = true;
					request.setAttribute("errorpvm", "*Please fill in the address.");
				} else if (applicantInfo.validateVMpPerm() == 162) {
					isError = true;
					request.setAttribute("errorpvm", "*This field shouldnot contain special characters.");
				}
			}
			if (applicantInfo.validatePermExtra() > 0) {
				if (applicantInfo.validatePermExtra() == 171) {
					isError = true;
					request.setAttribute("errorpe", "*This field should not contain special characters.");
				}
			}
			if (applicantInfo.validateTempDistrict() > 0) {
				if (applicantInfo.validateTempDistrict() == 181) {
					isError = true;
					request.setAttribute("errortd", "*District name should not contain special characters and digits.");
				}
			}
			if (applicantInfo.validateTempVMp() > 0) {
				if (applicantInfo.validateTempVMp() == 191) {
					isError = true;
					request.setAttribute("errortvm", "*Vdc or municipality needed.");
				} else if (applicantInfo.validateTempVMp() == 192) {
					isError = true;
					request.setAttribute("errortvm", "*Incomplete temporary address. Please fill in complete address.");
				} else if (applicantInfo.validateTempVMp() == 193) {
					isError = true;
					request.setAttribute("errortvm", "*Address should not contain special characters.");
				}
			}
			if (applicantInfo.validateTempExtra() > 0) {
				if (applicantInfo.validateTempExtra() == 201) {
					isError = true;
					request.setAttribute("errorte", "*Incomplete address. Please enter complete address.");
				} else if (applicantInfo.validateTempExtra() == 202) {
					isError = true;
					request.setAttribute("errorte", "*Address should not conatain special characters.");
				}
			}
			if (applicantInfo.validateFName() > 0) {
				if (applicantInfo.validateFName() == 211) {
					isError = true;
					request.setAttribute("errorf", "*Please fill in father's name.");
				} else if (applicantInfo.validateFName() == 212) {
					isError = true;
					request.setAttribute("errorf", "*Name should not contain special characters or digits.");
				}
			}
			if (applicantInfo.validateGFName() > 0) {
				if (applicantInfo.validateGFName() == 221) {
					isError = true;
					request.setAttribute("errorgfn", "*Please fill in grandfather's name.");
				} else if (applicantInfo.validateGFName() == 222) {
					isError = true;
					request.setAttribute("errorgfn", "*Name should not contain special characters or digits.");
				}
			}
			if (applicantInfo.validateFLName() > 0) {
				if (applicantInfo.validateFLName() == 231) {
					isError = true;
					request.setAttribute("errorfln", "*Please fill in father-in-law's name.");
				} else if (applicantInfo.validateFLName() == 232) {
					isError = true;
					request.setAttribute("errorfln", "*Name should not contain special characters and digits.");
				}
			}
			if (applicantInfo.validateNomineeName() > 0) {
				if (applicantInfo.validateNomineeName() == 241) {
					isError = true;
					request.setAttribute("errornn", "*Please fill in nominees name.");
				} else if (applicantInfo.validateNomineeName() == 242) {
					isError = true;
					request.setAttribute("errornn", "*Name shouldnot contain special characters or digits.");
				}
			}
			if (applicantInfo.validateNomineeRelation() > 0) {
				if (applicantInfo.validateNomineeRelation() == 251) {
					isError = true;
					request.setAttribute("errornr", "*Please fill in the relation of nominee.");
				} else if (applicantInfo.validateNomineeRelation() == 252) {
					isError = true;
					request.setAttribute("errornr", "*Should not contain special characters or digits.");
				}
			}
			if (applicantInfo.validateNCellOne() > 0) {
				if (applicantInfo.validateNCellOne() == 261) {
					isError = true;
					request.setAttribute("errorncf", "*Invalid phone number.");
				}
			}
			if (applicantInfo.validateNCellTwo() > 0) {
				if (applicantInfo.validateNCellTwo() == 271) {
					isError = true;
					request.setAttribute("errorncs", "*Invalid phone number.");
				}
			}
			if (applicantInfo.validateNLandLine() > 0) {
				if (applicantInfo.validateNLandLine() == 281) {
					isError = true;
					request.setAttribute("errornll", "*Invalid number.");
				}
			}
			if (applicantInfo.anyNNumber() > 0) {
				if (applicantInfo.anyNNumber() == 291) {
					isError = true;
					request.setAttribute("errorncf", "*At least one contact number is required.");
				}
			}
			if (applicantInfo.validateNEmail() > 0) {
				if (applicantInfo.validateNEmail() == 301) {
					isError = true;
					request.setAttribute("errorneid", "*Invalid email address.");
				}
			}
			if (applicantInfo.validateNDistrictPerm() > 0) {
				if (applicantInfo.validateNDistrictPerm() == 311) {
					isError = true;
					request.setAttribute("errornpd", "*Please fill in the district.");
				} else if (applicantInfo.validateNDistrictPerm() == 312) {
					isError = true;
					request.setAttribute("errornpd", "*District name should not contain special characters or numbers.");
				}
			}
			if (applicantInfo.validateNVMpPerm() > 0) {
				if (applicantInfo.validateNVMpPerm() == 321) {
					isError = true;
					request.setAttribute("errornpvm", "*Please fill in vdc or municipality.");
				} else if (applicantInfo.validateNVMpPerm() == 322) {
					isError = true;
					request.setAttribute("errornpvm", "*Vdc or Municipality name should not have special characters.");
				}
			}
			if (applicantInfo.validateNPermExtra() > 0) {
				if (applicantInfo.validateNPermExtra() == 331) {
					isError = true;
					request.setAttribute("errornpe", "*Address should not contain special characters.");
				}
			}
			if (applicantInfo.validateNTempDistrict() > 0) {
				if (applicantInfo.validateNTempDistrict() == 341) {
					isError = true;
					request.setAttribute("errorntd", "*Address should not contain special characters.");
				}
			}
			if (applicantInfo.validateNTempVMp() > 0) {
				if (applicantInfo.validateNTempVMp() == 351) {
					isError = true;
					request.setAttribute("errorntvm", "*Please enter VDC or municipality name.");
				} else if (applicantInfo.validateNTempVMp() == 352) {
					isError = true;
					request.setAttribute("errorntvm", "*Incomplete address. Please enter complete address.");
				} else if (applicantInfo.validateNTempVMp() == 353) {
					isError = true;
					request.setAttribute("errorntvm", "*Address should not conatain special characters.");
				}
			}
			if (applicantInfo.validateNTempExtra() > 0) {
				if (applicantInfo.validateNTempExtra() == 361) {
					isError = true;
					request.setAttribute("errornte", "*Incomplete address. Please enter complete address.");
				} else if (applicantInfo.validateNTempExtra() == 362) {
					isError = true;
					request.setAttribute("errornte", "*Address should not contain special characters.");
				}
			}
			if (applicantInfo.validateGuardianName() > 0) {
				if (applicantInfo.validateGuardianName() == 371) {
					isError = true;
					request.setAttribute("errorgn", "*Please fill in the guardian's name.");
				} else if (applicantInfo.validateGuardianName() == 372) {
					isError = true;
					request.setAttribute("errorgn", "*Name should not contain special characters or digits.");
				}
			}
			if (applicantInfo.validateGuardianRelation() > 0) {
				if (applicantInfo.validateGuardianRelation() == 381) {
					isError = true;
					request.setAttribute("errorgr", "*Please fill in the relation of the guardian.");
				} else if (applicantInfo.validateGuardianRelation() == 382) {
					isError = true;
					request.setAttribute("errorgr", "*Relation should not contain special characters or digits.");
				}
			}
			if (applicantInfo.validateGCellOne() > 0) {
				if (applicantInfo.validateGCellOne() == 391) {
					isError = true;
					request.setAttribute("errorgcf", "*Invalid phone number.");
				}
			}
			if (applicantInfo.validateGCellTwo() > 0) {
				if (applicantInfo.validateGCellTwo() == 401) {
					isError = true;
					request.setAttribute("errorgcs", "*Invalid phone number.");
				}
			}
			if (applicantInfo.validateGLandLine() > 0) {
				if (applicantInfo.validateGLandLine() == 411) {
					isError = true;
					request.setAttribute("errorgll", "*Invalid number.");
				}
			}
			if (applicantInfo.anyGNumber() > 0) {
				if (applicantInfo.anyGNumber() == 421) {
					isError = true;
					request.setAttribute("errorgcf", "*At least one contact number is required.");
				}
			}
			if (applicantInfo.validateGEmail() > 0) {
				if (applicantInfo.validateGEmail() == 431) {
					isError = true;
					request.setAttribute("errorgeid", "*Invalid email address.");
				}
			}
			if (applicantInfo.validateGDistrictPerm() > 0) {
				if (applicantInfo.validateGDistrictPerm() == 441) {
					isError = true;
					request.setAttribute("errorgpd", "*Please fill in the district.");
				} else if (applicantInfo.validateGDistrictPerm() == 442) {
					isError = true;
					request.setAttribute("errorgpd", "*District should not contain special characters and digits.");
				}
			}
			if (applicantInfo.validateGVMpPerm() > 0) {
				if (applicantInfo.validateGVMpPerm() == 451) {
					isError = true;
					request.setAttribute("errorgpvm", "*Please fill in the Vdc or Municipality.");
				} else if (applicantInfo.validateGVMpPerm() == 452) {
					isError = true;
					request.setAttribute("errorgpvm", "*Address should not contain special characters.");
				}
			}
			if (applicantInfo.validateGPermExtra() > 0) {
				if (applicantInfo.validateGPermExtra() == 461) {
					isError = true;
					request.setAttribute("errorgpe", "*Address should not contain special characters.");
				}
			}
			if (applicantInfo.validateGTempDistrict() > 0) {
				if (applicantInfo.validateGTempDistrict() == 471) {
					isError = true;
					request.setAttribute("errorgtd", "*Address should not contain special characters.");
				}
			}
			if (applicantInfo.validateGTempVMp() > 0) {
				if (applicantInfo.validateGTempVMp() == 481) {
					isError = true;
					request.setAttribute("errorgtvm", "*Please fill in the vdc or municipality.");
				} else if (applicantInfo.validateGTempVMp() == 482) {
					isError = true;
					request.setAttribute("errorgtvm", "*Incomplete address. Please enter complete address.");
				} else if (applicantInfo.validateGTempVMp() == 483) {
					isError = true;
					request.setAttribute("errorgtvm", "*Address should not contain special characters.");
				}
			}
			if (applicantInfo.validateGTempExtra() > 0) {
				if (applicantInfo.validateGTempExtra() == 491) {
					isError = true;
					request.setAttribute("errorgte", "*Incomplete address. Please enter complete address.");
				} else if (applicantInfo.validateGTempExtra() == 492) {
					isError = true;
					request.setAttribute("errorgte", "*Address should not contain special characters.");
				}
			}
			if (applicantInfo.validateAcCreation() > 0) {
				if (applicantInfo.validateAcCreation() == 501) {
					isError = true;
					request.setAttribute("errorcd", "*Invalid date format. Please fill date in the format YYYY/MM/dd.");
				}
			}
			if (applicantInfo.validateReferredBy() > 0) {
				if (applicantInfo.validateReferredBy() == 511) {
					isError = true;
					request.setAttribute("errorrb", "*Name should not contain special characters or digits.");
				}
			}
			if (applicantInfo.validateApprovedBy() > 0) {
				if (applicantInfo.validateApprovedBy() == 521) {
					isError = true;
					request.setAttribute("errorapb", "*Please fill in the name of the approver.");
				} else if (applicantInfo.validateApprovedBy() == 522) {
					isError = true;
					request.setAttribute("errorapb", "*Name should not contain special characters or digits.");
				}
			}
			if (!isError) {
				customerdbo.updateCustomerInfo(applicantInfo);
				getServletContext().getRequestDispatcher("/view/editUploads.jsp").forward(request, response);
				return;
			}
		}
			if (request.getContentType() != null && request.getContentType().indexOf("multipart/form-data") >= 0) {
				String relativeUploadPath = getServletConfig().getServletContext().getRealPath("/") + "upload/";
				String contentType = request.getContentType();
				Customer customerdbo = new Customer();
				String photoUpPath;
				String fingerPrintUpPath;
				File customerFile = null, fingerprintFile = null;
				CustomerBean applicantInfo = new CustomerBean();
				CustomerBean storedInfo = new CustomerBean();
				storedInfo = (CustomerBean)request.getSession().getAttribute("storedInfo");
				boolean isError = false;
				boolean edited = false;
				Random numberGenerator = new Random();
				/* Starting to process the data from the form */
				if (contentType.indexOf("multipart/form-data") >= 0) {
					/* creating a factory for disk-based file items */
					DiskFileItemFactory factory = new DiskFileItemFactory();
					/*
					 * Defining the threshhold size of the file that will be
					 * kept in memory
					 */
					factory.setSizeThreshold(MEMORY_THRESHOLD);
					/*
					 * defining directory to temporary store file which are
					 * larger than the threshhold memory
					 */
					factory.setRepository(new File(relativeUploadPath + TMP));
					/* creating a file upload handler */
					ServletFileUpload upload = new ServletFileUpload(factory);
					/*
					 * defining the maximum size of the file that can be
					 * uploaded to the form
					 */
					upload.setFileSizeMax(MAX_FILE_SIZE);
					/*
					 * defining the maximum size of the request(form-data+upload
					 * file)
					 */
					upload.setFileSizeMax(MAX_REQUEST_SIZE);
					/*
					 * defining the path for the directory to upload the
					 * customer photo
					 */
					photoUpPath = relativeUploadPath + PHOTO_UPLOAD_DIRECTORY;
					/*
					 * defining the path for the directory to upload the finger
					 * print of the customers
					 */
					fingerPrintUpPath = relativeUploadPath + FINGER_PRINT_UPLOAD_DIRECTORY;
					try {
						// parse the request objects content to extract the file
						// data
						List<FileItem> formItems = upload.parseRequest(request);
						Iterator<FileItem> itr = formItems.iterator();
						while (itr.hasNext()) {
							FileItem item = (FileItem) itr.next();
							if (!item.isFormField()) {
								String fieldName = item.getFieldName();
								if (fieldName.equals("upload_photo")) {
									if (item.getName().equals("") || item.getName() == null) {
										applicantInfo.setPhotoPath(storedInfo.getPhotoPath());
									} else {
										String fileName = item.getName();
										String mimeType = getServletContext().getMimeType(fileName);
										if (mimeType.startsWith("image/")) {
											if (fileName.lastIndexOf("\\") > 0) {
												customerFile = new File(photoUpPath + File.separator + fileName.substring(fileName.lastIndexOf("\\") + 1));
												if (customerFile.exists()) {
													while (customerFile.exists()) {
														customerFile = new File(photoUpPath + File.separator + numberGenerator.nextInt(1000) + fileName.substring(fileName.lastIndexOf("\\") + 1));
													}
													String nameTosave = customerFile.getName();
													applicantInfo.setPhotoPath(PHOTO_UPLOAD_DIRECTORY + nameTosave);
												} else {
													applicantInfo.setPhotoPath(PHOTO_UPLOAD_DIRECTORY + fileName.substring(fileName.lastIndexOf("\\") + 1));
												}
											} else {
												customerFile = new File(photoUpPath + File.separator + fileName.substring(fileName.lastIndexOf("\\") + 1));
												if (customerFile.exists()) {
													while (customerFile.exists()) {
														customerFile = new File(photoUpPath + File.separator + numberGenerator.nextInt(1000) + fileName.substring(fileName.lastIndexOf("\\") + 1));
													}
													String nameTosave = customerFile.getName();
													applicantInfo.setPhotoPath(PHOTO_UPLOAD_DIRECTORY + nameTosave);
												} else {
													applicantInfo.setPhotoPath(PHOTO_UPLOAD_DIRECTORY + fileName.substring(fileName.lastIndexOf("\\") + 1));
												}
											}
										} else {
											isError = true;
											request.setAttribute("errorp", "*Selected file is not an image file");
										}
										item.write(customerFile);
										edited = true;
									}
								}
								if (fieldName.equals("upload_fingerprints")) {
									if (item.getName().equals("") || item.getName() == null) {
										applicantInfo.setFingerPrintPath(storedInfo.getFingerPrintPath());
									} else {
										String fileName = item.getName();
										String mimeType = getServletContext().getMimeType(fileName);
										if (mimeType.startsWith("image/")) {
											if (fileName.lastIndexOf("\\") > 0) {
												fingerprintFile = new File(fingerPrintUpPath + fileName.substring(fileName.lastIndexOf("\\") + 1));
												if (fingerprintFile.exists()) {
													while (fingerprintFile.exists()) {
														fingerprintFile = new File(fingerPrintUpPath + File.separator + numberGenerator.nextInt(1000) + fileName.substring(fileName.lastIndexOf("\\")
																+ 1));
													}
													String nameTosave = fingerprintFile.getName();
													applicantInfo.setFingerPrintPath(FINGER_PRINT_UPLOAD_DIRECTORY + nameTosave);
												} else {
													applicantInfo.setFingerPrintPath(FINGER_PRINT_UPLOAD_DIRECTORY + fileName.substring(fileName.lastIndexOf("\\") + 1));
												}
											} else {
												fingerprintFile = new File(fingerPrintUpPath + fileName.substring(fileName.lastIndexOf("\\") + 1));
												if (fingerprintFile.exists()) {
													while (fingerprintFile.exists()) {
														fingerprintFile = new File(fingerPrintUpPath + File.separator + numberGenerator.nextInt(1000) + fileName.substring(fileName.lastIndexOf("\\")
																+ 1));
													}
													String nameTosave = fingerprintFile.getName();
													applicantInfo.setFingerPrintPath(FINGER_PRINT_UPLOAD_DIRECTORY + nameTosave);
												} else {
													applicantInfo.setFingerPrintPath(FINGER_PRINT_UPLOAD_DIRECTORY + fileName.substring(fileName.lastIndexOf("\\") + 1));
												}
											}
										} else {
											isError = true;
											request.setAttribute("errorfp", "*Selected file is not an image file");
											return;
										}
										item.write(fingerprintFile);
										edited = true;
									}
								}
							}
						}
					} catch (Exception ex) {
						System.out.println(ex);
					}
					applicantInfo.setCustomerId(storedInfo.getCustomerId());
				}
				if (!isError && edited == true) {
					if(customerdbo.changeCredentials(applicantInfo)){
						request.getSession().removeAttribute("storedInfo");
						request.getSession().setAttribute("successMsg", "true");
						response.sendRedirect("/KJJCSoft/com/kjjcsoft/controllers/edit");
						return;
					}
					
				} else if (!isError && edited == false){	
					request.getSession().removeAttribute("storedInfo");
					request.getSession().setAttribute("successMsg", "true");
					response.sendRedirect("/KJJCSoft/com/kjjcsoft/controllers/edit");
					return;
				}
			}
		doGet(request, response);
	}
}
