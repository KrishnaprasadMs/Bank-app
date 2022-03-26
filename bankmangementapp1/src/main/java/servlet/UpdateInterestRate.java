package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bankmangementapp.EmployeeOperation;

/**
 * Servlet implementation class UpdateInterestRate
 */
public class UpdateInterestRate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInterestRate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		float interestRate= Float.parseFloat(request.getParameter("interestRate"));
		String accountType = request.getParameter("accounType");
		HttpSession session = request.getSession();
		
	   boolean isUpdated = EmployeeOperation.updateRateOfInterest(accountType,interestRate);
	   
	   if(isUpdated) {
		   session.setAttribute("sucessMessage", "Updated");
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
