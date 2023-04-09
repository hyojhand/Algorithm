package Baekjoon.SlidingWindow;

import java.io.*;
// S1 문자열 교환
public class Main1522 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String value = br.readLine();
        int len = value.length(); // 문자열의 총 길이

        int aCount = 0;
        for (int i = 0; i < len; i++) {
            if (value.charAt(i) == 'a') {
                aCount++; // a의 총 개수를 구한다
            }
        }

        int answer = Integer.MAX_VALUE; // 최소값 answer

        // a개수 크기만큼 확인하면서 b의 개수 최소값을 구한다
        for (int i = 0; i < len; i++) {

            int bCount = 0; // b의 개수
            for (int j = 0; j < aCount; j++) {
                int idx = i + j;

                if (idx >= len) {
                    idx -= len;
                }

                if (value.charAt(idx) == 'b') {
                    bCount++;
                }
            }

            answer = Math.min(answer, bCount);
        }

        System.out.println(answer);
    }
}

