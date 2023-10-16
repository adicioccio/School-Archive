import java.util.*;
/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * Main class that contains the menu system and main method
 * Student Name: Adam Di Cioccio
 * Student Number: 041019241
 * Section #: 304
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 */

/**
 * @author Adam Di Cioccio 
 * main class that the program runs all classes from
 */
public class Assignment01 {

	/**
	 * main method that holds the menu system for the entire program
	 * @param args main
	 */
	public static void main(String[] args) {
		//create scanner
		Scanner input = new Scanner(System.in);
		//allow input of white spaces
		input.useDelimiter("\n");
		//create new inventory object
		Inventory i1 = new Inventory();
		//declare variables
		Boolean program = false;
		Boolean buysell;
		int userInput = 0;
		
		while (program == false) {
			//print menu from method
			printMenu();
			//gather menu selection from user and make sure its correct input
			try {
				userInput = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input! - " + e + "\n");
				main(null);
			}
			
			switch (userInput) {
			//add item to inventory
			case 1:
				i1.addItem(input);
				break;
			//display current inventory
			case 2:
				System.out.println("- Inventory -");
				i1.toString();
				break;
			//buy item
			case 3:
				buysell = true;
				i1.updateQuantity(input, buysell);
				break;
			//sell item
			case 4:
				buysell = false;
				i1.updateQuantity(input, buysell);
				break;
			//exit program
			case 5:
				System.out.println("Quitting program...");
				input.close();
				program = true;
				break;
			//invalid integer
			default:
				System.out.println("Invalid input!\n");
				break;
			}
		
		}	

	}
	
	/**
	 * method that prints out the menu system
	 */
	public static void printMenu() {
		System.out.println("-- Please select one of the following options --\n"
				+ "1. Add Item to Inventory\n"
				+ "2. Display Current Inventory\n"
				+ "3. Buy Item(s)\n"
				+ "4. Sell Item(s)\n"
				+ "5. To Exit");
	}

}
