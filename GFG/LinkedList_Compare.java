package GFG;

import java.util.Scanner;

class Node {
	char data;
	int intdata;
	Node next;

	// Constructor to create a new node
	Node(char d) {
		data = d;
		next = null;
	}
	
	Node(int d) {
		intdata = d;
		next = null;
	}
}

public class LinkedList_Compare {
	Node head;

	public void addToTheLast(Node node) {
		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;

			temp.next = node;
		}
	}

	public static void main(String args[]) {

		/*
		 * Constructed Linked List is 1->2->3->4->5->6-> 7->8->8->9->null
		 */
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			LinkedList_Compare llist1 = new LinkedList_Compare();
			LinkedList_Compare llist2 = new LinkedList_Compare();
			int n1 = sc.nextInt();

			int value = 0;

			char a1 = sc.next().charAt(0);
			Node head1 = new Node(a1);
			llist1.addToTheLast(head1);

			for (int i = 1; i < n1; i++) {
				char a = sc.next().charAt(0);
				llist1.addToTheLast(new Node(a));

			}

			int n2 = sc.nextInt();
			char b1 = sc.next().charAt(0);
			Node head2 = new Node(b1);
			llist2.addToTheLast(head2);

			for (int i = 1; i < n2; i++) {
				// int b;

				char b = sc.next().charAt(0);
				llist2.addToTheLast(new Node(b));
			}			
			// int value=0;
			GfG g = new GfG();
			value = g.compare(llist1.head, llist2.head);
			System.out.println(value);
			t--;
		}
		sc.close();
	}
}

class GfG {
	int compare(Node node1, Node node2) {
		int result = 0;
		while (node1 != null && node2 != null) {
			if (node1.data == node2.data) {
				node1 = node1.next;
				node2 = node2.next;
			} else if (node1.data > node2.data) {
				result = 1;
				break;
			} else {
				result = -1;
				break;
			}
		}
		return result;
	}
	Node addTwoLists(Node first, Node second) {
		int sum = 0, carry = 0;
		Node tmp = null, res = null, prev = null;
		
		while(first != null || second != null){
			sum = carry + (first != null ? first.intdata : 0)
                    + (second != null ? second.intdata : 0);
			
			carry = (sum >= 10) ? 1 : 0;
			sum = sum % 10;
			tmp = new Node(sum);
			
			if (res == null) {
                res = tmp;
            } else // If this is not the first node then connect it to the rest.
            {
                prev.next = tmp;
            }
			
			prev = tmp;
			
			if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
		}
		if (carry > 0) {
            tmp.next = new Node(carry);
        }
 
        return res;
	}
}
