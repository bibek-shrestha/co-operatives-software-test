package com.kjjcsoft.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjjcsoft.bean.EmployeeBean;
import com.kjjcsoft.bean.UserBean;
import com.kjjcsoft.model.Employee;
import com.kjjcsoft.model.Users;

/**
 * Servlet implementation class AddUserController
 */
@WebServlet(description = "a controller to add user", urlPatterns = { "/adduser" })
public class AddUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/adduser.jsp");
		Employee emp = new Employee();
		List<Integer> list = emp.getEmployeeIdList();
		request.setAttribute("Empid", list);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("check") != null) {
			EmployeeBean empBean = new EmployeeBean();
			Employee emp = new Employee();
			empBean = emp.getInfo(Integer.parseInt(request.getParameter("employee_id")));
			if (empBean.getEmployeeName().equals("no name")) {
				request.setAttribute("errorOpps", "Oops Something wrong in logic");
			} else {
				request.setAttribute("empInfo", empBean);
			}
		}
		if (request.getParameter("addUser") != null) {
			UserBean newUsr = new UserBean();
			newUsr.setUsername(request.getParameter("username"));
			newUsr.setPassword(request.getParameter("password"));
			newUsr.setEmployee_id(Integer.parseInt(request.getParameter("employee_id")));
			newUsr.setRole(request.getParameter("user_role"));
			Users addUsr = new Users();
			if (newUsr.userNameValidation()>0) {
				if (newUsr.userNameValidation()==1) {
					request.setAttribute("errorUname", "*Username should not contain any spaces.");	
				} else if (newUsr.userNameValidation()== 2) {
					request.setAttribute("errorUname", "*Username cannot be empty.");
				} else if (newUsr.userNameValidation()==3) {
					request.setAttribute("errorUname", "*Username must only be alphanumeric characters not special characters.");
				}
			} else {
				if (addUsr.checkUsername(newUsr.getUsername())) {
					request.setAttribute("errorUname", "*Username already exists in the system. Please choose another one.");
				} else {
					if(newUsr.passwordValidation()>0){
						if (newUsr.passwordValidation()==1) {
							request.setAttribute("errorPwd", "*Password should not contain any spaces.");	
						} else if (newUsr.passwordValidation()== 2) {
							request.setAttribute("errorPwd", "*Password must only be alphanumeric characters not special characters.");
						} else if (newUsr.passwordValidation()==3) {
							request.setAttribute("errorPwd", "*Password must have at least 8 characters.");
						}
					} else {
						if(addUsr.addUser(newUsr)){
							request.setAttribute("successAdd", "User Successfully Added");
						} else {
							request.setAttribute("error", "Something went wrong");
						}
					}
				}
			}
			
		}
		doGet(request, response);
	}
}
