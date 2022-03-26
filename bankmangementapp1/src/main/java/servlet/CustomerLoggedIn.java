package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bankmangementapp.CustomerAccountOperation;
import bankmangementapp.CustomerOperation;
import bankmangementapp.Customerdetails;
import bankmangementapp.TranslationPOJO;

/**
 * Servlet implementation class CustomerLoggedIn
 */
public class CustomerLoggedIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLoggedIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int customerId = (int) session.getAttribute("customerId");
		long accountNumber = (long)session.getAttribute("accountNumber");
		
		
		Customerdetails cust = CustomerOperation.getCustomerDetails("customer_id", customerId);
		ArrayList<TranslationPOJO> translations = CustomerAccountOperation.readAllTranslation(accountNumber);
		session.setAttribute("cust", cust);
		request.setAttribute("cust-obj", cust);
		request.setAttribute("translations", translations);
		request.getRequestDispatcher("customerhome.jsp").forward(request, response);
	}

}
