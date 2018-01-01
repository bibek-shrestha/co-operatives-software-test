/**
 * 
 */
package com.kjjcsoft.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kjjcsoft.bean.CustomerBean;
/**
 * @author Seekraw
 */
public class Customer {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private ResultSet rsNext = null;
	public Customer() {
		con = null;
		ps = null;
		rs = null;
	}
	public boolean registerCustomer(CustomerBean paramIn) {
		boolean customerCreated = false;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(
					"INSERT into tbl_customer (customer_name, customer_age, customer_gender, customer_dob, customer_nationality, customer_citizenshipno, customer_perm_district, customer_perm_vdc_municipality, customer_perm_extrainfo, customer_temp_district, customer_temp_vdc_municipality, customer_temp_extrainfo, customer_cell_number_first, customer_cell_number_second, customer_landline, customer_email, customer_marital_status, customer_spouse_name, customer_occupation, customer_father_name, customer_grandfather_name, customer_father_in_law_name, nominee_name, nominee_relation, nominee_perm_district, nominee_perm_vdc_municipality, nominee_perm_extrainfo, nominee_temp_district, nominee_temp_vdc_municipality, nominee_temp_extrainfo, nominee_cell_number_first, nominee_cell_number_second, nominee_landline, nominee_email, guardian_name, guardian_relation, guardian_perm_district, guardian_perm_vdc_municipality, guardian_perm_extrainfo, guardian_temp_district, guardian_temp_vdc_municipality, guardian_temp_extrainfo, guardian_cell_number_one, guardian_cell_number_second, guardian_landline, guardian_email, customer_joined_date, customer_refferedby, customer_approved_by, entry_by) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			ps.setString(1, paramIn.getCustomerName());
			ps.setString(2, paramIn.getCustomerAge());
			ps.setString(3, paramIn.getGender());
			ps.setString(4, paramIn.getDob());
			ps.setString(5, paramIn.getNationality());
			ps.setString(6, paramIn.getCitizenShipNo());
			ps.setString(7, paramIn.getPermDistrict());
			ps.setString(8, paramIn.getPermVdcMunicipality());
			ps.setString(9, paramIn.getPermExtrainfo());
			ps.setString(10, paramIn.getTempDistrict());
			ps.setString(11, paramIn.getTempVdcMunicipality());
			ps.setString(12, paramIn.getTempExtrainfo());
			ps.setString(13, paramIn.getCellNumberFirst());
			ps.setString(14, paramIn.getCellNumberSecond());
			ps.setString(15, paramIn.getLandLine());
			ps.setString(16, paramIn.getEmailId());
			ps.setString(17, paramIn.getMaritalStatus());
			ps.setString(18, paramIn.getSpouseName());
			ps.setString(19, paramIn.getOccupation());
			ps.setString(20, paramIn.getFathersName());
			ps.setString(21, paramIn.getGrandFathersName());
			ps.setString(22, paramIn.getFatherInLawsName());
			ps.setString(23, paramIn.getNomineesName());
			ps.setString(24, paramIn.getNomineeRelation());
			ps.setString(25, paramIn.getnPermDistrict());
			ps.setString(26, paramIn.getnPermVdcMunicipality());
			ps.setString(27, paramIn.getnPermExtraInfo());
			ps.setString(28, paramIn.getnTempDistrict());
			ps.setString(29, paramIn.getnTempVdcMunicipality());
			ps.setString(30, paramIn.getnTempExtraInfo());
			ps.setString(31, paramIn.getnCellNumberFirst());
			ps.setString(32, paramIn.getnCellNumberSecond());
			ps.setString(33, paramIn.getnLandLine());
			ps.setString(34, paramIn.getnEmailId());
			ps.setString(35, paramIn.getGuardianName());
			ps.setString(36, paramIn.getgRelation());
			ps.setString(37, paramIn.getgPermDistrict());
			ps.setString(38, paramIn.getgPermVdcMunicipality());
			ps.setString(39, paramIn.getgPermExtraInfo());
			ps.setString(40, paramIn.getgTempDistrict());
			ps.setString(41, paramIn.getgTempVdcMunicipality());
			ps.setString(42, paramIn.getgTempExtraInfo());
			ps.setString(43, paramIn.getgCellNumberFirst());
			ps.setString(44, paramIn.getgCellNumberSecond());
			ps.setString(45, paramIn.getgLandLine());
			ps.setString(46, paramIn.getgEmailId());
			ps.setString(47, paramIn.getjDate());
			ps.setString(48, paramIn.getRefferedBy());
			ps.setString(49, paramIn.getApprovedBy());
			ps.setInt(50, paramIn.getEntryBy());
			ps.executeUpdate();
			customerCreated = true;
		} catch (SQLException ex) {
			customerCreated = false;
			System.out.println(ex);
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return customerCreated;
	}
	public boolean updateCustomerInfo(CustomerBean paramIn){
		boolean updated = false;
			try{
				con = ConnectionProvider.getConnection();
				ps = con.prepareStatement("UPDATE tbl_customer SET customer_name=?, customer_age=?, customer_gender=?, customer_dob=?, customer_nationality=?, customer_citizenshipno=?, customer_perm_district=?, customer_perm_vdc_municipality=?, customer_perm_extrainfo=?, customer_temp_district=?, customer_temp_vdc_municipality=?, customer_temp_extrainfo=?, customer_cell_number_first=?, customer_cell_number_second=?, customer_landline=?, customer_email=?, customer_marital_status=?, customer_spouse_name=?, customer_occupation=?, customer_father_name=?, customer_grandfather_name=?, customer_father_in_law_name=?, nominee_name=?, nominee_relation=?, nominee_perm_district=?, nominee_perm_vdc_municipality=?, nominee_perm_extrainfo=?, nominee_temp_district=?, nominee_temp_vdc_municipality=?, nominee_temp_extrainfo=?, nominee_cell_number_first=?, nominee_cell_number_second=?, nominee_landline=?, nominee_email=?, guardian_name=?, guardian_relation=?, guardian_perm_district=?, guardian_perm_vdc_municipality=?, guardian_perm_extrainfo=?, guardian_temp_district=?, guardian_temp_vdc_municipality=?, guardian_temp_extrainfo=?, guardian_cell_number_one=?, guardian_cell_number_second=?, guardian_landline=?, guardian_email=?, customer_joined_date=?, customer_refferedby=?, customer_approved_by=? WHERE customer_id=?");
				ps.setString(1, paramIn.getCustomerName());
				ps.setString(2, paramIn.getCustomerAge());
				ps.setString(3, paramIn.getGender());
				ps.setString(4, paramIn.getDob());
				ps.setString(5, paramIn.getNationality());
				ps.setString(6, paramIn.getCitizenShipNo());
				ps.setString(7, paramIn.getPermDistrict());
				ps.setString(8, paramIn.getPermVdcMunicipality());
				ps.setString(9, paramIn.getPermExtrainfo());
				ps.setString(10, paramIn.getTempDistrict());
				ps.setString(11, paramIn.getTempVdcMunicipality());
				ps.setString(12, paramIn.getTempExtrainfo());
				ps.setString(13, paramIn.getCellNumberFirst());
				ps.setString(14, paramIn.getCellNumberSecond());
				ps.setString(15, paramIn.getLandLine());
				ps.setString(16, paramIn.getEmailId());
				ps.setString(17, paramIn.getMaritalStatus());
				ps.setString(18, paramIn.getSpouseName());
				ps.setString(19, paramIn.getOccupation());
				ps.setString(20, paramIn.getFathersName());
				ps.setString(21, paramIn.getGrandFathersName());
				ps.setString(22, paramIn.getFatherInLawsName());
				ps.setString(23, paramIn.getNomineesName());
				ps.setString(24, paramIn.getNomineeRelation());
				ps.setString(25, paramIn.getnPermDistrict());
				ps.setString(26, paramIn.getnPermVdcMunicipality());
				ps.setString(27, paramIn.getnPermExtraInfo());
				ps.setString(28, paramIn.getnTempDistrict());
				ps.setString(29, paramIn.getnTempVdcMunicipality());
				ps.setString(30, paramIn.getnTempExtraInfo());
				ps.setString(31, paramIn.getnCellNumberFirst());
				ps.setString(32, paramIn.getnCellNumberSecond());
				ps.setString(33, paramIn.getnLandLine());
				ps.setString(34, paramIn.getnEmailId());
				ps.setString(35, paramIn.getGuardianName());
				ps.setString(36, paramIn.getgRelation());
				ps.setString(37, paramIn.getgPermDistrict());
				ps.setString(38, paramIn.getgPermVdcMunicipality());
				ps.setString(39, paramIn.getgPermExtraInfo());
				ps.setString(40, paramIn.getgTempDistrict());
				ps.setString(41, paramIn.getgTempVdcMunicipality());
				ps.setString(42, paramIn.getgTempExtraInfo());
				ps.setString(43, paramIn.getgCellNumberFirst());
				ps.setString(44, paramIn.getgCellNumberSecond());
				ps.setString(45, paramIn.getgLandLine());
				ps.setString(46, paramIn.getgEmailId());
				ps.setString(47, paramIn.getjDate());
				ps.setString(48, paramIn.getRefferedBy());
				ps.setString(49, paramIn.getApprovedBy());
				ps.setInt(50, paramIn.getCustomerId());
				ps.executeUpdate();
				updated = true;
			} catch (SQLException e){
				e.printStackTrace();
			} finally {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return updated;
	}
	public int getIdofLastInsertion(int userID) {
		int customerId = 0;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT customer_id FROM tbl_customer WHERE entry_by = ? ORDER BY customer_id DESC LIMIT 1");
			ps.setInt(1, userID);
			rs = ps.executeQuery();
			if (rs.next()) {
				customerId = rs.getInt("customer_id");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return customerId;
	}
	public boolean uploadCredentials(CustomerBean photoPurp) {
		boolean credentialInserted = false;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("UPDATE tbl_customer SET customer_photo=?, customer_thumb_print=? WHERE customer_id = ? ");
			ps.setString(1, photoPurp.getPhotoPath());
			ps.setString(2, photoPurp.getFingerPrintPath());
			ps.setInt(3, photoPurp.getCustomerId());
			ps.executeUpdate();
			credentialInserted = true;
		} catch (SQLException ex) {
			credentialInserted = false;
			ex.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return credentialInserted;
	}
	public boolean changeCredentials(CustomerBean photoPurp){
		boolean credentialInserted = false;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("UPDATE tbl_customer SET customer_photo=?, customer_thumb_print=? WHERE customer_id = ? ");
			ps.setString(1, photoPurp.getPhotoPath());
			ps.setString(2, photoPurp.getFingerPrintPath());
			ps.setInt(3, photoPurp.getCustomerId());
			ps.executeUpdate();
			credentialInserted = true;
		} catch (SQLException ex) {
			credentialInserted = false;
			ex.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return credentialInserted;
	}
	public CustomerBean lastInsertion() {
		CustomerBean lastInsertedCustomer = new CustomerBean();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT * FROM tbl_customer ORDER BY customer_id DESC LIMIT 1");
			rs = ps.executeQuery();
			if (rs.next()) {
				lastInsertedCustomer.setCustomerId(rs.getInt("customer_id"));
				lastInsertedCustomer.setCustomerName(rs.getString("customer_name"));
				lastInsertedCustomer.setCustomerAge(rs.getString("customer_age"));
				lastInsertedCustomer.setGender(rs.getString("customer_gender"));
				lastInsertedCustomer.setDob(rs.getString("customer_dob"));
				lastInsertedCustomer.setNationality(rs.getString("customer_nationality"));
				lastInsertedCustomer.setCitizenShipNo(rs.getString("customer_citizenshipno"));
				lastInsertedCustomer.setPermDistrict(rs.getString("customer_perm_district"));
				lastInsertedCustomer.setPermVdcMunicipality(rs.getString("customer_perm_vdc_municipality"));
				lastInsertedCustomer.setPermExtrainfo(rs.getString("customer_perm_extrainfo"));
				lastInsertedCustomer.setTempDistrict(rs.getString("customer_temp_district"));
				lastInsertedCustomer.setTempVdcMunicipality(rs.getString("customer_temp_vdc_municipality"));
				lastInsertedCustomer.setTempExtrainfo(rs.getString("customer_temp_extrainfo"));
				lastInsertedCustomer.setCellNumberFirst(rs.getString("customer_cell_number_first"));
				lastInsertedCustomer.setCellNumberSecond(rs.getString("customer_cell_number_second"));
				lastInsertedCustomer.setLandLine(rs.getString("customer_landline"));
				lastInsertedCustomer.setEmailId(rs.getString("customer_email"));
				lastInsertedCustomer.setMaritalStatus(rs.getString("customer_marital_status"));
				lastInsertedCustomer.setSpouseName(rs.getString("customer_spouse_name"));
				lastInsertedCustomer.setOccupation(rs.getString("customer_occupation"));
				lastInsertedCustomer.setFathersName(rs.getString("customer_father_name"));
				lastInsertedCustomer.setGrandFathersName(rs.getString("customer_grandfather_name"));
				lastInsertedCustomer.setFatherInLawsName(rs.getString("customer_father_in_law_name"));
				lastInsertedCustomer.setNomineesName(rs.getString("nominee_name"));
				lastInsertedCustomer.setNomineeRelation(rs.getString("nominee_relation"));
				lastInsertedCustomer.setnPermDistrict(rs.getString("nominee_perm_district"));
				lastInsertedCustomer.setnPermVdcMunicipality(rs.getString("nominee_perm_vdc_municipality"));
				lastInsertedCustomer.setnPermExtraInfo(rs.getString("nominee_perm_extrainfo"));
				lastInsertedCustomer.setnTempDistrict(rs.getString("nominee_temp_district"));
				lastInsertedCustomer.setnTempVdcMunicipality(rs.getString("nominee_temp_vdc_municipality"));
				lastInsertedCustomer.setnTempExtraInfo(rs.getString("nominee_temp_extrainfo"));
				lastInsertedCustomer.setnCellNumberFirst(rs.getString("nominee_cell_number_first"));
				lastInsertedCustomer.setnCellNumberSecond(rs.getString("nominee_cell_number_second"));
				lastInsertedCustomer.setnLandLine(rs.getString("nominee_landline"));
				lastInsertedCustomer.setnEmailId(rs.getString("nominee_email"));
				lastInsertedCustomer.setGuardianName(rs.getString("guardian_name"));
				lastInsertedCustomer.setgRelation(rs.getString("guardian_relation"));
				lastInsertedCustomer.setgPermDistrict(rs.getString("guardian_perm_district"));
				lastInsertedCustomer.setgPermVdcMunicipality(rs.getString("guardian_perm_vdc_municipality"));
				lastInsertedCustomer.setgPermExtraInfo(rs.getString("guardian_perm_extrainfo"));
				lastInsertedCustomer.setgTempDistrict(rs.getString("guardian_temp_district"));
				lastInsertedCustomer.setgTempVdcMunicipality(rs.getString("guardian_temp_vdc_municipality"));
				lastInsertedCustomer.setgTempExtraInfo(rs.getString("guardian_temp_extrainfo"));
				lastInsertedCustomer.setgCellNumberFirst(rs.getString("guardian_cell_number_one"));
				lastInsertedCustomer.setgCellNumberSecond(rs.getString("guardian_cell_number_second"));
				lastInsertedCustomer.setgLandLine(rs.getString("guardian_landline"));
				lastInsertedCustomer.setgEmailId(rs.getString("guardian_email"));
				lastInsertedCustomer.setPhotoPath(rs.getString("customer_photo"));
				lastInsertedCustomer.setFingerPrintPath(rs.getString("customer_thumb_print"));
				lastInsertedCustomer.setjDate(rs.getString("customer_joined_date"));
				lastInsertedCustomer.setRefferedBy(rs.getString("customer_refferedby"));
				lastInsertedCustomer.setApprovedBy(rs.getString("customer_approved_by"));
				lastInsertedCustomer.setEntryBy(rs.getInt("entry_by"));
				rsNext = con.prepareStatement("SELECT username from tbl_user WHERE user_id =" + lastInsertedCustomer.getEntryBy()).executeQuery();
				if (rsNext.next()) {
					lastInsertedCustomer.setEnteredBy(rsNext.getString("username"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rsNext.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				rs.next();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rsNext.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lastInsertedCustomer;
	}
	public String checkIfExists(int ID) {
		String retMsg;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT customer_name FROM tbl_customer WHERE customer_id=?");
			ps.setInt(1, ID);
			rs = ps.executeQuery();
			if (rs.next()) {
				retMsg = rs.getString("customer_name");
			} else {
				retMsg = "No Match";
			}
		} catch (SQLException ex) {
			retMsg = "error";
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retMsg;
	}
	public ArrayList<CustomerBean> getAllUserList() {
		ArrayList<CustomerBean> list = new ArrayList<CustomerBean>();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(
					"SELECT customer_id, customer_name, customer_age, customer_gender, customer_citizenshipno, customer_perm_vdc_municipality, customer_cell_number_first, customer_marital_status, customer_occupation, customer_father_name, customer_joined_date, customer_refferedby, entry_by FROM tbl_customer");
			rs = ps.executeQuery();
			while (rs.next()) {
				CustomerBean storeInfo = new CustomerBean();
				storeInfo.setCustomerId(rs.getInt("customer_id"));
				storeInfo.setCustomerName(rs.getString("customer_name"));
				storeInfo.setCustomerAge(rs.getString("customer_age"));
				storeInfo.setGender(rs.getString("customer_gender"));
				storeInfo.setCitizenShipNo(rs.getString("customer_citizenshipno"));
				storeInfo.setPermVdcMunicipality(rs.getString("customer_perm_vdc_municipality"));
				storeInfo.setCellNumberFirst(rs.getString("customer_cell_number_first"));
				storeInfo.setMaritalStatus(rs.getString("customer_marital_status"));
				storeInfo.setOccupation(rs.getString("customer_occupation"));
				storeInfo.setFathersName(rs.getString("customer_father_name"));
				storeInfo.setjDate(rs.getString("customer_joined_date"));
				storeInfo.setRefferedBy(rs.getString("customer_refferedby"));
				storeInfo.setEntryBy(rs.getInt("entry_by"));
				rsNext = con.prepareStatement("SELECT username from tbl_user WHERE user_id =" + storeInfo.getEntryBy()).executeQuery();
				if (rsNext.next()) {
					storeInfo.setEnteredBy(rsNext.getString("username"));
				}
				list.add(storeInfo);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				rsNext.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public ArrayList<CustomerBean> searchCustomer(String queryString) {
		boolean rsNextStats = false;
		ArrayList<CustomerBean> list = new ArrayList<CustomerBean>();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(
					"SELECT customer_id, customer_name, customer_age, customer_gender, customer_citizenshipno, customer_perm_vdc_municipality, customer_cell_number_first, customer_marital_status, customer_occupation, customer_father_name, customer_joined_date, customer_refferedby, entry_by FROM tbl_customer WHERE customer_name=?");
			ps.setString(1, queryString);
			rs = ps.executeQuery();
			while (rs.next()) {
				CustomerBean storeInfo = new CustomerBean();
				storeInfo.setCustomerId(rs.getInt("customer_id"));
				storeInfo.setCustomerName(rs.getString("customer_name"));
				storeInfo.setCustomerAge(rs.getString("customer_age"));
				storeInfo.setGender(rs.getString("customer_gender"));
				storeInfo.setCitizenShipNo(rs.getString("customer_citizenshipno"));
				storeInfo.setPermVdcMunicipality(rs.getString("customer_perm_vdc_municipality"));
				storeInfo.setCellNumberFirst(rs.getString("customer_cell_number_first"));
				storeInfo.setMaritalStatus(rs.getString("customer_marital_status"));
				storeInfo.setOccupation(rs.getString("customer_occupation"));
				storeInfo.setFathersName(rs.getString("customer_father_name"));
				storeInfo.setjDate(rs.getString("customer_joined_date"));
				storeInfo.setRefferedBy(rs.getString("customer_refferedby"));
				storeInfo.setEntryBy(rs.getInt("entry_by"));
				rsNext = con.prepareStatement("SELECT username FROM tbl_user WHERE user_id =" + storeInfo.getEntryBy()).executeQuery();
				if (rsNext.next()) {
					storeInfo.setEnteredBy(rsNext.getString("username"));
					rsNextStats = true;
				}
				list.add(storeInfo);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (rsNextStats) {
				try {
					rsNext.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public ArrayList<CustomerBean> searchCustomer(int customerId) {
		ArrayList<CustomerBean> list = new ArrayList<CustomerBean>();
		boolean rsNextStats = false;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(
					"SELECT customer_id, customer_name, customer_age, customer_gender, customer_citizenshipno, customer_perm_vdc_municipality, customer_cell_number_first, customer_marital_status, customer_occupation, customer_father_name, customer_joined_date, customer_refferedby, entry_by FROM tbl_customer WHERE customer_id=?");
			ps.setInt(1, customerId);
			rs = ps.executeQuery();
			while (rs.next()) {
				CustomerBean storeInfo = new CustomerBean();
				storeInfo.setCustomerId(rs.getInt("customer_id"));
				storeInfo.setCustomerName(rs.getString("customer_name"));
				storeInfo.setCustomerAge(rs.getString("customer_age"));
				storeInfo.setGender(rs.getString("customer_gender"));
				storeInfo.setCitizenShipNo(rs.getString("customer_citizenshipno"));
				storeInfo.setPermVdcMunicipality(rs.getString("customer_perm_vdc_municipality"));
				storeInfo.setCellNumberFirst(rs.getString("customer_cell_number_first"));
				storeInfo.setMaritalStatus(rs.getString("customer_marital_status"));
				storeInfo.setOccupation(rs.getString("customer_occupation"));
				storeInfo.setFathersName(rs.getString("customer_father_name"));
				storeInfo.setjDate(rs.getString("customer_joined_date"));
				storeInfo.setRefferedBy(rs.getString("customer_refferedby"));
				storeInfo.setEntryBy(rs.getInt("entry_by"));
				rsNext = con.prepareStatement("SELECT username from tbl_user WHERE user_id =" + storeInfo.getEntryBy()).executeQuery();
				if (rsNext.next()) {
					storeInfo.setEnteredBy(rsNext.getString("username"));
					rsNextStats = true;
				}
				list.add(storeInfo);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (rsNextStats) {
				try {
					rsNext.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public ArrayList<CustomerBean> searchForEdit(int customerId) {
		ArrayList<CustomerBean> list = new ArrayList<CustomerBean>();
		boolean rsNextStats = false;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(
					"SELECT customer_id, customer_name, customer_age, customer_gender, customer_citizenshipno, customer_perm_vdc_municipality, customer_joined_date, entry_by, customer_status FROM tbl_customer WHERE customer_id=?");
			ps.setInt(1, customerId);
			rs = ps.executeQuery();
			while (rs.next()) {
				CustomerBean storeInfo = new CustomerBean();
				storeInfo.setCustomerId(rs.getInt("customer_id"));
				storeInfo.setCustomerName(rs.getString("customer_name"));
				storeInfo.setCustomerAge(rs.getString("customer_age"));
				storeInfo.setGender(rs.getString("customer_gender"));
				storeInfo.setCitizenShipNo(rs.getString("customer_citizenshipno"));
				storeInfo.setPermVdcMunicipality(rs.getString("customer_perm_vdc_municipality"));
				storeInfo.setjDate(rs.getString("customer_joined_date"));
				storeInfo.setEntryBy(rs.getInt("entry_by"));
				storeInfo.setStatus(rs.getBoolean("customer_status"));
				rsNext = con.prepareStatement("SELECT username from tbl_user WHERE user_id =" + storeInfo.getEntryBy()).executeQuery();
				if (rsNext.next()) {
					storeInfo.setEnteredBy(rsNext.getString("username"));
					rsNextStats = true;
				}
				list.add(storeInfo);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (rsNextStats) {
				try {
					rsNext.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public ArrayList<CustomerBean> searchForEdit(String customerName) {
		ArrayList<CustomerBean> list = new ArrayList<CustomerBean>();
		boolean rsNextStats = false;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(
					"SELECT customer_id, customer_name, customer_age, customer_gender, customer_citizenshipno, customer_perm_vdc_municipality, customer_joined_date, entry_by, customer_status FROM tbl_customer WHERE customer_name=?");
			ps.setString(1, customerName);
			rs = ps.executeQuery();
			while (rs.next()) {
				CustomerBean storeInfo = new CustomerBean();
				storeInfo.setCustomerId(rs.getInt("customer_id"));
				storeInfo.setCustomerName(rs.getString("customer_name"));
				storeInfo.setCustomerAge(rs.getString("customer_age"));
				storeInfo.setGender(rs.getString("customer_gender"));
				storeInfo.setCitizenShipNo(rs.getString("customer_citizenshipno"));
				storeInfo.setPermVdcMunicipality(rs.getString("customer_perm_vdc_municipality"));
				storeInfo.setjDate(rs.getString("customer_joined_date"));
				storeInfo.setEntryBy(rs.getInt("entry_by"));
				storeInfo.setStatus(rs.getBoolean("customer_status"));
				rsNext = con.prepareStatement("SELECT username from tbl_user WHERE user_id =" + storeInfo.getEntryBy()).executeQuery();
				if (rsNext.next()) {
					storeInfo.setEnteredBy(rsNext.getString("username"));
					rsNextStats = true;
				}
				list.add(storeInfo);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (rsNextStats) {
				try {
					rsNext.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public CustomerBean getDetails(int customerID) {
		CustomerBean lastInsertedCustomer = new CustomerBean();
		boolean rsNextStats = false;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT * FROM tbl_customer WHERE customer_id = ?");
			ps.setInt(1, customerID);
			rs = ps.executeQuery();
			while (rs.next()) {
				lastInsertedCustomer.setCustomerId(rs.getInt("customer_id"));
				lastInsertedCustomer.setCustomerName(rs.getString("customer_name"));
				lastInsertedCustomer.setCustomerAge(rs.getString("customer_age"));
				lastInsertedCustomer.setGender(rs.getString("customer_gender"));
				lastInsertedCustomer.setDob(rs.getString("customer_dob"));
				lastInsertedCustomer.setNationality(rs.getString("customer_nationality"));
				lastInsertedCustomer.setCitizenShipNo(rs.getString("customer_citizenshipno"));
				lastInsertedCustomer.setPermDistrict(rs.getString("customer_perm_district"));
				lastInsertedCustomer.setPermVdcMunicipality(rs.getString("customer_perm_vdc_municipality"));
				lastInsertedCustomer.setPermExtrainfo(rs.getString("customer_perm_extrainfo"));
				lastInsertedCustomer.setTempDistrict(rs.getString("customer_temp_district"));
				lastInsertedCustomer.setTempVdcMunicipality(rs.getString("customer_temp_vdc_municipality"));
				lastInsertedCustomer.setTempExtrainfo(rs.getString("customer_temp_extrainfo"));
				lastInsertedCustomer.setCellNumberFirst(rs.getString("customer_cell_number_first"));
				lastInsertedCustomer.setCellNumberSecond(rs.getString("customer_cell_number_second"));
				lastInsertedCustomer.setLandLine(rs.getString("customer_landline"));
				lastInsertedCustomer.setEmailId(rs.getString("customer_email"));
				lastInsertedCustomer.setMaritalStatus(rs.getString("customer_marital_status"));
				lastInsertedCustomer.setSpouseName(rs.getString("customer_spouse_name"));
				lastInsertedCustomer.setOccupation(rs.getString("customer_occupation"));
				lastInsertedCustomer.setFathersName(rs.getString("customer_father_name"));
				lastInsertedCustomer.setGrandFathersName(rs.getString("customer_grandfather_name"));
				lastInsertedCustomer.setFatherInLawsName(rs.getString("customer_father_in_law_name"));
				lastInsertedCustomer.setNomineesName(rs.getString("nominee_name"));
				lastInsertedCustomer.setNomineeRelation(rs.getString("nominee_relation"));
				lastInsertedCustomer.setnPermDistrict(rs.getString("nominee_perm_district"));
				lastInsertedCustomer.setnPermVdcMunicipality(rs.getString("nominee_perm_vdc_municipality"));
				lastInsertedCustomer.setnPermExtraInfo(rs.getString("nominee_perm_extrainfo"));
				lastInsertedCustomer.setnTempDistrict(rs.getString("nominee_temp_district"));
				lastInsertedCustomer.setnTempVdcMunicipality(rs.getString("nominee_temp_vdc_municipality"));
				lastInsertedCustomer.setnTempExtraInfo(rs.getString("nominee_temp_extrainfo"));
				lastInsertedCustomer.setnCellNumberFirst(rs.getString("nominee_cell_number_first"));
				lastInsertedCustomer.setnCellNumberSecond(rs.getString("nominee_cell_number_second"));
				lastInsertedCustomer.setnLandLine(rs.getString("nominee_landline"));
				lastInsertedCustomer.setnEmailId(rs.getString("nominee_email"));
				lastInsertedCustomer.setGuardianName(rs.getString("guardian_name"));
				lastInsertedCustomer.setgRelation(rs.getString("guardian_relation"));
				lastInsertedCustomer.setgPermDistrict(rs.getString("guardian_perm_district"));
				lastInsertedCustomer.setgPermVdcMunicipality(rs.getString("guardian_perm_vdc_municipality"));
				lastInsertedCustomer.setgPermExtraInfo(rs.getString("guardian_perm_extrainfo"));
				lastInsertedCustomer.setgTempDistrict(rs.getString("guardian_temp_district"));
				lastInsertedCustomer.setgTempVdcMunicipality(rs.getString("guardian_temp_vdc_municipality"));
				lastInsertedCustomer.setgTempExtraInfo(rs.getString("guardian_temp_extrainfo"));
				lastInsertedCustomer.setgCellNumberFirst(rs.getString("guardian_cell_number_one"));
				lastInsertedCustomer.setgCellNumberSecond(rs.getString("guardian_cell_number_second"));
				lastInsertedCustomer.setgLandLine(rs.getString("guardian_landline"));
				lastInsertedCustomer.setgEmailId(rs.getString("guardian_email"));
				lastInsertedCustomer.setPhotoPath(rs.getString("customer_photo"));
				lastInsertedCustomer.setFingerPrintPath(rs.getString("customer_thumb_print"));
				lastInsertedCustomer.setjDate(rs.getString("customer_joined_date"));
				lastInsertedCustomer.setRefferedBy(rs.getString("customer_refferedby"));
				lastInsertedCustomer.setApprovedBy(rs.getString("customer_approved_by"));
				lastInsertedCustomer.setEntryBy(rs.getInt("entry_by"));
				lastInsertedCustomer.setStatus(rs.getBoolean("customer_status"));
				rsNext = con.prepareStatement("SELECT username from tbl_user WHERE user_id =" + lastInsertedCustomer.getEntryBy()).executeQuery();
				if (rsNext.next()) {
					lastInsertedCustomer.setEnteredBy(rsNext.getString("username"));
					rsNextStats = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rsNextStats) {
				try {
					rsNext.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lastInsertedCustomer;
	}
	public int getTotalCustomerCount() {
		int totalCount = 0;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT COUNT(customer_id) AS totalCount FROM tbl_customer");
			rs = ps.executeQuery();
			while (rs.next()) {
				totalCount = rs.getInt("totalCount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return totalCount;
	}
	public int getActiveCustomers() {
		int activeCustomers = 0;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT COUNT(customer_id) AS activeCustomers FROM tbl_customer WHERE customer_status = 1");
			rs = ps.executeQuery();
			while (rs.next()) {
				activeCustomers = rs.getInt("activeCustomers");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return activeCustomers;
	}
	public int getInactiveCustomers() {
		int inactiveCustomers = 0;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT COUNT(*) AS inactiveCustomers FROM tbl_customer WHERE customer_status = 0");
			rs = ps.executeQuery();
			while (rs.next()) {
				inactiveCustomers = rs.getInt("inactiveCustomers");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return inactiveCustomers;
	}
	public int getMaleCustomers() {
		int maleCustomers = 0;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT COUNT(customer_id) AS maleCustomers FROM tbl_customer WHERE customer_gender='Male'");
			rs = ps.executeQuery();
			while (rs.next()) {
				maleCustomers = rs.getInt("maleCustomers");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return maleCustomers;
	}
	public int getFemaleCustomers() {
		int femaleCustomers = 0;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT COUNT(customer_id) AS femaleCustomers FROM tbl_customer WHERE customer_gender = 'Female'");
			rs = ps.executeQuery();
			while (rs.next()) {
				femaleCustomers = rs.getInt("femaleCustomers");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return femaleCustomers;
	}
	public int getAdultCustomers() {
		int adultCustomers = 0;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT COUNT(customer_id) AS adultCustomers FROM tbl_customer WHERE customer_age > 15");
			rs = ps.executeQuery();
			while (rs.next()) {
				adultCustomers = rs.getInt("adultCustomers");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return adultCustomers;
	}
	public int getChildrenCustomers() {
		int childrenCustomers = 0;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT COUNT(customer_id) as childrenCustomers FROM tbl_customer WHERE customer_age < 16");
			rs = ps.executeQuery();
			while (rs.next()) {
				childrenCustomers = rs.getInt("childrenCustomers");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return childrenCustomers;
	}
	public void changeToInactive(int customerId) {
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("UPDATE tbl_customer SET customer_status = 0 WHERE customer_id=?");
			ps.setInt(1, customerId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void changeToActive(int customerId) {
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("UPDATE tbl_customer SET customer_status = 1 WHERE customer_id = ?");
			ps.setInt(1, customerId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
