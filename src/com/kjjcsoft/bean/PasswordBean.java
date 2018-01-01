/**
 * 
 */
package com.kjjcsoft.bean;

/**
 * @author Seekraw
 *
 */
public class PasswordBean {
	private String oldPassword;
	private String newPassword;
	private String repeatPassword;
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getRepeatPassword() {
		return repeatPassword;
	}
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	public int validation(){
		if(newPassword.length()<8){
			return 3;
		} else if(newPassword.matches("\\s+.*")){
			return 1;
		} else if(newPassword.matches(".*\\s+.*")){
			return 1;
		} else if(newPassword.matches(".*\\W+.*")){
			return 2;
		} else if(newPassword.matches("\\W+.*")){
			return 2;
		} else{
			return 0;
		}
	}
	public boolean checkNewPasswords(){
		if(repeatPassword.equals(newPassword)){
			return true;
		}
		else{
			return false;
		}
	}
}
