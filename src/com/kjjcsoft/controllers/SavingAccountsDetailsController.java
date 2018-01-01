package com.kjjcsoft.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjjcsoft.model.Accounts;

/**
 * Servlet implementation class SavingAccountsDetailsController
 */
@WebServlet(description = "Details of all the saving accounts", urlPatterns = { "/savingdetails" })
public class SavingAccountsDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SavingAccountsDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/savingssummary.jsp");
		Accounts summary = new Accounts();
		int[] summaryData = new int[15];
		summaryData[0] = summary.getCountDailySavings();
		summaryData[1] = summary.getCountActiveDailySavings();
		summaryData[2] = summary.getCountInactiveDailySavings();
		summaryData[3] = summary.getCountMonthlySavings();
		summaryData[4] = summary.getCountActiveMonthlySavings();
		summaryData[5] = summary.getCountInactiveMonthlySavings();
		summaryData[6] = summary.getCountFixedDeposit();
		summaryData[7] = summary.getCountActiveFixedDeposit();
		summaryData[8] = summary.getCountInactiveFixedDeposit();
		summaryData[9] = summary.getCountContinuousFixedDeposit();
		summaryData[10] = summary.getCountActiveContinuousFixedDeposit();
		summaryData[11]	= summary.getCountInactiveContinuousFixedDeposit();
		summaryData[12] = summaryData[0]+summaryData[3]+summaryData[6]+summaryData[9];
		summaryData[13] = summaryData[1]+summaryData[4]+summaryData[7]+summaryData[10];
		summaryData[14] = summaryData[2]+summaryData[5]+summaryData[8]+summaryData[11];
		request.setAttribute("summaryData", summaryData);
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
