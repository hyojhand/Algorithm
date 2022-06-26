package Study.Week13;

import java.io.*;
import java.util.*;
// RGB거리 2
public class Main17404 {
    static int color[][],dp[][],result[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        color = new int[N+1][3];
        dp = new int[N+1][3];
        result = new int[3];
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            color[i][0] = Integer.parseInt(st.nextToken());
            color[i][1] = Integer.parseInt(st.nextToken());
            color[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int k = 0; k < 3; k++) {
            for(int l = 0; l < 3; l++) {
                if(k == l) dp[1][l] = color[1][l];
                else dp[1][l] = 9999;
            }

            for(int i = 2; i <= N; i++) {
                dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + color[i][0];
                dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + color[i][1];
                dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + color[i][2];
            }

            if(k == 0) result[0] = Math.min(dp[N][1],dp[N][2]);
            if(k == 1) result[1] = Math.min(dp[N][0],dp[N][2]);
            if(k == 2) result[2] = Math.min(dp[N][0],dp[N][1]);
        }

        System.out.println(Math.min(Math.min(result[0],result[1]),result[2]));
    }
}

