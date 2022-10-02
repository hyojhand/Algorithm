package Baekjoon.BFS;

import java.io.*;
import java.util.*;
// 안전영역 S1
public class Main2468 {
    static int N;
    static int[][] arr;
    static int count = 1;
    static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        int max = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
            }
        }

        for(int r = 1; r < max; r++) {
            check = new boolean[N][N];
            int cnt = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(arr[i][j] > r && !check[i][j]) {
                        bfs(i,j,r);
                        cnt++;
                    }
                }
            }

            count = Math.max(count, cnt);
        }

        System.out.println(count);
    }

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static void bfs(int x,int y,int rain) {
        check[x][y] = true;
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(x,y));

        while(!que.isEmpty()) {
            Point p = que.poll();
            for(int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if(nx>=0&ny>=0&&nx<N&&ny<N && !check[nx][ny] && arr[nx][ny] > rain) {
                    check[nx][ny] = true;
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
