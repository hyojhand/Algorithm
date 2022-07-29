package Study.Week20_24;

import java.io.*;
import java.util.*;
// 아기 상어2
public class Main17086 {
    static int[][] arr;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0) {
                    int num = bfs(i,j);
                    max = Math.max(max, num);
                }
            }
        }

        System.out.println(max);
    }

    static int max = 0;
    static int[] dx = {0,1,1,1,0,-1,-1,-1};
    static int[] dy = {1,1,0,-1,-1,-1,0,1};
    static int bfs(int a,int b) {
        boolean[][] check = new boolean[N][M];
        check[a][b] = true;
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(a,b));

        int count = 0;
        Loop:
        while(!que.isEmpty()) {
            count++;
            int size = que.size();
            for(int i = 0; i < size; i++) {
                Point p = que.poll();

                for(int k = 0; k < 8; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];
                    if(nx >=0 && ny >=0 && nx<N&& ny<M && !check[nx][ny]) {
                        if(arr[nx][ny] == 1) return count;

                        check[nx][ny] = true;
                        que.offer(new Point(nx,ny));
                    }
                }
            }
        }

        return count;
    }


    static class Point {
        int x,y;
        public Point(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }
}
