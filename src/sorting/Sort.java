package sorting;

public class Sort {
	
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
	
	
	
	public void printArray(int arr[]) {
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]+" ");
		}
		System.out.println();
	}
}
