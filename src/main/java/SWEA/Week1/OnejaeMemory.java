package SWEA.Week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OnejaeMemory {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());
        int testcount = 1;

        for (int i = 0; i < testcase; i++) {
            String str = br.readLine();
            char[] memory = new char[str.length()];
            for (int j = 0; j < str.length(); j++) {
                memory[j] = str.charAt(j);
            }

            boolean isZero = true;
            int count = 0;

            for (int j = 0; j < str.length(); j++) {
                if (isZero) {
                    if (memory[j] == '1') {
                        isZero = false;
                        count++;
                    }
                } else {
                    if (memory[j] == '0') {
                        isZero = true;
                        count++;
                    }
                }
            }

            sb.append("#" + testcount + " ").append(count).append('\n');
            testcount++;
        }

        System.out.println(sb);


    }
}
