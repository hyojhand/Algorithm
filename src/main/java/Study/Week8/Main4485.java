package Study.Week8;

import java.io.*;
import java.util.*;
// 녹색 옷 입은 애가 젤다지?
public class Main4485 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] arr,distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = 0;
        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            arr = new int[N][N];
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            distance = new int[N][N];
            for(int i = 0; i < N; i++) {
                Arrays.fill(distance[i], Integer.MAX_VALUE);
            }
            distance[0][0] = arr[0][0];

            bfs(N);

            tc++;
            sb.append("Problem " + tc + ": ").append(distance[N-1][N-1]).append('\n');
        }

        System.out.println(sb);
    }


    public static void bfs(int N) {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(0,0));

        while(!que.isEmpty()) {
            Point p = que.poll();
            int x = p.x;
            int y = p.y;

            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx>=0&&ny>=0&&nx<N&&ny<N && distance[nx][ny] > distance[x][y] + arr[nx][ny]) {
                    distance[nx][ny] = distance[x][y] + arr[nx][ny];
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
