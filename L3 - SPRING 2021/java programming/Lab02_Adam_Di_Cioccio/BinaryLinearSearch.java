import java.security.SecureRandom;
import java.util.Arrays;

/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This is the java class that contains all the methods used in the program.
 * Student Name: Adam Di Cioccio
 * Student Number: 041019241
 * Section #: 304
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 */

public class BinaryLinearSearch {
		
	//initialize array and variables
	private int [] array;
	private String output = "";
	
	/**
	 * default constructor
	 */
	public BinaryLinearSearch() {
		//initialize array
		array = new int [30];
	}
	
	/**
	 * generate the integers for the array and then displays unordered + ordered array
	 */
	public void generateArray() {
		//reset output
		output = "Unordered Array -> ";
		
		for (int i = 0; i < array.length; i++) {
			//generate new random number and set into index of the array
			SecureRandom random = new SecureRandom();
			array[i] = random.nextInt(90)+10;
			output += (array[i] + " ");
		}
		
		//display output and reset variable
		System.out.println(output);
		//reset output
		output = "Ordered Array ---> ";
		//sort array
		Arrays.sort(array);
		//set new output with sorted array
		for (int i = 0; i < array.length; i++) {
			output += (array[i] + " ");
		}
		//print out sorted array
		System.out.println(output + "\n");
	}
	
	/**
	 * @param target is the value the user is trying to search for
	 * @param low is the starting integer for searching the array
	 * @param high is the last integer in the search of the array
	 * @return returns either the index or restarts the method
	 */
	public int recursiveBinarySearch(int target, int low, int high) {
		//not found in all of array
		if (high < low) {
			return -1;
		}
		
		//set mid
		int mid = ((low + high)/2);
		
		try {
			//number found
			if (target == array[mid]) {
				return mid;
			}
		
			//adjust high and low if still not found
			if (target < array[mid]) {
				//call method to print remaining elements
				remainingElements(low, mid - 1);
				//set new high and low and restart method
				return recursiveBinarySearch(target, low, mid - 1 );
			} else if (target > array[mid]) {
				//call method to print remaining elements
				remainingElements(mid + 1, high);
				//set new high and low and restart method
				return recursiveBinarySearch(target, mid + 1, high);
			}
		
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
			
		}
		
		return 0;
		
	}
	
	/**
	 * @param target is the value the user is trying to search for
	 * @param index is the index
	 * @return returns either the index or restarts the method
	 */
	public int recursiveLinearSearch(int target, int index) {
		
		try {
			//check if target is found at index
			if (target == array[index]) {
				return index;
			} else if (index > 30) {
				//out of bounds
				return -1;
			} else {
				//go to next index if not found
				return recursiveLinearSearch(target, index + 1);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
		return -1;
		
	}
	
	
	//perform iterative binary search
	/**
	 * @param target is the value the user is trying to search for
	 * @return returns the found integers index
	 */
	public int iterativeBinarySearch(int target) {
		//declare variables
		int targetIndex = -1;
		int low = 0;
		int high = array.length - 1;
		
		while (targetIndex == -1 && high >= low) {
			//set the middle of the designated search
			int mid = (low + high) / 2;
			//if target is found
			if (target == array[mid]) {
				targetIndex = mid;
			//if target is on left side (low)
			} else if (target < array[mid]) {
				remainingElements(low, mid - 1);
				high = mid - 1;
			//if target is on right side (high)
			} else if (target > array[mid]) {
				remainingElements(mid + 1, high);
				low = mid + 1;
			}
		}
		
		return targetIndex;
		
	}
	
	//perform iterative linear search
	/**
	 * @param target target is the value the user is trying to search for
	 * @return return the found integer
	 */
	public int iterativeLinearSearch(int target) {
		//declare variables
		int targetIndex = -1;
		int count = 0;
		
		while (targetIndex == -1 && count < array.length) {
			//reset count
			count = 0;
			
			for (int i = 0; i < array.length; i++) {
				//check if target is at this index
				if (array[i] == target) {
					//set new target index and stopping loop
					targetIndex = i;
					count = array.length + 1;
				
				} else {
					count++;
				}
			}
		}
		
		return targetIndex;
		
	}
	
	/**
	 * @param low is the starting integer for searching the array
	 * @param high is the last integer in the search of the array
	 */
	public void remainingElements(int low, int high) {
		//declare variables
		String output = "";
		for (int i = low; i < high; i++) {
			//add values to output
			output += array[i] + " ";
		}
		//print output
		System.out.println(output);
	}
	
}
