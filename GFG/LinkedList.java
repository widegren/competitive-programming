package gfg;

import java.util.Scanner;

public class LinkedList {
	static Node head;

	void printList(Node head) {
		while (head != null) {
			System.out.print(head.intdata + " ");
			head = head.next;
		}
		System.out.println("");
	}

	public void push(int new_data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

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

	Node reverse(Node head, int k) {
		Node tmp = head, tmp_next = null, tmp_prev = null;
		int i = 0;
		while (tmp != null && i < k) {
			tmp_next = tmp.next;
			tmp.next = tmp_prev;
			tmp_prev = tmp;
			tmp = tmp_next;
			i++;
		}
		if (tmp_next != null) {
			head.next = reverse(tmp_next, k);
		}
		return tmp_prev;
	}
	
	int detectAndRemoveLoop(Node node) {
		return node.intdata;
	}
	
	void removeLoop(Node loop, Node curr) {
		
	}

	boolean isPresent(Node head, int data) {
		Node t = head;
		while (t != null) {
			if (t.intdata == data)
				return true;
			t = t.next;
		}
		return false;
	}

	void getUnion(Node head1, Node head2) {
		Node t1 = head1, t2 = head2;

		// insert all elements of list1 in the result
		while (t1 != null) {
			push(t1.intdata);
			t1 = t1.next;
		}
		while (t2 != null){
			if(!isPresent(head,t2.intdata)){
				push(t2.intdata);
			}
			t2 = t2.next;
		}
	}

	void getIntersection(Node head1, Node head2) {
		Node t1 = head1;
		
		while (t1 != null) {
            if (isPresent(head2, t1.intdata))
                push(t1.intdata);
            t1 = t1.next;
        }
	}

	void merge(LinkedList q) {
		Node p_curr = head, q_curr = q.head;
		Node p_next, q_next;

		while (p_curr != null && q_curr != null) {
			p_next = p_curr.next;
			q_next = q_curr.next;

			q_curr.next = p_next;
			p_curr.next = q_curr;

			p_curr = p_next;
			q_curr = q_next;
		}
		q.head = q_curr;
	}

//	// Driver method for adding two lists
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(System.in);
	// int T = sc.nextInt();
	// while (T > 0) {
	// int n1 = sc.nextInt();
	// LinkedList list1 = new LinkedList();
	// for (int i = 1; i <= n1; i++) {
	// int a = sc.nextInt();
	// list1.push(a);
	// }
	//
	// int n2 = sc.nextInt();
	// LinkedList list2 = new LinkedList();
	// for (int i = 0; i < n2; i++) {
	// int b = sc.nextInt();
	// list2.push(b);
	// }
	//
	// LinkedList list3 = new LinkedList();
	// GfG g = new GfG();
	// Node rs = g.addTwoLists(list1.head, list2.head);
	// list3.printList(rs);
	// System.out.println();
	// T--;
	// }
	// sc.close();
	// }

//	// Driver method for union and intersect of two linked lists
//	public static void main(String args[]) {
//		LinkedList llist1 = new LinkedList();
//		LinkedList llist2 = new LinkedList();
//		LinkedList unin = new LinkedList();
//		LinkedList intersecn = new LinkedList();
//
//		/* create a linked lits 10->15->5->20 */
//		llist1.push(20);
//		llist1.push(4);
//		llist1.push(15);
//		llist1.push(10);
//
//		/* create a linked lits 8->4->2->10 */
//		llist2.push(10);
//		llist2.push(2);
//		llist2.push(4);
//		llist2.push(8);
//
//		intersecn.getIntersection(llist1.head, llist2.head);
//		unin.getUnion(llist1.head, llist2.head);
//
//		System.out.println("First List is");
//		llist1.printList(llist1.head);
//
//		System.out.println("Second List is");
//		llist2.printList(llist2.head);
//
//		System.out.println("Intersection List is");
//		intersecn.printList(intersecn.head);
//
//		System.out.println("Union List is");
//		unin.printList(unin.head);
//	}
	
	public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);
 
        // Creating a loop for testing 
        head.next.next.next.next.next = head.next.next;
        list.detectAndRemoveLoop(head);
        System.out.println("Linked List after removing loop : ");
        list.printList(head);
    }
}