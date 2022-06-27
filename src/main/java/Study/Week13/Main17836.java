package Study.Week13;

import java.io.*;
import java.util.*;
// 공주님을 구해라!
public class Main17836 {
    static int N,M,T,arr[][];
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs();
        if(result == -1 || result > T) System.out.println("Fail");
        else System.out.println(result);
    }

    static int bfs() {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(0,0,0));
        boolean[][][] visit = new boolean[N][M][2];
        visit[0][0][0] = true;

        int count = 0;
        while(!que.isEmpty()) {
            count++;
            int size = que.size();
            for(int i = 0; i < size; i++) {
                Point p = que.poll();
                int x = p.x;
                int y = p.y;
                int sword = p.sword;

                if(x == N-1 && y==M-1) return count-1;

                for(int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if(nx>=0&&ny>=0&&nx<N&&ny<M&& !visit[nx][ny][sword]) {
                        if(sword == 1) que.offer(new Point(nx,ny,1));
                        else {
                            if(arr[nx][ny] == 0) que.offer(new Point(nx,ny,0));
                            else if(arr[nx][ny] == 2) que.offer(new Point(nx,ny,1));
                        }
                        visit[nx][ny][sword] = true;
                    }
                }
            }
        }
        return -1;
    }

    static class Point {
        int x,y,sword;
        public Point(int x,int y,int sword) {
            this.x = x;
            this.y = y;
            this.sword = sword;
        }
    }
}

