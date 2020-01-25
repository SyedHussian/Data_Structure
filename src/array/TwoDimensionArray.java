package array;

public class TwoDimensionArray {
	
	int arr[][] = null;
	
	// Default constructor 
	public TwoDimensionArray(int sizeOfRow, int sizeOfColume){
		this.arr = new int[sizeOfRow][sizeOfColume];
		for (int row=0; row<sizeOfRow; row++) {
			for(int col=0; col<sizeOfColume; col++) {
				arr[row][col] = Integer.MIN_VALUE;
			}
		}
	}
	
	public void traverse() {
		try {
			System.out.println("\nPrinting the array....s");
			for (int row=0; row<arr.length; row++) {
				for (int col=0; col<arr[row].length; col++) {
					System.out.print(arr[row][col] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}catch (Exception e) {
			System.out.println("Array does not exist");
		}
	}
	
	public void insert(int valueToInsert, int rowNumber, int colNumber) {
		try {
			System.out.println("Inserting.....");
			if (arr[rowNumber][colNumber] == Integer.MIN_VALUE) {
				arr[rowNumber][colNumber] = valueToInsert;
				System.out.println("Successfully inserted " + valueToInsert + " at row " + rowNumber + " column " + colNumber);
			}
			else {
				System.out.println("The cell is already occupied by another value");
			}
		}catch (Exception e) {
			System.out.println("Invalid index to access array!");
		}
	}
	
	public void accessingCell(int rowNumber, int colNumber) {
		try {
			System.out.println("Accessing Cell....");
			System.out.println(arr[rowNumber][colNumber]);
		}catch (Exception e) {
			System.out.println("invalid index to access array!");
		}
	}
	
	
	public void searchInArray(int valueToSearch) {
		System.out.println("Searching....");
		for (int row=0; row<arr.length; row++) {
			for (int col=0; col<arr[row].length; col++) {
				if(arr[row][col] == valueToSearch) {
					System.out.println("Value found!");
					System.out.println("Index of " + valueToSearch + " is in row "+ row + " column "+ col);
					return;
				}
			}
		}
		System.out.println("Value not found!");
	}
	
	public void Delete(int rowNumber, int colNumber) {
		arr[rowNumber][colNumber] = Integer.MIN_VALUE;
	}

	
}
