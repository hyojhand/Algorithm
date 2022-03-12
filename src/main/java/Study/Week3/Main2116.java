package Study.Week3;

import java.io.*;
import java.util.StringTokenizer;

public class Main2116 {
    static int N;
    static int[][] dice;
    static int result = Integer.MIN_VALUE;
    static int[] rule = new int[]{6, 4, 5, 2, 3, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dice = new int[N][7];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= 6; i++) {
            find(0, dice[0][i], 0);
        }

        System.out.println(result);

    }

    public static void find(int dept, int bottom, int sum) {

        if (dept == N) {
            result = Math.max(result, sum);
            return;
        }

        int idx = 0;
        for (int i = 1; i <= 6; i++) {
            if (dice[dept][i] == bottom) {
                idx = i;
                break;
            }
        }

        int max = max_dice(idx, rule[idx - 1], dept);
        find(dept + 1, dice[dept][rule[idx - 1]], sum + max);

    }

    public static int max_dice(int x, int y, int dept) {
        int max = 0;
        for (int i = 1; i <= 6; i++) {
            if (i == x || i == y) continue;
            max = Math.max(max, dice[dept][i]);
        }
        return max;
    }

}

