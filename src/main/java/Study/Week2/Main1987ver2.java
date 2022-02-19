package Study.Week2;

import java.io.*;
import java.util.StringTokenizer;

public class Main1987ver2 {
    static int R;
    static int C;
    static boolean[] check = new boolean[26];
    static int[][] arr;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j) - 65;
            }
        }

        check[arr[0][0]] = true;
        find(1, 0, 0, check);
        System.out.println(max);

    }


    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void find(int count, int x, int y, boolean[] check) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < R && ny < C && !check[arr[nx][ny]]) {
                check[arr[nx][ny]] = true;
                find(count + 1, nx, ny, check);
                check[arr[nx][ny]] = false;
            }
        }

        max = Math.max(max, count);

    }
}
