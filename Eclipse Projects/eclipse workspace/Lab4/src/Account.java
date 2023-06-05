/*
 * Adam Di Cioccio
 * 41019241 - Lab 04 Banking System
 * Bank system that allows the user to input an account (saving or checking) 
 * with specific balance and use abstract method to perform specific 
 * calculations on either of them
 * Anu Thomas - 2/9/2021
 */

//imports
import java.util.Scanner;

public abstract class Account extends Person {
	//declare variables
	private long accNumber;
	Person accHolder;
	protected double balance;
	
	//non-parameterized constructor
	Account() {
		
	}
	
	//read account details method that takes scanner
    public void readAccountDetails(Scanner input){
        System.out.print("Enter Account Number: ");
        accNumber = input.nextLong();
        readPersonDetails(input);
        System.out.print("Enter balance: ");
        balance = input.nextDouble(); 
    }
    
    //abstract method update balance
    abstract void updateBalance();
    
    //display all details of the inputed account
    public void displayAccount(){
    	System.out.printf("%-10d | %-15s | %-15s | %-15d | %-10.2f |\n", accNumber, getFullName(), getEmailId(), getPhoneNumber(), balance);
    }


}
