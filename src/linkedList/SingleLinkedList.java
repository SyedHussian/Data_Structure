package linkedList;

import node.SingleNode;;

public class SingleLinkedList {
	private SingleNode head;
	private SingleNode tail;
	private int size; // denotes size of list
	
	public SingleNode createSingleLinkedList(int nodeValue) {
		head = new SingleNode(); 				// creating a new head object
		SingleNode node = new SingleNode();		// creating a new node object
		node.setValue(nodeValue);				// putting the value in node
		node.setNext(null);						
		head = node;
		tail = node;
		size = 1; 								// size = 1
		return head;
	}
	
	public SingleNode getHead() {
		return head;
	}
	public void setHead(SingleNode head) {
		this.head = head;
	}
	
	public SingleNode getTail() {
		return tail;
	}
	public void setTail(SingleNode tail) {
		this.tail = tail;
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	//checking if head is not null
	public boolean existsLinkedList() {
		return head != null;
	}
	
	public void InsertInLinkedList(int nodeValue, int location) {
		SingleNode node = new SingleNode();
		node.setValue(nodeValue);
		if (!existsLinkedList()) {		// List does not exist
			System.out.println("The linked list does not exist!!");
			return;
		}
		else if (location == 0) {		// insert at the beginning 
			node.setNext(head);
			head = node;
		}
		else if (location >= size) {	// insert at the end
			node.setNext(null);
			tail.setNext(node);
			tail = node;
		}
		else {							// insert in a specified location
			SingleNode tempNode = head;
			int index = 0;
			while (index < location -1) {	// loop till we reached a specific location
				tempNode = tempNode.getNext();
				index++;
			}
			SingleNode nextNode = tempNode.getNext();
			tempNode.setNext(node);
			node.setNext(nextNode);
		}
		setSize(getSize()+1);
	}
	
	public void traverseLinkedList() {
		if (existsLinkedList()) {
			SingleNode tempNode = head;
			System.out.println("Printing the list: ");
			for (int i = 0; i<getSize(); i++) {
				System.out.print(tempNode.getValue());
				if (i != getSize() - 1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.getNext();
			}
		}
		else {
			System.out.println("Linked list does not exist!");
		}
		System.out.println("\n");
	}
	
	public void deleteLinkedList() {
		System.out.println("\n\nDeleting Linked List\n");
		head = null;
		tail = null;
		System.out.println("Linked List successfully deleted!\n");
	}
	
	public boolean searchNode(int nodeValue) {
		if (existsLinkedList()) {
			SingleNode tempNode = head;
			for(int i = 0; i<getSize(); i++) {
				if(tempNode.getValue() == nodeValue) {
					System.out.println("Found the node at the location " + i + "\n");
					return true;
				}
				tempNode = tempNode.getNext();
			}
		}
		System.out.println("Node not found! \n");
		return false;
	}
	
	public void deletionOfNode(int location) {
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist");
			return;
		}
		else if (location == 0) {
			head = head.getNext();
			setSize(getSize()-1);
			if (getSize() == 0) {
				tail = null;
			}
		}
		else if (location >= getSize()) {
			SingleNode tempNode = head;
			for (int i = 0; i<size-1; i++) {
				tempNode = tempNode.getNext();
			}
			if (tempNode == head) {
				head = tail = null;
				setSize(getSize()-1);
				return;
			}
			tempNode.setNext(null);
			tail=tempNode;
			setSize(getSize()-1);
		}
		else {
			SingleNode tempNode = head;
			for (int i=0; i<location-1; i++) {
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(tempNode.getNext().getNext());
			setSize(getSize()-1);
		}
	}	
}
