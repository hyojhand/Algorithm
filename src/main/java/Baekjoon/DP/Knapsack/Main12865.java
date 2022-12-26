package Baekjoon.DP.Knapsack;

import java.io.*;
import java.util.*;
// G5 평범한 배낭 - 1부터 최대무게까지 돌면서 각 무게일때의 가치를 dp해나간다.
// 넣을 수 있는 무게라면, 넣기전의 무게때의 가치와 지금의 가치를 더한 값과 아예 안넣었을때의 가치 중에서 비교해본다.
public class Main12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N+1][K+1];
        int[] W = new int[N+1];
        int[] V = new int[N+1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= K; j++) {
                if(W[i] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-W[i]] + V[i], dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
