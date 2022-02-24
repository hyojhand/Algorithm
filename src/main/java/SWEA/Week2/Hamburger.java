package SWEA.Week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hamburger {
    static int[][] arr;
    static int max;
    static int limit;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int testcase = 0;
        while (testcase < T) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            limit = Integer.parseInt(st.nextToken());
            max = Integer.MIN_VALUE;
            check = new boolean[N];

            arr = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            func(N, 0, 0, 0);

            testcase++;
            sb.append("#").append(testcase).append(" ").append(max).append('\n');
        }
        System.out.println(sb);

    }

    static void func(int N, int dept, int sum, int cal_sum) {
        if (cal_sum > limit) {
            return;
        }

        if (dept == N) {
            max = Math.max(max, sum);
            return;
        }

        func(N, dept + 1, sum + arr[dept][0], cal_sum + arr[dept][1]);
        func(N, dept + 1, sum, cal_sum);

    }


}
