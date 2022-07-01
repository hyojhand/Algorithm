package Study.Week14;

import java.io.*;
import java.util.*;
// 연구소 3
public class Main17142 {
    static int min = Integer.MAX_VALUE;
    static int N,M,arr[][], no_virus;
    static Point[] virus;
    static List<Point> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        virus = new Point[M];
        no_virus = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ;j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) list.add(new Point(i,j));
                if(arr[i][j] == 0) no_virus++;
            }
        }

        if(no_virus == 0) System.out.println(0);
        else {
            dfs(0, 0);
            if (min == Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(min);
        }
    }

    static void dfs(int idx,int dept) {
        if(dept == M) {
            int num = bfs();
            if(num >= 0) min = Math.min(min, num);
            return;
        }

        if(idx >= list.size()) return;

        virus[dept] = new Point(list.get(idx).x, list.get(idx).y);
        dfs(idx+1,dept+1);
        virus[dept] = null;
        dfs(idx+1, dept);
    }

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int bfs() {
        Queue<Point> que = new LinkedList<>();

        int[][] check = new int[N][N];
        for(int i = 0; i < N; i++) {
            System.arraycopy(arr[i],0,check[i],0,N);
        }
        for(int i = 0; i < M; i++) {
            que.offer(new Point(virus[i].x,virus[i].y));
            check[virus[i].x][virus[i].y] = 3;
        }

        int change = 0;
        int count = 0;
        while(!que.isEmpty()) {

            if(change == no_virus) return count;

            int size = que.size();
            count++;
            for(int i = 0; i < size; i++) {
                Point p = que.poll();
                int x = p.x;
                int y = p.y;

                for(int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if(nx>=0&&ny>=0&&nx<N&&ny<N) {
                        if(check[nx][ny] == 0) {
                            check[nx][ny] = 3;
                            change++;
                            que.offer(new Point(nx,ny));
                        }
                        else if(check[nx][ny] == 2) {
                            check[nx][ny] = 3;
                            que.offer(new Point(nx,ny));
                        }
                    }
                }
            }
        }

        return -1;
    }

    static class Point {
        int x,y;
        public Point(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }
}

