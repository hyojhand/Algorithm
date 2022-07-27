package Study.Week20_24;

import java.io.*;
import java.util.*;
// 관악산 등산
public class Main14699 {
    static int[] high, dp;
    static int N;
    static boolean[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        high = new int[N+1];
        dp = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            high[i] = Integer.parseInt(st.nextToken());
        }

        arr = new boolean[N+1][N+1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = true;
            arr[b][a] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            int num = find(i);
            sb.append(num).append('\n');
        }
        System.out.println(sb);
    }

    static int find(int num) {
        if(dp[num] != 0) return dp[num];

        dp[num] = 1;
        int max = 1;
        for(int i = 1; i <= N; i++) {
            if(arr[num][i] && high[i] > high[num]) {
                if(dp[i] == 0) find(i);
                max = Math.max(max, dp[i]+1);
            }
        }

        dp[num] = max;
        return dp[num];
    }
}

