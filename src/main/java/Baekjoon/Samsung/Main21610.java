package Baekjoon.Samsung;

import java.io.*;
import java.util.*;
// G5 마법사 상어와 비바라기
public class Main21610 {
    static int N,M;
    static int[][] arr;
    static int[] d,s;
    static Queue<Point> cloud;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        d = new int[M];
        s = new int[M];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            d[i] = Integer.parseInt(st.nextToken())-1;
            s[i] = Integer.parseInt(st.nextToken());
        }

        cloud = new LinkedList<>();
        cloud.offer(new Point(N-1,0));
        cloud.offer(new Point(N-1,1));
        cloud.offer(new Point(N-2,0));
        cloud.offer(new Point(N-2, 1));


        for(int i = 0; i < M; i++) {
            move(i);
        }

        int sum = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sum += arr[i][j];
            }
        }

        System.out.println(sum);
    }


    static int[] dx = {0,-1,-1,-1,0,1,1,1};
    static int[] dy = {-1,-1,0,1,1,1,0,-1};

    static int[] water_x = {-1,-1,1,1};
    static int[] water_y = {-1,1,1,-1};
    static void move(int dept) {
        int dir = d[dept];
        int len = s[dept];

        boolean[][] check = new boolean[N][N];

        Queue<Point> move_cloud = new LinkedList<>();
        while(!cloud.isEmpty()) {
            Point p = cloud.poll();

            int x = (N + p.x + dx[dir] * (len % N)) % N;
            int y = (N + p.y + dy[dir] * (len % N)) % N;
//            int x = p.x + dx[dir]*len;
//            int y = p.y + dy[dir]*len;

//            while(x < 0 || x >= N) x = x < 0 ? x + N : x - N;
//            while(y < 0 || y >= N) y = y < 0 ? y + N : y - N;

            check[x][y] = true;
            arr[x][y]++;
            move_cloud.add(new Point(x, y));
        }

        while(!move_cloud.isEmpty()) {
            Point p = move_cloud.poll();

            int num = 0;
            for (int k = 0; k < 4; k++) {
                int nx = p.x + water_x[k];
                int ny = p.y + water_y[k];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && arr[nx][ny] > 0) num++;
            }

            arr[p.x][p.y] += num;
        }

        cloud = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!check[i][j] && arr[i][j] >= 2) {
                    arr[i][j] -= 2;
                    cloud.add(new Point(i,j));
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