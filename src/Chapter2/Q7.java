package Chapter2;

import java.util.Stack;

/**
 * 
 * @author emeliewidegren
 *
 * Implement a function to check if a linked list is a palindrome.
 */
public class Q7 {
	public static void main(String[] args) {
		Q2 list = new Q2();
		list.head = new Node(7);
		list.head.next = new Node(1);
		list.head.next.next = new Node(1);
		list.head.next.next.next = new Node(7);

		System.out.println(isPalindrome(list.head));
	}

	public static boolean isPalindrome(Node head) {
		Stack<Integer> stack = new Stack<Integer>();
		
		Node tmp = head;
		
		while(tmp != null){
			stack.push(tmp.data);
			tmp = tmp.next;
		}
		
		while(head != null){
			int top = stack.pop().intValue();
			if(head.data != top){
				return false;
			}
			head = head.next;
		}
		return true;
	}
}
