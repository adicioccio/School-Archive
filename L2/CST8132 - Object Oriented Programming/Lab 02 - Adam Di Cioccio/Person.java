/*
 * Adam Di Cioccio
 * Anu Thomas - Lab 2
 * 1/26/2021
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

}
