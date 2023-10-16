import java.util.*;

/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * main inventory object that contains add item, update quantity, to string and already exists methods
 * Student Name: Adam Di Cioccio
 * Student Number: 041019241
 * Section #: 304
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 */

public class Inventory {

	//declare variables
	private int count;
	private Boolean valid = false;
	/**
	 * array of food item objects
	 */
	FoodItem array [] = new FoodItem[100];
	
	/**
	 * non parameterized constructor
	 */
	Inventory() {}
	
	/**
	 * add item method that adds a fruit, vegetable or preservative
	 * @param input passes through scanner
	 * @return true
	 */
	public boolean addItem(Scanner input) {
		
		Boolean validInput = false;
		
		while (validInput == false) {
			//get input from user and set to lower case
			System.out.println("Would you like to add (f)fruit, (v)vegetable or a (p)preservative?: ");
			String item = input.next();
			item = item.toLowerCase();
			//if user selects f for fruit
			if (item.equals("f")) {
				//create new object
				FoodItem fruit = new Fruit();
				//loop until user enters correct input
				valid = false;
				while (valid == false) {
					fruit.inputCode(input);
					alreadyExists(fruit);
				}
				//call add item method
				fruit.addItem(input);
				//add input into array
				array[count] = fruit;
				//add to count
				count++;
				validInput = true;
			//if user selects v for vegetable
			} else if (item.equals("v")) {
				//create new object
				FoodItem vegetable = new Vegetable();
				//loop until user enters correct input
				valid = false;
				while (valid == false) {
					vegetable.inputCode(input);
					alreadyExists(vegetable);
				}
				//call add item method
				vegetable.addItem(input);
				//call add item method
				array[count] = vegetable;
				//add to count
				count++;
				validInput = true;
			//if user selects p for preservative
			} else if (item.equals("p")) {
				//create new object
				FoodItem preservative = new Preservative();
				//loop until user enters correct input
				valid = false;
				while (valid == false) {
					preservative.inputCode(input);
					alreadyExists(preservative);
				}
				//call add item method
				preservative.addItem(input);
				//call add item method
				array[count] = preservative;
				//add to count
				count++;
				validInput = true;
				
			} else {
				//invalid input
				System.out.println("Invalid input!");
			}
		}
		return true;
		
	}
	/**
	 * to string method that prints all instances of inventory
	 * @return nothing
	 */
	public String toString() {
		//if array is empty
		if (count == 0) {
			return "Empty";
		} else {
			//print all instances
			for (int i = 0; i < count; i++) {
				System.out.println(array[i].toString());
			}
		}
		return "";
		
	}
	
	/**
	 * already exists method that checks if there is duplicate codes
	 * @param item is the food item object
	 */
	public void alreadyExists(FoodItem item) {
		//if array is empty
		if (count == 0) {
			valid = true;
		}
		//look for the item code throughout all the array
		for (int i = 0; i < count; i++) {
			if (array[i].itemCode == item.itemCode) {
				System.out.println("This item is code is already in use!");
				valid = false;
			//if not found
			} else {
				valid = true;
			}
		}
	}
	
	/**
	 * update quantity method that gets user input and calls the update item method
	 * @param input is the scanner
	 * @param buysell is the boolean set in main class
	 * @return true
	 */
	public boolean updateQuantity(Scanner input, Boolean buysell) {
		//declare variables
		int update;
		int code;
		//if array is empty
		if (count == 0) {
			return false;
		//buy
		} else if (buysell == true) {
			//prompt user for input
			System.out.println("Enter the code of the item: ");
			code = input.nextInt();
			
			for (int i = 0; i < count; i++) {
				if (code == array[i].itemCode) {
					//prompt user for input
					System.out.println("Enter the amount you want to buy: ");
					update = input.nextInt();
					//call the update items with positive value
					array[i].updateItems(update);
				}
			}
		//sell
		} else if (buysell == false) {
			//prompt user for input
			System.out.println("Enter the code of the item:  ");
			code = input.nextInt();
			
			for (int i = 0; i < count; i++) {
				if (code == array[i].itemCode) {
					//prompt user for input
					System.out.println("Enter the amount you want to sell: ");
					update = input.nextInt();
					//call the update items with negative value
					array[i].updateItems(-update);
				}
			}
		}
		return buysell;
	}
}
