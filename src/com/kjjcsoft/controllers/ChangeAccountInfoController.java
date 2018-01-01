package com.kjjcsoft.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjjcsoft.bean.AccountBean;
import com.kjjcsoft.model.Accounts;
import com.kjjcsoft.model.Customer;

/**
 * Servlet implementation class ChangeAccountInfoController
 */
@WebServlet(description = "for changing acinfo", urlPatterns = { "/changeacinfo" })
public class ChangeAccountInfoController extends HttpServlet {
	boolean submitted = false;
	String accessedFrom = null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeAccountInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		if (request.getSession().getAttribute("acType")!=null && request.getSession().getAttribute("aid")!=null && submitted == false) {
			Accounts getDetails = new Accounts();
			AccountBean sesBean = getDetails.getInfoFromDb((String)request.getSession().getAttribute("acType"),Integer.parseInt((String)request.getSession().getAttribute("aid")));
			request.getSession().setAttribute("changeValue", sesBean);
			if (request.getSession().getAttribute("acType").equals("ds")) {
				 rd = getServletContext().getRequestDispatcher("/view/changeDS.jsp");
			} else if (request.getSession().getAttribute("acType").equals("ms")) {
				rd = getServletContext().getRequestDispatcher("/view/changeMS.jsp");
			} else if (request.getSession().getAttribute("acType").equals("fds")) {
				rd = getServletContext().getRequestDispatcher("/view/changeFDS.jsp");
			} else if (request.getSession().getAttribute("acType").equals("cfd")) {
				rd = getServletContext().getRequestDispatcher("/view/changeCFD.jsp");
			} else {
				response.sendRedirect("/KJJCSoft/view/error.jsp");
			}
			request.getSession().removeAttribute("acType");
		} 
		if (submitted= true && accessedFrom!=null) {
			if (accessedFrom.equals("ds")) {
				rd = getServletContext().getRequestDispatcher("/view/changeDS.jsp");
			} else if (accessedFrom.equals("ms")) {
				rd = getServletContext().getRequestDispatcher("/view/changeMS.jsp");
			} else if (accessedFrom.equals("fds")) {
				rd = getServletContext().getRequestDispatcher("/view/changeFDS.jsp");
			} else if (accessedFrom.equals("cfd")) {
				rd = getServletContext().getRequestDispatcher("/view/changeCFD.jsp");
			}
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountBean updateInfo = new AccountBean();
		Accounts editedAc = new Accounts();
		Customer checkCustomer = new Customer();
		String cNamefDb;
		if (request.getParameter("check") != null) {
			String inData = request.getParameter("customer_id");
			if (inData.matches("\\d+")) {
				cNamefDb = checkCustomer.checkIfExists(Integer.parseInt(inData));
				if (cNamefDb.equals("No Match")) {
					request.setAttribute("customerError", "*Given Customer ID doesnot exists in the system");
				} else if (cNamefDb.equals("error")) {
					request.setAttribute("Error", "Something went wrong");
				} else {
					request.setAttribute("cName", cNamefDb);
					request.getSession().setAttribute("cName", cNamefDb);
				}				
			}
			else if(inData.length()<1) {
				request.setAttribute("errorcid", "*Please enter customer ID.");
			} else {
				request.setAttribute("errorcid", "*Only numbers are allowed.");
			}
			submitted= true;
			accessedFrom = request.getParameter("account_type");
		}
		if (request.getParameter("update") != null) {
			boolean isError = false;
			if (request.getParameter("account_type").equals("ds")) {
				updateInfo.setCustomerId(request.getParameter("customer_id"));
				updateInfo.setInterestRate(request.getParameter("interest_rate"));
				updateInfo.setApprovedBy(request.getParameter("approved_by"));
				updateInfo.setAccountType(request.getParameter("account_type"));
				if (updateInfo.validateCustomerId() > 1) {
					if (updateInfo.validateCustomerId() == 11) {
						isError = true;
						request.setAttribute("errorcid", "*Please enter customer ID.");
					} else if (updateInfo.validateCustomerId() == 12) {
						isError = true;
						request.setAttribute("errorcid", "*Only numbers are allowed.");
					}
				}
				if (updateInfo.validateInterestRate() > 1) {
					if (updateInfo.validateInterestRate() == 22) {
						updateInfo.setInterestRate("8.5");
					} else if (updateInfo.validateInterestRate() == 21) {
						isError = true;
						request.setAttribute("errorir", "Invalid rate entered.");
					}
				}
				if (updateInfo.validateApprovedBy() > 1) {
					if (updateInfo.validateApprovedBy() == 31) {
						isError = true;
						request.setAttribute("errorapb", "*Please enter who approved it");
					} else if (updateInfo.validateApprovedBy() == 32) {
						isError = true;
						request.setAttribute("errorapb", "*Name invalid");
					}
				}
				if (updateInfo.validateAccountType() > 1) {
					if (updateInfo.validateAccountType() == 61) {
						isError = true;
						request.setAttribute("errormain", "*An error occured. Please refresh the browser and refill the form.");
					}
				}
			} else if (request.getParameter("account_type").equals("ms")) {
				updateInfo.setCustomerId(request.getParameter("customer_id"));
				updateInfo.setInterestRate(request.getParameter("interest_rate"));
				updateInfo.setApprovedBy(request.getParameter("approved_by"));
				updateInfo.setAccountType(request.getParameter("account_type"));
				if (updateInfo.validateCustomerId() > 1) {
					if (updateInfo.validateCustomerId() == 11) {
						isError = true;
						request.setAttribute("errorcid", "*Please enter customer ID.");
					} else if (updateInfo.validateCustomerId() == 12) {
						isError = true;
						request.setAttribute("errorcid", "*Only numbers are allowed.");
					}
				}
				if (updateInfo.validateInterestRate() > 1) {
					if (updateInfo.validateInterestRate() == 22) {
						updateInfo.setInterestRate("8.5");
					} else if (updateInfo.validateInterestRate() == 21) {
						isError = true;
						request.setAttribute("errorir", "Invalid rate entered.");
					}
				}
				if (updateInfo.validateApprovedBy() > 1) {
					if (updateInfo.validateApprovedBy() == 31) {
						isError = true;
						request.setAttribute("errorapb", "*Please enter who approved it");
					} else if (updateInfo.validateApprovedBy() == 32) {
						isError = true;
						request.setAttribute("errorapb", "*Name invalid");
					}
				}
				if (updateInfo.validateAccountType() > 1) {
					if (updateInfo.validateAccountType() == 61) {
						isError = true;
						request.setAttribute("errormain", "*An error occured. Please refresh the browser and refill the form.");
					}
				}
			} else if (request.getParameter("account_type").equals("fds")) {
				updateInfo.setCustomerId(request.getParameter("customer_id"));
				updateInfo.setInterestRate(request.getParameter("interest_rate"));
				updateInfo.setFixedDepositAmount(request.getParameter("fd_amount"));
				updateInfo.setYears(request.getParameter("maturity_period"));
				updateInfo.setAccountType(request.getParameter("account_type"));
				updateInfo.setApprovedBy(request.getParameter("approved_by"));
				if (updateInfo.validateCustomerId() > 1) {
					if (updateInfo.validateCustomerId() == 11) {
						isError = true;
						request.setAttribute("errorcid", "*Please enter customer ID.");
					} else if (updateInfo.validateCustomerId() == 12) {
						isError = true;
						request.setAttribute("errorcid", "*Only numbers are allowed.");
					}
				}
				if (updateInfo.validateInterestRate() > 1) {
					if (updateInfo.validateInterestRate() == 22) {
						updateInfo.setInterestRate("15");
					} else if (updateInfo.validateInterestRate() == 21) {
						isError = true;
						request.setAttribute("errorir", "Invalid rate entered.");
					}
				}
				if (updateInfo.validateApprovedBy() > 1) {
					if (updateInfo.validateApprovedBy() == 31) {
						isError = true;
						request.setAttribute("errorapb", "*Please enter who approved it");
					} else if (updateInfo.validateApprovedBy() == 32) {
						isError = true;
						request.setAttribute("errorapb", "*Name invalid");
					}
				}
				if (updateInfo.validateAccountType() > 1) {
					if (updateInfo.validateAccountType() == 61) {
						isError = true;
						request.setAttribute("errormain", "*An error occured. Please refresh the browser and refill the form.");
					}
				}
				if (updateInfo.validateYears() > 1) {
					if (updateInfo.validateYears() == 41) {
						isError = true;
						request.setAttribute("errory", "*Please enter maturity period.");
					} else if (updateInfo.validateYears() == 42) {
						isError = true;
						request.setAttribute("errory", "Invalid number of years.");
					}
				}
				if (updateInfo.validateFixedDepositAmount() > 1) {
					if (updateInfo.validateFixedDepositAmount() == 51) {
						isError = true;
						request.setAttribute("errorfd", "*Please enter the fixed deposit amount.");
					} else if (updateInfo.validateFixedDepositAmount() == 52) {
						isError = true;
						request.setAttribute("errorfd", "*Invalid amount.");
					}
				}
			} else if (request.getParameter("account_type").equals("cfd")) {
				updateInfo.setCustomerId(request.getParameter("customer_id"));
				updateInfo.setInterestRate(request.getParameter("interest_rate"));
				updateInfo.setFixedDepositAmount(request.getParameter("fd_amount"));
				updateInfo.setYears(request.getParameter("maturity_period"));
				updateInfo.setAccountType(request.getParameter("account_type"));
				updateInfo.setApprovedBy(request.getParameter("approved_by"));
				if (updateInfo.validateCustomerId() > 1) {
					if (updateInfo.validateCustomerId() == 11) {
						isError = true;
						request.setAttribute("errorcid", "*Please enter customer ID.");
					} else if (updateInfo.validateCustomerId() == 12) {
						isError = true;
						request.setAttribute("errorcid", "*Only numbers are allowed.");
					}
				}
				if (updateInfo.validateInterestRate() > 1) {
					if (updateInfo.validateInterestRate() == 22) {
						updateInfo.setInterestRate("15");
					} else if (updateInfo.validateInterestRate() == 21) {
						isError = true;
						request.setAttribute("errorir", "Invalid rate entered.");
					}
				}
				if (updateInfo.validateApprovedBy() > 1) {
					if (updateInfo.validateApprovedBy() == 31) {
						isError = true;
						request.setAttribute("errorapb", "*Please enter who approved it");
					} else if (updateInfo.validateApprovedBy() == 32) {
						isError = true;
						request.setAttribute("errorapb", "*Name invalid");
					}
				}
				if (updateInfo.validateAccountType() > 1) {
					if (updateInfo.validateAccountType() == 61) {
						isError = true;
						request.setAttribute("errormain", "*An error occured. Please refresh the browser and refill the form.");
					}
				}
				if (updateInfo.validateYears() > 1) {
					if (updateInfo.validateYears() == 41) {
						isError = true;
						request.setAttribute("errory", "*Please enter maturity period.");
					} else if (updateInfo.validateYears() == 42) {
						isError = true;
						request.setAttribute("errory", "Invalid number of years.");
					}
				}
			}
			if (!isError) {
				if (editedAc.editAccount(Integer.parseInt((String)request.getSession().getAttribute("aid")),updateInfo)) {
					request.getSession().setAttribute("successMsg", "true");
					request.getSession().removeAttribute("aid");
					response.sendRedirect("/KJJCSoft/com/kjjcsoft/controllers/manageaccount");
					return;
				}
			}
			submitted = true;
			accessedFrom = updateInfo.getAccountType();
		}
		if (request.getParameter("cancel") != null) {
			response.sendRedirect("/KJJCSoft/com/kjjcsoft/controllers/manageaccount");
			return;
		}
		doGet(request, response);
	}

}
