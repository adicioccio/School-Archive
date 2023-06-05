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

public class Person {

	//declare variables
	private String firstName;
	private String lastName;
	private String emailId;
	private long phoneNumber;
	
	//non-arg constructor
	public Person() {
		
	}
	
	//parameterized constructor
	public Person(String firstName, String lastName, String emailId, long phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
	}
	
	//fullName getter
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	//emailId getter
	public String getEmailId() {
		return emailId;
	}

	//phoneNumber getter
	public long getPhoneNumber() {
		return phoneNumber;
	}
	
	public void readPersonDetails(Scanner input) {	
		
		//prompt user
		System.out.print("Enter first name: ");
		//store value into variable
		firstName = input.next();
		
		//prompt user
		System.out.print("Enter last name: ");
		//store value into variable
		lastName = input.next();
		
		//prompt user
		System.out.print("Enter email: ");
		//store value into variable
		emailId = input.next();

		//prompt user
		System.out.print("Enter phone number: ");
		//store value into variable
		phoneNumber = input.nextLong();

	}

}
