package Chapter2;
/**
 * 
 * @author emeliewidegren
 *
 * Implement an algorithm to delete a node in the middle of a singly linked list,
 * given only access to that node.
 */
public class Q3 {
	public static void main(String[] args) {
		Q1 list = new Q1();
		list.head = new Node(50);
		list.head.next = new Node(20);
		list.head.next.next = new Node(15);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(10);
		list.head.next.next.next.next.next = new Node(4);
		list.head.next.next.next.next.next.next = new Node(6);

		System.out.println(getMiddle(list.head));
		System.out.print("List before deletion: ");
		list.printList(list.head);
		deleteNode(list.head.next);
		System.out.print("List after deletion: ");
		list.printList(list.head);
	}

	public static int getMiddle(Node head) {
		Node current = head, middle = head;
		
		int count = 1;
		while(current.next != null){
			count++;
			if(count%2==0){
				middle = middle.next;
			}
			current = current.next;
		}
		return middle.data;
	}
	
	public static boolean deleteNode(Node node){
		if(node == null || node.next == null){
			return false;
		}
		Node tmp = node.next;
		node.data = tmp.data;
		node.next = tmp.next;
		return true;
	}
}
