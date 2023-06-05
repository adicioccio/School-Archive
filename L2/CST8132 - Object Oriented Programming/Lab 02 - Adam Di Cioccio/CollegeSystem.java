/*
 * Adam Di Cioccio
 * Anu Thomas - Lab 2
 * 1/26/2021
 */

//imports
import java.util.Scanner;

public class CollegeSystem {

	public static void main(String[] args) {
		
		//create scanner
		Scanner input = new Scanner(System.in);
		//prompt user
		System.out.println("Enter number of students: ");
		//set input into variable
		int num = input.nextInt();
		
		//initialize array
		Student []students = new Student[num];
		
		//for loop that repeats based on users input
		for (int i = 0; i < num; i++) {
			//prompt user
			System.out.println("Enter details of student " + (num + 1) + "\n**************************");
			//creates the object
			students[i] = new Student();
			//call readStudentInfo method from student class
			students[i].readStudentInfo();
		}

		//print out table header
		System.out.printf("%6s  ", "Student#");
		System.out.printf("%22s  ", "Student name");		
		System.out.printf("%22s  ", "Student email");
		System.out.printf("%22s", "Student phone#");
		System.out.printf("%6s", "GPA\n");
		
		//loop and print out each student object
		for (int i = 0; i < num; i++) {
			//call print student method
			students[i].printStudent();
		}
		//close scanner
		input.close();
	}
	
	
}
