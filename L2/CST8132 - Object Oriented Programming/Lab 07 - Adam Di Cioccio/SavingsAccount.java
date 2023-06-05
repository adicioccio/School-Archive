/*
Adam Di Cioccio
41019241 - Lab 07 
Bank simulator w exceptions 
Rejaul Chowdhury - 3/21/2021
*/

import java.util.Scanner;

public class SavingsAccount extends BankAccount {
	
	//declare variables
	private double interestRate;
	private double minimumBalance;
	
	@Override
	public String toString() {
		//returns the console output
		return "AccountNumber: " + this.getAccountNumber() + " | Name: " +
				this.getaccHolder().getName()
				+ " | email: " + this.getaccHolder().getEmailAddress() + " | " + 
				this.getbalance() + " | MinimumBalance: " + this.minimumBalance +
				" | Interest rate: " + this.interestRate;
	}
	
	public void addBankAccount(Scanner input) {
		//call super class method add bank account
		super.addBankAccount(input);
		
		//prompt user for minimum balance
		System.out.println("Enter the Saving Account's minimum balance: ");
		minimumBalance = input.nextDouble();
		
		//prompt user for interest rate
		System.out.println("Enter the Saving Account's yearly interest rate (between 0.0 - 1.0): ");
		interestRate = input.nextDouble();

	}
	
	@Override
	public void monthlyAccountUpdate(double none) {
		//apply interest rate for each month (interest rate is yearly)
		super.monthlyAccountUpdate(interestRate/12);
	}

}
