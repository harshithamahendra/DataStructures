/*
 * Linked List
 */
public class AddLinkedList extends LinkedList {
	Node head;
	AddLinkedList(){
		super();
	}
	public static void main(String[] args){
		LinkedList l1 = new LinkedList(); 
		LinkedList l2 = new LinkedList();
		LinkedList l3 = new LinkedList();
		l1.add(3);
		l1.add(4);
		l1.add(5);
		l2.add(1);
		l2.add(4);
		l2.add(5);
		disp(l1.head);
		disp(l2.head);
		disp(l3.head);
		if(addNodes(l1,l2,l3)){
			disp(l3.head);
		}
	}
	public static boolean addNodes(LinkedList l1,LinkedList l2,LinkedList l3){
		Node node1 = l1.head;
		Node node2 = l2.head;
		int carry = 0;
		int val = 0;
		while(node1 != null && node2 != null){
			val = node1.data + node2.data + carry;
			if(val > 9 && val < 100){
				carry = val / 10;
				val = val % 10;
			}
			else{
				carry = 0;
			}
			l3.add(val);
			node1 = node1.next;
			node2 = node2.next;
		}
		if(carry > 0){
			l3.add(carry);
		}
		if(node1 != null || node2 != null)
			return false;
		else
			return true;
	}
}
