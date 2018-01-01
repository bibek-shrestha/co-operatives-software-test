package com.kjjcsoft.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjjcsoft.bean.CustomerBean;
import com.kjjcsoft.model.Customer;

/**
 * Servlet implementation class CustomerDetailsController
 */
@WebServlet(description = "for the details extracted", urlPatterns = { "/details" })
public class CustomerDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("CustomerDetails")!=null) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/customer_details.jsp");
			rd.forward(request, response);			
		} else {
			response.sendRedirect("/KJJCSoft/view/error.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("view")!=null) {
			Customer getDetails = new Customer();
			CustomerBean details = new CustomerBean();
			details = getDetails.getDetails(Integer.parseInt(request.getParameter("customerId")));
			request.getSession().setAttribute("CustomerDetails", details);
		}
		doGet(request, response);
	}

}
