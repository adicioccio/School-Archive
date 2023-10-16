/**
 * Processing data using Doubly Linked List CST8130 Data Structures,
 * Computer Engineering Technology-Computer Science: Level 3
 * 
 * Professor: James Mwangi PhD
 * 
 * 
 *          Student Name: Adam Di Cioccio
 * 			Student ID: 041019241
 * 
 */

//===================== class starts here=============================
class Node {
	@SuppressWarnings("javadoc")
	public int mData; // data item
	@SuppressWarnings("javadoc")
	public Node next; // next node in list
	@SuppressWarnings("javadoc")
	public Node previous; // previous node in list
/**
 * Node default constructor
 * @param d is the data the user would like to put into the node
 */
// -------------------------------------------------------------

	public Node(int d) // constructor
	{
		mData = d;
	}

// -------------------------------------------------------------
	// display this node data
	/**
	 * displays the mData in selected node
	 */
	public void displayNode() {
		System.out.print(mData + " ");
	}
// -------------------------------------------------------------
} // end class Node

//===================== class design starts here =============================
/**
 * main class for the linked list
 * @author james mwangi and adam di cioccio
 *
 */
class DoublyLinkedList {
	//declare first and last nodes
	private Node first;
	private Node last;

// -------------------------------------------------------------
	/**
	 * default constructor
	 */
	public DoublyLinkedList() {
		first = null;
		last = null;
	}

// -------------------------------------------------------------
	/**
	 * checks if empty
	 * @return first equal null
	 */
	public boolean isEmpty() {
		return first == null;
	}

// -------------------------------------------------------------
	/**
	 * insert value at beginning of linked list
	 * @param num is the value you want to set
	 */
	public void insertFirst(int num) {
		Node newNode = new Node(num);

		if (isEmpty())
			last = newNode;
		else
			first.previous = newNode;
		newNode.next = first;
		first = newNode;
	}

// -------------------------------------------------------------
	/**
	 * insert value at the end of linked list
	 * @param num is the value you want to set
	 */
	public void insertLast(int num) {
		Node newNode = new Node(num);
		if (isEmpty())
			first = newNode;
		else {
			last.next = newNode;
			newNode.previous = last;
		}
		last = newNode;
	}


	/**
	 * insert newNumber just after numToFind
	 * @param numToFind is the value before the newly inserted node
	 * @param newNumber is the value you are setting
	 * @return true or false
	 */
	public boolean insertAfter(int numToFind, int newNumber) { // (assumes non-empty list)
		Node current = first;
		while (current.mData != numToFind) {
			current = current.next;
			if (current == null)
				return false;
		}
		Node newNode = new Node(newNumber);

		if (current == last) {
			newNode.next = null;
			last = newNode;
		} else {
			newNode.next = current.next;

			current.next.previous = newNode;
		}
		newNode.previous = current;
		current.next = newNode;
		return true;
	}
	
//------------------------------------------------// delete first node

	/**
	 * deletes the first note in a list
	 * @return node
	 */
	public Node deleteFirstNode() {
		
		//create new temporary node
		Node node = first;
		//set first node equal to the next node in the list
		first = first.next;
		
		//check if there is only one node in list
		if (first != null) {
			//set previous node to null (delete)
			first.previous = null;
		} else {
			//set last node to null
			last = null;
		}
		
		//return the deleted first node
		return node;
	}

// -----------------------------------------------// delete last node

	/**
	 * deletes the last node in a list
	 * @return node
	 */
	public Node deleteLastNode() {
		
		//create new temporary node
		Node node = last;
		//set first node equal to the next node in the list
		last = last.previous;
		
		//check if there is only one node in list
		if (last != null) {
			//set next last node to null (delete)
			last.next = null;
		} else {
			//set first node to null
			first = null;
		}
				
		//return the deleted last note--
		return node;
	}

// -------------------------------------------------------------

// -----------------------------------------finds, deletes and returns the node that contains the given int value
	/**
	 * search and delete a specific value in list
	 * @param number is the number you want to search for to delete
	 * @return null
	 */
	public Node searchAndDelete(int number) {
		//empty list
		if (first == null) 
			return null;
		//if first is the number
		if (first.mData == number) {
			first = first.next;
			return null;
		}
		//create temporary node
		Node current = first;
		
		//loop through the list
		while (current.next != null) {
			//if data in next node is the number
			if (current.next.mData == number) {
				//set next node equal to the node 2 nodesd ahead
				current.next = current.next.next;
				return null;
			}
			//go onto the next node
			current = current.next;
		}
		
		return null;
		
	}

// -------------------------------------------display data from first node to last node
	/**
	 * print out each value starting from first
	 */
	public void printForwards() {
		Node node = first;
		
		while (node != null) {
			node.displayNode();
			node = node.next;	
		}
	}

// -------------------------------------------display data from last node  to first node
	/**
	 * print out each value starting from last
	 */
	public void printBackwards() {
		Node node = last;
		
		while (node != null) {
			node.displayNode();
			node = node.previous;	
		}

	}
// -------------------------------------------------------------
} // end class DoublyLinkedList

// ==========================================================
