import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * Food item class that ontains the add item, input code, update item and to string methods
 * Student Name: Adam Di Cioccio
 * Student Number: 041019241
 * Section #: 304
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 */

public class FoodItem {
	//declare variables

	private String itemName = "";
	
	private int itemCode = 0, itemQuantity = 0;
	private double itemCost = 0.0, itemPrice = 0.0;
	
	
	/**
	 * non parameterized constructor
	 */
	FoodItem() {}

	/**
	 * super method add item that adds standard information for all item types
	 * @param input is the scanner that is passed through
	 * @param fileInput is the boolean to see if inputted from file
	 * @return true
	 */
	public boolean addItem(Scanner input, boolean fileInput) {
		
		if (fileInput == false) {
			Boolean validInput;
			//get item name from user
			System.out.println("Please enter the name of the item: ");
			itemName = input.next();
			
			validInput = false;
			while (validInput == false) {
				//get quantity from user
				System.out.println("Please enter the quantity of the item: ");
				try {
					itemQuantity = input.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Invalid input! - " + e + "\n");
					input.next();
				}
				//check if user entered negative value
				if (itemQuantity > 0) {
					validInput = true;
				} else if (itemQuantity < 0) {
					System.out.println("Invalid input! - Cannot be negative\n");
				}
			}
			
			validInput = false;
			while (validInput == false) {
				//get the item cost from user
				System.out.println("Please enter the cost of the item: ");
				
				try {
					itemCost = input.nextDouble();
				} catch (InputMismatchException e) {
					System.out.println("Invalid input! - " + e + "\n");
					input.next();
				}
				//check if user entered a negative value
				if (itemCost > 0) {
					validInput = true;
				} else if (itemCost < 0) {
					System.out.println("Invalid input! - Cannot be negative\n");
				}
			}
			
			validInput = false;
			while (validInput == false) {
				//get the price of the item from user
				System.out.println("Please enter the price of the item: ");
				
				try {
					itemPrice = input.nextDouble();
				} catch (InputMismatchException e) {
					System.out.println("Invalid input! - " + e + "\n");
					input.next();
				}
				//if item price is negative 
				if (itemPrice > 0) {
					validInput = true;
				} else if (itemPrice < 0) {
					System.out.println("Invalid input! - Cannot be negative\n");
				}
			}
			return true;
		} else if (fileInput == true) {
			input.nextLine();
			itemName = input.nextLine();
			itemQuantity = input.nextInt();
			itemCost = input.nextDouble();
			itemPrice = input.nextDouble();
			input.nextLine();
		}
		return true;
		
		
		
		
	}
	
	/**
	 * to string method superclass
	 * @return the item name, code, quantity and price
	 */
	public String toString() {
		return "Item: (" + itemCode + ") " + itemName + " | Quantity: " + itemQuantity + 
				" | Price: " + itemPrice + " | Cost: " + itemCost;
		
	}
	
	/**
	 * input code is the method that allows the user to input item code
	 * @param input is the scanner
	 * @param fileInput is the boolean to see if inputted from file
	 * @return true
	 */
	public boolean inputCode(Scanner input, boolean fileInput) {
		
		if (fileInput == false) {
			//get the item code from the user
			Boolean validInput = false;
			while (validInput == false) {
				System.out.println("Please enter the item code:");
				try {
					itemCode = input.nextInt();
					validInput = true;
				} catch (InputMismatchException e) {
					System.out.println("Invalid input! - " + e + "\n");
					input.next();
				}
			}
			
		} else if (fileInput == true) {
			itemCode = input.nextInt();
		}
		return true;
		
	}
	
	
	/**
	 * update items method in food item class
	 * @param update is the amount the user wants to buy / sell
	 * @return either true or false
	 */
	public boolean updateItems(int update) {
		if ((update + itemQuantity) < 0) {
			return false;
		} else {
			itemQuantity += update;
			return true;
		}
	}
	
	/**
	 * get item code returns the item code from object
	 * @return the item code
	 */
	public int getItemCode() {
		return itemCode;
		
	}
	
	/**
	 * output item that writes item code, name, quantity, cost in text
	 * @param writer is the file writer
	 * @throws IOException exception
	 */
	public void outputItem(FileWriter writer) throws IOException {
		writer.write(itemCode + "\n");
		writer.write(itemName + "\n");
		writer.write(itemQuantity + "\n");
		writer.write(itemCost + "\n");
		writer.write(itemPrice + "\n");
	
	}
}
