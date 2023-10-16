
/**
 * CET - CS Academic Level 3
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD.
 *  
 * @author Algonquin College
 * @author George Kriger
 *
 */

public class BinaryTree {
	/**
	 * root is the node of binary tree
	 */
	BinaryTreeNode root = null;
	BinaryTreeNode rootCopy = null;

	/**
	 * create new node with these contents and insert in the proper location
	 * using BST logic
	 * @param newData is the data you want to insert
	 */

	public void insertInTree(int newData) {
		if (root == null)
			root = new BinaryTreeNode(newData);
		else
			root.insert(newData);
	}

	/**
	 * Display tree contents using in order traversal
	 */
	public void displayInOrder() {
		displayInOrder(root);
	}
	
	/**
	 * Display tree contents using pre order traversal
	 */
	public void displayInPreorder() {
		displayInPreorder(root);
	}

	/**
	 * Start at subtree and display tree contents using in order traversal
	 * @param subRoot starting location in tree
	 */
	private void displayInOrder(BinaryTreeNode subRoot) {
		if (subRoot == null)
			return;
		displayInOrder(subRoot.getLeft());
		System.out.print(subRoot.getData() + " ");
		displayInOrder(subRoot.getRight());
	}
	
	/**
	 * Start at subtree and display tree contents using pre order traversal
	 * @param subRoot starting location in tree
	 */
	private void displayInPreorder(BinaryTreeNode subRoot) {
		if (subRoot == null)
			return;
		System.out.print(subRoot.getData() + " ");
		displayInPreorder(subRoot.getLeft());
		displayInPreorder(subRoot.getRight());
		
	}
	
	/**
	 * search method that uses recursion to search if number is there
	 * @param key is the number the user would like to search for
	 * @return either true or false if found
	 */
	public boolean search(int key) {
		
		//if search reaches end return not found
		if (rootCopy == null) return false;
		//if found
		if (rootCopy.getData() == key) return true;
		
		//use recursion to keep repeating thru the whole tree
		if (key < rootCopy.getData()) {
			rootCopy = rootCopy.getLeft();
			return search(key);
		} else {
			rootCopy = rootCopy.getRight();
			return search(key);
		}
	}
	
	/**
	 * displays found or not found rather than true or false
	 * @param found is whether the search returned true or false
	 */
	public void display(boolean found) {
		if (found == true) {
			//if found
			System.out.print("NUMBER WAS FOUND");
		} else {
			//not found
			System.out.print("NUMBER WAS NOT FOUND");
		}
		
	}
	
	/**
	 * creates copy of root to perform calculations
	 */
	public void reset() {
		//create copy of root
		rootCopy = root;
	}

}// class
