package Baekjoon.DP.LCS;

import java.io.*;
// G3 LCS 3 - 3개의 문자열중에서 공통부분 '수열(SubSequence)'를 구하라
public class Main1958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str_A = br.readLine();
        String str_B = br.readLine();
        String str_C = br.readLine();
        int len_A = str_A.length();
        int len_B = str_B.length();
        int len_C = str_C.length();

        int[][][] dp = new int[len_A + 1][len_B + 1][len_C + 1];

        int max = 0;
        for (int i = 1; i <= len_A; i++) {
            for (int j = 1; j <= len_B; j++) {
                for(int k = 1; k <= len_C; k++) {
                    if ((str_A.charAt(i-1) == str_B.charAt(j-1)) &&
                            (str_B.charAt(j-1) == str_C.charAt(k-1)) &&
                            (str_A.charAt(i-1) == str_C.charAt(k-1))) dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    else dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
                }
            }
        }

        System.out.println(dp[len_A][len_B][len_C]);
    }
}

