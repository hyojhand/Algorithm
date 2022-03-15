package Study.Week4;

import java.io.*;
import java.util.StringTokenizer;

public class Main14503 {
    static int[][] arr;
    static int N, M;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(x, y, dir);

        System.out.println(count);
    }


    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void clean(int x, int y, int dir) {

        if (arr[x][y] == 0) {
            arr[x][y] = 2;
            count++;
        }

        for (int i = dir; i < dir + 4; i++) {
            int nx;
            int ny;
            if (dir % 2 != 0) {
                nx = x + dx[(i + 2) % 4];
                ny = y + dy[(i + 2) % 4];
            } else {
                nx = x + dx[i % 4];
                ny = y + dy[i % 4];
            }
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 0) {
                if (nx - x == 1) dir = 2;
                else if (nx - x == -1) dir = 0;
                else if (ny - y == -1) dir = 3;
                else dir = 1;

                clean(nx, ny, dir);
                return;
            }
        }

        switch (dir) {
            case 0:
                if (x + 1 < N && arr[x+1][y] != 1) clean(x + 1, y, dir);
                break;
            case 1:
                if (y - 1 >= 0 && arr[x][y-1] != 1) clean(x, y - 1, dir);
                break;
            case 2:
                if (x - 1 >= 0 && arr[x-1][y] != 1) clean(x - 1, y, dir);
                break;
            case 3:
                if (y + 1 < M && arr[x][y+1] != 1) clean(x, y + 1, dir);
                break;
        }

    }
}
