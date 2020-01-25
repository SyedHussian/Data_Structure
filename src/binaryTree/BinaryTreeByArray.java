package binaryTree;

public class BinaryTreeByArray {
	
	int[] arry;
	int lastUsedIndex;
	
	
	public BinaryTreeByArray(int size) {
		arry = new int[size+1];
		this.lastUsedIndex = 0;
		System.out.println("Blank Tree of size "+size+" has been created!");
	}
	
	public boolean isTreeFull() {
		if (arry.length-1 == lastUsedIndex) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void insert(int value) {
		if(!isTreeFull()) {
			arry[lastUsedIndex+1] = value;
			lastUsedIndex++;
			System.out.println("Successfully inserted "+value+ " in the tree!");
		}
		else {
			System.out.println("Tree is full. Could not insert " +value+" in the Tree!");
		}
	}
	
	public void levelOrder() {
		for (int i=1; i<lastUsedIndex; i++) {
			System.out.print(arry[i]+" ");
		}
	}
	
	
	public void preOrder(int index) {
		if (index > lastUsedIndex) {
			return;
		}
		System.out.print(arry[index]+" ");
		preOrder(index*2);		//left
		preOrder(index*2 + 1);	//right
	}
	
	public void postOrder(int index) {
		if (index > lastUsedIndex) {
			return;
		}
		postOrder(index*2);
		postOrder(index*2 + 1);
		System.out.print(arry[index] + " ");
	}
	
	public void inOrder(int index) {
		if (index > lastUsedIndex) {
			return;
		}
		inOrder(index*2);
		System.out.print(arry[index]+" ");
		inOrder(index*2 + 1);
	}
	
	public int search(int value) {
		for (int i=0; i<=lastUsedIndex; i++) {
			if (arry[i] == value) {
				System.out.print(value + " exists in the Tree! ");
				System.out.println("It is located in: " + i);
				return i;
			}
		}
		System.out.println(value + " does not exists in Tree! ");
		return -1;
	}
	
	public void delete(int value) {
		int location = search(value);
		
		if (location == -1) {
			return;
		}
		else {
			arry[location] = arry[lastUsedIndex];
			lastUsedIndex--;
			System.out.println("Successfully deleted " +value+ " from the tree!" );
		}
	}
	
	public void deleteTree() {
		try {
			arry = null;
			System.out.println("Tree has been successfully deleted!");
		}catch(Exception e) {
			System.out.println("There was an error deleting the tree!");
		}
	}
	
	
}
