package Baekjoon.DP.Knapsack;

import java.io.*;
import java.util.*;
// G5 벼락치기 - 배낭문제와 동일한 2차원 배열 Knapsack 문제
public class Main14728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] time = new int[N+1];
        int[] score = new int[N+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            score[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][T+1];

        int max = 0;
        for (int i = 1; i <= N; i++) {
            for(int j = 1; j <= T; j++) {
                if (time[i] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - time[i]] + score[i]);
                }

                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max);
    }
}
