package SWEA.IM;

import java.io.*;
import java.util.StringTokenizer;

public class Solution1209 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 0;

        while (tc < 10) {
            int T = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];
            int max = 0;
            for(int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int sum = 0;
                for(int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    sum += arr[i][j];
                }
                max = Math.max(max,sum);
            }

            for(int i = 0; i < 100; i++) {
                int sum = 0;
                for(int j = 0; j < 100; j++) {
                    sum += arr[j][i];
                }
                max = Math.max(max,sum);
            }

            int sum = 0;
            for(int i = 0; i < 100; i++) {
                sum += arr[i][i];
            }
            max = Math.max(max,sum);

            sum =0;
            for(int i = 99; i >= 0; i--) {
                sum += arr[i][i];
            }
            max = Math.max(max,sum);

            tc++;
            sb.append("#").append(tc).append(" ").append(max).append('\n');
        }

        System.out.println(sb);
    }
}

