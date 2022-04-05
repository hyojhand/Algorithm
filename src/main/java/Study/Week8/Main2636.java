package Study.Week8;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2636 {
    static int N, M;
    static int[][] arr;
    static int min_count = Integer.MAX_VALUE;
    static int total_cheese = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) total_cheese++;
            }
        }

        arr[0][0] = 2;

        int time = 0;
        while(total_cheese != 0) {
            air();
            find();
            time++;
        }

        System.out.println(time);
        System.out.println(min_count);

    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    // 외부공기 2로 변환
    public static void air() {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(0,0));

        boolean[][] air_check = new boolean[N][M];
        while(!que.isEmpty()) {
            Point p = que.poll();
            int x = p.x;
            int y = p.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !air_check[nx][ny] &&arr[nx][ny] != 1) {
                    arr[nx][ny] = 2;
                    air_check[nx][ny] = true;
                    que.offer(new Point(nx,ny));
                }
            }

        }
    }


    public static void find() {
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 1) {
                    for(int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 2) {
                            arr[i][j] = 0;
                            count++;
                            total_cheese--;
                            break;
                        }
                    }
                }

            }
        }
        min_count = Math.min(count,min_count);
    }


    static class Point {
        int x;
        int y;
        public Point(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }


}
