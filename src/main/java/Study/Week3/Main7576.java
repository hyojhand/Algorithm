package Study.Week3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7576 {
    static int[][] arr;
    static int N,M;
    static Queue<Point> que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i = 0; i < N ;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j =0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) que.offer(new Point(i,j));
            }
        }

        bfs();
        int max = 0;

        Loop:
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0) {
                    max = 0;
                    break Loop;
                }
                max = Math.max(max, arr[i][j]);
            }
        }

        System.out.println(max-1);

    }

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void bfs() {

        while(!que.isEmpty()) {
            Point p = que.poll();

            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny <M) {
                    if(arr[nx][ny] == 0) {
                        arr[nx][ny] = arr[p.x][p.y] + 1;
                        que.offer(new Point(nx,ny));
                    }
                }
            }
        }

    }

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

