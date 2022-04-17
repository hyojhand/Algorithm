package Study.Week9;

import java.io.*;
// 스도쿠
public class Main2239 {
    static int blank = 0;
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                arr[i][j] = str.charAt(j) - '0';
                if (arr[i][j] == 0) blank++;
            }
        }

        find(0);
    }

    public static void find(int dept) {
        if (dept == blank) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]);
                }
                sb.append('\n');
            }

            System.out.println(sb);
            System.exit(0);
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        if (check(i, j, k)) {
                            arr[i][j] = k;
                            find(dept + 1);
                        }
                    }
                    arr[i][j] = 0;
                    return;
                }
            }
        }

    }

    public static boolean check(int row, int col, int value) {
        // row 체크
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == value) return false;
        }

        // col 체크
        for (int i = 0; i < 9; i++) {
            if (arr[i][col] == value) return false;
        }

        // 3*3 체크
        int x = row / 3 * 3;
        int y = col / 3 * 3;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (arr[i][j] == value) return false;
            }
        }

        return true;
    }
}
