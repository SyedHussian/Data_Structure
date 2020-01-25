package AVL;
import java.util.LinkedList;
import java.util.Queue;

import node.BinaryNode;

public class AVLTree {
	BinaryNode root;
	
	public BinaryNode getRoot() {
		return root;
	}
	
	public AVLTree() {
		root = null;
	}
	
	public void insert(int value) {
		root = insert(root, value);
	}
	
	public BinaryNode createNewNode(int value) {
		BinaryNode node = new BinaryNode();
		node.setValue(value);
		node.setHeight(0);
		return node;
	}
	
	public int calculateHeight(BinaryNode currentNode) {
		if (currentNode == null) {
			return 0;
		}
		// has problem understanding this part.........
		return 1 + Math.max((currentNode.getLeft() != null ? currentNode.getLeft().getHeight() : -1),
				(currentNode.getRight() != null ? currentNode.getRight().getHeight() : -1));
	}
	
	private int checkBalance(BinaryNode rootLeft, BinaryNode rootRight) {
		if ((rootLeft == null) && (rootRight == null)) {
			return 0;
		}
		else if (rootLeft == null) { // if left node is not there then simply return node's height +1 
			return -1 * (rootRight.getHeight() + 1); // we need to make it -1 cause blank height is considered having height as '-1' 
		}
		else if (rootRight == null) {
			return rootLeft.getHeight() + 1;
		}
		else { // +1 is not required, as both right and left child exist and 1 get nullified
			return rootLeft.getHeight() - rootRight.getHeight(); 
		}
	}
	
	// RR condition (left Rotation)
	private BinaryNode leftRotate(BinaryNode currentNode) {
		BinaryNode newRoot = new BinaryNode();
		newRoot = currentNode.getRight();
		currentNode.setRight(currentNode.getRight().getLeft());
		newRoot.setLeft(currentNode);
		currentNode.setHeight(calculateHeight(currentNode));
		newRoot.setHeight(calculateHeight(newRoot));
		return newRoot;
	}
	
	// LL condition	(Right Rotation)
	private BinaryNode rightRotate(BinaryNode currentNode) {
		BinaryNode newRoot = new BinaryNode();
		currentNode.setLeft(currentNode.getLeft().getRight());
		newRoot.setRight(currentNode);
		currentNode.setHeight(calculateHeight(currentNode));
		newRoot.setHeight(calculateHeight(newRoot));
		return newRoot;
	}
	
	
	
	public BinaryNode insert(BinaryNode currentNode, int value) {
		//This condition is the same as BST condition
		if (currentNode == null) {
			System.out.println("Successfully inserted "+value+" in AVL tree!");
			return createNewNode(value);
		}
		else if (value <= currentNode.getValue()) {
			currentNode.setLeft(insert(currentNode.getLeft(), value));
		}
		else {
			currentNode.setRight(insert(currentNode.getRight(), value));
		}
		
		//This is where we will do AVL specific work
		int balance = checkBalance(currentNode.getLeft(), currentNode.getRight());
		if (balance > 1) {
			if (checkBalance(currentNode.getLeft().getLeft(), currentNode.getLeft().getRight()) > 0) {
				currentNode = rightRotate(currentNode); //LL condition
			}
			else {
				currentNode.setLeft(leftRotate(currentNode.getLeft())); //LR condition
				currentNode = rightRotate(currentNode);
			}
		}
		else if (balance < -1) {
			if (checkBalance(currentNode.getRight().getRight(), currentNode.getRight().getLeft()) > 0) {
				currentNode = leftRotate(currentNode); //RR condition
			} 
			else {
				currentNode.setRight(rightRotate(currentNode.getRight())); //RL condition
				currentNode = leftRotate(currentNode);
			}
		}
		
		if (currentNode.getLeft() != null) {
			currentNode.getLeft().setHeight(calculateHeight(currentNode.getLeft()));
		}
		if (currentNode.getRight() != null) {
			currentNode.getRight().setHeight(calculateHeight(currentNode.getRight()));
		}
		currentNode.setHeight(calculateHeight(currentNode));
		return currentNode;
	}
	
	
	public void levelOrderTraversal() {
		Queue<BinaryNode> bQueue = new LinkedList<BinaryNode>();
		bQueue.add(root);
		System.out.println("Printing level order traversal of AVL tree");
		if (root == null) {
			System.out.println("Tree does not exist!");
			return;
		}
		while (!bQueue.isEmpty()) {
			BinaryNode presentNode = bQueue.remove();
			System.out.print(presentNode.getValue() + " ");
			if (presentNode.getLeft() != null) {
				bQueue.add(presentNode.getLeft());
			}
			if (presentNode.getRight() != null) {
				bQueue.add(presentNode.getRight());
			}
		}
	}
	
	// Get the successor 
	public static BinaryNode minimumElement(BinaryNode root) {
		if (root.getLeft() == null) {
			return root;
		}
		else {
			return minimumElement(root.getLeft());
		}
	}
	
	
	public void deleteNodeOfBST(int value) {
		System.out.println("Deleting "+value+" from AVL tree...");
		root = deleteNodeOfBST(root, value);
	}
	
	
	public BinaryNode deleteNodeOfBST(BinaryNode currentNode, int value) {
		// This condition is BST condition
		if (currentNode == null) {
			return null;
		}
		if (value < currentNode.getValue()) {
			currentNode.setLeft(deleteNodeOfBST(currentNode.getLeft(), value));
		}
		else if (value > currentNode.getValue()) {
			currentNode.setRight(deleteNodeOfBST(currentNode.getRight(), value));
		}
		else { // if current node is the node to be deleted
			if (currentNode.getLeft() != null && currentNode.getRight() != null) {
				BinaryNode temp = currentNode;
				BinaryNode minNodeForRight = minimumElement(temp.getRight()); // finding successor
				currentNode.setValue(minNodeForRight.getValue()); // replacing current node with minimum node from right subtree
				deleteNodeOfBST(currentNode.getRight(), minNodeForRight.getValue());
			}
			else if (currentNode.getLeft() != null) {
				currentNode = currentNode.getLeft();
			}
			else if (currentNode.getRight() != null) {
				currentNode = currentNode.getRight();
			}
			else {
				currentNode = null;
			}
			return currentNode;
		}
		
		// This is where we will do AVL specific work
		
		int balance = checkBalance(currentNode.getLeft(), currentNode.getRight());
		if (balance > 1) {
			if (checkBalance(currentNode.getLeft().getLeft(), currentNode.getLeft().getRight()) > 0) {
				currentNode = rightRotate(currentNode); //LL condition
			}
			else {
				currentNode.setLeft(leftRotate(currentNode.getLeft()));
				currentNode = rightRotate(currentNode);
			}
		}
		else if (balance < -1) {
			if (checkBalance(currentNode.getRight().getRight(), currentNode.getRight().getLeft()) < 0) {
				currentNode = leftRotate(currentNode); //RR condition
			}
			else {
				currentNode.setRight(rightRotate(currentNode.getRight())); //RL condition
				currentNode = leftRotate(currentNode);
			}
		}
		
		if (currentNode.getLeft() != null) {
			currentNode.getLeft().setHeight(calculateHeight(currentNode.getLeft()));
		}
		if (currentNode.getRight() != null) {
			currentNode.getRight().setHeight(calculateHeight(currentNode.getRight()));
		}
		currentNode.setHeight(calculateHeight(currentNode));
		return currentNode;
	}
	
	void printTreeGraphically() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		Queue<Integer> level = new LinkedList<Integer>();
		
		int CurrentLevel = 1;
		boolean previousLevelWasAllNull = false;
		queue.add(root);
		level.add(1);
		
		System.out.println("\n\nPrinting Level order traversal of Tree...");
		if(root == null) {
			System.out.println("Tree does not exists !");
			return;
		}
		
		while (!queue.isEmpty()) {
			if(CurrentLevel == level.peek()) { //if we are in the same level
				if(queue.peek()==null) {
					queue.add(null);
					level.add(CurrentLevel+1);
				}else {
					queue.add(queue.peek().getLeft());level.add(CurrentLevel+1);
					queue.add(queue.peek().getRight());level.add(CurrentLevel+1);
					previousLevelWasAllNull = false;
				}
				System.out.print(queue.remove() + "  ");
				level.remove();
			}else { //level has changed
				System.out.println("\n");
				CurrentLevel++;
				if(previousLevelWasAllNull == true) {
					break;
				}
				previousLevelWasAllNull = true;
			}
		}//end of loop
	}//end of method
}
