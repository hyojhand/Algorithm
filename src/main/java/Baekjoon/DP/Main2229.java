package Baekjoon.DP;

import java.io.*;
import java.util.*;

// G5 조 짜기
// dp[A] = A까지의 최대 결과값
// 마지막에서 현재 index만 가지는 조부터 시작해 하나씩 앞의 인덱스를 포함해 ((최대-최소) + 직전의 최대값)을 계산하며 최대값을 구한다.
// 현재 index 하나만 조로 포함되므로 최대-최소는 0이고, 직전(index - 1)까지의 최대값을 더한 값과, dp값중에 최대를 구한다.
// 다시 앞의 index 하나를 포함해 조를 만들어 최대-최소를 구하고, 하나를 제외한 앞의 인덱스까지 최대값을 더한 결과와 dp값의 최대를 갱신한다.
public class Main2229 {
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1];
        Arrays.fill(dp, -1);
        // 첫번째 원소 혼자는 0
        dp[0] = 0;
        dp[1] = 0;

        System.out.println(find(N));
    }

    private static int find(int index) {
        if (dp[index] == -1) {

            // 마지막에서 현재 index만 가지는 조부터 시작해 하나씩 앞의 인덱스를 포함해 ((최대-최소) + 직전의 최대값)을 계산하며 최대값을 구한다.
            // 현재 index 하나만 조로 포함되므로 최대-최소는 0이고, 직전(index - 1)까지의 최대값을 더한 값과, dp값중에 최대를 구한다.
            // 다시 앞의 index 하나를 포함해 조를 만들어 최대-최소를 구하고, 하나를 제외한 앞의 인덱스까지 최대값을 더한 결과와 dp값의 최대를 갱신한다.
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = index; i > 0; i--) {
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i]);
                dp[index] = Math.max(max - min + find(i - 1), dp[index]);
            }
        }

        return dp[index];
    }
}

