package b.com.speruri.java.ds.linkedlists;

public class Node<T extends Comparable<T>> {

	private T data;
	private Node nextNode;
	
	public Node(T argData) {
		this.data = argData;
	}

	public T getData() {
		return this.data;
	}

	public void setData(T argData) {
		this.data = argData;
	}

	public Node getNextNode() {
		return this.nextNode;
	}

	public void setNextNode(Node argNextNode) {
		this.nextNode = argNextNode;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
}
