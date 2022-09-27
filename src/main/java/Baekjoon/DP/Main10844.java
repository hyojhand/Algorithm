package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10844 {
    static Long[][] dp;
    static long MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new Long[N+1][10];

        for(int i = 0; i < 10; i++) {
            dp[1][i] = Long.valueOf(1);
        }

        long result = 0;

        for(int i = 1; i < 10; i++) {
            result += find(N, i);
        }
        System.out.println(result % MOD);

    }
    static long find (int digit, int val) {

        if(digit == 1) {
            return dp[1][val];
        }

        if(dp[digit][val] == null) {
            if(val == 0) {
                dp[digit][val] = find (digit-1, 1);
            }
            else if(val == 9) {
                dp[digit][val] = find (digit-1, 8);
            }
            else {
                dp[digit][val] = find (digit-1, val-1) + find(digit-1,val+1);
            }
        }

        return dp[digit][val] % MOD;
    }
}
