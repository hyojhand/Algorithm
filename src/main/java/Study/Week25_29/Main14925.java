package Study.Week25_29;

import java.io.*;
import java.util.*;
// 목장 건설하기
public class Main14925 {
    static int[] dx = {-1,-1,0};
    static int[] dy = {0,-1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[M][N];
        int[][] dp = new int[M][N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++) {
            if(arr[i][0] == 0)  dp[i][0] = 1;
        }

        for(int i = 0; i < N; i++) {
            if(arr[0][i] == 0) dp[0][i] = 1;
        }

        for(int i = 1; i < M; i++) {
            for(int j = 1; j < N; j++) {
                if(arr[i][j] != 0) {
                    dp[i][j] = 0;
                    continue;
                }

                int min = Integer.MAX_VALUE;

                for(int k = 0; k < 3; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    min = Math.min(min,dp[nx][ny]);
                }

                dp[i][j] = min+1;
            }
        }

        int max = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max);
    }
}
