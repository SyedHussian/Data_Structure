package linkedList;

import node.DoubleNode;

public class DoubleCircularLinkedList {
	private DoubleNode head;
	private DoubleNode tail;
	private int size;

	public DoubleNode getHead() {
		return head;
	}
	public void setHead(DoubleNode head) {
		this.head = head;
	}
	
	public DoubleNode getTail() {
		return tail;
	}
	public void setTail(DoubleNode tail) {
		this.tail = tail;
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public DoubleNode createDoubleLinkedList(int nodeValue) {
		head = new DoubleNode();
		DoubleNode node = new DoubleNode();
		node.setValue(nodeValue);
		node.setNext(null);
		node.setPrev(null);
		head = node;
		tail = node;
		size =1;	
		return head;
	}
	
	public boolean existsInLinkedList() {
		return head != null;
	}
	
	public void insertInLinkedList(int nodeValue, int location) {
		DoubleNode node = new DoubleNode();
		node.setValue(nodeValue);
		if (!existsInLinkedList()) {
			System.out.println("Linked list does not exists!");
			return;
		}
		else if (location == 0) {
			node.setNext(head);
			node.setPrev(tail);
			head.setPrev(node);
			tail.setNext(node);
			head = node;
		}
		else if (location >= size) {
			node.setNext(head);
			node.setPrev(tail);
			head.setPrev(node);
			tail.setNext(node);
			tail = node;	
		}
		else {
			DoubleNode tempNode = head;
			for (int i=0; i<location-1; i++) {
				tempNode = tempNode.getNext();
			}
			node.setPrev(tempNode);
			node.setNext(tempNode.getNext());
			tempNode.setNext(node);
			node.getNext().setPrev(node);
		}
		size++;
	}
	
	public void traverseLinkedList() {
		if (!existsInLinkedList()) {
			System.out.println("Linked list does not exists!");
			return;
		}
		else {
			DoubleNode tempNode = head;
			for (int i=0; i<size; i++) {
				System.out.print(tempNode.getValue());
				if(i != size-1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.getNext();
			}
		}
		System.out.println();
	}
	
	public void traverseLinkedListInReverseOrder() {
		if (!existsInLinkedList()) {
			System.out.println("Linked List does not exists !");
			return;
		}
		else {
			DoubleNode tempNode = tail;
			System.out.println("\nPrinting Linked list in reverse order...");
			for (int i = 0; i < size; i++) {
				System.out.print(tempNode.getValue());
				if (i != size-1) {
					System.out.print(" <- ");
				}
				tempNode = tempNode.getPrev();
			}
		} 
	}
	
	public void printHeadUsingTail() {
		if (!existsInLinkedList()) {
			System.out.println("Linked list does not exists!");
			return;
		}
		else {
			System.out.println("\n\nPrinting Tail...");
			System.out.println(tail.getValue());

			System.out.println("\nPrinting Head using Head reference...");
			System.out.println(head.getValue());

			System.out.println("\nPrinting Head using Tail reference...");
			System.out.println(tail.getNext().getValue());
		}
	}
	
	
	public void deleteLinkedList() {
		System.out.println("\n\nDeleting Linked list...");
		if (tail == null) {
			System.out.println("Linked list already deleted!");
			return;
		}
		else {
			head.setPrev(null);
			head.setNext(null);
			head = null;
			tail = null;
			System.out.println("Linked list is successfully deleted!");
		}
	}
	
	public boolean searchNode(int nodeValue) {
		if (!existsInLinkedList()) {
			System.out.println("Linked list not found!");
			return false;
		}
		else {
			DoubleNode tempNode = head;
			traverseLinkedList();
			for (int i=0; i<size; i++) {
				if (tempNode.getValue() == nodeValue) {
					System.out.println("Found the node at location: " + i);
					return true;
				}
				tempNode = tempNode.getNext();
			}
			System.out.println("Node not found!!");
			return false;
		}
	}
	
	public void deletionOfNode(int location) {
		if (!existsInLinkedList()) {
			System.out.println("Linked list does not exists!");
			return;
		}
		else if (location == 0) {
			if (getSize() == 1) {
				head.setNext(null);
				head.setPrev(null);
				head = tail = null;
				setSize(getSize()-1);
				return;
			}
			else {
				head = head.getNext();
				head.setPrev(tail);
				tail.setNext(head);
				setSize(getSize()-1);
			}
		}
		else if (location >= getSize()) {
			if (getSize() == 1) {
				head.setNext(null);
				head.setPrev(null);
				tail = head = null;
				setSize(getSize()-1);
				return;
			}
			tail = tail.getPrev();
			tail.setNext(head);
			head.setPrev(tail);
			setSize(getSize()-1);
		}
		else {
			DoubleNode tempNode = head;
			for (int i=0; i<location-1; i++) {
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(tempNode.getNext().getNext());
			tempNode.getNext().setPrev(tempNode);
			setSize(getSize()-1);
		}
	}
	
	
	
	
	
}
