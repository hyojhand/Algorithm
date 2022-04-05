package Study.Week8;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1600 {
    static int[][] arr;
    static int K, W, H;
    static int[] hx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] hy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count = -1;
    static boolean[][][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][W];
        check = new boolean[H][W][K+1];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        System.out.println(count);
    }

    public static void bfs() {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(0, 0,0));
        check[0][0][0] = true;
        int level = 0;
        boolean flag = false;
        while (!que.isEmpty()) {

            level++;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Point p = que.poll();
                int x = p.x;
                int y = p.y;
                int z = p.z;

                if(z < K) {
                    for (int k = 0; k < 8; k++) {
                        int nx = x + hx[k];
                        int ny = y + hy[k];
                        if (nx >= 0 && ny >= 0 && nx < H && ny < W && arr[nx][ny] != 1 && !check[nx][ny][z+1]) {
                            check[nx][ny][z+1] = true;
                            if(nx == H-1 && ny == W-1) flag = true;
                            que.offer(new Point(nx,ny,z+1));
                        }
                    }
                }

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx>=0&&ny>=0&&nx<H&&ny<W &&  arr[nx][ny] != 1 && !check[nx][ny][z]) {
                        check[nx][ny][z] = true;
                        if(nx == H-1 && ny == W-1) flag = true;
                        que.offer(new Point(nx, ny,z));
                    }
                }

            }

            if (flag) {
                count = level;
                break;
            }
            if(H == 1 && W == 1) count = 0;

        }
    }

    static class Point {
        int x;
        int y;
        int z;
        public Point(int x, int y,int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

}
