/**
 * 
 */
package com.kjjcsoft.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kjjcsoft.bean.EmployeeBean;

/**
 * @author Seekraw
 *
 */
public class Employee {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	public ArrayList<Integer> getEmployeeIdList(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		try{
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT employee_id FROM tbl_employee");
			rs = ps.executeQuery();
			while (rs.next()) {
				int id ;
				id = rs.getInt("employee_id");
				list.add(id);
			}
		} catch (SQLException ex){
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public EmployeeBean getInfo(int empId){
		EmployeeBean empBean = new EmployeeBean();
		try{
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT employee_name, employee_photo FROM tbl_employee WHERE employee_id=?");
			ps.setInt(1, empId);
			rs = ps.executeQuery();
			if (rs.next()) {
				empBean.setEmployeeName(rs.getString("employee_name"));
				empBean.setEmployeePhoto(rs.getString("employee_photo"));
			} else {
				empBean.setEmployeeName("no name");
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		return empBean;
	}
	public boolean exists(int collectorId){
		boolean exists = false;
		try{
			con= ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT collector_id FROM tbl_collector WHERE collector_id = ?");
			ps.setInt(1, collectorId);
			rs = ps.executeQuery();
			if (rs.next()) {
				exists = true;
			}
		} catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		return exists;
	}
}
