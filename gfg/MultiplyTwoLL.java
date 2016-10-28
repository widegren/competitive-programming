package gfg;

import java.util.Scanner;

public class MultiplyTwoLL {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			Node head = null;
			Node phead = null;
			int n = sc.nextInt();
			while (n-- > 0) {
				int n1 = sc.nextInt();
				if (head == null)
					head = new Node(n1);
				else {
					addHead(head, n1);
				}
			}
			int m = sc.nextInt();
			while (m-- > 0) {
				int n1 = sc.nextInt();
				if (phead == null)
					phead = new Node(n1);
				else {
					addPhead(phead, n1);
				}
			}
			LinkedList l = new LinkedList();

			System.out.println(l.multiplyTwoLists(head, phead));
		}
		sc.close();
	}

	public static void addHead(Node node, int a) {
		if (node == null)
			return;
		if (node.next == null)
			node.next = new Node(a);
		else
			addHead(node.next, a);
	}

	public static void addPhead(Node node, int a) {
		if (node == null)
			return;
		if (node.next == null)
			node.next = new Node(a);
		else
			addPhead(node.next, a);
	}
}
