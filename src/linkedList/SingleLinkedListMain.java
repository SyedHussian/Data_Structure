package linkedList;

public class SingleLinkedListMain {
	
	public static void main(String[] args) {
		System.out.println("Single Linked List: \n");
		SingleLinkedList linkedList = new SingleLinkedList();
		linkedList.createSingleLinkedList(5);
		
		for (int i=0 ; i<5; i++) {
			linkedList.InsertInLinkedList(i*10, i);
		}
		linkedList.traverseLinkedList();
		
		linkedList.InsertInLinkedList(100000, 2);
		linkedList.traverseLinkedList();
		
		System.out.println("\nDeleteting the node 2 ...");
		linkedList.deletionOfNode(2);
		linkedList.traverseLinkedList();

		System.out.println("\nSearching the node having 40 ...");
		linkedList.searchNode(40);
		
		System.out.println("\nSearching the node having 100000 ...");
		linkedList.searchNode(100000);
		
		System.out.println("\nDeleting the entire linkedList: ");
		linkedList.deleteLinkedList();
		linkedList.traverseLinkedList();
		
		
	}

}
