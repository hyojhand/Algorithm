package Study.Week19;

import java.io.*;
import java.util.*;

// 기타리스트
public class Main1495 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max = -1;
        int[] volume = new int[N];
        boolean[][] dp = new boolean[N+1][M+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            volume[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][S] = true;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j <= M; j++) {
                if(dp[i][j]) {
                    if(j + volume[i] <= M) dp[i+1][j+volume[i]] = true;
                    if(j - volume[i] >= 0) dp[i+1][j-volume[i]] = true;
                }
            }
        }


        for(int i = 0; i <= M; i++) {
            if(dp[N][i]) max = Math.max(max, i);
        }

        System.out.println(max);
    }
}

