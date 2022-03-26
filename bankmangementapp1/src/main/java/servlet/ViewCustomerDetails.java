package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bankmangementapp.CustomerOperation;
import bankmangementapp.Customerdetails;

/**
 * Servlet implementation class ViewCustomerDetails
 */
public class ViewCustomerDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCustomerDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		Customerdetails cust = CustomerOperation.getCustomerDetails("customer_id", customerId);
		HttpSession session = request.getSession();
		session.setAttribute("viewcustomer", cust);
		response.sendRedirect("view-pending-customers.html#searchcustomer");
	}

}
