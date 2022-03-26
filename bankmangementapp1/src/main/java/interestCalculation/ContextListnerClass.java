package interestCalculation;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



class DailyOperations extends TimerTask {
    public void run() {
    	System.out.println("Daily operations Executing......");
    	
    	InterestOperations.addDailyInterest(InterestOperations.calculateDailySavingsInterest());
    	InterestOperations.addDailyInterest(InterestOperations.calculateDailyCurrentInterest());
    	
    }
}


 
class MonthlyOperations extends TimerTask {
    public void run() {
       System.out.println("monthly operation executing........");
    	InterestOperations.addFdInterestToMainBalance(InterestOperations.calculateMonthlyFdInterest());
    	
    	InterestOperations.addRdInterestToMainBalance(InterestOperations.calculateMonthlyRdInterest());
    	
    	InterestOperations.monthlyaddInterestToMainBalance();
    	InterestOperations.addRdAmoundFromMainBalance(InterestOperations.selectRdDetails());
    	
    }
}
 
 
 
 
public class ContextListnerClass implements ServletContextListener{

	
	
	  private ScheduledExecutorService scheduler;

	    @Override
	    public void contextInitialized(ServletContextEvent event) {
	        scheduler = Executors.newSingleThreadScheduledExecutor();
	        Runnable command1 = new DailyOperations();
//	        long initialDelay1 = 2;
//	        TimeUnit unit1 = TimeUnit.SECONDS;
//	        long period1 = 2;
	        long initialDelay1 = 24;
	        TimeUnit unit1 = TimeUnit.HOURS;
	        long period1 = 24;
	        scheduler.scheduleAtFixedRate(command1, initialDelay1, period1, unit1); // daily operatations
	        
	        
	        
	        Runnable command2 = new MonthlyOperations(); // monthy operations
	        
//	        long initialDelay2 = 2;
//	        TimeUnit unit2 = TimeUnit.SECONDS;
//	        long period2 = 2;
	        long initialDelay2 = 30;
	        TimeUnit unit2 = TimeUnit.DAYS;
	        long period2 = 30;
	        scheduler.scheduleAtFixedRate(command2, initialDelay2, period2, unit2);
	        
	        
	        
	    }
        @Override
	    public void contextDestroyed(ServletContextEvent event) {
	        scheduler.shutdownNow();
	    }

		
	}

	
	
	


