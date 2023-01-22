package Baekjoon.DP;

import java.io.*;
import java.util.StringTokenizer;
// G5 합분해
// dp[n][k] = (dp[n][k-1] + 0) + (dp[n-1][k-1] + 1) +...+ (dp[0][k-1] + n)
// => dp[n][k-1] + dp[n-1][k]
public class Main2638 {
    static int[][] dp;
    private static final int MODNUBER = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][1] = 1;
        }

        for (int i = 0; i <= K; i++) {
            dp[0][i] = 1;
        }

        System.out.println(find(N, K));
    }

    static int find(int n, int k) {
        if (dp[n][k] == 0) {

            dp[n][k] = (find(n, k - 1) + find(n - 1, k)) % MODNUBER;
        }
        return dp[n][k];
    }
}

