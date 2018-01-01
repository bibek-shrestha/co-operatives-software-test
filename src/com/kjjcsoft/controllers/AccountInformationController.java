package com.kjjcsoft.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjjcsoft.bean.RetrivedUserBean;
import com.kjjcsoft.bean.UserLogBean;
import com.kjjcsoft.model.Users;

/**
 * Servlet implementation class AccountInformationController
 */
@WebServlet(description = "to get account information for the administrator", urlPatterns = { "/AccountInformation" })
public class AccountInformationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountInformationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/account_information.jsp");
			RetrivedUserBean myInfo = new RetrivedUserBean();
			myInfo = (RetrivedUserBean)request.getSession().getAttribute("Userinfo");
			Users user = new Users();
			user.getMyLogs(myInfo.getUser_id());
			List<UserLogBean> myLogs = user.getMyLogs(myInfo.getUser_id()); 
			request.setAttribute("mylogs", myLogs);
			rd.forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
