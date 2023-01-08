package Baekjoon.DP;

import java.io.*;
// G4 색상환
// dp[x][y] 는 일렬로 배열을 펼쳤을때 단순히 x개의 색 중에서 y개를 선택하는 경우의 수를 의미한다.
// 따라서, dp[x][y] = x를 선택했을때의 경우의수 + x를 선택하지 않았을 때의 경우의 수이다.
// x를 선택했을때 : dp[x-2][y-1] / 선택한 x와 인접한 x-1을 제외한 총 x-2개중에서 x를 선택한 1을 뺀 y-1을 의미한다
// x를 선택하지 않았을때 : dp[x-1][y] / x를 선택하지 않고 나머지 x-1개 중에서 y개를 의미한다
// dp[x][y] = dp[x-2][y-1] + dp[x-1][y]
public class Main2482 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        if (N < K * 2) {
            System.out.println(0);
            return;
        }

        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i][1] = i;
        }

        for (int i = 4; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                dp[i][j] = (dp[i - 2][j - 1] + dp[i - 1][j]) % 1000000003;
            }
        }

        System.out.println(dp[N][K]);
    }
}