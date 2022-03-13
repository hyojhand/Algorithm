package Study.Week4;

import java.io.*;
import java.util.StringTokenizer;

public class Main1654 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        long max = Integer.MIN_VALUE;
        long min = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
        }

        max++;

        while (min < max) {
            long result = (max + min) / 2;
            long count = 0;
            for (int i = 0; i < K; i++) {
                count += arr[i] / result;
            }

            if (count >= N) {
                min = result + 1;
            } else {
                max = result;
            }
        }

        System.out.println(min - 1);

    }
}
