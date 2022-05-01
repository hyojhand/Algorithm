package Study.Week11;

import java.io.*;
import java.util.StringTokenizer;
// 팰린드롬?
public class Main10942 {
    static Integer[][] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new Integer[N+1][N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(find(a,b)).append('\n');
        }

        System.out.println(sb);
    }

    static int find(int a,int b) {
        if(a == b) {
            dp[a][b] = 1;
            return dp[a][b];
        }
        if(a+1 == b && b-1 == a) {
            if(arr[a] == arr[b]) dp[a][b] = 1;
            else dp[a][b] = 0;

            return dp[a][b];
        }

        if(dp[a][b] == null) {
            if(arr[a] == arr[b] && find(a+1,b-1) == 1) {
                dp[a][b] = 1;
            } else {
                dp[a][b] = 0;
            }
        }
        return dp[a][b];
    }
}

