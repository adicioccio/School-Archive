/*
 * Adam Di Cioccio
 * 41019241 - Lab 05 Employee Interface
 * In-class lab that creates an automated employee payroll system that uses an interface.
 * Anu Thomas - 2/25/2021
 */

//imports
import java.util.Scanner;

//Employee interface
interface EmployeeInterface {
	
	//name of company stored in string
	String nameOfCompany = "AdamTech";
	
	//abstract methods
	public abstract void readDetails(Scanner input);
	public abstract void printDetails();
	public abstract void processPayroll();
	
	
}