package SWEA.IM;

import java.io.*;

public class Solution2005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        while (tc < T) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];

            int count = 1;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < count; j++) {
                    int x1 = i-1;
                    int y1 = j-1;

                    if(x1 >= 0 && y1 >= 0 && arr[x1][y1] != 0 && arr[x1][j] != 0) arr[i][j] = arr[x1][y1] + arr[x1][j];
                    else arr[i][j] = 1;
                }
                count++;
            }


            tc++;
            sb.append("#").append(tc).append('\n');

            for(int i = 0; i < N;i ++) {
                for(int j = 0; j < N; j++) {
                    if(arr[i][j] == 0) break;
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append('\n');
            }

        }

        System.out.println(sb);
    }
}
