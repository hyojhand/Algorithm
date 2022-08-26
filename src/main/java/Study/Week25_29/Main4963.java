package Study.Week25_29;

import java.io.*;
import java.util.*;
// 섬의 개수
public class Main4963 {
    static int[][] arr;
    static int w,h;
    static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            arr = new int[h][w];
            for(int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            check = new boolean[h][w];
            int sum = 0;
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(arr[i][j] == 1 && !check[i][j]) {
                        find(i,j);
                        sum++;
                    }
                }
            }

            sb.append(sum).append('\n');
        }

        System.out.println(sb);
    }

    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static void find(int a,int b) {
        check[a][b] = true;
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(a,b));

        while(!que.isEmpty()) {
            Point p = que.poll();

            for(int k = 0; k < 8; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if(nx>=0&&ny>=0&&nx<h&&ny<w&& !check[nx][ny]) {
                    if(arr[nx][ny] == 1) que.offer(new Point(nx,ny));
                    check[nx][ny] = true;
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
