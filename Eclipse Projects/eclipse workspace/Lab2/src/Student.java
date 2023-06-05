/*
 * Adam Di Cioccio
 * Anu Thomas - Lab 2
 * 1/26/2021
 */

//imports
import java.util.Scanner;

public class Student {

	//declare variables
	private int studentNumber;
	private Person student;
	private double gpa;
	
	//create scanner
	Scanner input = new Scanner(System.in);	
	
	//readStudentInfo method
	public void readStudentInfo () {
		//prompt user
		System.out.println("Enter student number: ");
		//set input into variable
		studentNumber = input.nextInt();
		
		//prompt user	
		System.out.println("Enter first name: ");
		//set input into variable
		String fName = input.next();
		
		//prompt user	
		System.out.println("Enter last name: ");
		//set input into variable
		String lName = input.next();
		
		//prompt user	
		System.out.println("Enter email Id: ");
		//set input into variable
		String emailId = input.next();
		
		//prompt user	
		System.out.println("Enter phone number: ");
		//set input into variable
		long phoneNumber = input.nextLong();
		
		//set values into object
		student = new Person(fName, lName, emailId, phoneNumber);
		
		//call readMarks method below
		readMarks();
		
		
	}
	
	public void readMarks () {
		//prompt user
		System.out.println("Enter number of courses: ");
		//set into variable
		int courses = input.nextInt();
		//declare array to store marks
		double markArray[] = new double [courses];
		//for loop that repeats based on how many courses student has
		for (int i = 0; i < courses; i++) {
			//prompt user for the mark
			System.out.println("Enter mark " + (i+1) + ": ");
			//set into test variable
			double test = input.nextDouble();
			//set into array
			markArray[i] = test;
		}
		//call calculateGpa with array values user entered
		calculateGpa(markArray);
		
	}
	
	public void calculateGpa (double[] gpaTest) {
		//declare total
		double total = 0;
		//add all marks into total using for loop
		for (int i = 0; i < gpaTest.length; i++) {
			//add num to previous total
			total = total + gpaTest[i];
		}
		
		//perform calculations and set into gpa
		gpa = (((total/gpaTest.length) * 4) / 100);
		
	}

	public void printStudent () {
		//print out values with formatting
		System.out.printf("%6d | %22s | %22s | %22s | %6s | \n", studentNumber, student.getFullName(), student.getEmailId(), student.getPhoneNumber(), gpa);
	}
	
}
