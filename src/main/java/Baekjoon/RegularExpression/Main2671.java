package Baekjoon.RegularExpression;

import java.io.*;
import java.util.regex.Pattern;

// 잠수함식별 S1
public class Main2671 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("(100+1+|01)+");

        String str = br.readLine();
        boolean matches = pattern.matcher(str).matches();
        if(matches) System.out.println("SUBMARINE");
        else System.out.println("NOISE");
    }
}
