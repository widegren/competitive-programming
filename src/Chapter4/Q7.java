package Chapter4;

/**
 * 
 * @author emeliewidegren
 *
 *         Design an algorithm and write code to find the first common ancestor
 *         of two nodes in a binary tree. Avoid storing additional nodes in a
 *         data structure. NOTE: This is not necessarily a binary search tree.
 */
public class Q7 {

	public static int covers(TreeNode root, TreeNode p, TreeNode q) {
		int ret = 0;
		if (root == null)
			return ret;
		if (root == p || root == q)
			ret += 1;
		ret += covers(root.left, p, q);

		if (ret == 2) // Found p and q
			return ret;
		return ret + covers(root.right, p, q);
	}

	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (q == p && (root.left == q || root.right == q))
			return root;

		int nodesFromLeft = covers(root.left, p, q); // Check left side
		if (nodesFromLeft == 2) {
			if (root.left == p || root.left == q)
				return root.left;
			else
				return commonAncestor(root.left, p, q);
		} else if (nodesFromLeft == 1) {
			if (root == p)
				return p;
			else if (root == q)
				return q;
		}

		int nodesFromRight = covers(root.right, p, q); // Check right side
		if (nodesFromRight == 2) {
			if (root.right == p || root.right == q)
				return root.right;
			else
				return commonAncestor(root.right, p, q);
		} else if (nodesFromRight == 1) {
			if (root == p)
				return p;
			else if (root == q)
				return q;
		}

		if (nodesFromLeft == 1 && nodesFromRight == 1)
			return root;
		else
			return null;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		TreeNode root = TreeNode.createMinimalBST(array);
		TreeNode n3 = root.find(1);
		TreeNode n7 = root.find(7);

		TreeNode ancestor = commonAncestor(root, n3, n7);
		System.out.println(ancestor.data);
	}
}
