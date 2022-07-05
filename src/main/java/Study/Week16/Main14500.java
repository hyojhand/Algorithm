package Study.Week16;

import java.io.*;
import java.util.*;

// 테트로미노
public class Main14500 {
    static int arr[][],N,M;
    static boolean[][] check;
    static List<Point> list = new ArrayList<>();
    static int max = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        check = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                check[i][j] = true;
                list.add(new Point(i,j));
                dfs(i,j,arr[i][j], 1);
                list.remove(0);
            }
        }
        System.out.println(max);
    }

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static void dfs(int x,int y,int sum,int dept) {
        if(dept == 4) {
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < list.size(); i++) {
            int tx = list.get(i).x;
            int ty = list.get(i).y;

            for (int k = 0; k < 4; k++) {
                int nx = tx + dx[k];
                int ny = ty + dy[k];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !check[nx][ny]) {
                    check[nx][ny] = true;
                    list.add(new Point(nx,ny));
                    dfs(nx, ny, sum + arr[nx][ny], dept + 1);
                    list.remove(dept);
                    check[nx][ny] = false;
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

