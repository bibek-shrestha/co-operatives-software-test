package com.kjjcsoft.controllers;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjjcsoft.bean.AccountBean;
import com.kjjcsoft.bean.RetrivedUserBean;
import com.kjjcsoft.model.Accounts;
import com.kjjcsoft.model.Customer;
/**
 * Servlet implementation class OpenMsAccountServlet
 */
@WebServlet(description = "monthly saving account", urlPatterns = {"/openmonthly"})
public class OpenMsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OpenMsController() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/openMS.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountBean creationInfo = new AccountBean();
		Accounts msAccount = new Accounts();
		RetrivedUserBean ses_usr = new RetrivedUserBean();
		ses_usr = (RetrivedUserBean) request.getSession().getAttribute("Userinfo");
		Customer checkCustomer = new Customer();
		String cNamefDb;
		if (request.getParameter("check") != null) {
			String inData = request.getParameter("customer_id");
			if (inData.matches("\\d+")) {
				cNamefDb = checkCustomer.checkIfExists(Integer.parseInt(inData));
				if (cNamefDb.equals("No Match")) {
					request.setAttribute("customerError", "*Given Customer ID doesnot exists in the system");
				} else if (cNamefDb.equals("error")) {
					request.setAttribute("Error", "Something went wrong");
				} else {
					request.setAttribute("cName", cNamefDb);
					request.getSession().setAttribute("cName", cNamefDb);
				}				
			}
			else if(inData.length()<1) {
				request.setAttribute("errorcid", "*Please enter customer ID.");
			} else {
				request.setAttribute("errorcid", "*Only numbers are allowed.");
			}
		}
		if (request.getParameter("create") != null) {
			boolean isError = false;
			creationInfo.setCustomerId(request.getParameter("customer_id"));
			creationInfo.setInterestRate(request.getParameter("interest_rate"));
			creationInfo.setApprovedBy(request.getParameter("approved_by"));
			creationInfo.setAccountType(request.getParameter("account_type"));
			if (creationInfo.validateCustomerId() > 1) {
				if (creationInfo.validateCustomerId() == 11) {
					isError = true;
					request.setAttribute("errorcid", "*Please enter customer ID.");
				} else if (creationInfo.validateCustomerId() == 12) {
					isError = true;
					request.setAttribute("errorcid", "*Only numbers are allowed.");
				}
			}
			if (creationInfo.validateInterestRate() > 1) {
				if (creationInfo.validateInterestRate() == 22) {
					creationInfo.setInterestRate("8.5");
				} else if (creationInfo.validateInterestRate() == 21) {
					isError = true;
					request.setAttribute("errorir", "Invalid rate entered.");
				}
			}
			if (creationInfo.validateApprovedBy() > 1) {
				if (creationInfo.validateApprovedBy() == 31) {
					isError = true;
					request.setAttribute("errorapb", "*Please enter who approved it");
				} else if (creationInfo.validateApprovedBy() == 32) {
					isError = true;
					request.setAttribute("errorapb", "*Name invalid");
				}
			}
			if (creationInfo.validateAccountType() > 1) {
				if (creationInfo.validateAccountType() == 61) {
					isError = true;
					request.setAttribute("errormain", "*An error occured. Please refresh the browser and refill the form.");
				}
			}
			creationInfo.setEntryBy(ses_usr.getUser_id());
			if (!isError) {
				if (msAccount.createMsAccount(creationInfo)) {
					request.getSession().removeAttribute("Id");
					AccountBean recBean = msAccount.retLastMsAcCreated(creationInfo.getCustomerId());
					/*
					 * if (!request.getParameter("starting_amount".equals("")))
					 * { }
					 */
					request.getSession().setAttribute("msAcInfo", recBean);
					response.sendRedirect("/KJJCSoft/view/MScreated.jsp");
					return;
				}
			}
		}
		if (request.getParameter("cancel") != null) {
			response.sendRedirect("/KJJCSoft/com/kjjcsoft/controllers/savingdetails");
			return;
		}
		doGet(request, response);
	}
}
