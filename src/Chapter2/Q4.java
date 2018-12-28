package Chapter2;

/**
 * 
 * @author emeliewidegren
 *
 *         Write code to partition a linked list around a value x, such that all
 *         nodes less than x come before all nodes greater than or equal to x.
 */
public class Q4 {
	public static void main(String[] args) {
		Q1 list = new Q1();
		list.head = new Node(50);
		list.head.next = new Node(20);
		list.head.next.next = new Node(15);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(10);
		list.head.next.next.next.next.next = new Node(4);
		list.head.next.next.next.next.next.next = new Node(6);

		list.printList(lessThanX(list.head, 9));
	}

	public static Node lessThanX(Node node, int x) {
		Node beforeStart = null;
		Node beforeEnd = null;
		Node afterStart = null;
		Node afterEnd = null;

		/* Partition list */
		while (node != null) {
			Node next = node.next;
			node.next = null;
			if (node.data < x) {
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {
				if (afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}

		/* Merge before list and after list */
		if (beforeStart == null) {
			return afterStart;
		}

		beforeEnd.next = afterStart;
		return beforeStart;
	}
}
