/*
 * Adam Di Cioccio
 * 41019241 - Lab 03 Store Management System
 * Store management system that allows the user to store names 
 * and information about specific employees, regulars and contractors
 * Anu Thomas - 2/1/2021
 */

//imports
import java.util.Scanner;

public class Employee extends Person {
	//declare variables
	private int employeeNumber;

	//non-arg
	public Employee() {

	}

	//parameterized
	public Employee(String firstName, String lastName, String email, long phoneNumber, int employeeNumber) {
		super(firstName, lastName, email, phoneNumber);
		this.employeeNumber = employeeNumber;
	}

	//read employee method superclass
	public void readEmployee() {
		//create scanner
		Scanner input = new Scanner(System.in);
		
		//prompt user and store value into variable
		System.out.print("Enter employee number: ");
		employeeNumber = input.nextInt();
		
		//prompt user and store value into variable
		System.out.print("Enter first name: ");
		String fName = input.next();
		//call setter
		setFirstName(fName);
		
		//prompt user and store value into variable
		System.out.print("Enter last name: ");
		String lName = input.next();
		//call setter
		setLastName(lName);
		
		//prompt user and store value into variable
		System.out.print("Enter email: ");
		String email = input.next();
		//call setter
		setEmail(email);
		
		//prompt user and store value into variable
		System.out.print("Enter phone number: ");
		long phoneNumber = input.nextLong();
		//call setter
		setPhoneNumber(phoneNumber);
		
	}

	//print employee method superclass
	public void printEmployee() {
		//print out employee information
		System.out.printf("%-10s | %-30s | %-15s | %-10d | ", employeeNumber, getFullName(), getEmailId(), getPhoneNumber());
	}
}
