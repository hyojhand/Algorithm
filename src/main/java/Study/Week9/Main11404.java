package Study.Week9;

import java.io.*;
import java.util.StringTokenizer;
// 플로이드
public class Main11404 {
    static final int INF = 9999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());

            if(arr[a][b] != 0) arr[a][b] = Math.min(arr[a][b], c);
            else arr[a][b] = c;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i != j && arr[i][j] == 0) arr[i][j] = INF;
            }
        }

        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
//                if(i == k) continue;
                for(int j = 0; j < N; j++) {
//                    if(j == k || j == i) continue;
                    arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == INF) sb.append(0);
                else sb.append(arr[i][j]);
                sb.append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}

