package _01_introduction;

public class LinkedListApp {

	public static void main(String[] args) {

		// 3 --> 72 --> 1 --> 24 --> 35 --> 0
		
		LinkedList2 list2 = new LinkedList2();
		list2.insertLast(3);
		list2.insertLast(72);
		list2.insertLast(1);
		list2.insertLast(24);
		list2.insertLast(35);
		list2.insertLast(0);
		
		list2.print();
		
		System.out.println();
		
		list2 = new LinkedList2();
		list2.insertFirst(0);
		list2.insertFirst(35);
		list2.insertFirst(24);
		list2.insertFirst(1);
		list2.insertFirst(72);
		list2.insertFirst(3);
		
		list2.print();
		
	}

}

class Node2{
	int num;
	Node2 next;
	
	Node2(int num){
		this.num = num;
	}
}

class LinkedList2{
	Node2 head;
	Node2 tail;
	
	public void insertFirst(int num) {
		Node2 newNode2 = new Node2(num);
		if(isEmpty()) {
			setFirstNode2(newNode2);
			return;
		}
		newNode2.next = head;
		head = newNode2;
	}
	
	public void insertLast(int num) {
		Node2 newNode2 = new Node2(num);
		if(isEmpty()) {
			setFirstNode2(newNode2);
			return;
		}
		tail.next = newNode2;
		tail = newNode2;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	private void setFirstNode2(Node2 firstNode) {
		head = firstNode;
		tail = firstNode;
	}
	
	public void print() {
		Node2 pointer = head;
		while(pointer != null) {
			System.out.print(pointer.num + " --> ");
			pointer = pointer.next;
		}
	}
}