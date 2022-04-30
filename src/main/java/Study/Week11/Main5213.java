package Study.Week11;

import java.io.*;
import java.util.*;
// 과외맨
public class Main5213 {
    static Point[][] arr,path_point;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new Point[N][N];
        path_point = new Point[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i % 2 != 0 && j == N - 1) continue;

                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[i][j] = new Point(a, b);
            }
        }

        Point t = bfs();

        int a = t.a;
        int b = t.b;
        int num = (a * N) - (a / 2) + b +1; // 타일의 넘버

        // 경로 탐색
        Stack<Integer> stack = new Stack<>();
        while(num != 1) {
            stack.push(num);
            Point p = path_point[a][b];
            a = p.a;
            b = p.b;
            num = (a * N) - (a / 2) + b +1;
        }

        // 경로 출력
        StringBuilder sb = new StringBuilder();
        sb.append(stack.size()+1).append('\n');
        sb.append(1).append(" ");
        int size = stack.size();
        for(int i = 0; i < size; i++) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }

    static int[][] odd = {{-1, -1}, {1, -1}, {0, -1}, {-1, 0}, {1, 0}, {0, 1}};
    static int[][] even = {{-1, 0}, {1, 0}, {0, -1}, {-1, 1}, {1, 1}, {0, 1}};

    static Point bfs() {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(0, 0));

        int tx = 0;
        int ty = 0;
        int max = 0;
        while (!que.isEmpty()) {
            Point p = que.poll();
            int a = p.a;
            int b = p.b;
            int num = (a * N) - (a / 2) + b +1; // 타일의 넘버

            if(num > max) {
                max = num;
                tx = a;
                ty = b;
            }

            int nx;
            int ny;
            for (int k = 0; k < 6; k++) {
                if (a % 2 == 0) { // 홀수행
                    nx = a + odd[k][0];
                    ny = b + odd[k][1];
                } else { // 짝수행
                    nx = a + even[k][0];
                    ny = b + even[k][1];
                }

                if (nx>=0 && ny>=0 && nx<N && ny<N && arr[nx][ny] != null && path_point[nx][ny] == null) {
                    if (k < 3) {
                        if (arr[nx][ny].b == arr[a][b].a) {
                            path_point[nx][ny] = new Point(a,b);
                            que.offer(new Point(nx, ny));
                        }
                    } else {
                        if (arr[nx][ny].a == arr[a][b].b) {
                            path_point[nx][ny] = new Point(a,b);
                            que.offer(new Point(nx, ny));
                        }
                    }
                }
            }
        }

        return new Point(tx,ty);
    }

    static class Point {
        int a, b;
        public Point(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
