/*
 * Adam Di Cioccio
 * 41019241 - Lab 03 Store Management System
 * Store management system that allows the user to store names 
 * and information about specific employees, regulars and contractors
 * Anu Thomas - 2/1/2021
 */

//imports
import java.util.Scanner;

public class Contractor extends Employee {
	//declare variables
	private double rate;
	private double hours;

	//non-arg constructor
	public Contractor() {

	}

	//parameterized constructor
	public Contractor(String firstName, String lastName, String email, long phoneNumber, int employeeNumber, double rate, double hours) {
		super(firstName, lastName, email, phoneNumber, employeeNumber);
		this.rate = rate;
		this.hours = hours;
	}

	//read employee method subclass
	public void readEmployee() {
		//create scanner
		Scanner input = new Scanner(System.in);
		//call method from super
		super.readEmployee();
		//prompt user
		System.out.println("Enter hourly rate: ");
		//set value into variable
		rate = input.nextDouble();
		//prompt user
		System.out.println("Enter number of hours worked: ");
		//set value into variable
		hours = input.nextDouble();
		
	}

	//print employee method subclass
	public void printEmployee() {
		//call method from super
		super.printEmployee();
		//add salary
		System.out.printf("%-1.2f |\n", (rate * hours));
	}
}