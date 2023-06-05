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

public class BankTest {

	public static void main(String[] args) {
		//create scanner
		Scanner input = new Scanner (System.in);

		//prompt user
		System.out.println("Enter the name of your bank: ");
		//set into variable
		String bankName = input.next();

		//prompt user
		System.out.println("How many account holders would you like to enter: ");
		//set into variable
		int numOfAccounts = input.nextInt();
		
		//create new object with inputed value
		Bank bank = new Bank (bankName, numOfAccounts);
		
		//call read Account method
		bank.readAccounts(input);
		
		//run the monthly process on all accounts
		bank.runMonthlyProcess();
		
		//print top stars
        Bank.printStar();
        //print out the name of bank
        System.out.println("                                   " + bankName 
        		+ " BANK                                 ");
        //print the detail headers
        Bank.printTitle();
       
        //print account details
        bank.displayAccounts();		

	}

}
