package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bankmangementapp.CustomerAccountOperation;
import bankmangementapp.Customerdetails;

/**
 * Servlet implementation class TransferMoney
 */
public class TransferMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TransferMoney() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int transferAmount = Integer.parseInt(request.getParameter("transferAmount"));
		long toaccountNo = Long.parseLong(request.getParameter("toaccountNo"));

		HttpSession session = request.getSession();
		Customerdetails obj = (Customerdetails) session.getAttribute("cust");
		double balance = CustomerAccountOperation.getTransferAccountBalance(toaccountNo);
		String timeDate = CustomerAccountOperation.timeDate();
		double balanceamount = obj.getAccountBalance() - transferAmount;
		if (balance != -1) {
			boolean isWithdrawSucess = CustomerAccountOperation.withdrawAmount(obj.getCustomerId(), transferAmount,obj.getAccountBalance());
			if (isWithdrawSucess) {
				String translation = "Transfer to AccNo:"+ toaccountNo +" (Dr)";
				CustomerAccountOperation.insertTranslation(obj.getAccountNumber(), timeDate, translation, transferAmount, balanceamount);
				boolean isAdded = CustomerAccountOperation.addAmount(toaccountNo, transferAmount, balance);
				if(isAdded) {
					double balanceadded = balance + transferAmount;
					String translationTo = "Transfer from AccNo:"+ obj.getAccountNumber() +" (Cr)";
					CustomerAccountOperation.insertTranslation(toaccountNo, timeDate, translationTo, transferAmount, balanceadded);
					session.setAttribute("sucessMessage", "Money Transfer Sucessfully");
					session.setAttribute("errorMessage", null);
					response.sendRedirect("customer-loggedIn.html");
				}
				else {
					session.setAttribute("sucessMessage", null);
					session.setAttribute("errorMessage", "Technical Issue");
					System.out.println("amount not added");
					response.sendRedirect("customer-loggedIn.html");
				}
			}
			else {
				session.setAttribute("sucessMessage", null);
				session.setAttribute("errorMessage", "Insufficient Amount");
				System.out.println("infus balance");
				response.sendRedirect("customer-loggedIn.html");
			}
		}
		else {
			session.setAttribute("sucessMessage", null);
			session.setAttribute("errorMessage", "Account Not Found");
			System.out.println("account n fount");
			response.sendRedirect("customer-loggedIn.html");
		}

	}
}
