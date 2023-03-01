package Baekjoon.DP;

import java.io.*;
// S1 1,2,3 더하기 4
// 1,2,3을 더할 수 있으므로 끝자리가 1,2,3 인 2차원 배열을 생각하는게 포인트!
// 오름차순으로 수식을 정렬하여 중복을 제거
public class Main15989 {
    // dp[N][K] : 숫자 N을 구하는 식 중에 마지막 숫자가 K인 갯수
    static int[][] dp = new int[10001][4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        dp[1][1] = 1; // 1

        dp[2][1] = 1; // 1 + 1
        dp[2][2] = 1; // 2

        dp[3][1] = 1; // 1 + 1 + 1
        dp[3][2] = 1; // 1 + 2
        dp[3][3] = 1; // 3

        for (int i = 0; i < T; i++) {
            int number = Integer.parseInt(br.readLine());

            // 숫자 N의 경우의 수는 dp[N][1] + dp[N][2] + dp[N][3] 이다.
            int answer = find(number, 1) + find(number, 2) + find(number, 3);
            sb.append(answer).append('\n');
        }

        System.out.println(sb);
    }

    // 오름차순으로 수식을 정렬해서 중복되는 경우를 제거한다.
    // dp[N][1] = dp[N-1][1];
    // dp[N][2] = dp[N-2][1] + dp[N-2][2];
    // dp[N][3] = dp[N-3][1] + dp[N-3][2] + dp[N-3][3];
    private static int find(int number, int lastNumber) {
        if (number <= 0) return 0;

        if (dp[number][lastNumber] == 0) {
            int answer = 0;

            for (int i = 1; i <= lastNumber; i++) {
                answer += find(number - lastNumber, i);
            }

            dp[number][lastNumber] = answer;
        }

        return dp[number][lastNumber];
    }
}

