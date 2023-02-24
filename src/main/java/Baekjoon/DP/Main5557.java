package Baekjoon.DP;

import java.io.*;
import java.util.*;
// G5 1학년
// dp[sum][index] : 중간합이 가능한 0~20과 해당 인덱스를 가지는 dp 배열 (0 <= sum <= 20)
// 다음 값과 더했을때의 dp값과 뺐을때의 dp값을 더해서 계산
// 마지막 숫자 이전까지 비교했다면, 해당 값과 마지막 값을 비교하여 같으면 1, 다르면 0 반환
public class Main5557 {
    static int N;
    static int[] score;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        score = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        // 중간합이 0에서 20까지의 숫자만 가지는 N개의 dp 배열
        dp = new long[21][N];
        // dp 배열 -1로 초기화
        for (int i = 0; i < 21; i++) {
            Arrays.fill(dp[i], -1);
        }

        long answer = find(score[0], 0);
        System.out.println(answer);
    }

    private static long find(int sum, int index) {
        // 0 ~ 20이 아닌 중간합은 0 리턴
        if (sum < 0 || sum > 20) {
            return 0;
        }

        // N-2 까지 계산했다면, N-1과 등호("=")로 비교, 맞다면 갯수 1개 반환
        if (index == N - 2) {
            return sum == score[N - 1] ? 1 : 0;
        }

        // 처음 방문한다면
        if (dp[sum][index] == -1) {
            dp[sum][index] = 0;
            // "+" 했을때의 수와 "-" 했을때의 수를 더한다
            dp[sum][index] += find(sum + score[index + 1], index + 1) + find(sum - score[index + 1], index + 1);
        }

        return dp[sum][index];
    }
}

