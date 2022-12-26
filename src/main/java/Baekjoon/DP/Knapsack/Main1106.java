package Baekjoon.DP.Knapsack;

import java.io.*;
import java.util.*;
// G5 호텔 - 최소 C명 이상이니 C + 100명까지 최소값을 구해준다 (1번 사람 최대가 100명)
public class Main1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] money = new int[N+1];
        int[] customer = new int[N+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            money[i] = Integer.parseInt(st.nextToken());
            customer[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[C+101];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++) {
            for(int j = customer[i]; j <= C + 100; j++) {

                if(dp[j - customer[i]] == Integer.MAX_VALUE) continue;
                dp[j] = Math.min(dp[j], dp[j - customer[i]] + money[i]);

                if(j >= C) min = Math.min(min, dp[j]);
            }
        }

        System.out.println(min);
    }
}
