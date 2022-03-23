package Study.Week6;

import java.io.*;
import java.util.StringTokenizer;

public class Main1079 {
    static int N;
    static int max_night = 0;
    static boolean[] check;
    static int[][] R;
    static int mafia_num;
    static int[] rate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        rate = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            rate[i] = Integer.parseInt(st.nextToken());
        }

        R = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                R[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        mafia_num = Integer.parseInt(br.readLine());
        check = new boolean[N];
        dfs(N,0);

        System.out.println(max_night);


    }

    public static void dfs(int alive, int night) {
        if (alive == 2) {
            max_night = Math.max(max_night, night + 1);
            return;
        }

        if (alive % 2 == 0) {
            for (int i = 0; i < N; i++) {
                if (!check[i] && i != mafia_num) {

                    check[i] = true;
                    change_rate(1, i);
                    dfs(alive - 1, night + 1);
                    change_rate(2, i);
                    check[i] = false;
                }
            }
        } else {
            int next_die = find_die();

            if (next_die == mafia_num) {
                max_night = Math.max(max_night, night);
                return;
            }

            check[next_die] = true;
            dfs(alive - 1, night);
            check[next_die] = false;
        }

    }

    public static void change_rate(int func, int die_num) {
        if (func == 1) {
            for (int j = 0; j < N; j++) {
                if (!check[j]) rate[j] += R[die_num][j];
            }
        } else {
            for (int j = 0; j < N; j++) {
                if (!check[j]) rate[j] -= R[die_num][j];
            }
        }
    }

    public static int find_die() {
        int max_rate = Integer.MIN_VALUE;
        int next_die = -1;
        for (int i = 0; i < N; i++) {
            if (check[i]) continue;

            if (max_rate < rate[i]) {
                max_rate = rate[i];
                next_die = i;
            }
        }

        return next_die;
    }

}
