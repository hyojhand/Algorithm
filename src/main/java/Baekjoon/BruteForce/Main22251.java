package Baekjoon.BruteForce;

import java.io.*;
import java.util.*;

// G5 빌런 호석
// 변환하는 경우의 수를 배열로 만들어놓고, 숫자의 각 자리수를 배열로 만들어서 비교
public class Main22251 {

    // CHANGE_LIGHT[a][b] = a -> b 로 바꿀때 스위치 반전 개수
    private static final int[][] CHANGE_LIGHT = {
            {0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
            {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
            {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
            {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
            {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
            {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
            {2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
            {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
            {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
            {2, 4, 3, 1, 2, 1, 2, 3, 1, 0}};
    static int K, P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        // 지금 숫자를 각 자리수마다 배열로 변경
        int[] nowNumberDigits = numberOfDigits(X);

        // 결과 개수
        int answer = 0;

        // 1 ~ N까지 변경이 가능한지 확인
        for (int i = 1; i <= N; i++) {
            // 같은 숫자라면 생략
            if (i == X) {
                continue;
            }

            // 현재 숫자에서 변경이 가능하면 결과 ++
            if (isChange(i, nowNumberDigits)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean isChange(int goalNumber, int[] nowNumberDigits) {
        // 목표 숫자를 각 자리수마다 배열로 변경
        int[] goalNumberDigits = numberOfDigits(goalNumber);

        // 디스플레이를 반전하는 개수
        int reverseCount = 0;
        for (int i = 0; i < K; i++) {
            // 현재 숫자 Digits -> 목표 숫자 Digits 반전한 개수만큼 누적
            reverseCount += CHANGE_LIGHT[nowNumberDigits[i]][goalNumberDigits[i]];
            // 가능한 개수를 넘어가면 false
            if (reverseCount > P) {
                return false;
            }
        }

        return true;
    }

    // 숫자를 각 자리수의 배열로 변환
    private static int[] numberOfDigits(int number) {
        int[] digits = new int[K];
        for (int i = K - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }
}
