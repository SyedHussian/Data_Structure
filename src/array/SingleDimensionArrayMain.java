package array;

public class SingleDimensionArrayMain {
	public static void main(String[] args) {
		SingleDimensionArray sdArray = new SingleDimensionArray(10); 
		sdArray.insert(2, 10);
		sdArray.insert(2, 50);
		sdArray.accessingCell(2);
		sdArray.searchInArray(10);
		sdArray.deleteValueFromArray(2);
		sdArray.traverseArray();
		//sdArray.traverseArray();
	}
}


/* 
 * Creating an empty Array 			(Time complexity O(1) | Space Complexity O(1)) 
 *
 * Inserting a value 				(Time complexity O(1) | Space Complexity O(1)) 
 * 
 * Traversing a given Array			(Time complexity O(n) | Space Complexity O(1))
 * 
 * Accessing given cell#			(Time complexity O(1) | Space Complexity O(1))
 * 
 * Searching a given value			(Time complexity O(n) | Space Complexity O(1))
 * 
 * Deleting a given cell's value	(Time complexity O(1) | Space Complexity O(1))
 */