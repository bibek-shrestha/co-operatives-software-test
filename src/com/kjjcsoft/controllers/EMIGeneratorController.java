package com.kjjcsoft.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjjcsoft.bean.EMIBean;

/**
 * Servlet implementation class EMIGeneratorController
 */
@WebServlet(description = "for generating EMI", urlPatterns = { "/EMIGenerator" })
public class EMIGeneratorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EMIGeneratorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/EMI.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("generate")!= null) {
			boolean error = false;
			List<EMIBean> list;
			String Amount;
			String Rate;
			String Duration;
			Amount = request.getParameter("amount");
			Rate = request.getParameter("rate");
			Duration = request.getParameter("duration");
			if (!Amount.matches("^\\d\\d*")) {
				error = true;
				request.setAttribute("errorAmount", true);
			}
			if (!Rate.matches("\\d{0,2}(\\.\\d{1,2})?")) {
				error = true;
				request.setAttribute("errorRate", true);
			}
			if (!Duration.matches("\\d+")) {
				error = true;
				request.setAttribute("errorDuration", true);
			}
			if (!error) {
				list = generateEMI(Amount, Rate, Duration);
				request.setAttribute("list", list);
			}
			doGet(request, response);
		}
	}
	public ArrayList<EMIBean> generateEMI(String Principal, String rate, String duration){
		ArrayList<EMIBean> list = new ArrayList<EMIBean>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date nextMonth;
		Calendar date = Calendar.getInstance();
		int counter = 1;
		float principalAmount = Float.parseFloat(Principal);
		int EMIduration = Integer.parseInt(duration);
		float interestRate = Float.parseFloat(rate);
		float remainingPrincipal;
		float payableInterest;
		float payableTotal;
		float payableAmount = principalAmount/EMIduration;
		while (EMIduration>0) {
			EMIBean generatedData = new EMIBean();
			payableInterest = (interestRate*principalAmount)/(100*12);
			payableTotal = payableInterest + payableAmount;
			remainingPrincipal = principalAmount - payableAmount;
			if (remainingPrincipal<0) {
				remainingPrincipal=0;
			}
			date.add(Calendar.MONTH, 1);
			nextMonth = date.getTime();
			generatedData.setPrincipal(String.format("%.2f",principalAmount));
			generatedData.setDate(sdf.format(nextMonth));
			generatedData.setPayablePrincipal(String.format("%.2f",payableAmount));
			generatedData.setPayableInterest(String.format("%.2f",payableInterest));
			generatedData.setPayableAmount(String.format("%.2f",payableTotal));
			generatedData.setRemainingPrincipal(String.format("%.2f",remainingPrincipal));
			principalAmount = remainingPrincipal;
			EMIduration = EMIduration-1;
			counter = counter + 1;
			list.add(generatedData);
		}
		return list;
	}

}
