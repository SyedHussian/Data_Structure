package array;

public class SingleDimensionArray {
	int arr[] = null;
	
	//constructor to create a blank array with size taken from user
	public SingleDimensionArray(int sizeArray) {
		this.arr = new int[sizeArray];
		for (int i=0; i<arr.length; i++) {
			arr[i] = Integer.MIN_VALUE; // Default value -2^31
		}	
	}
	
	//Print the array or traverse array
	public void traverseArray() {
		try {
			for (int i=0; i<arr.length; i++) {
				System.out.println(arr[i] + " ");
			}
		}catch (Exception e) {
			System.out.println("Array no longer exists");
		}
	}
	
	//Insert value in a specific location
	public void insert(int location, int valueToInsert) {
		try {
			if (arr[location] == Integer.MIN_VALUE) {
				arr[location] = valueToInsert;
				System.out.println("Successfully inserted " + valueToInsert + " at location " + location);
			}
			else {
				System.out.println("The cell is already occupied by another value");
			}
		}catch (Exception e) {
			System.out.println("Invalid index to access array!");
		}
	}
	
	
	//Access a particular element of an array
	public void accessingCell(int cellNumber) {
		try {
			System.out.println(arr[cellNumber]);
		}catch (Exception e) {
			System.out.println("invalid index to access array!");
		}
	}
	
	//Search for an element in the given Array
	public void searchInArray(int valueToSearch) {
		for (int i=0; i<arr.length; i++) {
			if(arr[i] == valueToSearch) {
				System.out.println("Value found!");
				System.out.println("Index of " + valueToSearch + " is "+ i);
				return;
			}
		}
		System.out.println("Value not found!");
	}
	
	//Delete value from given Array
	public void deleteValueFromArray(int deleteValueFromThisCell) {
		try {
			arr[deleteValueFromThisCell] = Integer.MIN_VALUE;
		}catch (Exception e) {
			System.out.println();
			System.out.println("Can't delete the value as cell# provided is out of range");
		}
	}
}
