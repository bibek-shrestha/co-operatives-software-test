/**
 * 
 */
package com.kjjcsoft.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.kjjcsoft.bean.TransactionBean;

/**
 * @author Seekraw
 *
 */
public class Transaction {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public boolean collectorTransactionInsertion(TransactionBean recBean) {
		boolean inserted = false;

		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(
					"INSERT INTO tbl_saving_transactions (date, customer_id, account_type, account_number, deposit_amount, withdrawal_amount, reference, principal_amount, interest_for_next, total_interest, total_amount, collector_id, entry_by ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, recBean.getDate());
			ps.setString(2, recBean.getCustomerId());
			ps.setString(3, recBean.getAccoutType());
			ps.setString(4, recBean.getAccountId());
			ps.setString(5, recBean.getDeposit());
			ps.setString(6, recBean.getWithdrawal());
			ps.setString(7, recBean.getReferences());
			ps.setDouble(8, recBean.getPrincipalAmount());
			ps.setDouble(9, recBean.getInterestForNext());
			ps.setDouble(10, recBean.getTotalInterest());
			ps.setDouble(11, recBean.getTotalAmount());
			ps.setString(12, recBean.getCollectorId());
			ps.setInt(13, recBean.getEntryBy());
			ps.executeUpdate();
			inserted = true;
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
		return inserted;
	}

	public String lastInsertedDate(String acType, int accountId) {
		String lastDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(
					"SELECT date FROM tbl_saving_transactions WHERE (account_type= ? AND account_number=?) ORDER BY date DESC LIMIT 1");
			ps.setString(1, acType);
			ps.setInt(2, accountId);
			rs = ps.executeQuery();
			if (rs.next()) {
				lastDate = rs.getString("date");
			} else {
				Date dt = new Date();
				lastDate = sdf.format(dt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
		return lastDate;
	}

	public TransactionBean getLastInsertedData(String acType, int accountId) {
		TransactionBean lastData = new TransactionBean();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(
					"SELECT * FROM tbl_saving_transactions WHERE account_type=? AND account_number=? ORDER BY date DESC LIMIT 1");
			ps.setString(1, acType);
			ps.setInt(2, accountId);
			rs = ps.executeQuery();
			if (rs.next()) {
				lastData.setTransactionId(rs.getInt("transaction_id"));
				lastData.setDate(rs.getString("date"));
				lastData.setCustomerId(rs.getString("customer_id"));
				lastData.setAccoutType(rs.getString("account_type"));
				lastData.setAccountId(rs.getString("account_number"));
				lastData.setDeposit(rs.getString("deposit_amount"));
				lastData.setWithdrawal(rs.getString("withdrawal_amount"));
				lastData.setReferences(rs.getString("reference"));
				lastData.setPrincipalAmount(rs.getDouble("principal_amount"));
				lastData.setInterestForNext(rs.getDouble("interest_for_next"));
				lastData.setTotalInterest(rs.getDouble("total_interest"));
				lastData.setTotalAmount(rs.getDouble("total_amount"));
				lastData.setCollectorId(rs.getString("collector_id"));
				lastData.setEntryBy(rs.getInt("entry_by"));
			} else {
				lastData.setPrincipalAmount(0);
				lastData.setInterestForNext(0);
				lastData.setTotalInterest(0);
				lastData.setTotalAmount(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
		return lastData;
	}
	public boolean officeTransactionInsertion(TransactionBean recBean) {
		boolean inserted = false;

		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(
					"INSERT INTO tbl_saving_transactions (date, customer_id, account_type, account_number, deposit_amount, withdrawal_amount, reference, principal_amount, interest_for_next, total_interest, total_amount, entry_by ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, recBean.getDate());
			ps.setString(2, recBean.getCustomerId());
			ps.setString(3, recBean.getAccoutType());
			ps.setString(4, recBean.getAccountId());
			ps.setString(5, recBean.getDeposit());
			ps.setString(6, recBean.getWithdrawal());
			ps.setString(7, recBean.getReferences());
			ps.setDouble(8, recBean.getPrincipalAmount());
			ps.setDouble(9, recBean.getInterestForNext());
			ps.setDouble(10, recBean.getTotalInterest());
			ps.setDouble(11, recBean.getTotalAmount());
			ps.setInt(12, recBean.getEntryBy());
			ps.executeUpdate();
			inserted = true;
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
		return inserted;
	}
}
