package Baekjoon.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int count;

        int testcase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcase; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int distance = (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

            if (x1 == x2 && y1 == y2 && r1 == r2) {
                count = -1;
            } else if (distance == Math.pow(r2 - r1, 2)) {
                count = 1;
            } else if (distance == Math.pow(r2 + r1, 2)) {
                count = 1;
            } else if (distance < Math.pow(r2 - r1, 2)) {
                count = 0;
            } else if (distance > Math.pow(r2 + r1, 2)) {
                count = 0;
            } else
                count = 2;

            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
