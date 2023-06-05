//Adam Di Cioccio
//Prof: Daniel Cormier
//Lab 6 - Bank System
//March 14, 2021

import java.util.Scanner;

public abstract class BankAccount extends Bank implements BankSimulator {

	//declare variables
	protected int accountNumber;
	protected Person accountHolder;
	protected double balance;
	protected double fee;
	protected double minimumBalance;
	protected double interestRate;
	
	//non parameterized constructor
	BankAccount () {}
	
	//parameterized constructor
	BankAccount (int accountNumber, Person accountHolder, double balance) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = balance;
	}
	
	//toString that returns console output
	public String toString(int i) {
		
		//chequings account
		if (accounts.get(i).fee > 0) {
			return "Account Number: " + accounts.get(i).accountNumber + " | Account Name: " + accounts.get(i).accountHolder.getName() 
					+ " | Account PhoneNumber: " + accounts.get(i).accountHolder.getPhoneNum() 
					+ " | Account Email: " + accounts.get(i).accountHolder.getEmail()
					+ " | Account Balance: " + accounts.get(i).balance; 
		
		//savings account
		} else if (accounts.get(i).interestRate > 0) {
			return "Account Number: " + accounts.get(i).accountNumber + " | Account Name: " + accounts.get(i).accountHolder.getName() 
					+ " | Account PhoneNumber: " + accounts.get(i).accountHolder.getPhoneNum() 
					+ " | Account Email: " + accounts.get(i).accountHolder.getEmail()
					+ " | Account Balance: " + accounts.get(i).balance;
		}
		
		return null;
		
	}


	@Override
	public void addBankAccount(Scanner scan) {
		//get input from user and store in variable
		System.out.println("Enter account number:");
		accountNumber = scan.nextInt();
		
		//get input from user and store in variable
		System.out.println("Enter fname:");
		String fname = scan.next();
		//get input from user and store in variable
		System.out.println("Enter lname:");
		String lname = scan.next();
		//get input from user and store in variable
		System.out.println("Enter phoneNum:");
		long phoneNum = scan.nextLong();
		//get input from user and store in variable
		System.out.println("Enter email:");
		String email = scan.next();
		
		//create new person and store into account holder
		accountHolder = new Person(fname, lname, phoneNum, email);
		
		//get input from user and store in variable
		System.out.println("Enter balance:");
		balance = scan.nextDouble();
	}

	@Override
	public void updateBalance() {
		// TODO Auto-generated method stub
		
	}

}
