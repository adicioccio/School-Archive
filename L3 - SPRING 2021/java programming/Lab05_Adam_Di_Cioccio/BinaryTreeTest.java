/**
 * CET - CS Academic Level 3
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 * @author Algonquin College
 * @author George Kriger
 *
 */
public class BinaryTreeTest {

	/**
	 * main() method to test features of BinaryTree
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		//create new binary tree
		BinaryTree tree = new BinaryTree();

		//initialize array from template
		int [] array = {26, 38, 34, 33, 70, 11, 25, 72, 14, 51, 13, 77, 6, 40, 95, 84, 50, 35, 
				31, 54, 88, 74, 46, 86, 57, 39, 85, 80, 19, 92};
		
		//insert each value into the tree from initialized array
		for (int i = 0; i < array.length; i++) {
			tree.insertInTree(array[i]);
		}
		
		//display in order from least to greatest
		System.out.println("Tree displayed in-order traversal:");
		tree.displayInOrder();
		
		System.out.println();
		System.out.println();
		
		//display in order from least to greatest
		System.out.println("Tree displayed pre-order traversal:");
		tree.displayInPreorder();
		
		System.out.println();
		System.out.println();
		//call reset
		tree.reset();
		
		//call display function that takes in true or false from search
		System.out.print("NUMBER 26: ");
		tree.display(tree.search(26));
		
		System.out.println();
		//call reset
		tree.reset();
		
		//call display function that takes in true or false from search
		System.out.print("NUMBER 11: ");
		tree.display(tree.search(11));
		
		System.out.println();
		//call reset
		tree.reset();
		
		//call display function that takes in true or false from search
		System.out.print("NUMBER 38: ");
		tree.display(tree.search(38));
		
		System.out.println();
		//call reset
		tree.reset();
		
		//call display function that takes in true or false from search
		System.out.print("NUMBER 100: ");
		tree.display(tree.search(100));
		
		
		
	}//main()

}// class
