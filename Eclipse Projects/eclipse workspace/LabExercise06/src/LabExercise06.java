//Adam Di Cioccio
//Lab Exercise 06
// Mohammad Patoary
//Due: November 13, 2020


public class LabExercise06 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		//declare variables
		int x = 10;
		int y = 5;
		
		//equation 1
		System.out.println("Equation 1 - (42 / 3.0 + 44 >= 100 && true || 99 - (11*9) + 45 < 42) \nanswer = " 
		+ (42 / 3.0 + 44 >= 100 && true || 99 - (11*9) + 45 < 42) + "\n" );
		
		//equation 2
		System.out.println("Equation 2 - (x++ + y > (y = 3) || 45 - y++ <= 2) - X = 10, Y = 5 \nanswer = " 
		+ (x++ + y > (y = 3) || 45 - y++ <= 2) + "\n" );
		
		//equation 3
		System.out.println("Equation 3 - (!(3 + 5 > 7 && 42 == 5 || ! (3 <= 3)) \nanswer = " 
		+ (!(3 + 5 > 7 && 42 == 5 || ! (3 <= 3))) + "\n" );
		
		//print name
		System.out.print("Adam Di Cioccio");
		

	}

}
