package _01_introduction;

public class DataStructureLinkedList {

	public static void main(String[] args) {

		/**
		 * LinkedList : 각 Node(value)가 서로 이어져 있는 형태(제대로 된 정의는 아님; 이해하기 쉽게 풀어 쓴 것)
		 * 
		 * ex) 5 --> 7 --> 1 --> 3 --> 4 --> null
		 * need) 5와 7 사이에 10을 삽입하고자 한다.
		 * how)
		 * - 5와 7의 연결을 끊는다.
		 * - 5가 10을 가리키게 변경한다.
		 * - 10이 7을 가리키게 변경한다.
		 * 
		 * - 탐색 : 시간 복잡도 O(n). index가 없기 때문.
		 * - 삽입 : 최적 O(1), 최악 O(n). 삽입할 대상의 위치를 찾아야 하기 때문.
		 * - 삭제 : 최적 O(1), 최악 O(n). 삭제할 대상의 위치를 찾아야 하기 때문.
		 * - 수정 : 최적 O(1), 최악 O(n). 수정할 대상의 위치를 찾아야 하기 때문.
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
	
	//맨 앞에 삽입
	public void insertFirst(int num) {
		Node newNode = new Node(num);
		if(isEmpty()) {
			setFirstNode(newNode);
			return;
		}	
		newNode.next = head; // newNode가 head를 가리키도록 만들고
		head = newNode;		// newNode를 새로운 head로 만듦
	}
	
	//맨 뒤에 삽입
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