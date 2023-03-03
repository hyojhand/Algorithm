package Baekjoon.DP;

import java.io.*;

// G4 타일채우기
// 짝수 단계로 타일이 채워질 수 있으므로 추가되는 2 X 3의 타일을 고려한다
// dp[i] = dp[i-2] * dp[2] + 2(가운데에 dp[i-2]가 있을경우, 예외상황)
// 예외 상황의 좌,우측을 고려해야하므로 dp[2] * 2 + dp[4] * 2 ... 를 더해주어야 한다
public class Main2133 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[31];
        dp[2] = 3;
        for (int i = 4; i <= N; i += 2) {
            dp[i] = dp[i - 2] * dp[2] + 2;
            for (int k = 2; k < i - 2; k += 2) {
                dp[i] += (dp[k] * 2);
            }
        }

        System.out.println(dp[N]);
    }
}

