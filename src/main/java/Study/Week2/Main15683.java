package Study.Week2;

import java.io.*;
import java.util.StringTokenizer;

public class Main15683 {
    static int N;
    static int M;
    static int cctv_count = 0;
    static int min;
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        min = 0;
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) min++;
                if (arr[i][j] > 0 && arr[i][j] < 6) cctv_count++;
            }
        }
        find(0, arr, 0);

        System.out.println(min);

    }

    public static void find(int dept, int[][] map, int x) {
        if (dept == cctv_count) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) count++;
                }
            }
            min = Math.min(min, count);
            return;
        }

        int[][] copy = new int[N][M];
        for (int i = x; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && map[i][j] < 6 && !check[i][j]) {
                    check[i][j] = true;
                    Loop:
                    for (int k = 0; k < 4; k++) {

                        for (int a = 0; a < N; a++) {
                            copy[a] = map[a].clone();
                        }

                        switch (copy[i][j]) {
                            case 1:
                                search(i, j, copy, k);
                                find(dept + 1, copy, i);
                                break;
                            case 2:
                                search(i, j, copy, k);
                                search(i, j, copy, (k + 2) % 4);
                                find(dept + 1, copy, i);
                                break;
                            case 3:
                                search(i, j, copy, k);
                                search(i, j, copy, (k + 1) % 4);
                                find(dept + 1, copy, i);
                                break;
                            case 4:
                                search(i, j, copy, k);
                                search(i, j, copy, (k + 1) % 4);
                                search(i, j, copy, (k + 2) % 4);
                                find(dept + 1, copy, i);
                                break;
                            case 5:
                                search(i, j, copy, 0);
                                search(i, j, copy, 1);
                                search(i, j, copy, 2);
                                search(i, j, copy, 3);
                                find(dept + 1, copy, i);
                                break Loop;
                        }
                    }

                    check[i][j] = false;
                }
            }
        }


    }


    static int[] dx = {-1, 0, 1, 0}; // 상,우,하,좌
    static int[] dy = {0, 1, 0, -1};

    public static void search(int x, int y, int[][] map, int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        while (true) {
            if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 6) break;
            if (map[nx][ny] == 0) map[nx][ny] = -1;
            nx += dx[dir];
            ny += dy[dir];
        }

    }

}
