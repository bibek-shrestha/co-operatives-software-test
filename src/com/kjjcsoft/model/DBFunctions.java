/**
 * 
 */
package com.kjjcsoft.model;
import java.sql.*;

import java.text.SimpleDateFormat;

import com.kjjcsoft.bean.RetrivedUserBean;
import com.kjjcsoft.bean.UserBean;
import java.util.Date;
/**
 * @author Seekraw
 *
 */
public class DBFunctions {
	private Connection con= null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private RetrivedUserBean user_info= new RetrivedUserBean();
	SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	public RetrivedUserBean getUserInfo(UserBean u){
		try {
			con=ConnectionProvider.getConnection();
			ps= con.prepareStatement("SELECT u.user_id, u.username, u.role, u.employee_id, u.user_enabled, e.employee_name, e.employee_photo FROM tbl_user u, tbl_employee e WHERE u.employee_id=e.employee_id AND u.username=?");
			ps.setString(1, u.getUsername());
			rs=ps.executeQuery();
		} catch (Exception e) {
			System.out.println(e);
		}
		try{
			while(rs.next()){
				user_info.setUser_id(rs.getInt("user_id"));
				user_info.setUser_name(rs.getString("username"));
				user_info.setRole(rs.getString("role"));
				user_info.setEmployee_id(rs.getInt("employee_id"));
				user_info.setName(rs.getString("employee_name"));
				user_info.setUser_enabled(rs.getBoolean("u.user_enabled"));
				user_info.setEmployeePhotoPath(rs.getString("e.employee_photo"));
			}
		}
		catch(SQLException ex){
			System.out.println(ex);
		}
		finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		user_info.setLastLogin(getCurrentLogin(user_info.getUser_id()));
		return user_info;
	}
	
	public static java.sql.Date convertToSqlDate (java.util.Date inDate){
		java.sql.Date conDate= new java.sql.Date(inDate.getTime());
		return conDate;
	}
	public void insertUserLog(int userId){
		Date dt = new Date();
		try{
			con=ConnectionProvider.getConnection();
			ps = con.prepareStatement("INSERT INTO tbl_user_log (user_id, last_login) VALUES (?,?)");
			ps.setInt(1, userId);
			ps.setString(2, sdf.format(dt));
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	public void insertLogoutLog(int userId, String lastlog){
		Date dt = new Date();
		try{
			con=ConnectionProvider.getConnection();
			ps = con.prepareStatement("UPDATE tbl_user_log SET last_logout=? WHERE user_id=? AND last_login=?");
			ps.setString(1, sdf.format(dt));
			ps.setInt(2, userId);
			ps.setString(3, lastlog);
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	public String getCurrentLogin(int userId){
		String retTimeStamp = null;
		try{
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT last_login FROM tbl_user_log WHERE user_id=? ORDER BY log_id DESC LIMIT 1");
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			if (rs.next()) {
				String timeString = rs.getString("last_login");
				retTimeStamp = timeString.substring(0, timeString.indexOf("."));
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
		return retTimeStamp;
	}
}
