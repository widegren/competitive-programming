package gfg;

public class Merge_LinkedList {
	public static void main(String args[])
    {
        LinkedList llist1 = new LinkedList();
        LinkedList llist2 = new LinkedList();
        llist1.push(3);
        llist1.push(2);
        llist1.push(1);
 
        System.out.println("First Linked List:");
        llist1.printList(llist1.head);
 
        llist2.push(8);
        llist2.push(7);
        llist2.push(6);
        llist2.push(5);
        llist2.push(4);
 
        System.out.println("Second Linked List:");
        llist2.printList(llist2.head);
 
        llist1.merge(llist2);
 
        System.out.println("Modified first linked list:");
        llist1.printList(llist1.head);
 
        System.out.println("Modified second linked list:");
        llist2.printList(llist2.head);
    }
}
