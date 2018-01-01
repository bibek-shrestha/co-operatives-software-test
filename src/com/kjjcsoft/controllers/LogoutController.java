package com.kjjcsoft.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjjcsoft.bean.RetrivedUserBean;
import com.kjjcsoft.model.DBFunctions;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet(description = "for destroying sessions", urlPatterns = { "/Logout" })
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RetrivedUserBean rUser= new RetrivedUserBean();
		rUser = (RetrivedUserBean)request.getSession().getAttribute("Userinfo");
		DBFunctions usrLogout = new DBFunctions();
		usrLogout.insertLogoutLog(rUser.getUser_id(),usrLogout.getCurrentLogin(rUser.getUser_id()));
		request.getSession().invalidate();
		response.sendRedirect("../../../index.jsp");
	}

}
