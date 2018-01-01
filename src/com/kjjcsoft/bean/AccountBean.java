/**
 * 
 */
package com.kjjcsoft.bean;

import org.apache.commons.lang3.text.WordUtils;

/**
 * @author Seekraw
 */
public class AccountBean {
	private int accountId;
	private String customerId;
	private String accountType;
	private String interestRate;
	private String approvedBy;
	private int entryBy;
	private String years;
	private String maturityPeriod;
	private String creationDate;
	private String fixedDepositAmount;
	private String customerName;
	private boolean status;
	private String enteredby;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}
	public String getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	public String getYears() {
		return years;
	}
	public void setYears(String years) {
		this.years = years;
	}
	public String getMaturityPeriod() {
		return maturityPeriod;
	}
	public void setMaturityPeriod(String maturityPeriod) {
		this.maturityPeriod = maturityPeriod;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getFixedDepositAmount() {
		return fixedDepositAmount;
	}
	public void setFixedDepositAmount(String fixedDepositAmount) {
		this.fixedDepositAmount = fixedDepositAmount;
	}
	public int getEntryBy() {
		return entryBy;
	}
	public void setEntryBy(int entryBy) {
		this.entryBy = entryBy;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getEnteredby() {
		return enteredby;
	}
	public void setEnteredby(String enteredby) {
		this.enteredby = enteredby;
	}
	public int validateCustomerId(){
		customerId = customerId.replaceAll("\\s+", " ").trim();
		customerId = WordUtils.capitalizeFully(customerId);
		if (customerId.length()<1) {
			return 11;
		} else if (customerId.matches("\\d+")) {
			return 0;
		} else {
			return 12;
		}
	}
	public int validateInterestRate(){
		interestRate = interestRate.replace("\\s+", " ").trim();
		interestRate = WordUtils.capitalizeFully(interestRate);
		if (interestRate.length()<1) {
			return 22;
		} else if (interestRate.matches("\\d{0,2}.\\d{0,3}") || interestRate.matches("\\d{0,2}") ) {
			return 0;
		} else {
			return 21;
		}
	}
	public int validateApprovedBy(){
		approvedBy = approvedBy.replaceAll("\\s+", " ").trim();
		approvedBy = WordUtils.capitalizeFully(approvedBy);
		if (approvedBy.length() < 1) {
			return 31;
		} else if (approvedBy.matches(".*[!@#$%^&*()_+=-><,.;~`:\"\'].*") || approvedBy.matches("^\\d+.*") || approvedBy.matches(".*\\d+.*")) {
			return 32;
		} else {
			return 0;
		}
	}
	public int validateYears(){
		years = years.replace("\\s+", " ").trim();
		years = WordUtils.capitalizeFully(years);
		if (years.length() < 1) {
			return 41;
		} else if (years.matches("\\d{1,3}")) {
			return 0;
		} else {
			return 42;
		}
	}
	public int validateFixedDepositAmount(){
		fixedDepositAmount = fixedDepositAmount.replace("\\s+", " ").trim();
		fixedDepositAmount = WordUtils.capitalizeFully(fixedDepositAmount);
		if (fixedDepositAmount.length() < 1) {
			return 51;
		} else if (fixedDepositAmount.matches("\\d+")||fixedDepositAmount.matches("\\d+.\\d+")) {
			return 0;
		} else {
			return 52;
		}
	}
	public int validateAccountType(){
		if(accountType.matches("ms")||accountType.matches("ds")||accountType.matches("cfd")||accountType.matches("fds")) {
			return 0;
		} else {
			return 61;
		}
	}
}
