//Adam Di Cioccio
//Prof: Daniel Cormier
//Lab 6 - Bank System
//March 14, 2021

import java.util.Scanner;

public class Lab6 {
	
	public static void main(String[] args) {
		
		//create scanner
		Scanner scan = new Scanner(System.in);
		
		//boolean for program to run
		boolean programIsRunning = true;

		//create new bank object
		Bank b = new Bank();
		
		//while loop
		while (programIsRunning) {
			
			//display header
			System.out.println("-=-=-=-=- Welcome to the Bank Simulation! -=-=-=-=-");
			//display menu
			displayMenu();
			
			//set input into variable
			String input = scan.next();
			//set the input to lower case
			input.toLowerCase();
			
			//check to see what user inputted
			if (input.equals("a")) {
				//add new account
				b.addAccount(scan);
			
			} else if (input.equals("u")) {
				//update a select account
				b.updateAccount();
				
			} else if (input.equals("d")) {
				//display a specific account
				b.displayAccount(scan);
			
			} else if (input.equals("p")) {
				//display all accounts
				b.printAllAccounts();
			
			} else if (input.equals("m")) {
				//perform montly update
				//b.monthlyUpdate();
			
			} else if (input.equals("q")) {
				//quit program
				System.out.println("Quiting...");
				programIsRunning = false;
			
			} else {
				//tell user input was invalid and restart program/loop
				System.out.println(input + " is an invalid input. Please try again.");
			}
		}

		//close scanner
		scan.close();
	}

	//display the menu method
	public static void displayMenu() {
		System.out.println("a) Add new account\n"
				+ "u) Update an account\n" + "d) Display an account\n" + "p) Print all accounts\n"
				+ "m) Run monthly update\n" + "q) Quit program\n" + "Enter your option here: ");
	}
}
