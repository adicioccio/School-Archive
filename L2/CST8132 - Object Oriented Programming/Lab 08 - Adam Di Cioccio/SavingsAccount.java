/*
Adam Di Cioccio
41019241 - Lab 08 
Bank simulator w File IO
Rejaul Chowdhury - 3/28/2021
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
	
	//return savings account for save
		public String saveString() {
	        return "S " + this.getAccountNumber() + " " + this.getaccHolder().getName() + " " + this.getaccHolder().getPhoneNumber() + " " +
	                this.getaccHolder().getEmailAddress() + " " + this.getbalance() + " " + this.minimumBalance + " " + this.interestRate;
	    }
		
		//pass information subclass
		public void passInformation(String accNum, String fName, String lName, String phoneNum, String email, String bal, String minBal, String interest) {
	        //set min balance and interest rate
			minimumBalance = Double.parseDouble(minBal);
			interestRate = Double.parseDouble(interest);
	        //call super class in BankAccount.java
			super.passInformation(accNum, fName, lName, phoneNum, email, bal);
	    }

}
