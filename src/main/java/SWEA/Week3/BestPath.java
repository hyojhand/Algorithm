package SWEA.Week3;

import java.io.*;
import java.util.StringTokenizer;

public class BestPath {
    static boolean[] check;
    static int[][] arr;
    static int N;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int tc = 0;
        while (tc < T) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N + 2][2];
            check = new boolean[N + 2];
            min = Integer.MAX_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N + 2; i++) {
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            find(0, 0, 0);


            tc++;
            sb.append("#").append(tc).append(" ").append(min).append('\n');
        }

        System.out.println(sb);

    }

    public static void find(int dept, int sum, int n) {
        if (dept == N) {
            sum += Math.abs(arr[1][0] - arr[n][0]) + Math.abs(arr[1][1] - arr[n][1]);
            min = Math.min(sum, min);
            return;
        }


        for (int i = 2; i <= N + 1; i++) {
            if (!check[i]) {
                check[i] = true;
                int num = Math.abs(arr[n][0] - arr[i][0]) + Math.abs(arr[n][1] - arr[i][1]);
                find(dept + 1, sum + num, i);
                check[i] = false;
            }
        }


    }


}
