package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1149 {
    static int Red = 0;
    static int Green = 1;
    static int Blue = 2;
    static int[][] cost;
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        cost = new int[N][3];
        DP = new int[N][3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            cost[i][Red] = Integer.parseInt(st.nextToken());
            cost[i][Green] = Integer.parseInt(st.nextToken());
            cost[i][Blue] = Integer.parseInt(st.nextToken());
        }

        DP[0][Red] = cost[0][Red];
        DP[0][Green] = cost[0][Green];
        DP[0][Blue] = cost[0][Blue];

        System.out.println(Math.min(paint(N - 1, Red), Math.min(paint(N - 1, Blue), paint(N - 1, Green))));

    }

    static int paint(int N, int color) {
        if (DP[N][color] == 0) {
            if (color == Red) {
                DP[N][Red] = Math.min(paint(N - 1, Green), paint(N - 1, Blue)) + cost[N][Red];
            }
            if (color == Green) {
                DP[N][Green] = Math.min(paint(N - 1, Red), paint(N - 1, Blue)) + cost[N][Green];
            }
            if (color == Blue) {
                DP[N][Blue] = Math.min(paint(N - 1, Green), paint(N - 1, Red)) + cost[N][Blue];
            }
        }

        return DP[N][color];
    }
}
