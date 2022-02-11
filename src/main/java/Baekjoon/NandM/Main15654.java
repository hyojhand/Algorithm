package Baekjoon.NandM;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15654 {
    static int[] arr;
    static boolean[] check;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[M];
        check = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        func(N, M, 0);

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

    }

    public static void func(int N, int M, int dept) {
        if (dept == M) {
            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                result[dept] = arr[i];
                func(N, M, dept + 1);
                check[i] = false;
            }
        }

    }
}
