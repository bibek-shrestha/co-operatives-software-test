package com.kjjcsoft.model;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

import com.kjjcsoft.bean.UserBean;

public class AuthenticateUser {
	private Connection con = null;
	PreparedStatement st= null;
	ResultSet rs=null;
	String digested_pwd;
	public boolean authenticate(UserBean u) throws NoSuchAlgorithmException{
		boolean result=false;
		try {
			con=ConnectionProvider.getConnection();
			digested_pwd=EncryptorClass.encrypt(u.getPassword());
			st= con.prepareStatement("Select password, user_enabled from tbl_user where username=?");
			st.setString(1, u.getUsername());
			rs=st.executeQuery();
			while(rs.next()){
				if ((rs.getString("password").equals(digested_pwd)) && (rs.getBoolean("user_enabled")!=false)) {
					result=true;
				} else {
					result=false;
				}
			}
		}
		catch(SQLException ex){
			System.out.println("exception catched" + ex);
		}
		finally{
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
