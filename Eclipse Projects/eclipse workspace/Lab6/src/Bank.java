//Adam Di Cioccio
//Prof: Daniel Cormier
//Lab 6 - Bank System
//March 14, 2021

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
	
	//create arrayList
	public ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	
	//declare boolean for while loop
	boolean validInput = false;
	
	public void addAccount(Scanner scan) {
		
		//reset boolean
		validInput = false;
		
		//prompt user
		System.out.println("Enter details of Account Holder " + (accounts.size() + 1) + "\n=================================");
		
		//while loop 
		while (!validInput) {
			//ask user which account they would like to input
			System.out.println("Please select the type of account you would like to add.\nType 'c' for chequings or 's' for savings.");
			//set input into variable
			String choice = scan.next();
			//set to lower case
			choice.toLowerCase();
			
			//chequings account
			if (choice.equals("c")) {
				
				ChequingsAccount chequings = new ChequingsAccount();
				chequings.addBankAccount(scan);
				//add into accounts array list
				accounts.add(new ChequingsAccount());

				//exit loop
				validInput = true;
				
			//savings account	
			} else if (choice.equals("s")) {
				
				SavingsAccount savings = new SavingsAccount();
				savings.addBankAccount(scan);
				//add into accounts array list
				accounts.add(new SavingsAccount());
				//exit loop
				validInput = true;
				
			} else {
				//invalid input. restart loop
				System.out.println("Invalid input!");
			}
		}	
	}
	
	public void updateAccount() {
		
		System.out.println("Array size:" + accounts.size());

	}
	
	
	public void displayAccount(Scanner scan) {
		
		//System.out.println(accounts.get(i).toString(i));
	}
	
	public void printAllAccounts() {

		for (int i = 1; i <= accounts.size(); i++) {

			System.out.println(accounts.get(i).toString(i));
			
		}
		
	}
	
	//public void monthlyUpdate() {
		
	//}	
	
}
