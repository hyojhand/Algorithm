package SWEA.IM;

import java.io.*;
import java.util.StringTokenizer;

public class Solution1859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        while (tc < T) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i]);
            }

            int count = 0;
            long sum = 0;
            for (int i = 0; i < N; i++) {

                if (arr[i] == max) {
                    sum += ((long) arr[i] * count);
                    count = 0;
                    max = Integer.MIN_VALUE;
                    for (int k = i + 1; k < N; k++) {
                        max = Math.max(max, arr[k]);
                    }
                } else {
                    sum -= arr[i];
                    count++;
                }
            }

            tc++;
            sb.append("#").append(tc).append(" ").append(sum).append('\n');
        }

        System.out.println(sb);

    }
}

