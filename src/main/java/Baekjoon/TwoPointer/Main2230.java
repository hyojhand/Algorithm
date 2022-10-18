package Baekjoon.TwoPointer;

import java.io.*;
import java.util.*;
// 수 고르기 G5
public class Main2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;

        while (end < N) {
            if (arr[end]-arr[start] < M) {
                end++;
                continue;
            }

            if(arr[end] - arr[start] == M) {
                min = M;
                break;
            }

            min = Math.min(min, arr[end] - arr[start]);
            start++;
        }

        System.out.println(min);
    }
}
