package _03_queue;

public interface Queue<E> {

	/**
	 * Queue : FIFO(First in First Out) ������ �ڷᱸ��
	 */
	
	 public void push(E item);
	 public E pop();
	 public boolean isEmpty();
	 public E peek();
	 
}
