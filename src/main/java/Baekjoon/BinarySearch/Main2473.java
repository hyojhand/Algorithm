package Baekjoon.BinarySearch;

import java.io.*;
import java.util.*;
// G3 세용액 - N개의 용액에서 하나의 용액을 무조건 선택하고,
// 나머지 2개의 용액을 이분탐색해가면서 절대값 sum 의 최소값을 탐색한다.
// 범위도 하나씩 줄여나가야 최소값을 찾을 수 있다.
public class Main2473 {
    static long[] pick;
    static long answer = 3000000000L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] liquid = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            liquid[i] = num;
        }

        Arrays.sort(liquid);

        pick = new long[3];
        for(int i = 0; i < N - 2; i++) {
            search(liquid,i);
        }

        Arrays.sort(pick);

        for(int i = 0; i < 3; i++) {
            System.out.print(pick[i] + " ");
        }
    }

    private static void search(long[] liquid, int index) {
        int start = index + 1;
        int end = liquid.length - 1;

        while(start < end) {
            long sum = liquid[start] + liquid[end] + liquid[index];
            long absSum = Math.abs(sum);

            if(answer > absSum) {
                pick[0] = liquid[start];
                pick[1] = liquid[end];
                pick[2] = liquid[index];
                answer = absSum;
            }

            if(sum > 0) {
                end--;
            } else {
                start++;
            }
        }
    }
}

