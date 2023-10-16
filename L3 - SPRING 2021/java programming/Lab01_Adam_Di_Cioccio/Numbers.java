import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Adam Di Cioccio
 * Student Number: 041019241
 * Section #: 304
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 * 
 */

public class Numbers {
	
	//declare array and variables
	private Float [] numbers;
	private int numItems;
	
	//default constructor
	public Numbers() {
		
		numbers = new Float [1];
		numItems = 0;
	
	}

	//parameterized constructor
	public Numbers(int size) {
	
		numbers = new Float [size];
		numItems = 0;
		
	}
	
	//add value method
	public void addValue(Scanner input) {
		//initialize
		Float newValue = (float) 0.0;
		
		System.out.println("Please type in the number you want to add to the array.");
		if (numbers.length == numItems) {
			System.out.println("Array is full. Try increasing the max value.");
			return;
		}
		
		//try catch statement in case user doesn't enter integer
		try {
		//set input into variable
		newValue = input.nextFloat();
		
		} catch (InputMismatchException e) {
			System.out.println(e);
			
		}
		//set new value into the array
		numbers[numItems] = newValue;
		//add 1 to numItems to keep track of objects in array
		numItems++;
	
	}
	
	//calculate average method
	public float calcAverage() {
		//initialize variable
		Float nums = (float) 0.0;
		//for loop that loops through each array item
		for (int i = 0; i < numItems; i++) {
			nums = nums + numbers[i];
			
		}
		//calculate average
		nums = (nums / numItems);
		//return average
		return (float) nums;
	}
	
	//calculate maximum method
	public float calcMaximum() {
		//initialize variable
		Float maximum = (float) 0.0;
		//for loop that loops through each array item
		for (int i = 0; i < numItems; i++) {
			if (maximum < numbers[i]) {
				maximum = numbers[i];
			}
		}
		//return maximum
		return (float) maximum;
	}
	
	//calculate minimum method
	public float calcMinimum() {
		//initialize variable
		Float minumum = (float) 100.0;
		//for loop that loops through each array item
		for (int i = 0; i < numItems; i++) {
			if (minumum > numbers[i]) {
				minumum = numbers[i];
			}
		}
		//return minimum
		return (float) minumum;
	}

	@Override
	public String toString() {
		//initialize variable
		String output = null;
		//list first item in array to avoid null problems
		output = (numbers[0]+ "\n");
		//for loop that loops through each array item
		for (int i = 1; i < numItems; i++) {
			//add each number in array to list
			output = output + (numbers[i] + "\n");
			
		} 
		//return the values
		return output;
		
	}
	
}
