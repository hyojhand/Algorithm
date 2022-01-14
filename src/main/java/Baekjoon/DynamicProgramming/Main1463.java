package Baekjoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1463 {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];
        dp[0] = 0;
        dp[1] = 0;

        System.out.println(changeOne(N));
    }

    static int changeOne(int N) {
        if (dp[N] == null) {
            if (N % 6 == 0) {
                dp[N] = Math.min(changeOne(N - 1), Math.min(changeOne(N / 2), changeOne(N / 3))) + 1;
            } else if (N % 3 == 0) {
                dp[N] = Math.min(changeOne(N / 3), changeOne(N - 1)) + 1;
            } else if (N % 2 == 0) {
                dp[N] = Math.min(changeOne(N / 2), changeOne(N - 1)) + 1;
            } else {
                dp[N] = changeOne(N - 1) + 1;
            }
        }
        return dp[N];
    }
}
