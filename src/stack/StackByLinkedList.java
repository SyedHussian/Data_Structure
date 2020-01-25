package stack;

import linkedList.SingleLinkedList;
//import node.SingleNode;

public class StackByLinkedList {
	SingleLinkedList list;
	
	public StackByLinkedList() {
		list = new SingleLinkedList();
	}
	
	public boolean isEmpty() {
		if (list.getHead() == null) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	public void push(int value) {
		if (list.getHead() == null) {
			list.createSingleLinkedList(value);
		}else {
			list.InsertInLinkedList(value, 0);
		}
		System.out.println("Inserted "+ value + " in Stack!");
	}
	
	public void pop() {
//		int value =-1;
		if (isEmpty()) {
			System.out.println("Stack underflow error!");
		}else {
			System.out.println("Poping value in stack: "+list.getHead().getValue());
			list.deletionOfNode(0);
		}
	}
	
	public void peek() {
		if (isEmpty()) {
			System.out.println("The stack is empty!");
		}else {
			System.out.println("Peeking in stack: " + list.getHead().getValue());
		}
	}
	
	public void deleteStack() {
		list.setHead(null);
	}

}
