package SWEA.Week4;

import java.io.*;
import java.util.*;

public class Contact {
    static int N;
    static int[][] arr;
    static boolean[] check;
    static int max;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = 0;
        while (tc < 10) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            arr = new int[101][101];
            check = new boolean[101];
            max = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                arr[from][to] = 1;
            }

            bfs(V);
            tc++;
            sb.append("#").append(tc).append(" ").append(max).append('\n');
        }

        System.out.println(sb);

    }

    public static void bfs(int from) {
        Queue<Integer> q = new LinkedList<>();
        q.add(from);
        check[from] = true;

        while (!q.isEmpty()) {
            max = 0;
            for (int i = 0; i <= q.size(); i++) {
                int num = q.poll();
                max = Math.max(num, max);

                for (int j = 1; j <= 100; j++) {
                    if (!check[j] && arr[num][j] == 1) {
                        q.add(j);
                        check[j] = true;
                    }
                }
            }
        }


    }
}
