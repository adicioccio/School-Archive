public class NumbersTest { 
 
 public static void main(String[] args) {   
	 
	 Numbers n1 = new Numbers (10);   
	 
	 n1.generateNumbers();   
	
	 System.out.println("Printing Numbers");      
	 n1.printNumbers();  
	 
	 Numbers n2 = new Numbers (10, 10);
	 
	 System.out.println("\n\nPrinting Positions");
	 n2.printIndices();
	 
	 n2.generateSquares();
	 
	 System.out.println("\nPrinting Squares in a pattern");
	 n2.printSquares();
	 
	 System.out.println("\nPrinting stars in a pattern");
	n2.printPattern();
	 
	System.out.println("\nGoodbye!");
 	} 
 }
