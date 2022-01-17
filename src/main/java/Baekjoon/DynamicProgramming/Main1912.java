package Baekjoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1912 {
    static Integer[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        arr = new int[N];
        dp = new Integer[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];

        int max = dp[0];
        for(int i = 1; i < N; i++) {
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
