package Baekjoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15650 {
    static int[] arr;
    static boolean[] visit;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];
        dfs(0, 0);
        System.out.print(sb);
    }
    // sol 2.ver 시작위치를 at으로 변경하면서 재귀함수 사용
    public static void dfs(int at, int dept) {
        if (dept == M) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = at; i < N; i++) {
            arr[dept] = i+1;                // arr[dept] = i;로 하면 dfs호출시 1로 넣어준다.
            dfs(i + 1 , dept + 1);
        }
    }

    /*  sol 1.ver  이전값보다 작으면 return
    public static void dfs(int dept) {
        if (dept > 1 && arr[dept - 2] > arr[dept-1]) {
            return;
        }

        if (dept == M) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[dept] = i+1;
                dfs(dept + 1);
                visit[i] = false;
            }
        }
    }
    sol 1.ver */

}
