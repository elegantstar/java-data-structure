package _05_dfs;

import java.util.LinkedList;
import java.util.Map;

public class DepthFirstSearch {

    private boolean[][] visited;

    private boolean[] visited2;
    private int[][] edges;

    private Map<Integer, LinkedList<Integer>> edges2;
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        /**
         * 깊이 우선 탐색 : 그래프를 탐색하는 알고리즘
         *
         * Stack을 기반으로 동작하는 Recursion을 이용해서 구현할 수 있다.
         *
         *
         */
    }

    // 상하좌우로 움직일 수 있는 그래프에서 DFS
    public void DFS(Point point){
        // Point에서 방문할 수 있는 위치는 상하좌우라고 가정.

        int x = point.x;
        int y = point.y;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 좌표가 유효하지 않으면 continue
            if(nx < 0 || nx >= edges.length || ny < 0 || ny >= edges.length){
                continue;
            }

            // visited가 아니라면 방문.
            if(!visited[nx][ny]){
                visited[nx][ny] = true;
                DFS(new Point(nx, ny));
            }
        }

    }

    // 링크드 리스트로 구현된 그래프에서 DFS
    public void DFS2(int x){

        // 방문할 수 있는 모든 곳 방문
        LinkedList<Integer> linkedList = edges2.get(x);

        for (int node : linkedList) {
            // 방문한 적이 없다면 방문
            if(!visited2[node]){
                visited2[node] = true;
                DFS2(node);
            }
        }
    }

    // 인접행렬로 구현된 그래프에서 DFS
    public void DFS3(int x){
        // 방문할 수 있는 모든 곳 방문
        for(int i = 0; i < edges.length; i++){
            if(!visited2[i] && edges[x][i] == 1){
                visited2[i] = true;
                DFS3(i);
            }
        }
    }
}

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}