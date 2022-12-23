package Baekjoon.DP;

import java.io.*;
// G5 공통 부분 문자열 - LCS(SubString) 공통 부분 문자열 중에서 연속된 문자의 가장 긴 문자열의 길이 구하기
public class Main5582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str_A = br.readLine();
        String str_B = br.readLine();
        int len_A = str_A.length();
        int len_B = str_B.length();

        int[][] dp = new int[len_A + 1][len_B + 1];

        int max = 0;
        for (int i = 1; i <= len_A; i++) {
            for (int j = 1; j <= len_B; j++) {
                if (str_A.charAt(i-1) == str_B.charAt(j-1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max);
    }
}
