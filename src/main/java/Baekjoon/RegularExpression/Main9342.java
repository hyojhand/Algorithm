package Baekjoon.RegularExpression;

import java.io.*;
import java.util.regex.Pattern;
// 염색체 S3
public class Main9342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("^[ABCDEF]?A+F+C+[ABCDEF]?$");

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            boolean matches = pattern.matcher(str).matches();
            if(matches) sb.append("Infected!");
            else sb.append("Good");

            sb.append('\n');
        }
        System.out.println(sb);
    }
}
