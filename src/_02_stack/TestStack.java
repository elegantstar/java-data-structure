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
		 * Collection Framework에서 제공하는 Stack
		 * 1. Stack class : Thread safe(쓰레드에 안전하다.)
		 * 2. LinkedList class : Thread unsafe(쓰레드에 불안전하다.)
		 * 
		 * Process : 실행 중인 프로그램 [Code영역, Data영역(static, final), Heap영역(객체/new()) + Thread(개별 Stack 영역)
		 * Thread : 하나의 프로세스에서 독립적으로 동작하는 프로그램의 실행 흐름
		 * 	- Multi Thread 환경에서는 공유되는 데이터 영역(heap)에서 예기치 못한 현상이 나타날 수 있다.
		 * 	- 이를 막아줄 수 있는 기술들이 있는데, 그 중에서 Java는 Synchronize라는 기술을 사용한다.
		 * 	- Synchronized가 적용된 객체는 thread-safe 하다고 부른다.
		 *
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
