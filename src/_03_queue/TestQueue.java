package _03_queue;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {

	public static void main(String[] args) {

		ArrayCircularQueue<String> circularQueue = new ArrayCircularQueue<>();
		
		circularQueue.push("abc");
		circularQueue.push("hello");
		circularQueue.push("queue");
		System.out.println(circularQueue.peek());
		System.out.println(circularQueue.pop());
		System.out.println(circularQueue.pop());
		System.out.println(circularQueue.pop());
		
		System.out.println("==================================");
		
		LinkedListQueue<String> linkedListQueue = new LinkedListQueue<String>();
		
		linkedListQueue.push("AB");
		linkedListQueue.push("CD");
		linkedListQueue.push("EF");
		
		System.out.println(linkedListQueue.pop());
		System.out.println(linkedListQueue.pop());
		System.out.println(linkedListQueue.peek());
		System.out.println(linkedListQueue.pop());
		
		/**
		 * Collection Framework���� �����ϴ� Queue
		 * 1. Queue class : thread unsafe
		 * 	- Queue�� Interface�̹Ƿ� ����ü�� linkedList�� ����Ѵ�.
		 *  
		 */
		Queue<String> queue = new LinkedList<>();
		queue.add("string");
		queue.poll();
	}

}
