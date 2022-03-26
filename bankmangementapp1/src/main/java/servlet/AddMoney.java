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
 * Servlet implementation class AddMoney
 */
public class AddMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMoney() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int addamount = Integer.parseInt(request.getParameter("addamount"));
		Customerdetails obj = (Customerdetails) session.getAttribute("cust");
		boolean b = CustomerAccountOperation.addAmount(obj.getAccountNumber(), addamount, obj.getAccountBalance());
		double balance = obj.getAccountBalance() + addamount;
		if(b) {
			String timeDate = CustomerAccountOperation.timeDate();
			String translation = "Deposited (Cr)";
			CustomerAccountOperation.insertTranslation(obj.getAccountNumber(), timeDate, translation, addamount, balance);
			session.setAttribute("sucessMessage", "Amount Added");
			session.setAttribute("errorMessage", null);
			response.sendRedirect("customer-loggedIn.html");	
		}
		else {
			session.setAttribute("sucessMessage", null);
			session.setAttribute("errorMessage", "Technical Issue");
			response.sendRedirect("customer-loggedIn.html");	
		}
	}

}
