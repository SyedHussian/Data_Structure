package linkedList;

public class CircularSingleLinkedListMain {
	public static void main(String[] args) {
		System.out.println("Circular Single Linked List: \n");
		CircularSingleLinkedList list = new CircularSingleLinkedList();
		list.createCircularSingleLinkedList(5);
		list.InsertInLinkedList(10, 1);
		list.InsertInLinkedList(20, 2);
		list.InsertInLinkedList(30, 3);
		list.InsertInLinkedList(40, 4);
		
		System.out.println("Linked List now: ");
		list.traverseLinkedList();
	    
		list.InsertInLinkedList(35, 4);
		list.traverseLinkedList();
		
		list.InsertInLinkedList(1, 0);
		list.traverseLinkedList();
		
		list.InsertInLinkedList(100, 10);
		list.traverseLinkedList();
		
		
		list.printHeadUsingTail();
		
		System.out.println("Searching the node having value 40: ");
		list.searchNode(40);
		
		System.out.println("\n\nSearching the node having value 200: ");
		list.searchNode(200);
		
		
		System.out.println("\n\nDeleting the node having location = 2: ");
		System.out.println("Before deletion...");
		list.traverseLinkedList();
		list.deletionOfNode(2);
		System.out.println("After deletion...");
		list.traverseLinkedList();
		
		
		System.out.println("\n\nDeleting the node having location = 0: ");
		System.out.println("Before deletion...");
		list.traverseLinkedList();
		list.deletionOfNode(0);
		System.out.println("After deletion...");
		list.traverseLinkedList();
		
		
		System.out.println("\n\nDeleting the node having location = 15: ");
		System.out.println("Before deletion...");
		list.traverseLinkedList();
		list.deletionOfNode(15);
		System.out.println("After deletion...");
		list.traverseLinkedList();
		
		
		System.out.println("\n\nDeleting the node having location = 15: ");
		System.out.println("Before deletion...");
		list.traverseLinkedList();
		list.deletionOfNode(15);
		System.out.println("After deletion...");
		list.traverseLinkedList();
		
		
		list.deleteLinkedList();
		list.traverseLinkedList();
	}

}
