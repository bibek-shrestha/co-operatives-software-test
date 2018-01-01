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
import com.kjjcsoft.bean.SearchBean;
import com.kjjcsoft.model.Users;

/**
 * Servlet implementation class UserSearchController
 */
@WebServlet(description = "Controller for searching user", urlPatterns = { "/usersearch" })
public class UserSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/searchresult.jsp");
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("search") != null) {
			Users usr = new Users();
			List<RetrivedUserBean> list = null;
			SearchBean searchKeyword = new SearchBean();
			searchKeyword.setSearchQuery(request.getParameter("query_word"));
			if(searchKeyword.validate() == 0){
				list = usr.searchUsers(searchKeyword.getSearchQuery());				
			} else if(searchKeyword.validate()==1){
				list = usr.searchUsers(Integer.parseInt(searchKeyword.getSearchQuery()));
			} else if(searchKeyword.validate()==2){
				list = usr.searchUsersEname(searchKeyword.getSearchQuery());
			} else if(searchKeyword.validate()==3){
				request.setAttribute("errorMsg", "No search Keyword");
			}
			request.setAttribute("userlistresult", list);
		}
		doGet(request, response);
	}

}
