package Study.Week13;

import java.io.*;
import java.util.StringTokenizer;
// 앱
public class Main7579 {
    static int N,M, memory[],cost[];
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        memory = new int[N];
        cost = new int[N];

        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st2.nextToken());
        }

        dp = new int[N][10001];
        find();

        for(int i = 0; i <= 10000; i++) {
            if(dp[N-1][i] >= M) {
                System.out.println(i);
                break;
            }
        }

    }

    static void find() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j <= 10000; j++) {
                if(i == 0) {
                    if(j >= cost[i]) dp[i][j] = memory[i];
                } else {
                    if(j >= cost[i]) dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost[i]]+memory[i]);
                    else dp[i][j] = dp[i-1][j];
                }
            }
        }
    }

}
