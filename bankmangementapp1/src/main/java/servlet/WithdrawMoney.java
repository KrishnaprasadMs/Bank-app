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
 * Servlet implementation class WithdrawMoney
 */
public class WithdrawMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WithdrawMoney() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int withdrawamount = Integer.parseInt(request.getParameter("withdrawamount"));
		Customerdetails obj = (Customerdetails) session.getAttribute("cust");
		double balance = obj.getAccountBalance() - withdrawamount;
		boolean b = CustomerAccountOperation.withdrawAmount(obj.getCustomerId(), withdrawamount, obj.getAccountBalance());
		if(b) {
			String timeDate = CustomerAccountOperation.timeDate();
			String translation = "Withdraw (Dr)";
			CustomerAccountOperation.insertTranslation(obj.getAccountNumber(), timeDate, translation, withdrawamount, balance);
			session.setAttribute("sucessMessage", "Money withdraw Sucessful");
			session.setAttribute("errorMessage", null);
			response.sendRedirect("customer-loggedIn.html");
		}
		else {
			session.setAttribute("sucessMessage", null);
			session.setAttribute("errorMessage", "Insufficient Amount");
			response.sendRedirect("customer-loggedIn.html");
		}
	}

}
