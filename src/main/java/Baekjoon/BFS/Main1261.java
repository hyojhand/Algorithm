package Baekjoon.BFS;

import java.io.*;
import java.util.*;
// G4 알고스팟
public class Main1261 {
    static int N, M;
    static int[][] arr;
    static int[][] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        count = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(count[N-1][M-1]);
    }


    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static void bfs() {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(0, 0, 0));
        boolean[][] check = new boolean[N][M];
        check[0][0] = true;

        while (!que.isEmpty()) {
            Point p = que.poll();

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                int ncnt = p.cnt;

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(arr[nx][ny] == 1) ncnt++;

                if (!check[nx][ny]) {
                    count[nx][ny] = ncnt;
                    que.offer(new Point(nx, ny, count[nx][ny]));
                    check[nx][ny] = true;
                } else {
                    if(count[nx][ny] > ncnt) {
                        count[nx][ny] = ncnt;
                        que.offer(new Point(nx,ny,count[nx][ny]));
                    }
                }
            }
        }
    }

    static class Point {
        int x, y, cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
