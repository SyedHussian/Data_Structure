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

	public void mergeSort(int[] array, int left, int right) {
		if (right > left) {
			int middle = (left+right)/2;
			mergeSort(array, left, middle);
			mergeSort(array, middle+1, right);
			merge(array, left, middle, right);
		}
	}
	
	public void merge(int[] array, int left, int middle, int right) {
		int[] leftTempArray = new int[middle-left+2];
		int[] rightTempArray = new int[right-middle+1];
		
		for (int i=0; i<=middle-left; i++) {
			leftTempArray[i] = array[left+i];
		}
		for (int i=0; i<right-middle; i++) {
			rightTempArray[i] = array[middle+1+i];
		}
		
		leftTempArray[middle-left+1] = Integer.MAX_VALUE;
		rightTempArray[right-middle] = Integer.MAX_VALUE;
		
		int i=0, j=0;
		
		for (int k=left; k<=right; k++) {
			if (leftTempArray[i] < rightTempArray[j]) {
				array[k] = leftTempArray[i];
				i++;
			}
			else {
				array[k] = rightTempArray[j];
				j++;
			}
		}
	}
	
	
	public void quickSort(int[] array, int start, int end) {
		if (start < end) {
			int pivot = partition(array, start, end);
			quickSort(array, start, pivot-1);
			quickSort(array, pivot+1, end);
		}
	}
	
	public int partition(int[] array, int start, int pivote) {
		int i = start-1;
		for (int j=start; j<=pivote; j++) {
			if (array[j] <= array[pivote]) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		return i;
	}

	
	public void heapSort(int[] arr) {
		heapByArray hba = new heapByArray(arr.length);
		for (int i=0; i<arr.length; i++) {
			hba.insertInHeap(arr[i]);
		}
		for (int i=0; i<arr.length; i++) {
			arr[i] = hba.extractHeadOfHeap();
		}
	}

	
	
	public void printArray(int arr[]) {
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]+" ");
		}
		System.out.println();
	}
}
