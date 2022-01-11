package Baekjoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1932 {
    static Integer[][] dp;
    static int[][] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new Integer[N][N];
        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(tri(0,0));

    }

    static int tri(int dept, int idx) {
        if(dept == N-1) {
            dp[dept][idx] = arr[dept][idx];
            return dp[dept][idx];
        }

        if(dp[dept][idx] == null) {
            dp[dept][idx] = Math.max(tri(dept+1, idx), tri(dept+1,idx+1)) + arr[dept][idx];
        }
        return dp[dept][idx];
    }
}
