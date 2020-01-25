package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

import node.BinaryNode;

public class BinarySearchTreeByLinkedList {
	BinaryNode root;
	
	public BinaryNode getRoot() {
		return root;
	}
	
	// Default constructor empty tree
	public BinarySearchTreeByLinkedList() {
		root = null;
	}
	
	//insert values in BST
	public void insert(int value) {				// ask user to insert just the value
		root = insert(root, value);				// call the insert with the parameters
	}
	
	//Helper Method
	public BinaryNode insert(BinaryNode currentNode, int value) {			
		if (currentNode == null) {				// if the node is null create a new node
			System.out.println("Successfully inserted "+value+" in BST!");
			return createNewNode(value);
		}
		else if (value <= currentNode.getValue()) {			// if the value <= current Value then set the current node to left 
			currentNode.setLeft(insert(currentNode.getLeft(), value));
			return currentNode;
		}
		else {												// if the value > current value then set the current node to right
			currentNode.setRight(insert(currentNode.getRight(), value));
			return currentNode;
		}
	}
	
	// creates a new blank node
	public BinaryNode createNewNode(int value) {
		BinaryNode node = new BinaryNode();		// create an empty node and store the value
		node.setValue(value);
		return node;
	}
	
	
	public void deleteNodeOfBST(int value) {
		System.out.println("\n\nDeleting " +value+ " from BST...");
		deleteNodeOfBST(root,value);
	}
	
	public BinaryNode deleteNodeOfBST(BinaryNode root, int value) {
		if (root == null) {					// if the root is null no tree
			System.out.println("Value not found in BST");
			return null;
		}
		if (value < root.getValue()) {		// if the value < root set the root to the left
			root.setLeft(deleteNodeOfBST(root.getLeft(), value));
		}
		else if (value > root.getValue()) {	// if the value > root set the root to the right
			root.setRight(deleteNodeOfBST(root.getRight(), value));
		}
		else {								// if the value is neither > nor < the root
			if (root.getLeft() != null && root.getRight() != null) {	// replace with the successor (case 3 - has both child)	
				BinaryNode temp = root;											// if left and right is not null 
				BinaryNode minNodeForRight = minimumElement(temp.getRight()); 	// find the successor and store the value in minNodeForRight
				root.setValue(minNodeForRight.getValue());						// replace the root value with the successor
				root.setRight(deleteNodeOfBST(root.getRight(), minNodeForRight.getValue())); //delete the successor
			}
			else if (root.getLeft() != null) { 							// just skip that node (case 2 - has only 1 child)
				root = root.getLeft();		// if left is not null root change to left 
			}
			else if (root.getRight() != null) { 						// just skip that node (case 2 - has only 1 child)
				root = root.getRight();		// else if right is not null root change to right 
			}
			else {							// just delete the value (case 1 - has no child) 
				root = null;
			}
		}
		return root;
	}
	
	// Get minimum element in binary search tree
	public static BinaryNode minimumElement(BinaryNode root) {	// find the successor
		if (root.getLeft() == null) { 
			return root;
		}
		else {
			return minimumElement(root.getLeft());
		}
	}
	
	public void searchForValue(int value) {
		searchForValue(root, value);
	}
	
	//Search a node in BST
	public BinaryNode searchForValue(BinaryNode node, int value) {
		if (node == null) {
			System.out.println("Value: "+value+" not found in BST.");
			return null;
		}
		else if (node.getValue() == value) {
			System.out.println("Value: "+value+" found in BST.");
			return node;
		}
		else if (value < node.getValue()) {
			return searchForValue(node.getLeft(), value);
		}
		else {
			return searchForValue(node.getRight(), value);
		}
	}
	
	
	public void levelOrderTraversal() {
		Queue<BinaryNode> bQueue = new LinkedList<BinaryNode>();
		bQueue.add(root);
		System.out.println("\nPrinting Level order traversal of Tree...");
		if (root == null) {
			System.out.println("Tree does not exists!");
			return;
		}
		while (!bQueue.isEmpty()) {
			BinaryNode presentNode = bQueue.remove();
			System.out.print(presentNode.getValue()+" ");
			if (presentNode.getLeft() != null) {
				bQueue.add(presentNode.getLeft());
			}
			if (presentNode.getRight() != null) {
				bQueue.add(presentNode.getRight());
			}
		}
	}
	
	public void deleteTree() {
		System.out.println("Deleting entire Tree...");
		root = null;
		System.out.println("Tree deleted successfully!");
	}
	
	public void printTreeGraphically() {
		Queue<BinaryNode> bQueue = new LinkedList<BinaryNode>();
		Queue<Integer> level = new LinkedList<Integer>();
		
		int currentLevel = 1;
		boolean previousLevelWasAllNull = false;
		
		bQueue.add(root);
		level.add(1);
		
		System.out.println("\nPrinting Level order Traversal of Tree...");
		if (root == null) {
			System.out.println("Tree does not exists!");
			return;
		}
		
		while (!bQueue.isEmpty()) {
			if (currentLevel == level.peek()) {
				if (bQueue.peek() == null) {
					bQueue.add(null);
					level.add(currentLevel+1);
				}
				else {
					bQueue.add(bQueue.peek().getLeft());
					level.add(currentLevel+1);
					bQueue.add(bQueue.peek().getRight());
					level.add(currentLevel+1);
					previousLevelWasAllNull = false;
				}
				System.out.print(bQueue.remove()+" ");
				level.remove();
			}
			else {
				System.out.println("\n");
				currentLevel++;
				if (previousLevelWasAllNull == true) {
					break;
				}
				previousLevelWasAllNull = true;
			}
		}		
	}
}
