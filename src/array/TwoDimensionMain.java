package array;

public class TwoDimensionMain {
	public static void main(String[] arg) {
		TwoDimensionArray td = new TwoDimensionArray(3, 3);
		td.insert(10000001, 1, 2);
		td.insert(20000001, 0, 1);
		td.traverse();
		
		td.accessingCell(1, 2);
		
		td.searchInArray(20000001);
		
		td.Delete(0, 1);
		td.traverse();
		
		
	}

}

/* 
 * Creating an empty Array 			(Time complexity O(1) | Space Complexity O(mn)) 
 *
 * Inserting a value 				(Time complexity O(1) | Space Complexity O(1)) 
 * 
 * Traversing a given Array			(Time complexity O(mn) | Space Complexity O(1))
 * 
 * Accessing given cell#			(Time complexity O(1) | Space Complexity O(1))
 * 
 * Searching a given value			(Time complexity O(mn) | Space Complexity O(1))
 * 
 * Deleting a given cell's value	(Time complexity O(1) | Space Complexity O(1))
 */