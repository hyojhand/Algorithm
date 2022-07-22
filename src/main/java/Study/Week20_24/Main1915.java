package Study.Week20_24;

import java.io.*;
import java.util.*;
// 가장 큰 정사각형
public class Main1915 {
    static int[] dx = {-1,-1,0};
    static int[] dy = {0,-1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int max = 0;
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j)-'0';
                max = Math.max(max, arr[i][j]);
            }
        }

        for(int i = 1; i < N; i++) {
            for(int j = 1; j < M; j++) {
                if(arr[i][j] == 0) continue;

                int min = Integer.MAX_VALUE;
                for(int k = 0; k < 3; k++) {
                    min = Math.min(min,arr[i+dx[k]][j+dy[k]]);
                }

                arr[i][j] = min+1;
                max = Math.max(max, arr[i][j]);
            }
        }

        System.out.println(max*max);
    }
}

