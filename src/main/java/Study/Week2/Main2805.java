package Study.Week2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i],max);
        }

        int start = 0;
        int end = max;
        int cut;
        while (true) {
            cut = (start + end) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                int num = arr[i] - cut;
                if (num > 0) sum += num;
            }

            if (sum == M) break;

            if (start > end) break;


            else if (sum >= M) {
                start = cut + 1;
            } else end = cut - 1;

        }

        System.out.println(cut);

    }
}
