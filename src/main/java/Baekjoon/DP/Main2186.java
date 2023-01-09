package Baekjoon.DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
// G3 문자판 - dfs + dp문제, 각 좌표에서 출발하여 몇번째 인덱스부터 끝까지 단어를 채우는 경우의 수를 dp로 저장하고 사용
//  dp[x][y][dept] : x,y 좌표에서 시작해서 단어의 dept 인덱스부터 끝까지 채우는 경우의 수
// 전체 dp를 -1로 초기화하고 방문했을경우 0으로 만들어줘야 0인경우 계속 탐색을 하지 않는다.
public class Main2186 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M, K;
    static char[][] board;
    static int[][][] dp;
    static String word;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        word = br.readLine();
        dp = new int[N][M][word.length()];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == word.charAt(0)) {
                    answer += dfs(i, j, 0);
                }
            }
        }

        System.out.println(answer);
    }

    static int dfs(int x, int y, int dept) {
        if (dept == word.length() - 1) {
            dp[x][y][dept] = 1;
            return dp[x][y][dept];
        }

        if (dp[x][y][dept] != -1) {
            return dp[x][y][dept];
        }

        dp[x][y][dept] = 0;

        for (int k = 1; k <= K; k++) {
            for (int t = 0; t < 4; t++) {
                int nx = x + dx[t] * k;
                int ny = y + dy[t] * k;

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && word.charAt(dept + 1) == board[nx][ny]) {
                    dp[x][y][dept] += dfs(nx, ny, dept + 1);
                }

            }
        }

        return dp[x][y][dept];
    }
}
