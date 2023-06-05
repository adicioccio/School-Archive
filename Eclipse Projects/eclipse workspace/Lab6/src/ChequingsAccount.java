//Adam Di Cioccio
//Prof: Daniel Cormier
//Lab 6 - Bank System
//March 14, 2021

import java.util.Scanner;

public class ChequingsAccount extends BankAccount {
	
	//parameterized constructor
	ChequingsAccount(int accountNumber, Person accountHolder, double balance, double fee) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = balance;
		this.fee = fee;
	}

	//non parameterized constructor
	ChequingsAccount() {}

	public void addBankAccount(Scanner scan) {
		//call super class method first
		super.addBankAccount(scan);
		
		//extra inputs solely for chequings
		System.out.println("Enter fee:");
		fee = scan.nextDouble();
		
	}
	
	public void updateBalance() {
		// TODO Auto-generated method stub
		
	}

}
