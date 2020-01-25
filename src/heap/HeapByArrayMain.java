package heap;


public class HeapByArrayMain {

	public static void main(String[] args) {
		System.out.println("Creating a blank Heap!");
		HeapByArray heap = new HeapByArray(10);
		
		for (int i = 100; i>10; i=i-10) {
			heap.insertInHeap(i);
		}
		
		heap.extractHeadOfHeap();
		
		heap.insertInHeap(110);
		heap.extractHeadOfHeap();
	}

}
