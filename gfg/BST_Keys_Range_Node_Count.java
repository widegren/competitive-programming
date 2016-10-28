package gfg;

import java.util.Scanner;

public class BST_Keys_Range_Node_Count {
	Node root;

	void insert(Node root, int key) {
		// System.out.print(key);
		if (key < root.intdata) { // System.out.print(root.key);
			if (root.left != null)
				insert(root.left, key);
			else {
				root.left = new Node(key);
				// System.out.print(root.left.key);
			}

			// root = root.left;
			// insert(root.left,key);
		} else if (key > root.intdata) {
			// System.out.print(root.key);
			if (root.right != null)
				insert(root.right, key);
			else {
				root.right = new Node(key);
				// System.out.print(root.right.key);
			}
			// root = root.right;
			// insert(root.right, key);
			// System.out.println(key);

		}
	}

	/*
	 * void inorder(Node node) { if(node==null) return ; else
	 * inorder(node.left); System.out.print(node.key + " ");
	 * inorder(node.right);
	 * 
	 * }
	 */

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		// Node root;

		while (t > 0) {
			// Node root;
			// Node tmp;
			// root = null;
			int n = sc.nextInt();
			BST_Keys_Range_Node_Count tree = new BST_Keys_Range_Node_Count();
			// GfG g = new GfG();
			int a1 = sc.nextInt();
			Node root = new Node(a1);

			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				tree.insert(root, a);
			}

			int l = sc.nextInt();
			int h = sc.nextInt();

			int k = getCountOfNode(root, l, h);
			System.out.println(k);

			t--;
		}
	}

	static int getCountOfNode(Node root, int low, int high) {
		if (root == null) {
			return 0;
		}

		if (root.intdata <= high && root.intdata >= low) {
			return 1 + getCountOfNode(root.left, low, high) + getCountOfNode(root.right, low, high);
		}

		else if (root.intdata < low)
			return getCountOfNode(root.right, low, high);

		else
			return getCountOfNode(root.left, low, high);
	}
}