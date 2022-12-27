package Baekjoon.DP.LIS;

import java.io.*;
import java.util.StringTokenizer;
// S2 가장 긴 감소하는 부분수열
public class Main11722 {
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

        int max = 0;
        for(int i = 0; i < N; i++) {
            max = Math.max(max, find(i));
        }
        System.out.println(max);
    }

    public static int find(int num) {
        if(dp[num] == 0) {
            dp[num] = 1;

            for(int i = 0; i < num; i++) {
                if(arr[i] > arr[num]) dp[num] = Math.max(dp[num], find(i) + 1);
            }
        }
        return dp[num];
    }
}
