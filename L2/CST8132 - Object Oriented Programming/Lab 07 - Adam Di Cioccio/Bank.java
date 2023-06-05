/*
Adam Di Cioccio
41019241 - Lab 07 
Bank simulator w exceptions 
Rejaul Chowdhury - 3/21/2021
*/

//imports
import java.util.ArrayList;
import java.util.InputMismatchException;
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
		System.out.println("Enter details of Account Holder " + (accounts.size() + 1) + "\n*********************************");
		
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
		int userInput = 0;

		try {
		// prompt user
		System.out.println("Please enter an account number display contents: ");
		// set input into variable
		userInput = input.nextInt();
			
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
			throw new NotExistAccount();
		}
		} catch (NotExistAccount ne) {
			System.out.println(ne);
		}  catch (InputMismatchException e) {
			System.err.println("Invalid input! Please enter an integer. \n" + e);
			input.next();
		}
	}

	// prints all accounts
	public void printAccountDetails() {
		// loops through all accounts and prints their data
		for (int i = 0; i < accounts.size(); i++) {
			System.out.println(accounts.get(i).toString());
		}
	}

	// updates an account
	public void updateAccount(Scanner input) {

		// prompt user and gather input
		System.out.println("Please enter an account number to update the balance: ");
		int accountNumber = input.nextInt();
		// prompt user and gather input
		System.out.println("Enter the amount to deposit/withdraw (positive to deposit, negative to withdraw) : ");
		int balanceChange = input.nextInt();

		boolean found = false;
		
		for (int i = 0; i < accounts.size(); i++) {
			if (accountNumber == accounts.get(i).getAccountNumber()) {
				this.accounts.get(i).updateBalance(balanceChange);
				found = true;
			}
		}

		if (found == false) {
			System.out.println("Account number not found.");
		}
	}

	//find specific account
	public void findAccount(int accountNumber) {
		
		boolean found = false;
		for (int i = 0; i < accounts.size(); i++) {
			if (accountNumber == accounts.get(i).getAccountNumber()) {
				System.out.println(i);
			}
		}
		if (found == false) {
			System.out.println("Account number not found.");
		}
	}

	// perform monthly update
	public void monthlyUpdate() {
		for (int i = 0; i < accounts.size(); i++) {
			accounts.get(i).monthlyAccountUpdate(0);
		}
	}
}
