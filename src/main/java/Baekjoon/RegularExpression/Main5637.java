package Baekjoon.RegularExpression;

import java.io.*;

// 가장 긴 단어 S4
public class Main5637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        String result = "";
        Loop: while(true) {
            String text = br.readLine();
            String[] str = text.toLowerCase().split("[^a-z-]");

            for (String s : str) {
                if(max < s.length()) {
                    result = s;
                    max = s.length();
                }

                if(s.equals("e-n-d")) break Loop;
            }
        }

        System.out.println(result);
    }
}
