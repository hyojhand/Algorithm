package Baekjoon.PrefixSum;

import java.io.*;
import java.util.StringTokenizer;
// G5 꿀따기 - 3가지 경우의 수로 나누어서 최대값을 계산
// 1. 벌1 왼쪽, 꿀통 오른쪽 고정 / 2. 벌1 오른쪽, 꿀통 왼쪽 고정 / 3. 벌1 왼쪽, 벌2 오른쪽 고정
public class Main21758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] sum = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            sum[i] = sum[i - 1] + num;
        }

        int answer = 0;

        // 1. 왼쪽 끝 벌1, 오른쪽 끝 꿀통 고정 / 벌2 위치 선택
        int bee1 = sum[N] - arr[1];
        for (int i = 2; i < N; i++) {
            int bee2 = sum[N] - sum[i];
            answer = Math.max(answer, bee1 + bee2 - arr[i]);
        }

        // 2. 왼쪽 끝 꿀통, 오른쪽 끝 벌1 고정 / 벌2 위치 선택
        bee1 = sum[N] - arr[N];
        for (int i = 2; i < N; i++) {
            int bee2 = sum[i - 1];
            answer = Math.max(answer, bee1 + bee2 - arr[i]);
        }

        // 3. 왼쪽 끝 벌1, 오른쪽 끝 벌2 고정 / 꿀통 위치 선택
        for (int i = 2; i <= N - 1; i++) {
            int sideBee = arr[1] + arr[N];
            answer = Math.max(answer, sum[i] + sum[N] - sideBee - sum[i - 1]);
        }

        System.out.println(answer);
    }
}

