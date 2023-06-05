/*
Adam Di Cioccio
41019241 - Lab 07 
Bank simulator w exceptions 
Rejaul Chowdhury - 3/21/2021
*/

//imports
import java.util.Scanner;

public class Lab7 {

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
			// run montly update
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
			// invalid input
			default:
				programRunning = null;
				System.out.println("Invalid input! Please enter a valid input.");
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
		System.out.println("q) Quit program.");
	}
}
