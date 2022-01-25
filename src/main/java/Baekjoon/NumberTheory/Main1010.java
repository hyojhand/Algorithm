package Baekjoon.NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1010 {
    static int[][] dp = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());
        while(testcase > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(find(M,N)).append('\n');

            testcase--;
        }
        System.out.println(sb);

    }
    public static int find(int x, int y) {
        if (dp[x][y] > 0) {
            return dp[x][y];
        }

        if(x == y || y == 0) {
            return dp[x][y] = 1;
        }

        dp[x][y] = find(x-1, y-1) + find(x-1,y);
        return dp[x][y];

    }
}
