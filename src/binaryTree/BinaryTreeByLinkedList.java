package binaryTree;
import java.util.*;

import node.BinaryNode;

public class BinaryTreeByLinkedList {
	BinaryNode root;
	

	// constructor for creating a blank Binary tree
	public BinaryTreeByLinkedList() {
		this.root = null;
	}
	
	public void insert(int value) {
		BinaryNode node = new BinaryNode();	// create an empty node
		node.setValue(value);				// save the value in that node
		if (root == null) {					// if the root is empty save the node to the root					
			root = node;	
			System.out.println("Successfully inserted new node at Root !");
			return;
		}
		Queue<BinaryNode> bQueue = new LinkedList<BinaryNode>();	// create a queue
		bQueue.add(root);											// add the root to the queue
		while (!bQueue.isEmpty()) {
			BinaryNode presentNode = bQueue.remove();				// remove a value from the queue and store it to the queue
			if (presentNode.getLeft() == null) {					// if left of that node is empty sort the new value there
				presentNode.setLeft(node);
				System.out.println("Successfully inserted new node !");
				break;
			}else if (presentNode.getRight() == null) {				// if right of that node is empty sort the new value there
				presentNode.setRight(node);
				System.out.println("Successfully inserted new node !");
				break;
			} else {												// if left and right is not empty add both to the queue
				bQueue.add(presentNode.getLeft());		
				bQueue.add(presentNode.getRight());
			}//end of else-if
		}//end of loopd
	}//end of method
	
	public void search(int value) {
		Queue<BinaryNode> bQueue = new LinkedList<BinaryNode>();	// create an empty queue
		bQueue.add(root);											// add root to that queue
		while (!bQueue.isEmpty()) {									
			BinaryNode presentNode = bQueue.remove();				// remove a value from queue and store to the presentNode
			if (presentNode.getValue() == value) {					// if present node is equals to the search value we found it
				System.out.println("Value-"+value+" is found in Tree!!");
				return;
			}
			else {													// if present node is not equals to the search value
				if (presentNode.getLeft() != null) {				// if left value of the node is not null add the left value in the queue
					bQueue.add(presentNode.getLeft());
				}
				if (presentNode.getRight() != null) {				// if right value of the node is not null add the right value in the queue
					bQueue.add(presentNode.getRight());
				}
			}
		}
		System.out.println("Value-"+value+" is not found in Tree!");
	}
	
	public BinaryNode getDeepestNode() {
		Queue<BinaryNode> bQueue = new LinkedList<BinaryNode>();	// create an empty queue
		bQueue.add(root);											// add the root to the queue
		BinaryNode presentNode = null;								// create an empty node
		while (!bQueue.isEmpty()) {									
			presentNode = bQueue.remove();							// store the the deleted value from the queue to the presentNode 
			if (presentNode.getLeft() != null) {					// if left node is not null add it to the queue
				bQueue.add(presentNode.getLeft());
			}
			if (presentNode.getRight() != null) {					// if right node is not null add it to the queue
				bQueue.add(presentNode.getRight());
			}
		}
		return presentNode;											// return the last value in the queue
	}	
	
	public void deleteDeepestNode() {
		Queue<BinaryNode> bQueue = new LinkedList<BinaryNode>();	
		bQueue.add(root);						
		BinaryNode previousNode, presentNode = null;				// create two empty nodes 
		while (!bQueue.isEmpty()) {		
			previousNode = presentNode;								
			presentNode = bQueue.remove();							// remove the node from the queue and store it in presentNode
			if (presentNode.getLeft() == null) {					// if left of presentNode is empty then right is the last node set it to null
				previousNode.setRight(null);
				return;
			}
			else if (presentNode.getRight() == null) {				// if right of presentNode is empty then left is the last node set it of null
				presentNode.setLeft(null);
				return;
			}
			bQueue.add(presentNode.getLeft());						// left and right is not empty store both to the queue
			bQueue.add(presentNode.getRight());
		}
	}
	
	public void deleteNodeOfBinaryTree(int value) {					
		Queue<BinaryNode> bQueue = new LinkedList<BinaryNode>();	
		bQueue.add(root);
		while (!bQueue.isEmpty()) {
			BinaryNode presentNode = bQueue.remove();				// remove the node from the queue and store it in the presentNode
			if (presentNode.getValue() == value) {					// if the value is equal to present node set the present node as the deepest node and delete the deepest node
				presentNode.setValue(getDeepestNode().getValue());	
				deleteDeepestNode();
				System.out.println("Deleted the node!!");
				return;
			}
			else {													// if presentNode is not equals to value and left and right to queue if they(left and right) are not null
				if (presentNode.getLeft() != null) {
					bQueue.add(presentNode.getLeft());
				}
				if (presentNode.getRight() != null) {
					bQueue.add(presentNode.getRight());
				}
			}
		}
		System.out.println("Did not find the node!!");
	}
	
	public void preOrder(BinaryNode node) {
		if (node == null) {
			return;
		}
		System.out.print(node.getValue() + " ");
		preOrder(node.getLeft());
		preOrder(node.getRight());
	}
	
	public void postOrder(BinaryNode node) {
		if (node == null) {
			return;
		}
		postOrder(node.getLeft());
		postOrder(node.getRight());
		System.out.print(node.getValue() + " ");
	}
	
	public void inOrder(BinaryNode node) {
		if (node == null) {
			return;
		}
		inOrder(node.getLeft());
		System.out.print(node.getValue() + " ");
		inOrder(node.getRight());
	}
	
	public void levelOrder() {
		Queue<BinaryNode> bQueue = new LinkedList<BinaryNode>();
		bQueue.add(root);
		while (!bQueue.isEmpty()) {								
			BinaryNode presentNode = bQueue.remove();				// removing one node and storing it to presentNode
			System.out.print(presentNode.getValue() + " ");			
			if (presentNode.getLeft() != null) {					// if left or right is not null sort it to queue
				bQueue.add(presentNode.getLeft());
			}
			if (presentNode.getRight() != null) {
				bQueue.add(presentNode.getRight());
			}
		}
	}
	
	public void deleteTree() {
		root = null;
		System.out.println("Binary Tree has been deleted successfully!!");
	}
}
