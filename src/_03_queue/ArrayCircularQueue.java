package _03_queue;

public class ArrayCircularQueue<E> implements Queue<E> {

	private Object[] elements = new Object[1024];
	private int pushIndex = 0;
	private int popIndex = 1023;
	
	@Override
	public void push(E item) {
		if(isFull()) {
			return;
		}
		elements[pushIndex] = item;
		pushIndex = (pushIndex + 1) % 1024;
	}
	
	@Override
	public E pop() {
		if(isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		
		popIndex = (popIndex + 1) % 1024;
		return (E) elements[popIndex];
	}
	
	@Override
	public boolean isEmpty() {
		return pushIndex == (popIndex + 1) % 1024;
	}
	
	@Override
	public E peek() {
		if(isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		return (E) elements[(popIndex + 1) % 1024];
	}
	
	private boolean isFull(){
		return pushIndex == popIndex % 1024;
	}
}
