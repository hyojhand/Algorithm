package Study.Week8;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 아기 상어
public class Main16236 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static int N;
    static int shark_size = 2;
    static int time, eat_count = 0;
    static Point shark;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        int fish_count = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    shark = new Point(i, j);
                    arr[i][j] = 0;
                }
                else if (arr[i][j] > 0) fish_count++;
            }
        }

        int tc = 0;
        while (tc < fish_count) {

            int num = move();
            if (num < 0) break;

            time += num;
            tc++;
        }
        System.out.println(time);
    }

    public static int distance(int start_x, int start_y, int end_x, int end_y) {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(start_x, start_y));
        boolean[][] check = new boolean[N][N];

        int count = 0;
        boolean flag = false;
        while (!que.isEmpty()) {

            int size = que.size();
            for (int i = 0; i < size; i++) {
                Point p = que.poll();
                int x = p.x;
                int y = p.y;

                if (x == end_x && y == end_y) return count;

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < N && arr[nx][ny] <= shark_size && !check[nx][ny]) {
                        que.offer(new Point(nx, ny));
                        check[nx][ny] = true;
                    }
                }

            }
            count++;
        }

        if(!flag) count = -1;
        return count;
    }

    public static int move() {

        Point next_fish = new Point(0, 0);
        int dist = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] >= 1 && arr[i][j] < shark_size) {
                    int temp = distance(shark.x, shark.y, i, j);
                    if(temp < 0) continue;

                    if (dist > temp) {
                        dist = temp;
                        next_fish = new Point(i, j);
                    }
                }
            }
        }

        if (dist == Integer.MAX_VALUE) return -1;

        arr[next_fish.x][next_fish.y] = 0;

        eat_count++;
        shark = next_fish;
        if (eat_count == shark_size) {
            shark_size++;
            eat_count = 0;
        }

        return dist;

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
