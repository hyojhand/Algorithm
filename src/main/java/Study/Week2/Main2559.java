package Study.Week2;

import java.io.*;
import java.util.StringTokenizer;

public class Main2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] degree = new int[N - K + 1];
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= N - K; i++) {
            for (int j = i; j < i + K; j++) {
                degree[i] += arr[j];
            }
            max = Math.max(max, degree[i]);
        }

        System.out.println(max);

    }
}
