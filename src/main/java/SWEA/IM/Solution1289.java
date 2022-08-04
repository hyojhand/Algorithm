package SWEA.IM;

import java.io.*;

public class Solution1289 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        while (tc < T) {
            String str = br.readLine();
            boolean isZero = true;
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (isZero) {
                    if (str.charAt(i) - '0' != 0) {
                        isZero = false;
                        count++;
                    }
                } else {
                    if (str.charAt(i) - '0' != 1) {
                        isZero = true;
                        count++;
                    }
                }
            }

            tc++;
            sb.append("#").append(tc).append(" ").append(count).append('\n');
        }

        System.out.println(sb);

    }
}
