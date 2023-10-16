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

class TestDLLApp {
	
	public static void main(String[] args) {
		
		//make new linked list called newLL
		DoublyLinkedList newLL = new DoublyLinkedList();
		
		//insert 20, 42, 63, 93 at the front of linked list Hint => call relevant method
		newLL.insertFirst(20);
		newLL.insertFirst(42);
		newLL.insertFirst(63);
		newLL.insertFirst(93);
		
		//insert 9, 34, 51 at the rear of linked list Hint => call relevant method
		newLL.insertLast(9);
		newLL.insertLast(34);
		newLL.insertLast(51);
		
		//display data elements in the linked list from first to last:		Hint => call printForwards() created in PART 2.
		System.out.print("LinkedList: [From first to last] -> ");
		newLL.printForwards();
		
		//display data elements in the linked list from last to first:		Hint => call printBackwards() created in PART 2.
		System.out.print("\nLinkedList: [From last to first] -> ");
		newLL.printBackwards();
		
		//delete first item		Hint: call relevant method
		newLL.deleteFirstNode();
		
		//delete last item
		newLL.deleteLastNode();
		
		//delete item with number 9:   Hint => call searchAndDelete(9) created in PART 2
		newLL.searchAndDelete(9);
        
		//display data elements in the linked list from first to last
		System.out.print("\nLinkedList: [From first to last] -> ");
		newLL.printForwards();  
		
		//insert 69 after 20
		newLL.insertAfter(20, 69);
		
		//insert 77 after 34
		newLL.insertAfter(34, 77);
			 
		//display data elements in the linked list from first to last
		System.out.print("\nLinkedList: [From first to last] -> ");
		newLL.printForwards();  

	} // end of main() method
} // end class TestDLLApp
