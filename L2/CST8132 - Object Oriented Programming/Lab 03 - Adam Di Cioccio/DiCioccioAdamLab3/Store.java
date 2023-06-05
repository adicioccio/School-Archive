/*
 * Adam Di Cioccio
 * 41019241 - Lab 03 Store Management System
 * Store management system that allows the user to store names 
 * and information about specific employees, regulars and contractors
 * Anu Thomas - 2/1/2021
 */

//imports
import java.util.Scanner;

public class Store {
	//declare array and variables
	private Employee[] employees;
	private int index;

	//parametized constructor for store
	public Store(int size) {
		this.employees = new Employee[size];
		this.index = 0;
	}

	public void readEmployeeDetails() {
		//create scanner
		Scanner input = new Scanner(System.in);
		
		//for loop that loops based on number of employees
		for (int i = 0; i < employees.length; i++) {
			
			//prompt user
			System.out.print("Enter details of Employee " + (i + 1) + "\n" + "1. Regular \n" + "2. Contractor \n" + "Enter type of employee: ");
			
			//create and store value into variable
			int type = input.nextInt();		

			//if statement to check if user entered 1 for regular and 2 for contractor
			if (type == 1) {
				//create new regular object
				Regular regular = new Regular();
				//call read employee method from regular class
				regular.readEmployee();
				//store values into array
				employees[index++] = regular;
			
			} else if (type == 2) {
				//create new contractor object
				Contractor contractor = new Contractor();
				//call read employee method from contractor class
				contractor.readEmployee();
				//store values into array
				employees[index++] = contractor;
			
			} else {
				//tell user to re input values
				System.out.println("Invalid input.");
				System.out.print("Enter details of Employee 1\n" + "1. Regular \n" + "2. Contractor \n" + "Enter type of employee: ");
				//collect input
				type = input.nextInt();
			}
			
		}
		
	}

	//print employee details method
	public void printEmployeeDetails() {
		//for loop that loops based on employees array length
		for (int i = 0; i < employees.length; i++) {
			//check if loop hits end of array
			if (employees[i] != null)
				//print out details at index
				employees[i].printEmployee();
		}
	}

	//print title method
	public static void printTitle(String storeName) {
		//call printLine method
		printLine();
		//display store name with title
		System.out.println(storeName + " Store Management System");
		//call printLine method
		printLine();
	}

	//print header method
	public static void printHeader() {
		//print out header
		System.out.printf("%-10s | %-30s | %-15s | %-10s | %-1s |\n", "Emp#", "Name", "Email", "Phone", "Salary");
		//call printLine method
		printLine();
	}
	
	//print line method
	public static void printLine() {
		//print line
		System.out.println("=====================================================================================");
	}
}