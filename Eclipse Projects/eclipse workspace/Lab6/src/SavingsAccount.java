//Adam Di Cioccio
//Prof: Daniel Cormier
//Lab 6 - Bank System
//March 14, 2021

import java.util.Scanner;


public class SavingsAccount extends BankAccount {

	//parameterized constructor
	SavingsAccount(int accountNumber, Person accountHolder, double balance, double minimumBalance, double interestRate) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = balance;
		this.minimumBalance = minimumBalance;
		this.interestRate = interestRate;
	}	
	
	//non parameterized constructor
	SavingsAccount() {}

	public void addBankAccount(Scanner scan) {
		
		//call super class method first
		super.addBankAccount(scan);
		
		//extra inputs solely for chequings
		System.out.println("Enter minimum balance:");
		minimumBalance = scan.nextDouble();
		System.out.println("Enter interest rate:");
		interestRate = scan.nextDouble();
		
	}
	
	public void updateBalance() {
		// TODO Auto-generated method stub
		
	}

}
