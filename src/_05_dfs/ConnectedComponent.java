package _05_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConnectedComponent {

    private static boolean[] visited;
    private static int[][] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        edges = new int[n][n];
        visited = new boolean[n];
        int count = 0;

        for(int i = 0; i < m; i++){
            String[] nums = br.readLine().split(" ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            edges[a-1][b-1] = 1;
            edges[b-1][a-1] = 1;
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                DFS(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void DFS(int x){
        for(int i = 0; i < edges.length; i++){
            if(!visited[i] && edges[x][i] == 1){
                visited[i] = true;
                DFS(i);
            }
        }
    }
}
