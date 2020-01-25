package queue;

public class QueueByArray {
	
	int[] arr;
	int topOfQueue;
	int beginingOfQueue;
	
	public QueueByArray(int size) {
		this.arr = new int[size];
		this.topOfQueue = -1;
		this.beginingOfQueue = -1;
		System.out.println("Successfully created an empty queue of size "+ size);
	}
	
	public boolean isFull() {
		if (topOfQueue == arr.length-1) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public boolean isEmpty() {
		if ((beginingOfQueue == -1) || (beginingOfQueue == arr.length)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public void InsertInQueue(int value) {
		if (isFull()) {
			System.out.println("Queue overflow error!");
		}else if (isEmpty()) { 
			beginingOfQueue = 0;
			topOfQueue++;
			arr[topOfQueue] = value;
			System.out.println("Successfully inserted " + value + " in the queue.");
		}else {
			topOfQueue++;
			arr[topOfQueue] = value;
			System.out.println("Successfully inserted " + value + " in the queue.");
		}
	}
	
	public void printQueue() {
		if ( isEmpty()) {
			System.out.println("Queue is empty!!");
		}else {
			System.out.println("Queue is...");
			for (int i = beginingOfQueue; i<topOfQueue; i++) {
				System.out.println(arr[i] + " ");
			}
			System.out.println();
		}
	}
	
	public void deletionOfQueue() {
		if (isEmpty()) {
			System.out.println("Queue underflow error!!");
		}else {
			System.out.println("Deleting value from Queue...");
			System.out.println("Deleted: " + arr[beginingOfQueue]);
			beginingOfQueue++;
			if (beginingOfQueue > topOfQueue) {
				beginingOfQueue = topOfQueue = -1;
			}
		}
	}
	
	public void peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty!");
		}else {
			System.out.println(arr[beginingOfQueue]);
		}
	}
	
	public void deleteQueue() {
		arr = null;
		System.out.println("Queue is successfully deleted!");
	}
	
}
