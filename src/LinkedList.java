
public class LinkedList {

	protected Node head;

	LinkedList()
	{
		head = null;
	}

	public void add(int a)
	{
		if(head == null)
		{
			head = new Node(a);
		}
		else
		{
			Node n1 = new Node(a);

			Node n = head;
			while(n.next != null)
			{
				n = n.next;
			}
			n.next = n1;
		}

	}
	public static void disp(Node head)
	{
		Node current = head;
		while(current != null)
		{
			System.out.print(current.data+"\t");
			current = current.next;
		}
		System.out.println();
	}
	public void delete(int value)
	{
		if(head == null)						/*Check for list empty*/
			return;
		else{
			if(head.data == value){				/* If head has the value to be deleted*/
				if(head.next == null){			/* If head is the only node*/
					head = null;
					return;
					}
				head = head.next;
			}
			Node current = head;
			while(current.next != null){
				if(current.next.data == value)
					current.next = current.next.next;
				else
					current = current.next;
			}
		}
	}
	/*
	 * Delete node at i
	 */
	public void deleteAti(int i){
		if(head == null)
			return;
		Node prev = head;
		if(i == 0){
			head = head.next;
			return;
		}
		int index = 0;
		//traverse until index index i-1;
		while(prev != null && i > 2){	
			prev = prev.next;
			i--;;
		}
		// Return false if there is no node at index i
		if(prev == null || prev.next == null)
			return;
		Node current = prev.next;		// Node to be deleted
		prev.next = current.next;
		current.next = null;			//Delete the current node's pointers
	}


	public static void main(String[] args)
	{
		LinkedList list1 = new LinkedList();
		list1.add(7);
		list1.add(4);
		list1.add(6);
		list1.add(3);
		list1.add(1);
		list1.add(2);
		list1.add(5);
		list1.add(2);
		System.out.println("Linked list before deletion");
		disp(list1.head);
		list1.deleteAti(8);
		System.out.println("Linked list after deletion");
		disp(list1.head);
		list1.add(3);
		list1.add(2);
		System.out.println("Linked List after adding 2 and 3");
		disp(list1.head);
		System.out.println("Reversed linked list");
		list1.reverse();
		disp(list1.head);
		System.out.println("Sorted Linked List using Merge sort");
		Node sorted = list1.MergeSort(list1.head);
		disp(sorted);
	}

	//In-place Linked List reversal
	public void reverse()
	{
		Node prev = head;
		if(head.next == null)
		{
			return;
		}
		Node next = head.next;		
		head.next = null;
		while(next.next != null)
		{
			Node temp = next.next;
			next.next = prev;
			prev = next;
			next = temp;
		}
		head = next;
		head.next = prev;
	}

	// Sorting the Linked List using Merge sort
	public Node MergeSort(Node head)
	{
		Node left = head;
		if(left.next == null)
			return left;
		else{
			Node right = head.next;
			while(right !=null)
			{
				if(right.next != null){
					left = left.next;
					right = right.next.next;
				}
				else
					break;
			}
			Node mid = left.next;
			left.next = null;
			head = MergeSort(head);
			mid = MergeSort(mid);
			head = Merge(head,mid);
			return head;
		}
	}

	public Node Merge(Node start, Node end){
		Node i = start;
		Node j = end;
		LinkedList list2 = new LinkedList();
		while(i != null && j != null)
		{
			if(i.data <= j.data){
				list2.add(i.data);
				i = i.next;
			}
			else{
				list2.add(j.data);
				j = j.next;
			}
		}
		if(i == null){
			while(j != null)
			{
				list2.add(j.data);
				j= j.next;
			}
		}
		if(j == null){
			while(i != null){
				list2.add(i.data);
				i = i.next;
			}
		}
		return list2.head;
	}
}

class Node{
	int data;
	Node next;

	Node(int data)
	{
		this.data = data;
		this.next = null;
	}
}


