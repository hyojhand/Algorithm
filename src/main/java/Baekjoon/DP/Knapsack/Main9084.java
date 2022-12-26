package Baekjoon.DP.Knapsack;

import java.io.*;
import java.util.*;
// G5 동전 - 동전하나마다 1부터 최대치까지 넣어보면서 dp를 더해나간다
public class Main9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] coin = new int[N+1];
            for(int i = 1; i <= N; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }

            int total = Integer.parseInt(br.readLine());
            int[] dp = new int[total + 1];

            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= total; j++) {
                    if(j - coin[i] > 0) {
                        dp[j] += dp[j-coin[i]];
                    } else if(j-coin[i] == 0) {
                        dp[j]++;
                    }
                }
            }
            /*
            j-coin[i]이 0 이상인 상태만 고려해서 계산하여 줄일 수 있다.
            dp[0] = 1;

            for(int i = 1; i <= N; i++) {
                for(int j = coin[i]; j <= total; j++) {
                    dp[j] += dp[j-coin[i]];
                }
            }
             */

            T--;
            sb.append(dp[total]).append('\n');
        }
        System.out.println(sb);
    }
}
