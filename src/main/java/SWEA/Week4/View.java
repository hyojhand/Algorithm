package SWEA.Week4;

import java.io.*;
import java.util.StringTokenizer;

public class View {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 0;

        while (tc < 10) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int sum = 0;
            for (int i = 2; i < N - 2; i++) {
                int min = Integer.MAX_VALUE;

                min = Math.min(Math.min(arr[i] - arr[i - 1], arr[i] - arr[i - 2]), Math.min(arr[i] - arr[i + 1], arr[i] - arr[i + 2]));

                if (min >= 0) sum += min;
            }

            tc++;
            sb.append("#").append(tc).append(" ").append(sum).append('\n');
        }
        System.out.println(sb);

    }
}
