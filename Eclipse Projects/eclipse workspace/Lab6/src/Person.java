//Adam Di Cioccio
//Prof: Daniel Cormier
//Lab 6 - Bank System
//March 14, 2021

public class Person {

	//declare variables
	private String fname;
	private String lname;
	private long phoneNum;
	private String email;
	
	//non parameterized constructor
	Person () {}
	
	//parameterized constructor
    Person (String fname, String lname, long phoneNum, String email) {
		this.fname = fname;
		this.lname = lname;
		this.phoneNum = phoneNum;
		this.email = email;
	}
	
	//full name getter
	public String getName() {
		return fname + " " + lname;
		
	}
	
	//phone number getter
	public long getPhoneNum() {
		return phoneNum;
		
	}

	//email getter
	public String getEmail() {
		return email;
		
	}
	
}
