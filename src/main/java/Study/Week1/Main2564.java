package Study.Week1;

import java.io.*;
import java.util.StringTokenizer;

public class Main2564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int P = Integer.parseInt(br.readLine());
        int[] direction = new int[P + 1];
        int[] x = new int[P + 1];
        for (int i = 0; i <= P; i++) {
            st = new StringTokenizer(br.readLine());
            direction[i] = Integer.parseInt(st.nextToken());
            x[i] = Integer.parseInt(st.nextToken());
        }

        int[][] arr = new int[P + 1][2];
        for (int i = 0; i <= P; i++) {
            switch (direction[i]) {
                case 1:
                    arr[i][0] = x[i];
                    arr[i][1] = M;
                    break;
                case 2:
                    arr[i][0] = x[i];
                    arr[i][1] = 0;
                    break;
                case 3:
                    arr[i][0] = 0;
                    arr[i][1] = M - x[i];
                    break;
                case 4:
                    arr[i][0] = N;
                    arr[i][1] = M - x[i];
                    break;
            }
        }

        int sum = 0;
        int num = 0;
        for (int i = 0; i < P; i++) {
            switch (direction[P]) {
                case 1:
                    if (direction[i] == 2) {
                        num = arr[i][0] + arr[P][0] + arr[i][1] + arr[P][1];
                    } else {
                        num = Math.abs(arr[i][0] - arr[P][0]) + Math.abs(arr[i][1] - arr[P][1]);
                    }
                    break;
                case 2:
                    if (direction[i] == 1) {
                        num = arr[i][0] + arr[P][0] + arr[i][1] + arr[P][1];
                    } else {
                        num = Math.abs(arr[i][0] - arr[P][0]) + Math.abs(arr[i][1] - arr[P][1]);
                    }
                    break;
                case 3:
                    if (direction[i] == 4) {
                        num = arr[i][0] + arr[P][0] + arr[i][1] + arr[P][1];
                    } else {
                        num = Math.abs(arr[i][0] - arr[P][0]) + Math.abs(arr[i][1] - arr[P][1]);
                    }
                    break;
                case 4:
                    if (direction[i] == 3) {
                        num = arr[i][0] + arr[P][0] + arr[i][1] + arr[P][1];
                    } else {
                        num = Math.abs(arr[i][0] - arr[P][0]) + Math.abs(arr[i][1] - arr[P][1]);
                    }
                    break;
            }

            sum += Math.min(num, (N * 2 + M * 2) - num);
        }

        System.out.println(sum);

    }
}
