package Baekjoon.DP.LIS;

import java.io.*;
import java.util.StringTokenizer;
// S2 가장 큰 증가 부분 수열 - 부분 수열에서 증가하는 합이 가장 큰 부분수열의 최대값을 구하는 문제
public class Main11055 {
    static int[] dp, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        dp = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        for(int i = 0; i < N; i++) {
            dp[i] = arr[i];
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j] + arr[i]);
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
