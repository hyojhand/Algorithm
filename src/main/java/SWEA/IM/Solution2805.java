package SWEA.IM;

import java.io.*;

public class Solution2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        while (tc < T) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = str.charAt(j) - '0';
                }
            }

            int idx = N / 2;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (i <= N / 2) {
                    for (int j = idx; j < idx + (i * 2 + 1); j++) {
                        sum += arr[i][j];
                    }
                    idx--;
                    if (idx == -1) idx = 1;
                } else {
                    for (int j = idx; j < idx + (N - idx * 2); j++) {
                        sum += arr[i][j];
                    }
                    idx++;
                }
            }

            tc++;
            sb.append("#").append(tc).append(" ").append(sum).append('\n');
        }

        System.out.println(sb);
    }
}
