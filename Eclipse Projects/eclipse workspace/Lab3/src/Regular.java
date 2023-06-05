/*
 * Adam Di Cioccio
 * 41019241 - Lab 03 Store Management System
 * Store management system that allows the user to store names 
 * and information about specific employees, regulars and contractors
 * Anu Thomas - 2/1/2021
 */

//imports
import java.util.Scanner;

public class Regular extends Employee {
	//declare variables
	private double salary;

	//non-arg constructor
	public Regular() {

	}

	//parameterized constructor
	public Regular(String firstName, String lastName, String email, long phoneNumber, int employeeNumber, double salary) {
		super(firstName, lastName, email, phoneNumber, employeeNumber);
		this.salary = salary;
	}

	//read employee method subclass
	public void readEmployee() {
		//create scanner
		Scanner input = new Scanner(System.in);
		//call method from super
		super.readEmployee();
		//prompt user
		System.out.print("Enter annual salary: $");
		//set value into variable
		double annualSalary = input.nextDouble();
		//perform calculations to get monthly wage
		this.salary = (annualSalary / 12);
		
	}

	//print employee method subclass
	public void printEmployee() {
		//call method from super
		super.printEmployee();
		//add salary
		System.out.printf("%-1.2f |\n", salary);
	}
}