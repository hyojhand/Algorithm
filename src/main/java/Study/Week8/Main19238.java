package Study.Week8;

import java.io.*;
import java.util.*;
// 스타트 택시
public class Main19238 {
    static int[][] arr;
    static Point start;
    static Point[] from;
    static Point[] to;
    static boolean[] visit;
    static int N,M,oil;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        oil = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        start = new Point(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);

        from = new Point[M];
        to = new Point[M];
        visit = new boolean[M];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from[i] = new Point(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
            to[i] = new Point(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
        }

        int count = 0;
        while(count < M) {
            // 손님 태우기
            int guest_num = guest_find(start.x, start.y);
            if(oil < 0 || guest_num == -1) {
                oil = -1;
                break;
            }
            start = new Point(from[guest_num].x, from[guest_num].y);
            //목적지 도착
            int use_oil = guest_end(start.x,start.y,guest_num);
            if(use_oil < 0 || oil - use_oil < 0) {
                oil = -1;
                break;
            }
            oil -= use_oil;
            start = new Point(to[guest_num].x, to[guest_num].y);
            // + 연료 * 2
            oil += (use_oil*2);
            count++;
        }

        // 남은 오일 출력
        System.out.println(oil);

    }

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static int distance(int start_x,int start_y,int end_x,int end_y) {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(start_x,start_y));
        boolean[][] check = new boolean[N][N];
        check[start_x][start_y] = true;

        int count = 0;
        boolean flag = false;

        Loop:
        while(!que.isEmpty()) {

            int size = que.size();
            for (int i = 0; i < size; i++) {
                Point p = que.poll();
                int x = p.x;
                int y = p.y;
                if (x == end_x && y == end_y) {
                    flag = true;
                    break Loop;
                }
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < N && arr[nx][ny] != 1 && !check[nx][ny]) {
                        que.offer(new Point(nx, ny));
                        check[nx][ny] = true;
                    }
                }
            }
            count++;
        }

        if(flag) return count;
        else return -1;
    }

    public static int guest_end(int taxi_x, int taxi_y,int idx) {
        int dist = distance(taxi_x,taxi_y, to[idx].x,to[idx].y);
        if(dist == -1) return -1;
        return dist;
    }

    public static int guest_find(int taxi_x, int taxi_y) {
        int dist = Integer.MAX_VALUE;
        int idx = 0;
        for(int i = 0; i < M; i++) {
            if(!visit[i]) {
                int temp = distance(taxi_x,taxi_y, from[i].x, from[i].y);
                if(temp < 0) continue;
                if(dist > temp) {
                    dist = temp;
                    idx = i;
                } else if (dist == temp) {
                    if(from[i].x < from[idx].x) {
                        dist = temp;
                        idx = i;
                    } else if (from[i].x == from[idx].x) {
                        if(from[i].y < from[idx].y) {
                            dist = temp;
                            idx = i;
                        }
                    }
                }
            }
        }

        if(dist == Integer.MAX_VALUE) return -1;
        else {
            visit[idx] = true;
            oil -= dist;
            return idx;
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
