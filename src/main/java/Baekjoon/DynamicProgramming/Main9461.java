package Baekjoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9461 {
    static long[] memo = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        memo[1] = (long) 1;
        memo[2] = (long) 1;
        memo[3] = (long) 1;

        for (int i = 0; i < count; i++) {
            sb.append(P(Integer.parseInt(br.readLine()))).append('\n');
        }
        System.out.println(sb);

    }

    static long P(int num) {
        if (memo[num] != 0) {
            return memo[num];
        }

        memo[num] = P(num - 2) + P(num - 3);
        return memo[num];
    }
}
