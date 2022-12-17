package Baekjoon.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int x;
        int y;
        int count;
        int distance;
        int max;

        for (int i = 0; i < testcase; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            distance = y - x;
            max = (int) Math.sqrt(distance);

            if (max == Math.sqrt(distance)) {
                count = max * 2 - 1;
            } else if (distance <= max * max + max) {
                count = max * 2;
            }
            else {
                count = max * 2 + 1;
            }

            sb.append(count).append('\n');
        }

        System.out.println(sb);
    }
}
