package binaryTree;

public class BinaryTreeByLinkedListMain {
	public static void main(String[] args) {
		
		BinaryTreeByLinkedList tree = new BinaryTreeByLinkedList();
		
		
		System.out.println("Inserting 10 nodes to tree!");
		for (int i=0; i<10; i++) {
			tree.insert(i*10);
		}
		
		System.out.println("\nLevel-order of tree...");
		tree.levelOrder();
		System.out.println();
		
		System.out.println("\nPre-order of tree...");
		tree.preOrder(tree.root);
		System.out.println();
		
		System.out.println("\nPost-order of tree...");
		tree.postOrder(tree.root);
		System.out.println();
		
		System.out.println("\nIn-order of tree...");
		tree.inOrder(tree.root);
		System.out.println();
		
		
		System.out.println("\nSearching node 50 in the tree...");
		tree.search(50);
		
		System.out.println("\nSearching node 500 in the tree...");
		tree.search(500);
		
		
		System.out.println("\nDeleting node having value 50 in the tree...");
		tree.deleteNodeOfBinaryTree(50);
		tree.levelOrder();
		System.out.println();
		
		System.out.println("\nDeleting node having value 10 in the tree...");
		tree.deleteNodeOfBinaryTree(10);
		tree.levelOrder();
		System.out.println();
		
		System.out.println("\nDeleting node having value 500 in the tree...");
		tree.deleteNodeOfBinaryTree(500);
		tree.levelOrder();
		System.out.println();
		
		System.out.println("\nDeleting the entire tree...");
		tree.deleteTree();
	}

}
