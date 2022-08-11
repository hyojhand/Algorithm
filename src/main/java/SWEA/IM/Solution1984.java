package SWEA.IM;

import java.io.*;
import java.util.StringTokenizer;

public class Solution1984 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        while (tc < T) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            double sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++) {
                int num = Integer.parseInt(st.nextToken());
                sum += num;
                max = Math.max(max, num);
                min = Math.min(min, num);
            }
            int result = (int) Math.round((sum - max - min) / 8);

            tc++;
            sb.append("#").append(tc).append(" ").append(result).append('\n');
        }

        System.out.println(sb);
    }
}

