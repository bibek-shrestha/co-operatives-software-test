/**
 * 
 */
package com.kjjcsoft.bean;

/**
 * @author Seekraw
 *
 */
public class UserLogBean {
	public String loginTime;
	public String logoutTime;
	public int userId;
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public String getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
