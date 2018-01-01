package com.kjjcsoft.controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjjcsoft.bean.PasswordBean;
import com.kjjcsoft.bean.RetrivedUserBean;
import com.kjjcsoft.model.EncryptorClass;
import com.kjjcsoft.model.Password;

/**
 * Servlet implementation class ChangePasswordController
 */
@WebServlet(description = "to change password", urlPatterns = { "/ChangePassword" })
public class ChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/change_password.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PasswordBean pwd= new PasswordBean();
		RetrivedUserBean ses_usr = new RetrivedUserBean();
		String newPassEncrypt = null;
		ses_usr = (RetrivedUserBean)request.getSession().getAttribute("Userinfo");
		Password pass = new Password();
		pwd.setOldPassword(request.getParameter("old_password"));
		pwd.setNewPassword(request.getParameter("new_password"));
		pwd.setRepeatPassword(request.getParameter("repeat_password"));
		if (pwd.validation()>0) {
			if (pwd.validation()==1) {
				request.setAttribute("errorNewPwd", "*Password should not contain any spaces");	
			} else if (pwd.validation()== 2) {
				request.setAttribute("errorNewPwd", "*Password must only be alphanumeric characters not special characters");
			} else if (pwd.validation()==3) {
				request.setAttribute("errorNewPwd", "*Password must have at least 8 characters");
			}
			doGet(request,response);
		} else {
			if(!pwd.checkNewPasswords()){
				request.setAttribute("errorRepPwd", "*Two passwords did not match");
				doGet(request,response);
			} else {
				if(pass.authenticatePassword(pwd.getOldPassword(), ses_usr.getUser_id())){
					try {
						newPassEncrypt = EncryptorClass.encrypt(pwd.getNewPassword());
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(pass.updatePassword(newPassEncrypt,ses_usr.getUser_id())){
						request.setAttribute("successMsg", "Password has been successfully changed");
						doGet(request, response);
					} else {
						response.sendRedirect("/KJJCSoft/view/error.jsp");
					}
				} else {
					request.setAttribute("errorOld", "*Password did not match");
					doGet(request, response);
				}
			}
		}
	}

}
