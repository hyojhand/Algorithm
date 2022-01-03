package Baekjoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] counting = new int[8001];

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            sum += value;
            counting[value + 4000]++;

            if (max < value) {
                max = value;
            }
            if (min > value) {
                min = value;
            }
        }

        double avg = (double) sum / N;
        sb.append((int) Math.round(avg)).append('\n');

        int count = 0;
        int maxcount = 0;
        boolean flag = false;

        int mid = 10000;
        int most = 10000;

        for (int i = min + 4000; i <= max + 4000; i++) {
            if (counting[i] > 0) {
                if (count < (N + 1) / 2) {
                    count += counting[i];
                    mid = i - 4000;
                }

                if (maxcount < counting[i]) {
                    maxcount = counting[i];
                    most = i - 4000;
                    flag = true;
                } else if (maxcount == counting[i] && flag == true) {
                    most = i - 4000;
                    flag = false;
                }
            }
        }

        sb.append(mid).append('\n');
        sb.append(most).append('\n');
        sb.append(max - min).append('\n');

        System.out.print(sb);
    }
}