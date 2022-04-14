package Study.Week9;

import java.io.*;
import java.util.StringTokenizer;
// 운동
public class Main1956 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int INF = 9999999;

        int[][] arr = new int[V+1][V+1];
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = c;
        }

        for(int i = 1; i <= V; i++) {
            for(int j = 1; j <= V; j++) {
                if(i != j && arr[i][j] == 0) arr[i][j] = INF;
            }
        }

        for(int k = 1; k <= V; k++) {
            for(int i = 1; i <= V; i++) {
                for(int j = 1; j <= V; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int min = INF;
        for(int i = 1; i <= V; i++) {
            for(int j = 1; j <= V; j++) {
                if(i != j && arr[i][j] != INF && arr[j][i] != INF) {
                    min = Math.min(arr[i][j]+arr[j][i], min);
                }
            }
        }

        if(min == INF) min = -1;
        System.out.println(min);
    }
}

