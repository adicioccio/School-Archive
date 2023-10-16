/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * Main class that contains the menu system and main method
 * Student Name: Adam Di Cioccio
 * Student Number: 041019241
 * Section #: 304
 * Course: CST8130 - Data Structures
 * Professor: Murtuza Marketwala 
 */

// package
package LinkedList;

/**
 * @author Adam Di Cioccio
 * node class for linked list
 */
class Node {	
	// declare data of type node
	private String code;
	private String name;
	private int enrollment;
	private int waitlist;
	/**
	 * next node in list
	 */
	Node next;
	
	/**
	 * default constructor
	 * @param c code
	 * @param n name
	 * @param e enrollment
	 * @param w wait list
	 */
	Node (String c, String n, int e, int w) {
		this.code = c;
		this.name = n;
		this.enrollment = e;
		this.waitlist = w;
	}
	
	/**
	 * displays code, name, enrollment and wait list in specific format
	 */
	public void display() {
		System.out.printf("%10s %53s %12s %12s\n", code, name, enrollment, waitlist);
		
	}
	
	/**
	 * getter that returns enrollment
	 * @return enrollment
	 */
	public int getEnroll() {
		return enrollment;
	}
	
	/**
	 * getter that returns wait list
	 * @return wait list
	 */
	public int getWaitlist() {
		return waitlist;
	}
}

/**
 * @author Adam Di Cioccio
 * linked list class that contains methods to be performed
 */
public class LinkedList {
	
	private Node head;
	
	
	/**
	 * default constructor
	 */
	public LinkedList() {
		head = null;
	}
	
	/**
	 * checks if head is null / list is empty
	 * @return true or false
	 */
	public boolean isEmpty() {
		return head == null;
	}
	
	/**
	 * takes in 4 parameters and inserts into a node then into the list
	 * @param c code
	 * @param n name
	 * @param e enrollment
	 * @param w wait list
	 */
	public void insert(String c, String n, int e, int w) {
		// create new node with set attributes
		Node newNode = new Node(c, n, e, w);
		// set next node to null
		newNode.next = null;
		
		// check if empty
		if (isEmpty()) {
			// set head
			head = newNode;
		} else {
			// go to next node
			Node last = head;
        	while (last.next != null) {
        		last = last.next;
        	}

        	// insert new node at next
        	last.next = newNode;
		}
			
			
	}
	
	/**
	 * loops through list calling display function
	 */
	public void print() {
		// set temporary node at head
		Node node = head;
		
		// loop through list
		while (node != null) {
			// call display function
			node.display();
			// go to next
			node = node.next;	
		}
	}
	
	/**
	 * get max enrollment method
	 */
	public void getMaxEnrollment() {
		// set temporary node at head
		Node node = head;
		// set temporary node for max
		Node maxNode = null;
		// variable for max
		int max = 0;
		
		// loop through list
		while (node != null) {
			// check if node enrollment is higher than previous max
			if (node.getEnroll() > max) {
				// set new max
				max = node.getEnroll();
				// set new node
				maxNode = node;
			}
			// go to next node
			node = node.next;	
		}
		
		// print message + display max node
		System.out.println("Course with maximum enrollment: ");
		maxNode.display();
	}
	
	/**
	 * get min wait list method
	 */
	public void getMinWaitlist() {
		// set temporary node at head
		Node node = head;
		// set temporary node for min
		Node minNode = null;
		// variable for min
		int min = 999;
		
		// loop through list
		while (node != null) {
			// check if node enrollment is lesser than previous min
			if (node.getWaitlist() < min) {
				// set new min
				min = node.getWaitlist();
				// set new node
				minNode = node;
			}
			// go to next node
			node = node.next;	
		}
		
		// print message + display min node
		System.out.println("Course with minimum waitlist: ");
		minNode.display();
	}
	
	
	
	
}
