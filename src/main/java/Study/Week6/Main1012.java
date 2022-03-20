package Study.Week6;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1012 {
    static int[][] arr;
    static boolean[][] visit;
    static Queue<Point> que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            arr = new int[N][M];
            visit = new boolean[N][M];
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int b = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                arr[a][b] = 1;
            }

            int count = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(arr[i][j] == 1 && !visit[i][j]) {
                        visit[i][j] = true;
                        que.offer(new Point(i,j));
                        bfs(N,M);
                        count++;
                    }
                }
            }

            sb.append(count).append('\n');

            T--;
        }
        System.out.println(sb);

    }

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void bfs(int N, int M) {

        while(!que.isEmpty()) {
            Point p = que.poll();
            int x = p.x;
            int y = p.y;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny]==1 && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    que.offer(new Point(nx,ny));
                }
            }



        }

    }

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

