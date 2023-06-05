/*
Adam Di Cioccio
41019241 - Lab 08 
Bank simulator w File IO
Rejaul Chowdhury - 3/28/2021
*/

public class Person {

	// declare variables
	private String fName;
	private String lName;
	private String phoneNumber;
	private String emailAddress;

	// non parameterized constructor
	public Person() {
	}

	// parameterized constructor
	public Person(String fName, String lName, String phoneNumber, String emailAddress) {
		this.fName = fName;
		this.lName = lName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}

	// getter for full name
	public String getName() {
		return this.fName + " " + this.lName;
	}

	// getter for phone number
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	// getter for email address
	public String getEmailAddress() {
		return this.emailAddress;
	}
}
