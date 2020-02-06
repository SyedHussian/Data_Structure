package sorting;

import java.util.Random;

public class SortMain {
	
	public static void main(String[] args) {
		Sort sort = new Sort();
		
//		final long start1 = System.nanoTime();
		
//		
//		System.out.println("Bubble Sort........");

//		int[] bArr = { 10, 5, 30, 15, 50, 6 };
//		System.out.println("Array to be sorted using Bubble sort...");
//		sort.printArray(bArr);
//
//		
//		System.out.println("Sorted Array using Bubble sort...");
//		sort.bubbleSort(bArr);
//		sort.printArray(bArr);
//		
//		final long duration1 = System.nanoTime() - start1;
//		System.out.println("Time taken in nano seconds: "+ duration1);
//		System.out.println("-----------------------------");
//		
//		final long start2 = System.nanoTime();
//		System.out.println("Selection Sort........");
//		int[] sArr = { 10, 5, 30, 15, 50, 6 };
//		
//		System.out.println("Array to be sorted using Selection sort...");
//		sort.printArray(sArr);
//
//		System.out.println("Sorted Array using Selection sort...");
//		sort.seletionSort(sArr);
//		sort.printArray(sArr);
//		
//		final long duration2 = System.nanoTime() - start2;
//		System.out.println("Time taken in nano seconds: "+ duration2);
//		System.out.println("-----------------------------");
//		
//		final long start3 = System.nanoTime();
//		System.out.println("Insertion Sort........");
//		int[] iArr = { 10, 5, 30, 15, 50, 6 };
//		
//		System.out.println("Array to be sorted using Insertion sort...");
//		sort.printArray(iArr);
//
//		System.out.println("Sorted Array using Insertion sort...");
//		sort.insertionSort(iArr);
//		sort.printArray(iArr);
//		
//		final long duration3 = System.nanoTime() - start3;
//		System.out.println("Time taken in nano seconds: "+ duration3);
//		System.out.println("-----------------------------");
//		

		//--------------------------- Bucket Sorting ----------------//

//		int arr[] = new int[100];
//		
//		//Generating 100 random numbers in the range of 0-100
//		Random random = new Random();
//		for(int i=0;i<100;i++) {
//			arr[i] = random.nextInt(100)+100;
//		}
//		
//		
//		//Passing this array to BucketSort method
//		Sort bs = new Sort(arr);
//		System.out.println("Array before Sorting: ");
//		bs.printArray(arr);
//		bs.bucketSort(arr);
//		
//		
//		System.out.println("\n\nArray after Sorting: ");
//		bs.printArray(arr);
		
		//--------------------------- Merge Sorting ----------------//

//		int array[] = {10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8};
//		
//		System.out.println("User entered Array: ");
//		sort.printArray(array);
//		
//		long start = System.nanoTime();
//		sort.mergeSort(array, 0, array.length-1);
//		long end = System.nanoTime();
//		System.out.println("\n\nTime to execute this algo: " + (end-start));
//		
//		System.out.println("\nAfter sorting: ");
//		sort.printArray(array);

		
<<<<<<< HEAD
		//--------------------------- Quick Sorting ----------------//
//		int array[] = {10, 3, 2, 7, 7, 5, 8, 4, 1, 2, 9, 7, 8, 11};
//		
//		System.out.println("User entered Array: ");
//		sort.printArray(array);
//		
//		sort.quickSort(array, 0, array.length-1);
//		
//		System.out.println("\n\nAfter sorting: ");
//		sort.printArray(array);
		
		//--------------------------- Heap Sorting ----------------//
		int arr[] = {10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8};
=======
		//---------------------------- Quick Sorting ----------------//
		int array[] = {10, 3, 2, 7, 7, 5, 8, 4, 1, 2, 9, 7, 8, 11};
>>>>>>> test
		
		System.out.println("User entered Array: ");
		sort.printArray(arr);
		System.out.println("\n");
		
		sort.heapSort(arr);
		
		System.out.println("\n\nAfter sorting: ");
		sort.printArray(arr);
		
	}
	
}
