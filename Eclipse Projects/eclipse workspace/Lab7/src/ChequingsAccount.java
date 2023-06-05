/*
Adam Di Cioccio
41019241 - Lab 07 
Bank simulator w exceptions 
Rejaul Chowdhury - 3/21/2021
*/

import java.util.Scanner;

public class ChequingsAccount extends BankAccount {

	//declare variables
	private double fee;
	
	@Override
	public String toString() {
		//returns the console output
		return "AccountNumber: " + this.getAccountNumber() + " | Name: " +
				this.getaccHolder().getName()
				+ " | email: " + this.getaccHolder().getEmailAddress() + " | " + 
				this.getbalance() + " | Fee: " + this.fee;
	}
	
	public void addBankAccount(Scanner input) {
		//call super class method add bank account
		super.addBankAccount(input);
		
		//prompt user for fee
		System.out.println("Enter the Chequing Account's monthly fee: ");
		fee = input.nextDouble();

	}
	
	public void monthlyAccountUpdate(double d) {
		//interest rate is yearly, while this method is monthly. We need to divide by 12 to correct for this
		super.monthlyAccountUpdate(-1 * fee/12);
	}
	
}
