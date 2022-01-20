package Baekjoon.NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(lcm(x,y)).append('\n');
        }

        System.out.println(sb);

    }
    static int gcd (int x, int y) {
        int tmp;
        if(y > x) {
            tmp = x;
            x = y;
            y = tmp;
        }

        if(x % y == 0) {
            return y;
        }
        else {
            return gcd(y, x%y);
        }
    }
    static int lcm (int x, int y) {
        return x*y/gcd(x,y);
    }
}
