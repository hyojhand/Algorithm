package Study.Week9;

import java.io.*;
import java.util.*;
// 연구소
public class Main14502 {
    static int N,M;
    static int max = Integer.MIN_VALUE;
    static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        check = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,arr);
        System.out.println(max);
    }

    public static void dfs(int dept,int[][] arr) {
        if(dept == 3) {
            int num = bfs(arr);
            max = Math.max(max,num);
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0 && !check[i][j]) {
                    check[i][j] = true;

                    int[][] copy = new int[N][M];
                    for(int t = 0; t < N; t++) {
                        System.arraycopy(arr[t], 0, copy[t], 0, M);
                    }
                    arr[i][j] = 1;

                    dfs(dept+1,arr);

                    arr[i][j] = 0;
                    for(int t = 0; t < N; t++) {
                        System.arraycopy(copy[t], 0, arr[t], 0, M);
                    }
                    check[i][j] = false;
                }
            }
        }
    }

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static int bfs(int[][] arr) {
        Queue<Point> que = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 2) {
                    que.offer(new Point(i,j));
                    visit[i][j] = true;
                }
            }
        }

        while(!que.isEmpty()) {
            Point p = que.poll();
            int x = p.x;
            int y = p.y;

            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx>=0&&ny>=0&&nx<N&&ny<M&&arr[nx][ny]==0&&!visit[nx][ny]) {
                    visit[nx][ny] = true;
                    arr[nx][ny] = 2;
                    que.offer(new Point(nx,ny));
                }
            }
        }

        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0) count++;
            }
        }
        return count;
    }

    static class Point {
        int x;
        int y;
        public Point(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }
}

