import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

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
	private Boolean valid = false;
	private File file;
	private FileWriter fileWriter;
	private Scanner fileReader;
	
	/**
	 * array of food item objects
	 */
	private ArrayList<FoodItem> array = new ArrayList<FoodItem>();
	
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
					fruit.inputCode(input, false);
					alreadyExists(fruit);
				}
				//call add item method
				fruit.addItem(input, false);
				//add input into array
				array.add(fruit);
				validInput = true;
			//if user selects v for vegetable
			} else if (item.equals("v")) {
				//create new object
				FoodItem vegetable = new Vegetable();
				//loop until user enters correct input
				valid = false;
				while (valid == false) {
					vegetable.inputCode(input, false);
					alreadyExists(vegetable);
				}
				//call add item method
				vegetable.addItem(input, false);
				//call add item method
				array.add(vegetable);
				validInput = true;
			//if user selects p for preservative
			} else if (item.equals("p")) {
				//create new object
				FoodItem preservative = new Preservative();
				//loop until user enters correct input
				valid = false;
				while (valid == false) {
					preservative.inputCode(input, false);
					alreadyExists(preservative);
				}
				//call add item method
				preservative.addItem(input, false);
				//call add item method
				array.add(preservative);
				validInput = true;
				
			} else {
				//invalid input
				System.out.println("Invalid input!");
			}
		}
		Collections.sort(array, codeComparator);
		return true;
		
	}
	/**
	 * to string method that prints all instances of inventory
	 * @return nothing
	 */
	public String toString() {
		Collections.sort(array, codeComparator);
		
		String contents = "";
		
		//if array is empty
		if (array.isEmpty()) {
			return "Empty";
		} else {
			//print all instances
			for (int i = 0; i < array.size(); i++) {
				contents += array.get(i).toString() + "\n";
			}
		}
		return contents;
		
	}
	
	/**
	 * already exists method that checks if there is duplicate codes
	 * @param item is the food item object
	 */
	public void alreadyExists(FoodItem item) {
		//if array is empty
		if (array.isEmpty()) {
			valid = true;
		}
		//look for the item code throughout all the array
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).getItemCode() == item.getItemCode()) {
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
		if (array.isEmpty()) {
			return false;
		//buy
		} else if (buysell == true) {
			//prompt user for input
			System.out.println("Enter the code of the item: ");
			code = input.nextInt();
			
			for (int i = 0; i < array.size(); i++) {
				if (code == array.get(i).getItemCode()) {
					//prompt user for input
					System.out.println("Enter the amount you want to buy: ");
					update = input.nextInt();
					//call the update items with positive value
					array.get(i).updateItems(update);
				}
			}
		//sell
		} else if (buysell == false) {
			//prompt user for input
			System.out.println("Enter the code of the item:  ");
			code = input.nextInt();
			
			for (int i = 0; i < array.size(); i++) {
				if (code == array.get(i).getItemCode()) {
					//prompt user for input
					System.out.println("Enter the amount you want to sell: ");
					update = input.nextInt();
					//call the update items with negative value
					array.get(i).updateItems(-update);
				}
			}
		}
		return buysell;
	}
	
	 
	/**
	 * search for item method uses binary search to find the item based on inputted code
	 * @param input is the scanner
	 */
	public void searchForItem(Scanner input) {
		
		int code;
		Boolean itemFound = false;;
		
		//prompt user for input
		System.out.println("Enter the code of the item: ");
		code = input.nextInt();
		
		//declare variables
		int targetIndex = -1;
		int low = 0;
		int high = array.size() - 1;
		
		while (targetIndex == -1 && high >= low) {
			//set the middle of the designated search
			int mid = (low + high) / 2;
			//if target is found
			if (code == array.get(mid).getItemCode()) {
				targetIndex = mid;
				
				itemFound = true;
			//if target is on left side (low)
			} else if (code < array.get(mid).getItemCode()) {
				high = mid - 1;
			//if target is on right side (high)
			} else if (code > array.get(mid).getItemCode()) {
				low = mid + 1;
			}
		}
		
		if (itemFound == false) {
			System.out.println("Item with code " + code + " not found.");
		} else {
			System.out.println(array.get(targetIndex).toString());
		}
		
	}
	
	/**
	 * Comparator that compares item codes
	 */
	public static Comparator<FoodItem> codeComparator = new Comparator<FoodItem>() {
		@Override
		public int compare(FoodItem o1, FoodItem o2) {
			//compare
			return (o1.getItemCode() - o2.getItemCode());
		}
    };
	
	/**
	 * saves the inventory array into a file called inventory.txt
	 * @param input is the scanner
	 * @throws IOException exception
	 */
	public void saveToFile(Scanner input) throws IOException {
		//prompt user for input
		System.out.println("Please enter the name of the file you want to create(do not include txt): ");
		String fileName = input.next();
		
		fileName += ".txt";
				
		fileWriter = new FileWriter(fileName);
		
		System.out.println("File has been created. (" + fileName + ")");
		
		if (array.size() == 0) {
			System.out.println("Inventory is empty...");
		} else {
			for (int i = 0; i < array.size(); i++) {
				array.get(i).outputItem(fileWriter);
			}
		}
		
		fileWriter.close();
		
		
	}
	
	/**
	 * reads from file and sets into array list
	 * @param input is the scanner
	 * @throws FileNotFoundException exception
	 */
	public void readFromFile(Scanner input) throws FileNotFoundException {
		//prompt user for input
		System.out.println("Please enter the text file you want to read (do not include txt): ");
		String fileName = input.next();
		//add .txt at the end
		fileName += ".txt";
		//responsiveness
		System.out.println("Reading from file. (" + fileName + ")");
		//create new file with user created name
		file = new File(fileName);
		//create file scanner
		fileReader = new Scanner(file);
		//clear previous array
		array.clear();
		
		while (fileReader.hasNext()) {
			char line = fileReader.next().charAt(0);
			
			if (line == 'f') {
				//create object
				FoodItem fruit = new Fruit();
				//input code
				fruit.inputCode(fileReader, true);
				//call add item method
				fruit.addItem(fileReader, true);
				//call add item method
				array.add(fruit);
				
			} else if (line == 'v') {
				//create object
				FoodItem vegetable = new Vegetable();
				//input code
				vegetable.inputCode(fileReader, true);
				//call add item method
				vegetable.addItem(fileReader, true);
				//call add item method
				array.add(vegetable);
				
			} else if (line == 'p') {
				//create object
				FoodItem preservative = new Preservative();
				//input code
				preservative.inputCode(fileReader, true);
				//call add item method
				preservative.addItem(fileReader, true);
				//call add item method
				array.add(preservative);
				
			}
			
		}
		//close scanner
		fileReader.close();
		
	}
	
}
