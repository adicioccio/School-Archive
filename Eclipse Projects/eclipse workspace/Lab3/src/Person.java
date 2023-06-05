/*
 * Adam Di Cioccio
 * 41019241 - Lab 03 Store Management System
 * Store management system that allows the user to store names 
 * and information about specific employees, regulars and contractors
 * Anu Thomas - 2/1/2021
 */

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
	
	//firstName setter
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	//lastName setter
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	//emailId setter
	public void setEmail(String emailId) {
		this.emailId = emailId;
	}
	
	//phoneNumber setter
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}