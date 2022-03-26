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
 * Servlet implementation class FdRdDeposit
 */
public class FdRdDeposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FdRdDeposit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		double addamount= Double.parseDouble(request.getParameter("addamount"));
		int duration= Integer.parseInt(request.getParameter("duration"));
		String fdOrRdType = request.getParameter("fdOrRdType");
		Customerdetails obj = (Customerdetails) session.getAttribute("cust");
		
		if(obj.getAccountType().equals("Current")) {
			session.setAttribute("sucessMessage", null);
			session.setAttribute("errorMessage", "Fd/Rd Not For Current");
			response.sendRedirect("customer-loggedIn.html");	
		}
		else if(Double.compare(obj.getRdAmount(), 0.0)>0 || Double.compare(obj.getFdAmount(), 0.0) >0) {
			session.setAttribute("errorMessage", "Already Deposited In Fd/Rd");
			session.setAttribute("sucessMessage", null);
			response.sendRedirect("customer-loggedIn.html");	
		}
		else if(addamount<1000) {
			session.setAttribute("errorMessage", "Min Rs1000 amount Required");
			session.setAttribute("sucessMessage", null);
			response.sendRedirect("customer-loggedIn.html");	
		}
		else {
			boolean isAdded = CustomerAccountOperation.addFdOrRdAmount(fdOrRdType, obj.getCustomerId(), addamount, duration);
			
			if(isAdded) {
				session.setAttribute("errorMessage", null);
				session.setAttribute("sucessMessage", "Money Deposited Sucessfully");
				System.out.println("added");
				response.sendRedirect("customer-loggedIn.html");	
			}
			else {
				session.setAttribute("sucessMessage", null);
				session.setAttribute("errorMessage", "Technical Issue");
				response.sendRedirect("customer-loggedIn.html");	
			}
		}
		
	}

}
