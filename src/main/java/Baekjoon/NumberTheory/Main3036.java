package Baekjoon.NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        // while(st.hasMoreTokens()) {
        while(N-1 > 0) {
            int a = R;
            int b = Integer.parseInt(st.nextToken());

            int num = gcd(a,b);
            sb.append(a/num).append("/").append(b/num).append('\n');
            N--;
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
}
