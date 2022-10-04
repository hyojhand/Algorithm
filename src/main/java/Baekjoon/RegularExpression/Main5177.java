package Baekjoon.RegularExpression;

import java.io.*;
// 출력형식이 잘못되었습니다 S2
public class Main5177 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < K; i++) {
            String s1 = br.readLine().trim().toLowerCase();
            String s2 = br.readLine().trim().toLowerCase();

            s1 = s1.replaceAll("[\\[\\{]","(").replaceAll("[\\]\\}]", ")");
            s2 = s2.replaceAll("[\\[\\{]","(").replaceAll("[\\]\\}]", ")");

            s1 = s1.replaceAll(",",";");
            s2 = s2.replaceAll(",",";");

            s1 = s1.replaceAll("\\s*(\\(|\\)|\\[|\\]|\\{|\\}|\\.|\\,|\\;|\\:)\\s*", "");
            s2 = s2.replaceAll("\\s*(\\(|\\)|\\[|\\]|\\{|\\}|\\.|\\,|\\;|\\:)\\s*", "");

            s1 = s1.replaceAll("\\s+", "\\s");
            s2 = s2.replaceAll("\\s+", "\\s");

            sb.append("Data Set ").append(i+1).append(": ");
            if(s1.equals(s2)) sb.append("equal");
            else sb.append("not equal");
            sb.append('\n').append('\n');
        }

        System.out.println(sb);
    }
}
