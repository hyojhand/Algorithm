package Study.NotSolve;

import java.io.*;
import java.util.StringTokenizer;

public class Main2527 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int nx1 = Integer.parseInt(st.nextToken());
            int ny1 = Integer.parseInt(st.nextToken());
            int nx2 = Integer.parseInt(st.nextToken());
            int ny2 = Integer.parseInt(st.nextToken());
            int max_x = Math.max(x2, nx2);
            int max_y = Math.max(y2, ny2);

            int[][] arr = new int[max_x + 1][max_y + 1];
            for (int k = y1; k <= y2; k++) {
                for (int l = x1; l <= x2; l++) {
                    arr[k][l]++;
                }
            }

            for (int k = nx1; k <= nx2; k++) {
                for (int l = ny1; l <= ny2; l++) {
                    arr[k][l]++;
                }
            }

            int[] count = new int[max_x];

            for (int k = 0; k < max_x; k++) {
                for (int l = 0; l < max_y; l++) {
                    if (arr[k][l] == 2) {
                        count[k]++;
                    }
                }
            }

            int max_count = 0;
            int max_sum = 0;
            boolean isline = false;
            for (int k = 0; k < max_x; k++) {
                if (count[k] != 0) {
                    max_count++;
                    max_sum += count[k];
                    if (count[k] == 1) isline = true;
                }
            }

            char result;
            if (max_count == 0) {
                result = 'd';
            } else if (max_count == 1) {
                if (max_sum == 1) {
                    result = 'c';
                } else {
                    result = 'b';
                }
            } else {
                if (isline) {
                    result = 'b';
                } else {
                    result = 'a';
                }
            }

            sb.append(result).append('\n');
        }

        System.out.println(sb);

    }
}
