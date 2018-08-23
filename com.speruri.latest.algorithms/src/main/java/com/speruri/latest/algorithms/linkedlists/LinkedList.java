package com.speruri.latest.algorithms.linkedlists;


public class LinkedList<E> {

	Node head = null;
	Node left = null;


	boolean isPalindrome(Node right){
	 	left = head;
		
		if(right == null){
		return true;
		}
		
		boolean isPal = isPalindrome(right.next);
		if(isPal == false){
			return false;
		}
		
		isPal = (left.data == right.data);
		left = left.next;
		return isPal;
		
	}


	void addNodeAtFirst(Node<E> argNode) {
		if (head == null) {
			// then the list is empty
			head = argNode;
		} else {
			argNode.next = head;
			head = argNode;
		}
	}

	void addNodeAtLast(Node<E> argNode) {
		if (head == null) {
			head = argNode;
		} else {
			Node n = head;
			while (n.next != null) {
				n = n.next;
			}
			n.next = argNode;
		}
	}

	void displayNodes() {
		Node n = head;
		if (n != null) {
			while (n != null) {
				System.out.print(n.data + " ");
				n = n.next;
			}
		} else {
			System.out.println("No Nodes in the list");
		}
	}

	public Node<E> searchElement(E argData) {
		Node node = head;
		int count = 0;
		while (node != null) {
			System.out.println("Iteration : " + count);
			if (node.data.equals(argData)) {
				System.out.println("Node found is : " + node);
				return node;
			}
			node = node.next;
			count++;
		}

		return node;
	}

	public void insertBeforeNodeData(Node<E> argNodeToInsert, E argData) {

		Node node = head;

		if (node == null || node != null && node.data.equals(argData)) {
			addNodeAtFirst(argNodeToInsert);
		}
		while (node != null) {
			Node nextNode = node.next;
			if (nextNode != null && nextNode.data.equals(argData)) {
				argNodeToInsert.next = nextNode;
				node.next = argNodeToInsert;
				break;
			}
			node = node.next;
		}
		displayNodes();
	}

	public void deleteNode(E argData) {
		Node node = head;

		if (node.data.equals(argData)) {
			head = node.next;
		}

		while (node.next != null) {
			Node nextNode = node.next;
			if (nextNode.data.equals(argData)) {
				node.next = nextNode.next;
				break;
			}
			node = node.next;
		}

		displayNodes();
	}

	int lengthOfList() {
		int length = 0;
		Node node = head;
		while (node != null) {
			length++;
			node = node.next;
		}

		return length;
	}

	int sizeOfList() {
		return sizeOfList(head);
	}

	int sizeOfList(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + sizeOfList(node.next);
	}

	Node searchNodeByDataRecursively(E argData) {
		return searchNodeByDataRecursively(head, argData);
	}

	Node searchNodeByDataRecursively(Node argNode, E argData) {
		if (argNode == null) {
			return null;
		}
		if (argNode.data.equals(argData)) {
			return argNode;
		}
		return searchNodeByDataRecursively(argNode.next, argData);
	}

	Node getMidNode() {
		return printMiddleNode(head, 0, head);
	}

	Node printMiddleNode(Node argNode, int count, Node midNode) {
		if (argNode == null) {
			return midNode;
		}
		if (count % 2 == 1) {
			midNode = midNode.next;
		}

		return printMiddleNode(argNode.next, ++count, midNode);
	}

	Node getNthNodeFromLast(int index) {
		if (index < 0) {
			return null;
		}
		Node node = head;

		int len = 0;

		while (node != null) {
			node = node.next;
			len++;
		}

		System.out.println("Size of the list is " + len);
		if (len < index) {
			// then the index we got is more than the length
			return null;
		}

		// reset to the head node since we now know the size of the linked list
		node = head;

		int newLength = (len - index);
		System.out.println("New length is " + newLength);

		for (int i = 1; i < newLength; i++) {
			node = node.next;
		}
		return node;
	}

	public int countOccurences(int number) {
		return countNoOfOccurences(head, number, 0);
	}

	public int countNoOfOccurences(Node node, int number, int count) {
		if (node == null) {
			return count;
		}
		if (node.data.equals(number)) {
			count++;
		}
		return countNoOfOccurences(node.next, number, count);
	}

	int loopLengthUsingFloydAlg() {
		int count = 0;
		Node slowNode = head;
		Node fastNode = head;

		while (slowNode != null && fastNode != null && fastNode.next != null) {

			slowNode = slowNode.next;
			fastNode = fastNode.next.next;

			if (slowNode == fastNode) {
				return countLoopNodes(slowNode);
			}

		}

		return count;
	}

	private int countLoopNodes(Node slowNode) {
		int count = 1;
		Node temp = slowNode;

		while (temp != null && temp.next != slowNode) {
			count++;
			temp = temp.next;
		}

		return count;
	}

	boolean floydDetectLoop() {
		Node slowNode = head;
		Node fastNode = head;

		while (slowNode != null && fastNode != null && fastNode.next != null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
			if (slowNode == fastNode) {
				return true;
			}
		}
		return false;
	}

	public void reverseList() {
		reverseNode(head);
		displayNodes();
	}

	public Node reverseNode(Node node) {
		if (node == null) {
			return node;
		}
		Node currentNode = node;
		Node n = reverseNode(node.next);
		if (n == null) {
			head = currentNode;
			return currentNode;
		}
		n.next = currentNode;
		currentNode.next = null;
		return currentNode;
	}

	public static void main(String[] args) {
		Node<Integer> firstNode = new Node<Integer>(1);
		Node<Integer> secondNode = new Node<Integer>(2);
		Node<Integer> thirdNode = new Node<Integer>(3);
		Node<Integer> fourthNode = new Node<Integer>(1);

		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.addNodeAtFirst(fourthNode);
		linkedList.addNodeAtFirst(firstNode);
		linkedList.addNodeAtFirst(secondNode);
		linkedList.addNodeAtFirst(thirdNode);

		linkedList.addNodeAtLast(new Node<Integer>(2));
		linkedList.addNodeAtLast(new Node<Integer>(3));

		linkedList.displayNodes();
		System.out.println();

		int numberToFind = 6;
//		Assert.check(true, linkedList.searchElement(numberToFind).data.equals(numberToFind));

		int nodeNum = 5;
		int data = 10;
		linkedList.insertBeforeNodeData(new Node<Integer>(data), nodeNum);
		linkedList.insertBeforeNodeData(new Node<Integer>(1), 1);
		System.out.println();
		linkedList.deleteNode(data);
		System.out.println();
		System.out.println("Size of list is : " + linkedList.lengthOfList());
		System.out.println("Size of list recursion is : " + linkedList.sizeOfList());
		System.out.println("SEarched Node : " + linkedList.searchNodeByDataRecursively(0));

		System.out.println("Middle node is : " + linkedList.getMidNode());
		System.out.println("Nth node from the last is : " + linkedList.getNthNodeFromLast(1));
		System.out.println("No of Occurences : " + linkedList.countOccurences(1));
		System.out.println("==================");
		System.out.println("Reverse List : ");
		linkedList.reverseList();
		System.out.println();
		System.out.println("==================");
//		linkedList.head.next.next.next.next = linkedList.head;
//		System.out.println("Floyd Loop detected is : " + linkedList.floydDetectLoop());
//		System.out.println("Floyd loop count " + linkedList.loopLengthUsingFloydAlg());
	
		System.out.println("IS list Palindrome : " + linkedList.isPalindrome(linkedList.head));
}
}
