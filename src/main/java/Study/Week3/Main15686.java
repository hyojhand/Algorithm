package Study.Week3;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main15686 {
    static int chicken_count = 0;
    static int N, M;
    static ArrayList<Pair> list = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    static boolean[] check;
    static int[] chicken_x;
    static int[] chicken_y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) {
                    list.add(new Pair(i, j));
                    chicken_count++;
                } else {
                    map[i][j] = num;
                }
            }
        }

        check = new boolean[chicken_count];
        chicken_x = new int[chicken_count];
        chicken_y = new int[chicken_count];

        dfs(0, 0, map, chicken_x, chicken_y);
        System.out.println(result);

    }

    public static void dfs(int dept, int p, int[][] map, int[] x, int[] y) {

        if (dept == M) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1) {
                        int distance = Integer.MAX_VALUE;
                        for (int k = 0; k < M; k++) {
                            distance = Math.min(Math.abs(i - x[k]) + Math.abs(j - y[k]), distance);
                        }

                        sum += distance;
                    }
                }
            }

            result = Math.min(result, sum);
        }

        for (int i = p; i < chicken_count; i++) {
            if (!check[i]) {
                check[i] = true;
                chicken_x[dept] = list.get(i).x;
                chicken_y[dept] = list.get(i).y;
                dfs(dept + 1, i+1,map, chicken_x, chicken_y);
                check[i] = false;
            }
        }

    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}
