package com.kjjcsoft.controllers;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjjcsoft.bean.CustomerBean;
import com.kjjcsoft.bean.SearchBean;
import com.kjjcsoft.model.Customer;
/**
 * Servlet implementation class EditCustomerController
 */
@WebServlet(description = "to edit the details of customers", urlPatterns = {"/edit"})
public class EditCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditCustomerController() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/editInfo.jsp");
		if (request.getParameter("edit")!=null && request.getParameter("edit").equals("true")) {
			Customer changeInfo = new Customer();
			CustomerBean fromDbInfo = new CustomerBean();
			fromDbInfo = (CustomerBean)changeInfo.getDetails(Integer.parseInt(request.getParameter("customerid")));
			request.getSession().setAttribute("storedInfo", fromDbInfo);
			response.sendRedirect("/KJJCSoft/com/kjjcsoft/controllers/change");
			return;
		}
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer queryCustomer = new Customer();
		List<CustomerBean> list = null;
		if (request.getParameter("search") != null) {
			SearchBean customerQuery = new SearchBean();
			customerQuery.setCustomerListSearch(request.getParameter("query_string"));
			if (customerQuery.validateListSearch() == 0) {
				list = queryCustomer.searchForEdit(customerQuery.getCustomerListSearch());
			} else if (customerQuery.validateListSearch() == 1) {
				list = queryCustomer.searchForEdit(Integer.parseInt(customerQuery.getCustomerListSearch()));
			} else if (customerQuery.validateListSearch() == 2) {
				request.setAttribute("errormsgcs", "No keywords entered");
			}
			request.setAttribute("editList", list);
		}
		if (request.getParameter("disable")!=null) {			
			queryCustomer.changeToInactive(Integer.parseInt(request.getParameter("customerid")));
			list=queryCustomer.searchForEdit(Integer.parseInt(request.getParameter("customerid")));
			request.setAttribute("editList", list);
		}
		if (request.getParameter("enable")!=null) {
			queryCustomer.changeToActive(Integer.parseInt(request.getParameter("customerid")));
			list=queryCustomer.searchForEdit(Integer.parseInt(request.getParameter("customerid")));
			request.setAttribute("editList", list);
		}
		doGet(request, response);
	}
}
