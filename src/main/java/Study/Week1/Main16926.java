package Study.Week1;

import java.io.*;
import java.util.StringTokenizer;

public class Main16926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (R > 0) {
            int row_min = 0;
            int row_max = N - 1;
            int col_min = 0;
            int col_max = M - 1;
            while (true) {
                int pre = arr[row_min][col_min + 1];
                int now;
                for (int i = row_min; i < row_max; i++) {
                    now = arr[i][col_min];
                    arr[i][col_min] = pre;
                    pre = now;
                }
                for (int i = col_min; i < col_max; i++) {
                    now = arr[row_max][i];
                    arr[row_max][i] = pre;
                    pre = now;
                }
                for (int i = row_max; i > row_min; i--) {
                    now = arr[i][col_max];
                    arr[i][col_max] = pre;
                    pre = now;
                }
                for (int i = col_max; i > col_min; i--) {
                    now = arr[row_min][i];
                    arr[row_min][i] = pre;
                    pre = now;
                }

                row_min++;
                row_max--;
                col_min++;
                col_max--;
                if (row_min >= (N / 2) || col_min >= (M / 2)) break;
            }
            R--;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
