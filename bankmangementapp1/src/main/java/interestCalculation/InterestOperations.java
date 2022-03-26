package interestCalculation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import bankmangementapp.*;

public class InterestOperations {

	public static final String url = "jdbc:sqlite:D:\\project2\\bankmangementdb.db";

	public static void addDailyInterest(ArrayList<Customerdetails> list) {

		Customerdetails obj = null;
		for (int i = 0; i < list.size(); i++) {

			obj = list.get(i);

			int custId = obj.getCustomerId();

			double interestToadd = obj.getMainInterestAdd();
			System.out.println("Cust id " + custId + "   Daily interest to add = " + interestToadd);
			String query = "UPDATE customer_account_details SET main_interest_add = " + interestToadd + "  WHERE "
					+ "customer_id =" + custId;

			try {
				Class.forName("org.sqlite.JDBC");
				Connection con = DriverManager.getConnection(url);

				PreparedStatement st = con.prepareStatement(query);
				st.executeUpdate();

				con.close();

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static ArrayList<Customerdetails> calculateDailySavingsInterest() {
		ArrayList<Customerdetails> list = new ArrayList<Customerdetails>();

		String query = "SELECT customer_id,account_balance,interest_rate,main_interest_add FROM customer_account_details where account_type ='Saving' ";
		System.out.println(query);
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url);

			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Customerdetails cust = new Customerdetails();
				cust.setCustomerId(rs.getInt(1));
				System.out.println("Customer id in calculate daily interest  " + cust.getCustomerId());
				cust.setAccountBalance(rs.getDouble(2));
				cust.setInterestRate(rs.getFloat(3));
				double mainInterestAdd = rs.getDouble(4);
//				System.out.println("interest before update =" + mainInterestAdd);
//
//				System.out.println(cust.getAccountBalance() + "   " + cust.getInterestRate());

				mainInterestAdd += cust.getAccountBalance() * Double.valueOf(cust.getInterestRate())
						/ Double.valueOf(36500);

				// System.out.println("interest after update =" + mainInterestAdd);

				cust.setMainInterestAdd(mainInterestAdd);

				list.add(cust);

			}
			
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

//		for(Customerdetails obj : list) {
//			System.out.println("cust id =="+obj.getCustomerId());
//		}

		return list;

	}

	public static ArrayList<Customerdetails> calculateMonthlyFdInterest() {
		ArrayList<Customerdetails> list = new ArrayList<>();

		String query = "SELECT customer_id,fd_interest_rate,fd_amount FROM customer_account_details where fd_interest_rate > ? ";

		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url);

			PreparedStatement st = con.prepareStatement(query);
			st.setFloat(1, 1);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Customerdetails cust = new Customerdetails();

				cust.setCustomerId(rs.getInt(1));
				cust.setFdInterestRate(rs.getFloat(2));

				double fdAmount = rs.getDouble(3);

				fdAmount += fdAmount * Double.valueOf(cust.getFdInterestRate()) / Double.valueOf(1200); // calculate
																										// interest
																										// for
																										// one
																										// month

				cust.setFdAmount(fdAmount);

				list.add(cust);

			}
			con.close();
//         for(Customerdetails obj : list) {
//        	 System.out.println(obj.getCustomerId());
//        	 System.out.println(obj.getFdAmount());
//        	 
//         }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

	public static void addFdInterestToMainBalance(ArrayList<Customerdetails> list) {

		Customerdetails cust = null;

		for (int i = 0; i < list.size(); i++) {

			cust = list.get(i);

			int custId = cust.getCustomerId();

			double fdAmount = cust.getFdAmount();

			String query = "UPDATE customer_account_details SET fd_amount = " + fdAmount + "  WHERE " + "customer_id ="
					+ custId;

			try {
				Class.forName("org.sqlite.JDBC");
				Connection con = DriverManager.getConnection(url);

				PreparedStatement st = con.prepareStatement(query);
				st.executeUpdate();

				con.close();

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static ArrayList<Customerdetails> calculateMonthlyRdInterest() {
		ArrayList<Customerdetails> list = new ArrayList<>();

		String query = "SELECT customer_id,rd_interest_rate,rd_amount FROM customer_account_details where rd_interest_rate >  ?";

		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url);

			PreparedStatement st = con.prepareStatement(query);
			st.setFloat(1, 1);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Customerdetails cust = new Customerdetails();

				cust.setCustomerId(rs.getInt(1));
				cust.setRdInterestRate(rs.getFloat(2));

				double rdAmound = rs.getDouble(3);

				rdAmound += rdAmound * Double.valueOf(cust.getFdInterestRate()) / Double.valueOf(1200);// calculate
																										// interest for
																										// one month

				cust.setRdAmount(rdAmound);

				list.add(cust);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

	public static void addRdInterestToMainBalance(ArrayList<Customerdetails> list) {

		Customerdetails cust = null;

		for (int i = 0; i < list.size(); i++) {

			cust = list.get(i);

			int custId = cust.getCustomerId();

			double rdAmount = cust.getRdAmount();

			String query = "UPDATE customer_account_details SET rd_amount = " + rdAmount + "  WHERE " + "customer_id ="
					+ custId;

			try {
				Class.forName("org.sqlite.JDBC");
				Connection con = DriverManager.getConnection(url);

				PreparedStatement st = con.prepareStatement(query);
				st.executeUpdate();

				con.close();

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void setMaininterestToAddZero() {

		String query = "UPDATE customer_account_details SET main_interest_add = 0 ";

		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url);

			PreparedStatement st = con.prepareStatement(query);
			st.executeUpdate();

			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static ArrayList<Customerdetails> calculateDailyCurrentInterest() {
		ArrayList<Customerdetails> list = new ArrayList<>();

		String query = "SELECT customer_id,account_balance,interest_rate,main_interest_add FROM customer_account_details where account_type ='Current' ";
		System.out.println(query);
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url);

			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Customerdetails cust = new Customerdetails();
				cust.setCustomerId(rs.getInt(1));
				cust.setAccountBalance(rs.getDouble(2));
				cust.setInterestRate(rs.getFloat(3));
				double mainInterestAdd = rs.getDouble(4);
				System.out.println("interest before update =" + mainInterestAdd);

				System.out.println(cust.getAccountBalance() + "   " + cust.getInterestRate());

				mainInterestAdd += cust.getAccountBalance() * Double.valueOf(cust.getInterestRate())
						/ Double.valueOf(36500);

				System.out.println("interest after update =" + mainInterestAdd);
				// mainInterestAdd = mainInterestAdd/100 ;
				cust.setMainInterestAdd(mainInterestAdd);
				list.add(cust);

			}

			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

	public static void monthlyaddInterestToMainBalance() {

		String query = "UPDATE customer_account_details SET account_balance = account_balance + main_interest_add ";
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url);

			PreparedStatement st = con.prepareStatement(query);
			st.executeUpdate();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		setMaininterestToAddZero();

	}
	
	public static void addRdAmoundFromMainBalance(ArrayList<Customerdetails> list) {

		Customerdetails cust = null;

		for (int i = 0; i < list.size(); i++) {

			cust = list.get(i);

			int custId = cust.getCustomerId();
			double mainBalance = cust.getAccountBalance();

			double rdAmount = cust.getRdAmount();
			double rdInterestAdd = cust.getRdInterestAdd();

			// (int customer_id, int amount, double accountBalance)
			if (CustomerAccountOperation.withdrawAmount(custId, (int) rdInterestAdd, mainBalance)) {
				rdAmount += Double.valueOf((int) rdInterestAdd);
				String query = "UPDATE customer_account_details SET rd_amount = " + rdAmount + "  WHERE "
						+ "customer_id =" + custId;
				try {
					Class.forName("org.sqlite.JDBC");
					Connection con = DriverManager.getConnection(url);

					PreparedStatement st = con.prepareStatement(query);
					st.executeUpdate();

					con.close();

				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				Customerdetails obj = CustomerOperation.getCustomerDetails("customer_id", custId);
				MyMail mail = new MyMail();
				String sub = "Hi " + obj.getCustomerName()
						+ "<br><p>monthy deduction from main balance for RD failed due to insufficient main balance</p>";
				mail.SendMail(obj.getEmailId(), "Recurring Deposit failrd ", sub);

			}

		}

	}
	
	public static ArrayList<Customerdetails> selectRdDetails() {

		ArrayList<Customerdetails> list = new ArrayList<>();

		String query = "SELECT customer_id,account_balance,rd_interest_add ,rd_amount FROM customer_account_details where rd_interest_rate >  '1' ";
		System.out.println(query);
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url);

			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Customerdetails cust = new Customerdetails();
				cust.setCustomerId(rs.getInt(1));
				cust.setAccountBalance(rs.getDouble(2));
				cust.setRdInterestAdd(rs.getDouble(3));
				cust.setRdAmount(rs.getDouble(4));
				list.add(cust);

			}

			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

}

//CREATE TABLE "Interest_rate" (
//		"Saving"	BLOB,
//		"Current"	BLOB,
//		"Fd_interest_rate"	BLOB,
//		"Rd_interest_rate"	BLOB
//	)

//SELECT count(*) , SUM(account_balance + fd_amount + rd_amount) FROM customer_account_details

/*
 * CREATE TABLE "customer_account_details" ( "customer_id" INTEGER UNIQUE,
 * "account_number" INTEGER NOT NULL UNIQUE, "account_balance" BLOB,
 * "interest_rate" BLOB, "account_type" TEXT, "fd_interest_rate" BLOB,
 * "rd_interest_rate" BLOB, "fd_amount" BLOB, "rd_amount" BLOB,
 * "maturity_duration" TEXT, "fd_interest_add" BLOB, "rd_interest_add" BLOB,
 * "main_interest_add" BLOB, PRIMARY KEY("account_number" AUTOINCREMENT) )
 * 
 */

//CREATE TABLE "Customer_details" (
//"customer_id"	INTEGER NOT NULL UNIQUE,
//"customer_name"	TEXT,
//"password"	TEXT,
//"phone_number"	INTEGER,
//"email_id"	TEXT UNIQUE,
//"pan_number"	INTEGER UNIQUE,
//"address"	INTEGER,
//"nominee_name"	INTEGER,
//"account _type"	NUMERIC,
//"aadhaar"	INTEGER UNIQUE,
//"data_of_birth"	TEXT,
//"account_status"	TEXT,
//PRIMARY KEY("customer_id" AUTOINCREMENT)
//)

//  SELECT  customer_id, SUM(account_balance + main_interest_add)FROM    customer_account_details GROUP   BY customer_id 

// SELECT customer_id,account_balance,interest_rate,main_interest_add FROM customer_account_details where interest_rate iS NOT NULL ;
