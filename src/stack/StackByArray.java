package stack;

public class StackByArray {
	
	int[] arr;
	int topOfStack; //keep track of the cell which is last occupied in Array, this will help in insertion/deletion 

	public StackByArray(int size) {
		this.arr = new int[size];
		this.topOfStack = -1;
		System.out.println("Successfully created an empty Stack of size " + size);
	}
	
	public boolean isFullStack() {
		if (topOfStack == arr.length-1) {
			System.out.println("Stack is full!");
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isEmptyStack() {
		if (topOfStack == -1) {
			return true;
		}else {
			return false;
		}
	}
	
	public void push(int value) {
		//if array is full, show stack overflow error
		if (isFullStack()) {
			System.out.println("Stack overflow error! ");
		}else {
			arr[topOfStack+1] = value;
			topOfStack++;
			System.out.println("Successfully inserted "+ value + " in the stack.");
		}
	}
	
	public void pop() {
		// if stack is empty, how stack underflow error
		if (isEmptyStack()) {
			System.out.println("Stack underflow error!!");
		}else {
			System.out.println("Poping value from Stack: "+ arr[topOfStack]);
			topOfStack--;
		}
	}
	
	public void peek() {
		if (isEmptyStack()) {
			System.out.println("Stack is empty!");
		}else {
			System.out.println("Top of the stack: " + arr[topOfStack]);
		}
		System.out.println();
	}
	
	public void deleteStack() {
		arr = null;
		System.out.println("Stack is deleted!");
	}
}
