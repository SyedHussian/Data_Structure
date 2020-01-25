package heap;

public class HeapByArray {
	int[] arr;
	int sizeOfTree;
	
	public HeapByArray(int size){
		//We are adding 1 here so that first cell of the array can be left blank all the time. 
		//This is eliminate problem of array starting from index 0.
		arr = new int[size + 1];
		this.sizeOfTree = 0;
		System.out.println("Empty Heap has been created!");
	}
	
	public int sizeOfArray() {
		return arr.length;
	}
	
	public int sizeOfTree() {
		System.out.println("Size of Tree: " + sizeOfTree);
		return sizeOfTree;
	}
	
	public boolean isHeapEmpty() {
		if (sizeOfTree <= 0) {
			System.out.println("Tree is empty!");
			return true;
		}
		else {
			System.out.println("Tree is not empty!");
			return false;
		}
	}
	
	public void deleteHeap() {
		arr = null;
		System.out.println("Heap has been deleted!");
	}
	
	
	public void HeapifyBottomToTop(int index) {
		int parent = index/2;
		// We are at root of the tree. 
		//Hence no more Heapifying is required.
		if (index <= 1) {
			return;
		}
		
		if (arr[index] < arr[parent]) {
			int tmp = arr[index];
			arr[index] = arr[parent];
			arr[parent] = tmp;
		}
		HeapifyBottomToTop(parent);
	}
	
	
	public void HeapifyTopToBottom(int index) {
		int left = index*2;
		int right = (index*2)+1;
		int smallestChild = 0;
		
		if (sizeOfTree < left) {
			return;
		}
		else if (sizeOfTree == left) {
			if (arr[index] > arr[left]) {
				int tmp = arr[index];
				arr[index] = arr[left];
				arr[left] = tmp;
			}
			return;
		}
		else { // if both children are there
			if (arr[left] < arr[right]) { // finding the smallest
				smallestChild = left;
			}
			else {
				smallestChild = right;
			}
			// if parent is greater then the smallest children then swap
			if (arr[index] > arr[smallestChild]) { 
				int tmp = arr[index];
				arr[index] = arr[smallestChild];
				arr[smallestChild] = tmp;
			}
		}
		HeapifyTopToBottom(smallestChild);
	}
	
	
	
	public void levelOrder() {
		System.out.println("Printing all the elements of this Heap...");
		for (int i = 1; i <= sizeOfTree; i++) {
			System.out.print(arr[i] + " ");
		} 
		System.out.println("\n");
	}
	
	public void insertInHeap(int value) {
		//Doing +1 because sizeOfTree always points to the last occupied cell of the array 
		System.out.println("Inserting "+value+" in Heap...");
		arr[sizeOfTree+1] = value;
		sizeOfTree++;
		HeapifyBottomToTop(sizeOfTree);
		System.out.println("Inserted "+value+" successfully in Heap!");
		levelOrder();
	}
	
	public void peek() {
		if (sizeOfTree == 0) {
			System.out.println("Heap is empty!");
		}
		else {
			System.out.println("Head of the Heap is: " + arr[1]);
		}
	}
	
	public int extractHeadOfHeap() {
		if (sizeOfTree == 0) {
			System.out.println("Heap is empty!");
			return -1;
		}
		else {
			System.out.println("Head of the Heap is "+arr[1]);
			System.out.println("Extracting it now...");
			int extractedValue = arr[1];
			arr[1] = arr[sizeOfTree];
			sizeOfTree--;
			HeapifyTopToBottom(1);
			System.out.println("Successfully extracted value from Heap!");
			levelOrder();
			return extractedValue;
		}
	}
	
}
