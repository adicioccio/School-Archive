import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class contains the main script that is run including the menu system
 * Student Name: Adam Di Cioccio
 * Student Number: 041019241
 * Section #: 304
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 * 
 */

public class Lab1 {
	
	//main class
	public static void main(String[] args) {
		
		//create scanner
		Scanner input = new Scanner(System.in);
		
		//initialize variables
		Numbers n1 = null;
		String output;
		Float average;
		Float maximum;
		Float minimum;
		
		//initialize variables
		boolean programExit = false;
			
		//while loop for the program
		while (programExit != true) {
			
			//initialize variable
			int selection = 0;
			//provide user with instructions
			printMenu();
			
			//try catch statement in case user doesn't enter integer
			try {
			//set input into variable
			selection = input.nextInt();
			
			} catch (InputMismatchException e) {
				System.out.println(e);
				main(null);
				
			}
			
			//menu selection routes
			if (selection == 1) {
				
				//initialize class
				n1 = new Numbers();
			
			} else if (selection == 2) {
				
				//initialize max size
				int maxSize = 0;
				
				//ask user for input then call parameterized constructor
				System.out.println("Specify max size of the array.");
				
				//try catch statement in case user doesn't enter integer or negative integer
				try {
				//set input into variable
				maxSize = input.nextInt();
				n1 = new Numbers(maxSize);
				
				} catch (InputMismatchException e) {
					System.out.println(e);
					main(null);
					
				} catch (NegativeArraySizeException e) {
					System.out.println(e);
					main(null);
				}
				
			} else if (selection == 3) {
				
				//call add value method with scanner input
				n1.addValue(input);
			
			} else if (selection == 4) {
				
				//call to string method and display values
				System.out.println("Displaying all values...");
				output = n1.toString();
				System.out.println(output);
				
			
			} else if (selection == 5) {
				//print out average max and min
				System.out.println("Printing average, maximum, minimum...");
				average = n1.calcAverage();
				System.out.print("Average: " + average + " ");
				
				maximum = n1.calcMaximum();
				System.out.print("| Max: " + maximum + " ");
				
				minimum = n1.calcMinimum();
				System.out.print("| Min: " + minimum + " \n\n");
				
			} else if (selection == 6 ) {
				
				//exit program
				programExit = true;
				
			} else {
				
				//if user enters incorrect integer
				System.out.println("Incorrect input value! Please try again.\n");
				
			
			}
			
		}
		
	}
	
	//user instructions
	public static void printMenu() {
		System.out.println("Please select one of the options below!"
				+ "\n1. Initialize a default array"
				+ "\n2. Specify max size of array"
				+ "\n3. Add a value to the array"
				+ "\n4. Display values in the array"
				+ "\n5. Display the average, minimum and maximum out of the values"
				+ "\n6. Exit the program");
	}

}
