package Study.Week1;

import java.io.*;
import java.util.StringTokenizer;

public class Main17406 {
    static int[][] arr;
    static boolean[] check;
    static int[][] rotation;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check = new boolean[K];
        rotation = new int[K][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            rotation[i][0] = Integer.parseInt(st.nextToken());
            rotation[i][1] = Integer.parseInt(st.nextToken());
            rotation[i][2] = Integer.parseInt(st.nextToken());
        }

        call(K, 0);
        System.out.println(min);

    }

    public static void call(int K, int dept) {
        if (dept == K) {
            for (int i = 0; i < arr.length; i++) {
                int sum = 0;
                for (int j = 0; j < arr[0].length; j++) {
                    sum += arr[i][j];
                }
                min = Math.min(min, sum);
            }
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!check[i]) {
                check[i] = true;
                func(rotation[i][0], rotation[i][1], rotation[i][2]);
                call(K, dept + 1);
                refunc(rotation[i][0], rotation[i][1], rotation[i][2]);
                check[i] = false;
            }
        }
    }

    public static void refunc(int r, int c, int s) {
        int row_min = r - s - 1;
        int row_max = r + s - 1;
        int col_min = c - s - 1;
        int col_max = c + s - 1;
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
            if (row_min == row_max && col_min == col_max) break;
        }
    }

    public static void func(int r, int c, int s) {
        int row_min = r - s - 1;
        int row_max = r + s - 1;
        int col_min = c - s - 1;
        int col_max = c + s - 1;
        while (true) {
            int pre = arr[row_min + 1][col_min];
            int now;
            for (int i = col_min; i < col_max; i++) {
                now = arr[row_min][i];
                arr[row_min][i] = pre;
                pre = now;
            }
            for (int i = row_min; i < row_max; i++) {
                now = arr[i][col_max];
                arr[i][col_max] = pre;
                pre = now;
            }
            for (int i = col_max; i > col_min; i--) {
                now = arr[row_max][i];
                arr[row_max][i] = pre;
                pre = now;
            }
            for (int i = row_max; i > row_min; i--) {
                now = arr[i][col_min];
                arr[i][col_min] = pre;
                pre = now;
            }

            row_min++;
            row_max--;
            col_min++;
            col_max--;
            if (row_min == row_max && col_min == col_max) break;
        }

    }
}
