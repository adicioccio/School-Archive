import java.util.*;

/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * vegetable object that extends food item
 * Student Name: Adam Di Cioccio
 * Student Number: 041019241
 * Section #: 304
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 */

public class Vegetable extends FoodItem {
	
	/**
	 * vegetable variable farm supplier
	 */
	String farmSupplier;
	
	/**
	 * non parameterized constructor
	 */
	Vegetable() {}
	
	/**
	 * add item sub class method
	 * @param input is the scanner
	 * @return true
	 */
	public boolean addItem(Scanner input) {
		//call superclass add item
		super.addItem(input);
		//get user input
		System.out.println("Please enter the name of the orchard supplier: ");
		farmSupplier = input.next();
		return true;
	}
	
	/**
	 * to string method subclass
	 * @return farm supplier
	 */
	public String toString() {
		return super.toString() + " | Farm Supplier: " + farmSupplier;
		
	}
}
