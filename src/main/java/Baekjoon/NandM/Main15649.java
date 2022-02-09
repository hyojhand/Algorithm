package Baekjoon.NandM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15649 {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visit = new boolean[N];

        dfs(N, M, 0);
        System.out.println(sb);

    }

    public static void dfs(int N, int M, int dept) {
        if (dept == M) {
            for (int n : arr) {
                sb.append(n).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[dept] = i + 1;
                dfs(N, M, dept + 1);
                visit[i] = false;
            }
        }

    }
}
