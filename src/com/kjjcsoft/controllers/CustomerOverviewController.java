package com.kjjcsoft.controllers;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjjcsoft.model.Customer;
/**
 * Servlet implementation class CustomerOverviewController
 */
@WebServlet(description = "overview look of customers registered", urlPatterns = {"/overview"})
public class CustomerOverviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerOverviewController() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/customer_overview.jsp");
		Customer customerOverview = new Customer();
		int[] overviewData = new int[7];
		overviewData[0] = customerOverview.getTotalCustomerCount();
		overviewData[1] = customerOverview.getActiveCustomers();
		overviewData[2] = customerOverview.getInactiveCustomers();
		overviewData[3] = customerOverview.getAdultCustomers();
		overviewData[4] = customerOverview.getChildrenCustomers();
		overviewData[5] = customerOverview.getMaleCustomers();
		overviewData[6] = customerOverview.getFemaleCustomers();
		request.setAttribute("overview", overviewData);
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
