package Baekjoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14888 {
    static int N;
    static int[] A;
    static int[] operation;
    static int Max = Integer.MIN_VALUE;
    static int Min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        operation = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operation[i] = Integer.parseInt(st.nextToken());
        }

        dfs(A[0], 1);

        System.out.println(Max);
        System.out.println(Min);

    }

    public static void dfs(int num, int dept) {
        if (dept == N) {
            Max = Math.max(num, Max);
            Min = Math.min(num, Min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operation[i] > 0) {
                operation[i]--;

                switch (i) {
                    case 0:
                        dfs(num + A[dept], dept + 1);
                        break;
                    case 1:
                        dfs(num - A[dept], dept + 1);
                        break;
                    case 2:
                        dfs(num * A[dept], dept + 1);
                        break;
                    case 3:
                        dfs(num / A[dept], dept + 1);
                        break;
                }
                operation[i]++;
            }
        }
    }
}
