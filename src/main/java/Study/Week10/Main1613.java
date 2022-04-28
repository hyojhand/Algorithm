package Study.Week10;

import java.io.*;
import java.util.StringTokenizer;

// 역사
public class Main1613 {
    static int INF = 999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i != j) arr[i][j] = INF;
            }
        }

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int S = Integer.parseInt(br.readLine());
        for(int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(arr[a][b] > 0 && arr[a][b] != INF) {
                sb.append(-1);
            } else if(arr[a][b] == INF) {
                if(arr[b][a] == INF) sb.append(0);
                else sb.append(1);
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }
}

