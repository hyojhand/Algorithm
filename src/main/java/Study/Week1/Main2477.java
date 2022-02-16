package Study.Week1;

import java.io.*;
import java.util.StringTokenizer;

public class Main2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int[][] arr = new int[6][2];
        int row_max = 0;
        int col_max = 0;
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            if (arr[i][0] == 1 || arr[i][0] == 2) {
                row_max = Math.max(row_max, arr[i][1]);
            } else {
                col_max = Math.max(col_max, arr[i][1]);
            }
        }

        int[] result = new int[2];
        int index = 0;
        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                if (arr[5][0] == arr[i + 1][0]) {
                    result[index] = arr[i][1];
                    index++;
                }
            } else if (i == 5) {
                if (arr[i - 1][0] == arr[0][0]) {
                    result[index] = arr[i][1];
                    index++;
                }
            } else {
                if (arr[i - 1][0] == arr[i + 1][0]) {
                    result[index] = arr[i][1];
                    index++;
                }
            }
        }

        int sum = (row_max * col_max - result[0] * result[1]) * K;
        System.out.println(sum);

    }
}
