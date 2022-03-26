package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bankmangementapp.Customerdetails;
import bankmangementapp.EmployeeOperation;

/**
 * Servlet implementation class ViewPendingCustomers
 */
public class ViewPendingCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPendingCustomers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<Customerdetails> pendingcustomers = EmployeeOperation.readAllEmployees();
		ArrayList<Customerdetails> activecustomers = EmployeeOperation.readAllActivecustomers();
		long[] assetAndNoofCust = EmployeeOperation.totalCustAndTotalAsset();
		float[] getAllInterestRate = EmployeeOperation.getAllInterestRate();
		
		request.setAttribute("customers", pendingcustomers);
		request.setAttribute("activecustomers", activecustomers);
		request.setAttribute("asset", assetAndNoofCust[1]);
		request.setAttribute("NoofCust", assetAndNoofCust[0]);
		request.setAttribute("getAllInterestRate", getAllInterestRate);
		request.getRequestDispatcher("employeehome.jsp").forward(request, response);
	}

}
