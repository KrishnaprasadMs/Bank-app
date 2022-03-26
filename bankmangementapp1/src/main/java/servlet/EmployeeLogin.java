package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bankmangementapp.Customerdetails;
import bankmangementapp.EmployeeOperation;


/**
 * Servlet implementation class EmployeeLogin
 */
public class EmployeeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int employee_id = Integer.parseInt(request.getParameter("customerId"));
		String password = request.getParameter("password");
		
		if (EmployeeOperation.checkLoginCredentials(employee_id, password)) {
			
			Customerdetails customer = new Customerdetails();
			customer.setCustomerName("");
			customer.setPassword("");
			customer.setDateOfBirth("");
			customer.setAadhaar(0);
			customer.setPanNumber("");
			customer.setAddress("");
			customer.setAccountType("");
			customer.setNomineeName("");
			customer.setPhoneNumber(0);
			customer.setEmailId("");
			customer.setAccountStatus("");
			customer.setAccountNumber(0);
			customer.setAccountBalance(0);
			customer.setInterestRate(0);
			customer.setFdAmount(0);
			
			HttpSession session = request.getSession();
			session.setAttribute("employeeIsLoggedIn", true);
			session.setAttribute("viewcustomer", customer);
			session.setAttribute("sucessMessage", null);
			session.setAttribute("errorMessage", null);
			response.sendRedirect("view-pending-customers.html");
		}
		else {
			PrintWriter out = response.getWriter();
			RequestDispatcher footer = request.getRequestDispatcher("home.jsp");
			footer.include(request, response);
			out.println("<script type=\"text/javascript\">");
			out.println("setTimeout(() => {confirm('Invalid Login Credential')}, 1000);");
			out.println("</script>");
		}
	}

}
