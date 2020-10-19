package _05_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConnectedComponent2 {
        private static boolean[] visited;
        private static List<LinkedList<Integer>> edges;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            edges = new ArrayList<>();
            for(int i = 0; i <n; i++) {
                edges.add(new LinkedList<>());
            }
            visited = new boolean[n];
            int count = 0;

            for(int i = 0; i < m; i++){
                String[] nums = br.readLine().split(" ");
                int a = Integer.parseInt(nums[0]);
                int b = Integer.parseInt(nums[1]);
                edges.get(a-1).add(b-1);
                edges.get(b-1).add(a-1);
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
            LinkedList<Integer> linkedList = edges.get(x);
            for (int u : linkedList) {
                if(!visited[u]){
                    visited[u] = true;
                    DFS(u);
            }
        }
    }
}
