//Adam Di Cioccio
//Lab Exercise 07
//CST8116-321

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		//declare variables
		GradingSystem gradingSystem;
		String course;
		String grade;
		String report;
		boolean validInput = false;
		
		//create scanner
		Scanner input = new Scanner(System.in);
 		
		//while loop to check if user inputs correct grade (A-F)
		while (!validInput) {
			
			//gather user input
			System.out.print("Please enter course number ");
			course = input.nextLine();
			System.out.print("Please enter letter grade ");
			grade = input.nextLine();
	        //set grade to upper case
			grade = grade.toUpperCase();
			
	        
			//if grade is equal to A-F then perform logic
	        if (grade.equals("A") || grade.equals("B") || grade.equals("C") || grade.equals("D") || grade.equals("E") || grade.equals("F")) {
	             
	     		//create parameterized constructor
	      		gradingSystem = new GradingSystem(course, grade);
	        	 
	        	 //call createReport method in GradingSystem
	     		report = gradingSystem.createReport();
	     		
	     		//print the results
	     		System.out.println(report);
	     		
	     		//print full name
	     		System.out.println("Program by Adam Di Cioccio \n");
	        	//close scanner 
	     		input.close();
	     		//exit loop
	        	validInput = true;
	        	
	        //if user did not input correct grade
	        } else
	            
	        	 //tell user it isn't option and restart loop
	        	 System.out.println(grade + " is not an option. Please try again. \n");

		}

	}
}



