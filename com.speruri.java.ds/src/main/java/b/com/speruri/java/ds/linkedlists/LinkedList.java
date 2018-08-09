package b.com.speruri.java.ds.linkedlists;

public class LinkedList<T extends Comparable<T>> implements List<T> {

	private Node<T> root;
	private int sizeOfList = 0;

	public void insert(T argData) {
		// TODO Auto-generated method stub
		++this.sizeOfList;
		if (this.root == null) {
			this.root = new Node<T>(argData);
		} else {
			insertAtFirst(argData);
		}
	}

	private void insertAtFirst(T argData) {
		Node newNode = new Node<T>(argData);
		newNode.setNextNode(this.root);
		this.root = newNode;
	}

	public void insertAtLast(Node<T> argNode, T argData) {
		if (argNode != null && argNode.getNextNode() != null) {
			insertAtLast(argNode.getNextNode(), argData);
		} else {
			Node<T> newNode = new Node<T>(argData);
			argNode.setNextNode(newNode);
		}
	}

	public void remove(T argData) {
		if (this.root == null) {
			return;
		}

		this.sizeOfList--;

		Node<T> node = this.root;
		while (node != null) {
			if (node.getData().compareTo(argData) == 1) {
				
				return;
			}
			node = node.getNextNode();
		}

		Node<T> nextNode = this.root.getNextNode();
		if (nextNode != null && nextNode.getData().compareTo(argData) == 1) {
			this.root.setNextNode(nextNode.getNextNode());
		} else {
			remove(argData);
		}

	}

	public void traverseList() {
		// TODO Auto-generated method stub

	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
