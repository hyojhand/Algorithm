package Baekjoon.Xmas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main14235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int visit = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        ArrayList<Integer> list = new ArrayList<>();

        while (visit > 0) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if (num == 0) {
                if (list.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(list.get(0)).append('\n');
                    list.remove(0);
                }
            } else {
                for (int j = 0; j < num; j++) {
                    list.add(Integer.parseInt(st.nextToken()));
                }
                Collections.sort(list, Collections.reverseOrder());
            }

            visit--;
        }

        System.out.println(sb);
    }
}
