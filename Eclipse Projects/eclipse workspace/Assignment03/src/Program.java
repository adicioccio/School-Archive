//Adam Di Cioccio

public class Program {

	public static void main(String[] args) {
		//Reference other classes
		MathMachine math = new MathMachine();
		MenuSystem menu = new MenuSystem();
		UserInput user = new UserInput();
		//Boolean to keep program running
		boolean programIsRunning = true;
		
		//start of while loop
		while (programIsRunning) {
			//Call options list method and print out results
			System.out.println(menu.optionsList());
			
			System.out.println("Please enter an option from 1 to 8:");
			int inputTest1 =  user.input();
			
			if (inputTest1 == 1) {
				System.out.println("Please enter an option from -10000.0 to 10000.0 for the first operand:");
				double inputTest2 = user.input2();
				math.setLeftOperand(inputTest2);
				
				System.out.println("Please enter an option from -10000.0 to 10000.0 for the second operand:");
				double inputTest3 = user.input2();
				math.setRightOperand(inputTest3);
				
			} else if (inputTest1 == 2) {
				//Display the two selected operands
				System.out.println("Selected operands: \n Left = " + math.getLeftOperand() + "\n Right = " + math.getRightOperand());
				
			} else if (inputTest1 == 3) {
				//Add numbers using MathMachine
				System.out.println("Calculated sum: " + math.add());
				
			} else if (inputTest1 == 4) {
				//Subtract numbers using MathMachine
				System.out.println("Calculated difference: " + math.subtract());
				
			} else if (inputTest1 == 5) {
				//Multiply numbers using MathMachine
				System.out.println("Calculated product: " + math.multiply());
				
			} else if (inputTest1 == 6) {
				//Divide numbers using MathMachine
				System.out.println("Calculated quotient: " + math.divide());
				
			} else if (inputTest1 == 7) {
				//Get remainder of numbers using MathMachine
				System.out.println("Calculated remainder: " + math.remainder());
				
			} else if (inputTest1 == 8) {
				//Exit program
				System.out.println("Exiting Program...");
				programIsRunning = false;
				
			} else
				System.out.println("Invalid input. Please enter a number between 1 and 8:");
		}
		
	}

}
