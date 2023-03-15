package Baekjoon.DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
// G4 뮤탈리스크 - 모든 데미지를 맞는 경우를 dp로 저장해놓고 방문했던 체력이라면 dp값 사용
public class Main12869 {

    static int[][][] dp;
    static int[][] damage = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 3, 9}, {1, 9, 3}};
    private static final int MAX_ATTACK = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] scv = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scv[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[61][61][61];

        for (int i = 0; i <= 60; i++) {
            for (int j = 0; j <= 60; j++) {
                Arrays.fill(dp[i][j], MAX_ATTACK);
            }
        }

        dp[0][0][0] = 0;

        System.out.println(dfs(scv));
    }

    static int dfs(int[] scv) {
        int a = scv[0];
        int b = scv[1];
        int c = scv[2];

        if (dp[a][b][c] == MAX_ATTACK) {

            for (int i = 0; i < 6; i++) {
                int nextA = Math.max(scv[0] - damage[i][0], 0);
                int nextB = Math.max(scv[1] - damage[i][1], 0);
                int nextC = Math.max(scv[2] - damage[i][2], 0);

                dp[a][b][c] = Math.min(dp[a][b][c], dfs(new int[]{nextA, nextB, nextC}) + 1);
            }
        }

        return dp[a][b][c];
    }
}
