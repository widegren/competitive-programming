package Chapter4;

import java.util.*;

/**
 * 
 * @author emeliewidegren
 *
 *         You have two very large binary trees: T1, with millions of nodes, and
 *         T2, with hundreds of nodes. Create an algorithm to decide if T2 is a
 *         subtree of T1. A tree T2 is a subtree of T1 if there exists a node n
 *         in T1 such that the subtree of n is identical to T2. That is, if you
 *         cut off the tree at node n, the two trees would be identical.
 */
public class Q8 {
	public static void main(String[] args) {
		int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		int[] array2 = { 2, 4, 5, 8, 9, 10, 11 };
		int[] array3 = { 1, 2, 3 };

		TreeNode t1 = createTreeFromArray(array1);
		TreeNode t2 = createTreeFromArray(array2);
		TreeNode t3 = createTreeFromArray(array3);

		if (containsTree(t1, t2))
			System.out.println("t2 is a subtree of t1");
		else
			System.out.println("t2 is not a subtree of t1");

		if (containsTree(t1, t3))
			System.out.println("t4 is a subtree of t3");
		else
			System.out.println("t4 is not a subtree of t3");
	}

	public static boolean containsTree(TreeNode t1, TreeNode t2) {
		if (t2 == null)
			return true; // The empty tree is a subtree of every tree.
		else
			return subTree(t1, t2);
	}

	public static boolean subTree(TreeNode t1, TreeNode t2) {
		if (t1 == null)
			return false; // big tree empty & subtree still not found.

		if (t1.data == t2.data) {
			if (matchTree(t1, t2))
				return true;
		}
		return (subTree(t1.left, t2) || subTree(t1.right, t2));
	}

	public static boolean matchTree(TreeNode t1, TreeNode t2) {
		if (t2 == null && t1 == null)
			return true; // nothing left in the subtree
		if (t1 == null || t2 == null)
			return false; // big tree empty & subtree still not found
		if (t1.data != t2.data)
			return false; // data doesn’t match
		return (matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right));
	}

	public static TreeNode createTreeFromArray(int[] array) {
		if (array.length > 0) {
			TreeNode root = new TreeNode(array[0]);
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			boolean done = false;
			int i = 1;
			while (!done) {
				TreeNode r = (TreeNode) queue.element();
				if (r.left == null) {
					r.left = new TreeNode(array[i]);
					i++;
					queue.add(r.left);
				} else if (r.right == null) {
					r.right = new TreeNode(array[i]);
					i++;
					queue.add(r.right);
				} else {
					queue.remove();
				}
				if (i == array.length)
					done = true;
			}
			return root;
		} else {
			return null;
		}
	}
}
