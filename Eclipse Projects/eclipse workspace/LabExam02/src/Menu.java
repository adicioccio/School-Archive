/*
 * Adam DI Cioccio
 * Mohammad Pataory
 * December 8, 2020
 * Lab Exam 02
 */

public class Menu {
	
	public Menu() {
		
	}
	
	public String optionsList() {
		String displayBox = "%nPlease select an option from below:%n";
		displayBox += "321 to edit the egg%n";
		displayBox += "642 to show the sales cost%n";
		displayBox += "963 to exit the program%n";
		displayBox += "Program by Adam Di Cioccio\n";
		
		//return the display for print
		return String.format(displayBox);
	}
	
}
