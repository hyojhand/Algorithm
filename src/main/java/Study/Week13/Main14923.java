package Study.Week13;

import java.io.*;
import java.util.*;
// 미로 탈출
public class Main14923 {
    static int N,M,arr[][];
    static Point end;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int start_x = Integer.parseInt(st.nextToken());
        int start_y = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        end = new Point(a,b,0);

        arr = new int[N+1][M+1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(start_x,start_y));
    }

    static int bfs(int a,int b) {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(a,b,1));
        boolean[][][] visit = new boolean[N+1][M+1][2];
        visit[a][b][1] = true;
        visit[a][b][0] = true;

        int count = 0;
        while(!que.isEmpty()) {
            count++;
            int size = que.size();
            for(int i = 0; i < size; i++) {
                Point p = que.poll();
                int x = p.x;
                int y = p.y;
                int magic = p.magic;

                if(x == end.x && y== end.y) return count-1;

                for(int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if(nx>=1&&ny>=1&&nx<=N&&ny<=M&& !visit[nx][ny][magic]) {
                        if(arr[nx][ny] == 0) {
                            que.offer(new Point(nx,ny,magic));
                            visit[nx][ny][magic] = true;
                        } else {
                            if(magic == 1) {
                                que.offer(new Point(nx,ny,0));
                                visit[nx][ny][1] = true;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    static class Point {
        int x,y,magic;
        public Point(int x,int y,int magic) {
            this.x = x;
            this.y = y;
            this.magic = magic;
        }
    }
}

