package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bankmangementapp.CustomerOperation;
import bankmangementapp.Customerdetails;

/**
 * Servlet implementation class CustomerLogin
 */
public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		String password = request.getParameter("password");

		if (CustomerOperation.checkLoginCredentials(customerId, password)) {
			Customerdetails cust = CustomerOperation.getCustomerDetails("customer_id", customerId);
						
			if (cust.getAccountStatus().equals("active")) {
				HttpSession session = request.getSession();
				session.setAttribute("customerId", cust.getCustomerId());
				session.setAttribute("accountNumber", cust.getAccountNumber());
				session.setAttribute("isLoggedIn", true);
				session.setAttribute("sucessMessage", null);
				session.setAttribute("errorMessage", null);
				System.out.println( cust.getCustomerId());
				response.sendRedirect("customer-loggedIn.html");
				
			} else {
				System.out.println(cust.getAccountStatus());
				request.setAttribute("pending", "Your Account Not Yet Active");
				PrintWriter out = response.getWriter();
				RequestDispatcher footer = request.getRequestDispatcher("home.jsp");
				footer.include(request, response);
				out.println("<script type=\"text/javascript\">");
				out.println("document.getElementById('id01').style.display='block'");
		        out.println("</script>");
			}

		} else {
			PrintWriter out = response.getWriter();
			RequestDispatcher footer = request.getRequestDispatcher("home.jsp");
			footer.include(request, response);
			out.println("<script type=\"text/javascript\">");
			out.println("setTimeout(() => {confirm('Invalid Login Credential')}, 1000);");
			out.println("</script>");
			
		}
	}

}
