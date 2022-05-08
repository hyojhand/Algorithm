package Study.Week11;

import java.io.*;
import java.util.StringTokenizer;

// 여왕벌
public class Main10836 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[M][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] num = new int[3];

            for(int k = 0; k < 3; k++) {
                num[k] = Integer.parseInt(st.nextToken());
            }

            int x = M-1;
            int y = 0;
            for(int k = 1; k <= M*2-1; k++) {
                if(k > num[0]+num[1]) arr[x][y] += 2;
                else if(k > num[0])arr[x][y] += 1;

                if(x == 0) y++;
                else x--;
            }

        }

        for(int i = 0; i <M; i++) {
            for(int j = 0; j < M; j++) {
                if(i > 0 && j > 0) arr[i][j] = arr[0][j];
                sb.append(arr[i][j]+1).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
