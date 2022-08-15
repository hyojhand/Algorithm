package SWEA.IM;

import java.io.*;

public class Solution2007 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        while (tc < T) {
            String str = br.readLine();
            int result = 0;

            Loop:
            for (int i = 1; i < str.length(); i++) {
                String tmp = str.substring(0, i);
                boolean isSame = true;
                for (int j = 0; j < str.length() - tmp.length(); j += tmp.length()) {
                    if (!tmp.equals(str.substring(j, j + tmp.length()))) {
                        isSame = false;
                        break;
                    }
                }

                if (isSame) {
                    result = tmp.length();
                    break Loop;
                }
            }

            tc++;
            sb.append("#").append(tc).append(" ").append(result).append('\n');
        }

        System.out.println(sb);
    }
}
