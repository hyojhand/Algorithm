package Baekjoon.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2581 {
    public static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        check = new boolean[N + 1];
        prime();

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = M; i <= N; i++) {
            if (check[i] == false) {
                sum += i;
                if (min == Integer.MAX_VALUE) {
                    min = i;
                }
            }
        }
        if (sum == 0)
            System.out.print(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }

    public static void prime() {
        check[0] = check[1] = true;

        for (int i = 2; i < Math.sqrt(check.length); i++) {
            if (check[i] == true)
                continue;
            for (int j = i * i; j < check.length; j = j + i) {
                check[j] = true;
            }
        }
    }
}
