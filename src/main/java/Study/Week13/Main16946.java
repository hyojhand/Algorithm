package Study.Week13;

import java.io.*;
import java.util.*;
// 벽 부수고 이동하기 4
public class Main16946 {
    static int N, M, arr[][];
    static Point group[][];
    static boolean visit[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        group = new Point[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        int group_num = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0 && group[i][j] == null) {
                    bfs(i, j,group_num);
                    group_num++;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 1) group_check(i,j);

                sb.append(arr[i][j]%10);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void group_check(int x,int y) {
        List<Integer> list = new ArrayList<>();
        for(int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx>=0&&ny>=0&&nx<N&&ny<M&& arr[nx][ny] == 0 && !list.contains(group[nx][ny].y)) {
                arr[x][y] += group[nx][ny].x;
                list.add(group[nx][ny].y);
            }
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static void bfs(int a, int b,int group_num) {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(a, b));
        visit[a][b] = true;

        Queue<Point> temp = new LinkedList<>();
        temp.add(new Point(a,b));

        int count = 1;
        while (!que.isEmpty()) {
            Point p = que.poll();
            int x = p.x;
            int y = p.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx>=0&&ny>=0&&nx<N&&ny<M&& arr[nx][ny] == 0 && !visit[nx][ny]) {
                    que.offer(new Point(nx, ny));
                    temp.offer(new Point(nx, ny));
                    visit[nx][ny] = true;
                    count++;
                }
            }
        }

        while(!temp.isEmpty()) {
            Point t = temp.poll();
            group[t.x][t.y] = new Point(count, group_num);
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

