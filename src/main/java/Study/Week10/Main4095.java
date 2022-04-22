package Study.Week10;

import java.io.*;
import java.util.StringTokenizer;

// 최대 정사각형
public class Main4095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if(N == 0 && M == 0) break;

            int[][] arr = new int[N][M];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            for(int i = 0; i < N; i++) {
                if(arr[i][0] == 1) {
                    max = 1;
                    break;
                }
                if(arr[0][i] == 1) {
                    max = 1;
                    break;
                }
            }

            for(int i = 1; i < N; i++) {
                for(int j = 1; j < M; j++) {
                    if(arr[i][j] != 0) {
                        arr[i][j] = Math.min(arr[i-1][j], Math.min(arr[i-1][j-1],arr[i][j-1])) + 1;
                        max = Math.max(arr[i][j], max);
                    }
                }
            }

            sb.append(max).append('\n');
        }
        System.out.println(sb);
    }
}

