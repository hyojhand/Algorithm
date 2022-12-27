package Baekjoon.DP.LIS;

import java.io.*;
import java.util.StringTokenizer;
// G4 가장 긴 바이토닉 부분 수열 - 증가 후 감소의 가장 긴 부분수열을 구한다.
// 증가 부분수열과 감소 부분수열을 각자 구한다음 더해주고, 중복되는 각 수를 -1 해준다.
public class Main11054 {
    static int[] arr,lis_dp,lds_dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis_dp = new int[N];
        lds_dp = new int[N];

        for(int i = 0; i < N; i++) {
            LIS(i);
            LDS(i);
        }

        int max = 0;
        for(int i = 0; i < N; i++) {
            max = Math.max(lis_dp[i] + lds_dp[i] - 1, max);
        }
        System.out.println(max);
    }

    public static int LIS (int num) {
        if(lis_dp[num] == 0) {
            lis_dp[num] = 1;

            for (int i = 0; i < num; i++) {
                if (arr[i] < arr[num]) lis_dp[num] = Math.max(lis_dp[num], LIS(i) + 1);
            }
        }
        return lis_dp[num];
    }

    public static int LDS (int num) {
        if(lds_dp[num] == 0) {
            lds_dp[num] = 1;

            for (int i = num; i < N; i++) {
                if(arr[i] < arr[num]) lds_dp[num] = Math.max(lds_dp[num], LDS(i) + 1);
            }
        }
        return lds_dp[num];
    }
}
