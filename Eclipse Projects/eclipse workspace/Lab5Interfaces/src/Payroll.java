/*
 * Adam Di Cioccio
 * 41019241 - Lab 05 Employee Interface
 * In-class lab that creates an automated employee payroll system that uses an interface.
 * Anu Thomas - 2/25/2021
 */

//imports
import java.util.Scanner;

public class Payroll {

	private int [] employees;
	
	//non-parameterized constructor
	public Payroll() {
		
	}	
	
	//parameterized constructor
	public Payroll(int x) {
		this.employees = new int[x];
	}
	
	public void addEmployees(Scanner input) {
		//for loop that repeats based on array length
		for (int i = 0; i < employees.length; i++) {
			
			//prompt user
			System.out.println("1. Regular\n2. Contractor\nSelect an option: ");
			//set value into declared variable
			int type = input.nextInt();
			
			//invalid input
			while (type != 1 && type != 2) {
				//prompt user
				System.out.println("Invalid option...\n1. Regular\n2. Contractor\nSelect an option: ");
				//set value into variable
				type = input.nextInt();
			}
			
			//regular
			if (type == 1) {
				Regular r = new Regular();
				r.readDetails(input);
				r.processPayroll();
				r.printDetails();
				
			//contractor
			} else if (type == 2) {
				Contractor c = new Contractor();
				c.readDetails(input);
				c.processPayroll();
				c.printDetails();
			}
			
		}
	}
	
	public void processPayroll() {
		
	}
	
	
}
