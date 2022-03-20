package Study.Week6;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2178 {
    static boolean[][] check;
    static int[][] arr;
    static int N, M;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        check = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(count);
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void bfs() {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(0, 0));
        check[0][0] = true;

        while (!que.isEmpty()) {
            count++;
            if(check[N-1][M-1]) break;

            int size = que.size();
            for (int k = 0; k < size; k++) {
                Point p = que.poll();
                int x = p.x;
                int y = p.y;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < M && !check[nx][ny] && arr[nx][ny] == 1) {
                        check[nx][ny] = true;
                        que.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }

    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

