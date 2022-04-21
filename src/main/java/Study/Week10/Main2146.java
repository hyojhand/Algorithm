package Study.Week10;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 다리 만들기
public class Main2146 {
    static int N;
    static int[][] arr;
    static boolean[][] check;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        check = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int num = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!check[i][j] && arr[i][j] > 0) {
                    num++;
                    area(i,j,num);
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] > 0) bridge(i,j,arr[i][j]);
            }
        }

        System.out.println(min);
    }

    static void bridge(int a,int b,int num) {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(a,b));
        boolean[][] visit = new boolean[N][N];
        visit[a][b] = true;

        int count = -1;
        boolean find = false;
        while(!que.isEmpty()) {
            int size = que.size();
            count++;

            for(int i = 0; i < size; i++) {
                Point p = que.poll();
                int x = p.x;
                int y = p.y;

                for(int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if(nx>=0&&ny>=0&&nx<N&&ny<N&&!visit[nx][ny]) {
                        if(arr[nx][ny] == 0) {
                            visit[nx][ny] = true;
                            que.offer(new Point(nx, ny));
                        } else if(arr[nx][ny] > num) find = true;
                    }
                }

                if(find) {
                    min = Math.min(min, count);
                    return;
                }
            }
        }
    }

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static void area(int a,int b,int num) {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(a,b));
        check[a][b] = true;
        arr[a][b] = num;

        while(!que.isEmpty()) {
            Point p = que.poll();
            int x = p.x;
            int y = p.y;

            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx>=0&&ny>=0&&nx<N&&ny<N&&!check[nx][ny]&&arr[nx][ny]>0) {
                    check[nx][ny] = true;
                    arr[nx][ny] = num;
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
