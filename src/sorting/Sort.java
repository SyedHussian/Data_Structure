package sorting;

public class Sort {
	
	public void bubbleSort(int arr[]) {
		int n = arr.length;
		for (int i=0; i<n-1; i++) {
			for (int j=0; j<n-i-1; j++) {
				if (arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public void printArray(int arr[]) {
		int n = arr.length;
		for (int i=0; i<n; i++) {
			System.out.println(arr[i]+" ");
		}
		System.out.println();
	}
}
