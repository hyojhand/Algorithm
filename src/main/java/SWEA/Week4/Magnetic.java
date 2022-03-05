package SWEA.Week4;

import java.io.*;
import java.util.StringTokenizer;

public class Magnetic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 0;

        while (tc < 10) {

            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][N];

            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < 100; i++) {
                boolean isN = false;
                for (int j = 0; j < 100; j++) {

                    if (isN) {
                        if (arr[j][i] == 2) {
                            count++;
                            isN = false;
                        }
                    }

                    if (arr[j][i] == 1) isN = true;

                }
            }

            tc++;
            sb.append("#").append(tc).append(" ").append(count).append('\n');
        }

        System.out.println(sb);

    }
}
