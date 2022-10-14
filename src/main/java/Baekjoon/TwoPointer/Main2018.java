package Baekjoon.TwoPointer;

import java.io.*;
// 수 들의 합 5 S4 / 투포인터
public class Main2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        long sum = 1;
        int count = 0;

        int start = 1;
        int end = 1;

        while(start <= end) {
            if(sum == S) count++;
            if(sum < S) {
                end++;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }

        System.out.println(count);

    }
}
