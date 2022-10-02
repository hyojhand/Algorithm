package Baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽 부수고 이동하기
public class Main2206 {
    static int N,M,arr[][],check[][][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        check = new int[N+1][M+1][2];

        for(int i = 1; i <= N; i++) {
            String str = br.readLine();
            for(int j = 1; j <= M; j++) {
                arr[i][j] = str.charAt(j-1)-'0';
            }
        }

        System.out.println(bfs());
    }

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int bfs() {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(1,1,1));
        check[1][1][0] = 1;
        check[1][1][1] = 1;

        int count = 0;
        while(!que.isEmpty()) {
            count++;
            int size = que.size();
            for(int i = 0; i < size; i++) {
                Point p = que.poll();
                int x = p.x;
                int y = p.y;
                int z = p.z;

                if(x == N && y == M) {
                    return count;
                }

                for(int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if(z == 1 && nx>=1&& ny>=1&& nx<=N&&ny<=M && arr[nx][ny] == 1 && check[nx][ny][1] == 0) {
                        check[nx][ny][1] = count;
                        que.offer(new Point(nx,ny,0));
                    }

                    if(nx>=1&& ny>=1&& nx<=N&&ny<=M && arr[nx][ny] == 0 && check[nx][ny][z] == 0) {
                        check[nx][ny][z] = count;
                        que.offer(new Point(nx,ny,z));
                    }
                }
            }
        }

        return -1;
    }


    static class Point {
        int x,y,z;
        public Point(int x,int y,int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

}
