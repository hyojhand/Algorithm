package Baekjoon.DP;

import java.io.*;
import java.util.*;

// G3 사회망 서비스(SNS)
// 루트를 하나 정하고, 자신이 얼리어답터가 아니라면 자식은 얼리어답터인 DP값을 더하고, 얼리아답터라면 자식은 DP의 최소값 더한다.
// 재귀 형식으로 DP를 구하면서 더해간다.
// dp[a][0] : a가 얼리어답터가 아닌 경우, dp[a][1] : a가 얼리어답터인 경우
public class Main2533 {
    private static List<Integer>[] nodes;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        nodes = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            nodes[start].add(end);
            nodes[end].add(start);
        }

        dp = new int[N + 1][2];
        find(1, -1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static void find(int number, int parent) {
        dp[number][0] = 0;
        dp[number][1] = 1;

        for (int child : nodes[number]) {
            if (child != parent) {
                find(child, number);
                // 자신이 얼리어답터가 아니면 자식은 얼리어답터이어야 한다.
                dp[number][0] += dp[child][1];
                // 자신이 얼리어답터이면 둘 중 최소값으로 더한다.
                dp[number][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
    }
}
