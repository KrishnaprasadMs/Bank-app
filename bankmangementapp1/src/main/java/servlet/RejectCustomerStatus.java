package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bankmangementapp.EmployeeOperation;
import bankmangementapp.MyMail;

/**
 * Servlet implementation class RejectCustomerStatus
 */
public class RejectCustomerStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RejectCustomerStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailId = request.getParameter("emailId");
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		HttpSession session = request.getSession();
		
		if(EmployeeOperation.deleteCustomer(customerId)) {
			MyMail obj = new MyMail();
			obj.SendMail(emailId, "Account Status", "Your Account is Rejected Contact customer care");
			session.setAttribute("sucessMessage", "Customer Removed");
			session.setAttribute("errorMessage", null);
			response.sendRedirect("view-pending-customers.html");
			
		}
		else {
			session.setAttribute("sucessMessage", null);
			session.setAttribute("errorMessage", "Technical Issue");
			response.sendRedirect("view-pending-customers.html");
		}
	}

}
