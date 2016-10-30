package Chapter4;

/**
 * 
 * @author emeliewidegren
 *
 * Implement a function to check if a binary tree is balanced. For the purposes of
 * this question, a balanced tree is defined to be a tree such that the heights of the
 * two subtrees of any node never differ by more than one.
 */
public class Q1 {
	public static int checkHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = checkHeight(root.left);
		if (leftHeight == -1) {
			return -1;
		}
		int rightHeight = checkHeight(root.right);
		if (rightHeight == -1) {
			return -1;
		}
		
		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1) {
			return -1;
		}
		else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	
	public static boolean isBalanced(TreeNode root) {
		if (checkHeight(root) == -1) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void main(String[] args) {
		// Create balanced tree
		int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);

		System.out.println("Is balanced? " + isBalanced(root));
		
		root.insertInOrder(4); // Add 4 to make it unbalanced

		System.out.println("Is balanced? " + isBalanced(root));
		
		System.out.print("Inorder traversal: ");
		inorder(root);
		System.out.println(" ");
		System.out.print("Preorder traversal: ");
		preorder(root);
		System.out.println(" ");
		System.out.print("Postorder traversal: ");
		postorder(root);
	}
	
	public static void inorder(TreeNode root){
		if(root != null){
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}
	
	public static void preorder(TreeNode root){
		if(root != null){
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public static void postorder(TreeNode root){
		if(root != null){
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + " ");
		}
	}
}
