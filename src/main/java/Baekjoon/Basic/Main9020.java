package Baekjoon.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9020 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] check = new boolean[10001];

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        prime();

        int testcase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcase; i++) {
            int num = Integer.parseInt(br.readLine());
            int first = num / 2;
            int second = num / 2;

            while (true) {
                if (!check[first] && !check[second]) {
                    sb.append(first).append(" ").append(second).append("\n");
                    break;
                }
                first--;
                second++;
            }
        }
        System.out.print(sb);
    }

    public static void prime() {
        check[0] = check[1] = true;

        for (int i = 2; i < Math.sqrt(check.length); i++) {
            if (check[i] == true)
                continue;
            for (int j = i * i; j < check.length; j += i) {
                check[j] = true;
            }
        }
    }
}
