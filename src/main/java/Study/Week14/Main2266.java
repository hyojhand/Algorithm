package Study.Week14;

import java.io.*;
import java.util.*;
// 금고 테스트
public class Main2266 {
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[N+1][K+1];
        System.out.println(find(N,K));
    }

    static int find(int n,int k) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(k == 1) return n;

        if(dp[n][k] != 0) return dp[n][k];

        dp[n][k] = 9999;
        for(int i = 1; i <= n; i++) {
            int temp = Math.max(find(i-1,k-1),find(n-i,k)) + 1;
            dp[n][k] =  Math.min(temp, dp[n][k]);
        }

        return dp[n][k];
    }
}
