package queue;

import linkedList.SingleLinkedList;

public class QueueByLinkedList {
	
	SingleLinkedList list;
	
	public QueueByLinkedList() {
		list = new SingleLinkedList();
	}
	
	public boolean isEmpty() {
		if (list.getHead() == null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void insertInQueue(int value) {
		if (list.getHead() == null) {
			list.createSingleLinkedList(value);
			System.out.println("Successfully created Queue: " + value);
		}else {
			// push a value on last of queue, update list tail too 
			list.InsertInLinkedList(value, list.getSize());
			System.out.println("Successfully inserted value: " + value);
		}
	}
	
	public void deleteInQueue() {
		if (isEmpty()) {
			System.out.println("Queue underflow error!");
		}else {
			System.out.println("Deleting: " + list.getHead().getValue());
			list.deletionOfNode(0);
		}
	}
	
	public void peek() {
		if (isEmpty()) {
			System.out.println("Queue underflow error!");
		}else {
			System.out.println("Peeking: " + list.getHead().getValue());
		}
	}
	
	public void deleteQueue() {
		list.setHead(null);
		list.setTail(null);
	}
	
}
