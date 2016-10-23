package GFG;

import java.util.Scanner;

public class Reverse_LinkedList {
	public static void main(String args[]) {

		/*
		 * Constructed Linked List is 1->2->3->4->5->6-> 7->8->8->9->null
		 */
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			Add_LinkedList llist = new Add_LinkedList();
			// int n=Integer.parseInt(br.readLine());
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			llist.addToTheLast(head);
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				llist.addToTheLast(new Node(a));
			}
			int k = sc.nextInt();

			llist.head = llist.reverse(llist.head, k);
			llist.printList(llist.head);
			t--;
		}
		sc.close();
	}
}
