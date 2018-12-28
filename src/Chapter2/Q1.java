package Chapter2;

import java.util.HashSet;

/**
 * 
 * @author emeliewidegren
 *
 *         Write code to remove duplicates from an unsorted linked list.
 */

class Node {
	Node head, next;
	int data;

	public Node(int data) {
		this.data = data;
		next = null;
	}

	public Node clone() {
		Node tmp = null;
		if (next != null) {
			tmp = next.clone();
		}
		Node head2 = new Node(data);
		head2.next = tmp;
		return head2;
	}
}

public class Q1 {
	static Node head;

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Q1 list = new Q1();
		list.head = new Node(50);
		list.head.next = new Node(20);
		list.head.next.next = new Node(15);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(10);
		list.head.next.next.next.next.next = new Node(4);

		Node head2 = head.clone();

		list.removeDuplicates(head);
		list.removeDuplicatesB(head2);

		list.printList(head);
		list.printList(head2);
	}

	private void removeDuplicatesB(Node head) {
		if (head == null)
			return;

		Node tmp = head;
		while (tmp != null) {
			Node runner = tmp;
			while (runner.next != null) {
				if (runner.next.data == tmp.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			tmp = tmp.next;
		}
	}

	public void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println("");
	}

	public static void removeDuplicates(Node head) {
		HashSet<Integer> hm = new HashSet<Integer>();
		Node prev = null;

		while (head != null) {
			if (!hm.contains(head.data)) {
				hm.add(head.data);
				prev = head;
			} else {
				prev.next = head.next;
			}
			head = head.next;
		}

	}
}
