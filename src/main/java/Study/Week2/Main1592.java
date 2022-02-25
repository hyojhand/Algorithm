package Study.Week2;

import java.io.*;
import java.util.StringTokenizer;

public class Main1592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int idx = 0;
        int count = 0;
        while (true) {
            arr[idx]++;
            if (arr[idx] == M) break;

            count++;
            if (arr[idx] % 2 != 0) {
                idx += L;
                if (idx >= N) idx = idx % N;
            } else {
                idx -= L;
                if (idx < 0) idx += N;
            }

        }

        System.out.println(count);

    }
}
