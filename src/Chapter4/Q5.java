package Chapter4;

/**
 * 
 * @author emeliewidegren
 *
 * Implement a function to check if a binary tree is a binary search tree.
 */
public class Q5 {
	public static void main(String[] args) {
		int[] nodes_flattened = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		TreeNode root = TreeNode.createMinimalBST(nodes_flattened);
		System.out.println(root.isBST());
	}
}
