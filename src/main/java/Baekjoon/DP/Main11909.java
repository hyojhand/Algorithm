package Baekjoon.DP;

import java.io.*;
import java.util.*;
// G5 배열탈출
public class Main11909 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        int[][] dp = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i == N-1 && j == N-1) break;

                if(i != N-1) {
                    if(arr[i+1][j] >= arr[i][j]) {
                        int dif = arr[i+1][j] - arr[i][j] + 1;
                        dp[i+1][j] = Math.min(dp[i+1][j], dif + dp[i][j]);
                    } else {
                        dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]);
                    }
                }

                if(j != N-1) {
                    if(arr[i][j+1] >= arr[i][j]) {
                        int dif = arr[i][j+1] - arr[i][j] + 1;
                        dp[i][j+1] = Math.min(dp[i][j+1], dif + dp[i][j]);
                    } else {
                        dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]);
                    }
                }
            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}

