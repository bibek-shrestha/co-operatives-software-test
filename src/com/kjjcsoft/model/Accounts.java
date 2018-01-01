/**
 * 
 */
package com.kjjcsoft.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Years;

import com.kjjcsoft.bean.AccountBean;
/**
 * @author Seekraw
 */
public class Accounts {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private ResultSet rsNext;
	private ResultSet thirdRs;
	public Accounts() {
		con = null;
		ps = null;
		rs = null;
	}
	public boolean createDsAccount(AccountBean newDsAc) {
		boolean accountCreated = false;
		Date dt = new Date();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("INSERT INTO tbl_daily_savings (customer_id, interest_rate, creation_date, approved_by, entry_by) VALUES (?,?,?,?,?)");
			ps.setString(1, newDsAc.getCustomerId());
			ps.setString(2, newDsAc.getInterestRate());
			ps.setDate(3, DBFunctions.convertToSqlDate(dt));
			ps.setString(4, newDsAc.getApprovedBy());
			ps.setInt(5, newDsAc.getEntryBy());
			ps.executeUpdate();
			accountCreated = true;
		} catch (SQLException ex) {
			accountCreated = false;
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
		return accountCreated;
	}
	public AccountBean retLastDsAcCreated(String customer_id) {
		AccountBean retBean = new AccountBean();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT ds_id, customer_id, interest_rate from tbl_daily_savings WHERE customer_id=? ORDER BY ds_id DESC LIMIT 1");
			ps.setInt(1, Integer.parseInt(customer_id));
			rs = ps.executeQuery();
			if (rs.next()) {
				retBean.setAccountId(rs.getInt("ds_id"));
				retBean.setCustomerId(rs.getString("customer_id"));
				retBean.setInterestRate(rs.getString("interest_rate"));
			} else {
				retBean.setAccountId(0);
			}
		} catch (SQLException ex) {
			retBean.setAccountId(0);
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
		return retBean;
	}
	public boolean createMsAccount(AccountBean newMsAc) {
		boolean accountCreated = false;
		Date dt = new Date();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("INSERT into tbl_monthly_savings (customer_id, interest_rate, creation_date, approved_by, entry_by) VALUES (?,?,?,?,?)");
			ps.setString(1, newMsAc.getCustomerId());
			ps.setString(2, newMsAc.getInterestRate());
			ps.setDate(3, DBFunctions.convertToSqlDate(dt));
			ps.setString(4, newMsAc.getApprovedBy());
			ps.setInt(5, newMsAc.getEntryBy());
			ps.executeUpdate();
			accountCreated = true;
		} catch (SQLException ex) {
			accountCreated = false;
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
		return accountCreated;
	}
	public AccountBean retLastMsAcCreated(String customer_id) {
		AccountBean retBean = new AccountBean();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT ms_id, customer_id, interest_rate from tbl_monthly_savings WHERE customer_id=? ORDER BY ms_id DESC LIMIT 1");
			ps.setInt(1, Integer.parseInt(customer_id));
			rs = ps.executeQuery();
			if (rs.next()) {
				retBean.setAccountId(rs.getInt("ms_id"));
				retBean.setCustomerId(rs.getString("customer_id"));
				retBean.setInterestRate(rs.getString("interest_rate"));
			} else {
				retBean.setAccountId(0);
			}
		} catch (SQLException ex) {
			retBean.setAccountId(0);
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
		return retBean;
	}
	public boolean createFdsAccount(AccountBean newFdsAc) {
		boolean accountCreated = false;
		Date dt = new Date();
		Calendar date = Calendar.getInstance();
		date.add(Calendar.YEAR, Integer.parseInt(newFdsAc.getYears()));
		Date mDt = date.getTime();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("INSERT INTO tbl_fixed_deposit (customer_id, interest_rate, fd_amount, maturity_date, creation_date, approved_by, entry_by) VALUES (?,?,?,?,?,?,?)");
			ps.setString(1, newFdsAc.getCustomerId());
			ps.setString(2, newFdsAc.getInterestRate());
			ps.setString(3, newFdsAc.getFixedDepositAmount());
			ps.setDate(4, DBFunctions.convertToSqlDate(mDt));
			ps.setDate(5, DBFunctions.convertToSqlDate(dt));
			ps.setString(6, newFdsAc.getApprovedBy());
			ps.setInt(7, newFdsAc.getEntryBy());
			ps.executeUpdate();
			accountCreated = true;
		} catch (SQLException ex) {
			accountCreated = false;
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
		return accountCreated;
	}
	public AccountBean retLastFdsAcCreated(String customer_id) {
		AccountBean retBean = new AccountBean();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT fds_id, customer_id, interest_rate, fd_amount, maturity_date FROM tbl_fixed_deposit WHERE customer_id=? ORDER BY fds_id DESC LIMIT 1");
			ps.setInt(1, Integer.parseInt(customer_id));
			rs = ps.executeQuery();
			if (rs.next()) {
				retBean.setAccountId(rs.getInt("fds_id"));
				retBean.setCustomerId(rs.getString("customer_id"));
				retBean.setInterestRate(rs.getString("interest_rate"));
				retBean.setFixedDepositAmount(rs.getString("fd_amount"));
				retBean.setMaturityPeriod(rs.getString("maturity_date"));
			} else {
				retBean.setAccountId(0);
			}
		} catch (SQLException ex) {
			retBean.setAccountId(0);
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
		return retBean;
	}
	public boolean createCfdAccount(AccountBean newCfdAc) {
		boolean accountCreated = false;
		Date dt = new Date();
		Calendar cd = Calendar.getInstance();
		cd.add(Calendar.YEAR, Integer.parseInt(newCfdAc.getYears()));
		Date mDt = cd.getTime();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("INSERT INTO tbl_c_fixed_deposit (customer_id, interest_rate, maturity_date, creation_date, approved_by, entry_by) VALUES (?,?,?,?,?,?)");
			ps.setString(1, newCfdAc.getCustomerId());
			ps.setString(2, newCfdAc.getInterestRate());
			ps.setDate(3, DBFunctions.convertToSqlDate(mDt));
			ps.setDate(4, DBFunctions.convertToSqlDate(dt));
			ps.setString(5, newCfdAc.getApprovedBy());
			ps.setInt(6, newCfdAc.getEntryBy());
			ps.executeUpdate();
			accountCreated = true;
		} catch (SQLException ex) {
			accountCreated = false;
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
		return accountCreated;
	}
	public AccountBean retLastCfdAcCreated(String customer_id) {
		AccountBean retBean = new AccountBean();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT cfd_id, customer_id, interest_rate, maturity_date FROM tbl_c_fixed_deposit WHERE customer_id=? ORDER BY cfd_id DESC LIMIT 1");
			ps.setInt(1, Integer.parseInt(customer_id));
			rs = ps.executeQuery();
			if (rs.next()) {
				retBean.setAccountId(rs.getInt("cfd_id"));
				retBean.setCustomerId(rs.getString("customer_id"));
				retBean.setInterestRate(rs.getString("interest_rate"));
				retBean.setMaturityPeriod(rs.getString("maturity_date"));
			} else {
				retBean.setAccountId(0);
			}
		} catch (SQLException ex) {
			retBean.setAccountId(0);
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
		return retBean;
	}
	public int getCountDailySavings() {
		int count = 0;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT COUNT(ds_id) as count FROM tbl_daily_savings");
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
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
		return count;
	}
	public int getCountActiveDailySavings() {
		int count = 0;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT COUNT(ds_id) as count FROM tbl_daily_savings WHERE ac_status = 1");
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
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
		return count;
	}
	public int getCountInactiveDailySavings() {
		int count = 0;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT COUNT(ds_id) as count FROM tbl_daily_savings WHERE ac_status = 0");
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
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
		return count;
	}
	public int getCountMonthlySavings() {
		int count = 0;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT COUNT(ms_id) as count FROM tbl_monthly_savings");
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
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
		return count;
	}
	public int getCountActiveMonthlySavings() {
		int count = 0;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT COUNT(ms_id) as count FROM tbl_monthly_savings WHERE ac_status = 1");
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
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
		return count;
	}
	public int getCountInactiveMonthlySavings() {
		int count = 0;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT COUNT(ms_id) as count FROM tbl_monthly_savings WHERE ac_status = 0");
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
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
		return count;
	}
	public int getCountFixedDeposit() {
		int count = 0;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT COUNT(fds_id) as count FROM tbl_fixed_deposit");
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
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
		return count;
	}
	public int getCountActiveFixedDeposit() {
		int count = 0;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT COUNT(fds_id) as count FROM tbl_fixed_deposit WHERE ac_status = 1");
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
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
		return count;
	}
	public int getCountInactiveFixedDeposit() {
		int count = 0;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT COUNT(fds_id) as count FROM tbl_fixed_deposit WHERE ac_status = 0");
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
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
		return count;
	}
	public int getCountContinuousFixedDeposit() {
		int count = 0;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT COUNT(cfd_id) as count FROM tbl_c_fixed_deposit");
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
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
		return count;
	}
	public int getCountActiveContinuousFixedDeposit() {
		int count = 0;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT COUNT(cfd_id) as count FROM tbl_c_fixed_deposit WHERE ac_status = 1");
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
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
		return count;
	}
	public int getCountInactiveContinuousFixedDeposit() {
		int count = 0;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT COUNT(cfd_id) as count FROM tbl_c_fixed_deposit WHERE ac_status = 0");
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
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
		return count;
	}
	public ArrayList<AccountBean> getDailySavingAccounts() {
		boolean rsNextStatus = false;
		boolean thirdRsStatus = false;
		ArrayList<AccountBean> list = new ArrayList<AccountBean>();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT * FROM tbl_daily_savings");
			rs = ps.executeQuery();
			while (rs.next()) {
				AccountBean accountList = new AccountBean();
				accountList.setAccountId(rs.getInt("ds_id"));
				accountList.setCustomerId(rs.getString("customer_id"));
				accountList.setInterestRate(rs.getString("interest_rate"));
				accountList.setCreationDate(rs.getString("creation_date"));
				accountList.setApprovedBy(rs.getString("approved_by"));
				accountList.setEntryBy(rs.getInt("entry_by"));
				accountList.setStatus(rs.getBoolean("ac_status"));
				rsNext = con.prepareStatement("SELECT customer_name FROM tbl_customer WHERE customer_id=" + accountList.getCustomerId()).executeQuery();
				if (rsNext.next()) {
					accountList.setCustomerName(rsNext.getString("customer_name"));
					rsNextStatus = true;
				}
				thirdRs = con.prepareStatement("SELECT username FROM tbl_user WHERE user_id =" + accountList.getEntryBy()).executeQuery();
				if (thirdRs.next()) {
					accountList.setEnteredby(thirdRs.getString("username"));
					thirdRsStatus = true;
				}
				list.add(accountList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rsNextStatus) {
				try {
					rsNext.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (thirdRsStatus) {
				try {
					thirdRs.next();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
	public ArrayList<AccountBean> getMonthlySavingAccounts() {
		boolean rsNextStatus = false;
		boolean thirdRsStatus = false;
		ArrayList<AccountBean> list = new ArrayList<AccountBean>();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT * FROM tbl_monthly_savings");
			rs = ps.executeQuery();
			while (rs.next()) {
				AccountBean accountList = new AccountBean();
				accountList.setAccountId(rs.getInt("ms_id"));
				accountList.setCustomerId(rs.getString("customer_id"));
				accountList.setInterestRate(rs.getString("interest_rate"));
				accountList.setCreationDate(rs.getString("creation_date"));
				accountList.setApprovedBy(rs.getString("approved_by"));
				accountList.setEntryBy(rs.getInt("entry_by"));
				accountList.setStatus(rs.getBoolean("ac_status"));
				rsNext = con.prepareStatement("SELECT customer_name FROM tbl_customer WHERE customer_id=" + accountList.getCustomerId()).executeQuery();
				if (rsNext.next()) {
					accountList.setCustomerName(rsNext.getString("customer_name"));
					rsNextStatus = true;
				}
				thirdRs = con.prepareStatement("SELECT username FROM tbl_user WHERE user_id =" + accountList.getEntryBy()).executeQuery();
				if (thirdRs.next()) {
					accountList.setEnteredby(thirdRs.getString("username"));
					thirdRsStatus = true;
				}
				list.add(accountList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rsNextStatus) {
				try {
					rsNext.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (thirdRsStatus) {
				try {
					thirdRs.next();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
	public ArrayList<AccountBean> getFixedDepositAccounts() {
		boolean rsNextStatus = false;
		boolean thirdRsStatus = false;
		ArrayList<AccountBean> list = new ArrayList<AccountBean>();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT * FROM tbl_fixed_deposit");
			rs = ps.executeQuery();
			while (rs.next()) {
				AccountBean accountList = new AccountBean();
				accountList.setAccountId(rs.getInt("fds_id"));
				accountList.setCustomerId(rs.getString("customer_id"));
				accountList.setInterestRate(rs.getString("interest_rate"));
				accountList.setFixedDepositAmount(rs.getString("fd_amount"));
				accountList.setMaturityPeriod(rs.getString("maturity_date"));
				accountList.setCreationDate(rs.getString("creation_date"));
				accountList.setApprovedBy(rs.getString("approved_by"));
				accountList.setEntryBy(rs.getInt("entry_by"));
				accountList.setStatus(rs.getBoolean("ac_status"));
				rsNext = con.prepareStatement("SELECT customer_name FROM tbl_customer WHERE customer_id=" + accountList.getCustomerId()).executeQuery();
				if (rsNext.next()) {
					accountList.setCustomerName(rsNext.getString("customer_name"));
					rsNextStatus = true;
				}
				thirdRs = con.prepareStatement("SELECT username FROM tbl_user WHERE user_id =" + accountList.getEntryBy()).executeQuery();
				if (thirdRs.next()) {
					accountList.setEnteredby(thirdRs.getString("username"));
					thirdRsStatus = true;
				}
				list.add(accountList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rsNextStatus) {
				try {
					rsNext.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (thirdRsStatus) {
				try {
					thirdRs.next();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
	public ArrayList<AccountBean> getCFixedDepositAccounts() {
		boolean rsNextStatus = false;
		boolean thirdRsStatus = false;
		ArrayList<AccountBean> list = new ArrayList<AccountBean>();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT * FROM tbl_c_fixed_deposit");
			rs = ps.executeQuery();
			while (rs.next()) {
				AccountBean accountList = new AccountBean();
				accountList.setAccountId(rs.getInt("cfd_id"));
				accountList.setCustomerId(rs.getString("customer_id"));
				accountList.setInterestRate(rs.getString("interest_rate"));
				accountList.setMaturityPeriod(rs.getString("maturity_date"));
				accountList.setCreationDate(rs.getString("creation_date"));
				accountList.setApprovedBy(rs.getString("approved_by"));
				accountList.setEntryBy(rs.getInt("entry_by"));
				accountList.setStatus(rs.getBoolean("ac_status"));
				rsNext = con.prepareStatement("SELECT customer_name FROM tbl_customer WHERE customer_id=" + accountList.getCustomerId()).executeQuery();
				if (rsNext.next()) {
					accountList.setCustomerName(rsNext.getString("customer_name"));
					rsNextStatus = true;
				}
				thirdRs = con.prepareStatement("SELECT username FROM tbl_user WHERE user_id =" + accountList.getEntryBy()).executeQuery();
				if (thirdRs.next()) {
					accountList.setEnteredby(thirdRs.getString("username"));
					thirdRsStatus = true;
				}
				list.add(accountList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rsNextStatus) {
				try {
					rsNext.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (thirdRsStatus) {
				try {
					thirdRs.next();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
	public ArrayList<AccountBean> searchForEdit(String acType, int accountId) {
		ArrayList<AccountBean> list = new ArrayList<AccountBean>();
		boolean rsNextStatus = false;
		boolean thirdRsStatus = false;
		if (acType.equals("ds")) {
			try {
				con = ConnectionProvider.getConnection();
				ps = con.prepareStatement("SELECT * FROM tbl_daily_savings WHERE ds_id=?");
				ps.setInt(1, accountId);
				rs = ps.executeQuery();
				while (rs.next()) {
					AccountBean accountList = new AccountBean();
					accountList.setAccountId(rs.getInt("ds_id"));
					accountList.setCustomerId(rs.getString("customer_id"));
					accountList.setInterestRate(rs.getString("interest_rate"));
					accountList.setCreationDate(rs.getString("creation_date"));
					accountList.setApprovedBy(rs.getString("approved_by"));
					accountList.setEntryBy(rs.getInt("entry_by"));
					accountList.setStatus(rs.getBoolean("ac_status"));
					rsNext = con.prepareStatement("SELECT customer_name FROM tbl_customer WHERE customer_id=" + accountList.getCustomerId()).executeQuery();
					if (rsNext.next()) {
						accountList.setCustomerName(rsNext.getString("customer_name"));
						rsNextStatus = true;
					}
					thirdRs = con.prepareStatement("SELECT username FROM tbl_user WHERE user_id =" + accountList.getEntryBy()).executeQuery();
					if (thirdRs.next()) {
						accountList.setEnteredby(thirdRs.getString("username"));
						thirdRsStatus = true;
					}
					list.add(accountList);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (rsNextStatus) {
					try {
						rsNext.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (thirdRsStatus) {
					try {
						thirdRs.next();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
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
		} else if (acType.equals("ms")) {
			try {
				con = ConnectionProvider.getConnection();
				ps = con.prepareStatement("SELECT * FROM tbl_monthly_savings WHERE ms_id = ?");
				ps.setInt(1, accountId);
				rs = ps.executeQuery();
				while (rs.next()) {
					AccountBean accountList = new AccountBean();
					accountList.setAccountId(rs.getInt("ms_id"));
					accountList.setCustomerId(rs.getString("customer_id"));
					accountList.setInterestRate(rs.getString("interest_rate"));
					accountList.setCreationDate(rs.getString("creation_date"));
					accountList.setApprovedBy(rs.getString("approved_by"));
					accountList.setEntryBy(rs.getInt("entry_by"));
					accountList.setStatus(rs.getBoolean("ac_status"));
					rsNext = con.prepareStatement("SELECT customer_name FROM tbl_customer WHERE customer_id=" + accountList.getCustomerId()).executeQuery();
					if (rsNext.next()) {
						accountList.setCustomerName(rsNext.getString("customer_name"));
						rsNextStatus = true;
					}
					thirdRs = con.prepareStatement("SELECT username FROM tbl_user WHERE user_id =" + accountList.getEntryBy()).executeQuery();
					if (thirdRs.next()) {
						accountList.setEnteredby(thirdRs.getString("username"));
						thirdRsStatus = true;
					}
					list.add(accountList);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (rsNextStatus) {
					try {
						rsNext.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (thirdRsStatus) {
					try {
						thirdRs.next();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
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
		} else if (acType.equals("fds")) {
			try {
				con = ConnectionProvider.getConnection();
				ps = con.prepareStatement("SELECT * FROM tbl_fixed_deposit WHERE fds_id = ?");
				ps.setInt(1, accountId);
				rs = ps.executeQuery();
				while (rs.next()) {
					AccountBean accountList = new AccountBean();
					accountList.setAccountId(rs.getInt("fds_id"));
					accountList.setCustomerId(rs.getString("customer_id"));
					accountList.setInterestRate(rs.getString("interest_rate"));
					accountList.setFixedDepositAmount(rs.getString("fd_amount"));
					accountList.setMaturityPeriod(rs.getString("maturity_date"));
					accountList.setCreationDate(rs.getString("creation_date"));
					accountList.setApprovedBy(rs.getString("approved_by"));
					accountList.setEntryBy(rs.getInt("entry_by"));
					accountList.setStatus(rs.getBoolean("ac_status"));
					rsNext = con.prepareStatement("SELECT customer_name FROM tbl_customer WHERE customer_id=" + accountList.getCustomerId()).executeQuery();
					if (rsNext.next()) {
						accountList.setCustomerName(rsNext.getString("customer_name"));
						rsNextStatus = true;
					}
					thirdRs = con.prepareStatement("SELECT username FROM tbl_user WHERE user_id =" + accountList.getEntryBy()).executeQuery();
					if (thirdRs.next()) {
						accountList.setEnteredby(thirdRs.getString("username"));
						thirdRsStatus = true;
					}
					list.add(accountList);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (rsNextStatus) {
					try {
						rsNext.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (thirdRsStatus) {
					try {
						thirdRs.next();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
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
		} else if (acType.equals("cfd")) {
			try {
				con = ConnectionProvider.getConnection();
				ps = con.prepareStatement("SELECT * FROM tbl_c_fixed_deposit WHERE cfd_id = ?");
				ps.setInt(1, accountId);
				rs = ps.executeQuery();
				while (rs.next()) {
					AccountBean accountList = new AccountBean();
					accountList.setAccountId(rs.getInt("cfd_id"));
					accountList.setCustomerId(rs.getString("customer_id"));
					accountList.setInterestRate(rs.getString("interest_rate"));
					accountList.setMaturityPeriod(rs.getString("maturity_date"));
					accountList.setCreationDate(rs.getString("creation_date"));
					accountList.setApprovedBy(rs.getString("approved_by"));
					accountList.setEntryBy(rs.getInt("entry_by"));
					accountList.setStatus(rs.getBoolean("ac_status"));
					rsNext = con.prepareStatement("SELECT customer_name FROM tbl_customer WHERE customer_id=" + accountList.getCustomerId()).executeQuery();
					if (rsNext.next()) {
						accountList.setCustomerName(rsNext.getString("customer_name"));
						rsNextStatus = true;
					}
					thirdRs = con.prepareStatement("SELECT username FROM tbl_user WHERE user_id =" + accountList.getEntryBy()).executeQuery();
					if (thirdRs.next()) {
						accountList.setEnteredby(thirdRs.getString("username"));
						thirdRsStatus = true;
					}
					list.add(accountList);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (rsNextStatus) {
					try {
						rsNext.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (thirdRsStatus) {
					try {
						thirdRs.next();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
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
		}
		return list;
	}
	public void disableDsAc(int accountId) {
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("UPDATE tbl_daily_savings SET ac_status = 0 WHERE ds_id = ?");
			ps.setInt(1, accountId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
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
	public void disableMsAc(int accountId) {
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("UPDATE tbl_monthly_savings SET ac_status = 0 WHERE ms_id = ?");
			ps.setInt(1, accountId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
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
	public void disableFdsAc(int accountId) {
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("UPDATE tbl_fixed_deposit SET ac_status = 0 WHERE fds_id = ?");
			ps.setInt(1, accountId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
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
	public void disableCfdAc(int accountId) {
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("UPDATE tbl_c_fixed_deposit SET ac_status = 0 WHERE cfd_id = ?");
			ps.setInt(1, accountId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
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
	public void enableDsAc(int accountId) {
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("UPDATE tbl_daily_savings SET ac_status = 1 WHERE ds_id = ?");
			ps.setInt(1, accountId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
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
	public void enableMsAc(int accountId) {
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("UPDATE tbl_monthly_savings SET ac_status = 1 WHERE ms_id = ?");
			ps.setInt(1, accountId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
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
	public void enableFdsAc(int accountId) {
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("UPDATE tbl_fixed_deposit SET ac_status = 1 WHERE fds_id = ?");
			ps.setInt(1, accountId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
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
	public void enableCfdAc(int accountId) {
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("UPDATE tbl_c_fixed_deposit SET ac_status = 1 WHERE cfd_id = ?");
			ps.setInt(1, accountId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
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
	public AccountBean getInfoFromDb(String acType, int accountId) {
		AccountBean accountList = new AccountBean();
		boolean rsNextStatus = false;
		boolean thirdRsStatus = false;
		if (acType.equals("ds")) {
			try {
				con = ConnectionProvider.getConnection();
				ps = con.prepareStatement("SELECT * FROM tbl_daily_savings WHERE ds_id=?");
				ps.setInt(1, accountId);
				rs = ps.executeQuery();
				while (rs.next()) {
					accountList.setAccountId(rs.getInt("ds_id"));
					accountList.setCustomerId(rs.getString("customer_id"));
					accountList.setInterestRate(rs.getString("interest_rate"));
					accountList.setCreationDate(rs.getString("creation_date"));
					accountList.setApprovedBy(rs.getString("approved_by"));
					accountList.setEntryBy(rs.getInt("entry_by"));
					accountList.setStatus(rs.getBoolean("ac_status"));
					rsNext = con.prepareStatement("SELECT customer_name FROM tbl_customer WHERE customer_id=" + accountList.getCustomerId()).executeQuery();
					if (rsNext.next()) {
						accountList.setCustomerName(rsNext.getString("customer_name"));
						rsNextStatus = true;
					}
					thirdRs = con.prepareStatement("SELECT username FROM tbl_user WHERE user_id =" + accountList.getEntryBy()).executeQuery();
					if (thirdRs.next()) {
						accountList.setEnteredby(thirdRs.getString("username"));
						thirdRsStatus = true;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (rsNextStatus) {
					try {
						rsNext.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (thirdRsStatus) {
					try {
						thirdRs.next();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
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
		} else if (acType.equals("ms")) {
			try {
				con = ConnectionProvider.getConnection();
				ps = con.prepareStatement("SELECT * FROM tbl_monthly_savings WHERE ms_id = ?");
				ps.setInt(1, accountId);
				rs = ps.executeQuery();
				while (rs.next()) {
					accountList.setAccountId(rs.getInt("ms_id"));
					accountList.setCustomerId(rs.getString("customer_id"));
					accountList.setInterestRate(rs.getString("interest_rate"));
					accountList.setCreationDate(rs.getString("creation_date"));
					accountList.setApprovedBy(rs.getString("approved_by"));
					accountList.setEntryBy(rs.getInt("entry_by"));
					accountList.setStatus(rs.getBoolean("ac_status"));
					rsNext = con.prepareStatement("SELECT customer_name FROM tbl_customer WHERE customer_id=" + accountList.getCustomerId()).executeQuery();
					if (rsNext.next()) {
						accountList.setCustomerName(rsNext.getString("customer_name"));
						rsNextStatus = true;
					}
					thirdRs = con.prepareStatement("SELECT username FROM tbl_user WHERE user_id =" + accountList.getEntryBy()).executeQuery();
					if (thirdRs.next()) {
						accountList.setEnteredby(thirdRs.getString("username"));
						thirdRsStatus = true;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (rsNextStatus) {
					try {
						rsNext.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (thirdRsStatus) {
					try {
						thirdRs.next();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
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
		} else if (acType.equals("fds")) {
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			Date mdate = null;
			Date jdate = null;
			DateTime d2 = null;
			DateTime d1	= null;
			try {
				con = ConnectionProvider.getConnection();
				ps = con.prepareStatement("SELECT * FROM tbl_fixed_deposit WHERE fds_id = ?");
				ps.setInt(1, accountId);
				rs = ps.executeQuery();
				while (rs.next()) {
					accountList.setAccountId(rs.getInt("fds_id"));
					accountList.setCustomerId(rs.getString("customer_id"));
					accountList.setInterestRate(rs.getString("interest_rate"));
					accountList.setFixedDepositAmount(rs.getString("fd_amount"));
					accountList.setMaturityPeriod(rs.getString("maturity_date"));
					accountList.setCreationDate(rs.getString("creation_date"));
					accountList.setApprovedBy(rs.getString("approved_by"));
					try {
						mdate = sdf.parse(accountList.getMaturityPeriod());
						jdate = sdf.parse(accountList.getCreationDate());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					d2 = new DateTime(mdate);
					d1= new DateTime(jdate);
					accountList.setYears(String.valueOf(Years.yearsBetween(d1, d2).getYears()));
					accountList.setEntryBy(rs.getInt("entry_by"));
					accountList.setStatus(rs.getBoolean("ac_status"));
					rsNext = con.prepareStatement("SELECT customer_name FROM tbl_customer WHERE customer_id=" + accountList.getCustomerId()).executeQuery();
					if (rsNext.next()) {
						accountList.setCustomerName(rsNext.getString("customer_name"));
						rsNextStatus = true;
					}
					thirdRs = con.prepareStatement("SELECT username FROM tbl_user WHERE user_id =" + accountList.getEntryBy()).executeQuery();
					if (thirdRs.next()) {
						accountList.setEnteredby(thirdRs.getString("username"));
						thirdRsStatus = true;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (rsNextStatus) {
					try {
						rsNext.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (thirdRsStatus) {
					try {
						thirdRs.next();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
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
		} else if (acType.equals("cfd")) {
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			Date mdate = null;
			Date jdate = null;
			DateTime d2 = null;
			DateTime d1	= null;
			try {
				con = ConnectionProvider.getConnection();
				ps = con.prepareStatement("SELECT * FROM tbl_c_fixed_deposit WHERE cfd_id = ?");
				ps.setInt(1, accountId);
				rs = ps.executeQuery();
				while (rs.next()) {
					accountList.setAccountId(rs.getInt("cfd_id"));
					accountList.setCustomerId(rs.getString("customer_id"));
					accountList.setInterestRate(rs.getString("interest_rate"));
					accountList.setMaturityPeriod(rs.getString("maturity_date"));
					accountList.setCreationDate(rs.getString("creation_date"));
					accountList.setApprovedBy(rs.getString("approved_by"));
					try {
						mdate = sdf.parse(accountList.getMaturityPeriod());
						jdate = sdf.parse(accountList.getCreationDate());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					d2 = new DateTime(mdate);
					d1= new DateTime(jdate);
					accountList.setYears(String.valueOf(Years.yearsBetween(d1, d2).getYears()));
					accountList.setEntryBy(rs.getInt("entry_by"));
					accountList.setStatus(rs.getBoolean("ac_status"));
					rsNext = con.prepareStatement("SELECT customer_name FROM tbl_customer WHERE customer_id=" + accountList.getCustomerId()).executeQuery();
					if (rsNext.next()) {
						accountList.setCustomerName(rsNext.getString("customer_name"));
						rsNextStatus = true;
					}
					thirdRs = con.prepareStatement("SELECT username FROM tbl_user WHERE user_id =" + accountList.getEntryBy()).executeQuery();
					if (thirdRs.next()) {
						accountList.setEnteredby(thirdRs.getString("username"));
						thirdRsStatus = true;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (rsNextStatus) {
					try {
						rsNext.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (thirdRsStatus) {
					try {
						thirdRs.next();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
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
		}
		return accountList;
	}
	public boolean editAccount(int accountId, AccountBean recBean) {
		boolean edited = false;
		try {
			con = ConnectionProvider.getConnection();
			if (recBean.getAccountType().equals("ds")) {
				ps = con.prepareStatement("UPDATE tbl_daily_savings SET customer_id =?, interest_rate = ?, approved_by=? WHERE ds_id =? ");
				ps.setString(1, recBean.getCustomerId());
				ps.setString(2, recBean.getInterestRate());
				ps.setString(3, recBean.getApprovedBy());
				ps.setInt(4, accountId);
				ps.executeUpdate();
				edited = true;
			} else if (recBean.getAccountType().equals("ms")) {
				ps = con.prepareStatement("UPDATE tbl_monthly_savings SET customer_id =?, interest_rate = ?, approved_by=? WHERE ms_id =? ");
				ps.setString(1, recBean.getCustomerId());
				ps.setString(2, recBean.getInterestRate());
				ps.setString(3, recBean.getApprovedBy());
				ps.setInt(4, accountId);
				ps.executeUpdate();
				edited = true;
			} else if (recBean.getAccountType().equals("fds")) {
				Calendar date = Calendar.getInstance();
				date.add(Calendar.YEAR, Integer.parseInt(recBean.getYears()));
				Date mDt = date.getTime();
				ps = con.prepareStatement("UPDATE tbl_fixed_deposit SET customer_id =?, interest_rate = ?, fd_amount=?, maturity_date=?, approved_by=? WHERE fds_id =? ");
				ps.setString(1, recBean.getCustomerId());
				ps.setString(2, recBean.getInterestRate());
				ps.setString(3, recBean.getFixedDepositAmount());
				ps.setDate(4, DBFunctions.convertToSqlDate(mDt));
				ps.setString(5, recBean.getApprovedBy());
				ps.setInt(6, accountId);
				ps.executeUpdate();
				edited = true;
			} else if (recBean.getAccountType().equals("cfd")) {
				Calendar date = Calendar.getInstance();
				date.add(Calendar.YEAR, Integer.parseInt(recBean.getYears()));
				Date mDt = date.getTime();
				ps = con.prepareStatement("UPDATE tbl_c_fixed_deposit SET customer_id =?, interest_rate = ?, maturity_date=?, approved_by=? WHERE cfd_id =? ");
				ps.setString(1, recBean.getCustomerId());
				ps.setString(2, recBean.getInterestRate());
				ps.setDate(3, DBFunctions.convertToSqlDate(mDt));
				ps.setString(4, recBean.getApprovedBy());
				ps.setInt(5, accountId);
				ps.executeUpdate();
				edited = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
		return edited;
	}
	public boolean exists(String acType, int accountId, int customerId){
		boolean exists = false;
		try{
			con = ConnectionProvider.getConnection();
			if (acType.equals("ds")) {
				ps = con.prepareStatement("SELECT ds_id from tbl_daily_savings WHERE (ds_id=? AND customer_id=?)");
				ps.setInt(1, accountId);
				ps.setInt(2, customerId);
				rs = ps.executeQuery();
				if (rs.next()) {
					exists = true;
				}
			} else if (acType.equals("ms")) {
				ps = con.prepareStatement("SELECT ms_id from tbl_monthly_savings WHERE (ms_id=? AND customer_id=?)");
				ps.setInt(1, accountId);
				ps.setInt(2, customerId);
				rs = ps.executeQuery();
				if (rs.next()) {
					exists = true;
				}
			} else if (acType.equals("cfd")) {
				ps = con.prepareStatement("SELECT cfd_id from tbl_c_fixed_deposit WHERE (cfd_id=? AND customer_id=?)");
				ps.setInt(1, accountId);
				ps.setInt(2, customerId);
				rs = ps.executeQuery();
				if (rs.next()) {
					exists = true;
				}
			}
		} catch (SQLException e){
			e.printStackTrace();
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
		return exists;
	}
	public float getInterestRate(String acType, int accountId){
		float interestRate = 0;
		try{
			con = ConnectionProvider.getConnection();
		if (acType.equals("ds")) {
			ps = con.prepareStatement("SELECT interest_rate FROM tbl_daily_savings WHERE ds_id=? ");
			ps.setInt(1, accountId);
			rs = ps.executeQuery();
		} else if (acType.equals("ms")) {
			ps = con.prepareStatement("SELECT interest_rate FROM tbl_monthly_savings WHERE ms_id=? ");
			ps.setInt(1, accountId);
			rs = ps.executeQuery();
		} else if (acType.equals("cfd")) {
			ps = con.prepareStatement("SELECT interest_rate FROM tbl_c_fixed_deposit WHERE cfd_id=? ");
			ps.setInt(1, accountId);
			rs = ps.executeQuery();
		} else if (acType.equals("fds")) {
			ps = con.prepareStatement("SELECT interest_rate FROM tbl_fixed_deposit WHERE fds_id=? ");
			ps.setInt(1, accountId);
			rs = ps.executeQuery();
		}
		if (rs.next()) {
			interestRate = rs.getFloat("interest_rate");
		}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return interestRate;
	}
}
