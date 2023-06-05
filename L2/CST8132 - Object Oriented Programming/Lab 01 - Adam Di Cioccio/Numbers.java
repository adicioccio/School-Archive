//Adam Di Cioccio
//Lab 01 - Anu Thomas

//imports
import java.util.Scanner;

public class Numbers {

	//declare arrays
	private int[] numbers;
	private int[][] squares;

	//non-arg constructor
	Numbers() {
		
	}
	
	//parameterized constructor
	Numbers(int size) {
		//set array size
		numbers = new int [size];
	}
	
	//parameterized constructor
	Numbers(int row, int col) {
		//set array row and column
		squares = new int [row][col];
	}
	
	public void generateNumbers() {
		//for loop that repeats itself for each 
		for(int index = 0; index < numbers.length; index++) {
			//set number into index
			numbers[index] = index;

		}
	}
	
	public void printNumbers() {
		for(int index = 0; index < numbers.length; index++) {
			//print out the number at index
			System.out.print(numbers[index] + " ");
		}
	}
	
	public void printIndices() {
		for(int i = 0; i < squares.length; i++) {
			for(int j = 0; j < squares.length; j++) {
				//output numbers
				System.out.print(i + "," + j + "  ");
			}
			//start new line after i = row
			System.out.println();
		}
	}
        
	public void generateSquares() {
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; i > j; j++) {
				//set value into index (index*10+j)^2
				squares[i][j] = (i * 10 + j) * (i * 10 + j);
			}
		}
	}
	
	public void printSquares() {
		for (int i = 1; i < squares.length; i++) {
			for (int j = 0; i > j; j++) {
	            //print out index   
				System.out.printf("%4d  ", squares[i][j]);
	        }	
			//start new line
			System.out.println();
		}
	}
	
	public void printPattern() {
		//declare variable
		int userInput;
        //creates scanner
		Scanner input = new Scanner(System.in);

        do {
            //prompt user for input
        	System.out.println("Please enter an odd number for height (-1 to quit): ");
            //set the input into variable
        	userInput = input.nextInt();
            //check input to see if its smaller than 5
            if (userInput <= 5) {
                //prompt user
            	System.out.println("Please enter a number larger than 5...");
            	
            //user check to see if input is even number
            } else if (userInput % 2 != 0){
            	 for (int i = 1; i < 2 * userInput; i++) {
            		 
                     int a = Math.abs(userInput - i);

                     //create first side
                     for (int j = a; j < ((userInput / 2) + 0.5); j++) {
                         System.out.print("*");
                     }
                     //create space in the middle
                     for (int j = 0; j < a; j++) {
                         System.out.print("  ");
                     }
                     //create second side
                     for (int j = a; j < ((userInput / 2) + 0.5); j++) {
                         System.out.print("*");
                     }
                     System.out.println();
                 }
            } else {
            	//if odd number is entered prompt user for valid input
            	System.out.println("Please input a positive number... ");
            }
          //end loop if user enters -1
        } while (userInput != -1);
        //close scanner
        input.close();
		
	}
	
}
