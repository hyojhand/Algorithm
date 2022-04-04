package Study.Week8;

import java.io.*;
import java.util.*;

public class Main1194 {
    static char[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static Point start;
    static boolean[][][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visit = new boolean[N][M][64];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == '0') {
                    start = new Point(i, j, 0, 0);
                }
            }
        }

        int result = bfs();
        System.out.println(result);

    }

    public static int bfs() {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(start.x, start.y, 0, 0));
        visit[start.x][start.y][0] = true;

        while (!que.isEmpty()) {

            Point p = que.poll();
            int x = p.x;
            int y = p.y;
            int count = p.count;
            int key = p.key;

            if (arr[x][y] == '1') return count;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx>=0&& ny>=0 &&nx<N &&ny<M && arr[nx][ny] != '#' && !visit[nx][ny][key]) {
                    // 열쇠
                    if(arr[nx][ny] >= 'a' && arr[nx][ny] <= 'f') {
                        int next_key = 1 << (arr[nx][ny] - 'a');
                        next_key = key | next_key;
                        visit[nx][ny][next_key] = true;
                        que.offer(new Point(nx,ny,count+1,next_key));
                    } // 문
                    else if(arr[nx][ny] >= 'A' && arr[nx][ny] <= 'F') {
                        if((key & 1 << (arr[nx][ny] - 'A')) > 0) {
                            visit[nx][ny][key] = true;
                            que.offer(new Point(nx,ny,count+1,key));
                        }
                    } // 평지
                    else {
                        visit[nx][ny][key] = true;
                        que.offer(new Point(nx,ny,count+1,key));
                    }

                }
            }
        }

        return -1;
    }

    static class Point {
        int x;
        int y;
        int count;
        int key;

        public Point(int x, int y, int count, int key) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.key = key;
        }
    }
}
