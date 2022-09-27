package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2579 {
    static int[] score;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        score = new int[N + 1];
        dp = new Integer[N + 1];

        score[0] = 0;
        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = score[0];
        dp[1] = score[1];

        if(N >= 2) {
            dp[2] = score[1] + score[2];
        }

        System.out.println(stairs(N));

    }

    static int stairs(int N) {
        if (dp[N] == null) {
            dp[N] = Math.max(stairs(N - 2), stairs(N - 3) + score[N - 1]) + score[N];
        }
        return dp[N];
    }

}
