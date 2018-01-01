/**
 * 
 */
package com.kjjcsoft.model;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.kjjcsoft.bean.RetrivedUserBean;
import com.kjjcsoft.bean.UserBean;
import com.kjjcsoft.bean.UserLogBean;
/**
 * @author Seekraw
 */
public class Users {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	ResultSet rsNext = null;
	public ArrayList<UserLogBean> getMyLogs(int userId) {
		ArrayList<UserLogBean> list = new ArrayList<UserLogBean>();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT last_login, last_logout FROM tbl_user_log WHERE user_id=? ORDER BY log_id DESC");
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserLogBean logData = new UserLogBean();
				String loginTimeStamp = rs.getString("last_login");
				logData.setLoginTime(loginTimeStamp.substring(0, loginTimeStamp.indexOf(".")));
				String logoutTimeStamp = rs.getString("last_logout");
				if (logoutTimeStamp == null) {
					logData.setLogoutTime("current session");
				} else {
					logData.setLogoutTime(logoutTimeStamp.substring(0, logoutTimeStamp.indexOf(".")));
				}
				list.add(logData);
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
		return list;
	}
	public ArrayList<RetrivedUserBean> getUsers() {
		ArrayList<RetrivedUserBean> list = new ArrayList<RetrivedUserBean>();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT user_id, username, role, employee_id, user_enabled FROM tbl_user");
			rs = ps.executeQuery();
			while (rs.next()) {
				RetrivedUserBean retBean = new RetrivedUserBean();
				retBean.setUser_id(rs.getInt("user_id"));
				retBean.setUser_name(rs.getString("username"));
				retBean.setRole(rs.getString("role"));
				int empId = rs.getInt("employee_id");
				retBean.setUser_enabled(rs.getBoolean("user_enabled"));
				rsNext = con.prepareStatement("SELECT employee_name FROM tbl_employee WHERE employee_id=" + empId).executeQuery();
				if (rsNext.next()) {
					retBean.setName(rsNext.getString("employee_name"));
				}
				list.add(retBean);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				rsNext.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
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
		return list;
	}
	public void activateUser(int userId) {
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("UPDATE tbl_user SET user_enabled = 1 WHERE user_id=?");
			ps.setInt(1, userId);
			ps.executeUpdate();
		} catch (SQLException ex) {
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
	}
	public void deactivateUser(int userId) {
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("UPDATE tbl_user SET user_enabled = 0 WHERE user_id=?");
			ps.setInt(1, userId);
			ps.executeUpdate();
		} catch (SQLException ex) {
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
	}
	public boolean addUser(UserBean usr) {
		boolean userAdded = false;
		String encryptedPassword = null;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("INSERT INTO tbl_user (username, password, role, employee_id) VALUES (?,?,?,?)");
			try {
				encryptedPassword = EncryptorClass.encrypt(usr.getPassword());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			ps.setString(1, usr.getUsername());
			ps.setString(2, encryptedPassword);
			ps.setString(3, usr.getRole());
			ps.setInt(4, usr.getEmployee_id());
			ps.executeUpdate();
			userAdded = true;
		} catch (SQLException ex) {
			userAdded = false;
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
		return userAdded;
	}
	public boolean checkUsername(String username) {
		boolean retValue = false;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT username FROM tbl_user WHERE username = ?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				retValue = true;
			} else {
				retValue = false;
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
		return retValue;
	}
	public ArrayList<RetrivedUserBean> searchUsers(String username) {
		ArrayList<RetrivedUserBean> list = new ArrayList<RetrivedUserBean>();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT user_id, username, role, employee_id, user_enabled FROM tbl_user WHERE username=?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				RetrivedUserBean retBean = new RetrivedUserBean();
				retBean.setUser_id(rs.getInt("user_id"));
				retBean.setUser_name(rs.getString("username"));
				retBean.setRole(rs.getString("role"));
				int empId = rs.getInt("employee_id");
				retBean.setUser_enabled(rs.getBoolean("user_enabled"));
				rsNext = con.prepareStatement("SELECT employee_name FROM tbl_employee WHERE employee_id=" + empId).executeQuery();
				if (rsNext.next()) {
					retBean.setName(rsNext.getString("employee_name"));
				}
				list.add(retBean);
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
	public ArrayList<RetrivedUserBean> searchUsers(int empId) {
		ArrayList<RetrivedUserBean> list = new ArrayList<RetrivedUserBean>();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT user_id, username, role, employee_id, user_enabled FROM tbl_user WHERE employee_id=?");
			ps.setInt(1, empId);
			rs = ps.executeQuery();
			while (rs.next()) {
				RetrivedUserBean retBean = new RetrivedUserBean();
				retBean.setUser_id(rs.getInt("user_id"));
				retBean.setUser_name(rs.getString("username"));
				retBean.setRole(rs.getString("role"));
				int empid = rs.getInt("employee_id");
				retBean.setUser_enabled(rs.getBoolean("user_enabled"));
				rsNext = con.prepareStatement("SELECT employee_name FROM tbl_employee WHERE employee_id=" + empid).executeQuery();
				if (rsNext.next()) {
					retBean.setName(rsNext.getString("employee_name"));
				}
				list.add(retBean);
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
	public ArrayList<RetrivedUserBean> searchUsersEname(String employeeName) {
		ArrayList<RetrivedUserBean> list = new ArrayList<RetrivedUserBean>();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT user_id, username, role, employee_id, user_enabled FROM tbl_user");
			rs = ps.executeQuery();
			while (rs.next()) {
				RetrivedUserBean retBean = new RetrivedUserBean();
				retBean.setUser_id(rs.getInt("user_id"));
				retBean.setUser_name(rs.getString("username"));
				retBean.setRole(rs.getString("role"));
				int empid = rs.getInt("employee_id");
				retBean.setUser_enabled(rs.getBoolean("user_enabled"));
				rsNext = con.prepareStatement("SELECT employee_name FROM tbl_employee WHERE employee_id=" + empid).executeQuery();
				if (rsNext.next()) {
					retBean.setName(rsNext.getString("employee_name"));
				}
				if (retBean.getName().equalsIgnoreCase(employeeName)) {
					list.add(retBean);
				}
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
}
