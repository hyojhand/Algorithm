package Baekjoon.BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
// 미로만들기 G4
public class Main2665 {
    static int[][] arr, count;
    static int n;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        count = new int[n][n];
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j)-'0';
                count[i][j] = INF;
            }
        }

        bfs();
        System.out.println(count[n-1][n-1]);
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static void bfs() {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(0,0));
        count[0][0] = 0;

        while(!que.isEmpty()) {
            Point p = que.poll();

            for(int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if(nx>=0&&ny>=0&&nx<n&&ny<n && count[nx][ny] > count[p.x][p.y]) {
                    int cnt = count[p.x][p.y];
                    if(arr[nx][ny] == 0) cnt++;
                    count[nx][ny] = cnt;
                    que.offer(new Point(nx,ny));
                }
            }
        }
    }

    static class Point {
        int x,y;
        public Point(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }
}
