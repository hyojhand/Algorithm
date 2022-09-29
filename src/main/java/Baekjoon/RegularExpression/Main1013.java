package Baekjoon.RegularExpression;

import java.io.*;
import java.util.regex.Pattern;
// Contact S1
public class Main1013 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("(100+1+|01)+");

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            boolean matches = pattern.matcher(str).matches();

            if(matches) sb.append("YES");
            else sb.append("NO");

            sb.append('\n');
        }
        System.out.println(sb);
    }
}
