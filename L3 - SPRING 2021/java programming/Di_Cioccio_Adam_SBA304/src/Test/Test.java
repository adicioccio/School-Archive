/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * Main class that contains the menu system and main method
 * Student Name: Adam Di Cioccio
 * Student Number: 041019241
 * Section #: 304
 * Course: CST8130 - Data Structures
 * Professor: Murtuza Marketwala 
 */

//package
package Test;

// imports
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import LinkedList.LinkedList;

/**
 * @author Adam Di Cioccio
 * Test class that contains the main method with most functionalities
 */
public class Test {

	/**
	 * main function
	 * @param args arguments
	 */
	public static void main(String[] args) {
		
		// create new list using custom created class
		LinkedList list = new LinkedList();
		
		// import csv file and read from it
		String filename = "Courses.csv";
		Path file = Paths.get(filename);
		try (BufferedReader input = Files.newBufferedReader(file)) {
			// declare line variable
			String line = null;
			
			// print header
			System.out.printf("%10s %53s %12s %12s\n", "Code", "Course name", "| Enrollment", "| Waitlist");
			System.out.println("------------------------------------------------------------------------------------------");
			
			// read each line and set info into variable
			while ((line = input.readLine()) != null) {
				// set array and delimiter variables
				String array[] = null;
				String delimiter = ",";
				
				// loop through each element and split based on delimiter
				for (int i = 0; i < 3; i++) {
					array = line.split(delimiter);
				}
				
				// insert into linked list
				list.insert(array[0], array[1], Integer.parseInt(array[2]), Integer.parseInt(array[3]));
			}
		}
		// exception handling
		catch (IOException ioException) {
			System.err.println("Error opening file");
			ioException.printStackTrace();
		} 
		// call print function to print out nodes
		list.print();
		
		// call max enrollment function
		System.out.println("------------------------------------------------------------------------------------------");
		list.getMaxEnrollment();
		
		// call min waitlist function
		System.out.println("------------------------------------------------------------------------------------------");
		list.getMinWaitlist();		
	}
}
