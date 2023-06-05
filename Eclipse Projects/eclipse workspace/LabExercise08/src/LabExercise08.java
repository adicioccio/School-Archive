//Adam Di Cioccio
//Lab Practice Exam 08
//Mohammad Patoary

import java.util.Scanner;

public class LabExercise08 {

	public static void main(String[] args) {
		//declare variables
		boolean programIsRunning = true;
		double num = 0;
		double total = 0;
		double totalGrade = 0;
		int i = 0;
		String userInput;
		
		//create scanner
		Scanner scanner = new Scanner(System.in);
		
		//while loop for program
		while (programIsRunning) {
			
			i = 1;
			num = 0;
			total = 0;
	
			//get users input
			for (i = 1; i <= 5; i++) {
				//get user input
				System.out.println("Enter Grade " + i + ": ");
				num = scanner.nextDouble();
				//add number to previous
				total = num + total;
			}
			
			//perform calculations to get average
			totalGrade = total / 5;
			
			//print results
			System.out.println("Average Grade: " + totalGrade);
			
			//get user input (YES or NO)
			System.out.println("Continue Program? (Y/N)");
			userInput = scanner.next();
			userInput.toUpperCase();
			
			//check to see what user inputs and perform logic based on answer
			if (userInput.equals("N")) {
				//display exit message
				System.out.println("Exiting Program... \nProgram By: Adam Di Cioccio");
				//close scanner
				scanner.close();
				//end while loop
				programIsRunning = false;
			
			} else if (userInput.equals("Y")) {
				//restart while loop
				continue;
			} 
		
			
		}

	}

}
