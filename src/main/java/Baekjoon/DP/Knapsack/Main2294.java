package Baekjoon.DP.Knapsack;

import java.io.*;
import java.util.*;
// G5 동전 2 - 딱 맞게 떨어지면 (0이면) 무조건 동전 1개이고, 각 동전값 - 해당 동전으로 dp를 채워가면서 동전 개수 1을 더해간다.
public class Main2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];
        for(int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[K+1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;

        for(int i = 0; i < N; i++) {
            for(int j = coin[i]; j <= K; j++) {
                dp[j] = Math.min(dp[j], dp[j-coin[i]] + 1);
            }
        }

        if(dp[K] == Integer.MAX_VALUE - 1) System.out.println("-1");
        else System.out.println(dp[K]);
    }
}
