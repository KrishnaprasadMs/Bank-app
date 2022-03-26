package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bankmangementapp.CustomerOperation;
import bankmangementapp.Customerdetails;
import bankmangementapp.GenerateOtp;
import bankmangementapp.MyMail;

/**
 * Servlet implementation class CustomerSignup
 */
public class CustomerSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int otp;
	Customerdetails customer = new Customerdetails();
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerSignup() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		if ((request.getParameter("otp") == null)) {
			customer.setCustomerName(request.getParameter("name"));
			customer.setPassword(request.getParameter("password"));
			customer.setDateOfBirth(request.getParameter("dateofbirth"));
			customer.setAadhaar(Long.parseLong(request.getParameter("aadhar")));
			customer.setPanNumber(request.getParameter("pan"));
			customer.setAddress(request.getParameter("address"));
			customer.setAccountType(request.getParameter("acctype"));
			customer.setNomineeName(request.getParameter("nominee"));
			customer.setPhoneNumber(Long.parseLong(request.getParameter("phone")));
			customer.setEmailId(request.getParameter("email"));
			customer.setAccountStatus("pending");

			GenerateOtp obj = new GenerateOtp();
			this.otp = obj.generateOTP();
			MyMail mail = new MyMail();
			mail.SendMail(request.getParameter("email"),"bank otp Verification",String.valueOf(this.otp));
			
			PrintWriter out = response.getWriter();
			RequestDispatcher footer = request.getRequestDispatcher("signup.jsp");
			footer.include(request, response);
			out.println("<script type=\"text/javascript\">");
			out.println("document.getElementById('id01').style.display='block'");
	        out.println("</script>");
		}
		else {
			if(!(this.otp == Integer.parseInt(request.getParameter("otp")))) {
				PrintWriter out = response.getWriter();
				RequestDispatcher footer = request.getRequestDispatcher("signup.jsp");
				footer.include(request, response);
				out.println("<script type=\"text/javascript\">");
				out.println("document.getElementById('id01').style.display='block'");
				out.println("setTimeout(() => {confirm('Invalid Otp')}, 1000);");
		        out.println("</script>");
			}
			else {
				if(CustomerOperation.addcustomer(customer)) {
					request.setAttribute("SignupMessage", "Your Account Created Status is Pending...");
					request.getRequestDispatcher("home.jsp").forward(request, response);
				}
				else {
					request.setAttribute("SignupMessage", "You Already Have Account");
					request.getRequestDispatcher("home.jsp").forward(request, response);
					
				}
			}
		}

	}

}
