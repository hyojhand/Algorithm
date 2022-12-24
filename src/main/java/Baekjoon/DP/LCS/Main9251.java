package Baekjoon.DP.LCS;

import java.io.*;
// G5 LCS - Longest Common Subsequence, 최장 공통 부분 수열
// 떨어진 단어라도 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제
public class Main9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str_A = br.readLine();
        String str_B = br.readLine();
        int len_A = str_A.length();
        int len_B = str_B.length();

        int[][] dp = new int[len_A + 1][len_B + 1];

        for (int i = 1; i <= len_A; i++) {
            for (int j = 1; j <= len_B; j++) {
                if (str_A.charAt(i-1) == str_B.charAt(j-1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        System.out.println(dp[len_A][len_B]);
    }
}
