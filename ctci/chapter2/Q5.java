package Chapter2;
/**
 * 
 * @author emeliewidegren
 *
 * You have two numbers represented by a linked list, where each node contains a
 * single digit. The digits are stored in reverse order, such that the 1's digit is at the
 * head of the list. Write a function that adds the two numbers and returns the sum
 * as a linked list.
 */
public class Q5 {
	public static void main(String[] args) {
		Q2 list = new Q2();
		list.head = new Node(7);
		list.head.next = new Node(1);
		list.head.next.next = new Node(6);
		
		Q2 list2 = new Q2();
		list2.head = new Node(5);
		list2.head.next = new Node(9);
		list2.head.next.next = new Node(2);

		System.out.println(addLinkedLists(list.head, list2.head));
	}

	private static int addLinkedLists(Node node1, Node node2) {
		int nr1 = 0, nr2 = 0, mul = 1;
		
		while(node1 != null){
			nr1 = nr1 + mul*node1.data;
			node1 = node1.next;
			mul *= 10;
		}
		mul = 1;
		while(node2 != null){
			nr2 = nr2 + mul*node2.data;
			node2 = node2.next;
			mul *= 10;
		}
		return nr1+nr2;
	}
}
