/*
 * Adam Di Cioccio
 * 41019241 - Lab 03 Store Management System
 * Store management system that allows the user to store names 
 * and information about specific employees, regulars and contractors
 * Anu Thomas - 2/1/2021
 */

//imports
import java.util.Scanner;

public class Lab3 {

	public static void main(String[] args) {
		
		//create scanner
		Scanner input = new Scanner(System.in);
		//declare variables
		String storeName;
		int employeeNum;
		
		//prompt user
		System.out.println("Enter name of the store:");
		//store into variable
		storeName = input.next();
		
		//prompt user
		System.out.println("How many employees would you like to enter? ");
		//store into variable
		employeeNum = input.nextInt();
		
		//create new object
		Store store = new Store(employeeNum);
		//call read employee details method from store class
		store.readEmployeeDetails();
		  
		//call print title method in store
		Store.printTitle(storeName);
		//call print header method in store
		Store.printHeader();
		//print details from print employee details class
		store.printEmployeeDetails();
		
		//close scanner
		input.close();
		

	}

}
