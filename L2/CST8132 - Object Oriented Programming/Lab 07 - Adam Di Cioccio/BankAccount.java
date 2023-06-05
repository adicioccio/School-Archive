/*
Adam Di Cioccio
41019241 - Lab 07 
Bank simulator w exceptions 
Rejaul Chowdhury - 3/21/2021
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class BankAccount extends Bank implements BankSimulator {

	// declare variables
	private int accountNumber;
	private Person accHolder;
	protected double balance;

	@Override
	public void addBankAccount(Scanner input) {

		boolean validInput = false;
		do {
		try {
			// get account number
			System.out.println("Enter account number(up to 8 digits): ");
			accountNumber = input.nextInt();

			if (accountNumber < 0) throw new NegativeAccountNumberException();
			if (accountNumber > 99999999) throw new DigitAccountNumberException();
			
			for (int i = 0; i < accounts.size(); i++) {
				if (accountNumber == accounts.get(i).getAccountNumber()) {
					throw new DuplicateAccountNumberException();
				}
			}
			
			validInput = true;

		} catch (InputMismatchException e) {
			System.err.println("Invalid input! Please enter an integer. \n" + e);
			input.next();
		} catch (NegativeAccountNumberException nane) {
			System.out.println(nane);
		} catch (DigitAccountNumberException dane){
			System.out.println(dane);
		} catch (DuplicateAccountNumberException dan) {
			System.out.println(dan);
		}
		
		} while (!validInput);

		// gather information and put into variables
		System.out.println("Enter first name of account holder: ");
		String firstName = input.next();
		System.out.println("Enter last name of account holder: ");
		String lastName = input.next();
		System.out.println("Enter phone number of account holder: ");
		String phoneNumber = input.next();
		System.out.println("Enter email of account holder: ");
		String email = input.next();

		// make new person object
		accHolder = new Person(firstName, lastName, phoneNumber, email);

		// get starting balance
		System.out.println("Enter opening balance of account holder: ");
		balance = input.nextInt();

	}

	@Override
	public void updateBalance(double d) {
		// update the balance
		balance += d;
	}

	public void monthlyAccountUpdate(double fee) {
		// add the fee
		balance += fee;
	}

	// getter for account number
	public int getAccountNumber() {
		return accountNumber;
	}

	// getter for person object
	public Person getaccHolder() {
		return accHolder;
	}

	// getter for balance
	public double getbalance() {
		return balance;
	}
}
