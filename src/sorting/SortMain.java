package sorting;

public class SortMain {
	
	public static void main(String[] args) {
		
		final long start1 = System.nanoTime();
		
		System.out.println("Bubble Sort........");
		Sort sort = new Sort();
		int[] bArr = { 10, 5, 30, 15, 50, 6 };
		System.out.println("Array to be sorted using Bubble sort...");
		sort.printArray(bArr);

		
		System.out.println("Sorted Array using Bubble sort...");
		sort.bubbleSort(bArr);
		sort.printArray(bArr);
		
		final long duration1 = System.nanoTime() - start1;
		System.out.println("Time taken in nano seconds: "+ duration1);
		System.out.println("-----------------------------");
		
		final long start2 = System.nanoTime();
		System.out.println("Selection Sort........");
		int[] sArr = { 10, 5, 30, 15, 50, 6 };
		
		System.out.println("Array to be sorted using Selection sort...");
		sort.printArray(sArr);

		System.out.println("Sorted Array using Selection sort...");
		sort.seletionSort(sArr);
		sort.printArray(sArr);
		
		final long duration2 = System.nanoTime() - start2;
		System.out.println("Time taken in nano seconds: "+ duration2);
		System.out.println("-----------------------------");
		
		final long start3 = System.nanoTime();
		System.out.println("Insertion Sort........");
		int[] iArr = { 10, 5, 30, 15, 50, 6 };
		
		System.out.println("Array to be sorted using Insertion sort...");
		sort.printArray(iArr);

		System.out.println("Sorted Array using Insertion sort...");
		sort.insertionSort(iArr);
		sort.printArray(iArr);
		
		final long duration3 = System.nanoTime() - start3;
		System.out.println("Time taken in nano seconds: "+ duration3);
		System.out.println("-----------------------------");

	}
	
}
