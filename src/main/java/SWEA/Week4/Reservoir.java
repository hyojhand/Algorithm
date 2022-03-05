package SWEA.Week4;

import java.io.*;
import java.util.StringTokenizer;

public class Reservoir {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        while (tc < T) {
            int N = Integer.parseInt(br.readLine());
            char[][] arr = new char[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = st.nextToken().charAt(0);
                }
            }

            int max = 0;
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < N - 1; j++) {
                    if (arr[i][j] == 'W') {
                        int count = 0;
                        for (int k = 0; k < 8; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (arr[nx][ny] == 'G') count++;
                        }

                        if (count == 8) {
                            max = Math.max(1, max);
                        } else {
                            max = Math.max(8 - count, max);
                        }
                    }
                }
            }


            tc++;
            sb.append("#").append(tc).append(" ").append(max).append('\n');
        }
        System.out.println(sb);

    }
}
