package Study.Week11;

import java.io.*;
import java.util.StringTokenizer;
// 내리막길
public class Main1520 {
    static int N, M;
    static int[][] arr,dp;
    static boolean[][] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dp = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        System.out.println(dp[0][0]);
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int dfs(int x,int y) {
        if(x == N-1 && y == M-1) {
            return 1;
        }

        if(visit[x][y]) {
            return dp[x][y];
        }

        int pre = arr[x][y];
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && pre > arr[nx][ny]) {
                dp[x][y] += dfs(nx,ny);
                visit[nx][ny] = true;
            }
        }

        return dp[x][y];
    }
}
