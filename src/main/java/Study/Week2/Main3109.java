package Study.Week2;

import java.io.*;
import java.util.StringTokenizer;

public class Main3109 {
    static int C;
    static int R;
    static char[][] map;
    static int count = 0;
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }


        for (int i = 0; i < R; i++) {
            check = false;
            find(i, 0);
        }

        System.out.println(count);

    }

    static int[] dx = {-1, 0, 1};

    public static void find(int x, int y) {

        if (y == C - 1) {
            check = true;
            count++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + 1;
            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                if (map[nx][ny] == '.') {
                    map[nx][ny] = 'x';
                    find(nx, ny);
                    if (check) return;
                }
            }
        }


    }
}
