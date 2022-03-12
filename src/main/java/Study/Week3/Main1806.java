package Study.Week3;

import java.io.*;
import java.util.StringTokenizer;

public class Main1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (end <= N) {

            if (sum >= S) min = Math.min(min, end - start);

            if (sum < S) {
                if (end == N) break;
                sum += arr[end];
                end++;
            } else {
                sum -= arr[start];
                start++;
            }

        }

        if (min == Integer.MAX_VALUE) min = 0;

        System.out.println(min);

    }
}
