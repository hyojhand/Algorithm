package Baekjoon.DP.Knapsack;

import java.io.*;
import java.util.*;
// G5 수강과목 - 배낭문제와 동일한 2차원 배열 Knapsack 문제
public class Main17845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max_time = Integer.parseInt(st.nextToken());
        int subjects = Integer.parseInt(st.nextToken());

        int[] important = new int[subjects + 1];
        int[] time = new int[subjects + 1];

        for(int i = 1; i <= subjects; i++) {
            st = new StringTokenizer(br.readLine());
            important[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[subjects + 1][max_time + 1];
        for(int i = 1; i <= subjects; i++) {
            for(int j = 1; j <= max_time; j++) {
                if(time[i] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - time[i]] + important[i]);
                }
            }
        }
        System.out.println(dp[subjects][max_time]);
    }
}

