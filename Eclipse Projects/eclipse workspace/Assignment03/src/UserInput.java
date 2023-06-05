//Adam Di Cioccio
import java.util.Scanner;

public class UserInput {
	private Scanner scanner = new Scanner(System.in);
	private boolean validInput;
	private int userInt;
	private double userDouble;
	private String userInput;
	

	public int input() {

		//declare variables
		int minValue = 1;
		int maxValue = 8;
		
		//set boolean to false
		validInput = false;
		
		//start of while loop
		while (!validInput) {
			
			//get input
			userInput = scanner.next();
			
			//test for non integer input
			try {
		        Integer.parseInt(userInput);
		        //convert to integer
		        userInt = Integer.parseInt(userInput);
		    }
		    catch( Exception e ) {
		    		
		    }	
			
		//check if in range, if not try again
		if (userInt < (minValue) || userInt > (maxValue)) {
			System.out.println("Invalid input. Please enter a number between 1 and 8:");
			
		} else 
			validInput = true;
		
		}
		return userInt;
	}
	
	

	public double input2() {

		//declare variables
		double minValue = -10000.0;
		double maxValue = 10000.0;
		
		//set boolean to false
		validInput = false;
		
		//start of while loop
		while (!validInput) {
			//get input
			userInput = scanner.next();
		
			//test for non double input
			try {
		        Double.parseDouble(userInput);
		        //convert to double
				userDouble = Double.parseDouble(userInput);
		    }
		    catch( Exception e ) {
		    	
		    }
			
			//check if in range, if not try again
		if (userDouble < (minValue) || userDouble > (maxValue)) {
			System.out.println("Invalid input. Please enter a number between -10000.0 and 10000:");
			
		} else 
			validInput = true;
		}
		return userDouble;
	}
}
