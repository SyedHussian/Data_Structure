package sorting;

public class SortMain {
	
	public static void main(String[] args) {
		
		Sort bSort = new Sort();
		int[] arr = { 10, 5, 30, 15, 50, 6 };
		System.out.println("Array to be sorted...");
		bSort.printArray(arr);

		bSort.bubbleSort(arr);

		System.out.println("Sorted Array...");
		bSort.printArray(arr);

	}
	
}
