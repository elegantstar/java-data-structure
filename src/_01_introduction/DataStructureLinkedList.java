package _01_introduction;

public class DataStructureLinkedList {

	public static void main(String[] args) {

		/**
		 * LinkedList : �� Node(value)�� ���� �̾��� �ִ� ����(����� �� ���Ǵ� �ƴ�; �����ϱ� ���� Ǯ�� �� ��)
		 * 
		 * ex) 5 --> 7 --> 1 --> 3 --> 4 --> null
		 * need) 5�� 7 ���̿� 10�� �����ϰ��� �Ѵ�.
		 * how)
		 * - 5�� 7�� ������ ���´�.
		 * - 5�� 10�� ����Ű�� �����Ѵ�.
		 * - 10�� 7�� ����Ű�� �����Ѵ�.
		 * 
		 * - Ž�� : �ð� ���⵵ O(n). index�� ���� ����.
		 * - ���� : ���� O(1), �־� O(n). ������ ����� ��ġ�� ã�ƾ� �ϱ� ����.
		 * - ���� : ���� O(1), �־� O(n). ������ ����� ��ġ�� ã�ƾ� �ϱ� ����.
		 * - ���� : ���� O(1), �־� O(n). ������ ����� ��ġ�� ã�ƾ� �ϱ� ����.
		 * 
		 */
		
		LinkedList list = new LinkedList();
		list.insertFirst(4);
		list.insertFirst(3);
		list.insertFirst(1);
		list.insertFirst(7);
		list.insertFirst(5);
		
		list.print();
	
		System.out.println("\n");
		
		list = new LinkedList();
		list.insertLast(5);
		list.insertLast(7);
		list.insertLast(1);
		list.insertLast(3);
		list.insertLast(4);
		
		list.print();
		
	}

}

class Node {
	int num;
	Node next;
	
	Node(int num){
		this.num = num;
	}
}

class LinkedList {
	Node head;
	Node tail;
	
	//�� �տ� ����
	public void insertFirst(int num) {
		Node newNode = new Node(num);
		if(isEmpty()) {
			setFirstNode(newNode);
			return;
		}	
		newNode.next = head; // newNode�� head�� ����Ű���� �����
		head = newNode;		// newNode�� ���ο� head�� ����
	}
	
	//�� �ڿ� ����
	public void insertLast(int num) {
		Node newNode = new Node(num);
		if (isEmpty()) {
			setFirstNode(newNode);
			return;
		}	
		
		tail.next = newNode;
		tail = newNode;
		
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	private void setFirstNode(Node firstNode) {
		head = firstNode;
		tail = firstNode;
	}
	
	
	public void print() {
		Node pointer = head;
		while(pointer != null) {
			System.out.print(pointer.num + " --> ");
			pointer = pointer.next;
		}
	}
}