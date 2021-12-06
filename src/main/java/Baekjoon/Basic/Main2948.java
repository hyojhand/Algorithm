package Baekjoon.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2948 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] check = new boolean[246913];

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        prime();
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0)
                break;

            int count = 0;
            for (int i = num + 1; i <= 2 * num; i++) {
                if (check[i] == false) {
                    count++;
                }
            }
            sb.append(count).append('\n');
        }
        System.out.print(sb);

    }

    public static void prime() {
        check[0] = check[1] = true;
        for (int i = 2; i < Math.sqrt(check.length); i++) {
            if (check[i] == true) {
                continue;
            }
            for (int j = i * i; j < check.length; j = j + i) {
                check[j] = true;
            }
        }

    }
}
