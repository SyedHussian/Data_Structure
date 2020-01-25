package linkedList;

import node.SingleNode;

public class CircularSingleLinkedList {
	private SingleNode head;
	private SingleNode tail;
	private int size;
	
	public SingleNode createCircularSingleLinkedList(int nodeValue) {
		head = new SingleNode();
		SingleNode node= new SingleNode();
		node.setValue(nodeValue);
		node.setNext(null);
		head = node;
		tail = node;
		size = 1;
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
	
	public boolean existsLinkedList() {
		return head != null;
	}
	
	public void InsertInLinkedList(int nodeValue, int location) {
		SingleNode node = new SingleNode();
		node.setValue(nodeValue);
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist!");
			return;
		}
		else if (location == size) {
			node.setNext(head);
			head = node;
			tail.setNext(node); // tail 
		}
		else if (location >= size) {
			tail.setNext(node);
			tail = node;
			tail.setNext(head);
		}
		else {
			SingleNode tempNode = head;
			int index = 0;
			while (index < location-1) {
				tempNode = tempNode.getNext();
				index++;
			}
			node.setNext(tempNode.getNext());
			tempNode.setNext(node);
		}
		size++;
	}
	
	public void traverseLinkedList() {
		if (!existsLinkedList()) {
			System.out.println("Linked list does not exists!");
			return;
		}
		else {
			SingleNode tempNode = head;
			for (int i=0; i<size; i++) {
				System.out.print(tempNode.getValue());
				if (i != size-1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.getNext();
			}
			System.out.println("\n");
		}
	}
	
	public void printHeadUsingTail() {
		if(!existsLinkedList()) {
			System.out.println("Link list does not exist!");
			return;
		}
		else {
			System.out.println("Print Tail....");
			System.out.println(tail.getValue());
			
			System.out.println("Printing Head using Head reference...");
			System.out.println(head.getValue());
			
			System.out.println("Printing Head using Tail reference...");
			System.out.println(tail.getNext().getValue());
		}
	}
	
	public void deleteLinkedList() {
		System.out.println("\n\nDeleting Linked List...");
		head=null;
		if(tail == null) {
			System.out.println("Linked list is already deleted, nothing to delete!");
		}
		else {
			tail.setNext(null);
			tail = null;
			System.out.println("Linked list is deleted successfully!");
		}
	}
	
	public boolean searchNode(int nodeValue) {
		if (!existsLinkedList()) {
			System.out.println("Linked List does not exists!");
			return false;
		}
		else {
			SingleNode tempNode = head;
			for (int i=0; i< size; i++) {
				if (tempNode.getValue() == nodeValue) {
					System.out.print("Found the node at location: " + i);
					return true;
				}
				tempNode = tempNode.getNext();
			}
			System.out.println("Node not found!");
			return false;
		}
	}
	
	public void deletionOfNode(int location) {
		if (!existsLinkedList()) {
			System.out.println("Linked list does not exists!");
			return;
		}
		else if (location == 0) {
			head = head.getNext();
			tail.setNext(head);
			setSize(getSize()-1);
			if (getSize() == 0) {
				tail = null;
			}
		}
		else if (location >= size) {
			SingleNode tempNode = head;
			for (int i=0; i<size-1; i++) { // index 0 means size 1; 
				tempNode = tempNode.getNext();
			}
			if (tempNode == head) {
				tail = head = null;
				setSize(getSize()-1);
				return;
			}
			tempNode.setNext(head);
			tail = tempNode;
			setSize(getSize() - 1);
		}
		else {
			SingleNode tempNode = head;
			for (int i = 0; i<location-1; i++) {
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(tempNode.getNext().getNext());
			setSize(getSize()-1);
		}
	}
}
