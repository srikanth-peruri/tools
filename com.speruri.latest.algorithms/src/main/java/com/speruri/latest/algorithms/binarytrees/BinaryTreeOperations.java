package com.speruri.latest.algorithms.binarytrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeOperations {

	public static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return this.data + " ";
		}

	}

	public static void deleteBottomMost(Node root, int x) {
		if (root == null) {
			return;
		}

		Queue<Node> q = new ArrayDeque<>();
		q.add(root);
		Node c = null;
		Node nodeToUpdate = null;
		Node dNode = null;

		while (!q.isEmpty()) {
			c = q.poll();
			if (c.data == x) {
				nodeToUpdate = c;
			}

			if (c.left != null) {
				q.add(c.left);
			} else {
				dNode = c;
			}

			if (c.right != null) {
				q.add(c.right);
			} else {
				dNode = c;
			}

		}

		int d = c.data;
		deleteDeepestNode(root, c);
		nodeToUpdate.data = d;

	}

	public static void deleteDeepestNode(Node root, Node nodeToDelete) {
		if (root == null || nodeToDelete == null) {
			return;
		}

		Queue<Node> q = new ArrayDeque<>();
		q.add(root);
		Node c;
		while (!q.isEmpty()) {
			c = q.poll();
			if (c.right != null) {
				if (c.right == nodeToDelete) {
					c.right = null;
					break;
				} else {
					q.add(c.right);
				}
			}
			if (c.left != null) {
				if (c.left == nodeToDelete) {
					c.left = null;
					break;
				} else {
					q.add(c.left);
				}
			}

		}

	}

	private void insert(Node node, int data) {
		Node newNode = new Node(data);
		if (node == null) {
			node = newNode;
			return;
		}

		Queue<Node> q = new ArrayDeque<>();
		q.add(node);
		Node c;

		while (!q.isEmpty()) {
			c = q.poll();
			if (c.left == null) {
				c.left = newNode;
				break;
			} else {
				q.add(c.right);
			}

			if (c.right == null) {
				c.right = newNode;
				break;
			} else {
				q.add(c.right);
			}
		}
	}

	public static void displayInOrder(Node node) {
		if (node == null) {
			return;
		}
		displayInOrder(node.left);
		System.out.print(node.data + " ");
		displayInOrder(node.right);

	}

	public static boolean isContinousTree(Node node) {
		// Check whether this is null, then return true since the empoty tree is
		// also continous.
		if (node == null) {
			return true;
		}

		// Check whether this is a leaf node
		if (node.left == null && node.right == null) {
			return true;
		}

		// Check if this node is having left node or not. If not then check the
		// right node data
		int currentNodeData = node.data;
		int rightNodeData = node.right.data;
		if (node.left == null) {
			return Math.abs(currentNodeData - rightNodeData) == 1 && isContinousTree(node.right);
		}

		// Check if this node is having right node or not. If not then check the
		// left node data
		int leftnodeData = node.left.data;
		boolean leftAbs = Math.abs((currentNodeData - leftnodeData)) == 1;
		if (node.right == null) {
			return leftAbs && isContinousTree(node.left);
		}

		// If both the nodes are not null, then check the child nodes data
		boolean rightAbs = Math.abs((currentNodeData - rightNodeData)) == 1;
		return leftAbs && rightAbs && isContinousTree(node.left) && isContinousTree(node.right);

	}

	public static boolean isFoldable(Node n) {
		if (n == null) {
			return true;
		}
		return isStructureSame(n.left, n.right);

	}

	public static boolean isStructureSame(Node n1, Node n2) {
		// Check whether these are leaf nodes
		if (n1 == null && n2 == null) {
			return true;
		}

		// Check whether one of the two nodes is null, then return false;
		if (n1 == null || n2 == null) {
			return false;
		}

		return isStructureSame(n1.left, n2.right) && isStructureSame(n1.right, n2.left);
	}

	public static class CharNode {

		char data;
		CharNode left;
		CharNode right;

		public CharNode(char data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return this.data + " ";
		}

	}

	public static void getInfixNotation(char[] a) {
		if (a == null || a.length == 0) {
			return;
		}

		Stack<CharNode> s = new Stack<CharNode>();
		for (int i = 0; i < a.length; i++) {
			char c = a[i];
			if (!isOperator(c)) {
				s.push(new CharNode(c));
			} else {
				CharNode charNode = new CharNode(c);
				charNode.right = s.pop();
				charNode.left = s.pop();
				s.push(charNode);
			}
		}
		inOrderTraversal(s.pop());
	}

	public static void inOrderTraversal(CharNode node) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.left);
		System.out.print(node + " ");
		inOrderTraversal(node.right);
	}

	public static void inOrderTraversal(Node node) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.left);
		System.out.print(node + " ");
		inOrderTraversal(node.right);
	}

	// public static int evaluateTree(CharNode node) {
	// if (node == null) {
	// return -1;
	// }
	//
	// int result = 0;
	//
	// Stack<Node> s = new Stack<>();
	//
	// performPostFixEvaluation(node, s);
	// return (s.pop().data - '0');
	// }

	// public static void performPostFixEvaluation(CharNode node, Stack s) {
	// if (node == null) {
	// return;
	// }
	// performPostFixEvaluation(node.left, s);
	// performPostFixEvaluation(node.right, s);
	// char c = node.data;
	// if (!isOperator(c)) {
	// s.push(c);
	// } else {
	// int operand1 = s.pop();
	// int operand2 = s.pop();
	// s.push(performOperation(operand1, operand2, c));
	// }
	//
	// }

	public static int performOperation(int operand1, int operand2, char c) {
		int result = -1;

		switch (c) {
		case '+':
			result = operand1 + operand2;
			break;
		case '-':
			result = operand1 - operand2;
			break;
		case '*':
			result = operand1 * operand2;
			break;
		case '/':
			result = (operand1 / operand2);
			break;
		default:
			System.out.println("Enter valid operator");
			break;
		}

		return result;
	}

	public static boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/') {
			return true;
		}
		return false;
	}

	public static boolean isSymmetric(Node node) {
		// return isMirrorTree(node, node);
		return isMirror(node);

	}

	public static boolean isMirrorTree(Node n1, Node n2) {
		if (n1 == null && n2 == null) {
			return true;
		}

		if (n1 != null && n2 != null && n1.data == n2.data) {
			return isMirrorTree(n1.left, n2.right) && isMirrorTree(n1.right, n2.left);
		}
		return false;
	}

	public static boolean isMirror(Node node) {
		if (node == null) {
			return true;
		}
		return isMirror(node.left, node.right);
	}

	public static boolean isMirror(Node n1, Node n2) {

		if (n1 == null && n2 == null) {
			return true;
		}

		if (n1 == null || n2 == null) {
			return false;
		}
		boolean isMirror = n1.data == n2.data;
		return isMirror && isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left);
	}

	public static void printReverseLevelOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.println("\nReverse Order is :");
		Stack<Node> s = new Stack<>();
		Queue<Node> q = new ArrayDeque<>();
		q.add(node);
		Node current = null;
		while (!q.isEmpty()) {
			current = q.poll();
			s.push(current);
			if (current.left != null) {
				q.add(current.left);

			}

			if (current.right != null) {
				q.add(current.right);
			}
		}

		while (!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}

	}

	public static void printInSpiral(Node n) {
		if (n == null) {
			return;
		}
		System.out.println("\n Printing in Spriral");
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		// Add the root to the stack
		s1.push(n);
		Node current;
		// Iterate on the stacks now
		while (!s1.isEmpty() || !s2.isEmpty()) {

			// Iterate on each stack and add the nodes
			while (!s1.isEmpty()) {
				current = s1.pop();
				System.out.print(current + " ");
				if (current.right != null) {
					s2.push(current.right);
				}
				if (current.left != null) {
					s2.push(current.left);
				}
			}

			while (!s2.isEmpty()) {
				current = s2.pop();
				System.out.print(current + " ");
				if (current.left != null) {
					s1.push(current.left);
				}
				if (current.right != null) {
					s1.push(current.right);
				}
			}
		}
	}

	public static void printLevelOrderWithOneLine(Node node) {
		if (node == null) {
			return;
		}

		Queue<Node> q = new ArrayDeque<>();
		q.add(node);
		q.add(new Node(-1));
		Node current;
		while (!q.isEmpty()) {
			current = q.poll();

			if (current != null && current.data == -1) {
				if (!q.isEmpty()) {
					q.add(new Node(-1));
					System.out.println("");
				}
			} else {
				System.out.print(current + " ");
				if (current.left != null) {
					q.add(current.left);
				}
				if (current.right != null) {
					q.add(current.right);
				}
			}
		}
	}

	// public static boolean isSubsetTree(Node n1, Node n2) {
	// if (n1 == null || n2 == null) {
	// return false;
	// }
	//
	// List<Integer> list1 = new ArrayList();
	// populateList(n1, list1);
	// List<Integer> list2 = new ArrayList();
	// populateList(n2, list2);
	//
	// // check the second list is a subList of the first list.
	// // if yes, then true.
	// // Perform a sliding window solution to check the sub array
	//
	//
	// }

	public static void populateList(Node n, List list) {
		if (n == null) {
			return;
		}
		populateList(n.left, list);
		list.add(n.data);
		populateList(n.right, list);
	}

	public static int binaryTreeSum(Node node) {
		if (node == null) {
			return 0;
		}
		return node.data + binaryTreeSum(node.left) + binaryTreeSum(node.right);
	}

	public static int sizeOfTree(Node n) {
		if (n == null) {
			return 0;
		}
		return 1 + sizeOfTree(n.left) + sizeOfTree(n.right);
	}

	public static int sizeOfTreeIterative(Node n) {
		if (n == null) {
			return 0;
		}

		int size = 0;

		Queue<Node> q = new ArrayDeque();
		q.add(n);
		Node current;
		while (!q.isEmpty()) {
			current = q.poll();
			size++;
			if (current.left != null) {
				q.add(current.left);
			}
			if (current.right != null) {
				q.add(current.right);
			}
		}

		return size;
	}

	public static Node deleteLeafNode(Node n, int x) {
		if (n == null) {
			return null;
		}
		if (n.left != null) {
			n.left = deleteLeafNode(n.left, x);
		}
		if (n.right != null) {
			n.right = deleteLeafNode(n.right, x);
		}
		if (n.data == x && n.left == null && n.right == null) {
			return null;
		}

		return n;
	}

	public static int height(Node root) {
		// Write your code here.
		if (root == null) {
			return 0;
		}

		Queue<Node> q = new ArrayDeque<>();
		q.add(root);
		int height = 0;
		Node current;
		while (true) {
			// get the size of the current queue
			int nodeCount = q.size();
			if (nodeCount == 0) {
				return height;
			}
			height++;

			while (nodeCount > 0) {
				current = q.poll();
				if (current.left != null) {
					q.add(current.left);
				}
				if (current.right != null) {
					q.add(current.right);
				}
				nodeCount--;
			}
		}

	}

	public static boolean areSame(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return true;
		}
		if (node1 == null || node2 == null) {
			return false;
		}
		return (node1.data == node2.data) && areSame(node1.left, node2.left) && areSame(node1.right, node2.right);
	}

	public static int maxDepth(Node node) {
		// If the node == null then return 0;
		if (node == null) {
			return 0;
		} else {
			// Get the left subtree depth
			int lDepth = maxDepth(node.left);
			// Get the right subtree depth
			int rDepth = maxDepth(node.right);
			// Add 1 to the max of the depth for this node
			return Math.max(lDepth, rDepth) + 1;
		}
	}

	public static int maxHeightIterative(Node node) {
		if (node == null) {
			return 0;
		}

		int height = 0;
		Queue<Node> q = new ArrayDeque<>();
		q.add(node);
		Node current = null;
		// Iterative until the queue is empty
		while (true) {
			// Check the no of nodes in this level
			int noOfNodes = q.size();
			if (noOfNodes == 0) {
				return height;
			}
			// If the no of nodes in current lvel is 0, then return
			// Or else increment the height
			height++;

			while (noOfNodes > 0) {
				// Iterate on the count and add the left and right to the queue
				current = q.poll();
				if (current.left != null) {
					q.add(current.left);
				}
				if (current.right != null) {
					q.add(current.right);
				}
				// Itrate that particular level and add them to the queue
				noOfNodes--;
			}

		}
	}

	public static void deleteNode(Node node, int x) {
		if (node == null) {
			return;
		}
		// Get the node to be deleted and the last node by iterating the tree
		// with BFS
		Node delNode = null;
		Node lastNode = null;
		Queue<Node> q = new ArrayDeque<>();
		q.add(node);
		// Iterate on the queue untill we reach the last node.

		while (!q.isEmpty()) {
			lastNode = q.poll();
			if (lastNode.data == x) {
				delNode = lastNode;
			}
			if (lastNode.left != null) {
				q.add(lastNode.left);
			}
			if (lastNode.right != null) {
				q.add(lastNode.right);
			}
		}

		// If the key is not found then return.
		if (delNode == null) {
			return;
		}
		// Get the last nodes value since we are deleting it
		int c = lastNode.data;
		// Now iterate the root with DFS and then delete that deepest node.
		deleteDeepestNode(node, lastNode);
		// Now update the delNode value with the last node value;
		delNode.data = c;
	}

	public static void deleteDeepestNodeFound(Node node, Node lastNode) {
		if (node == null || lastNode == null) {
			return;
		}

		Queue<Node> q = new ArrayDeque<>();
		q.add(node);
		Node current;
		while (!q.isEmpty()) {
			// get the first element
			current = q.poll();
			// check whether the left node is the node which we are searching
			if (current.left != null) {
				if (current.left == lastNode) {
					current.left = null;
					return;
				} else {
					q.add(current.left);
				}
			}

			// check whether the left node is the node which we are searching
			if (current.right != null) {
				if (current.right == lastNode) {
					current.right = null;
					return;
				} else {
					q.add(current.right);
				}
			}
		}

	}

	public static void spiralPrint(Node node) {
		if (node == null) {
			return;
		}

		Stack<Node> s1 = new Stack();
		Stack<Node> s2 = new Stack();

		s1.push(node);
		Node current = null;
		boolean done = false;
		while (!done) {

			// Check the first stack for he nodes
			while (!s1.isEmpty()) {
				current = s1.pop();
				System.out.print(current + " ");
				if (current.right != null) {
					s2.push(current.right);
				}
				if (current.left != null) {
					s2.push(current.left);
				}
			}

			// Check the second stack for he nodes
			while (!s2.isEmpty()) {
				current = s2.pop();
				System.out.print(current + " ");
				if (current.left != null) {
					s1.push(current.left);
				}
				if (current.right != null) {
					s1.push(current.right);
				}
			}

			if (s1.isEmpty() && s2.isEmpty()) {
				done = true;
			}

		}

	}

	public static void printLevelReverseOrder(Node node) {
		if (node == null) {
			return;
		}
		Queue<Node> q = new ArrayDeque();
		Stack<Node> s = new Stack();
		q.add(node);
		Node current = null;
		while (!q.isEmpty()) {
			current = q.poll();
			s.push(current);
			if (current.left != null) {
				q.add(current.left);
			}
			if (current.right != null) {
				q.add(current.right);
			}
		}

		while (!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}

	}

	public static void printInSpecificOrder(Node node) {
		if (node == null) {
			return;
		}

		// Lets take two queues
		Queue<Node> q1 = new ArrayDeque();
		q1.add(node);

		Node current = null;
		while (!q1.isEmpty()) {
			// get the first node from q1 and then print
			int noOfNodes = q1.size();
			System.out.println();
			int i = 0;
			while (noOfNodes > 0) {
				current = q1.poll();
				if (i == 0) {
					System.out.print(current + " ");
				}
				if (current.left != null) {
					q1.add(current.left);
				}
				if (current.right != null) {
					q1.add(current.right);
				}
				i++;
				noOfNodes--;
			}

		}

	}

	public static int returnNextSiblingValue(Node node, int x) {
		if (node == null) {
			return -1;
		}

		int result = -1;

		// Perform a BFS and check whether it matches our search term
		Queue<Node> q = new ArrayDeque();
		q.add(node);
		Node current = null;
		Queue<Node> q2 = new ArrayDeque();
		// While the queue is emoty
		while (!q.isEmpty()) {
			// check the no of nodes at current level
			int size = q.size();

			// iterate all the nodes in that level
			while (size > 0) {
				current = q.poll();
				// check wehter the current node is matching with the search
				// data
				if (current.data == x) {
					// also check whether the q is empty
					if (q.isEmpty()) {
						return -1;
					}
					// If not..just peek the first element and data from it
					return q.peek().data;
				}
				if (current.left != null) {
					q2.add(current.left);
				}
				if (current.right != null) {
					q2.add(current.right);
				}
				size--;
			}
			while (!q2.isEmpty()) {
				q.add(q2.poll());
			}
		}
		return result;
	}

	public static boolean isBalanceBinaryTree(Node node) {
		if (node == null) {
			return true;
		}

		if (node.left == null && node.right == null) {
			return true;
		}

		if (node.left == null || node.right == null) {
			return false;
		}
		return isBalanceBinaryTree(node.left) && isBalanceBinaryTree(node.right);

	}

	public static void mirrortree(Node node) {
		if (node == null) {
			return;
		}

		if (node.left != null && node.right != null) {
			int temp = node.left.data;
			node.left.data = node.right.data;
			node.right.data = temp;
		}
		mirrortree(node.left);
		mirrortree(node.right);
	}

	public static void printcornerNodes(Node n) {
		if (n == null) {
			return;
		}
		Queue<Node> q = new ArrayDeque();
		q.add(n);
		Node current;
		while (!q.isEmpty()) {
			int len = q.size();
			if (len == 0) {
				return;
			}

			int i = 0;
			while (len > 0) {
				current = q.poll();
				if (i == 0 || i == q.size() - 1) {
					System.out.print(current + " ");
				}

				if (current.left != null) {
					q.add(current.left);
				}
				if (current.right != null) {
					q.add(current.right);
				}

				len--;
				i++;
			}

		}

	}

	public static boolean isNumber(String s) {
		boolean isNumber = false;
		if (s == null || s.length() == 0) {
			return false;
		}
		s = s.trim();
		if (s.startsWith("-")) {
			s = s.substring(1);
		}

		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			int c = chars[i];
			if (c < 48 || c > 57) {
				return false;
			}
		}

		return true;
	}

	public static Node findLCA(Node node, int n1, int n2) {
		// Bas ecase check for the null
		if (node == null) {
			return null;
		}

		// First check whether this current node data is equal to the n1 or n2
		if (node.data == n1 || node.data == n2) {
			return node;
		}

		// If not equal , the goto left sub tree and then find the left matching
		// node
		Node leftLca = findLCA(node.left, n1, n2);
		// If not equal , the goto right sub tree and then find the right
		// matching node
		Node rightLca = findLCA(node.right, n1, n2);

		if (leftLca != null && rightLca != null) {
			return node;
		}
		return leftLca != null ? leftLca : rightLca;
	}

	boolean v1 = false;
	boolean v2 = false;

	public Node findLCAWithNoKey(Node root, int n1, int n2) {
		if (root == null) {
			return null;
		}
		if (root.data == n1) {
			v1 = true;
			return root;
		}

		if (root.data == n2) {
			v2 = true;
			return root;
		}

		Node lcaLeft = findLCAWithNoKey(root.left, n1, n2);
		Node lcaRight = findLCAWithNoKey(root.right, n1, n2);

		if (lcaLeft != null && lcaRight != null) {
			return root;
		}

		return (lcaLeft != null ? lcaLeft : lcaRight);
	}

	public boolean find(Node node, int n) {
		if (node == null) {
			return false;
		}
		if (node.data == n && find(node.left, n) && find(node.right, n)) {
			return true;
		}
		return false;
	}

	Node findLcaWithNull(Node root, int n1, int n2) {
		if (root == null) {
			return null;
		}

		Node n = findLCAWithNoKey(root, n1, n2);

		if (v1 && v2) {
			return n;
		}
		return null;
	}

	boolean n1Found = false;
	boolean n2Found = false;

	public int findMinDistanceBetweenTwoNodes(Node node, int n1, int n2) {
		if (node == null) {
			return -1;
		}
		// The logic here is to find the LCA for these two nodes
		// Then find the depth of those nodes from the LCa
		Node lca = findLca(node, n1, n2);
		// Then sum of those depths would be the min distance between those
		// nodes
		if (n1Found && n2Found && lca != null) {
			int dist1 = findDistance(lca, n1, 0);
			int dist2 = findDistance(lca, n2, 0);
			return dist1 + dist2;
		}
		return -1;
	}

	private int findDistance(Node lca, int n, int level) {
		if (lca == null) {
			return -1;
		}
		// Check if the roots data is equal to the data passed. If yes, send
		// this level
		if (lca.data == n) {
			return level;
		}
		// /If not matched, then check the left sub tree for the search item.
		// and get the distance.

		int dist = findDistance(lca.left, n, level + 1);
		// If not found in the left sub treewith level -1, then we should search
		// in the right sub tree
		if (dist == -1) {
			dist = findDistance(lca.right, n, level + 1);
		}
		return dist;
	}

	public Node findLca(Node node, int n1, int n2) {
		if (node == null) {
			return null;
		}

		// Check whethet the data of the root is matching with one of the data
		// passed
		if (node.data == n1) {
			n1Found = true;
			return node;
		}
		if (node.data == n2) {
			n2Found = true;
			return node;
		}

		// Then check the left sub tree and the right sub tree
		Node leftMatching = findLca(node.left, n1, n2);
		Node rightMatching = findLca(node.right, n1, n2);

		// If there is a match for both the nodes, then return the current node,
		// since this would be the LCA for those nodes
		if (leftMatching != null && rightMatching != null) {
			return node;
		}
		return leftMatching != null ? leftMatching : rightMatching;
	}

	public static void printAllCommanAncestors(Node root, int n1, int n2) {
		if (root == null) {
			return;
		}
		// First we will find the LCA for these two numbers
		Node lca = findLCA(root, n1, n2);
		// If this LCA is not null, then we can travel from the root to this LCA
		// and print all the nodes
		if (lca != null) {
			printFromRootToLCA(root, lca.data);
		}

	}

	private static boolean printFromRootToLCA(Node root, int target) {
		if (root == null) {
			return false;
		}
		if (root.data == target) {
			System.out.print(target + " ");
			return true;
		}
		if (printFromRootToLCA(root.left, target) || printFromRootToLCA(root.right, target)) {
			System.out.print(root + " ");
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(11);
		root.left.left = new Node(7);
		root.left.right = new Node(12);
		root.right = new Node(9);
		root.right.left = new Node(15);
		root.right.right = new Node(8);
		System.out.println("After insertion");
		displayInOrder(root);
		deleteBottomMost(root, 11);
		System.out.println("\nAfter Deletion");

		displayInOrder(root);

		Node r = new Node(3);
		r.left = new Node(2);
		r.right = new Node(4);
		r.left.left = new Node(1);
		r.left.right = new Node(3);
		System.out.println();
		if (isContinousTree(r)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

		Node fold = new Node(1);
		fold.left = new Node(2);
		fold.right = new Node(3);
		fold.right.left = new Node(4);
		fold.left.right = new Node(5);
		if (isFoldable(fold)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

		String postfix = "ab+ef*g*-";
		getInfixNotation(postfix.toCharArray());

		CharNode expr = new CharNode('+');
		expr.left = new CharNode('*');
		expr.left.left = new CharNode('5');
		expr.left.right = new CharNode('4');
		expr.right = new CharNode('-');
		expr.right.left = new CharNode('0');
		expr.right.right = new CharNode('2');

		// System.out.println(evaluateTree(expr));

		Node symRoot = new Node(1);
		symRoot.left = new Node(2);
		symRoot.right = new Node(3);
		symRoot.left.left = new Node(4);
		symRoot.left.right = new Node(5);
		symRoot.right.left = new Node(6);
		symRoot.right.right = new Node(7);
		symRoot.right.left.right = new Node(8);
		System.out.println("\n" + isSymmetric(symRoot));

		printReverseLevelOrder(symRoot);
		System.out.println("new reverse ");
		printLevelReverseOrder(symRoot);
		printInSpiral(symRoot);
		System.out.println("Spiral new");
		spiralPrint(symRoot);

		printLevelOrderWithOneLine(symRoot);
		System.out.println("\n total sum is " + binaryTreeSum(symRoot));
		System.out.println("\nSize of the tree is " + sizeOfTree(symRoot));
		System.out.println("\nSize of the tree is " + sizeOfTreeIterative(symRoot));

		Node delRoot = new Node(10);
		delRoot.left = new Node(3);
		delRoot.right = new Node(10);
		delRoot.left.left = new Node(3);
		delRoot.left.right = new Node(1);
		delRoot.right.right = new Node(3);
		delRoot.right.right.left = new Node(3);
		delRoot.right.right.right = new Node(3);
		System.out.println("\ndeleting the leaf node ");
		deleteLeafNode(delRoot, 3);
		inOrderTraversal(delRoot);

		Node rightNode = new Node(3);
		rightNode.left = new Node(2);
		rightNode.right = new Node(4);
		rightNode.left.left = new Node(1);
		rightNode.left.right = new Node(3);

		Node leftNode = new Node(3);
		leftNode.left = new Node(2);
		leftNode.right = new Node(4);
		leftNode.left.left = new Node(1);
		leftNode.left.right = new Node(3);
		System.out.println("Are same");
		System.out.println(areSame(rightNode, leftNode));

		Node maxDepthRoot = new Node(1);
		maxDepthRoot.left = new Node(2);
		maxDepthRoot.right = new Node(3);
		maxDepthRoot.left.left = new Node(4);
		maxDepthRoot.left.right = new Node(5);
		maxDepthRoot.left.right.left = new Node(7);
		System.out.println("\nMax depth is " + maxDepth(maxDepthRoot));
		System.out.println("\nMax depth iterative is " + maxHeightIterative(maxDepthRoot));

		System.out.println("Before deletion");
		printLevelOrderWithOneLine(maxDepthRoot);
		deleteNode(maxDepthRoot, 3);
		System.out.println("After deletion");
		printLevelOrderWithOneLine(maxDepthRoot);
		System.out.println("\n print in specific order");

		Node sNode = new Node(1);
		sNode.left = new Node(2);
		sNode.right = new Node(3);
		sNode.left.left = new Node(4);
		sNode.left.right = new Node(5);
		sNode.right.left = new Node(6);
		sNode.right.right = new Node(7);

		printInSpecificOrder(sNode);
		System.out.println("Next sibling i s: " + returnNextSiblingValue(sNode, 8));

		System.out.println("\nBefore mirror");
		printLevelOrderWithOneLine(sNode);
		System.out.println("\nAfter mirror");
		mirrortree(sNode);
		printLevelOrderWithOneLine(sNode);
		System.out.println("Conrner nodes\n");
		String s = "Srikanth";
		System.out.println(s.substring(1));
		printcornerNodes(sNode);
		System.out.println("" + (int) 'e');

		System.out.println(isNumber("e"));

		Node lcaNode = new Node(1);
		lcaNode.left = new Node(2);
		lcaNode.right = new Node(3);
		lcaNode.left.left = new Node(4);
		lcaNode.left.right = new Node(5);
		lcaNode.right.left = new Node(6);
		lcaNode.right.right = new Node(7);
		lcaNode.right.left.right = new Node(8);
		// System.out.println("LCA(4, 5) = " + findLCA(lcaNode, 4, 5).data);
		// System.out.println("LCA(4, 6) = " + findLCA(lcaNode, 4, 6).data);
		// System.out.println("LCA(3, 4) = " + findLCA(lcaNode, 3, 4).data);
		// System.out.println("LCA(2, 4) = " + findLCA(lcaNode, 2, 4).data);
		BinaryTreeOperations bo = new BinaryTreeOperations();
		// System.out.println("No key ");
		// System.out.println("LCA(2, 4) = " + bo.findLcaWithNull(lcaNode, 2,
		// 4));
		System.out.println("Min distance between the nodes");
		System.out.println(bo.findMinDistanceBetweenTwoNodes(lcaNode, 5, 8));

		Node lc = new Node(1);
		lc.left = new Node(2);
		lc.right = new Node(3);
		lc.left.left = new Node(4);
		lc.left.right = new Node(5);
		lc.right.left = new Node(6);
		lc.right.right = new Node(7);
		lc.left.left.left = new Node(8);
		lc.right.left.left = new Node(9);
		lc.right.left.right = new Node(10);
		System.out.println("Print all ancestors of the nodes");
		printAllCommanAncestors(lc, 9, 10);
	}

}
