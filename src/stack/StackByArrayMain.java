package stack;

public class StackByArrayMain {
	public static void main(String[] args) {
		System.out.println("Creating a stack of size 5...");
		StackByArray stack = new StackByArray(5);
		System.out.println();
		
		System.out.println("Pushing 6 values in the stack...");
		for (int i =0; i<=5; i++) {
			stack.push(i*10);
		}
		System.out.println();
		
		System.out.println("Peeking value from stack");
		stack.peek();
		System.out.println();
		
		System.out.println("Poping 6 values from the stack...");
		for (int i=0; i<=5; i++) {
			stack.pop();
		}
		System.out.println();
		
		System.out.println("Deleting the stack.");
		stack.deleteStack();
		
		
	}

}
