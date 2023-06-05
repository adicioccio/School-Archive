/*
 * Student Name: Stanley Pieda
 * Lab Professor: Stanley Pieda
 * Due Date: Dec 4, 2020 by 11:59pm
 * Modified: Dec 4, 2020 by 11:59pm
 * Description: Sample solution for Exercise 10, 2020 Fall
 */
import java.util.Scanner;

/*
 * This class creates and stores 5 employees initialized from user inputs via the
 * console window, then prints out the employees in the reverse order that they
 * were entered.
 */
public class Exercise10 {

	/*
	 * Entry point for the application
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Employee[] employees = new Employee[5];
		int id;
		String name;
		String report;
		
		// inputs
		for(int index = 0; index < employees.length; index++) {
			System.out.print("Enter Employee id ");
			id = keyboard.nextInt();
			keyboard.nextLine();
			
			System.out.print("Enter Employee name ");
			name = keyboard.nextLine();
			
			Employee employee = new Employee(id, name); // instantiate object
			employees[index] = employee; // copy reference to object into array
			// employees[index] = new Employee(id, name); // do both on same line
		}
		
		// outputs
		for(int index = 4; index >= 0; index--) {
			Employee employee = employees[index]; // get reference to employee
			report = employee.createReport(); // call createReport()
			System.out.println( report ); // print the report
			
			// do the three lines above in one line:
			//System.out.println( employees[index].createReport() );
		}
		
		System.out.println("Program by Stanley Pieda");

	}

}
