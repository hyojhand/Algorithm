package Study.Week16;

import java.io.*;
import java.util.*;

// 빙산
public class Main2573 {
    static int ice_total,N,M, arr[][];
    static boolean[][] check;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] != 0) ice_total++;
            }
        }

        int count = 0;
        while(true) {
            if(ice_total == 0) {
                count = 0;
                break;
            }

            check = new boolean[N][M];

            int seperate_count = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(arr[i][j] != 0 && !check[i][j]) {
                        bfs(i,j);
                        seperate_count++;
                    }
                }
            }
            if(seperate_count >= 2) break;

            count++;
            melting();
        }

        System.out.println(count);
    }

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static void melting() {

        int[][] copy_arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] != 0) {

                    int sea_cnt = 0;
                    for(int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx>=0&&ny>=0&&nx<N&&ny<M && arr[nx][ny] == 0) {
                            sea_cnt++;
                        }
                    }

                    copy_arr[i][j] = arr[i][j] - sea_cnt;
                    if(copy_arr[i][j] <= 0) {
                        copy_arr[i][j] = 0;
                        ice_total--;
                    }

                }
            }
        }

        for(int k = 0; k < N; k++) {
            System.arraycopy(copy_arr[k], 0,arr[k], 0,M);
        }
    }

    static void bfs(int x,int y) {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(x,y));
        check[x][y] = true;

        while(!que.isEmpty()) {
            Point p = que.poll();
            int tx = p.x;
            int ty = p.y;

            for(int k = 0; k < 4; k++) {
                int nx = tx + dx[k];
                int ny = ty + dy[k];
                if(nx>=0&&ny>=0&&nx<N&&ny<M && arr[nx][ny] != 0 && !check[nx][ny]) {
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

