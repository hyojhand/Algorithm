package SWEA.IM;

import java.io.*;
import java.util.StringTokenizer;

public class Solution1979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        while (tc < T) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == 1) {
                        int x_count = 1;
                        for (int k = j + 1; k < N; k++) {
                            if (arr[i][k] == 1) x_count++;
                            else break;
                        }
                        j += x_count - 1;
                        if (x_count == K) count++;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[j][i] == 1) {
                        int y_count = 1;
                        for (int k = j + 1; k < N; k++) {
                            if (arr[k][i] == 1) y_count++;
                            else break;
                        }
                        j += y_count - 1;
                        if (y_count == K) count++;
                    }
                }
            }


            tc++;
            sb.append("#").append(tc).append(" ").append(count).append('\n');
        }

        System.out.println(sb);
    }
}

