package Baekjoon.Xmas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10708 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 친구수
        int M = Integer.parseInt(br.readLine()); // 게임횟수
        int[] target = new int[M];
        int[] friend = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == target[i]) {
                    friend[j]++;
                    count++;
                }
            }
            friend[target[i] - 1] += (N - count);
        }

        for (int i = 0; i < N; i++) {
            System.out.println(friend[i]);
        }

    }
}


