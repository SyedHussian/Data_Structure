package binaryTree;

public class BinaryTreeByArrayMain {
	public static void main(String[] args) {

		System.out.println("Creating a blank Array of size 10 to store Binary Tree...");
		BinaryTreeByArray tree = new BinaryTreeByArray(10);
		
		
		System.out.println("Inserting 11 values in the Tree...");
		for (int i=1; i<=11; i++) {
			tree.insert(i*10);
		}
		
		System.out.println("\nLevel-order Traversal...");
		tree.levelOrder();
		System.out.println();
		
		System.out.println("\nPre-order Traversal...");
		tree.preOrder(1);
		System.out.println();
		
		System.out.println("\nPost-order Traveersal...");
		tree.postOrder(1);
		System.out.println();
		
		System.out.println("\nSearching value 500 in the tree...");
		tree.search(500);
		System.out.println();
		
		System.out.println("\nSearching value 40 in the tree...");
		tree.search(40);
		System.out.println();
		
		System.out.println("\nDeleting value 500 from the tree...");
		tree.delete(500);
		System.out.println();
		
		System.out.println("\nDeleting value 40 from the tree...");
		tree.delete(40);
		System.out.println();
		
		System.out.println("\nLevel-order Traversal...");
		tree.levelOrder();
		System.out.println();
		
		System.out.println("\nDeleting the entire tree...");
		tree.deleteTree();
		
	}

}
