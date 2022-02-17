package Study.Week1;

import java.io.*;
import java.util.StringTokenizer;

public class Main10157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(br.readLine());

        int[][] arr = new int[R][C];

        int x = R - 1;
        int y = 0;
        int count = 1;
        int col_level = R;
        int row_level = C - 1;

        while (true) {
            for (int i = 0; i < col_level; i++) {
                arr[x][y] = count;
                count++;
                if (i == col_level - 1) {
                    y++;
                    break;
                }
                x--;
            }
            col_level--;

            for (int i = 0; i < row_level; i++) {
                arr[x][y] = count;
                count++;
                if (i == row_level - 1) {
                    x++;
                    break;
                }
                y++;
            }
            row_level--;
            if(count >= R*C) break;

            for (int i = 0; i < col_level; i++) {
                arr[x][y] = count;
                count++;
                if (i == col_level - 1) {
                    y--;
                    break;
                }
                x++;
            }
            col_level--;

            for (int i = 0; i < row_level; i++) {
                arr[x][y] = count;
                count++;
                if (i == row_level - 1) {
                    x--;
                    break;
                }
                y--;
            }
            row_level--;

            if(count >= R*C) break;
        }


        boolean isIn = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == num) {
                    sb.append(j + 1).append(" ").append(R - i);
                    isIn = true;
                    break;
                }
            }
            if (isIn) break;
        }
        if (!isIn) sb.append(0);


        System.out.println(sb);

    }
}
