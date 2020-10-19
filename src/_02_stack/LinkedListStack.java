package _02_stack;

public class LinkedListStack implements Stack {

	private Node head;

	@Override
	public void insert(int value) {
		Node node = new Node(value);
		node.next = head;
		head = node;
	}

	@Override
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack이 비어있습니다.");
			return -1;
		}
		int result = head.value;
		head = head.next;
		return result;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
}

class Node{
	int value;
	Node next;
	
	public Node(int value){
		this.value = value;
	}
}