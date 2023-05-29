package Baekjoon.DP.Palindrome;

import java.io.*;
import java.util.*;

// G4 팰린드롬 만들기
// 시작과 끝 인덱스를 하나씩 당겨가며 최소 개수를 구한다.
// 만약 둘이 같다면 양쪽을 동시에 당기고, 시작과 끝이 같으면 팰린드롬이므로 0을 반환, 시작이 끝을 넘어가면 안되니 0을 반환한다.
// 둘이 다르다면 왼쪽에 추가해 오른쪽을 당기는 dp와 오른쪽을 추가해 왼쪽을 당기는 dp의 최소값을 구하고 1을 더해준다.
public class Main1695 {
    static int[][] dp;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        numbers = new int[N + 1];
        dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int answer = findPalindrome(1, N);
        System.out.println(answer);
    }

    private static int findPalindrome(int start, int end) {
        if (start >= end) {
            return 0;
        }

        if (dp[start][end] == -1) {
            // 양쪽이 같다면, 양끝을 가운데로 한칸신 감소
            if (numbers[start] == numbers[end]) {
                dp[start][end] = findPalindrome(start + 1, end - 1);

            } else {
                // 다르면, 왼쪽에 삽입하는 경우와 오른쪽에 삽입하는 경우의 최소값을 구한다.
                dp[start][end] = Math.min(findPalindrome(start + 1, end), findPalindrome(start, end - 1)) + 1;
            }
        }

        return dp[start][end];
    }
}

