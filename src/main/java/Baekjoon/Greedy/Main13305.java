package Baekjoon.Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Main13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] distance = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] oil = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            oil[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        for (int i = 0; i < N - 1; i++) {
            int count = 0;
            for (int j = i; j < N - 1; j++) {
                if (oil[i] <= oil[j]) {
                    sum += (long) distance[j] *oil[i];
                    count++;
                } else break;
            }

            i += count - 1;
        }

        System.out.println(sum);

    }
}

