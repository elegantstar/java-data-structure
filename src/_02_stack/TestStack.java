package _02_stack;

import java.util.LinkedList;
import java.util.Stack;

public class TestStack {

	public static void main(String[] args) {

		ArrayStack arrayStack = new ArrayStack();
		
		System.out.println(arrayStack.isEmpty());
		arrayStack.insert(7);
		arrayStack.insert(5);
		arrayStack.insert(10);
		
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		
		System.out.println(arrayStack.isFull());
		
		System.out.println("==========================================");
		
		LinkedListStack linkedListStack = new LinkedListStack();
		
		System.out.println(linkedListStack.isEmpty());
		linkedListStack.insert(4);
		linkedListStack.insert(7);
		linkedListStack.insert(1);
		linkedListStack.insert(10);
		linkedListStack.insert(2);
		
		System.out.println(linkedListStack.pop());
		System.out.println(linkedListStack.pop());
		System.out.println(linkedListStack.pop());
		System.out.println(linkedListStack.pop());
		System.out.println(linkedListStack.pop());
		System.out.println(linkedListStack.pop());
		System.out.println(linkedListStack.pop());
		
		System.out.println("==========================================");
		
		/**
		 * Collection Framework���� �����ϴ� Stack
		 * 1. Stack class : Thread safe(�����忡 �����ϴ�)
		 * 2. LinkedList class : Thread unsafe(�����忡 �Ҿ����ϴ�)
		 * 
		 * Process : ���� ���� ���α׷�[Code����, Data����(static, final), Heap����(��ü/new()) + Thread(���� Stack ����)
		 * Thread : �ϳ��� ���μ������� ���������� �����ϴ� ���α׷��� ���� �帧
		 * 	- Multi Thread ȯ�濡���� �����Ǵ� ������ ����(Heap)���� ����ġ ���� ������ ��Ÿ�� �� �ִ�.
		 * 	- �̸� ������ �� �ִ� ������� �ִµ�, �� �߿��� Java�� Synchronize��� ����� ����Ѵ�.
		 * 	- Synchronized�� ����� ��ü�� thread-safe �ϴٰ� ǥ���Ѵ�.
		 * 
		 * 	�ڵ��׽�Ʈ������ ������!! LinkedList�� ����Ѵ�.
		 */
		
		Stack<Integer> stack = new Stack<>();
		stack.push(5);
		stack.push(7);
		stack.pop();
		
		LinkedList<Integer> stack2 = new LinkedList<Integer>();
		stack2.addFirst(7);
		stack2.addFirst(3);
	
		System.out.println(stack2.pop());
	}

}
