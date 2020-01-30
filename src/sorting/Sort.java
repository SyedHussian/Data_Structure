package sorting;

import java.util.ArrayList;
import java.util.Collections;

public class Sort {
	int arr[];
	
	public Sort(int[] arr) { this.arr = arr;}
	public Sort() { }

	public void bubbleSort(int arr[]) {
		for (int i=0; i<arr.length-1; i++) {
			for (int j=0; j<arr.length-i-1; j++) {
				if (arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public void seletionSort(int arr[]) {
		for (int i=0; i<arr.length; i++) {
			int minIndex = i;
			for (int j = i+1; j<arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
	}
	
	public void insertionSort(int arr[]) {
		for (int i=1; i<arr.length; i++) {
			int temp = arr[i], j=i;
			while (j>0 && arr[j-1]>temp) {
				arr[j]=arr[j-1];
				j--;
			}
			arr[j]=temp;
		}
	}
	
	
	public void bucketSort(int arr[]) {
		// creating sqrt# of buckets, se that the distribution is even 
		int numberOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
		int maxValue = Integer.MIN_VALUE;
		int minValue = Integer.MAX_VALUE;
		
		
		//Finding the min and max value from the array
		for (int value: arr) {
			if (value< minValue) {
				minValue = value;
			}
			else if (value > maxValue) {
				maxValue = value;
			}
		}
		
		//Create an array of buckets
		ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
		
		
		//initializing empty bucket
		for (int i=0; i<buckets.length; i++) {
			buckets[i] = new ArrayList<Integer>();
		}
		
		for (int value: arr) {
			int bucketNumber = (int) Math.ceil((value * numberOfBuckets)/maxValue);
			//System.out.println("bucketNumber: " + bucketNumber);
			buckets[bucketNumber - 1].add(value);
		}
		
		System.out.println("\n\nPrinting buckets before Sorting...");
		printBucket(buckets);
		
		for (ArrayList<Integer> bucket : buckets) {
			Collections.sort(bucket);
		}
		
		System.out.println("\n\nPrinting buckets after sorting!");
		printBucket(buckets);
		
		int index = 0;
		for (ArrayList<Integer> bucket: buckets) {
			for (int value: bucket) {
				arr[index] = value;
				index++;
			}
		}
		
		
	}
	
	//Prints Buckets
	public void printBucket(ArrayList<Integer>[] buckets) {
		for(int i=0; i<buckets.length; i++) {
			System.out.println("\nBucket#" + i + " :");
			for (int j=0; j<buckets[i].size(); j++) {
				System.out.print(buckets[i].get(j)+"  ");
			}
		}
		
	}
	
	public void printArray(int arr[]) {
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]+" ");
		}
		System.out.println();
	}
}
