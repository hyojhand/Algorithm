package SWEA.IM;

import java.io.*;
import java.util.StringTokenizer;

public class Solution1961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        while (tc < T) {
            tc++;
            sb.append("#").append(tc).append('\n');

            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][][] copy = new int[3][N][N];
            int y = 0;
            int x = N-1;
            for(int i = 0; i < N; i++) {
                x = N-1;
                for(int j = 0; j < N; j++) {
                    copy[0][i][j] = arr[x][y];
                    x--;
                }
                y++;
            }

            x = N-1;
            for(int i = 0; i < N; i++) {
                y = N-1;
                for(int j = 0; j < N; j++) {
                    copy[1][i][j] = arr[x][y];
                    y--;
                }
                x--;
            }

            y = N-1;
            for(int i = 0; i < N; i++) {
                x = 0;
                for(int j = 0; j < N; j++) {
                    copy[2][i][j] = arr[x][y];
                    x++;
                }
                y--;
            }

            for(int i = 0; i < N; i++) {
                for(int k = 0; k < 3; k++) {
                    for(int j = 0; j < N; j++) {
                        sb.append(copy[k][i][j]);
                    }
                    sb.append(" ");
                }
                sb.append('\n');
            }
        }

        System.out.println(sb);

    }
}
