package Study.Week0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3085 {
    static char[][] arr;
    static int N;
    static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
            }
            max = Math.max(max, row_max(i));
        }

        for (int i = 0; i < N; i++) {
            max = Math.max(max, col_max(i));
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N) {
                    swap(i, j, i, j + 1);
                    max = Math.max(max, row_max(i));
                    max = Math.max(max, col_max(j));
                    max = Math.max(max, col_max(j+1));
                    swap(i, j, i, j + 1);

                }

                if (i + 1 < N) {
                    swap(i, j, i + 1, j);
                    max = Math.max(max, row_max(i));
                    max = Math.max(max, row_max(i+1));
                    max = Math.max(max, col_max(j));
                    swap(i, j, i + 1, j);

                }

            }
        }

        System.out.println(max);

    }

    public static void swap(int x, int y, int nextx, int nexty) {
        char tmp = arr[x][y];
        arr[x][y] = arr[nextx][nexty];
        arr[nextx][nexty] = tmp;
    }

    public static int row_max(int x) {
        int count = 1;
        int maxtemp = 1;
        char ch = arr[x][0];
        for (int i = 1; i < N; i++) {
            if (arr[x][i] == ch) {
                count++;
            } else {
                ch = arr[x][i];
                maxtemp = Math.max(maxtemp, count);
                count = 1;
            }
        }

        return Math.max(maxtemp,count);
    }

    public static int col_max(int y) {
        int count = 1;
        int maxtemp = 1;
        char ch = arr[0][y];
        for (int i = 1; i < N; i++) {
            if (arr[i][y] == ch) {
                count++;
            } else {
                ch = arr[i][y];
                maxtemp = Math.max(maxtemp, count);
                count = 1;
            }
        }

        return Math.max(maxtemp,count);
    }


}
