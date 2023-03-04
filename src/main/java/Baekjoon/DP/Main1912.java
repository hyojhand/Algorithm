package Baekjoon.DP;

import java.io.*;
import java.util.StringTokenizer;
// S2 연속합 - N개의 수 중에서 연속된 합이 가장 큰 수 구하기
public class Main1912 {
    static Integer[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        arr = new int[N + 1];
        dp = new Integer[N + 1];

        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 0;

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++) {
            max = Math.max(max, find(i));
        }
        System.out.println(max);

    }

    static int find(int N) {
        if(dp[N] == null) {
            dp[N] = Math.max(arr[N], find(N-1) + arr[N]);
        }
        return dp[N];
    }
}
