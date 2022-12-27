package Baekjoon.DP.LIS;

import java.io.*;
import java.util.StringTokenizer;
// S2 가장 긴 증가하는 부분 수열 - 부분 수열에서 증가하는 길이가 가장 긴 부분수열의 길이를 구하는 문제
public class Main11053 {
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

        int max = dp[0];
        for(int i = 0; i < N; i++) {
            max = Math.max(max, find(i));
        }

        System.out.println(max);
    }

    public static int find(int a) {
        if(dp[a] == 0) {
            dp[a] = 1;

            for(int i = 0; i < a; i++) {
                if(arr[i] < arr[a]) dp[a] = Math.max(dp[a], find(i) + 1);
            }
        }
        return dp[a];
    }
}
