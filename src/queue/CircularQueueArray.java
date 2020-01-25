package queue;

public class CircularQueueArray {
	
	int[] arr;
	int topOfQueue;
	int size;
	int start;
		
	public CircularQueueArray(int size) {
		this.arr = new int[size];
		this.size = size;
		this.topOfQueue = -1;
		this.start = -1;
		System.out.println("Successfully created an empty queue of size " + size);
	}

	public void initializeStartOfArray() {
		if (start == -1) {
			start = 0;
		}
	}
		
	public boolean isFull() {
		if (topOfQueue+1 == start) {
			return true;
		}else if ((start ==0) && (topOfQueue+1 == size)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isEmpty() {
		if (topOfQueue ==-1) {
			return true;
		}
		else {
			return false;
		}
	}

	public void insertInQueue(int value) {
		if (arr == null){
			System.out.println("Queue is not yet created. Please create one first!");
		}else if (isFull()) {
			System.out.println("Queue overflow error!");
		}else {
			initializeStartOfArray();
			if (topOfQueue+1 == size) {
				topOfQueue = 0;
			}else {
				topOfQueue++;
			}
			arr[topOfQueue] = value;
			System.out.println("Successfully inserted " + value);
		}
	}
	
	public void printQueue() {
		System.out.println("Queue now....");
		for (int i=0; i<size; i++) {
			System.out.println(arr[i] + " ");
		}
		System.out.println("\nStart = "+start);
		System.out.println("\nEnd = " + topOfQueue);
	}

	public void deletionOfQueue() {
		if (isEmpty()) {
			System.out.println("Queue underflow error!!");
		}else {
			System.out.println("\n---------------------------");
			System.out.println("Before Deletion.. ");printQueue();
			System.out.println("Deleting value from queue...");
			System.out.println("Deleting: " + arr[start]);
			arr[start] = 0;
			if (start == topOfQueue) {
				start = topOfQueue = -1;
			}else if (start+1 == size) {
				start = 0;
			}else {
				start++;
			}
		}
		System.out.println("After Deleting.."); printQueue();
		System.out.println("-----------------------------------------");
	}
	
	public void peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty!");
		}else {
			System.out.println("\nPeeking value from queue....");
			System.out.println(arr[start]);
		}
	}
		
	public void deleteStack() {
		System.out.println("\n Deleting the entire Queue");
		arr = null;
		System.out.println("Successfully deleted the entire Queue");
	}
	
}
