package Study.Week3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main10026 {
    static boolean[][] check;
    static char[][] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new char[N][N];
        check = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j]) {
                    check[i][j] = true;
                    bfs(i, j);
                    count++;
                }
            }
        }

        check = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'R') arr[i][j] = 'G';
            }
        }

        int count2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j]) {
                    check[i][j] = true;
                    bfs(i, j);
                    count2++;
                }
            }
        }

        System.out.print(count + " " + count2);

    }


    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void bfs(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {x, y});

        while (!que.isEmpty()) {
            int[] color = que.poll();
            x = color[0];
            y = color[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !check[nx][ny]) {
                    if (arr[x][y] == arr[nx][ny]) {
                         check[nx][ny] = true;
                        que.offer(new int[] {nx,ny});
                    }
                }
            }

        }
    }


}
