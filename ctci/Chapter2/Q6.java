package Chapter2;

/**
 * 
 * @author emeliewidegren
 *
 *         Given a circular linked list, implement an algorithm which returns
 *         the node at the beginning of the loop
 */
public class Q6 {
	public static void main(String[] args) {
		Q2 list = new Q2();
		list.head = new Node(7);
		list.head.next = new Node(1);
		list.head.next.next = new Node(6);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = list.head.next;

		System.out.println(detectLoop(list.head));
	}

	public static int detectLoop(Node head) {
		Node slow = head, fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		if (fast == null || fast.next == null) {
			return 0;
		}

		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return fast.data;
	}
}
