package _07_bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        /**
         * BFS : 그래프의 탐색
         *
         * ex) Node = { 1, 2, 3 }
         * ex) Edge = {(1,2), (1,3)}
         *
         * 인접행렬 : 노드 u와 노드v가 연결되어있으면 1로 나타내는 베열
         * ex)
         * 0, 1, 1
         * 1, 0, 0
         * 1, 0, 0
         *
         * 링크드리스트 : 노드 u와 연결된 모든 노드를 링크드리스트에 삽입
         * ex)
         * [1] : [2] --> [3]
         * [2] : [1] --> null
         * [3] : [1] --> null
         *
         *
         * 1. Queue를 이용한다.
         * 2. 최단거리 찾을 때 좋다.
         */

        int[][] arr = { { 0, 1, 1 }, { 1, 0, 0 }, { 1, 0, 0 } };
        int n = 3;

        // 인접행렬 그래프 탐색
        BFS(arr, 3);

        int[][] arr2 = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1 }, { 1, 1, 1, 0, 0 }, { 0, 0, 0, 1, 0 } };

        // 미로 찾기
//        BFS(arr2, 4, 5);

        // 미로 찾기 및 최단거리
        BFSMinDistance(arr2, 4, 5);

        KnightMove(5,2,1,9, 15, 15);

    }

    /**
     * 인접행렬의 형태로 그래프가 주어졌을 때 연결된 모든 노드를 방문하는 알고리즘.
     * 큐에 넣은 후에 방문한다.
     */

    public static void BFS(int[][] arr, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println(node + 1);

            for (int i = 0; i < n; i++) {
                if (arr[node][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    /**
     * 링크드리스트 형태로 그래프가 주어졌을 때 연결된 모든 노드를 방문하는 알고리즘.
     * 큐에 넣은 후에 꺼낼 때 방문한다.
     */
    public static void BFS(List<LinkedList<Integer>> arr, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            LinkedList<Integer> linkedList = arr.get(node); // node와 연결된 모든 노드   [2] --> [3] --> [4] --> [5]

            for (Integer nextNode : linkedList) {
                if (!visited[nextNode]) {
                    queue.add(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
    }

    /**
     * 미로찾기 문제.
     *
     * 0 0 0 0 0
     * 0 0 0 0 1
     * 1 1 1 0 0
     * 0 0 0 1 0
     *
     * arr : 배열
     * m : 행의 수
     * n : 열의 수
     */
    public static void BFS(int[][] arr, int m, int n) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };

        queue.add(new Point(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;

            System.out.println(String.format("현재 위치 : (%d, %d)", x, y));

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 방문할 수 있는지 검사.
                // 인덱스 조건 : 0 <= nx < m && 0<= ny < n
                // 벽인지 아닌지 검사
                // visited 검사
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }

                if (arr[nx][ny] == 0 && !visited[nx][ny]) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void BFSMinDistance(int[][] arr, int m, int n) {
        Queue<Triple> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };

        queue.add(new Triple(0, 0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Triple triple = queue.poll();
            int x = triple.x;
            int y = triple.y;
            int distance = triple.distance;

            System.out.println(String.format("현재 위치 : (%d, %d), 거리 : %d", x, y, distance));

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }

                if (arr[nx][ny] == 0 && !visited[nx][ny]) {
                    queue.add(new Triple(nx, ny, distance + 1));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void KnightMove(int sx, int sy, int ex, int ey, int m, int n) {
        Queue<Triple> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        int[] dx = { 2, 2, -2, -2, 1, 1, -1, -1 };
        int[] dy = { 1, -1, 1, -1, 2, -2, 2, -2 };

        queue.add(new Triple(sx, sy, 0));
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            Triple triple = queue.poll();
            int x = triple.x;
            int y = triple.y;
            int distance = triple.distance;

            if (x == ex && y == ey) {
                System.out.println("distance : " + distance);
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }

                if (!visited[nx][ny]) {
                    queue.add(new Triple(nx, ny, distance + 1));
                    visited[nx][ny] = true;
                }
            }
        }
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Triple {
    int x;
    int y;
    int distance;

    public Triple(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}
