package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1003 {
    static Integer[][] fibodata = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());

        fibodata[0][0] = 1;
        fibodata[0][1] = 0;
        fibodata[1][0] = 0;
        fibodata[1][1] = 1;

        for (int i = 0; i < testcase; i++) {
            int N = Integer.parseInt(br.readLine());
            fibo(N);
            sb.append(fibodata[N][0] + " " + fibodata[N][1]);
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static Integer[] fibo(int n) {

        if (fibodata[n][0] == null || fibodata[n][1] == null) {
            fibodata[n][0] = fibo(n - 1)[0] + fibo(n - 2)[0];
            fibodata[n][1] = fibo(n - 1)[1] + fibo(n - 2)[1];
        }

        return fibodata[n];
    }
}
