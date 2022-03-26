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
 * Servlet implementation class UpdateCustomerProfile
 */
public class UpdateCustomerProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));
		String address = request.getParameter("address");
		String nomineeName = request.getParameter("nomineeName");
		String emailId = request.getParameter("emailId");
		
		HttpSession session = request.getSession();
		Customerdetails obj = (Customerdetails) session.getAttribute("cust");
		boolean isUpdated = CustomerAccountOperation.UpdateAccount(phoneNumber, emailId, address, nomineeName, obj.getCustomerId());
		if(isUpdated) {
			session.setAttribute("errorMessage", null);
			session.setAttribute("sucessMessage", "Update Sucessfully");
			response.sendRedirect("customer-loggedIn.html");
		}
		else {
			session.setAttribute("sucessMessage", null);
			session.setAttribute("errorMessage", "Updation Failed");
			System.out.println("error");
			response.sendRedirect("customer-loggedIn.html");
		}
	}

}
