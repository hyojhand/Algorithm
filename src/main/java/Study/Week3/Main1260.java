package Study.Week3;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1260 {
    static int N;
    static int[][] arr;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        check = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from][to] = 1;
            arr[to][from] = 1;
        }

        dfs(V);
        System.out.println(sb);
        reset_check();
        bfs(V);
        System.out.println(sb);


    }

    public static void reset_check() {
        for (int i = 0; i <= N; i++) {
            check[i] = false;
        }
        sb = new StringBuilder();
    }

    public static void dfs(int from) {

        sb.append(from).append(" ");
        check[from] = true;
        for (int i = 1; i <= N; i++) {
            if (!check[i] && arr[from][i] != 0) {
                dfs(i);
            }
        }
    }

    public static void bfs(int from) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(from);
        check[from] = true;

        while (!queue.isEmpty()) {
            int num = queue.poll();
            sb.append(num).append(" ");

            for (int i = 1; i <= N; i++) {
                if (!check[i] && arr[num][i] == 1) {
                    queue.add(i);
                    check[i] = true;
                }
            }
        }


    }
}
