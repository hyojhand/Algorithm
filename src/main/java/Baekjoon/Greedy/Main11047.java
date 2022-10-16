package Baekjoon.Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Main11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i = N-1; i >= 0; i--) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for(int i = 0; i < N; i++) {
            if(K >= arr[i]) {
                count += K /arr[i];
                K = K % arr[i];
            }

            if(K == 0) break;
        }

        System.out.println(count);

    }
}

