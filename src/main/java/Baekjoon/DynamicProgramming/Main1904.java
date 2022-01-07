package Baekjoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1904 {
    static int[] memo = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;

        System.out.println(tile(num));

    }

    public static int tile(int num) {
        if (memo[num] != 0) {
            return memo[num];
        }

        memo[num] = (tile(num - 1) + tile(num - 2)) % 15746;
        return memo[num];

    }
}
