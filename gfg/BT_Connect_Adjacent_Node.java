package gfg;

import java.util.Scanner;
import java.lang.Integer;
import java.util.HashMap;
//import java.lang.Math;
import java.util.Queue;
import java.util.LinkedList;
import java.io.*;

public class BT_Connect_Adjacent_Node {
	void inorder(Node node) {
		if (node == null)
			return;
		else
			inorder(node.left);
		System.out.print(node.intdata + " ");
		inorder(node.right);

	}

	void printSpecial(Node root) {
		if (root == null)
			return;
		Node node = root;
		while (node != null) {
			System.out.print(node.intdata + " ");
			node = node.nextRight;
		}
		if (root.left != null)
			printSpecial(root.left);
		else
			printSpecial(root.right);

	}

	// driver function to test the above functions
	public static void main(String args[]) {

		// Input the number of test cases you want to run
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		BT_Connect_Adjacent_Node can = new BT_Connect_Adjacent_Node();
		// Node root=null;

		while (t > 0) {
			HashMap<Integer, Node> m = new HashMap<Integer, Node>();
			int n = sc.nextInt();

			Node root = null;

			while (n > 0) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				char lr = sc.next().charAt(0);

				// cout << n1 << " " << n2 << " " << (char)lr << endl;
				Node parent = m.get(n1);
				if (parent == null) {
					parent = new Node(n1);
					m.put(n1, parent);
					if (root == null)
						root = parent;
				}

				Node child = new Node(n2);
				if (lr == 'L')
					parent.left = child;
				else
					parent.right = child;
				m.put(n2, child);
				n--;
			}

			connect(root);
			can.printSpecial(root);
			System.out.println();
			can.inorder(root);
			System.out.println();
			t--;

		}
	}
	
	static void connect(Node root){
		// Base case
        if (root == null)
            return;
  
        // Set the nextRight pointer for p's left child
        if (root.left != null)
            root.left.nextRight = root.right;
  
        // Set the nextRight pointer for p's right child
        // p->nextRight will be NULL if p is the right most child 
        // at its level
        if (root.right != null) 
            root.right.nextRight = (root.nextRight != null) ? 
                                         root.nextRight.left : null;
  
        // Set nextRight for other nodes in pre order fashion
        connect(root.left);
        connect(root.right);
	}
}