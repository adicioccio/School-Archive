import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This is the main class that includes the menu system and certain functionalities.
 * Student Name: Adam Di Cioccio
 * Student Number: 041019241
 * Section #: 304
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 */

public class Lab02BinLinSearchTest {

	/**
	 * @param args arugments
	 * @param method that contains the loop for the program and each functionality
	 */
	public static void main(String[] args) {
		
		//create scanner
		Scanner input = new Scanner(System.in);
		
		//variables
		int choice = 0;
		boolean program = false;
		
		//initialize object
		BinaryLinearSearch bl = new BinaryLinearSearch();
		
		while (program == false) {
			//print out menu and get input from user
			printMenu();
			//get user input while scanning for input mismatch
			try {
				choice = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(e);
				main(null);
			}
			
			switch (choice) {
			
			case 1:
				//generate array and print out unsorted + sorted arrays
				bl.generateArray();
				break;
				
			case 2:
				System.out.println("What number would you like to search:");
				int target = input.nextInt();
				
				long nanoTime = System.nanoTime();
				long miliTime = System.currentTimeMillis();
				System.out.println("(Recursive Binary Search): Number "+ target + 
						" was found at index -> " + bl.recursiveBinarySearch(target, 0, 30) +
							"\n Calculating time in nanoseconds :" + (System.nanoTime() - nanoTime) +
							"\n Calculating time in miliseconds :" + (System.currentTimeMillis() - miliTime) + "\n");
				
				nanoTime = System.nanoTime();
				miliTime = System.currentTimeMillis();
				System.out.println("(Recursive Linear Search): Number "+ target + 
						" was found at index -> " + bl.recursiveLinearSearch(target, 0) +
						"\n Calculating time in nanoseconds :" + (System.nanoTime() - nanoTime) +
						"\n Calculating time in miliseconds :" + (System.currentTimeMillis() - miliTime) + "\n");	
				
				break;
				
			case 3:
				System.out.println("What number would you like to search:");
				int target1 = input.nextInt();
				
				long nanoTime1 = System.nanoTime();
				long miliTime1 = System.currentTimeMillis();
				System.out.println("(Iterative Binary Search): Number "+ target1 + 
						" was found at index -> " + bl.iterativeBinarySearch(target1) +
						"\n Calculating time in nanoseconds :" + (System.nanoTime() - nanoTime1) +
						"\n Calculating time in miliseconds :" + (System.currentTimeMillis() - miliTime1) + "\n");
				
				nanoTime1 = System.nanoTime();
				miliTime1 = System.currentTimeMillis();
				System.out.println("(Iterative Linear Search): Number "+ target1 + 
						" was found at index -> " + bl.iterativeLinearSearch(target1) +
								"\n Calculating time in nanoseconds :" + (System.nanoTime() - nanoTime1) +
								"\n Calculating time in miliseconds :" + (System.currentTimeMillis() - miliTime1) + "\n");
				break;
				
			case 4:
				//exit the program
				System.out.println("Quitting...");
				program = true;
				input.close();
				break;
			
			default:
				//if user enters wrong integer
				System.out.println("Wrong input!\n");
				break;
			
			}
		
		}
	
	}
		
	//user instructions
	/**
	 * simple print menu method
	 */
	public static void printMenu() {
		System.out.println("--- Please select one of the options below! ---"
				+ "\n1. Initialize and populate an array of 30 integers"
				+ "\n2. Perfrom a recursive binary and linear search"
				+ "\n3. Perfrom a iterative binary and linear search"
				+ "\n4. Quit the program");
	}
}
