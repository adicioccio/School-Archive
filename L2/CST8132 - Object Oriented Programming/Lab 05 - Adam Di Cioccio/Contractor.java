/*
 * Adam Di Cioccio
 * 41019241 - Lab 05 Employee Interface
 * In-class lab that creates an automated employee payroll system that uses an interface.
 * Anu Thomas - 2/25/2021
 */

//imports
import java.util.Scanner;

public class Contractor implements EmployeeInterface {

	//declare variables
	String name;
	double hourlyRate;
	double hoursPerWeek;
	static double tax = 0.15;
	
	double cheque;
	double taxRemit;
	
	//read details method
	@Override
	public void readDetails(Scanner input) {
		
		//prompt user
		System.out.println("Enter name: ");
		//set value
		name = input.next();
		
		//prompt user
		System.out.println("Enter hourly rate: ");
		//set value
		hourlyRate = input.nextDouble();
		
		//prompt user
		System.out.println("Enter hours worked this week: ");
		//set value
		hoursPerWeek = input.nextDouble();
	}

	//print details method
	@Override
	public void printDetails() {
		//print out details
		System.out.println(nameOfCompany + " mailed a cheque to " + name + " for $" + cheque + ". Tax amount to remit: " + taxRemit);
		
	}

	//process payroll method
	@Override
	public void processPayroll() {
		//perform calculations
		cheque = hourlyRate * hoursPerWeek;
		taxRemit = cheque * tax;
		
	}

}
