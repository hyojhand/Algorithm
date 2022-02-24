package SWEA.Week2;

import java.io.*;
import java.util.StringTokenizer;

public class SquareRoom {
    static int max;
    static int[][] arr;
    static int[][] delta = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visit;
    static int max_num;
    static int max_result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        while (tc < T) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            visit = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            max_result = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    find(1, N, i, j);

                    if (max > max_result) {
                        max_result = max;
                        max_num = arr[i][j];
                    } else if (max == max_result) {
                        max_num = Math.min(max_num, arr[i][j]);
                    }
                    max = 1;

                }
            }

            tc++;
            sb.append("#").append(tc).append(" ").append(max_num).append(" ").append(max_result).append('\n');
        }

        System.out.println(sb);

    }

    public static void find(int count, int N, int x, int y) {
        if (!visit[x][y]) {
            visit[x][y] = true;
            for (int k = 0; k < 4; k++) {
                int nx = x + delta[k][0];
                int ny = y + delta[k][1];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (arr[nx][ny] == (arr[x][y] + 1)) {
                        find(count + 1, N, nx, ny);
                    } else {
                        if (max <= count) {
                            max = count;
                        }
                    }
                }
            }
        }
        visit[x][y] = false;

    }
}
