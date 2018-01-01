/**
 * 
 */
package com.kjjcsoft.bean;
/**
 * @author Seekraw
 */
public class TransactionBean {
	public int transactionId;
	public String customerId;
	public String accoutType;
	public String accountId;
	public String deposit;
	public String withdrawal;
	public String fixedDepositAmount;
	public String collectorId;
	public int entryBy;
	public String references;
	public double principalAmount;
	public double interestForNext;
	public double totalInterest;
	public double totalAmount;
	public String date;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getAccoutType() {
		return accoutType;
	}
	public void setAccoutType(String accoutType) {
		this.accoutType = accoutType;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getWithdrawal() {
		return withdrawal;
	}
	public void setWithdrawal(String withdrawal) {
		this.withdrawal = withdrawal;
	}
	public String getFixedDepositAmount() {
		return fixedDepositAmount;
	}
	public void setFixedDepositAmount(String fixedDepositAmount) {
		this.fixedDepositAmount = fixedDepositAmount;
	}
	public String getCollectorId() {
		return collectorId;
	}
	public void setCollectorId(String collectorId) {
		this.collectorId = collectorId;
	}
	public int getEntryBy() {
		return entryBy;
	}
	public void setEntryBy(int entryBy) {
		this.entryBy = entryBy;
	}
	public String getReferences() {
		return references;
	}
	public void setReferences(String references) {
		this.references = references;
	}
	public double getPrincipalAmount() {
		return principalAmount;
	}
	public void setPrincipalAmount(double principalAmount) {
		this.principalAmount = principalAmount;
	}
	public double getInterestForNext() {
		return interestForNext;
	}
	public void setInterestForNext(double interestForNext) {
		this.interestForNext = interestForNext;
	}
	public double getTotalInterest() {
		return totalInterest;
	}
	public void setTotalInterest(double totalInterest) {
		this.totalInterest = totalInterest;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
