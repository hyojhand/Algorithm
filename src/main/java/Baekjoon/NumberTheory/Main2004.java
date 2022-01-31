package Baekjoon.NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long count5 = five_num(N) - five_num(N-M) - five_num(M);
        long count2 = two_num(N) - two_num(N-M) - two_num(M);

        System.out.println(Math.min(count2,count5));

    }

    public static long five_num(int num) {
        int count = 0;

        while(num >= 5) {
            count += num /5;
            num /= 5;
        }
        return count;
    }

    public static long two_num(int num) {
        int count = 0;

        while(num >= 2) {
            count += num /2;
            num /= 2;
        }
        return count;
    }

}
