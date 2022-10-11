package Baekjoon.Dijkstra;

import java.io.*;
import java.util.*;
// 서강그라운드 G4 - 플로이드 워셜 풀이
public class Main14938_Floyd {
    static final int INF = 9999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] item = new int[n+1];
        for(int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        int[][] arr = new int[n+1][n+1];
        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr[from][to] = weight;
            arr[to][from] = weight;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i != j && arr[i][j] == 0) arr[i][j] = INF;
            }
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    arr[i][j] = Math.min(arr[i][k] + arr[k][j] , arr[i][j]);
                }
            }
        }

        int max = 0;
        for(int i = 1; i <= n; i++) {
            int sum = 0;
            for(int j = 1; j <= n; j++) {
                if(arr[i][j] <= m) sum += item[j];
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }

}
