/*
 * Adam Di Cioccio
 * 41019241 - Lab 05 Employee Interface
 * In-class lab that creates an automated employee payroll system that uses an interface.
 * Anu Thomas - 2/25/2021
 */

//imports
import java.util.Scanner;

public class Regular implements EmployeeInterface {

	//declare variables
	String name;
	double annualSalary;
	static double deduction = 0.17;
	
	double deposit;
	
	//read details method
	@Override
	public void readDetails(Scanner input) {
		
		//prompt user
		System.out.println("Enter name: ");
		//set value
		name = input.next();
		
		//prompt user
		System.out.println("Enter annual salary: ");
		//set value
		annualSalary = input.nextDouble();
	}

	//print details method
	@Override
	public void printDetails() {
		//print out details
		System.out.println(nameOfCompany + " deposited $" + deposit + " to " + name + "'s account." );
		
	}

	//process payroll method
	@Override
	public void processPayroll() {
		//calculate deposit amount
		deposit = (annualSalary/12) - ((annualSalary/12) * deduction);
		
	}



}
