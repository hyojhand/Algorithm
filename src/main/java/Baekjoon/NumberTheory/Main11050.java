package Baekjoon.NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(find(N,K));

    }

    public static int find(int N, int K) {
        if(K == 0 | K == N) {
            return 1;
        }

        return find(N-1,K-1) + find(N-1, K);
    }
}
