package com.kjjcsoft.controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kjjcsoft.model.AuthenticateUser;
import com.kjjcsoft.model.DBFunctions;
import com.kjjcsoft.bean.RetrivedUserBean;
import com.kjjcsoft.bean.UserBean;

/**
 * Servlet implementation class UserLoginController
 */
@WebServlet(description = "Login Page Controller", urlPatterns = { "/login" })
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public UserLoginController(){
		super();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession(true);
		boolean ret_result=false;
		AuthenticateUser au= new AuthenticateUser();
		UserBean usr= new UserBean();
		DBFunctions retrive_user= new DBFunctions();
		RetrivedUserBean r_user=new RetrivedUserBean();
		usr.setUsername(request.getParameter("username"));
		usr.setPassword(request.getParameter("password"));
		try {
			ret_result=au.authenticate(usr);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		if (ret_result==false) {
			request.setAttribute("error", true);
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date dt = new Date();
			r_user=retrive_user.getUserInfo(usr);
			r_user.setCurrentLogin(sdf.format(dt));
			retrive_user.insertUserLog(r_user.getUser_id());
			session.setAttribute("Userinfo",r_user );
			session.setAttribute("loggedIn", true);
			session.setAttribute("initLogin",true);
			if (r_user.getRole().equals("Administrator")) {
				session.setAttribute("AdminLogin", true);
			} else {
				session.setAttribute("AdminLogin", false);
			}
			response.sendRedirect("/KJJCSoft/view/home.jsp");
		}		
	}

}
