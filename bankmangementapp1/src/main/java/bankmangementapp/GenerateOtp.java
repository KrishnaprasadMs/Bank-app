package bankmangementapp;

import java.util.Random;

public class GenerateOtp {
	
	public  int generateOTP() {
		int length = 4;
	      String numbers = "1234567890";
	      Random random = new Random();
          String strOtp="";
	      for(int i = 0; i< length ; i++) {
	    	  strOtp =strOtp + numbers.charAt(random.nextInt(numbers.length()));
	      }
	      return Integer.parseInt(strOtp);
	   }

}
