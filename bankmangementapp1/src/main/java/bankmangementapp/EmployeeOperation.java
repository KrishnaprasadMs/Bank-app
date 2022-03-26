package bankmangementapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class EmployeeOperation {
	 static final String url = "jdbc:sqlite:D:\\project2\\bankmangementdb.db";
	
	public static boolean checkLoginCredentials(int employee_id, String password) {
		boolean isvalid = false;
		
		String query = "SELECT password FROM Employee_details WHERE employee_id = ?";
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url);

			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, employee_id);
			ResultSet rs = st.executeQuery();
			System.out.println("value of rs : " + rs.getString(1));

			if (password.equals(rs.getString(1))) {
				isvalid = true;
			}
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isvalid;
	}
	
	public static ArrayList<Customerdetails> readAllActivecustomers() {
		
		String querry = "select customer_id, customer_name, password, phone_number, email_id, pan_number, address, nominee_name, account_type, aadhaar, data_of_birth, account_status from Customer_details WHERE account_status = ?";
		ArrayList<Customerdetails> customers = new ArrayList<>();
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement st = conn.prepareStatement(querry);
			st.setString(1, "active");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Customerdetails customer = new Customerdetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getLong(10), rs.getString(11), rs.getString(12));
				customers.add(customer);
				
			}
			
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 1. Register/Load Driver
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
	}
	
	public static boolean approvecustomer(int customerId, String accountType, float interestRate) {
		String query = "insert into customer_account_details(customer_id, account_balance, interest_rate, account_type, main_interest_add) values(?, ?, ?, ?, ?)";
		boolean isSucessful = false;
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, customerId);
			st.setDouble(2, 0);
			st.setFloat(3, interestRate);
			st.setString(4, accountType);
			st.setDouble(5, 0);

			 st.execute();
			conn.close();
			isSucessful = true;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isSucessful;
	}
	
    public static float getInterestRate(String interestRate) {
		
		String querry = "select "+interestRate+" from Interest_rate";
		float rateOfInterest = 0.0f;
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement st = conn.prepareStatement(querry);
			ResultSet rs = st.executeQuery();
		     rateOfInterest = rs.getFloat(1);
		     conn.close();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 1. Register/Load Driver
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rateOfInterest;
	}
    
    public static boolean UpdateStatus(int customer_id) {
		
		String querry = "update Customer_details set account_status = ? where customer_id = ?";
		boolean isUpdated = false;
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement st = conn.prepareStatement(querry);
			st.setString(1, "active");
			st.setInt(2, customer_id);
			int i = st.executeUpdate();
		    if(i!=0) {
		    	isUpdated=true; }
		     conn.close();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 1. Register/Load Driver
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUpdated;
	}
    
    public static boolean deleteCustomer(int customerId) {
    	
		String deleteQuery = "delete from Customer_details where customer_id = "+ customerId;
		boolean isDeleted = false;
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement st = conn.prepareStatement(deleteQuery);
			int i = st.executeUpdate();
			if(i!=0) {
				isDeleted=true;
				}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error in Deleted the row");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isDeleted;
	}
    
public static ArrayList<Customerdetails> readAllEmployees() {
		
		String querry = "select customer_id, customer_name, password, phone_number, email_id, pan_number, address, nominee_name, account_type, aadhaar, data_of_birth, account_status from Customer_details WHERE account_status = ?";
		ArrayList<Customerdetails> Employees = new ArrayList<>();
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement st = conn.prepareStatement(querry);
			st.setString(1, "pending");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Customerdetails Employee = new Customerdetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getLong(10), rs.getString(11), rs.getString(12));
				Employees.add(Employee);
				
			}
			
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 1. Register/Load Driver
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Employees;
	}

public static long[] totalCustAndTotalAsset() {
	
	long assetAndNoofCust [] = new long [2];
	long asset=0;
	String query = "SELECT  account_balance , fd_amount , rd_amount FROM customer_account_details " ; 
	try {
		Class.forName("org.sqlite.JDBC");
		Connection con = DriverManager.getConnection(url);

		PreparedStatement st = con.prepareStatement(query);
		ResultSet rs =  st.executeQuery();
		long i =0;
		while(rs.next()) {
			i++;
			//assetAndNoofCust[0] = rs.getLong(1);
			asset += rs.getLong(1) +rs.getLong(2) + rs.getLong(3);
			
			
		}
		assetAndNoofCust[0] = i;
		assetAndNoofCust[1] = asset;
		 con.close();
		

		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return assetAndNoofCust ;
}

public static float[] getAllInterestRate() {
	
	String querry = "select Saving, Current, Fd_interest_rate, Rd_interest_rate from Interest_rate";
	float rateOfInterest [] = new float [4]; 
	try {
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection(url);
		PreparedStatement st = conn.prepareStatement(querry);
		ResultSet rs = st.executeQuery();
	     rateOfInterest [0] = rs.getFloat(1);
	     rateOfInterest [1] = rs.getFloat(2);
	     rateOfInterest [2] = rs.getFloat(3);
	     rateOfInterest [3] = rs.getFloat(4);
	     conn.close();
	}
	catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} // 1. Register/Load Driver
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rateOfInterest;
}

public static boolean  updateRateOfInterest(String parameter , float value) {
	String query = "";
	int i = -1 ;
	boolean isupdated = false ;
	 if (parameter.equals("fixed")){
		query ="UPDATE Interest_rate SET Fd_interest_rate = ? ";
		
	}
	else if(parameter.equals("recurring")) {
		query ="UPDATE Interest_rate SET Rd_interest_rate = ? ";
		
	}else if(parameter.equals("saving")){
		
		query = "UPDATE Interest_rate SET Saving = ? ";
		
	}else if (parameter.equals("current")){
		query = "UPDATE Interest_rate SET Current = ? ";

		
	}
	 try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url);

			PreparedStatement st = con.prepareStatement(query);
			st.setFloat(1, value);
		    i = st.executeUpdate();
		    if(i !=0) {
		    	
		    	isupdated = true ;
		    }

			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 
	 
	 
	 
	 
	  return isupdated ;
	
}

}

//CREATE TABLE "customer_account_details" (
//		"customer_id"	INTEGER UNIQUE,
//		"account_number"	INTEGER NOT NULL UNIQUE,
//		"account_balance"	BLOB,
//		"interest_rate"	BLOB,
//		"account_type"	TEXT,
//		"fd_interest_rate"	BLOB,
//		"rd_interest_rate"	BLOB,
//		"fd_amount"	BLOB,
//		"rd_amount"	BLOB,
//		"maturity_duration"	TEXT,
//		"fd_interest_add"	BLOB,
//		"rd_interest_add"	BLOB,
//		"main_interest_add"	BLOB,
//		PRIMARY KEY("account_number" AUTOINCREMENT)
//	)

//CREATE TABLE "Interest_rate" (
//		"Saving"	BLOB,
//		"Current"	BLOB,
//		"Fd_interest_rate"	BLOB,
//		"Rd_interest_rate"	BLOB
//	)

//CREATE TABLE "Customer_details" (
//		"customer_id"	INTEGER NOT NULL UNIQUE,
//		"customer_name"	TEXT,
//		"password"	TEXT,
//		"phone_number"	INTEGER,
//		"email_id"	TEXT UNIQUE,
//		"pan_number"	INTEGER UNIQUE,
//		"address"	INTEGER,
//		"nominee_name"	INTEGER,
//		"account_type"	TEXT,
//		"aadhaar"	INTEGER UNIQUE,
//		"data_of_birth"	TEXT,
//		"account_status"	TEXT,
//		PRIMARY KEY("customer_id" AUTOINCREMENT)
//	)