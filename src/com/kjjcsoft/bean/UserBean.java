package com.kjjcsoft.bean;

public class UserBean {
	private String username;
	private String password;
	private int employee_id;
	private String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public int passwordValidation(){
		if(password.length()<8){
			return 3;
		} else if(password.matches("\\s+.*")){
			return 1;
		} else if(password.matches(".*\\s+.*")){
			return 1;
		} else if(password.matches(".*\\W+.*")){
			return 2;
		} else if(password.matches("\\W+.*")){
			return 2;
		} else{
			return 0;
		}
	}
	public int userNameValidation(){
		if (username.matches("\\s+.*")) {
			return 1;
		} else if (username.matches(".*\\s+.*")) {
			return 1;
		} else if (username.length()<1) {
			return 2;
		} else if (username.matches(".*\\W+.*")) {
			return 3;
		} else if (username.matches("\\W+.*")) {
			return 3;
		} else {
			return 0;
		}
	}
}
