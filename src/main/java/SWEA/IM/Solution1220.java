package SWEA.IM;

import java.io.*;
import java.util.StringTokenizer;

public class Solution1220 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 0;

        while (tc < 10) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                boolean isN = false;
                for (int j = 0; j < N; j++) {
                    if (arr[j][i] == 1) isN = true;

                    if (isN) {
                        if (arr[j][i] == 2) {
                            count++;
                            isN = false;
                        }
                    }

                }
            }

            tc++;
            sb.append("#").append(tc).append(" ").append(count).append('\n');
        }

        System.out.println(sb);
    }
}
