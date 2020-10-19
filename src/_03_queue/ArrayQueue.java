package _03_queue;

public class ArrayQueue<E> implements Queue<E> {

	private Object[] elements = new Object[1024];
	private int size = 0;
	private int popIndex = -1;
	
	@Override
	public void push(E item) {
		if(isFull()) {
			return;
		}
		elements[size++] = item;
	}
	
	@Override
	public E pop() {
		if(isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		
		return (E) elements[++popIndex];
	}
	@Override
	public boolean isEmpty() {
		return size == popIndex + 1;
	}
	@Override
	public E peek() {
		if(isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		return (E) elements[popIndex + 1];
	}
	
	private boolean isFull(){
		return size == 1024;
	}
}
