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

public class SortingAlgorithms {
		
	//initialize array and variables
	private static int arraySize = 1000;
	private int [] array;
	private int [] unsortedArray;
	private String output = "";
	
	/**
	 * default constructor
	 */
	public SortingAlgorithms() {
		//initialize array
		array = new int [arraySize];
		unsortedArray = new int [arraySize];
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
			array[i] = random.nextInt(979)+21;
			unsortedArray[i] = array[i];
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
	 * perform the recursive binary search that takes in 3 parameters.
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
	 * perform the recursive linear search that takes in 2 parameters
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
	
	
	
	/**
	 * perform iterative binary search
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
	
	
	/**
	 * perform iterative linear search
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
	 * perform remaining elements method
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
	
	/**
	 * sorting method that makes new array and sorts it using the bubble method
	 */
	public void bubbleSort() {
		//declare variables
		int [] bubbleArray = new int [arraySize];
		int tempStorage;
		
		//copy array
		for (int i = 0; i < unsortedArray.length; i++) {
			bubbleArray[i] = unsortedArray[i];
		}
		
		for (int i = bubbleArray.length - 1; i > 0; i--) {
			//loop until end of array
			for (int j = 0; j < i; j++) {
				//check to see if value on the left is bigger than one on the right
				if (bubbleArray[j] > bubbleArray[j + 1]) {
					//swap values using a temporary storage
					tempStorage = bubbleArray[j];
					bubbleArray[j] = bubbleArray[j + 1];
					bubbleArray[j + 1] = tempStorage;
				}
			}
		}
		
		//print sorted array
		System.out.print("Bubble sorted array -> ");
		for (int i = 0; i < unsortedArray.length; i++) {
			System.out.print(bubbleArray[i] + " ");
		}
	}
	
	/**
	 * sorting method that makes new array and sorts it using the insertion method
	 */
	public void insertionSort() {
		//declare variables
		int [] insertionArray = new int [arraySize];
		int index, valueAtIndex;
		
		//copy array
		for (int i = 0; i < unsortedArray.length; i++) {
			insertionArray[i] = unsortedArray[i];
		}
		
		//repeat array based on array length starting at 1 to compare first 2 numbers
		for (int i = 1; i < insertionArray.length; i++) {
			//set values
			index = i;
			valueAtIndex = insertionArray[i];
			
			//check to see if value on left of index is bigger
			while (index > 0 && valueAtIndex < insertionArray[index - 1]) {
				//replace the value on the left with the value on the right
				insertionArray[index] = insertionArray[index - 1];
				//move down in the array until it reaches end
				index--;
			}
			//insert the value
			insertionArray[index] = valueAtIndex;
		}
		
		//print sorted array
		System.out.print("Insertion sorted array -> ");
		for (int i = 0; i < unsortedArray.length; i++) {
			System.out.print(insertionArray[i] + " ");
		}
	}
	
	/**
	 * sorting method that makes new array and sorts it using the selection method
	 */
	public void selectionSort() {
		//declare variables
		int [] selectionArray = new int [arraySize];
		int min, tempStorage = 0;
		
		//copy array
		for (int i = 0; i < unsortedArray.length; i++) {
			selectionArray[i] = unsortedArray[i];
		}
		
		for (int i = 0; i < selectionArray.length - 1; i++) {
			//move from left to right while moving the minimum
			min = i;
			//go through all values to the left of minimum
			for (int j = i + 1; j < selectionArray.length; j++) {
				//see if index is smaller than minimum
				if (selectionArray[j] < selectionArray[min]) {
					//set new minimum = index
					min = j;
				}
			}
			if (min != i) {
				//swap the 2 values
				tempStorage = selectionArray[i];
				selectionArray[i] = selectionArray[min];
				selectionArray[min] = tempStorage;
				
			}
			
			
		}
		
		//print sorted array
		System.out.print("Selection sorted array -> ");
		for (int i = 0; i < unsortedArray.length; i++) {
			System.out.print(selectionArray[i] + " ");
		}
	}
	
	/**
	 * sorting method that makes new array and sorts it using the merge method
	 */
	public void mergeSort() {
		//declare variables
		int [] mergeArray = new int [arraySize];
		
		//copy array
		for (int i = 0; i < unsortedArray.length; i++) {
			mergeArray[i] = unsortedArray[i];
		}
		
		mergeSortRecursion(mergeArray);
		
		//print sorted array
		System.out.print("Merge sorted array -> ");
		for (int i = 0; i < unsortedArray.length; i++) {
			System.out.print(mergeArray[i] + " ");
		}
	}
	
	/**
	 * merge sort recursive method
	 * @param array accepts the copied merge sort array
	 */
	public static void mergeSortRecursion(int[] array) {
		
		//get length of array
		int length = array.length;
		//base case
		if (length <= 1) return;
		
		//split array in half to find mid point
		int mid = length / 2;
		//array with all values left of mid
		int [] leftArray = new int [mid];
		int i = 0;
		//array with all values right of mid
		int [] rightArray = new int [length - mid];
		int j = 0;
		
		//run through array setting left array values and right array values
		for (; i < length; i++) {
			if (i < mid) {
				leftArray[i] = array[i];
			} else {
				rightArray[j] = array[i];
				j++;
			}
		}
		//repeat steps until array is split into singular array integers
		mergeSortRecursion(leftArray);
		mergeSortRecursion(rightArray);
		//perform the merging
		merge(leftArray, rightArray, array);
		
	}
	/**
	 * merge sort recursive method
	 * @param leftArray is accepted as the the left array
	 * @param rightArray is accepted as the right array
	 * @param array is the initial array
	 */
	private static void merge(int [] leftArray, int [] rightArray, int [] array) {
		//set the array size for the right and left
		int leftSize = array.length / 2;
		int rightSize = array.length - leftSize;
		//create indices
		int i = 0, l = 0, r = 0;
		
		//loop through each side of array
		while (l < leftSize && r < rightSize) {
			//compare both indices of each side
			if (leftArray[l] < rightArray[r]) {
				//set smaller value to left side
				array[i] = leftArray[l];
				//add one to counters
				i++;
				l++;
			} else {
				//set smaller value to left side
				array[i] = rightArray[r];
				//add one to counters
				i++;
				r++;
			}
		}
		//excess values getting sorted
		while (l < leftSize) {
			array[i] = leftArray[l];
			i++;
			l++;
		}
		//excess values getting sorted
		while (r < rightSize) {
			array [i] = rightArray[r];
			i++;
			r++;
		}
	}
	
	/**
	 * sorting method that makes new array and sorts it using the quick method
	 */
	public void quickSort() {
		//declare variables
		int [] quickArray = new int [arraySize];
		
		//copy array
		for (int i = 0; i < unsortedArray.length; i++) {
			quickArray[i] = unsortedArray[i];
		}
		
		//quick sort the array
		quickSortAlgo(quickArray, 0, quickArray.length - 1);
		
		//print sorted array
		System.out.print("Quick sorted array -> ");
		for (int i = 0; i < unsortedArray.length; i++) {
			System.out.print(quickArray[i] + " ");
		}
	}
	
	/**
	 * @param array is the original array passed through
	 * @param start is the starting point
	 * @param end is the end point
	 */
	public static void quickSortAlgo(int [] array, int start, int end) {
		//base case
		if (end <= start) return;
		
		//create pivot point calling partition
		int pivot = partition(array, start, end);
		//left side of pivot
		quickSortAlgo(array, start, pivot - 1);
		//right side of pivot
		quickSortAlgo(array, pivot + 1, end);
	}
	
	/**
	 * @param array is the original array passed through
	 * @param start is the starting point
	 * @param end is the end point
	 * @return pivot point
	 */
	public static int partition(int [] array, int start, int end) {
		//pivot point will be last element in array
		int pivot = array[end];
		//declare item from left
		int i = start - 1;
		
		for(int j = start; j <= end - 1; j++) {
			if (array[j] < pivot) {
				//shift over
				i++;
				//swap the 2 values
				int tempStorage = array[i];
				array[i] = array[j];
				array[j] = tempStorage;
			}
		}
		//shift over
		i++;
		//swap the 2 values
		int tempStorage = array[i];
		array[i] = array[end];
		array[end] = tempStorage;
		
		return i;
		
	}
	
	/**
	 * print the unsorted array
	 */
	public void printArray() {
		System.out.print("Unsorted array -> ");
		for (int i = 0; i < unsortedArray.length; i++) {
			System.out.print(unsortedArray[i] + " ");
		}
		System.out.println("");
	}
}
