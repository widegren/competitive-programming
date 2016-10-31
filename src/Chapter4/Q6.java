package Chapter4;

/**
 * 
 * @author emeliewidegren
 *
 *         Write an algorithm to find the'next'node (i.e., in-order successor)
 *         of a given node in a binary search tree. You may assume that each
 *         node has a link to its parent
 */
public class Q6 {
	public static void main(String[] args) {
		int[] nodes_flattened = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		TreeNode root = TreeNode.createMinimalBST(nodes_flattened);
		inorder(root);
		System.out.println("");
		System.out.println(findNext(root.find(nodes_flattened[6])).data);
	}

	public static TreeNode findNext(TreeNode root) {
		if (root == null)
			return null;
		if (root.parent == null || root.right != null) {
			TreeNode n = root.right;
			while (n.left != null) {
				n = n.left;
			}
			return n;
		} else {
			TreeNode q = root;
			TreeNode x = q.parent;
			// Go up until we’re on left instead of right
			while (x != null && x.left != q) {
				q = x;
				x = x.parent;
			}
			return x;
		}
	}

	public static void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	public static void preorder(TreeNode root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}

}
