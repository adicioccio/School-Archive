/*
 * Adam Di Cioccio
 * 41019241 - Lab 04 Banking System
 * Bank system that allows the user to input an account (saving or checking) 
 * with specific balance and use abstract method to perform specific 
 * calculations on either of them
 * Anu Thomas - 2/9/2021
 */

public class Checking extends Account {

	//declare variable
	double fees;

	//non-parameterized constructor
	Checking() {
		fees = 13.50;
	}

	//override parent method updateBalance
	@Override
	//sub method update balance for saving
	public void updateBalance() {
		//take away fees from balance
		balance = balance - fees;
	}

}