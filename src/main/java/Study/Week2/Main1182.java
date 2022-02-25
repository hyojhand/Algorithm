package Study.Week2;

import java.io.*;
import java.util.StringTokenizer;

public class Main1182 {
    static int[] arr;
    static int N, S;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        find(0, 0);

        if (S == 0) count--;

        System.out.println(count);
    }

    public static void find(int dept, int sum) {
        if (dept == N) {
            if (sum == S) count++;
            return;
        }

        find(dept + 1, sum + arr[dept]);
        find(dept + 1, sum);

    }
}
