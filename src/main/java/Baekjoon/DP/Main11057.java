package Baekjoon.DP;

import java.io.*;

// S1 오르막 수 - 2차원 배열 dp[N(자리수)][K(끝 숫자)]
// dp[n][k] = dp[n-1][k] + dp[n][k-1] 점화식 찾기
public class Main11057 {
    private static final int MOD_NUMBER = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][10];
        for (int i = 1; i <= N; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < 10; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD_NUMBER;
            }
        }

        int answer = 0;
        for (int k = 0; k < 10; k++) {
            answer += dp[N][k];
        }

        System.out.println(answer % MOD_NUMBER);
    }
}

