package Study.Week20_24;

import java.io.*;
import java.util.*;
// 구간 합 최대? 1
public class Main15560 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = U * num + V;
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (C == 0) {
                int max = Integer.MIN_VALUE;
                int sum = 0;
                for (int k = A; k <= B; k++) {
                    sum = Math.max(sum, 0) + arr[k];
                    max = Math.max(max, sum);
                }

                sb.append(max - V).append('\n');
            } else {
                arr[A] = U * B + V;
            }
        }

        System.out.println(sb);
    }
}

