package Study.Week12;

import java.io.*;
import java.util.StringTokenizer;
// 양팔저울
public class Main2629 {
    static int N,M;
    static int[] weight;
    static boolean[][] dp;
    static boolean[] check;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        weight = new int[N+1];
        dp = new boolean[N+1][15001];
        check = new boolean[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        dp(0,0);
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(num > 15000) sb.append("N ");
            else {
                if(dp[N][num]) sb.append("Y ");
                else sb.append("N ");
            }
        }
        System.out.println(sb);
    }

    static void dp(int dept,int num) {
        if(dp[dept][num]) return;
        dp[dept][num] = true;
        if(dept == N) return;

        for(int i = 1; i <= N; i++) {
            if(!check[i]) {
                check[i] = true;
                dp(dept + 1, num + weight[i]);
                dp(dept + 1, num);
                dp(dept + 1,Math.abs(num-weight[i]));
                check[i] = false;
            }
        }
    }
}