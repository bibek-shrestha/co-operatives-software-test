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
import com.kjjcsoft.model.Users;

/**
 * Servlet implementation class UsersController
 */
@WebServlet(description = "for managing users", urlPatterns = { "/users" })
public class UsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/users.jsp");
		Users usersList = new Users();
		List<RetrivedUserBean> list = usersList.getUsers();
		request.setAttribute("userlist", list);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Users changeUsrStatus = new Users();
		if (request.getParameter("deactivate") != null) {
			changeUsrStatus.deactivateUser(Integer.parseInt(request.getParameter("userId")));
		}
		if (request.getParameter("activate") != null) {
			changeUsrStatus.activateUser(Integer.parseInt(request.getParameter("userId")));
		}
		doGet(request, response);
	}

}
