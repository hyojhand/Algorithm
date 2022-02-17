package Study.Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10974 {
    static int N;
    static int[] arr;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        check = new boolean[N];

        func(N, 0);

        System.out.println(sb);

    }

    public static void func(int x, int dept) {
        if (dept == N) {
            for (int i = 0; i < N; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                arr[dept] = i + 1;
                func(x - 1, dept + 1);
                check[i] = false;
            }
        }
    }

}
