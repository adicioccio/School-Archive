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

public class Bank {
    //variable name and array account
    String name;
    Account account[];
   
    //non-arg constructor
    Bank () {
    	
    }
    
    //parameterized constructor
    Bank (String name, int size) {
        this.name = name;
        this.account = new Account[size];
    }
   
    //read accounts method
    public void readAccounts(Scanner input) {
        //for loop that loops based on the account array length
    	for(int i = 0; i < account.length; i++) {
            
    		//prompt user for type of account
            System.out.println("1. Checking \n2. Savings \nEnter the type of account you want to create: ");
            //store into variable
            int type = input.nextInt();
            
            //check to see what user entered (1 for checking and 2 for savings)
            if(type == 1) {
                //create new Checking object
            	account[i] = new Checking();
            } else if (type == 2) {
            	//create new Saving object
            	account[i] = new Saving();
            } else {
            	//prompt user for type of account
                System.out.println("Incorrect input! \n1. Checking \n2. Savings \nEnter the type of account you want to create: ");
                //store into variable
                type = input.nextInt();
            }
            //call read account details in account class
            account[i].readAccountDetails(input);
        }
    }
   
    //run monthly process method
    public void runMonthlyProcess(){
    	//for loop that loops based on the account array length
    	for(int i = 0; i < account.length; i++) {
           //call update balance abstract method
    		account[i].updateBalance();
        }
    }
    
    //display accounts method
    public void displayAccounts(){
    	//for loop that loops based on the account array length
    	for(int i = 0; i < account.length; i++) {
            //call display account method
    		account[i].displayAccount();
        }
    }
    
    //print line of stars method
    public static void printStar(){
        //print stars
    	System.out.println("********************************************************************************");
    }
    
    //print the header with stars on top and bottom
    public static void printTitle(){
        //print stars
    	printStar();
		//print out header
		System.out.printf("%-10s | %-15s | %-15s | %-15s | %-10s |\n", "Acc #", "Acc Name", "Acc Email", "Acc Phone#", "Balance");
		//print stars
		printStar();
    }
}