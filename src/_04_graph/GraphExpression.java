package _04_graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class GraphExpression {
    public static void main(String[] args) {
        /**
         * Graph : (V, E) 노드와 간선의 집합
         * V : 노드
         * E : 간선
         *
         * 1. 인접 행렬
         * 2. 링크드 리스트
         */

        /**
         * ex)
         * V = {0, 1, 2, 3, 4, 5}   : N개
         * E = {(0, 1), (0, 3), (1, 2), (1, 5), (2, 3), (2, 4), (3, 4), (3, 5), (4, 5)}     : M개
         * G = (V, E)가 무방향(양방향) 그래프
         *
         * 1. 인접행렬
         * 0 1 0 1 0 0
         * 1 0 1 0 0 1
         * 0 1 0 1 1 0
         * 1 0 1 0 1 1
         * 0 0 1 1 0 1
         * 0 1 0 1 1 0
         *
         * 2. 링크드 리스트
         * [0] : [1] --> [3]
         * [1] : [0] --> [2] --> [5]
         * [2] : [1] --> [3] --> [4]
         * [3] : [0] --> [2] --> [4] --> [5]
         * [4] : [2] --> [3] --> [5]
         * [5] : [1] --> [3] --> [4]
         *
         * Q. x 노드와 연결되어 있는 모든 노드를 탐색하는 알고리즘
         * 1. 인접행렬 : O(N)
         * 2. 링크드 리스트 : O(degN)
         *  --> 링크드 리스트가 속도가 더 빠르다.
         *
         *  하지만, Edge의 개수가 M개라면 링크드 리스트로 구현했을 때, 2M 만큼의 시간 복잡도가 걸린다
         *
         *  Edge의 개수가 적다면 링크드 리스트로 그래프를 저장하는 것이 좋고, Edge의 개수가 충분히 많다면 인접행렬로 표현하는 것이 좋다.
         */

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<Integer, LinkedList<Integer>> edges = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] strings = sc.nextLine().split(" ");
            for (int j = 0; j < strings.length; j++) {
                if (strings[j].equals("1")) {
                    if (!edges.containsKey(i)) {
                        edges.put(i, new LinkedList<>());
                    }
                    LinkedList<Integer> linkedList = edges.get(i);
                    linkedList.add(j);
                }
            }
        }

        for (Integer key : edges.keySet()) {
            LinkedList<Integer> linkedList = edges.get(key);
            for (Integer value : linkedList) {
                System.out.print("[" + value + "] —>");
            }
            System.out.println();
        }
    }
}
