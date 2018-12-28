package Chapter2;

/**
 * 
 * @author emeliewidegren
 *
 *         Implement an algorithm to find the kth to last element of a singly
 *         linked list.
 */
public class Q2 {
	Node head;

	public static void main(String[] args) {
		Q2 list = new Q2();
		list.head = new Node(50);
		list.head.next = new Node(20);
		list.head.next.next = new Node(15);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(10);
		list.head.next.next.next.next.next = new Node(4);
		list.head.next.next.next.next.next.next = new Node(6);

		kthToLast(list.head, 2);
	}

	public static int kthToLast(Node head, int n) {
		if (n == 0 || head == null) {
			return 0;
		}
		int k = kthToLast(head.next, n) + 1;
		if (k == n) {
			System.out.println(n + "th to last node is " + head.data);
		}
		return k;
	}

	public static Node nthToLast(Node head, int n) {
		Node p1 = head;
		Node p2 = head;

		if (n <= 0)
			return null;

		// Move p2 n nodes into the list. Keep n1 in the same position.
		for (int i = 0; i < n - 1; i++) {
			if (p2 == null) {
				return null; // Error: list is too small.
			}
			p2 = p2.next;
		}
		if (p2 == null) { // Another error check.
			return null;
		}

		// Move them at the same pace. When p2 hits the end,
		// p1 will be at the right element.
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
}
