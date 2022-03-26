package bankmangementapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CustomerAccountOperation {
	public static final String url = "jdbc:sqlite:D:\\project2\\bankmangementdb.db";
	
	public static boolean addAmount(long accountNumber, int amount, double accountBalance) {
		boolean isSucess = false;
		
		accountBalance += amount;
		try {
			String query = " UPDATE customer_account_details SET account_balance = ? where account_number = ?";
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement st;
			st = conn.prepareStatement(query);
			st.setDouble(1, accountBalance);
			st.setLong(2, accountNumber);
			int i = st.executeUpdate();
	        conn.close();
	        if(i !=0) {
	        	isSucess = true ;
	        }

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	
			return isSucess ;

	}
	
	public static boolean withdrawAmount(int customer_id, int amount, double accountBalance) {
		 boolean isSucess = false;
		 if((accountBalance -amount)>=0.0) {
			 accountBalance  = accountBalance - amount ;
              System.out.println(accountBalance);
				try {
					String query = " UPDATE customer_account_details SET account_balance = ? where customer_id = ?";
					Class.forName("org.sqlite.JDBC");
					Connection conn = DriverManager.getConnection(url);
					PreparedStatement st;
					st = conn.prepareStatement(query);
					st.setDouble(1, accountBalance);
					st.setInt(2, customer_id);
					int i = st.executeUpdate();
			        conn.close();
			        if(i !=0) {
			        	isSucess = true ;
			        }
			    	System.out.println("i val = "+i);

				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {

					e.printStackTrace();
				} 	 
		 }
		 return isSucess ;
	}
	
	public static double getTransferAccountBalance(long accountNumber) {
		double accountBalance = -1;
		
		try {
			String query = " Select account_balance from customer_account_details where account_number = ?";
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement st;
			st = conn.prepareStatement(query);
			st.setLong(1, accountNumber);
		    ResultSet rs = st.executeQuery();
		    accountBalance = rs.getDouble(1);
	        conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	
			return accountBalance ;

	}
	
	 public static boolean UpdateAccount(long phoneNumber, String emailId, String address, String nomineeName, int customer_id) {
			
			String querry = "update Customer_details set phone_number = ?, email_id = ?,address = ?,nominee_name = ? where customer_id = ?";
			boolean isUpdated = false;
			try {
				Class.forName("org.sqlite.JDBC");
				Connection conn = DriverManager.getConnection(url);
				PreparedStatement st = conn.prepareStatement(querry);
				st.setLong(1, phoneNumber);
				st.setString(2, emailId);
				st.setString(3, address);
				st.setString(4, nomineeName);
				st.setInt(5, customer_id);
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
	 
	 public static boolean insertTranslation(long accountNumber, String timeDate, String translation, double amount, double balance) {
			String query = "insert into translation(account_number, time_date, translation, amount, balance) values(?, ?, ?, ?, ?)";
			boolean isSucessful = false;
			try {
				Class.forName("org.sqlite.JDBC");
				Connection conn = DriverManager.getConnection(url);
				PreparedStatement st = conn.prepareStatement(query);
				st.setLong(1, accountNumber);
				st.setString(2, timeDate);
				st.setString(3, translation);
				st.setDouble(4, amount);
				st.setDouble(5, balance);

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
	 
	 public static String timeDate() {
		 
		 String timeDate;
		 LocalDateTime myDateObj = LocalDateTime.now();  
		 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
		 timeDate = myDateObj.format(myFormatObj);
		 return timeDate;
		 
	 }
	 
	 public static ArrayList<TranslationPOJO> readAllTranslation(long accountNumber) {
			
			String querry = "select account_number, time_date, translation, amount, balance from translation WHERE account_number = ?";
			ArrayList<TranslationPOJO> translations = new ArrayList<>();
			try {
				Class.forName("org.sqlite.JDBC");
				Connection conn = DriverManager.getConnection(url);
				PreparedStatement st = conn.prepareStatement(querry);
				st.setLong(1, accountNumber);
				ResultSet rs = st.executeQuery();
				while(rs.next()) {
					TranslationPOJO translation = new TranslationPOJO(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getFloat(5));
					translations.add(translation);
					
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
			return translations;
		}
	 
	 public static boolean addFdOrRdAmount(String interestRate  ,int custId , double amount, int duration ) {
			boolean isupdated = false ;
			 String timeDate;
			 LocalDateTime myDateObj = LocalDateTime.now();  
			 myDateObj = myDateObj.plusMonths(duration);
			 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
			 timeDate = myDateObj.format(myFormatObj);
			 System.out.println(timeDate);
		
			 float interest = EmployeeOperation.getInterestRate(interestRate);
			 String amountColumn="";
				String query= "";
			
			if(interestRate.substring(0, 2).equalsIgnoreCase("Fd")) {
		
		     amountColumn  =	"fd_amount";
			 query = "update customer_account_details set "+interestRate+" = '"+interest+"',"+amountColumn+" = '"+amount+"' ,maturity_duration = '"+timeDate+"' where customer_id = '"+custId+"'";
 
			}else if (interestRate.substring(0, 2).equalsIgnoreCase("Rd")) {
				amountColumn  =	"rd_amount";
				 query = "update customer_account_details set "+interestRate+" = '"+interest+"',"+amountColumn+" = '"+amount+"' , rd_interest_add ='"+amount+"',  maturity_duration = '"+timeDate+"' where customer_id = '"+custId+"'";
				
			}else {
			
				return isupdated ;
			}
			
				try {
					int i = 0;
					Class.forName("org.sqlite.JDBC");
					Connection con = DriverManager.getConnection(url);
					PreparedStatement st = con.prepareStatement(query);
					 i = st.executeUpdate();
					 con.close();
					 if(i !=0) {
						 isupdated = true ;
						 return isupdated ;
					 }
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			
			return isupdated;
		}

}

//CREATE TABLE "translation" (
//		"account_number"	INTEGER,
//		"time_date"	TEXT,
//		"translation"	TEXT,
//		"amount"	BLOB,
//		"balance"	BLOB
//	)

//CREATE TABLE "Customer_details" (
//"customer_id"	INTEGER NOT NULL UNIQUE,
//"customer_name"	TEXT,
//"password"	TEXT,
//"phone_number"	INTEGER,
//"email_id"	TEXT UNIQUE,
//"pan_number"	INTEGER UNIQUE,
//"address"	INTEGER,
//"nominee_name"	INTEGER,
//"account_type"	NUMERIC,
//"aadhaar"	INTEGER UNIQUE,
//"data_of_birth"	TEXT,
//"account_status"	TEXT,
//PRIMARY KEY("customer_id" AUTOINCREMENT)
//)

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
