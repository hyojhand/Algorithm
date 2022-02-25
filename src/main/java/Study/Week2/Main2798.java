package Study.Week2;

import java.io.*;
import java.util.StringTokenizer;

public class Main2798 {
    static int N, M;
    static boolean[] check;
    static int[] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new boolean[N];

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        find(0, 0);
        System.out.println(M - min);
    }

    public static void find(int dept, int sum) {
        if (sum > M) return;

        if (dept == 3) {
            min = Math.min(Math.abs(M - sum), min);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                find(dept + 1, sum + arr[i]);
                check[i] = false;
            }
        }

    }
}
