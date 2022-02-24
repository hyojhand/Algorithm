package SWEA.Week2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SpotMart {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tcase = Integer.parseInt(br.readLine());
        int count = 0;
        while (count < tcase) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int max = -1;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    int num = arr[i] + arr[j];
                    if (num > M) continue;
                    max = Math.max(max, num);
                    if (max == M) break;
                }
            }

            count++;
            sb.append("#").append(count).append(" ");
            sb.append(max).append('\n');
        }
        System.out.println(sb);
    }
}
