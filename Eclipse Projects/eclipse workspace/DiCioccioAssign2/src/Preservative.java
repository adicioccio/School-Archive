import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * preservative object that extends food item
 * Student Name: Adam Di Cioccio
 * Student Number: 041019241
 * Section #: 304
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 */

public class Preservative extends FoodItem {
	
	/**
	 * preservative variable size of jar
	 */
	private String sizeOfJar;
	
	/**
	 * non parameterized constructor
	 */
	Preservative() {}
	
	/**
	 * add item sub class method
	 * @param input is the scanner
	 * @param fileInput is the boolean to see if inputted from file
	 * @return true
	 */
	public boolean addItem(Scanner input, boolean fileInput) {
		//call superclass add item
		super.addItem(input, fileInput);
		
		if (fileInput == false) {
			//get user input
			System.out.println("Please enter the name of the orchard supplier: ");
			sizeOfJar = input.next();
			
		} else if (fileInput == true) {
			sizeOfJar = input.nextLine();
		}
		return true;
		
	}
	
	/**
	 * to string method subclass
	 * @return jar size
	 */
	public String toString() {
		return super.toString() + " | Size of Jar: " + sizeOfJar;
		
	}
	
	/**
	 * output item that writes f, size of jar in text
	 * @param writer is the file writer
	 * @throws IOException exception
	 */
	public void outputItem(FileWriter writer) throws IOException {
		writer.write("p\n");
		super.outputItem(writer);
		writer.write(sizeOfJar + "\n");
	}
}
