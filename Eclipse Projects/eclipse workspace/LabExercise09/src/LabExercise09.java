import java.util.Scanner;

public class LabExercise09 {

	public static void main(String[] args) {
		//create scanner
		Scanner scanner = new Scanner (System.in);
		
		//declare variables
		double userInput;
		
		//declare array
		double newArray [];
		newArray = new double [5];
		
		//for loop that collects user input and puts into array
		for (int index = 0; index < newArray.length; index++) {
			//ask user for input
			System.out.println("Enter Number " + (index + 1) + ":"); 
			//collect input
			userInput = scanner.nextDouble();
			//set array index as the inputed value
			newArray[index] = userInput;
			
		}
		
		//for loop that displays the entire array
		for (int index = 4; index >= 0; index--) {
			//display value at index
			System.out.println(newArray[index]);
			
		}
		
		//close scanner
		scanner.close();
		//display name
		System.out.println("Program By: Adam Di Cioccio");
	}

}
