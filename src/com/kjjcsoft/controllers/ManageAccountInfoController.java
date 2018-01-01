package com.kjjcsoft.controllers;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjjcsoft.bean.AccountBean;
import com.kjjcsoft.bean.SearchBean;
import com.kjjcsoft.model.Accounts;
/**
 * Servlet implementation class EditAccountInfoController
 */
@WebServlet(description = "to edit account information", urlPatterns = {"/manageaccount"})
public class ManageAccountInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageAccountInfoController() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/manageAccounts.jsp");
		if (request.getParameter("edit")!=null && request.getParameter("edit").equals("true")) {
			request.getSession().setAttribute("acType", request.getParameter("ac"));
			request.getSession().setAttribute("aid", request.getParameter("accountid"));
			response.sendRedirect("/KJJCSoft/com/kjjcsoft/controllers/changeacinfo");
			return;
		}
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Accounts queryAccount = new Accounts();
		List<AccountBean> list = null;
		if (request.getParameter("search") != null) {
			SearchBean accountQuery = new SearchBean();
			accountQuery.setSearchQuery(request.getParameter("query_string"));
			if (accountQuery.validate() == 0 || accountQuery.validate() == 2) {
				request.setAttribute("errormsgcs", "*Invalid account id.");
			} else if (accountQuery.validate() == 1) {
				list = queryAccount.searchForEdit(request.getParameter("accountType"), Integer.parseInt(accountQuery.getSearchQuery()));
				if (list.isEmpty()) {
					request.setAttribute("errormsgcs", "No records found.");
				} else {					
					request.setAttribute("acType", request.getParameter("accountType"));
				}
			} else if (accountQuery.validate() == 3) {
				request.setAttribute("errormsgcs", "No keywords entered");
			}
			request.setAttribute("list", list);
		}
		if (request.getParameter("enable") != null) {
			if (request.getParameter("accounttype").equals("ds")) {
				queryAccount.enableDsAc(Integer.parseInt(request.getParameter("accountid")));
				list = queryAccount.searchForEdit(request.getParameter("accounttype"), Integer.parseInt(request.getParameter("accountid")));
				request.setAttribute("list", list);
				request.setAttribute("acType", request.getParameter("accounttype"));
			} else if (request.getParameter("accounttype").equals("ms")) {
				queryAccount.enableMsAc(Integer.parseInt(request.getParameter("accountid")));
				list = queryAccount.searchForEdit(request.getParameter("accounttype"), Integer.parseInt(request.getParameter("accountid")));
				request.setAttribute("list", list);
				request.setAttribute("acType", request.getParameter("accounttype"));
			} else if (request.getParameter("accounttype").equals("fds")) {
				queryAccount.enableFdsAc(Integer.parseInt(request.getParameter("accountid")));
				list = queryAccount.searchForEdit(request.getParameter("accounttype"), Integer.parseInt(request.getParameter("accountid")));
				request.setAttribute("list", list);
				request.setAttribute("acType", request.getParameter("accounttype"));
			} else if (request.getParameter("accounttype").equals("cfd")) {
				queryAccount.enableCfdAc(Integer.parseInt(request.getParameter("accountid")));
				list = queryAccount.searchForEdit(request.getParameter("accounttype"), Integer.parseInt(request.getParameter("accountid")));
				request.setAttribute("list", list);
				request.setAttribute("acType", request.getParameter("accounttype"));
			}
		}
		if (request.getParameter("disable") != null) {
			if (request.getParameter("accounttype").equals("ds")) {
				queryAccount.disableDsAc(Integer.parseInt(request.getParameter("accountid")));
				list = queryAccount.searchForEdit(request.getParameter("accounttype"), Integer.parseInt(request.getParameter("accountid")));
				request.setAttribute("list", list);
				request.setAttribute("acType", request.getParameter("accounttype"));
			} else if (request.getParameter("accounttype").equals("ms")) {
				queryAccount.disableMsAc(Integer.parseInt(request.getParameter("accountid")));
				list = queryAccount.searchForEdit(request.getParameter("accounttype"), Integer.parseInt(request.getParameter("accountid")));
				request.setAttribute("list", list);
				request.setAttribute("acType", request.getParameter("accounttype"));
			} else if (request.getParameter("accounttype").equals("fds")) {
				queryAccount.disableFdsAc(Integer.parseInt(request.getParameter("accountid")));
				list = queryAccount.searchForEdit(request.getParameter("accounttype"), Integer.parseInt(request.getParameter("accountid")));
				request.setAttribute("list", list);
				request.setAttribute("acType", request.getParameter("accounttype"));
			} else if (request.getParameter("accounttype").equals("cfd")) {
				queryAccount.disableCfdAc(Integer.parseInt(request.getParameter("accountid")));
				list = queryAccount.searchForEdit(request.getParameter("accounttype"), Integer.parseInt(request.getParameter("accountid")));
				request.setAttribute("list", list);
				request.setAttribute("acType", request.getParameter("accounttype"));
			}
		}
		doGet(request, response);
	}
}
