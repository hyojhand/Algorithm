package Study.Week10;

import java.io.*;
import java.util.*;
// 낚시왕
public class Main17143 {
    static int R,C,M;
    static Point[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new Point[R+1][C+1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken())-1;
            int z = Integer.parseInt(st.nextToken());
            arr[r][c] = new Point(r,c,s,d,z);
        }

        int result = 0;

        int people = 1;
        while(people <= C) {

            int idx = 1;
            // 상어 잡기
            while(idx <= R) {
                if(arr[idx][people] != null) {
                    result += arr[idx][people].z;
                    arr[idx][people] = null;
                    break;
                }
                idx++;
            }

            // 상어 무빙
            move();

            // 사람 무빙
            people++;
        }
        System.out.println(result);
    }

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    static void move() {
        Stack<Point> stack = new Stack<>();
        for(int i = 1; i <= R; i++) {
            for(int j = 1; j <= C; j++) {
                if(arr[i][j] != null) {
                    stack.push(arr[i][j]);
                }
            }
        }

        arr = new Point[R+1][C+1];
        while(!stack.isEmpty()) {
            Point p = stack.pop();
            int x = p.r;
            int y = p.c;
            int speed = p.s;
            int dir = p.d;
            int size = p.z;

            if(dir == 0 || dir == 1) speed %= (R-1) * 2;
            else speed %= (C-1)*2;

            for(int i = 0; i < speed; i++) {

                if(dir == 0 && x == 1) {
                    dir = 1;
                } else if(dir == 1 && x == R) {
                    dir = 0;
                } else if(dir == 2 && y == C) {
                    dir = 3;
                } else if(dir == 3 && y == 1) {
                    dir = 2;
                }

                x += dx[dir];
                y += dy[dir];
            }

            if(arr[x][y] != null) {
                if(arr[x][y].z < size) {
                    arr[x][y].s = p.s;
                    arr[x][y].d = dir;
                    arr[x][y].z = size;
                }
            } else {
                arr[x][y] = new Point(x,y,p.s,dir,size);
            }
        }
    }

    static class Point {
        int r,c,s,d,z;
        public Point(int r,int c,int s,int d,int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

}
