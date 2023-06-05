/*
Adam Di Cioccio
41019241 - Lab 08 
Bank simulator w File IO
Rejaul Chowdhury - 3/28/2021
*/

//imports
import java.util.Scanner;

public class Lab8 {

	public static void main(String args[]) {

		// create scanner
		Scanner input = new Scanner(System.in);

		// create new bank instance
		Bank bank = new Bank();

		// print title
		System.out.println("-=-=-=-=- Welcome to the Banking Program -=-=-=-=-");

		// declare variable for while loop
		String programRunning = null;

		// loops until 'q' is selected. Prints the information below
		while (programRunning == null) {

			// print options
			printOptions();
			// collect input
			programRunning = input.next();
			// set to lowercase
			programRunning.toLowerCase();
			
			try {
			
			// check users input
			switch (programRunning) {

			// add new account
			case "a":
				programRunning = null;
				bank.addAccount(input);
				break;
			// update an account
			case "u":
				programRunning = null;
				bank.updateAccount(input);
				break;
			// display account
			case "d":
				programRunning = null;
				bank.displayAccount(input);
				break;
			// print all accounts
			case "p":
				programRunning = null;
				bank.printAccountDetails();
				break;
			// run monthly update
			case "m":
				programRunning = null;
				bank.monthlyUpdate();
				System.out.println("Performed monthly update.");
				break;
			// quit the program
			case "q":
				System.out.println("Quiting...");
				input.close();
				break;
			case "r":
				System.out.println("Completed.");
				programRunning = null;
				//perform operations in bank class
				bank.openInputFile();
				bank.readInputFile();
				bank.closeInputFile();
				break;
				
			// invalid input
			default : 
				throw new WrongMenuException();	
			} 
			} catch (WrongMenuException e) {
				System.out.println(e);
			} finally {
				programRunning = null;
			}
		}
	}

	// print options method
	private static void printOptions() {
		System.out.println("a) Add new account.");
		System.out.println("u) Update an account.");
		System.out.println("d) Display an account.");
		System.out.println("p) Print all accounts.");
		System.out.println("m) Run monthly update.");
		System.out.println("r) Read from text file.");
		System.out.println("q) Quit program.");
	}
}
