package Study.Week9;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
// 캐슬 디펜스
public class Main17135 {
    static int N, M, D, enemy;
    static boolean[] set_check;
    static int max = 0;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        set_check = new boolean[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) enemy++;
            }
        }

        dfs(0);
        System.out.println(max);
    }

    static void dfs(int dept) {
        if (dept == 3) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                if (set_check[i]) list.add(i);
            }

            int[][] copy = new int[N][M];
            for (int t = 0; t < N; t++) {
                System.arraycopy(arr[t], 0, copy[t], 0, M);
            }
            kill(list, copy);
            return;
        }

        for (int i = 0; i < M; i++) {
            if (!set_check[i]) {
                set_check[i] = true;
                dfs(dept + 1);
                set_check[i] = false;
            }
        }
    }

    static void kill(ArrayList<Integer> list, int[][] copy) {
        int num = enemy;

        int count = 0;
        while (num != 0) {
            Integer[][] temp = new Integer[3][2];
            for (int k = 0; k < 3; k++) {
                int t = list.get(k);  // 궁수 인덱스
                Loop:
                for (int d = 1; d <= D; d++) { // 거리 가까운순부터
                    for (int i = 0; i < M; i++) {
                        for (int j = N - 1; j >= 0; j--) {
                            if (copy[j][i] == 1 && Math.abs(j - N) + Math.abs(i - t) <= d) {
                                temp[k][0] = j;
                                temp[k][1] = i;
                                break Loop;
                            }
                        }
                    }
                }
            }

            for (int k = 0; k < 3; k++) {
                if (temp[k][0] != null) {
                    int x = temp[k][0];
                    int y = temp[k][1];
                    if (copy[x][y] == 1) {
                        copy[x][y] = 0;
                        count++;
                    }
                }
            }

            for (int i = N - 1; i > 0; i--) {
                for (int j = 0; j < M; j++) {
                    copy[i][j] = copy[i - 1][j];
                }
            }
            for (int j = 0; j < M; j++) copy[0][j] = 0;

            num = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copy[i][j] == 1) num++;
                }
            }
        }

        max = Math.max(max, count);
    }
}
