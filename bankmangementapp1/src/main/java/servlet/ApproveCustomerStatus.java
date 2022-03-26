package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bankmangementapp.*;

/**
 * Servlet implementation class ApproveCustomerStatus
 */
public class ApproveCustomerStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveCustomerStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailId = request.getParameter("emailId");
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		String accountType = request.getParameter("accountType");
	    float interestRate = EmployeeOperation.getInterestRate(accountType);
	    boolean isApproved = EmployeeOperation.approvecustomer(customerId,accountType,interestRate);
	    HttpSession session = request.getSession();
	
	if(isApproved) {
		EmployeeOperation.UpdateStatus(customerId);
		MyMail obj = new MyMail();
		String body = "<h2 style ='colour:Red;'>Welcome To FORTUNA BANK</h2> <br><p>Your Account is Activated</p> <br>Your Customer ID :"+ customerId + "<br> <p>Login With CustomerID and Created Password </p>";
		obj.SendMail(emailId, "Account Active Status", body);
//		ArrayList<Customerdetails> customers = EmployeeOperation.readAllEmployees();
//		request.setAttribute("customers", customers);
//		request.getRequestDispatcher("employeehome.jsp").forward(request, response);
		session.setAttribute("sucessMessage", "Customer Added");
		session.setAttribute("errorMessage", null);
		response.sendRedirect("view-pending-customers.html");
	}else {
		session.setAttribute("sucessMessage", null);
		session.setAttribute("errorMessage", "Technical Issue");
		response.sendRedirect("view-pending-customers.html");
	}
	}

}
