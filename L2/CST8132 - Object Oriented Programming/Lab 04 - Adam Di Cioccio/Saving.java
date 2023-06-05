/*
 * Adam Di Cioccio
 * 41019241 - Lab 04 Banking System
 * Bank system that allows the user to input an account (saving or checking) 
 * with specific balance and use abstract method to perform specific 
 * calculations on either of them
 * Anu Thomas - 2/9/2021
 */

public class Saving extends Account {

	//declare variable
	double interestRate;

	//non-parameterized constructor
	Saving() {
		interestRate = 3.99;
	}

	//override parent method updateBalance
	@Override
	//sub method update balance for saving
	public void updateBalance() {
		//add interest rate calculation
		balance = balance + ((balance * interestRate) / 100);
	}
}