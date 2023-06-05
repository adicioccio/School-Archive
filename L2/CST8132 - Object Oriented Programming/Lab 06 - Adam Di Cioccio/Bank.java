/*
Adam Di Cioccio
41019241 - Lab 07 
Bank simulator w exceptions 
Rejaul Chowdhury - 3/21/2021
*/

//imports
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

	// create new array list called accounts
	ArrayList<BankAccount> accounts = new ArrayList<>();

	// non parameterized constructor
	public Bank() {
	}

	// creates an account
	public void addAccount(Scanner input) {
		// prompt user
		System.out.println("Please select the type of account you would like to add.\n"
				+ "Type 'c' for chequings account or 's' for savings account: ");
		// get input from user
		String accType = input.next();

		// new chequings account
		if (accType.equals("c")) {
			ChequingsAccount c = new ChequingsAccount();
			c.addBankAccount(input);
			accounts.add(c);
			// new savings account
		} else if (accType.equals("s")) {
			SavingsAccount s = new SavingsAccount();
			s.addBankAccount(input);
			accounts.add(s);
			// invalid input
		} else {
			System.out.println("Invalid input!");
		}
	}

	// displays account
	public void displayAccount(Scanner input) {
		// prompt user
		System.out.println("Please enter an account number to update the balance of: ");
		// set input into variable
		int userInput = input.nextInt();

		//boolean to check if any accounts are found
		boolean found = false;

		//loop all accounts
		for (int i = 0; i < accounts.size(); i++) {
			if (userInput == accounts.get(i).getAccountNumber()) {
				System.out.println(accounts.get(i).toString());
				found = true;
			}
		}

		// if nothing found print not found
		if (found == false) {
			System.out.println("Account number not found");
		}
	}

	// prints all accounts
	public void printAccountDetails() {
		// loops through all accounts and prints their data
		for (int i = 0; i < this.accounts.size(); i++) {
			System.out.println(this.accounts.get(i).toString());
		}
	}

	// updates an account
	public void updateAccount(Scanner input) {

		// prompt user and gather input
		System.out.println("Please enter an account number to update the balance of : ");
		int accountNumber = input.nextInt();
		System.out.println("Enter the amount to deposit/withdraw (positive number to deposit, negative to withdraw) : ");
		int balanceChange = input.nextInt();

		boolean found = false;
		
		for (int i = 0; i < this.accounts.size(); i++) {
			if (accountNumber == this.accounts.get(i).getAccountNumber()) {
				this.accounts.get(i).updateBalance(balanceChange);
				found = true;
			}
		}

		if (found == false) {
			System.out.println("Account number not found");
		}
	}

	public void findAccount(int accountNumber) {
		// applies the same logic as the methods above
		boolean found = false;
		for (int i = 0; i < this.accounts.size(); i++) {
			if (accountNumber == this.accounts.get(i).getAccountNumber()) {
				System.out.println(i);
			}
		}
		if (found == false) {
			System.out.println("Account number not found");
		}
	}

	// perform monthly update
	public void monthlyUpdate() {
		for (int i = 0; i < this.accounts.size(); i++) {
			accounts.get(i).monthlyAccountUpdate(0);
		}
	}
}
