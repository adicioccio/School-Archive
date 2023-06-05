/*
 * Adam DI Cioccio
 * Mohammad Pataory
 * December 8, 2020
 * Lab Exam 02
 */

import java.util.Scanner;

public class AdamDiCioccioLabExam02_321 {

	public static void main(String[] args) {
		//declare variables and classes
		Egg egg = new Egg();
		Menu menu = new Menu();
		boolean programIsRunning = true;
		
		//create scanner
		Scanner scanner = new Scanner(System.in);

		//while loop
		while (programIsRunning) {
			//call options list method and print out results
			System.out.println(menu.optionsList());
			
			//get user input
			System.out.println("Enter selection: ");
			int userInput =  scanner.nextInt();
			
			if (userInput == 321) {
				//get user input
				System.out.println("Enter ounces: ");
				//set value
				double ounces =  scanner.nextDouble();
				//call setter from egg.java
				egg.setOunces(ounces);
				
				//get user input
				System.out.println("Enter price per ounce: ");
				//set value
				double pricePerOunce =  scanner.nextDouble();
				//call setter from egg.java
				egg.setPricePerOunce(pricePerOunce);
				
			} else if (userInput == 642) {
				//show sales cost
				System.out.println("Sales cost: " + egg.calculateSalesCost());

				
			} else if (userInput == 963) {
				//exit program message
				System.out.println("Exiting Program...");
				//close scanner
				scanner.close();
				//stop while loop
				programIsRunning = false;
				
			} else
				//display then restart while loop
				System.out.println("Invalid input. Please try again.");
		}
			
	}

}
