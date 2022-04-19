package Study.Week10;

import java.io.*;
// LCS
public class Main9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String str2 = br.readLine();
        int len = str.length();
        int len2 = str2.length();

        int[][] dp = new int[len+1][len2+1];
        for(int i = 1; i <= len; i++) {
            for(int j = 1; j <= len2; j++) {
                if(str.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[len][len2]);
    }
}

