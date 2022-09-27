package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11053 {
    static Integer[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new Integer[N+1];
        arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");;
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 0;
        for(int i = 1; i <= N; i++) {
            find(i);
        }
        int max = dp[1];

        for(int i = 2; i <= N; i++) {
            max = Math.max(max,dp[i]);
        }

        System.out.println(max);


    }
    static int find(int N) {
        if(dp[N] == null) {
            dp[N] = 1;

            for(int i = N-1; i > 0; i--) {
                if(arr[i] < arr[N]) {
                    dp[N] = Math.max(dp[N], find(i) + 1);
                }
            }
        }
        return dp[N];
    }
}
