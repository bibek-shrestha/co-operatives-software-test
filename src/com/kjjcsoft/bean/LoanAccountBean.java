package com.kjjcsoft.bean;

import java.util.Date;

public class LoanAccountBean {
	private String accountId;
	private int customerId;
	private String accountType;
	private float interestRate;
	private String approvedBy;
	private String approvedAmount;
	private Date dateOfInvestment=new Date();
	private Date dateOfReturn=new Date();
	private int entryBy;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getApprovedAmount(){
		return approvedAmount;
	}
	
	public void setApprovedAmount(String approvedAmount){
		this.approvedAmount = approvedAmount;		
	}
	
	public Date getDateOfInvestment(){
		return dateOfInvestment;
	}
	
	public void setDateOfInvestment(Date dateOfInvestment){
		this.dateOfInvestment=dateOfInvestment;
	}
	
	public Date getDateOfReturn(){
		return dateOfReturn;
	}
	
	public void setDateOfReturn(Date dateOfReturn){
		this.dateOfReturn=dateOfReturn;
	}
	
	public int getEntryBy() {
		return entryBy;
	}

	public void setEntryBy(int entryBy) {
		this.entryBy = entryBy;
	}
	
	
}
