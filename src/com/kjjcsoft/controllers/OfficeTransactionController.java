package com.kjjcsoft.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;

import com.kjjcsoft.bean.RetrivedUserBean;
import com.kjjcsoft.bean.TransactionBean;
import com.kjjcsoft.model.Accounts;
import com.kjjcsoft.model.Customer;
import com.kjjcsoft.model.Transaction;

/**
 * Servlet implementation class OfficeTransactionController
 */
@WebServlet(description = "for office transaction", urlPatterns = { "/otransaction" })
public class OfficeTransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfficeTransactionController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/transactionO.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("check") != null) {
			Customer checkCustomer = new Customer();
			String cNamefDb;
			String inData = request.getParameter("customerId");
			if (inData.matches("\\d+")) {
				cNamefDb = checkCustomer.checkIfExists(Integer.parseInt(inData));
				if (cNamefDb.equals("No Match")) {
					request.setAttribute("customerError", "*Given Customer ID doesnot exists in the system");
				} else if (cNamefDb.equals("error")) {
					request.setAttribute("Error", "Something went wrong");
				} else {
					request.setAttribute("cName", cNamefDb);
				}
			} else if (inData.length() < 1) {
				request.setAttribute("errorcid", "*Please enter customer ID.");
			} else {
				request.setAttribute("errorcid", "*Only numbers are allowed.");
			}
		}
		if (request.getParameter("checkagain") != null) {
			Accounts getAc = new Accounts();
			String inCustomerId = request.getParameter("customerId");
			String inAccountId = request.getParameter("accountId");
			String inAcType = request.getParameter("accountType");
			if (inAccountId.matches("\\d+")) {
				if (getAc.exists(inAcType, Integer.parseInt(inAccountId), Integer.parseInt(inCustomerId))) {
					request.setAttribute("exists", true);
				} else {
					request.setAttribute("exists", false);
				}
			} else {
				request.setAttribute("errorAcId", "Invalid Account number");
			}
		}
		if (request.getParameter("save") != null) {
			RetrivedUserBean ses_user = new RetrivedUserBean();
			ses_user = (RetrivedUserBean) request.getSession().getAttribute("Userinfo");
			Date dt = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			boolean error = false;
			String customerId = request.getParameter("customerId");
			String accountType = request.getParameter("accountType");
			String accountNumber = request.getParameter("accountId");
			String depositAmount = request.getParameter("depositAmount");
			String withdrawalAmount = request.getParameter("withdrawalAmount");
			String references = request.getParameter("references");
			if (!customerId.matches("\\d+")) {
				request.setAttribute("errorcid", "Invalid CustomerId");
				error = true;
			}
			/*if (!accountType.equals("ds") || !accountType.equals("ms") || !accountType.equals("cfd")) {
				request.setAttribute("erroractype", "Invalid choice");
				error = true;
			}*/
			if (!accountNumber.matches("\\d+")) {
				request.setAttribute("errorAcId", "Invalid Account number");
				error = true;
			}
			if (depositAmount.length() > 0 && !depositAmount.matches("\\d*")) {
				request.setAttribute("errorDA", "Invalid entry");
				error = true;
			} else if (depositAmount.length() < 1) {
				depositAmount = "0";
			}
			if (withdrawalAmount.length() > 0 && !withdrawalAmount.matches("\\d*")) {
				request.setAttribute("errorWA", "Invalid entry");
				error = true;
			} else if (withdrawalAmount.length() < 1) {
				withdrawalAmount = "0";
			}
			if (depositAmount.equals("0") && withdrawalAmount.equals("0")) {
				request.setAttribute("errorGen", "Atleast one amount should be present");
				error = true;
			}
			if (references.matches(".*[!@#$%^&*()_+=-><,.;~`:\"\'].*") || references.matches(".*\\d+.*")) {
				request.setAttribute("errorR", "Invalid name");
				error = true;
			}
			dt = new Date();
			if (!error) {
				if (validateAndInsert(customerId, accountType, accountNumber, depositAmount, withdrawalAmount, references, sdf.format(dt), ses_user.getUser_id())) {
					response.sendRedirect("/KJJCSoft/com/kjjcsoft/controllers/ctransaction");
					request.getSession().setAttribute("successMsg", true);
					return;
				} else {
					response.sendRedirect("/KJJCSoft/view/error.jsp");
					return;
				}
			}
		}
		doGet(request, response);
	}
	private boolean validateAndInsert(String customerId, String acType, String accountNumber, String depositAmount, String withdrawalAmount, String references, String dt,
			int userid) {
		boolean transactionDone = false;
		TransactionBean trBean = new TransactionBean();
		TransactionBean lastData = new TransactionBean();
		Transaction trLog = new Transaction();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Accounts interestInfo = new Accounts();
		float interestRate = 0;
		double principalAmount = 0;
		double totalInterest = 0;
		double totalAmount = 0;
		double nextInterest = 0;
		Date now = null;
		Date then = null;
		int diff = 0;
		String lastinsertedDate = trLog.lastInsertedDate(acType, Integer.parseInt(accountNumber));
		if (acType.equals("ds") || acType.equals("cfd")) {
			try {
				now = sdf.parse(dt);
				then = sdf.parse(lastinsertedDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			DateTime d1 = new DateTime(then);
			DateTime d2 = new DateTime(now);
			diff = Days.daysBetween(d1, d2).getDays();
			if (diff > 1) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(now);
				cal.add(Calendar.DATE, -1);
				Date newdt = cal.getTime();
				validateAndInsert(customerId, acType, accountNumber, "0", "0", "", sdf.format(newdt), userid);
			}
		} else if (acType.equals("ms")) {
			try {
				now = sdf.parse(dt);
				then = sdf.parse(lastinsertedDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			DateTime d1 = new DateTime(then);
			DateTime d2 = new DateTime(now);
			diff = Months.monthsBetween(d1, d2).getMonths();
			if (diff > 1) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(now);
				cal.add(Calendar.MONTH, -1);
				Date newdt = cal.getTime();
				validateAndInsert(customerId, acType, accountNumber, "0", "0", "", sdf.format(newdt), userid);
			}
		}
		lastData = trLog.getLastInsertedData(acType, Integer.parseInt(accountNumber));
		if (Double.parseDouble(depositAmount) > 0 && Double.parseDouble(withdrawalAmount) < 1) {
			principalAmount = lastData.getPrincipalAmount() + Double.parseDouble(depositAmount);
		} else if (Double.parseDouble(depositAmount) < 1 && Double.parseDouble(withdrawalAmount) > 0) {
			principalAmount = lastData.getPrincipalAmount() - Double.parseDouble(withdrawalAmount);
		} else if (Double.parseDouble(depositAmount) > 0 && Double.parseDouble(withdrawalAmount) > 0) {
			principalAmount = lastData.getPrincipalAmount() - Double.parseDouble(withdrawalAmount);
			principalAmount = principalAmount + Double.parseDouble(depositAmount);
		} else if (Double.parseDouble(depositAmount) < 1 && Double.parseDouble(withdrawalAmount) < 1) {
			principalAmount = lastData.getPrincipalAmount() - Double.parseDouble(withdrawalAmount);
			principalAmount = principalAmount + Double.parseDouble(depositAmount);
		}
		interestRate = interestInfo.getInterestRate(acType, Integer.parseInt(accountNumber));
		nextInterest = (principalAmount * interestRate) / (100 * 365);
		if (diff<1) {
			totalInterest = lastData.getTotalInterest();
		}else{
			totalInterest = lastData.getInterestForNext() + lastData.getTotalInterest();
		}
		totalAmount = totalInterest + principalAmount;
		trBean.setCustomerId(customerId);
		trBean.setAccoutType(acType);
		trBean.setAccountId(accountNumber);
		trBean.setDeposit(depositAmount);
		trBean.setWithdrawal(withdrawalAmount);
		trBean.setReferences(references);
		trBean.setDate(dt);
		trBean.setInterestForNext(nextInterest);
		trBean.setPrincipalAmount(principalAmount);
		trBean.setTotalInterest(totalInterest);
		trBean.setTotalAmount(totalAmount);
		trBean.setEntryBy(userid);
		transactionDone = trLog.officeTransactionInsertion(trBean);
		return transactionDone;
	}
}
