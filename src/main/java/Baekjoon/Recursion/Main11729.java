package Baekjoon.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// S1 하노이 탑 이동순서
public class Main11729 {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());


        sb.append((int) (Math.pow(2, num) - 1)).append('\n');

        Hanoi(num, 1, 2, 3);

        System.out.println(sb);

    }

    public static void Hanoi(int N, int start, int mid, int to) {
        if (N == 1) {
            sb.append(start + " " + to + "\n");
            return;
        }
        // N-1 개를 A에서 B로 이동
        Hanoi(N - 1, start, to, mid);

        // 1개를 A에서 C로 이동
        sb.append(start + " " + to + "\n");

        // N-1개를 B에서 C로 이동
        Hanoi(N - 1, mid, start, to);
    }
}