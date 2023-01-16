package Baekjoon.DP;

import java.io.*;
import java.util.StringTokenizer;

// G5 신을 모시는 사당
// Max( | 1의개수 - 2의개수 | ) == Max ( max(1개수 - 2개수), max(2개수 - 1개수))
// max(1개수 - 2개수) : 1은 1로 바꾸고, 2는 -1로 변경하여 "최대 연속 부분 수열 합"을 계산한다
// max(2개수 - 1개수) : 1은 -1로 바꾸고, 2는 1로 변경하여 "최대 연속 부분 수열 합"을 계산한다
// Kadane’s Algorithm (카데인 알고리즘) - 전체 배열에서 최대 부분합을 구하기
public class Main27210 {
    static int[] arr, arr2;
    static Integer[] dp, dp2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        dp = new Integer[N + 1];

        arr2 = new int[N + 1];
        dp2 = new Integer[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num == 1) {
                arr[i] = 1;
                arr2[i] = -1;
            }

            if (num == 2) {
                arr[i] = -1;
                arr2[i] = 1;
            }
        }

        dp[0] = 0;
        dp2[0] = 0;
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, Math.max(Math.abs(find(i, arr, dp)), Math.abs(find(i, arr2, dp2))));
        }

        System.out.println(answer);
    }

    static int find(int num, int[] arr, Integer[] dp) {
        if (dp[num] == null) {
            dp[num] = Math.max(arr[num], find(num - 1, arr, dp) + arr[num]);
        }
        return dp[num];
    }

}

// 다른풀이 - 왼쪽 오른쪽 최대값을 계속 갱신시키면서 최종 최대값을 구한다
//    int leftCount = 0;
//    int leftMax = 0;
//    int rightCount = 0;
//    int rightMax = 0;
//
//    StringTokenizer st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < N; i++) {
//        int num = Integer.parseInt(st.nextToken());
//
//        if(num == 1) {
//        if(rightCount > 0) rightCount--;
//        leftCount++;
//        leftMax = Math.max(leftMax, leftCount);
//        } else {
//        if(leftCount > 0) leftCount--;
//        rightCount++;
//        rightMax = Math.max(rightMax, rightCount);
//        }
//        }
//
//        System.out.println(Math.max(leftMax, rightMax));