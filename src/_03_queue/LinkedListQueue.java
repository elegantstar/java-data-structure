package _03_queue;

public class LinkedListQueue<E> implements Queue<E> {

	private QueueNode<E> head;
	private QueueNode<E> tail;
	
	// push : head
	// pop : tail
	
	@Override
	public void push(E item) {
		QueueNode<E> newNode = new QueueNode<E>(item);
		if(head == null) {
			head = newNode;
			tail = newNode;
			return;
		}
		
		newNode.setNext(head);
		head.setPre(newNode);
		head = newNode;
	}

	@Override
	public E pop() {
		E value = tail.getValue();
		tail = tail.getPre();
		if(tail != null) {
			tail.getNext().setPre(null);
			tail.setNext(null);
			
		}
		return value;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public E peek() {
		return tail.getValue();
	}

	
}

class QueueNode<E> {
	private E value;
	private QueueNode next;
	private QueueNode pre;
	
	public QueueNode(E item) {
		this.value = item;
	}

	// Alt + Shift + s(source 단축키) --> r (getter & setter 생성 단축키)
	
	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public QueueNode getNext() {
		return next;
	}

	public void setNext(QueueNode next) {
		this.next = next;
	}

	public QueueNode getPre() {
		return pre;
	}

	public void setPre(QueueNode pre) {
		this.pre = pre;
	}
	
	
	
}