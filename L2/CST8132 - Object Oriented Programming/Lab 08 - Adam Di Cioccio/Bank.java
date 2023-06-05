/*
Adam Di Cioccio
41019241 - Lab 08 
Bank simulator w File IO
Rejaul Chowdhury - 3/28/2021
*/

//imports from lab7
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
//lab8 imports
import java.util.HashMap;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Bank {

	// create new array list called accounts
	ArrayList<BankAccount> accounts = new ArrayList<>();

	// lab8 declarations
	private File file;
	private FileWriter fileWriter;
	private Scanner fileReader;

	// non parameterized constructor
	public Bank() {
	}

	// creates an account
	public void addAccount(Scanner input) {

		// prompt user
		System.out.println(
				"Enter details of Account Holder " + (accounts.size() + 1) + "\n*********************************");

		// prompt user
		System.out.println("Please select the type of account you would like to add.\n"
				+ "Type 'c' for chequings account or 's' for savings account: ");
		// get input from user
		String accType = input.next();

		// new chequings account
		if (accType.equals("c")) {
			ChequingsAccount c = new ChequingsAccount();
			c.addBankAccount(input);
			accounts.add(c);
			// new savings account
		} else if (accType.equals("s")) {
			SavingsAccount s = new SavingsAccount();
			s.addBankAccount(input);
			accounts.add(s);
			// invalid input
		} else {
			System.out.println("Invalid input!");
		}
	}

	// displays account
	public void displayAccount(Scanner input) {
		int userInput = 0;

		try {
			// prompt user
			System.out.println("Please enter an account number display contents: ");
			// set input into variable
			userInput = input.nextInt();

			// boolean to check if any accounts are found
			boolean found = false;

			// loop all accounts
			for (int i = 0; i < accounts.size(); i++) {
				if (userInput == accounts.get(i).getAccountNumber()) {
					System.out.println(accounts.get(i).toString());
					found = true;
				}
			}

			// if nothing found print not found
			if (found == false) {
				throw new NotExistAccount();
			}
		} catch (NotExistAccount ne) {
			System.out.println(ne);
		} catch (InputMismatchException e) {
			System.err.println("Invalid input! Please enter an integer. \n" + e);
			input.next();
		}
	}

	// prints all accounts
	public void printAccountDetails() {
		// loops through all accounts and prints their data
		for (int i = 0; i < accounts.size(); i++) {
			System.out.println(accounts.get(i).toString());
		}

		// call methods to save into a file
		openInputFile();
		readInputFile();
		closeInputFile();
	}

	// updates an account
	public void updateAccount(Scanner input) {

		// prompt user and gather input
		System.out.println("Please enter an account number to update the balance: ");
		int accountNumber = input.nextInt();
		// prompt user and gather input
		System.out.println("Enter the amount to deposit/withdraw (positive to deposit, negative to withdraw) : ");
		int balanceChange = input.nextInt();

		boolean found = false;

		for (int i = 0; i < accounts.size(); i++) {
			if (accountNumber == accounts.get(i).getAccountNumber()) {
				this.accounts.get(i).updateBalance(balanceChange);
				found = true;
			}
		}

		if (found == false) {
			System.out.println("Account number not found.");
		}
	}

	// find specific account
	public void findAccount(int accountNumber) {

		boolean found = false;
		for (int i = 0; i < accounts.size(); i++) {
			if (accountNumber == accounts.get(i).getAccountNumber()) {
				System.out.println(i);
			}
		}
		if (found == false) {
			System.out.println("Account number not found.");
		}
	}

	// perform monthly update
	public void monthlyUpdate() {
		for (int i = 0; i < accounts.size(); i++) {
			accounts.get(i).monthlyAccountUpdate(0);
		}
	}

	// open input file method
	public void openInputFile() {
		// try catch statement
		try {
			// create new file
			file = new File("bankInput.txt");
			// create new file reader
			fileReader = new Scanner(file);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// read input method
	public void readInputFile() {
		// while loop
		while (fileReader.hasNextLine()) {
			// set scanner input into variable
			String i = fileReader.nextLine();
			// dissect from method below
			HashMap<String, String> data = dissect(i);

			// if statement to see what type of account the program will read
			if (data.get("Type").equals("C")) {
				// create new chequings account
				ChequingsAccount temp = new ChequingsAccount();
				// call pass information method
				temp.passInformation(data.get("Account Number"), data.get("First Name"), data.get("Last Name"),
						data.get("Phone Number"), data.get("Email"), data.get("Balance"), data.get("Fee"));
				// add into array
				accounts.add(temp);
			} else if (data.get("Type").equals("S")) {
				// create new savings account
				SavingsAccount temp = new SavingsAccount();
				// call pass information method
				temp.passInformation(data.get("Account Number"), data.get("First Name"), data.get("Last Name"),
						data.get("Phone Number"), data.get("Email"), data.get("Balance"), data.get("Minimum Balance"), data.get("Interest Rate"));
				// add into array
				accounts.add(temp);
			}
		}
	}

	// close input method
	public void closeInputFile() {
		// close scanner
		fileReader.close();
	}

	// open output method
	public void openOutputFile() {
		// try catch statement
		try {
			fileWriter = new FileWriter("bankOutput.txt");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// close output method
	public void closeOutputFile() {
		// try catch statement
		try {
			// close file writer
			fileWriter.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	// write into file method
	public void writeIntoFile() {
		// try catch statement
		try {
			for (BankAccount account : accounts) {
				fileWriter.write(account.saveString());
				fileWriter.write("\n");
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private String[] nextChunk(String data) {
		String[] output = new String[2];
		String c = data;
		String w = "";

		for (int i = 0; i < data.length(); i++) {
			if (data.charAt(i) == ' ') {
				c = data.substring(0, i);
				w = data.substring(i + 1);
				break;
			}
		}

		output[0] = c;
		output[1] = w;
		
		return output;
	}

	// hashmap dissect
	private HashMap<String, String> dissect(String data) {
		// initialize hash map
		HashMap<String, String> hashmapData = new HashMap<String, String>();
		// declare temp array
		String[] array;

		// for chequings and savings
		array = nextChunk(data);
		data = array[1];
		hashmapData.put("Type", array[0]);
		// set account number
		array = nextChunk(data);
		data = array[1];
		hashmapData.put("Account Number", array[0]);
		// set first name
		array = nextChunk(data);
		data = array[1];
		hashmapData.put("First Name", array[0]);
		// set last name
		array = nextChunk(data);
		data = array[1];
		hashmapData.put("Last Name", array[0]);
		// set phone number
		array = nextChunk(data);
		data = array[1];
		hashmapData.put("Phone Number", array[0]);
		// set email
		array = nextChunk(data);
		data = array[1];
		hashmapData.put("Email", array[0]);
		// set balance
		array = nextChunk(data);
		data = array[1];
		hashmapData.put("Balance", array[0]);

		// for savings account only
		if (hashmapData.get("Type").equals("C")) {
			// set fee
			array = nextChunk(data);
			data = array[1];
			hashmapData.put("Fee", array[0]);
		}
		// for chequings account only
		else if (hashmapData.get("Type").equals("S")) {
			// set minimum balance
			array = nextChunk(data);
			data = array[1];
			hashmapData.put("Minimum Balance", array[0]);
			// set interest rate
			array = nextChunk(data);
			data = array[1];
			hashmapData.put("Interest Rate", array[0]);
		}
		// return data
		return hashmapData;
	}

}
