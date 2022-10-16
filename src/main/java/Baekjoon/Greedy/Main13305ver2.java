package Baekjoon.Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Main13305ver2 {
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
        long min = oil[0];
        for(int i = 0; i < N-1; i++) {

            if(oil[i] < min) min = oil[i];

            sum += distance[i] * min;
        }

        System.out.println(sum);

    }
}

