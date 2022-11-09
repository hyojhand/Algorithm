package Baekjoon.Samsung;

import java.io.*;
import java.util.*;
// G4 마법사 상어와 파이어볼
public class Main20056 {
    static int N,M,K;
    static Queue<Point> fireball;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static Queue<Point>[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        fireball = new LinkedList<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireball.offer(new Point(x,y,m,s,d));
        }

        map = new Queue[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = new LinkedList<>();
            }
        }

        for(int i = 0; i < K; i++) {
            move();
            divide();
        }

        int sum = 0;
        while(!fireball.isEmpty()) {
            Point p = fireball.poll();
            sum += p.m;
        }

        System.out.println(sum);
    }

    static void move() {

        while(!fireball.isEmpty()) {
            Point p = fireball.poll();
            int nx = (N + p.x + dx[p.d] * (p.s % N)) % N;
            int ny = (N + p.y + dy[p.d] * (p.s % N)) % N;
            map[nx][ny].add(new Point(nx,ny,p.m,p.s,p.d));
        }
    }

    static void divide() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j].size() >= 2) {
                    boolean odd = true;
                    boolean even = true;

                    int sum_m = 0;
                    int sum_s = 0;
                    int cnt = map[i][j].size();
                    while(!map[i][j].isEmpty()) {
                        Point p = map[i][j].poll();

                        if(p.d % 2 == 0) odd = false;
                        else even = false;

                        sum_m += p.m;
                        sum_s += p.s;
                    }

                    if (sum_m / 5 == 0) continue;

                    int start = 1;
                    if(odd | even) start = 0;

                    for(int k = start; k < 8; k += 2) {
                        fireball.offer(new Point(i,j,sum_m/5,sum_s/cnt,k));
                    }

                } else if(map[i][j].size() == 1) {
                    Point p = map[i][j].poll();
                    if (p.m == 0) continue;
                    fireball.offer(new Point(i,j,p.m,p.s,p.d));
                }
            }
        }
    }

    static class Point {
        int x,y,m,s,d;
        public Point(int x,int y,int m,int s,int d) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}
