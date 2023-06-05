/*
 * Adam Di Cioccio
 * 41019241 - Lab 05 Employee Interface
 * In-class lab that creates an automated employee payroll system that uses an interface.
 * Anu Thomas - 2/25/2021
 */

//imports
import java.util.Scanner;

public class PayrollTest {

	//main method
	public static void main(String[] args) {
		
		//create scanner
		Scanner input = new Scanner(System.in);
		
		//ask user for input
		System.out.println("How many employees are there? ");
		
		//set input into variable
		int numOfEmployees = input.nextInt();
			
		//create new payroll with number of employee parameter
		Payroll p = new Payroll(numOfEmployees);
			
		//call add employee method from payroll.java
		p.addEmployees(input);
			
		//close scanner
		input.close();
		
		
		

	}

}
