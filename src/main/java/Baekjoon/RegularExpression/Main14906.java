package Baekjoon.RegularExpression;

import java.io.*;
import java.util.regex.Pattern;
// 스러피 G4
public class Main14906 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("SLURPYS OUTPUT").append('\n');

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int lastIndex = str.lastIndexOf('C');

            if (lastIndex == -1) {
                if (str.startsWith("AH") && isSlump(str.substring(2))) sb.append("YES");
                else sb.append("NO");
            } else {
                String sub = str.substring(0, lastIndex + 1);
                if (isSlimp(sub)) {
                    if (isSlump(str.substring(lastIndex + 1))) sb.append("YES");
                    else sb.append("NO");
                } else {
                    sb.append("NO");
                }
            }

            sb.append('\n');
        }

        sb.append("END OF OUTPUT");
        System.out.println(sb);
    }

    static boolean isSlump(String str) {
        Pattern slump = Pattern.compile("^(([DE])F+)+G$");
        return slump.matcher(str).matches();
    }

    static boolean isSlimp(String str) {
        if(str.length() < 2) return false;

        if(str.equals("AH")) return true;

        String sub = str.substring(1,str.length()-1);
        if(sub.startsWith("B")) {
            return isSlimp(sub.substring(1));
        } else return isSlump(sub);
    }
}
