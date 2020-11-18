package _09_heap;

import java.util.PriorityQueue;

public class HeapExample {
    /**
     * 프로세스의 메모리 구조
     *  - Code : 실제 프로그램의 코드가 저장되는 영역 (프로세스가 공유하는 영역)
     *  - Stack : 메서드, 지역변수가 저장되는 영역 (쓰레드가 개별적으로 가지는 영역)
     *  - Heap : 객체가 저장되는 영역 (프로세스가 공유하는 영역)
     *
     * 자료구조의 Heap
     * 전제 조건 1. Complete Binary Tree : 왼쪽에서 오른쪽으로 선을 그었을 때, 비어있는 노드가 없는 이진 트리.
     *   cf) Full Binary Tree : 각 레벨의 모든 노드가 가득 차있는 이진 트리
     * 전제 조건 2. Heap Property : 노드가 왼쪽 자식보다 작(크)거나 같고, 오른쪽 자식보다 작(크)거나 같은 성질
     *
     * Heap의 정의 : Complete Binary Tree와 Heap Property를 만족하는 자료구조
     *
     * Heap의 특징 (max-heap)
     * 1. 루트 노드가 반드시 가장 큰 값이 된다.
     * 2. 최댓값을 찾는 시간 복잡도 : O(1)
     * 3. 최댓값을 찾은 후에는 heap property가 깨지기 때문에 heapify 연산을 해야 한다. heapify 연산의 시간 복잡도는 O(logN)이다.
     *   ex) Heap을 사용했을 때, 가장 큰 값 4개를 찾는 시간 복잡도 : O(4logN) = O(logN)
     *   ex) 배열 자료구조를 사용했을 때, 가장 큰 값 4개를 찾는 시간 복잡도 : O(4N) = O(N)
     *
     * Heap의 구현
     *  - Complete Binary Tree만의 독특한 구현 방법이 존재한다.
     *  - index 0을 사용하지 않는 배열로 구현
     *
     *  - i번째 노드의 부모 노드 : i / 2
     *  - i번째 노드의 자식 노드 : 2*i, 2*i+1
     *
     * Heap의 push연산
     * 1. heap[n+1]의 자리에 데이터를 삽입
     * 2. 부모 노드와 비교해서 heap property를 만족할 때까지 스왑을 반복한다.
     *
     * Heap의 pop연산
     * 1. heap[1] 데이터를 꺼내고 삭제
     * 2. heap[n] 데이터를 루트로 이동(n은 마지막 index) (heap[n] --> heap[1])
     * 3. heapify 연산 수행
     *
     * Heapify 연산
     * 1. 루트 노드부터 왼쪽 자식, 오른쪽 자식과 값을 비교해서 루트보다 작은 값이 존재한다면 자리를 스왑한다.
     * 2. 이 과정을 스왑할 노드가 없을 때까지 반복한다.
     *
     * Heap의 구현체
     *  - PriorityQueue (우선순위 큐) - min-Heap
     *
     * Heap의 활용
     * 1. maxHeap 구현 방법 : 데이터를 넣을 때 -를 붙여서 넣고, 꺼낼 때 -를 붙여서 꺼낸다.
     * 2. heap을 이용한 정렬(heap sort) : 데이터를 전부 heap에 넣고, 다시 다 꺼내는 정렬 기법.
     *   - 시간 복잡도 : O(NlogN)
     *
     *
     */

    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        heap.add(5);
        heap.add(7);
        heap.add(13);
        heap.add(2);
        heap.add(-7);

        System.out.println(heap.poll()); // -7
        System.out.println(heap.poll()); // 2
        System.out.println(heap.poll()); // 5
        System.out.println(heap.poll()); // 7
        System.out.println(heap.poll()); // 13

        heap.add(-5);
        heap.add(-7);
        heap.add(-13);
        heap.add(-2);
        heap.add(7);

        System.out.println(-heap.poll());
        System.out.println(-heap.poll());
        System.out.println(-heap.poll());
        System.out.println(-heap.poll());
        System.out.println(-heap.poll());


    }
}
