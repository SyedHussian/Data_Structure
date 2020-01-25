package node;

public class SingleNode {
	private int value; // data stored can be any type like string, char, float.. 
	private SingleNode next; // has the address of an object or pointers
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public SingleNode getNext() {
		return next;
	}

	public void setNext(SingleNode next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return (value + "");
	}
}
