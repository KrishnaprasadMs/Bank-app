package bankmangementapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerOperation {
	public static final String url = "jdbc:sqlite:D:\\project2\\bankmangementdb.db";

	
	public static boolean checkLoginCredentials(int customer_id, String password) {
		boolean isvalid = false;
		String query = "SELECT password FROM Customer_details WHERE customer_id = ?";
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url);

			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, customer_id);
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
	
	public static Customerdetails getCustomerDetails(String parameter, long value) {
		Customerdetails cust = null;

		if (parameter.equals("customer_id")) {
			String query = "select Customer_details.customer_id, Customer_details.customer_name,"
					+ " Customer_details.password, Customer_details.phone_number, Customer_details.email_id,"
					+ " Customer_details.pan_number, Customer_details.address, Customer_details.nominee_name,"
					+ " Customer_details.aadhaar, Customer_details.data_of_birth,"
					+ " Customer_details.account_status, customer_account_details.account_number, customer_account_details.account_balance,"
					+ " customer_account_details.interest_rate, customer_account_details.account_type, customer_account_details.fd_interest_rate, "
					+ "customer_account_details.rd_interest_rate, customer_account_details.fd_amount, customer_account_details.rd_amount,"
					+ " customer_account_details.maturity_duration, customer_account_details.fd_interest_add, customer_account_details.rd_interest_add, "
					+ "customer_account_details.main_interest_add from Customer_details, customer_account_details where Customer_details.customer_id = "+value+" AND customer_account_details.customer_id ="+value;
			try {
				Class.forName("org.sqlite.JDBC");
				Connection conn = DriverManager.getConnection(url);
				PreparedStatement st = conn.prepareStatement(query);
				ResultSet rs = st.executeQuery();
				cust = new Customerdetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getLong(9), rs.getString(10), rs.getString(11), rs.getLong(12), rs.getDouble(13), rs.getFloat(14), rs.getString(15), rs.getFloat(16), rs.getFloat(17), rs.getDouble(18), rs.getDouble(19), rs.getString(20), rs.getDouble(21),  rs.getDouble(22),  rs.getDouble(23));
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} 
		return cust;
	}
	
	public static boolean addcustomer(Customerdetails obj) {
		String query = "insert into Customer_details(customer_name, password, phone_number, email_id, pan_number, address, nominee_name, account_type, aadhaar, data_of_birth, account_status) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int i = 0;
		boolean isSucessful = false;
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, obj.getCustomerName());
			st.setString(2, obj.getPassword());
			st.setLong(3, obj.getPhoneNumber());
			st.setString(4, obj.getEmailId());
			st.setString(5, obj.getPanNumber());
			st.setString(6, obj.getAddress());
			st.setString(7, obj.getNomineeName());
			st.setString(8, obj.getAccountType());
			st.setLong(9, obj.getAadhaar());
			st.setString(10, obj.getDateOfBirth());
			st.setString(11, obj.getAccountStatus());

			i = st.executeUpdate();
			if (i != 0) {
				isSucessful = true;
			}
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isSucessful;
	}
	
		

}


//CREATE TABLE "Customer_details" (
//		"customer_id"	INTEGER NOT NULL UNIQUE,
//		"customer_name"	TEXT,
//		"password"	TEXT,
//		"phone_number"	INTEGER,
//		"email_id"	TEXT UNIQUE,
//		"pan_number"	INTEGER UNIQUE,
//		"address"	INTEGER,
//		"nominee_name"	INTEGER,
//		"account_type"	NUMERIC,
//		"aadhaar"	INTEGER UNIQUE,
//		"data_of_birth"	TEXT,
//		"account_status"	TEXT,
//		PRIMARY KEY("customer_id" AUTOINCREMENT)
//	)

//CREATE TABLE "customer_account_details" (
//"customer_id"	INTEGER UNIQUE,
//"account_number"	INTEGER NOT NULL UNIQUE,
//"account_balance"	BLOB,
//"interest_rate"	BLOB,
//"account_type"	TEXT,
//"fd_interest_rate"	BLOB,
//"rd_interest_rate"	BLOB,
//"fd_amount"	BLOB,
//"rd_amount"	BLOB,
//"maturity_duration"	TEXT,
//"fd_interest_add"	BLOB,
//"rd_interest_add"	BLOB,
//"main_interest_add"	BLOB,
//PRIMARY KEY("account_number" AUTOINCREMENT)
//)
