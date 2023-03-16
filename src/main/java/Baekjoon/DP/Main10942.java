package Baekjoon.DP;

import java.io.*;
import java.util.StringTokenizer;

// G4 팰린드롬
// 양쪽끝 확인 -> 재귀호출 해서 결과같을 DP로 저장
public class Main10942 {
    static int[] numbers;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        numbers = new int[N + 1];

        // 숫자 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // a ~ b 까지의 팰린드롬 결과 dp
        dp = new Integer[N + 1][N + 1];
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(find(a, b)).append('\n');
        }
        System.out.println(sb);
    }

    static int find(int a, int b) {
        // 두개가 같은 수면 무조건 팰린드롬
        if (a == b) {
            dp[a][b] = 1;
        }

        // 붙어있는 수이고, 같은 수면 팰린드롬
        if (a + 1 == b && b - 1 == a) {
            if (numbers[a] == numbers[b]) {
                dp[a][b] = 1;
            } else {
                dp[a][b] = 0;
            }
        }

        // 양쪽 끝이 같고, 하나씩 좁혀졌을 때 재귀호출도 팰린드롬이면, 팰린드롬
        if (dp[a][b] == null) {
            if (numbers[a] == numbers[b] && find(a + 1, b - 1) == 1) {
                dp[a][b] = 1;
            } else {
                dp[a][b] = 0;
            }
        }

        return dp[a][b];
    }
}

