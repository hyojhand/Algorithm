package Study.Week3;

import java.io.*;
import java.util.StringTokenizer;

public class Main18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        int max_level = Integer.MIN_VALUE;
        int min_time = Integer.MAX_VALUE;
        for (int k = min; k <= max; k++) {
            int inben = B;
            int time = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int num = k - map[i][j];
                    if (num > 0) {
                        inben -= num;
                        time += num;
                    } else if (num < 0) {
                        inben -= num;
                        time -= (2 * num);
                    }
                }
            }

            if (inben >= 0) {
                if (min_time > time) {
                    min_time = time;
                    max_level = k;
                } else if (min_time == time) {
                    max_level = Math.max(max_level, k);
                }
            }

        }


        System.out.print(min_time + " " + max_level);
    }
}
