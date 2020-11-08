package _06_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BacktrackingExample {

    private static int[] maxResult;
    private static int[] minResult;
    private static int k;
    private static boolean[] visited;
    private static String[] inequalitySigns;
    private static boolean isFound = false;

    public static void main(String[] args) throws IOException {
        /**
         * Backtracking Algorithm
         * 가능한 모든 경우의 수를 다 탐색하는데, 만약 조건에 부합하지 않으면 더 이상 깊게 탐색하지 않는 알고리즘.
         *
         * Eight Queen Problem
         *
         * Q. 8개의 퀸을 8*8 사이즈의 체스판에 서로 공격할 수 없도록 하는 순서쌍을 찾는 문제
         * A. 전수 조사의 시간 복잡도 는 O(8^8), 하지만 Backtrackiing으로 사전에 불가능한 조합들을 제거해 나가면 이보다 훨씬 작은 시간 복잡도로 계산할 수 있다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        k = Integer.parseInt(input);
        inequalitySigns = br.readLine().split(" ");

        maxResult = new int[k + 1];
        minResult = new int[k + 1];
        visited = new boolean[10];

        DFSMax(0);

        isFound = false;

        DFSMin(0);

        for (int i = 0; i < maxResult.length; i++) {
            System.out.print(maxResult[i]);
        }

        System.out.println();

        for (int i = 0; i < minResult.length; i++) {
            System.out.print(minResult[i]);
        }
    }

    public static void DFSMax(int depth) {
        // 끝나는 조건 (모든 수를 다 찾았으면 종료)
        if (depth == k + 1) {
            isFound = true;
            return;
        }

        for (int i = 9; i >= 0; i--) {
            if (isFound) return;

            if (!visited[i]) {
                maxResult[depth] = i;
                if (isRight(depth, maxResult)) {
                    visited[i] = true;
                    DFSMax(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void DFSMin(int depth) {
        // 끝나는 조건 (모든 수를 다 찾았으면 종료)
        if (depth == k + 1) {
            isFound = true;
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (isFound) return;

            if (!visited[i]) {
                minResult[depth] = i;
                if (isRight(depth, minResult)) {
                    visited[i] = true;
                    DFSMin(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }


    //
    // maxResult = [9, 8]   depth = 1
    // inequalitySigns = [">"]
    // maxResult[depth]와 maxResult[depth - 1]의 값이 inequalitySigns[depth -1]을 만족하는가?
    //
    public static boolean isRight(int depth, int[] result) {
        if (depth == 0) return true;

        int right = result[depth];
        int left = result[depth - 1];

        if (inequalitySigns[depth - 1].equals(">")) {
            return left > right;
        } else {
            return left < right;
        }
    }
}
