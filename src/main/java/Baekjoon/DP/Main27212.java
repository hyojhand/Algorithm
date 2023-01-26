package Baekjoon.DP;

import java.io.*;
import java.util.StringTokenizer;
// G3 미팅 - dp[i][j] = A[0..i] 와 B[0..j] 에 대한 최대 매칭 점수
// case1) A[i]를 선택x, case2) B[j]를 선택x, case3) A[i]가 B[j]를 선택
// dp[i][j] = max(max(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1] + W[A[i][B[j]])
public class Main27212 {
    static long[][] dp, W;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        W = new long[C + 1][C + 1];
        for (int i = 1; i <= C; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        B = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        dp = new long[N + 1][M + 1];

        long answer = find(N,M);
        System.out.println(answer);
    }

    static long find(int n, int k) {
        if (n == 0 || k == 0) return 0;

        if (dp[n][k] == 0) {
            dp[n][k] = Math.max(Math.max(find(n - 1, k), find(n, k - 1)), find(n - 1, k - 1) + W[A[n]][B[k]]);
        }

        return dp[n][k];
    }
}

