package _02_stack;

public class ArrayStack implements Stack {

	private int[] stack = new int[1024];
	private int size = 0;
	
	@Override
	public void insert(int value) {
		if(isFull()) {
			System.out.println("stack이 꽉 찼습니다.");
			return;
		}
		stack[size++] = value;
	}

	@Override
	public int pop() {
		if(isEmpty()) {
			System.out.println("데이터가 없습니다.");
			return -1;
		}
		return stack[--size];
	}
	
	public boolean isEmpty() {
		return size == 0; 
	}
	
	public boolean isFull() {
		return size == 1024;
	}

}