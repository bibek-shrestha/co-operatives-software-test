/**
 * 
 */
package com.kjjcsoft.model;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Seekraw
 *
 */
public class Password {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	public boolean authenticatePassword(String password, int userId){
		boolean retResult= false;
		String encryptedPassword = null;
		try {
			encryptedPassword = EncryptorClass.encrypt(password);
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try{
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT password from tbl_user WHERE user_id=?");
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			if (rs.next()) {
				if (encryptedPassword.equals(rs.getString("password"))) {
					retResult=true;
				} else {
					retResult=false;
				}
			} else {
				retResult = false;
			}
		} catch(SQLException ex){
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
		return retResult;
	}
	public boolean updatePassword(String encPass, int userId){
		boolean updated = false;
		try{
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("UPDATE tbl_user SET password=? WHERE user_id=?");
			ps.setString(1, encPass);
			ps.setInt(2, userId);
			ps.executeUpdate();
			updated = true;
		} catch (SQLException ex){
			updated = false;
			ex.printStackTrace();
		}
		return updated;
	}
}
