package Baekjoon.NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (testcase > 0) {
            int num = Integer.parseInt(br.readLine());

            Map<String, Integer> hm = new HashMap<>();

            for (int i = 0; i < num; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String kind = st.nextToken();

                if (hm.containsKey(kind)) {
                    hm.put(kind, hm.get(kind) + 1);
                } else {
                    hm.put(kind, 1);
                }
            }

            int result = 1;

            for (int val : hm.values()) {
                result *= (val + 1);
            }

            sb.append(result - 1).append('\n');

            testcase--;
        }

        System.out.println(sb);

    }
}
