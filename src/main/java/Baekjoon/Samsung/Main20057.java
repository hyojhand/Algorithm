package Baekjoon.Samsung;

import java.io.*;
import java.util.*;
// G3 마법사 상어와 토네이도
public class Main20057 {
    static int N;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int start_x = N / 2;
        int start_y = N / 2;

        move(start_x, start_y);
        System.out.println(out);

    }

    static void move(int x, int y) {
        int cnt = 0;
        while (true) {
            int count = (cnt / 2) + 1;

            for (int i = 0; i < count; i++) {
                if (x == 0 && y == 0) return;
                x += dx[cnt % 4];
                y += dy[cnt % 4];
                if(arr[x][y] != 0) seperate(x, y, cnt % 4, arr[x][y]);
            }
            cnt++;
        }
    }

    static int out = 0;
    static int[][] move_x = {{-1,1,-2,-1,1,2,-1,1,0}, {-1,-1,0,0,0,0,1,1,2},
            {1,-1,2,1,-1,-2,1,-1,0},{1,1,0,0,0,0,-1,-1,-2}};
    static int[][] move_y = {{1,1,0,0,0,0,-1,-1,-2}, {-1,1,-2,-1,1,2,-1,1,0},
            {-1,-1,0,0,0,0,1,1,2}, {1,-1,2,1,-1,-2,1,-1,0}};
    static int[] per = {1,1,2,7,7,2,10,10,5};
    static void seperate(int x, int y, int dir, int sand) {
        int out_sum = 0;
        for(int k = 0; k < 9; k++) {
            int nx = x + move_x[dir][k];
            int ny = y + move_y[dir][k];
            int ns = sand * per[k] / 100;

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) arr[nx][ny] += ns;
            else out_sum += ns;
            arr[x][y] -= ns;
        }

        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if(nx >= 0 && ny >= 0 && nx < N && ny < N) arr[nx][ny] += arr[x][y];
        else out_sum += arr[x][y];

        arr[x][y] = 0;
        out += out_sum;
    }
}